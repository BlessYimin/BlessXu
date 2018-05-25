package com.iflytek.service;

import com.iflytek.model.User;

import java.util.List;

public interface HelloService {
    /**
     * 获取用户信息
     * @param id 用户id
     */
    public User getUser(String id);
}
