package com.aieener.anglee.user.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    SUCCESS(0, "success"),
    LOGIN_FAIL_INVALID_PASSWORD(1, "login fail: wrong password"),
    LOGIN_FAIL_NON_EXISTING_USER(2, "login fail: username doesn't exist"),
    REGISTER_FAIL_DB(3, "register fail: db error"),
    REGISTER_FAIL_EXISTING_USERNAME(4, "register fail: existing username"),
    REGISTER_FAIL_EXISTING_EMAIL(5, "register fail: existing email"),
    REGISTER_FAIL(6, "register fail"),
    ROLE_ERROR(7, "unauthorized user"),
    PARAM_ERROR(10, "param error"),
    USER_NOT_FOUND(11, "user not found");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
