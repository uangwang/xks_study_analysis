package com.xks.utils;

import com.xks.annotations.JWTAuthizator;
import com.xks.enums.AppHttpCodeEnum;
import com.xks.exceptions.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;

@Slf4j
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String header2 = request.getHeader("User-Agent");
        if (header2 == null || header2 == "") {
            throw new MyException(AppHttpCodeEnum.PROGRAMME_INPERTER);
        }

        if(handler instanceof  HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            JWTAuthizator annotation = method.getAnnotation(JWTAuthizator.class);
            if (annotation != null && annotation.require()){
                String token = request.getHeader("auth");
                if (token == null || token.length() == 0){
                    throw new MyException(AppHttpCodeEnum.TOKEN_NULL);
                }
                try {
                    String audience = JWTUtils.getAudienceByToken(token);
                    if (audience == null){
                        throw new MyException(AppHttpCodeEnum.AUDIENCE_ERROR);
                    }
                    Map<String, Object> variefToken = JWTUtils.variefToken(token, audience);
                    Integer code = (Integer) variefToken.get("infoCode");
                    if (code == 2){
                        throw new MyException(AppHttpCodeEnum.SIGN_ERROR);
                    }
                    if (code == 3){
                        throw new MyException(AppHttpCodeEnum.TOKEN_EXPRE_ERROR);
                    }
                    if (code == 4){
                        throw new MyException(AppHttpCodeEnum.SIGN_DEFFRENT_ERROR);
                    }

                    String role = JWTUtils.getInfoByTokenAndName(token,"role");
                    String[] roles = annotation.role();
                    if (roles.length > 0){
                        boolean flag= false;
                        for (String roleStr:roles) {
                            if (roleStr.equals(role)){
                                flag = true;
                                break;
                            }
                        }
                        if (!flag){
                            throw new MyException(AppHttpCodeEnum.SIGN_DEFFRENT_ERROR);
                        }

                    }

                }catch (Exception e){
                    throw new MyException(AppHttpCodeEnum.ROLE_ERROR);
                }
            }
        }


        return true;
    }
}
