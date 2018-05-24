package com.iflytek.service.impl;

import com.iflytek.dao.HelloDao;
import com.iflytek.model.User;
import com.iflytek.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("helloService")
public class HelloServiceImpl implements HelloService {

    @Autowired
    private HelloDao helloDao;

    @Override
    public User getUser(String id) {
        return helloDao.getUser(id);
//        return null;
    }
}
