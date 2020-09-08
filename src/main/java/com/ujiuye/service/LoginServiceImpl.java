package com.ujiuye.service;

import com.ujiuye.dao.LoginMapper;
import com.ujiuye.daomain.User;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginServiceImpl implements ILoginService {
    @Autowired
    private LoginMapper loginMapper;
    @Override
    //    用户手机密码登录接口
    public Integer findUserById(User user){
        return loginMapper.findUserById(user);
    }
}
