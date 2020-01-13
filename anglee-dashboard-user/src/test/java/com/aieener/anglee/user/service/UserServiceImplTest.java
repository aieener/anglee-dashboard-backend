package com.aieener.anglee.user.service;

import com.aieener.anglee.user.form.RegisterForm;
import com.aieener.anglee.user.model.User;

import com.aieener.anglee.user.enums.ResultEnum;
import com.aieener.anglee.user.vo.ResultVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Date;

@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UserService userService;
    private String mockPassword = "1234abcd";
    private String mockUsername = "dajiangtang";
    private String mockemail = "dajiangtang@gmail.co";

    @Test
    @Transactional
    public void testSuccessfulRegister() {
        ResultVO<String> response = registerMockUser();
        Assert.isTrue(response.isSuccess(), "register user successfully");
    }

    @Test
    @Transactional
    public void testRegisterOnFailure() {
        registerMockUser();
        ResultVO<String> response = registerMockUser();
        Assert.isTrue(!response.isSuccess(), "can't register existing user");
        Assertions.assertEquals(response.getCode(), ResultEnum.REGISTER_FAIL_EXISTING_USERNAME.getCode());
    }

    private ResultVO<String> registerMockUser() {
        RegisterForm form = new RegisterForm();
        form.setPassword(mockPassword);
        form.setUsername(mockUsername);
        form.setEmail(mockemail);
        form.setRole(Arrays.asList("admin"));
        return userService.register(form);
    }
}
