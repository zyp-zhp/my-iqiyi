package com.ujiuye.service;

import com.ujiuye.daomain.User;

public interface ILoginService {
    //    用户手机密码登录接口
    public Integer findUserById(User user);
}
