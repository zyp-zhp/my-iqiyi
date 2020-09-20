package com.ujiuye.service.impl;

import com.ujiuye.dao.RecommendTypeMapper;
import com.ujiuye.daomain.RecommendType;
import com.ujiuye.service.IRecommendTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendTypeServiceImpl implements IRecommendTypeService{
    @Autowired
    private RecommendTypeMapper recommendTypeMapper;

    @Override
    public List<RecommendType> findAll() {
        return recommendTypeMapper.findAll();
    }

    @Override
    public void nowRecommend(String ids) {
        // 先取消之前所有的推荐类型
        recommendTypeMapper.cancelRecommend();

        // 在设置现在推荐的类型: ["1", "2"]
        String[] idArray = ids.split(",");
        for (String id : idArray) {
            recommendTypeMapper.nowRecommend(Integer.parseInt(id));
        }
    }
}
