package com.ujiuye.daomain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;
@Data
@ToString
@AllArgsConstructor
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
}
