package com.ujiuye.service;

import com.ujiuye.dao.MovieMapper;
import com.ujiuye.daomain.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements IMovieService {
    @Autowired
    private MovieMapper movieMapper;
    public List<Movie> findAllMovie(){
        List<Movie> movieList=null;
        movieList=movieMapper.findAllMovie();
        return  movieList;
    }
    @Override
    //2) 新增电影接口
    public void insertMovie(Movie movie){
        // 1.向movie表中插入一条记录
        movieMapper.insertMovie(movie);
        int mid=movie.getId();
        System.out.println("id==" + mid);
        System.out.println(movie.getMovietypes());
        // 2.向电影和类型的中间表中插入记录:
        String  movietypes = movie.getMovietypes();
        String[] cateArray = movietypes.split(",");
        for (String cid : cateArray){
            MovieAndType mat =new MovieAndType(mid,Integer.parseInt(cid));
            movieMapper.insertMovieAndType(mat);
        }
    }
    @Override
    //3) 修改电影接口
    public void update(Movie movie){
        // 1.更新电影表
        movieMapper.update(movie);
        // 2.更新电影与类型的中间表的记录
        // 2.1.先删除中间表中的相关记录:根据电影的id删除记录
        movieMapper.deleteMovieAndType(movie.getId());

        // 2.2.在插入相关的记录:向中间表中插入新的记录
        // 页面上传递过来的电影存储在movie的categories中, 使用逗号连接起来的字符串: 1,3
        // 分割电影类型的id
        String movietypes = movie.getMovietypes();
        // ["1", "3"]
        String[] cateids = movietypes.split(",");
        for (String cid : cateids) {
            // 创建一个bean用来封装movieId和categoryId
            MovieAndType mac = new MovieAndType(movie.getId(),
                    Integer.parseInt(cid));
            movieMapper.insertMovieAndType(mac);
        }
    }
    @Override
    //4) 删除电影接口
    public void deleteMovieById(Integer id){
        // 1.电影与类型的中间表的记录
        movieMapper.deleteMovieAndType(id);
        // 2.电影与演员的中间表的记录
        movieMapper.deleteMovieActorById(id);
        // 3.电影表中的记录
        movieMapper.deleteMovieById(id);
    }
    //根据id查找电影
    @Override
    public  Movie findById(int id){
        return movieMapper.findById(id);
    }
    @Override
    //电影与类型的中间表
    public  void deleteMovieAndType(int movieId){
            movieMapper.deleteMovieAndType(movieId);
    }
    @Override
    //    1) 电影详情接口
    public Movie findMoviedirectionById(Integer id){
        return movieMapper.findMoviedirectionById(id);
    }
    @Override
    //2) 电影类别接口
    public List<Movietype> findMovieTypeById(Integer id){
        List<Movietype> movietypeList=null;
        movietypeList=movieMapper.findMovieTypeById(id);
        return  movietypeList;
    }
    @Override
    //    1) 电影推荐列表接口
    public List<Recommend> findRecommendById(Integer id){
        List<Recommend> recommendList=null;
        recommendList=movieMapper.findRecommendById(id);
        return recommendList;
    }
    @Override
    //2) 电影播放接口
    public Integer findMovieById(Integer id){
        return movieMapper.findMovieById(id);
    }
    @Override
    //    1) 电影演员查询列表接口
    public List<Actor> findMovieActorById(Integer id){
        List<Actor> actorList=null;
        actorList=movieMapper.findMovieActorById(id);
        return actorList;
    }
    @Override
    //2) 添加电影演员接口  把电影和演员的id联系
    public Actor insertMovieActorById(Movie movie){
        return movieMapper.insertMovieActorById(movie);
    }
    @Override
    //3) 编辑电影演员接口
    public Integer updateMovieActorById(Integer id){
        return movieMapper.updateMovieActorById(id);
    }
    @Override
    //4) 删除电影演员接口
    public Integer deleteMovieActorById(Integer id){
        return movieMapper.deleteMovieActorById(id);
    }
}
