package com.example.blog.config.ResultConfig;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * 在自定义异常的错误码和信息时，如果过多，没有统一管理，则会出现重复。
 * 使用枚举统一管理code和message：
 */
@Getter
@AllArgsConstructor
public enum ResultEnum {
    LOGIN_INVALID(-6, "登录过期，请重新登录"),
    ACCOUNT_EXIST(-5, "该账号已被注册使用"),
    PASSWORD_ERROR(-3, "密码错误或未选择正确角色"),
    NOTFOUND_USER(-2, "该用户未注册"),
    UNKNOW_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功");
    private Integer code;
    private String msg;
}
