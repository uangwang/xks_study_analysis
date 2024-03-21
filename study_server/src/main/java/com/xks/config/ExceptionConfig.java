package com.xks.config;

import com.xks.enums.AppHttpCodeEnum;
import com.xks.exceptions.MyException;
import com.xks.utils.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler(value = MyException.class)
    public ResponseResult systemExceptionHandler(MyException e){
        return ResponseResult.errorResult(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(value = NullPointerException.class)
    public ResponseResult exceptionHandler(Exception e){
        return ResponseResult.errorResult(AppHttpCodeEnum.IDERROR);
    }
}
