/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : minapp

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 05/05/2019 00:27:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for feed
-- ----------------------------
DROP TABLE IF EXISTS `feed`;
CREATE TABLE `feed`  (
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品',
  `source` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '来源（0：Google 1：朋友圈 2:公总号）',
  `area` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地区（0：美国 1：中国 2：巴西 3：日本）',
  `score` int(11) NULL DEFAULT NULL COMMENT '打分',
  `isFront` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否是前端工程师（ 0：是 1：不是）',
  `createDate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of feed
-- ----------------------------
INSERT INTO `feed` VALUES ('aaaa', '[\"0\",\"2\"]', '1', '3', 58, '0', '2019-05-04 14:17:54');
INSERT INTO `feed` VALUES ('bbbb', 'nullnull', '0', '1', 36, '0', '2019-05-04 14:47:27');
INSERT INTO `feed` VALUES ('cccc', '微商城VLog微社区', '1', '2', 61, '0', '2019-05-04 15:05:47');
INSERT INTO `feed` VALUES ('dddd', '微社区,微商城,', '1', '2', 61, '0', '2019-05-04 15:09:32');
INSERT INTO `feed` VALUES ('eeeee', '微社区,微商城,', '1', '2', 61, '0', '2019-05-04 15:10:04');
INSERT INTO `feed` VALUES ('ffff', '微商城,VLog', '0', '2', 22, '0', '2019-05-04 15:11:14');
INSERT INTO `feed` VALUES ('ggg', '微商城,VLog', '0', '2', 43, '0', '2019-05-04 15:12:55');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `image` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片地址',
  `curTime` datetime(0) NULL DEFAULT NULL,
  `desc` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES (1, 'Favicon Checker ', NULL, '2019-05-04 10:50:05', '为你的网站添加图标（Favicon），虽然是一个简单的动作，但对网站来说却有相当大的帮助，怎么说呢？因为这些图案有助于加深使用者对网站的印象，在书签列显示也更容易识别，除此之外，当今行动装置浏览器例如iOS Safari或Android Chrome都支援将网站钉选到主画面，不过必须事先设定好合适的图案。\r\n\r\n');
INSERT INTO `news` VALUES (2, '超级实用的工具', NULL, '2019-05-04 10:50:43', 'MikuTools : 工具合集网站，有媒体类，图片类和文字处理类等的在线工具；适合于大众。');
INSERT INTO `news` VALUES (3, '火狐邮箱泄露检测', NULL, '2019-05-04 10:51:17', 'Firefox Monitor 是免费检测你的邮箱，被哪些网站泄露过信息。\r\n\r\n有些人使用密码，可能很多网站的密码都是一样的，如果其中一个网站泄露了，其他网站可能有可能受影响。所以大家赶快去检查一下。如果有，赶快修改密码。\r\n\r\n它这个网站统计了很多黑客公开的一些账号信息。\r\n\r\n为了避免这些问题再次发生。这个网站给出了一些解决方案。比如为不同的号设置不同的密码。还可以使用第三方密码管理工具（Master Password  根据主账号 + 网站生成密码）。还可以订阅警报，如果有新的网站被泄露了，它可以随时通知你。');
INSERT INTO `news` VALUES (4, 'Master Password ', NULL, '2019-05-04 10:51:42', 'Master Password ：通过使用者设定好的名称、主密码（Master Password）来产生一把主钥匙（Master Key）；再搭配你设定的网站名称（例如：apple.com），从中计算出特定的密码组合。\r\n\r\n这也表示你的密码不会以任何形式被储存在任何地方，包括电脑上、或者云端，这是一个相当安全的作法，甚至于当你的手机失窃、电脑资料被其他人窃取，也找不到任何的密码档案，这就好比你把钥匙保存在脑海里，让其他人难以取得，而且你只需要记住一组主密码。\r\n\r\nMaster Password还是有缺点，例如最大的问题是无法重设主密码，当你更换掉主密码后，你必须手动将所有设定的网站密码全部换掉，因为它将无法计算出一组相同密码。');

SET FOREIGN_KEY_CHECKS = 1;
