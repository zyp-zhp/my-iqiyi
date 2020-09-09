package com.ujiuye.daomain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;
@Data
@ToString
@NoArgsConstructor
public class Movie {
    private Integer id;
    private String movieName;
    private Date showdate;
    private int timelength;
    private String director;
    private String description;
    private String photo;
    private List<Recommend> Recommends;
    private List<Movietype> movietypes;
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

    public List<Recommend> getRecommends() {
        return Recommends;
    }

    public void setRecommends(List<Recommend> recommends) {
        Recommends = recommends;
    }

    public List<Movietype> getMovietypes() {
        return movietypes;
    }

    public void setMovietypes(List<Movietype> movietypes) {
        this.movietypes = movietypes;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
