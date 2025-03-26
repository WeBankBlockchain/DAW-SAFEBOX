CREATE TABLE `t_mnemonic_info`
(
    `pk_id`        bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `user_id` varchar(256)  NOT NULL DEFAULT '' COMMENT '用户id',
    `key_type`   smallint  NOT NULL DEFAULT 0,
    `encrypt_mn` varchar(1024) NOT NULL DEFAULT '加密后的助记词',
    `create_time`  timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time`  timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`pk_id`),
    INDEX `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

