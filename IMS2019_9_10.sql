/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : ssmcrud

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-09-10 21:23:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for disk_send
-- ----------------------------
DROP TABLE IF EXISTS `disk_send`;
CREATE TABLE `disk_send` (
  `send_id` int(11) NOT NULL AUTO_INCREMENT,
  `send_name` varchar(255) DEFAULT NULL,
  `send_num` varchar(255) DEFAULT NULL,
  `d_id` int(11) DEFAULT NULL,
  `receive_name` varchar(255) DEFAULT NULL,
  `send_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`send_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of disk_send
-- ----------------------------
INSERT INTO `disk_send` VALUES ('1', '张三', '1', '1', '李四', '2019-09-05 00:00:00');
INSERT INTO `disk_send` VALUES ('2', '王五', '2', '2', '刘六', '2019-09-06 00:00:00');
INSERT INTO `disk_send` VALUES ('3', '啊啊啊', null, '1', null, '2019-09-05 22:58:19');
INSERT INTO `disk_send` VALUES ('4', '不不不', null, '1', null, '2019-09-05 22:58:47');
INSERT INTO `disk_send` VALUES ('5', null, null, '1', null, '2019-09-05 23:50:30');
INSERT INTO `disk_send` VALUES ('6', null, null, '1', null, '2019-09-05 23:51:34');
INSERT INTO `disk_send` VALUES ('7', null, null, '1', null, '2019-09-05 23:51:47');
INSERT INTO `disk_send` VALUES ('8', null, null, '1', null, '2019-09-06 00:05:04');
INSERT INTO `disk_send` VALUES ('9', null, null, '1', null, '2019-09-06 00:11:53');
INSERT INTO `disk_send` VALUES ('10', null, null, '1', null, '2019-09-06 00:23:37');
INSERT INTO `disk_send` VALUES ('11', null, null, '1', null, '2019-09-06 00:24:56');
INSERT INTO `disk_send` VALUES ('12', null, null, '1', null, '2019-09-08 16:20:44');
INSERT INTO `disk_send` VALUES ('13', null, null, '2', null, '2019-09-08 16:30:55');
INSERT INTO `disk_send` VALUES ('14', '让人', '3', '2', '天天', '2019-09-08 17:22:04');

-- ----------------------------
-- Table structure for tbl_dept
-- ----------------------------
DROP TABLE IF EXISTS `tbl_dept`;
CREATE TABLE `tbl_dept` (
  `dept_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(255) NOT NULL,
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tbl_dept
-- ----------------------------
INSERT INTO `tbl_dept` VALUES ('1', '遥感数据加工中心');
INSERT INTO `tbl_dept` VALUES ('2', '信息提取与研发中心');
INSERT INTO `tbl_dept` VALUES ('3', '财务部');
INSERT INTO `tbl_dept` VALUES ('4', '航天世景');
INSERT INTO `tbl_dept` VALUES ('5', '后勤保洁');
INSERT INTO `tbl_dept` VALUES ('6', '后勤保安');

-- ----------------------------
-- Table structure for tbl_desn
-- ----------------------------
DROP TABLE IF EXISTS `tbl_desn`;
CREATE TABLE `tbl_desn` (
  `destination_id` int(11) NOT NULL AUTO_INCREMENT,
  `destination_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`destination_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_desn
-- ----------------------------
INSERT INTO `tbl_desn` VALUES ('1', '北京');
INSERT INTO `tbl_desn` VALUES ('2', '山东');

-- ----------------------------
-- Table structure for tbl_emp
-- ----------------------------
DROP TABLE IF EXISTS `tbl_emp`;
CREATE TABLE `tbl_emp` (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(255) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `d_id` int(11) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `g_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`emp_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4026 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tbl_emp
-- ----------------------------
INSERT INTO `tbl_emp` VALUES ('1', '李翠翠', 'F', 'asd@126.com', '1', '2323', '2311', '1');
INSERT INTO `tbl_emp` VALUES ('4018', '啊啊', 'M', '', '1', '', 'aaa@126.con', '1');
INSERT INTO `tbl_emp` VALUES ('4019', '爸爸', 'M', null, '1', '111', '222', '1');
INSERT INTO `tbl_emp` VALUES ('4020', 'vvvvvv', 'M', null, '1', '', '', '1');
INSERT INTO `tbl_emp` VALUES ('4021', 'cccccccccc', 'M', null, '1', '', '', '1');
INSERT INTO `tbl_emp` VALUES ('4022', 'rrrrrrrrr', 'M', null, '1', '', '', '1');
INSERT INTO `tbl_emp` VALUES ('4023', 'tttttttttttttt', 'M', null, '1', '', '', '1');
INSERT INTO `tbl_emp` VALUES ('4024', '啊啊啊', null, null, null, null, '', null);
INSERT INTO `tbl_emp` VALUES ('4025', '嘤嘤嘤', null, null, null, null, '', null);

-- ----------------------------
-- Table structure for tbl_group
-- ----------------------------
DROP TABLE IF EXISTS `tbl_group`;
CREATE TABLE `tbl_group` (
  `group_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `group_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_group
-- ----------------------------
INSERT INTO `tbl_group` VALUES ('1', '项目实施与管理组');
INSERT INTO `tbl_group` VALUES ('2', '正射融合组');
INSERT INTO `tbl_group` VALUES ('3', '匀色镶嵌组');
INSERT INTO `tbl_group` VALUES ('4', '信息提取与研发中心');
