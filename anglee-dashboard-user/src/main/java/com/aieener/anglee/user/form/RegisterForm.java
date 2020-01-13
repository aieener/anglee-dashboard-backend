package com.aieener.anglee.user.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Data
public class RegisterForm {
    @NotEmpty(message="must provide username!")
    private String username;
    @NotEmpty(message="must provide password!")
    private String password;
    private String email;
    private String phone;
    private String question;
    private String answer;
    @NotNull(message="must provide user role!")
    private List<String> role;
}
