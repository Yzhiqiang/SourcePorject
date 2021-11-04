/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : vueblog

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 02/11/2021 19:18:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sortdata
-- ----------------------------
DROP TABLE IF EXISTS `sortdata`;
CREATE TABLE `sortdata`  (
  `values` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `sorted_values` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sortdata
-- ----------------------------
INSERT INTO `sortdata` VALUES ('1 3 45 56 6 2', 2, '1 2 3 6 45 56 ');
INSERT INTO `sortdata` VALUES ('1 3 45 56 6 2', 3, '1 2 3 6 45 56 ');
INSERT INTO `sortdata` VALUES ('1 3 45 56 6 2', 4, '1 2 3 6 45 56 ');

SET FOREIGN_KEY_CHECKS = 1;
