package com.ujiuye.dao;

import com.ujiuye.daomain.Movietype;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MovietypeMapper{
    public List<Movietype> findAll();
}
