package com.xks.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 类名：JWTAuthizator
 * 包名：com.ksw.annotations
 * 描述：
 * 作者: cdutKSW
 * 创建日期：2024/3/4
 * 版本号：V1.0
 */
// target元注解用于标明他所注解带的注解的使用位置
@Target(ElementType.METHOD)
// Retention元注解用于标明他所注解的注解的生命周期
@Retention(RetentionPolicy.RUNTIME)
public @interface JWTAuthizator {

    boolean require() default true;
    String[] role() default {};

}
