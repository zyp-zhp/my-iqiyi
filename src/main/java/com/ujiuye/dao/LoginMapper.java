package com.ujiuye.dao;

import com.ujiuye.daomain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    //    用户手机密码登录接口
    public Integer findUserById(User user);
}