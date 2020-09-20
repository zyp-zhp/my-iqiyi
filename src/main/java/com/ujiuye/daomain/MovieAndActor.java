package com.ujiuye.daomain;

public class MovieAndActor {
    private int movieid;
    private int actorid;

    public MovieAndActor() {
    }

    public MovieAndActor(int movieid, int actorid) {
        this.movieid = movieid;
        this.actorid = actorid;
    }

    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    public int getActorid() {
        return actorid;
    }

    public void setActorid(int actorid) {
        this.actorid = actorid;
    }

    @Override
    public String toString() {
        return "MovieAndActor{" +
                "movieid=" + movieid +
                ", actorid=" + actorid +
                '}';
    }
}
