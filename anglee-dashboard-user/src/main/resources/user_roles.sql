CREATE TABLE `user_roles`
(
    `users_id` int NOT NULL,
    `roles_id` int NOT NULL,
    PRIMARY KEY (`users_id`, `roles_id`),
    KEY `user_id` (`users_id`),
    CONSTRAINT `user_role_ibfk_1`
        FOREIGN KEY (`roles_id`) REFERENCES `role` (`id`),
    CONSTRAINT `user_role_ibfk_2`
        FOREIGN KEY (`users_id`) REFERENCES `user` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;