package com.xks.config;

import com.xks.utils.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 类名：MyConfig
 * 包名：com.ksw.config
 * 描述：
 * 作者: cdutKSW
 * 创建日期：2024/3/4
 * 版本号：V1.0
 */
@Configuration
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptor1 = registry.addInterceptor(new MyInterceptor());
        interceptor1.addPathPatterns("/**");
        interceptor1.excludePathPatterns("/users/login");
    }
}
