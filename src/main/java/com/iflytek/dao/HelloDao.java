package com.iflytek.dao;

import com.iflytek.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface HelloDao extends Mapper<User> {
    @Select("select * from User where id=#{id}")
    public User getUserById(@Param("id") String id);

    @Select("select * from User where name=#{name} and password=#{password}")
    public User getUser(@Param("name") String name,@Param("password") String password);
}
