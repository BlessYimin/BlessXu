package com.iflytek.service;

import com.iflytek.model.User;

import java.util.List;

public interface HelloService {
    /**
     * 获取用户信息
     * @param id 用户id
     */
    public User getUser(String id);

    /**
     * 通过用户名与密码获得用户
     * @param name 用户名
     * @param password 用户密码
     * @return User
     */
    public User getUser(String name,String password);
}
