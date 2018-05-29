package com.iflytek.controller;

import com.iflytek.constants.Constants;
import com.iflytek.exception.ControllerException;
import com.iflytek.model.User;
import com.iflytek.service.HelloService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "hello")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "world")
    @ResponseBody
    public User world(HttpServletResponse response){
        System.out.println("hello world!");
        User user=helloService.getUser("1");
        return user;
//        System.out.println(JSON.toJSONString(user));
    }

    @RequiresRoles(value = {"user","admin"},logical = Logical.OR)
    @RequiresPermissions("create")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody User user,Model model) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getPassword());
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            model.addAttribute("userName", "用户名错误！");
            return "login";
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            model.addAttribute("passwd", "密码错误");
            return "login";
        }
        return "index";
    }

    @RequestMapping(value = "exception")
    @ResponseBody
    public void exception(){
        try {
            List<String> list=new ArrayList<>();
            String temp=list.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ControllerException(Constants.ERROR_CODE,"错误");
        }

    }

}
