package com.iflytek.dao;

import com.iflytek.model.User;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface HelloDao extends Mapper<User> {
    @Select("select * from User where id={#id}")
    public User getUser(String id);
}
