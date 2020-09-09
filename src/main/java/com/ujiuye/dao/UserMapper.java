package com.ujiuye.dao;

import com.ujiuye.daomain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    //    管理员用户注册接口
    public void insertUser(User user);
    //    用户手机密码登录接口
    public List<User> findUser(User user);
}