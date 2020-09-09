package com.ujiuye.service;

import com.ujiuye.daomain.User;

import java.util.List;


public interface IUserService {
    //    管理员用户注册接口
    public void insertUser(User user);
    //    用户手机密码登录接口
    public List<User> findUser(User user);
}
