package com.bjsxt.service;

import com.bjsxt.common.pojo.Result;
import com.bjsxt.pojo.User;

/**
 * @author lhp
 * @create 2021-09-07 14:56
 *
 * 前后端分离的项目，控制层都是被前端项目用 ajax的方式访问的
 *
 * 所以，控制层处理完请求后，要响应给前端一段内容！
 *
 * 为了规范写代码，需要指定统一的格式响应给前端
 *
 */
public interface UserService {

    Result login(User user);

    Result register(User user);
}
