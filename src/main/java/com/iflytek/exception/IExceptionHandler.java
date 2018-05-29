package com.iflytek.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class IExceptionHandler {

    @ExceptionHandler(ControllerException.class)//可以直接写@ExceptionHandler,不指明异常类，会自动映射
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map controllerExceptionHandler(ControllerException exception){ //还可以声明接收其他任意参数
        Map map=new HashMap();
        map.put("errCode",exception.getErrCode());
        map.put("errMsg",exception.getErrMsg());
        return map;
    }

    @ExceptionHandler(Exception.class)//可以直接写@EceptionHandler，IOExeption继承于Exception
    public Map allExceptionHandler(Exception exception){
        Map map=new HashMap();
        map.put("errCode","0");
        map.put("errMsg",exception.getMessage());
        return map;
    }
}
