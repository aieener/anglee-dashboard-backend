package com.aieener.anglee.user.service;

import com.aieener.anglee.user.form.RegisterForm;
import com.aieener.anglee.user.model.User;
import com.aieener.anglee.user.validator.RegisterValidator;
import com.aieener.anglee.user.vo.ResultVO;

import java.util.List;

public interface UserService {
    List<User> findAll();

    ResultVO<String> register(RegisterForm form);

    User findByUsername(String username);

    User findUserByEmail(String email);
}
