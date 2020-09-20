package com.ujiuye.service.impl;

import com.ujiuye.dao.MovieAndActorMapper;
import com.ujiuye.dao.MovieMapper;
import com.ujiuye.daomain.Movie;
import com.ujiuye.daomain.MovieAndActor;
import com.ujiuye.service.IMovieAndActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieAndActorServiceImpl implements IMovieAndActorService {

    @Autowired
    private MovieAndActorMapper movieAndActorMapper;

    @Autowired
    private MovieMapper movieMapper;

    @Override
    public void save(Movie movie) {
        // 1.得到电影的id
        int mid = movie.getId();
        // 2.得到所有的演员的id
        String actorIds = movie.getActorIds();
        // 解析出每个演员id
        String[] actorIdArray = actorIds.split(",");
        // 遍历出每个演员的id
        for (String actorId :actorIdArray) {
            MovieAndActor maa = new MovieAndActor(mid,Integer.parseInt(actorId));
            // 向中间表中保存记录
            movieAndActorMapper.save(maa);
        }
    }

    @Override
    public Movie findByMovieId(int movieId) {
        return null;
    }

    @Override
    public void deleteByMovieId(int movieId) {
        // 从电影与演员的中间表movie_actor中删除该电影相关的记录
        movieMapper.deleteMovieAndActors(movieId);
    }

    @Override
    public void update(Movie movie) {
        // 得到电影id
        int movieId = movie.getId();
        // 从电影与演员的中间表movie_actor中删除该电影相关的记录
        movieMapper.deleteMovieAndActors(movieId);

        // 获得从页面传递过来的演员id,如: "1,2,3"
        String actorIds = movie.getActorIds();
        // 拆分演员id
        String[] actorIdArray = actorIds.split(",");
        // 遍历出每个演员id
        for (String actorId : actorIdArray) {
            // 向电影与演员的中间表movie_actor中插入记录
            MovieAndActor maa = new MovieAndActor(movieId,
                    Integer.parseInt(actorId));
            movieAndActorMapper.save(maa);
        }
    }
}
