package com.ujiuye.controller;

import com.ujiuye.daomain.Movie;
import com.ujiuye.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("movie")
public class MovieController {
    @Autowired
    private IMovieService movieService;
    @GetMapping("/findAll")
    public List<Movie>findAll(){
        return movieService.findAllMovie();
    }
}
