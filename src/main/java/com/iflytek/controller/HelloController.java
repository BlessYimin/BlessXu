package com.iflytek.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "hello")
public class HelloController {

    @RequestMapping(value = "world")
    public void world(){
        System.out.println("hello world!");
    }

}
