package com.aieener.anglee.user.service.impl;

import com.aieener.anglee.user.form.RegisterForm;
import com.aieener.anglee.user.model.Role;
import com.aieener.anglee.user.model.User;
import com.aieener.anglee.user.enums.ResultEnum;
import com.aieener.anglee.user.repository.RoleRepository;
import com.aieener.anglee.user.repository.UserRepository;
import com.aieener.anglee.user.service.UserService;
import com.aieener.anglee.user.util.BcryptUtil;
import com.aieener.anglee.user.util.ResultVOUtil;
import com.aieener.anglee.user.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public ResultVO<String> register(RegisterForm form) {
        User res = userRepository.save(getPasswordEncryptedUserByRegisterForm(form));
        if (res == null) {
            return ResultVOUtil.error(ResultEnum.REGISTER_FAIL_DB);
        }
        return ResultVOUtil.success();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    private User getPasswordEncryptedUserByRegisterForm(RegisterForm form) {
        User user = new User();
        BeanUtils.copyProperties(form, user);
        Set<Role> roles = new HashSet<>();
        form.getRole().forEach(name -> {
            Role role = roleRepository.findByName(name);
            roles.add(role);
        });
        user.setRoles(roles);
        user.setPassword(BcryptUtil.encode(user.getPassword()));
        return user;
    }
}
