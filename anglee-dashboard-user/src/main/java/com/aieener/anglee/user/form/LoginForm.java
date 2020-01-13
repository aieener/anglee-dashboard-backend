package com.aieener.anglee.user.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginForm {
    @NotEmpty(message = "must provide username!")
    private String username;
    @NotEmpty(message = "must provide password!")
    private String password;
}
