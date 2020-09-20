package com.ujiuye.service.impl;

import com.ujiuye.dao.MovieMapper;
import com.ujiuye.dao.RecommendTypeMapper;
import com.ujiuye.daomain.*;
import com.ujiuye.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MovieServiceImpl implements IMovieService {
    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private RecommendTypeMapper recommendTypeMapper;

    @Override
    public List<Movie> findAll() {
        return movieMapper.findAll();
    }

    @Override
    public void save(Movie movie) {
        // 1.向movie表中插入一条记录
        movieMapper.save(movie);
        int mid =  movie.getId();
        System.out.println("id==" + mid);
        System.out.println(movie.getMovietypes());
        // 2.向电影和类型的中间表中插入记录:
        String  categories = movie.getMovietypes();
        String[] cateArray = categories.split(",");
        for (String cid : cateArray) {
            MovieAndType mac = new MovieAndType(mid,Integer.parseInt(cid));
            movieMapper.insertMovieAndCategory(mac);
        }
    }

    @Override
    public Movie findById(int movieId) {
        return movieMapper.findById(movieId);
    }

    @Override
    public void deleteMovie(int movieId) {
        // 1.电影与类型的中间表的记录
        movieMapper.deleteMovieAndcategories(movieId);
        // 2.电影与演员的中间表的记录
        movieMapper.deleteMovieAndActors(movieId);
        // 3.电影表中的记录
        movieMapper.deleteById(movieId);
    }

    @Override
    public void update(Movie movie) {
        // 1.更新电影表
        movieMapper.update(movie);
        // 2.更新电影与类型的中间表的记录
        // 2.1.先删除中间表中的相关记录:根据电影的id删除记录
        movieMapper.deleteMovieAndcategories(movie.getId());

        // 2.2.在插入相关的记录:向中间表中插入新的记录
        // 页面上传递过来的电影存储在movie的categories中, 使用逗号连接起来的字符串: 1,3
        // 分割电影类型的id
        String categories = movie.getMovietypes();
        // ["1", "3"]
        String[] cateids = categories.split(",");
        for (String cid : cateids) {
            // 创建一个bean用来封装movieId和categoryId
            MovieAndType mac = new MovieAndType(movie.getId(),
                    Integer.parseInt(cid));
            movieMapper.insertMovieAndCategory(mac);
        }

    }

    /*
    电影 推荐列表:

     */
    @Override
    public List<Movie> recommendMovieList(int movieId) {
        // 1.查询电影
        Movie movie = movieMapper.findById(movieId);

        // 2.获取所有的推荐类型
        List<RecommendType> recommendList = recommendTypeMapper.findRecommendList();

        // 3. 定义一个list用来存储被推荐的电影
        List<Movie> recommendMovieList = new ArrayList<Movie>();
        // 用来存储被推荐的电影的id,不允许重复
        Set<Integer> recommendMovieIds = new HashSet<Integer>();
        // 3.遍历推荐类型
        for (RecommendType r : recommendList) {
            if(r.getId() == 1){
                // 表示按照 类型推荐
                // 按照电影的类型查询出最新的前3条电影
                List<Movie> top3ByCates = movieMapper.findTop3ByCates(movieId);
                // 添加到recommendMovieList中
                // recommendMovieList.addAll(top3ByCates);
                for (Movie m : top3ByCates) {
                    // 判断当前电影是否与已经推荐的
                    if(!recommendMovieIds.contains(m.getId())){
                        recommendMovieList.add(m);
                        recommendMovieIds.add(m.getId());
                    }

                }
            }else if (r.getId() == 2){
                // 表示按照演员
                // 按照电影的演员查询出最新的前3条电影
                List<Movie> top3ByActors =
                        movieMapper.findTop3ByActors(movieId);
                for (Movie m : top3ByActors) {
                    if(!recommendMovieIds.contains(m.getId())){
                        recommendMovieList.add(m);
                        recommendMovieIds.add(m.getId());
                    }
                }
            }else{
                // 按照花絮推荐
            }

        }

        return recommendMovieList;
    }
}
