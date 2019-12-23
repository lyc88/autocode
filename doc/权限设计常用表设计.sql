/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : demo01

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2019-12-23 16:16:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_permissions
-- ----------------------------
DROP TABLE IF EXISTS `sys_permissions`;
CREATE TABLE `sys_permissions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `permission` varchar(100) NOT NULL COMMENT '权限编号',
  `description` varchar(100) NOT NULL COMMENT '权限描述',
  `rid` bigint(20) NOT NULL COMMENT '此权限关联角色的id',
  `type` varchar(50) NOT NULL COMMENT '类型 1 菜单 2 按钮',
  `url` varchar(200) NOT NULL COMMENT 'url',
  `sort` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '排序字段',
  `external` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否外部链接 1 是 0不是',
  `parent_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '父级id',
  `available` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否锁定',
  `icon` varchar(100) NOT NULL COMMENT '菜单图标',
  `create_time` datetime NOT NULL COMMENT '添加时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_permissions_permission` (`permission`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permissions
-- ----------------------------

-- ----------------------------
-- Table structure for sys_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_roles`;
CREATE TABLE `sys_roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `role` varchar(100) NOT NULL COMMENT '角色名称',
  `description` varchar(100) NOT NULL COMMENT '角色描述',
  `pid` bigint(20) NOT NULL COMMENT '父节点',
  `available` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否锁定',
  `create_time` datetime NOT NULL  COMMENT '添加时间',
  `update_time` datetime NOT NULL  COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_roles_role` (`role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_roles
-- ----------------------------

-- ----------------------------
-- Table structure for sys_roles_permissions
-- ----------------------------
DROP TABLE IF EXISTS `sys_roles_permissions`;
CREATE TABLE `sys_roles_permissions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role_id` bigint(20) NOT NULL COMMENT '角色编号',
  `permission_id` bigint(20) NOT NULL COMMENT '权限编号',
  `create_time` datetime NOT NULL  COMMENT '添加时间',
  `update_time` datetime NOT NULL  COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_roles_permissions
-- ----------------------------

-- ----------------------------
-- Table structure for sys_users
-- ----------------------------
DROP TABLE IF EXISTS `sys_users`;
CREATE TABLE `sys_users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `salt` varchar(100) NOT NULL COMMENT '盐值',
  `role_id` varchar(50) NOT NULL COMMENT '角色列表',
  `locked` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否锁定',
  `reg_ip` varchar(30) NOT NULL COMMENT '注册IP',
  `last_login_ip` varchar(30) NOT NULL COMMENT '最近登录IP',
  `last_login_time` datetime NOT NULL COMMENT '最近登录时间',
  `login_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '登录次数',
  `create_time` datetime NOT NULL  COMMENT '注册时间',
  `update_time` datetime NOT NULL  COMMENT '更新时间',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_users_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_users
-- ----------------------------

-- ----------------------------
-- Table structure for sys_users_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_users_roles`;
CREATE TABLE `sys_users_roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `role_id` bigint(20) NOT NULL COMMENT '角色编号',
  `create_time` datetime NOT NULL  COMMENT '添加时间',
  `update_time` datetime NOT NULL  COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_users_roles
-- ----------------------------
