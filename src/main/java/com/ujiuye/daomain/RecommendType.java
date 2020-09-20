package com.ujiuye.daomain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


public class RecommendType {
    private Integer id;
    private String way;
    private int isrecommend;

    public RecommendType() {
    }

    public RecommendType(Integer id, String way, int isrecommend) {
        this.id = id;
        this.way = way;
        this.isrecommend = isrecommend;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public int getIsrecommend() {
        return isrecommend;
    }

    public void setIsrecommend(int isrecommend) {
        this.isrecommend = isrecommend;
    }

    @Override
    public String toString() {
        return "RecommendType{" +
                "id=" + id +
                ", way='" + way + '\'' +
                ", isrecommend=" + isrecommend +
                '}';
    }
}
