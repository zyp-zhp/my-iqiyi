package com.ujiuye.dao;

import com.ujiuye.daomain.RecommendType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecommendTypeMapper {
    // 查询所有选中的推荐类型
    public List<RecommendType> findRecommendList();

    // 修改成被推荐的类型
    public void nowRecommend(int id);

    // 取消所有已经被推荐的类型
    public void cancelRecommend();

    // 查询所有推荐类型
    List<RecommendType> findAll();
}
