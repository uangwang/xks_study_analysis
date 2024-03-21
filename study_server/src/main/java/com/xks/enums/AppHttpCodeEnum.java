package com.xks.enums;

public enum AppHttpCodeEnum {
    SUCCESS(200, "操作成功"),
    ERROR(469,"error"),
    IDERROR(401,"error!"),
    STREAMERROR(402,"error"),
    TOKEN_NULL(403,"Token为空"),
    SIGN_ERROR(404,"签名错误"),
    TOKEN_EXPRE_ERROR(405,"Token过期"),
    SIGN_DEFFRENT_ERROR(406,"签名被篡改"),
    TOKEN_PARM_ERROR(407,"签名参数错误"),
    ROLE_ERROR(408,"角色错误"),
    PROGRAMME_INPERTER(409,"亲你是不是在使用爬虫呢？"),
    AUDIENCE_ERROR(410,"身份存在问题"),
    USER_NULL(411,"用户信息为空"),
    REGISTER_ERROR(412,"用户注册错误"),
    ACCOUNT_EXISTS(413,"此账户已存在"),
    ACCOUNT_PASSWORD_NULL(414,"账号密码为空"),
    LOGIN_ERROR(415,"登录失败"),
    USER_EMAIL_NULL(416,"用户和邮箱不匹配");


    int code;
    String msg;

    AppHttpCodeEnum(int code, String errorMessage) {
        this.code = code;
        this.msg = errorMessage;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
