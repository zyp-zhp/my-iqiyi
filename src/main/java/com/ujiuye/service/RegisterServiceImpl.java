package com.ujiuye.service;

import com.ujiuye.dao.RegisterMapper;
import com.ujiuye.daomain.User;
import org.springframework.beans.factory.annotation.Autowired;

public class RegisterServiceImpl implements IRegisterService{
    @Autowired
    private RegisterMapper registerMapper;
    //    管理员用户注册接口
    @Override
    public User insertUser(User user){
        return registerMapper.insertUser(user);
    }
}
