package com.ujiuye.dao;

import com.ujiuye.daomain.MovieAndActor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MovieAndActorMapper {
    public void save(MovieAndActor maa);

    public List findByMovieId(int movieId);

    public void deleteByMovieId(int movieId);
}
