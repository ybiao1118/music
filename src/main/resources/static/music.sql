/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : music

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-01-29 11:38:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_dynamic
-- ----------------------------
DROP TABLE IF EXISTS `t_dynamic`;
CREATE TABLE `t_dynamic` (
  `id` varchar(32) NOT NULL,
  `uid` varchar(32) DEFAULT NULL COMMENT '用户id',
  `znumber` int(32) DEFAULT '0' COMMENT '点赞量',
  `fnumber` int(32) DEFAULT '0' COMMENT '转发量',
  `pnumber` int(32) DEFAULT '0' COMMENT '评论量',
  `comment` varchar(255) DEFAULT NULL COMMENT '发布内容',
  `time` datetime DEFAULT NULL,
  `file` varchar(255) DEFAULT NULL COMMENT '文件，视频，音乐或者图片',
  PRIMARY KEY (`id`),
  KEY `d_uid_key` (`uid`),
  CONSTRAINT `d_uid_key` FOREIGN KEY (`uid`) REFERENCES `t_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dynamic
-- ----------------------------
INSERT INTO `t_dynamic` VALUES ('1', '04139ed40ae143148ae4d857c2f773d2', '0', '0', '0', 'sasasd', '2019-01-29 10:36:34', 'dsada');
INSERT INTO `t_dynamic` VALUES ('2', '3f4ace763d804d91b52b0c0de67d672a', '0', '0', '0', 'dasdfffff', '2019-01-28 10:36:53', 'sdfsd');

-- ----------------------------
-- Table structure for t_dynamic_comments
-- ----------------------------
DROP TABLE IF EXISTS `t_dynamic_comments`;
CREATE TABLE `t_dynamic_comments` (
  `id` varchar(32) NOT NULL,
  `did` varchar(32) NOT NULL COMMENT '动态id',
  `uid` varchar(32) NOT NULL COMMENT '评论人id',
  `comment` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `time` datetime DEFAULT NULL,
  `znumber` int(32) DEFAULT '0' COMMENT '点赞数量',
  `level` varchar(2) DEFAULT '0' COMMENT '层级，0是第一层，1是第二层',
  `parentid` varchar(32) DEFAULT '0' COMMENT '父级id,0表示没有父级',
  PRIMARY KEY (`id`),
  KEY `dc_did_key` (`did`),
  KEY `dc_uid_key` (`uid`),
  CONSTRAINT `dc_did_key` FOREIGN KEY (`did`) REFERENCES `t_dynamic` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `dc_uid_key` FOREIGN KEY (`uid`) REFERENCES `t_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dynamic_comments
-- ----------------------------
INSERT INTO `t_dynamic_comments` VALUES ('1', '1', '04139ed40ae143148ae4d857c2f773d2', 'dasda', '2019-01-29 10:38:41', '0', '0', '0');
INSERT INTO `t_dynamic_comments` VALUES ('2', '1', '3f4ace763d804d91b52b0c0de67d672a', 'sffff', '2019-01-29 10:39:01', '0', '0', '0');
INSERT INTO `t_dynamic_comments` VALUES ('3', '1', '9dc2b1aa753f4bd2a837772966617b11', 'dasd', '2019-01-30 10:39:20', '0', '0', '1');
INSERT INTO `t_dynamic_comments` VALUES ('4', '2', '4ec550a3ff154d7e888f512b968dc965', 'sdasd', '2019-01-29 11:01:19', '0', '0', '0');

-- ----------------------------
-- Table structure for t_music
-- ----------------------------
DROP TABLE IF EXISTS `t_music`;
CREATE TABLE `t_music` (
  `id` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `pid` varchar(32) NOT NULL COMMENT '歌手id',
  `image` varchar(255) DEFAULT NULL,
  `mp3` varchar(255) NOT NULL,
  `lyrics` varchar(255) DEFAULT NULL,
  `dnumber` int(32) DEFAULT '0' COMMENT '下载量',
  `snumber` int(32) DEFAULT '0' COMMENT '搜索量',
  `cnumber` int(32) DEFAULT '0' COMMENT '点击量',
  `pnumber` int(32) DEFAULT '0' COMMENT '评论量',
  `is_delete` int(2) DEFAULT '0' COMMENT '是否删除,0未删除,1删除',
  `is_audit` int(2) DEFAULT '0' COMMENT '是否审核,0未审核,1审核通过',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `p_pid_key` (`pid`),
  CONSTRAINT `p_pid_key` FOREIGN KEY (`pid`) REFERENCES `t_player` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_music
-- ----------------------------
INSERT INTO `t_music` VALUES ('1', '你好', 'd992b770074d4fbcbedd6712411c413e', 'dd', 'bb', 'www', '0', '0', '0', '0', '0', '0', null);
INSERT INTO `t_music` VALUES ('11', '千千', 'd992b770074d4fbcbedd6712411c413e', '弟弟', '11', '11', '0', '2', '0', '0', '0', '0', '2019-01-28 15:51:40');
INSERT INTO `t_music` VALUES ('12', '多大的', '6597d8197f2c459f9a188f315e1bcb05', 'ss', 'ss', 'ss', '0', '0', '0', '0', '0', '0', '2019-01-27 17:56:13');
INSERT INTO `t_music` VALUES ('13', '多大点事所', '6597d8197f2c459f9a188f315e1bcb05', 'ff', 'ss', '33', '0', '0', '0', '0', '0', '0', '2019-01-21 17:57:21');
INSERT INTO `t_music` VALUES ('22', 'fff', '6597d8197f2c459f9a188f315e1bcb05', 'ff', 'ff', 'ff', '3', '1', '0', '0', '0', '0', '2019-01-28 15:42:05');
INSERT INTO `t_music` VALUES ('7321305f5ccf40eaac3446bf03ce82e2', 'test', '6597d8197f2c459f9a188f315e1bcb05', 'E://music/music/image/7321305f5ccf40eaac3446bf03ce82e2.png', 'E://music/music/music/7321305f5ccf40eaac3446bf03ce82e2.png', 'E://music/music/lyrics/7321305f5ccf40eaac3446bf03ce82e2.png', '4', '3', '0', '0', '0', '0', null);
INSERT INTO `t_music` VALUES ('f211fedcd4194419add580f606ce9bc9', '千千阙歌', '6597d8197f2c459f9a188f315e1bcb05', 'E://music/music/image/f211fedcd4194419add580f606ce9bc9.png', 'E://music/music/music/f211fedcd4194419add580f606ce9bc9.png', 'E://music/music/lyrics/f211fedcd4194419add580f606ce9bc9.png', '2', '0', '0', '0', '0', '0', '2019-01-28 14:35:16');

-- ----------------------------
-- Table structure for t_music_comments
-- ----------------------------
DROP TABLE IF EXISTS `t_music_comments`;
CREATE TABLE `t_music_comments` (
  `id` varchar(32) NOT NULL,
  `mid` varchar(32) NOT NULL COMMENT '音乐id',
  `uid` varchar(32) NOT NULL COMMENT '评论人id',
  `comment` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `time` datetime DEFAULT NULL,
  `znumber` int(32) DEFAULT '0' COMMENT '点赞数量',
  `level` varchar(2) DEFAULT '0' COMMENT '层级，0是第一层，1是第二层',
  `parentid` varchar(32) DEFAULT '0' COMMENT '父级id,0表示没有父级',
  PRIMARY KEY (`id`),
  KEY `mc_uid_key` (`uid`),
  KEY `mc_mid_key` (`mid`),
  CONSTRAINT `mc_mid_key` FOREIGN KEY (`mid`) REFERENCES `t_music` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `mc_uid_key` FOREIGN KEY (`uid`) REFERENCES `t_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_music_comments
-- ----------------------------
INSERT INTO `t_music_comments` VALUES ('1', '1', '3f4ace763d804d91b52b0c0de67d672a', 'asdas', '2019-01-29 11:18:08', '0', '0', '0');
INSERT INTO `t_music_comments` VALUES ('2', '1', '4ec550a3ff154d7e888f512b968dc965', 'dasdasdff', '2019-01-29 11:18:25', '0', '0', '0');
INSERT INTO `t_music_comments` VALUES ('3', '11', '9dc2b1aa753f4bd2a837772966617b11', 'fdfdsffs', '2019-01-29 11:18:42', '0', '0', '0');

-- ----------------------------
-- Table structure for t_player
-- ----------------------------
DROP TABLE IF EXISTS `t_player`;
CREATE TABLE `t_player` (
  `id` varchar(32) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL COMMENT '简介',
  `snumber` int(32) DEFAULT '0' COMMENT '收藏量',
  `image` varchar(255) DEFAULT NULL,
  `pinyin` varchar(2) DEFAULT NULL COMMENT '首字母拼音',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_player
-- ----------------------------
INSERT INTO `t_player` VALUES ('6597d8197f2c459f9a188f315e1bcb05', 'tom', '1111', '0', 'E://music/player/6597d8197f2c459f9a188f315e1bcb05.png', 't');
INSERT INTO `t_player` VALUES ('d992b770074d4fbcbedd6712411c413e', '余程风', '1111', '0', 'E://music/player/d992b770074d4fbcbedd6712411c413e.png', 'y');

-- ----------------------------
-- Table structure for t_playlist
-- ----------------------------
DROP TABLE IF EXISTS `t_playlist`;
CREATE TABLE `t_playlist` (
  `id` varchar(32) NOT NULL,
  `uid` varchar(32) NOT NULL,
  `pnumber` int(32) DEFAULT '0' COMMENT '评论量',
  `cnumber` int(32) DEFAULT '0' COMMENT '点击量',
  `is_online` int(2) DEFAULT '0' COMMENT '是否上线，0未上线，1上线',
  `name` varchar(32) DEFAULT NULL COMMENT '歌单名称',
  PRIMARY KEY (`id`),
  KEY `pl_uid_key` (`uid`),
  CONSTRAINT `pl_uid_key` FOREIGN KEY (`uid`) REFERENCES `t_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_playlist
-- ----------------------------

-- ----------------------------
-- Table structure for t_playlist_center
-- ----------------------------
DROP TABLE IF EXISTS `t_playlist_center`;
CREATE TABLE `t_playlist_center` (
  `id` varchar(32) NOT NULL,
  `plid` varchar(32) DEFAULT NULL COMMENT '歌单id',
  `mid` varchar(32) DEFAULT NULL COMMENT '音乐id',
  PRIMARY KEY (`id`),
  KEY `pc_mid_key` (`mid`),
  KEY `plid_key` (`plid`),
  CONSTRAINT `pc_mid_key` FOREIGN KEY (`mid`) REFERENCES `t_music` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `plid_key` FOREIGN KEY (`plid`) REFERENCES `t_playlist` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_playlist_center
-- ----------------------------

-- ----------------------------
-- Table structure for t_playlist_comments
-- ----------------------------
DROP TABLE IF EXISTS `t_playlist_comments`;
CREATE TABLE `t_playlist_comments` (
  `id` varchar(32) NOT NULL,
  `plid` varchar(32) NOT NULL COMMENT '歌单id',
  `uid` varchar(32) NOT NULL COMMENT '评论人id',
  `comment` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `time` datetime DEFAULT NULL,
  `znumber` int(32) DEFAULT '0' COMMENT '点赞数量',
  `level` varchar(2) DEFAULT '0' COMMENT '层级，0是第一层，1是第二层',
  `parentid` varchar(32) DEFAULT '0' COMMENT '父级id,0表示没有父级',
  PRIMARY KEY (`id`),
  KEY `pc_uid_key` (`uid`),
  KEY `pc_plid_key` (`plid`),
  CONSTRAINT `pc_plid_key` FOREIGN KEY (`plid`) REFERENCES `t_playlist` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `pc_uid_key` FOREIGN KEY (`uid`) REFERENCES `t_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_playlist_comments
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` varchar(32) NOT NULL,
  `username` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `sex` varchar(8) DEFAULT NULL,
  `age` int(5) DEFAULT NULL,
  `city` varchar(32) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL COMMENT '头像',
  `introduce` varchar(255) DEFAULT NULL COMMENT '简介',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('04139ed40ae143148ae4d857c2f773d2', '1510501505', 'E10ADC3949BA59ABBE56E057F20F883E', null, null, null, null, 'E://music/user/04139ed40ae143148ae4d857c2f773d2.png', null);
INSERT INTO `t_user` VALUES ('3f4ace763d804d91b52b0c0de67d672a', 'yanbiao', '4A023ACD48ED390599163859360C7912', '弟弟', null, null, null, 'E://music//image//null.png', null);
INSERT INTO `t_user` VALUES ('4ec550a3ff154d7e888f512b968dc965', 'tom', '4A023ACD48ED390599163859360C7912', '余程风', '男', '21', '11', 'E://music//image//null.png', '11');
INSERT INTO `t_user` VALUES ('9dc2b1aa753f4bd2a837772966617b11', 'bob', '4A023ACD48ED390599163859360C7912', 'tom', '男', '18', '33', 'E://music//user//9dc2b1aa753f4bd2a837772966617b11.png', '44');
