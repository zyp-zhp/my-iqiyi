package com.ujiuye.dao;

import com.ujiuye.daomain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterMapper {
//    管理员用户注册接口
    public User insertUser(User user);
}
