package com.ujiuye.service;

import com.ujiuye.dao.MovieMapper;
import com.ujiuye.daomain.Actor;
import com.ujiuye.daomain.Movie;
import com.ujiuye.daomain.Movietype;
import com.ujiuye.daomain.Recommend;
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
    public Movie insertMovie(Movie movie){
        return movieMapper.insertMovie(movie);
    }
    @Override
    //3) 修改电影接口
    public Integer updateMovieById(Movie movie){
        return movieMapper.updateMovieById(movie);
    }
    @Override
    //4) 删除电影接口
    public Integer deleteMovieById(Integer id){
        return  movieMapper.deleteMovieById(id);
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
