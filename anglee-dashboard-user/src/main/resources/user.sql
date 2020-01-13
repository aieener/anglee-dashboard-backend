DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`          int(11)     NOT NULL AUTO_INCREMENT COMMENT 'user id',
    `username`    varchar(50) NOT NULL COMMENT 'username',
    `password`    varchar(72) NOT NULL COMMENT 'password, bcrypt encrypt',
    `email`       varchar(50)  DEFAULT NULL,
    `phone`       varchar(20)  DEFAULT NULL,
    `question`    varchar(100) DEFAULT NULL COMMENT 'question to get password back',
    `answer`      varchar(100) DEFAULT NULL COMMENT 'answer to password questions',
    `create_time` timestamp  not null default current_timestamp comment 'create time',
    `update_time` timestamp  not null default current_timestamp on update current_timestamp comment  'last update time',
    PRIMARY KEY (`id`),
    UNIQUE KEY `user_name_unique` (`username`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 22
  DEFAULT CHARSET = utf8;