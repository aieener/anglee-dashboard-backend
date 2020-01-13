package com.aieener.anglee.user.controller.api;

import com.aieener.anglee.user.enums.ResultEnum;
import com.aieener.anglee.user.form.RegisterForm;
import com.aieener.anglee.user.service.UserService;
import com.aieener.anglee.user.util.ResultVOUtil;
import com.aieener.anglee.user.validator.RegisterValidator;
import com.aieener.anglee.user.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
public class UserRestController {
    private final UserService userService;
    private final RegisterValidator registerValidator;

    @Autowired
    public UserRestController(UserService userService, RegisterValidator registerValidator) {
        this.userService = userService;
        this.registerValidator = registerValidator;
    }

    @PostMapping("/signup.do")
    public ResultVO register(@Valid RegisterForm registerForm, BindingResult bindingResult) {
        registerValidator.validate(registerForm, bindingResult);
        if (bindingResult.hasErrors()) {
            log.error("[register] parameter error, username={}", registerForm.getUsername());
            return ResultVOUtil.error(ResultEnum.REGISTER_FAIL);
        }
        return userService.register(registerForm);
    }

}
