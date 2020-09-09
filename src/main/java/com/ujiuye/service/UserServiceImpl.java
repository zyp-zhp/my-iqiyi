package com.ujiuye.service;

import com.ujiuye.dao.UserMapper;
import com.ujiuye.daomain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    //    管理员用户注册接口
    @Override
    public void insertUser(User user){
        userMapper.insertUser(user);
    }
    @Override
    //    用户手机密码登录接口
    public List<User> findUser(User user){
        return userMapper.findUser(user);
    }
}
