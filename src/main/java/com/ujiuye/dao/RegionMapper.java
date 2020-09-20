package com.ujiuye.dao;

import com.ujiuye.daomain.Region;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface RegionMapper {
    public List<Region> findAll();
}
