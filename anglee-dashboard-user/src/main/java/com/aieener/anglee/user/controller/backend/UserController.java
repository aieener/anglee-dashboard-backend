package com.aieener.anglee.user.controller.backend;

import com.aieener.anglee.user.model.Role;
import com.aieener.anglee.user.model.User;
import com.aieener.anglee.user.form.RegisterForm;
import com.aieener.anglee.user.repository.RoleRepository;
import com.aieener.anglee.user.service.UserService;
import com.aieener.anglee.user.validator.RegisterValidator;
import com.aieener.anglee.user.vo.ResultVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RegisterValidator registerValidator;

    @GetMapping("/register")
    public ModelAndView register(Map<String, Object> map) {
        return new ModelAndView("user/register", map);
    }

    @PostMapping("/register.do")
    public ModelAndView register(@Valid RegisterForm form, BindingResult bindingResult, Map<String, Object> map) {
        registerValidator.validate(form, bindingResult);
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "list");
            return new ModelAndView("common/error", map);
        }
        ResultVO res = userService.register(form);

        map.put("url", "list");
        if (res.isSuccess()) {
            map.put("msg", "Successfully sign up user : " + form.getUsername());
            return new ModelAndView("common/success", map);
        } else {
            map.put("msg", res.getMsg());
            return new ModelAndView("common/error", map);
        }
    }

    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map) {
        List<User> users = userService.findAll();
        map.put("users", users);
        return new ModelAndView("user/list", map);
    }

    @GetMapping("/login")
    public ModelAndView login(Map<String, Object> map) {
        List<User> users = userService.findAll();
        map.put("users", users);
        return new ModelAndView("user/login", map);
    }
}
