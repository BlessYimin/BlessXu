package com.iflytek.service;

import com.iflytek.model.User;

public interface HelloService {
    /**
     * 获取用户信息
     * @param id 用户id
     */
    public User getUser(String id);
}
