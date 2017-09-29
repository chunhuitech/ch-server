mysql -h192.168.134.106 -P3306 -uadmin -padmin123 --default-character-set=utf8mb4 -A

CREATE DATABASE `ch_xf` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
use ch_xf;
CREATE TABLE `xf_school` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL COMMENT '名称',
  `description` varchar(256) NOT NULL DEFAULT '',
  `modify_time` bigint(20) NOT NULL,
  `create_time` bigint(20) NOT NULL,
  `status` tinyint(4) NOT NULL COMMENT '0:可用 1删除',
  PRIMARY KEY (`id`)
);

-- INSERT INTO `xf_school`
-- (`id`,
-- `name`,
-- `description`,
-- `modify_time`,
-- `create_time`,
-- `status`)
-- VALUES
-- (1,
-- '北京大学',
-- '海淀区',
-- UNIX_TIMESTAMP(now(3))*1000,
-- UNIX_TIMESTAMP(now(3))*1000,
-- 0);

