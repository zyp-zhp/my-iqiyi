package com.ujiuye.controller;

import com.ujiuye.daomain.User;
import com.ujiuye.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
   private IUserService userService;
    //    管理员用户注册接口
    @PostMapping("/register")
    public String insertUser(User user)
    {
        userService.insertUser(user);
        return "创建成功";
    }
    //    用户手机密码登录接口
    @PostMapping("/findUser")
    public User findUser(User user, HttpServletRequest request, HttpServletResponse response) {
        List<User> list = userService.findUser(user);
        if (list != null && list.size() > 0) {
            user = list.get(0);
            //把用户信息保存到session中,便于操作其他操作之前判断用户是否已经登录
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
        }
        return user;
    }
}
