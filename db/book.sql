/*
MySQL Data Transfer
Source Host: localhost
Source Database: crud
Target Host: localhost
Target Database: crud
Date: 11/11/2013 12:23:27 PM
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `no` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `price` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `book` VALUES ('2', 'N0002', '政治', '23.1');
INSERT INTO `book` VALUES ('4', 'N0004', '计算机', '54.4');
INSERT INTO `book` VALUES ('6', 'N0008', '小时代3', '34.6');
