package com.ujiuye.service;

import com.ujiuye.daomain.RecommendType;

import java.util.List;

public interface IRecommendTypeService {
    public List<RecommendType> findAll();

    public void nowRecommend(String ids);
}
