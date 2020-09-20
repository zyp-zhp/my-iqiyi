package com.ujiuye.service;

import com.ujiuye.daomain.Movie;
import com.ujiuye.daomain.Movietype;
import com.ujiuye.daomain.RecommendType;

import java.util.List;

public interface IMovieService {

    public List<Movie> findAll();
    public void save(Movie movie);

    Movie findById(int movieId);

    void deleteMovie(int movieId);

    void update(Movie movie);

    List<Movie> recommendMovieList(int movieId);
}
