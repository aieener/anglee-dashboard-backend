package com.aieener.anglee.user.validator;

import com.aieener.anglee.user.enums.ResultEnum;
import com.aieener.anglee.user.form.RegisterForm;
import com.aieener.anglee.user.model.User;
import com.aieener.anglee.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.xml.transform.Result;

@Component
public class RegisterValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RegisterForm form = (RegisterForm) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (userService.findByUsername(form.getUsername()) != null) {
            errors.rejectValue("username", ResultEnum.REGISTER_FAIL_EXISTING_USERNAME.getMsg());
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
        if (userService.findUserByEmail(form.getEmail()) != null) {
            errors.rejectValue("email", ResultEnum.REGISTER_FAIL_EXISTING_EMAIL.getMsg());
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
    }
}
