package com.ujiuye.daomain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Actor {
    private Integer id;
    private String actorName;
    private Date birthday;
    private String sex;
    private String description;
    private String photo;
    private List<Region> regions;

}
