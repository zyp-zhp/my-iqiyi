package com.ujiuye.daomain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;
@Data
@ToString
@NoArgsConstructor
public class Movie {
    private int id;
    private String movieName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date showdate;
    private int timelength;
    private String director;
    private String description;
    private float rating;
    private String photo;
    private List<RecommendType> recommendTypes;
    // 一个电影有多个类型,一对多的关系
    private String movietypes;
    private List<Movietype> movietypeList;
    // 在电影与演员的编辑界面,选中的多个演员的id,比如: "1,3,4"
    private String actorIds;
    private List<Actor> actors;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Date getShowdate() {
        return showdate;
    }

    public void setShowdate(Date showdate) {
        this.showdate = showdate;
    }

    public int getTimelength() {
        return timelength;
    }

    public void setTimelength(int timelength) {
        this.timelength = timelength;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<RecommendType> getRecommendTypes() {
        return recommendTypes;
    }

    public void setRecommendTypes(List<RecommendType> recommendTypes) {
        this.recommendTypes = recommendTypes;
    }

    public String getMovietypes() {
        return movietypes;
    }

    public void setMovietypes(String movietypes) {
        this.movietypes = movietypes;
    }

    public List<Movietype> getMovietypeList() {
        return movietypeList;
    }

    public void setMovietypeList(List<Movietype> movietypeList) {
        this.movietypeList = movietypeList;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public String getActorIds() {
        return actorIds;
    }

    public void setActorIds(String actorIds) {
        this.actorIds = actorIds;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
