package com.bjsxt.controller;

import com.bjsxt.common.pojo.Result;
import com.bjsxt.pojo.User;
import com.bjsxt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author lhp
 * @create 2021-09-07 15:04
 */
@RestController
//@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;
//登录接口
    @RequestMapping("/login")
    public Result login(User user){

        return userService.login(user);
    }
//    注册接口
    @PostMapping("/register")
    public Result register(User user){
        System.out.println(user);
        return userService.register(user);
    }
}
