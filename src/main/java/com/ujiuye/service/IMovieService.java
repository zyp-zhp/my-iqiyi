package com.ujiuye.service;

import com.ujiuye.daomain.Actor;
import com.ujiuye.daomain.Movie;
import com.ujiuye.daomain.Movietype;
import com.ujiuye.daomain.Recommend;

import java.util.List;

public interface IMovieService {
    //1) 电影列表查询接口
    public List<Movie> findAllMovie();
    //2) 新增电影接口
    public void insertMovie(Movie movie);
    //3) 修改电影接口
    public void update(Movie movie);
    //4) 删除电影接口
    public void deleteMovieById(Integer id);
//根据id查找电影
    Movie findById(int movieId);
    //电影与类型的中间表
   public  void deleteMovieAndType(int movieId);


    //    1) 电影详情接口
    public Movie findMoviedirectionById(Integer id);
    //2) 电影类别接口
    public List<Movietype> findMovieTypeById(Integer id);

    //    1) 电影推荐列表接口
    public List<Recommend> findRecommendById(Integer id);
    //2) 电影播放接口
    public Integer findMovieById(Integer id);

    //    1) 电影演员查询列表接口
    public List<Actor> findMovieActorById(Integer id);
    //2) 添加电影演员接口
    public Actor insertMovieActorById(Movie movie);
    //3) 编辑电影演员接口
    public Integer updateMovieActorById(Integer id);
    //4) 删除电影演员接口
    public Integer deleteMovieActorById(Integer id);
}
