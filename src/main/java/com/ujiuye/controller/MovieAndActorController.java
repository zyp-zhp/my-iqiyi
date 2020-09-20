package com.ujiuye.controller;

import com.ujiuye.daomain.Actor;
import com.ujiuye.daomain.Movie;
import com.ujiuye.service.IActorService;
import com.ujiuye.service.IMovieAndActorService;
import com.ujiuye.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("movieAndActor")
public class MovieAndActorController {
    @Autowired
    private IMovieAndActorService movieAndActorService;

    @Autowired
    private IMovieService movieService;

    @Autowired
    private IActorService actorService;


    @GetMapping("/edit")
    public Map<String, Object> editMovieAndActor(int movieId){

        /*
        1.2 接口的逻辑:
            根据电影的id查询出电影的数据: movie
            查询所有的电影: movieList
            查询出所有的演员: actorList
        */
        // 根据电影的id查询出电影的数据: movie
        Movie movie = movieService.findById(movieId);
        // 查询所有的电影: movieList
        List<Movie> movieList = movieService.findAll();
        // 查询出所有的演员: actorList
        List<Actor> actorList = actorService.findAll();

        /*1.3 返回的数据
        以上三个数据:
        movie, movieList, actorList
        定义一个map封装这三个数据,返回map*/
        Map<String, Object> map = new HashMap<>();
        map.put("movie", movie);
        map.put("movieList", movieList);
        map.put("actorList", actorList);

        return map;

    }
    // 添加电影与演员
    @PostMapping("/save")
    public String save(Movie movie){
        movieAndActorService.save(movie);
        return "提交成功";
    }
}
