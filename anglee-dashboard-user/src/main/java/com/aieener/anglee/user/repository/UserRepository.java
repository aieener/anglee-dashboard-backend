package com.aieener.anglee.user.repository;

import com.aieener.anglee.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    int countUsersByUsername(String username);

    int countUsersByEmail(String email);

    boolean existsByUsername(String username);

    User findUserByUsername(String username);

    User findUserByEmail(String email);
}
