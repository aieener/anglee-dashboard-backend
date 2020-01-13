package com.aieener.anglee.user.common;

public class Const {
    public static final String CURRENT_USER = "currentUser";
    public static final String EMAIL = "email";
    public static final String USERNAME = "username";

    public interface Role {
        int ROLE_ADMIN = 0;
        int ROLE_USER = 1;
    }

    public interface RedisConstant {
        String TOKEN_TEMPLATE = "token_%s";

    }

    public interface CookieConstant {
        String TOKEN = "user_token";
        Integer expire = 7200; // unit s
    }
}
