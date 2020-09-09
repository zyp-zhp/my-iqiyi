package com.ujiuye.daomain;

public class MovieAndType {
    private int movieId;
    private int movieTypeId;

    public MovieAndType() {
    }

    public MovieAndType(int movieId, int movieTypeId) {
        this.movieId = movieId;
        this.movieTypeId = movieTypeId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getMovieTypeId() {
        return movieTypeId;
    }

    public void setMovieTypeId(int movieTypeId) {
        this.movieTypeId = movieTypeId;
    }

    @Override
    public String toString() {
        return "MovieAndType{" +
                "movieId=" + movieId +
                ", movieTypeId=" + movieTypeId +
                '}';
    }
}
