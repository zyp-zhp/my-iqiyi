package com.ujiuye.service;

import com.ujiuye.daomain.Movie;

public interface IMovieAndActorService {
    public void save(Movie movie);

    public Movie findByMovieId(int movieId);

    public void deleteByMovieId(int movieId);


    public void update(Movie movie);
}
