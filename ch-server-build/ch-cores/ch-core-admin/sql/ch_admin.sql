mysql -h127.0.0.1 -P3306 -uroot -padmin123 --default-character-set=utf8mb4 -A

CREATE DATABASE `ch_admin` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
use ch_admin;
CREATE TABLE `admin_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `token` varchar(50) NOT NULL,
  `nickname` varchar(50) NOT NULL,
  `avatar` varchar(300) NOT NULL DEFAULT '',
  `email` varchar(50) NOT NULL,
  `qq` varchar(45) NOT NULL DEFAULT '',
  `weixin` varchar(45) NOT NULL DEFAULT '',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0 正常　１ 删除  2 禁止登录',
  `des` varchar(200) NOT NULL DEFAULT ' ',
  `modify_time` bigint(20) NOT NULL,
  `create_time` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_name` (`username`),
  UNIQUE KEY `idx_token` (`token`)
)

SET SQL_SAFE_UPDATES = 0;
update user set password=MD5(password);
SET SQL_SAFE_UPDATES = 1;

CREATE TABLE `admin_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `system_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `des` varchar(200) DEFAULT ' ',
  PRIMARY KEY (`id`)
);

CREATE TABLE `admin_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_user_role` (`user_id`,`role_id`)
);

CREATE TABLE `admin_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `system_id` int(11) NOT NULL COMMENT '系统ID',
  `name` varchar(45) NOT NULL COMMENT '名称',
  `index_path` varchar(45) NOT NULL COMMENT 'menu唯一标志',
  `route` varchar(1024) NOT NULL,
  `icon` varchar(128) DEFAULT NULL COMMENT '图标',
  `res_url` varchar(128) DEFAULT NULL COMMENT '链接',
  `seq` int(11) NOT NULL COMMENT '顺序',
  `des` varchar(200) DEFAULT ' ',
  `status` tinyint(4) NOT NULL COMMENT '状态',
  `modify_time` bigint(20) NOT NULL,
  `create_time` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `admin_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `menu_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ;

CREATE TABLE `admin_system` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `des` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `admin_user_system` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `system_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
);


