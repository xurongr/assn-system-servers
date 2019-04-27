/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost:3306
 Source Schema         : assn_system

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 27/04/2019 17:39:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for apply_table
-- ----------------------------
DROP TABLE IF EXISTS `apply_table`;
CREATE TABLE `apply_table`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '负责人ID：user_id',
  `association_id` bigint(20) NULL DEFAULT NULL,
  `department_id` bigint(20) NULL DEFAULT NULL COMMENT '部门ID：department_id',
  `content` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '介绍:content',
  `apply_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间：create_time',
  `state` int(11) NULL DEFAULT NULL COMMENT '状态(0申请中,1通过,2未通过):state',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '申请表：apply_table' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for association_activity_table
-- ----------------------------
DROP TABLE IF EXISTS `association_activity_table`;
CREATE TABLE `association_activity_table`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `association_id` bigint(20) NULL DEFAULT NULL COMMENT '社团名称：association_name',
  `activity_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '社团名称：association_name',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '负责人ID：user_id',
  `content` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '介绍:content',
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地址：address',
  `image` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片：image',
  `score` double NULL DEFAULT NULL,
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间：create_time',
  `end_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '社团活动表association_activity_table' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of association_activity_table
-- ----------------------------
INSERT INTO `association_activity_table` VALUES (2, 0, 'string', 0, 'string', 'string', 'string', 0, '1970-01-19 08:00:43', '2019-04-14 19:57:51');
INSERT INTO `association_activity_table` VALUES (3, 0, 'string', 0, 'string', 'string', 'string', 0, '1970-01-19 08:00:43', '2019-04-14 19:57:51');
INSERT INTO `association_activity_table` VALUES (4, 0, 'string', 0, 'string', 'string', 'string', 0, '1970-01-19 08:00:43', '1970-01-19 08:00:43');
INSERT INTO `association_activity_table` VALUES (5, 0, 'string', 0, 'string', 'string', 'string', 0, '2019-04-14 19:57:51', '2019-04-14 19:57:51');
INSERT INTO `association_activity_table` VALUES (6, 0, 'string', 0, 'string', 'string', 'string', 0, '2019-04-14 19:57:51', '2019-04-14 19:57:51');
INSERT INTO `association_activity_table` VALUES (7, 0, 'string', 0, 'string', 'string', 'string', 0, '1970-01-19 08:00:43', '1970-01-19 08:00:44');
INSERT INTO `association_activity_table` VALUES (8, 0, 'string', 0, 'string', 'string', 'string', 0, '2019-04-14 19:58:08', '2019-04-14 20:21:11');

-- ----------------------------
-- Table structure for association_table
-- ----------------------------
DROP TABLE IF EXISTS `association_table`;
CREATE TABLE `association_table`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `association_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '社团名称：association_name',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '负责人ID：user_id',
  `content` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '介绍:content',
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地址：address',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间：create_time',
  `recruit_state` int(11) NULL DEFAULT NULL COMMENT '招募状态：recruit_state',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '社团表association_table' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of association_table
-- ----------------------------
INSERT INTO `association_table` VALUES (1, '计算机协会', 1, '致力于用专业学到的知识帮助同学们解决与计算机有关的问题', '求是楼', '2019-03-09 20:15:10', 0);
INSERT INTO `association_table` VALUES (2, '青年志愿者协会', NULL, '致力于志愿服务的大学生团队1', '女生宿舍里一楼右侧2n110', '2019-03-10 05:15:17', 0);
INSERT INTO `association_table` VALUES (3, '后山夜校', NULL, '三十载风雨兼程；三十载春华秋实；三十载沧桑巨变。后山夜校坚持教育扶贫已经三十年。后山夜校是校团委于1987年成立的一所义务支教学校，坚持了30年的教学。在每周一至周五晚及周末的早上为后山畲族村周边中小学生义教，发展至今变为了集课业辅导、兴趣培训、人文教育为一体的特色教学基地。', '宁德师范学院', '2019-03-15 18:39:21', 0);
INSERT INTO `association_table` VALUES (4, 'string', 0, 'string', 'string', '2019-03-15 18:44:38', 0);
INSERT INTO `association_table` VALUES (5, '后山夜校', 4, '后山夜校是校团委于1987年成立的一所义务支教学校，坚持了30年的教学。在每周一至周五晚及周末的早上为后山畲族村周边中小学生义教，发展至今变为了集课业辅导、兴趣培训、人文教育为一体的特色教学基地。', '宁德师范学院', '2019-03-16 01:39:08', 0);
INSERT INTO `association_table` VALUES (6, '潮音文学社', 4, '3333333333333333333333', '3333', '2019-03-16 01:42:36', 1);
INSERT INTO `association_table` VALUES (7, 'string', 0, 'string', 'string', '2019-03-16 01:44:40', 0);
INSERT INTO `association_table` VALUES (8, 'g', 0, 'g', 'g', '2019-03-16 01:46:07', 0);
INSERT INTO `association_table` VALUES (9, 'string', 0, 'string', 'string', '2019-04-14 19:58:08', 0);

-- ----------------------------
-- Table structure for department_table
-- ----------------------------
DROP TABLE IF EXISTS `department_table`;
CREATE TABLE `department_table`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `association_id` bigint(20) NULL DEFAULT NULL COMMENT '社团名称：association_id',
  `minister_user_id` bigint(20) NULL DEFAULT NULL COMMENT '负责人ID：user_id',
  `department_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `content` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '介绍:content',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间：create_time',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '部门表department_table' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department_table
-- ----------------------------
INSERT INTO `department_table` VALUES (2, 1, 7, '11', '11', '2019-04-13 00:02:33');
INSERT INTO `department_table` VALUES (3, 3, 0, 'string', 'string', '1970-01-19 08:00:43');

-- ----------------------------
-- Table structure for identity_table
-- ----------------------------
DROP TABLE IF EXISTS `identity_table`;
CREATE TABLE `identity_table`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `identity_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份名称：identity_name',
  `level` bigint(20) NULL DEFAULT NULL COMMENT '等级:level',
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
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '发布人ID：user_id',
  `association_id` bigint(20) NULL DEFAULT NULL COMMENT '社团ID：association_id',
  `content` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '公告内容:content',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间：create_time',
  `type` int(11) NULL DEFAULT NULL COMMENT '类型(0系统公告,1社团公告)：type',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '公告表notice_table' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice_table
-- ----------------------------
INSERT INTO `notice_table` VALUES (1, NULL, 1, NULL, '社团管理系统旨在于更好的服务于学校和学生', '2019-03-10 23:03:43', 0);
INSERT INTO `notice_table` VALUES (2, NULL, 1, NULL, '测试测试测试', '2019-03-10 23:11:39', 1);
INSERT INTO `notice_table` VALUES (3, 'string', 0, 0, 'string', '1970-01-19 07:43:56', 0);

-- ----------------------------
-- Table structure for user_activity_table
-- ----------------------------
DROP TABLE IF EXISTS `user_activity_table`;
CREATE TABLE `user_activity_table`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '人员ID：user_id',
  `association_id` bigint(20) NULL DEFAULT NULL COMMENT '社团ID:association_id',
  `department_id` bigint(20) NULL DEFAULT 0 COMMENT '部门ID:department_id',
  `activity_id` bigint(20) NULL DEFAULT 0 COMMENT '活动ID：activity_id',
  `job` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '职务：job',
  `identity_id` bigint(20) NULL DEFAULT 2 COMMENT '身份ID:identity_id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '人员活动中间表：user_activity_table' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_activity_table
-- ----------------------------
INSERT INTO `user_activity_table` VALUES (9, 7, 1, 0, 0, NULL, 2);
INSERT INTO `user_activity_table` VALUES (10, 7, 1, 0, 0, NULL, 2);
INSERT INTO `user_activity_table` VALUES (11, 7, 1, 0, 0, NULL, 2);
INSERT INTO `user_activity_table` VALUES (13, 7, 1, 1, 0, NULL, 2);
INSERT INTO `user_activity_table` VALUES (14, 7, 1, 2, 0, NULL, 2);

-- ----------------------------
-- Table structure for user_table
-- ----------------------------
DROP TABLE IF EXISTS `user_table`;
CREATE TABLE `user_table`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `major` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '专业:major',
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名:user_name',
  `pwd` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码：pwd',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名：name',
  `sex` tinyint(4) NULL DEFAULT NULL COMMENT '性别：sex',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄：age',
  `tel_number` bigint(20) NULL DEFAULT NULL COMMENT '联系方式:tel_number',
  `grade` int(11) NULL DEFAULT NULL COMMENT '年级:grade',
  `user_img` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片:user_img',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表user_table' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_table
-- ----------------------------
INSERT INTO `user_table` VALUES (1, '', 'NDSFXY', '111111', '徐徐', 2, 18, 17705032963, 0, NULL);
INSERT INTO `user_table` VALUES (3, '', 'B2015102201', '111111', '张三', 0, 20, 17705032963, 2015, '');
INSERT INTO `user_table` VALUES (4, NULL, 'admin', 'admin', 'admin', 0, NULL, NULL, NULL, NULL);
INSERT INTO `user_table` VALUES (5, 'string', '111111', '111111', '111111', 0, 0, 0, 0, NULL);
INSERT INTO `user_table` VALUES (6, '计算机科学与技术', 'B2015102202', '123456', '张三', NULL, 18, NULL, NULL, NULL);
INSERT INTO `user_table` VALUES (7, '1', 'B2015102203', '1', '1', 1, 1, 1111, 1, '');
INSERT INTO `user_table` VALUES (8, '中文系', 'B2015102204', 'iajsd', '艳艳', 2, 22, 18873838384, 2016, '');
INSERT INTO `user_table` VALUES (9, '计算机科学与技术', 'B2015102210', '123456', '徐蓉蓉', 2, 22, 17705032963, 2015, '');
INSERT INTO `user_table` VALUES (10, 'gffg', 'sjjhdd', 'dddd', 'fdg', 1, 14, 14455445445, NULL, '');
INSERT INTO `user_table` VALUES (11, '', 'defsdf', 'ff', 'dfdf', 1, NULL, NULL, NULL, '');
INSERT INTO `user_table` VALUES (12, '', 'fffff', 'fff', 'fff', NULL, NULL, NULL, NULL, '');
INSERT INTO `user_table` VALUES (13, '', 'aaaa', 'aaaa', '', NULL, NULL, NULL, NULL, '');

SET FOREIGN_KEY_CHECKS = 1;
