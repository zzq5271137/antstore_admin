/*
 Navicat Premium Data Transfer

 Source Server         : MyLocal
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : antstore

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 06/02/2020 18:29:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', '123');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `cid` int(50) NOT NULL AUTO_INCREMENT,
  `cname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '电脑办公');
INSERT INTO `category` VALUES (2, '家具家居');
INSERT INTO `category` VALUES (3, '鲜果时光');
INSERT INTO `category` VALUES (4, '图书音像');
INSERT INTO `category` VALUES (5, '母婴育婴');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `image` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gdesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_hot` int(1) NULL DEFAULT 0,
  `cid` int(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `cid`(`cid`) USING BTREE,
  CONSTRAINT `cid` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '梵希蔓短袖衬衣女2018新款夏季气质韩版通勤', 159.00, 'goods_001.png', '', 0, 1);
INSERT INTO `goods` VALUES (2, '姿忆秀五分袖宽松衬衫女2018夏装新款竖条纹\r\n', 88.00, 'goods_002.png', NULL, 0, 2);
INSERT INTO `goods` VALUES (3, '梵希蔓短袖雪纺衬衫短款2018夏季新款女装韩\r\n', 176.00, 'goods_003.png', NULL, 0, 1);
INSERT INTO `goods` VALUES (4, '2018夏季新款雪纺衬衫女上衣职业OL短袖衬衣韩版修身休闲', 159.00, 'goods_004.png', NULL, 0, 4);
INSERT INTO `goods` VALUES (5, '电脑椅家用电竞椅 人体工学椅子座椅网布转椅可躺老板椅办公椅', 269.00, 'goods_005.png', NULL, 0, 1);
INSERT INTO `goods` VALUES (6, '电脑椅家用座椅办公椅主播椅子游戏椅网吧电竞椅可躺午休', 699.00, 'goods_006.png', NULL, 0, 3);
INSERT INTO `goods` VALUES (7, '百图 立领条纹衬衫女套头短袖百搭雪纺衫上\r\n', 179.00, 'goods_007.png', NULL, 0, 2);
INSERT INTO `goods` VALUES (8, '不锈钢卫浴室柜组合小户型挂墙式洗手洗脸盆池卫生间厕所洗漱台盆', 305.00, 'goods_008.png', NULL, 0, 1);
INSERT INTO `goods` VALUES (9, '北欧双盆浴室柜组合简约卫浴柜镜柜卫生间洗手盆洗脸盆洗漱台盆柜', 900.00, 'goods_009.png', NULL, 0, 2);
INSERT INTO `goods` VALUES (10, '简约现代浴室柜洗手盆柜组合洗脸卫生间小户型厕所洗漱台卫浴吊柜', 948.00, 'goods_10.png', NULL, 0, 1);
INSERT INTO `goods` VALUES (11, '三只鸟旅行箱拉杆箱女铝框20寸行李箱万向轮24寸学生密码箱登机箱', 268.00, 'goods_11.png', NULL, 0, 2);
INSERT INTO `goods` VALUES (12, '全铝镁铝合金拉杆箱金属旅行箱子男女万向轮行李箱商务学生登机箱', 375.00, 'goods_12.png', NULL, 0, 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('439f1f56-0faa-42fa-a84b-36e65849a05a', '毛毛的大脚', '123', '13912004862');
INSERT INTO `user` VALUES ('6576be11-8fc5-441a-a56b-93fb4c32b00f', 'zzq5271137', '123', '13952232956');
INSERT INTO `user` VALUES ('d904a494-5e96-4364-a2cb-fa1f714c9ff4', '深海的星星', '1234', '13912004862');

SET FOREIGN_KEY_CHECKS = 1;
