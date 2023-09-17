package com.bjsxt.mapper;

import com.bjsxt.pojo.User;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author lhp
 * @create 2021-09-07 14:55
 */
@Mapper
public interface UserMapper {

    @Select("select * from user where username=#{username} and password=#{password}")
    User getUserByUsernameAndPassword(User user);
    @Insert("INSERT INTO `test`.`user` (`id`, `username`, `password`) VALUES (null, #{username}, #{password});")
    Integer register(User user);
}
