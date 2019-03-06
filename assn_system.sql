/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost:3306
 Source Schema         : assn_system

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 06/03/2019 15:15:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for apply_table
-- ----------------------------
DROP TABLE IF EXISTS `apply_table`;
CREATE TABLE `apply_table`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '负责人ID：user_id',
  `association_id` bigint(20) DEFAULT NULL,
  `department_id` bigint(20) DEFAULT NULL COMMENT '部门ID：department_id',
  `content` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '介绍:content',
  `apply_time` datetime(0) DEFAULT NULL COMMENT '创建时间：create_time',
  `state` int(11) DEFAULT NULL COMMENT '状态(0申请中,1通过,2未通过):state',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '申请表：apply_table' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for association_activity_table
-- ----------------------------
DROP TABLE IF EXISTS `association_activity_table`;
CREATE TABLE `association_activity_table`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `association_id` bigint(20) DEFAULT NULL COMMENT '社团名称：association_name',
  `activity_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '社团名称：association_name',
  `user_id` bigint(20) DEFAULT NULL COMMENT '负责人ID：user_id',
  `content` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '介绍:content',
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '地址：address',
  `image` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图片：image',
  `score` double DEFAULT NULL,
  `start_time` datetime(0) DEFAULT NULL COMMENT '创建时间：create_time',
  `end_time` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '社团活动表association_activity_table' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for association_table
-- ----------------------------
DROP TABLE IF EXISTS `association_table`;
CREATE TABLE `association_table`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `association_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '社团名称：association_name',
  `user_id` bigint(20) DEFAULT NULL COMMENT '负责人ID：user_id',
  `content` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '介绍:content',
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '地址：address',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间：create_time',
  `recruit_state` int(11) DEFAULT NULL COMMENT '招募状态：recruit_state',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '社团表association_table' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for department_table
-- ----------------------------
DROP TABLE IF EXISTS `department_table`;
CREATE TABLE `department_table`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `association_id` bigint(20) DEFAULT NULL COMMENT '社团名称：association_id',
  `minister_user_id` bigint(20) DEFAULT NULL COMMENT '负责人ID：user_id',
  `department_name` bigint(20) DEFAULT NULL,
  `content` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '介绍:content',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间：create_time',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '部门表department_table' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for identity_table
-- ----------------------------
DROP TABLE IF EXISTS `identity_table`;
CREATE TABLE `identity_table`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `identity_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '身份名称：identity_name',
  `level` bigint(20) DEFAULT NULL COMMENT '等级:level',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '身份表identity_table' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of identity_table
-- ----------------------------
INSERT INTO `identity_table` VALUES (1, '系统管理员', 0);
INSERT INTO `identity_table` VALUES (2, '社团管理员', 1);
INSERT INTO `identity_table` VALUES (3, '社团成员', 2);
INSERT INTO `identity_table` VALUES (4, '普通用户', 3);

-- ----------------------------
-- Table structure for notice_table
-- ----------------------------
DROP TABLE IF EXISTS `notice_table`;
CREATE TABLE `notice_table`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '发布人ID：user_id',
  `content` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '公告内容:content',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间：create_time',
  `type` int(11) DEFAULT NULL COMMENT '类型(0系统公告,1社团公告)：type',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '公告表notice_table' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_activity_table
-- ----------------------------
DROP TABLE IF EXISTS `user_activity_table`;
CREATE TABLE `user_activity_table`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '人员ID：user_id',
  `association_id` bigint(20) DEFAULT NULL COMMENT '社团ID:association_id',
  `department_id` bigint(20) DEFAULT NULL,
  `activity_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '人员活动中间表：user_activity_table' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_table
-- ----------------------------
DROP TABLE IF EXISTS `user_table`;
CREATE TABLE `user_table`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `identity_id` bigint(20) DEFAULT NULL COMMENT '身份ID=>identity->id:identity_id',
  `major` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '专业:major',
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户名:user_name',
  `pwd` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '密码：pwd',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '姓名：name',
  `sex` tinyint(4) DEFAULT NULL COMMENT '性别：sex',
  `age` int(11) DEFAULT NULL COMMENT '年龄：age',
  `job` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '职务：job',
  `tel_number` bigint(20) DEFAULT NULL COMMENT '联系方式:tel_number',
  `grade` int(11) DEFAULT NULL COMMENT '年级:grade',
  `user_img` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图片:user_img',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表user_table' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
