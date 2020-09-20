package com.ujiuye.dao;

import com.ujiuye.daomain.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MovieMapper {
    public List<Movie> findAll();

    public void save(Movie movie);

    /*   public void insertMovieAndCategory(Movie movie, Category cate);*/

    public void insertMovieAndCategory(MovieAndType mac);

    Movie findById(int movieId);

    void deleteMovieAndcategories(int movieId);

    void deleteMovieAndActors(int movieId);

    void deleteById(int movieId);

    void update(Movie movie);

    // 根据当前电影的类型查询出与该电影类型相同的最新的前3条电影
    List<Movie> findTop3ByCates(int movieId);

    // 根据当前电影的演员查询出与该电影演员相同的最新的前3条电影
    List<Movie> findTop3ByActors(int movieId);
}
