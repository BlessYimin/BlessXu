package com.iflytek.controller;

import com.alibaba.fastjson.JSON;
import com.iflytek.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "hello")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "world")
    public void world(){
        System.out.println("hello world!");
        System.out.println(JSON.toJSON(helloService.getUser("1")));
    }

}
