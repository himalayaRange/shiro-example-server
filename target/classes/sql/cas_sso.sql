/*
Navicat MySQL Data Transfer

Source Server         : 174_local
Source Server Version : 50622
Source Host           : 192.168.1.174:3306
Source Database       : cas_sso

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2016-09-22 17:22:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `auth_function`
-- ----------------------------
DROP TABLE IF EXISTS `auth_function`;
CREATE TABLE `auth_function` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `parent_id` bigint(20) NOT NULL,
  `url` varchar(128) NOT NULL,
  `serial_num` int(11) NOT NULL,
  `accordion` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_function
-- ----------------------------

-- ----------------------------
-- Table structure for `auth_role`
-- ----------------------------
DROP TABLE IF EXISTS `auth_role`;
CREATE TABLE `auth_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_role
-- ----------------------------

-- ----------------------------
-- Table structure for `auth_role_function`
-- ----------------------------
DROP TABLE IF EXISTS `auth_role_function`;
CREATE TABLE `auth_role_function` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL,
  `function_id` bigint(20) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_role_function
-- ----------------------------

-- ----------------------------
-- Table structure for `auth_user`
-- ----------------------------
DROP TABLE IF EXISTS `auth_user`;
CREATE TABLE `auth_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `pwd` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_user
-- ----------------------------

-- ----------------------------
-- Table structure for `auth_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `auth_user_role`;
CREATE TABLE `auth_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for `oauth2_client`
-- ----------------------------
DROP TABLE IF EXISTS `oauth2_client`;
CREATE TABLE `oauth2_client` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '编号主键',
  `client_name` varchar(100) NOT NULL COMMENT '客户端名称',
  `client_id` varchar(100) NOT NULL COMMENT '客户端ID',
  `client_secret` varchar(100) NOT NULL COMMENT '客户端安全秘钥key',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `is_valid` tinyint(4) NOT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='客户端';

-- ----------------------------
-- Records of oauth2_client
-- ----------------------------
INSERT INTO `oauth2_client` VALUES ('1', 'chapter17-client', 'c1ebe466-1cdc-4bd3-ab69-77c3561b9dee', 'd8346ea2-6017-43ed-ad68-19c0f971738b', '2016-09-08 00:00:00', '2016-09-08 00:00:00', '1');

-- ----------------------------
-- Table structure for `oauth2_user`
-- ----------------------------
DROP TABLE IF EXISTS `oauth2_user`;
CREATE TABLE `oauth2_user` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '编号，主键',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `salt` varchar(50) NOT NULL COMMENT '盐值',
  `create_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_date` timestamp NULL DEFAULT NULL,
  `is_valid` tinyint(1) NOT NULL COMMENT '是否有效 1.有效 0.无效',
  PRIMARY KEY (`id`),
  KEY `index_id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of oauth2_user
-- ----------------------------
INSERT INTO `oauth2_user` VALUES ('1', 'admin', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', '2016-09-08 00:00:00', '2016-09-08 00:00:00', '1');

-- ----------------------------
-- Table structure for `seckill`
-- ----------------------------
DROP TABLE IF EXISTS `seckill`;
CREATE TABLE `seckill` (
  `seckill_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品库存ID',
  `name` varchar(120) NOT NULL COMMENT '商品名称',
  `number` int(11) NOT NULL COMMENT '库存数量',
  `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '秒杀开始时间',
  `end_time` datetime NOT NULL COMMENT '秒杀结束时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`seckill_id`),
  KEY `idx_start_time` (`start_time`),
  KEY `idx_end_time` (`end_time`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=utf8 COMMENT='秒杀库存表';

-- ----------------------------
-- Records of seckill
-- ----------------------------
INSERT INTO `seckill` VALUES ('1000', '1000元秒杀iphone6', '97', '2016-06-02 22:43:45', '2016-11-02 00:00:00', '2016-05-28 22:06:21');
INSERT INTO `seckill` VALUES ('1001', '800元秒杀ipad', '189', '2016-06-03 16:44:59', '2016-11-02 00:00:00', '2016-05-28 22:06:21');
INSERT INTO `seckill` VALUES ('1002', '6600元秒杀mac book pro', '296', '2016-06-02 10:29:04', '2016-11-02 00:00:00', '2016-05-28 22:06:21');
INSERT INTO `seckill` VALUES ('1003', '7000元秒杀iMac', '400', '2016-05-25 00:00:00', '2016-05-28 00:00:00', '2016-05-28 22:06:21');

-- ----------------------------
-- Table structure for `success_killed`
-- ----------------------------
DROP TABLE IF EXISTS `success_killed`;
CREATE TABLE `success_killed` (
  `seckill_id` bigint(20) NOT NULL COMMENT '秒杀商品ID',
  `user_phone` bigint(20) NOT NULL COMMENT '用户手机号',
  `state` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态标识:-1:无效 0:成功 1:已付款 2:已发货',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`seckill_id`,`user_phone`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='秒杀成功明细表';

-- ----------------------------
-- Records of success_killed
-- ----------------------------
INSERT INTO `success_killed` VALUES ('1000', '13127636621', '0', '2016-05-28 22:12:10');
INSERT INTO `success_killed` VALUES ('1000', '18256007528', '0', '2016-05-28 22:41:54');
INSERT INTO `success_killed` VALUES ('1000', '18256007529', '0', '2016-05-28 22:43:45');
INSERT INTO `success_killed` VALUES ('1001', '13127636621', '0', '2016-05-28 22:13:20');
INSERT INTO `success_killed` VALUES ('1001', '13128636628', '0', '2016-06-03 16:45:51');
INSERT INTO `success_killed` VALUES ('1001', '13256007529', '0', '2016-05-31 14:19:47');
INSERT INTO `success_killed` VALUES ('1001', '13656564116', '0', '2016-05-31 17:46:07');
INSERT INTO `success_killed` VALUES ('1001', '13656564229', '0', '2016-06-02 10:29:44');
INSERT INTO `success_killed` VALUES ('1001', '18256007528', '0', '2016-05-28 22:17:08');
INSERT INTO `success_killed` VALUES ('1001', '18256007529', '0', '2016-05-28 22:43:54');
INSERT INTO `success_killed` VALUES ('1001', '18656564259', '0', '2016-06-01 14:49:55');
INSERT INTO `success_killed` VALUES ('1002', '13127636621', '0', '2016-05-31 11:13:32');
INSERT INTO `success_killed` VALUES ('1002', '13256007529', '0', '2016-05-31 14:19:59');
INSERT INTO `success_killed` VALUES ('1002', '13656564116', '0', '2016-05-31 17:46:51');
INSERT INTO `success_killed` VALUES ('1002', '13656564229', '0', '2016-06-02 10:29:57');

-- ----------------------------
-- Table structure for `sys_app`
-- ----------------------------
DROP TABLE IF EXISTS `sys_app`;
CREATE TABLE `sys_app` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '应用名称',
  `app_key` varchar(100) DEFAULT NULL COMMENT '应用Key,唯一',
  `app_secret` varchar(100) DEFAULT NULL COMMENT '应用安全码',
  `available` tinyint(1) DEFAULT '0' COMMENT '是否锁定',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_app_app_key` (`app_key`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='应用表';

-- ----------------------------
-- Records of sys_app
-- ----------------------------
INSERT INTO `sys_app` VALUES ('1', '中心服务器', '645ba616-370a-43a8-a8e0-993e7a590cf0', 'bb74abb6-bae0-47dd-a7b1-9571ea3a0f33', '1');
INSERT INTO `sys_app` VALUES ('2', 'APP-1', '645ba612-370a-43a8-a8e0-993e7a590cf0', 'bb74abb2-bae0-47dd-a7b1-9571ea3a0f33', '1');
INSERT INTO `sys_app` VALUES ('3', 'APP-2', '645ba613-370a-43a8-a8e0-993e7a590cf0', 'bb74abb3-bae0-47dd-a7b1-9571ea3a0f33', '1');

-- ----------------------------
-- Table structure for `sys_dic`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dic`;
CREATE TABLE `sys_dic` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `dic_code` varchar(50) NOT NULL COMMENT '字典code',
  `dic_value` int(3) unsigned NOT NULL COMMENT '字典值',
  `dic_label` varchar(200) DEFAULT NULL COMMENT '字典名称',
  `orders` int(3) unsigned DEFAULT NULL COMMENT '选项排序',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新建时间',
  `update_date` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `is_valid` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=371 DEFAULT CHARSET=utf8 COMMENT='字段表';

-- ----------------------------
-- Records of sys_dic
-- ----------------------------
INSERT INTO `sys_dic` VALUES ('1', 'user_status', '1', '启用', '1', '2016-08-30 10:30:43', '2016-08-30 10:30:43', '1');
INSERT INTO `sys_dic` VALUES ('2', 'user_status', '0', '禁用', '2', '2016-08-30 10:31:12', '2016-08-30 10:31:12', '1');
INSERT INTO `sys_dic` VALUES ('364', 'sys_status', '1', '正常', '0', '2016-08-30 14:26:36', '2016-08-30 14:27:45', '1');
INSERT INTO `sys_dic` VALUES ('365', 'sys_status', '0', '异常', '1', '2016-08-30 14:28:00', '2016-08-31 10:12:20', '1');
INSERT INTO `sys_dic` VALUES ('369', 'menu_status', '1', '正常', '0', '2016-08-31 10:05:39', '2016-08-31 10:06:47', '1');
INSERT INTO `sys_dic` VALUES ('370', 'menu_status', '0', '异常', '1', '2016-08-31 10:06:18', '2016-08-31 10:07:26', '1');

-- ----------------------------
-- Table structure for `sys_dic_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dic_menu`;
CREATE TABLE `sys_dic_menu` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `dic_code` varchar(50) NOT NULL COMMENT '字典code',
  `dic_name` varchar(200) DEFAULT NULL COMMENT '字典菜单名称',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新建时间',
  `update_date` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `is_valid` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=364 DEFAULT CHARSET=utf8 COMMENT='字典菜单表';

-- ----------------------------
-- Records of sys_dic_menu
-- ----------------------------
INSERT INTO `sys_dic_menu` VALUES ('1', 'user_status', '用户状态', '2016-08-30 18:42:38', '2016-08-30 18:42:38', '1');
INSERT INTO `sys_dic_menu` VALUES ('2', 'sys_status', '系统状态', '2016-08-30 18:42:56', '2016-08-30 18:42:56', '1');
INSERT INTO `sys_dic_menu` VALUES ('363', 'menu_status', '菜单状态', '2016-08-30 19:35:59', '2016-08-30 21:36:03', '1');

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `parentId` int(11) NOT NULL COMMENT '父节点',
  `name` varchar(64) NOT NULL COMMENT '节点名称',
  `open` tinyint(1) NOT NULL DEFAULT '0' COMMENT '节点是否展开',
  `iconSkin` varchar(64) DEFAULT NULL COMMENT '自定义图标',
  `url` varchar(200) DEFAULT NULL COMMENT 'URL',
  `target` varchar(32) NOT NULL DEFAULT '_blank' COMMENT '打开方式',
  `isHidden` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否隐藏',
  `isParent` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否为父节点： 0 叶子节点  1父节点',
  `orders` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新建时间',
  `update_date` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `is_valid` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='系统菜单表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '0', '菜单根节点', '1', 'pIcon01', null, '_blank', '0', '1', '0', '2016-08-31 15:10:04', '2016-08-31 15:10:04', '1');
INSERT INTO `sys_menu` VALUES ('2', '1', '管理员管理', '0', null, '', '_blank', '0', '1', '0', '2016-08-31 15:20:10', '2016-08-31 15:20:10', '1');
INSERT INTO `sys_menu` VALUES ('3', '1', '系统管理', '0', null, null, '_blank', '0', '1', '0', '2016-08-31 15:20:44', '2016-08-31 15:20:44', '1');
INSERT INTO `sys_menu` VALUES ('4', '2', '管理员列表', '0', 'icon02', 'https://baidu.com', '_blank', '0', '0', '0', '2016-08-31 15:21:40', '2016-09-01 14:38:57', '1');
INSERT INTO `sys_menu` VALUES ('5', '2', '角色管理', '0', 'icon02', '', '_blank', '0', '0', '1', '2016-08-31 15:22:29', '2016-09-01 14:39:03', '1');
INSERT INTO `sys_menu` VALUES ('6', '2', '权限管理', '0', 'icon02', '', '_blank', '0', '0', '2', '2016-08-31 15:22:53', '2016-09-01 14:39:10', '1');
INSERT INTO `sys_menu` VALUES ('7', '3', '系统监控', '0', 'icon01', '', '_blank', '0', '0', '0', '2016-08-31 15:23:58', '2016-09-01 14:39:35', '1');
INSERT INTO `sys_menu` VALUES ('8', '3', '数据字典', '0', null, null, '_blank', '0', '1', '1', '2016-08-31 15:24:47', '2016-08-31 15:24:47', '1');
INSERT INTO `sys_menu` VALUES ('9', '8', '字典菜单', '0', 'icon06', '', '_blank', '0', '0', '0', '2016-08-31 15:25:09', '2016-09-01 14:40:04', '1');
INSERT INTO `sys_menu` VALUES ('10', '8', '字典详情', '0', 'icon06', '', '_blank', '0', '0', '1', '2016-08-31 15:25:30', '2016-09-01 14:40:20', '1');
INSERT INTO `sys_menu` VALUES ('11', '3', '菜单管理', '0', 'icon01', '', '_blank', '0', '0', '1', '2016-08-31 15:25:50', '2016-09-01 14:39:45', '1');
INSERT INTO `sys_menu` VALUES ('13', '3', '系统设置', '0', 'icon07', '', '_blank', '0', '0', '0', '2016-09-01 11:24:15', '2016-09-01 14:34:58', '1');
INSERT INTO `sys_menu` VALUES ('14', '2', '客户端管理', '0', 'icon06', '', '_blank', '0', '0', '0', '2016-09-12 13:37:14', '2016-09-12 13:37:14', '1');
INSERT INTO `sys_menu` VALUES ('15', '2', '会话管理', '0', 'icon01', '', '_blank', '0', '0', '0', '2016-09-21 18:44:30', '2016-09-21 18:44:58', '1');

-- ----------------------------
-- Table structure for `sys_user_app_roles`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_app_roles`;
CREATE TABLE `sys_user_app_roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '所属用户',
  `app_id` bigint(20) DEFAULT NULL COMMENT '所属应用',
  `role_ids` varchar(100) DEFAULT NULL COMMENT '角色列表',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_user_app_roles_user_id_app_id` (`user_id`,`app_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='应用授权表';

-- ----------------------------
-- Records of sys_user_app_roles
-- ----------------------------
INSERT INTO `sys_user_app_roles` VALUES ('1', '1', '1', '1');
INSERT INTO `sys_user_app_roles` VALUES ('2', '1', '2', '1,2');
INSERT INTO `sys_user_app_roles` VALUES ('3', '1', '3', '1,3');

-- ----------------------------
-- Table structure for `t_resources`
-- ----------------------------
DROP TABLE IF EXISTS `t_resources`;
CREATE TABLE `t_resources` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(32) DEFAULT NULL COMMENT '资源名称',
  `permission` varchar(32) DEFAULT NULL COMMENT '权限',
  `url` varchar(32) DEFAULT NULL COMMENT 'url',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of t_resources
-- ----------------------------
INSERT INTO `t_resources` VALUES ('1', '系统管理', '', '/admin/**');
INSERT INTO `t_resources` VALUES ('2', '用户管理', null, '/admin/user/*');
INSERT INTO `t_resources` VALUES ('3', '用户添加', null, '/admin/user/add');
INSERT INTO `t_resources` VALUES ('4', '用户更新', '', '/admin/user/update');
INSERT INTO `t_resources` VALUES ('5', '角色管理', null, '/admin/role/*');
INSERT INTO `t_resources` VALUES ('6', '角色添加', null, '/admin/role/add');
INSERT INTO `t_resources` VALUES ('7', '角色修改', '', '/admin/role/update');
INSERT INTO `t_resources` VALUES ('8', '资源管理', '/res/*', '/admin/res/*');
INSERT INTO `t_resources` VALUES ('9', '资源添加', 'res:add:*', '/admin/res/add');
INSERT INTO `t_resources` VALUES ('10', '资源更新', '', '/admin/res/update');
INSERT INTO `t_resources` VALUES ('11', '菜单管理', '', '/admin/sys/menu/*');
INSERT INTO `t_resources` VALUES ('12', '字典管理', '', '/admin/sys/dic/*');

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(32) NOT NULL COMMENT '角色名称',
  `sn` varchar(32) DEFAULT NULL COMMENT '角色的命名空间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '管理员', 'ADMIN');
INSERT INTO `t_role` VALUES ('2', '管理员测试', 'USER');
INSERT INTO `t_role` VALUES ('3', '角色测试', 'ROLE');
INSERT INTO `t_role` VALUES ('5', '资源测试', 'RESOURCES');
INSERT INTO `t_role` VALUES ('6', '访客', 'GUEST');
INSERT INTO `t_role` VALUES ('7', '菜单管理员', 'MENU');
INSERT INTO `t_role` VALUES ('8', '字典管理员', 'SYS');

-- ----------------------------
-- Table structure for `t_role_res`
-- ----------------------------
DROP TABLE IF EXISTS `t_role_res`;
CREATE TABLE `t_role_res` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `roleId` int(11) DEFAULT NULL COMMENT '角色ID',
  `resId` int(11) DEFAULT NULL COMMENT '资源ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='角色权限表';

-- ----------------------------
-- Records of t_role_res
-- ----------------------------
INSERT INTO `t_role_res` VALUES ('1', '1', '1');
INSERT INTO `t_role_res` VALUES ('2', '2', '2');
INSERT INTO `t_role_res` VALUES ('3', '2', '3');
INSERT INTO `t_role_res` VALUES ('4', '2', '4');
INSERT INTO `t_role_res` VALUES ('10', '3', '5');
INSERT INTO `t_role_res` VALUES ('12', '5', '8');
INSERT INTO `t_role_res` VALUES ('16', '3', '6');
INSERT INTO `t_role_res` VALUES ('17', '3', '7');
INSERT INTO `t_role_res` VALUES ('18', '5', '9');
INSERT INTO `t_role_res` VALUES ('19', '5', '10');
INSERT INTO `t_role_res` VALUES ('20', '7', '11');
INSERT INTO `t_role_res` VALUES ('21', '8', '12');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `nickname` varchar(32) DEFAULT NULL COMMENT '昵称',
  `status` int(3) NOT NULL DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`),
  KEY `index_id` (`id`),
  KEY `index_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='用户主表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'zhangsan', '92eb2ebd555db284186a07025cb00e1c', '张三', '1');
INSERT INTO `t_user` VALUES ('2', 'admin', '88212f91e2e9cf36981a91b6c518af5c', '管理员', '1');
INSERT INTO `t_user` VALUES ('3', 'kh', 'e5c2b665a637ae59ac2bc8465490d1f0', '空号', '1');
INSERT INTO `t_user` VALUES ('5', 'wy', 'ee907c158ab2e14109d95c29e9c89081', '汪谊', '1');
INSERT INTO `t_user` VALUES ('6', 'laozhang', '24e914af8c35c0a92350927fa29b815d', '老张', '1');
INSERT INTO `t_user` VALUES ('7', 'guest', 'd180a942c97a9ebf50edefd508b46cb2', '外来访客', '1');
INSERT INTO `t_user` VALUES ('8', 'zimo', 'bbb89d7893e0fc8fa074d4a538dd7295', '子墨', '1');
INSERT INTO `t_user` VALUES ('9', 'laoding', '38e15ad1ca00c49747b0dd59da86321b', '老丁', '1');
INSERT INTO `t_user` VALUES ('12', 'ls', '61ffbb181b85da5a7978722d3c1e7d7e', '李四', '1');

-- ----------------------------
-- Table structure for `t_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `userId` int(11) DEFAULT NULL COMMENT '用户ID',
  `roleId` int(11) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '1', '2');
INSERT INTO `t_user_role` VALUES ('2', '2', '1');
INSERT INTO `t_user_role` VALUES ('3', '3', '3');
INSERT INTO `t_user_role` VALUES ('4', '6', '5');
INSERT INTO `t_user_role` VALUES ('5', '7', '6');
INSERT INTO `t_user_role` VALUES ('6', '5', '1');
INSERT INTO `t_user_role` VALUES ('7', '8', '7');
INSERT INTO `t_user_role` VALUES ('8', '10', '1');
INSERT INTO `t_user_role` VALUES ('9', '12', '1');
INSERT INTO `t_user_role` VALUES ('10', '9', '8');

-- ----------------------------
-- Procedure structure for `execute_seckill`
-- ----------------------------
DROP PROCEDURE IF EXISTS `execute_seckill`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `execute_seckill`(in v_seckill_id BIGINT,in v_phone BIGINT,
in v_kill_time TIMESTAMP,OUT r_result INTEGER)
BEGIN
	DECLARE insert_count int DEFAULT 0;
	START TRANSACTION;
	insert IGNORE  into  success_killed
	(seckill_id,user_phone,create_time)
	VALUES(v_seckill_id,v_phone,v_kill_time);
	select ROW_COUNT() into insert_count;
	IF(insert_count=0)THEN
	ROLLBACK;
  set r_result=-1;
  ELSEIF(insert_count<0)THEN
	ROLLBACK;
	set r_result=-2;
	else 
	update seckill 
	set number=number-1 
	where seckill_id=v_seckill_id 
	and end_time>v_kill_time 
	and start_time<v_kill_time 
	and number>0;
	select ROW_COUNT() INTO insert_count;
	IF(insert_count=0)THEN 
	ROLLBACK;
	set r_result=0;
	ELSEIF(insert_count<0)THEN
	ROLLBACK;
	set r_result=-2;
	ELSE
	COMMIT;
	set r_result=1;
	END IF;
	END IF;
END
;;
DELIMITER ;
