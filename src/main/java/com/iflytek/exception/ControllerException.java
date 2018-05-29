package com.iflytek.exception;

import lombok.Data;

@Data
public class ControllerException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private String errCode;
    private String errMsg;

    public ControllerException(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
}