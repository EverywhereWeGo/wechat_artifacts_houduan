/*
 Navicat Premium Data Transfer

 Source Server         : 172.24.5.242
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : 172.24.5.242:3306
 Source Schema         : splider

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 17/09/2019 11:16:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for zghjjczz
-- ----------------------------
DROP TABLE IF EXISTS `zghjjczz`;
CREATE TABLE `zghjjczz` (
  `collectiontime` varchar(255) DEFAULT NULL,
  `siteName` varchar(255) DEFAULT NULL,
  `dateTime` varchar(255) DEFAULT NULL,
  `pH` varchar(255) DEFAULT NULL,
  `DO` varchar(255) DEFAULT NULL,
  `NH4` varchar(255) DEFAULT NULL,
  `CODMn` varchar(255) DEFAULT NULL,
  `TOC` varchar(255) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `attribute` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zghjjczz
-- ----------------------------
BEGIN;
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '北京古北口', '2018-09-17 16:05', '7.7', '10.38', '0.19', '2.1', '--', 'II', '密云水库入口', '通讯故障');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '北京门头沟沿河城', '2018-10-24 19:12', '--', '--', '--', '--', '--', '--', '官厅水库出口', '通讯故障');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '天津果河桥', '2019-09-17 08:00', '8.46', '12.76', '0.15', '2.55', '--', 'II', '于桥水库入口', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '河北张家口八号桥', '2018-09-20 08:10', '8.91', '8.85', '0.32', '3.24', '--', 'II', '官厅水库入口', '通讯故障');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '山西忻州万家寨', '2019-09-17 08:00', '7.98', '7.99', '0.28', '4.39', '--', 'III', '库体', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '内蒙古呼伦贝尔黑山头', '2019-09-17 08:00', '7.08', '7.62', '0.02', '10.63', '--', 'V', '中、俄界河', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '辽宁丹东鸭绿江桥', '2019-09-17 04:00', '7.83', '8.5', '0.06', '3.25', '--', 'II', '中、朝界河', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '辽宁抚顺大伙房水库', '2019-09-17 08:00', '7.35', '6.78', '0.24', '3.31', '--', 'II', '库体', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '辽宁盘锦兴安', '2019-09-12 10:00', '8.27', '6.4', '0.32', '4.6', '--', 'III', '入海口', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '辽宁铁岭朱尔山', '2019-09-17 08:00', '7.67', '6.73', '0.12', '2.9', '--', 'II', '', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '辽宁营口辽河公园', '2019-09-17 08:05', '7.28', '6.26', '0.05', '6.9', '--', 'IV', '入海口', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '吉林白城白沙滩', '2019-09-17 08:00', '8.64', '9.12', '0.13', '--', '--', 'I', '入松花江前', '仪器故障');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '吉林长春松花江村', '2019-09-17 08:05', '7.28', '7.27', '0.2', '--', '--', 'II', '', '仪器故障');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '吉林延边圈河', '2019-09-17 08:00', '--', '--', '--', '--', '--', '--', '中、朝界河', '子站改造');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '黑龙江抚远乌苏镇', '2019-08-15 11:45', '6.96', '13.59', '0.42', '--', '--', 'II', '中、俄界河', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '黑龙江黑河', '2019-09-17 08:05', '--', '--', '--', '--', '--', '--', '中、俄界河', '采水故障');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '黑龙江同江', '2019-09-16 08:00', '7.75', '9.81', '0.3', '20', '--', '劣V', '入黑龙江前', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '黑龙江肇源', '2019-09-09 16:00', '7.14', '6.16', '0', '10.1', '--', 'V', '', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '上海青浦急水港', '2019-09-17 08:00', '8.15', '5.5', '0.25', '2.61', '--', 'III', '苏-沪省界', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '江苏邳苍', '2019-09-17 08:00', '8.23', '9.76', '0.14', '3.2', '--', 'II', '鲁-苏省界', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '江苏泗洪大屈', '2019-09-17 08:00', '7.66', '8.18', '0.13', '7.44', '--', 'IV', '皖-苏省界', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '江苏盱眙', '2019-09-17 08:03', '8.46', '8.38', '0.15', '4.86', '0.9', 'III', '皖-苏省界', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '江苏徐州李集桥', '2019-09-17 07:59', '7.25', '7.55', '0.18', '3.89', '--', 'II', '苏-鲁省界', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '江苏扬州三江营', '2019-09-17 08:00', '7.61', '6.61', '0.17', '2.12', '--', 'II', '南水北调东线取水口', '仪器故障');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '浙江杭州鸠坑口', '2019-09-17 08:00', '8.77', '8.63', '0.21', '2.23', '--', 'II', '皖-浙省界', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '浙江湖州新塘港', '2019-09-17 08:00', '7.4', '6.72', '0.28', '7.34', '--', 'IV', '浙-苏省界', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '浙江嘉兴王江泾', '2019-09-17 08:00', '7.04', '2.79', '0.22', '3.71', '--', 'V', '苏-浙省界', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '安徽安庆皖河口', '2019-09-17 04:00', '8.42', '6.29', '0.53', '1.84', '--', 'III', '', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '安徽蚌埠蚌埠闸', '2019-09-17 08:00', '8.2', '7.66', '0.12', '4.41', '--', 'III', '闸上', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '安徽亳州颜集', '2019-09-17 08:00', '8.96', '4.15', '--', '3.13', '--', 'IV', '豫-皖省界', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '安徽滁州小柳巷', '2019-09-17 08:00', '7.29', '20', '0.17', '5.01', '--', 'III', '皖-苏省界', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '安徽阜南王家坝', '2019-09-17 08:01', '7.97', '5.67', '0.15', '5.25', '--', 'III', '豫-皖省界', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '安徽阜阳徐庄', '2019-01-11 04:01', '8.28', '10.1', '0.08', '2.67', '--', 'II', '豫-皖省界', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '安徽阜阳张大桥', '2019-09-17 08:00', '8.32', '6', '0.05', '2.89', '--', 'II', '豫-皖省界', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '安徽淮北小王桥', '2019-09-17 00:00', '--', '--', '--', '--', '--', '--', '豫-皖省界', '调水调沙');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '安徽界首七渡口', '2019-09-17 04:00', '7.58', '3.96', '--', '3.36', '--', 'IV', '豫-皖省界', '仪器故障');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '江西九江蛤蟆石', '2019-09-17 08:00', '7.63', '5.72', '0.2', '2.27', '--', 'III', '湖体（出口）', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '江西九江河西水厂', '2019-09-17 08:00', '6.89', '6.63', '0.18', '1.39', '--', 'II', '鄂-赣省界', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '江西南昌滁槎', '2019-09-17 08:00', '6.44', '5.01', '0.27', '1.8', '1.33', 'III', '入鄱阳湖', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '山东济南泺口', '2019-09-17 04:00', '7.91', '7.01', '0.15', '2.51', '--', 'II', '入海口', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '山东聊城秤钩湾', '2019-06-17 08:00', '--', '--', '--', '--', '--', '--', '豫冀鲁三省交界', '河流断流');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '山东临沂涝沟桥', '2019-09-17 08:00', '7.63', '10.11', '0.07', '5.11', '--', 'III', '鲁-苏省界', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '山东枣庄台儿庄', '2019-09-17 08:00', '7.67', '4.97', '0.04', '3.84', '--', 'IV', '鲁-苏省界', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '河南济源小浪底', '2019-09-17 08:00', '8.33', '7.73', '0.12', '1.68', '--', 'I', '水库出口', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '河南信阳淮滨水文站', '2019-09-17 08:00', '7.3', '4.79', '0.22', '3.26', '--', 'IV', '豫-皖省界', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '河南永城黄口', '2019-09-17 08:00', '7.6', '1.05', '0.88', '4.11', '--', '劣V', '豫-皖省界', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '河南周口鹿邑付桥闸', '2019-09-17 08:00', '8.52', '6.17', '0.09', '5.1', '--', 'III', '豫-皖省界', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '河南驻马店班台', '2019-09-17 08:00', '7.31', '5.61', '0.2', '4.51', '--', 'III', '豫-皖省界', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '湖北丹江口胡家岭', '2019-09-17 08:08', '7.92', '5.68', '0.08', '1.92', '--', 'III', '库体', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '湖北武汉宗关', '2019-09-17 04:03', '1.13', '8.04', '0.09', '3.49', '--', '劣V', '入长江前', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '湖北宜昌南津关', '2019-09-17 08:00', '7.78', '7.93', '0.26', '1.58', '2.3', 'II', '三峡水库出口', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '湖南岳阳城陵矶', '2019-09-17 04:00', '8.56', '10.86', '0.61', '--', '--', 'III', '', '仪器故障');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '湖南岳阳岳阳楼', '2019-06-17 08:00', '--', '--', '--', '--', '--', '--', '湖体（出口）', '通讯故障');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '广东清远七星岗', '2019-09-17 08:00', '7.21', '5.35', '--', '2.22', '20', 'III', '', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '广西贵港石嘴', '2019-09-17 08:00', '6.89', '6.75', '0.02', '2.56', '--', 'II', '', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '广西桂林阳朔', '2019-09-17 08:00', '7.11', '5.78', '--', '1.64', '--', 'III', '', '仪器故障');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '广西南宁老口', '2019-09-16 12:00', '7.69', '5.98', '0.13', '2.26', '--', 'III', '', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '重庆朱沱', '2019-09-17 08:00', '--', '--', '--', '--', '--', '--', '川-渝省界', '通讯故障');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '四川泸州沱江二桥', '2019-09-17 08:15', '7.48', '8.31', '0.08', '--', '--', 'I', '入长江前', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '四川攀枝花龙洞', '2019-09-17 04:00', '8.2', '11.59', '0.04', '1.27', '--', 'I', '', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '四川宜宾凉姜沟', '2019-09-17 08:00', '7.13', '--', '--', '1.38', '--', 'I', '入长江前', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '云南红河州河口', '2019-09-17 08:00', '8.86', '8', '1.7', '1.6', '--', 'V', '中-越出境', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '陕西渭南潼关吊桥', '2019-09-17 08:08', '7.99', '6.45', '0.27', '0.78', '--', 'II', '陕-晋、豫省界（入黄前）', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '甘肃兰州新城桥', '2019-09-17 08:00', '6.38', '7.19', '0.05', '2.55', '--', 'II', '', '正常');
INSERT INTO `zghjjczz` VALUES ('2019-09-17 10:40:10', '宁夏中卫新墩', '2019-09-17 08:00', '8.64', '8.02', '0.2', '5.15', '--', 'III', '甘-宁省界', '正常');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
