package com.xks.exceptions;

import com.xks.enums.AppHttpCodeEnum;

public class MyException extends Exception {
    private int code;
    private String message;

    public MyException(){

    }

    public MyException(AppHttpCodeEnum codeEnum){
        super(codeEnum.getMsg());
        this.code = codeEnum.getCode();
        this.message = codeEnum.getMsg();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
