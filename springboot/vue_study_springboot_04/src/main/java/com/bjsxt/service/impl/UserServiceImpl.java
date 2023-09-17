package com.bjsxt.service.impl;

import com.bjsxt.common.pojo.Result;
import com.bjsxt.mapper.UserMapper;
import com.bjsxt.pojo.User;
import com.bjsxt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lhp
 * @create 2021-09-07 15:03
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result login(User user) {

        User u = userMapper.getUserByUsernameAndPassword(user);
        if(u == null){
            return Result.error("用户名或密码错误！");
        }else{
            return Result.ok();
        }
    }

    @Override
    public Result register(User user){
        Integer i = userMapper.register(user);
        if (i==1){
            return Result.ok(user);
        }else {
            return Result.error("注册失败！");
        }
    }
}
