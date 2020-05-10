/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : 127.0.0.1:3306
 Source Schema         : uiaipms

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 10/05/2020 18:09:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `admin_name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员姓名',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `nickname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `ban` int(1) NULL DEFAULT 0 COMMENT '0 启用 1 禁用，默认0',
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `image` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '照片地址',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `logic_delete_flag` int(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除字段',
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1447df502e6b4a5fa2b148be4bf03ec4', '宋江', 'fin_admin', 'ccc8d0adb62e165a2b30e4c203bf7bd5', '昵称-宋江', 0, '13688290904', '/uiaipms/head-img/1588815905568.jpg', '2020-05-07 09:45:10', '2020-01-13 11:14:16', 0);
INSERT INTO `admin` VALUES ('69fcc37f356b4767b1d556ecace9d479', '李逵', 'sys_admin', 'd1ee51fab32afe381b45a8c42bf3eaaf', '昵称-李逵', 0, '13688290904', '/uiaipms/head-img/1589079175004.jpg', '2020-05-10 10:52:55', '2020-01-11 17:33:49', 0);
INSERT INTO `admin` VALUES ('e7a185e5074741b385d3615d41a92038', '卢俊义', 'stock_admin', 'df75011b435f604766b5795ca18c3854', '昵称-卢俊义', 0, NULL, '/uiaipms/head-img/icon.png', '2020-04-30 14:08:49', '2020-02-17 12:07:42', 0);

-- ----------------------------
-- Table structure for buy_funds_apply
-- ----------------------------
DROP TABLE IF EXISTS `buy_funds_apply`;
CREATE TABLE `buy_funds_apply`  (
  `bfa_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `deal_user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '处理人id',
  `deal` int(1) NULL DEFAULT 1 COMMENT '是否处理 0 已处理 1 没处理 默认 1',
  `bfa_agree` int(1) NULL DEFAULT 1 COMMENT '是否同意 0 同意 1 不同意 默认 1',
  `bfa_reason` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '处理结果说明',
  `apply_user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请人id',
  `apply_reason` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请理由',
  `apply_mount` decimal(10, 0) NULL DEFAULT NULL COMMENT '申请金额',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `logic_delete_flag` int(1) NULL DEFAULT 0 COMMENT '逻辑删除字段',
  PRIMARY KEY (`bfa_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '采购资金申请' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of buy_funds_apply
-- ----------------------------
INSERT INTO `buy_funds_apply` VALUES ('0087263287f845759e917a1837d7ff18', '883a51f8cae347048e45a785b8f87a0e', 0, 1, '第12次测试，不同意', 'e7a185e5074741b385d3615d41a92038', '购买路由器10个，单价500元', 5000, '2020-03-20 15:47:01', '2020-03-23 19:08:58', 0);
INSERT INTO `buy_funds_apply` VALUES ('0ab87df4c31747aa9a5c6eaefd2b1bd4', '1447df502e6b4a5fa2b148be4bf03ec4', 0, 0, '同意同意同意同意同意同意同意同意同意同意同意同意', 'e7a185e5074741b385d3615d41a92038', '嘟嘟嘟嘟嘟', 6202, '2020-04-08 21:56:50', '2020-04-23 16:01:24', 0);
INSERT INTO `buy_funds_apply` VALUES ('2a366a2c403440f99a3f9311a6ac65b3', '1447df502e6b4a5fa2b148be4bf03ec4', 0, 0, '同意，同意，同意，同意，同意，同意，同意', 'e7a185e5074741b385d3615d41a92038', '采购，采购，采购，采购，采购，采购，采购，', 1500, '2020-05-03 15:13:50', '2020-05-03 15:17:23', 0);
INSERT INTO `buy_funds_apply` VALUES ('3041c8ff5c0348bc911b79423678d124', NULL, 1, 1, NULL, 'e7a185e5074741b385d3615d41a92038', '采购，采购，采购，采购，采购，采购，采购，采购，', 600, '2020-05-08 16:03:45', '2020-05-08 16:03:45', 0);
INSERT INTO `buy_funds_apply` VALUES ('313f1e77fe21413b9e20ea72868a5c96', '1447df502e6b4a5fa2b148be4bf03ec4', 0, 0, 'sdsadasdashjdashdss', 'e7a185e5074741b385d3615d41a92038', '采购，采购，采购，采购，采购，采购，采购，', 1000, '2020-05-08 16:03:54', '2020-05-10 16:42:57', 0);
INSERT INTO `buy_funds_apply` VALUES ('3cb417606a08430aa4f8869e72126cc2', NULL, 1, 1, NULL, 'e7a185e5074741b385d3615d41a92038', '采购，采购，采购，采购，采购，采购，', 800, '2020-05-08 16:03:37', '2020-05-08 16:03:37', 0);
INSERT INTO `buy_funds_apply` VALUES ('3e67689751ef49aca4b0b00de81802c8', '1447df502e6b4a5fa2b148be4bf03ec4', 0, 0, '同意，同意，同意，同意，同意，同意，同意', 'e7a185e5074741b385d3615d41a92038', '采购，采购，采购，采购，采购，采购，采购，', 500, '2020-05-03 15:13:56', '2020-05-03 15:17:12', 0);
INSERT INTO `buy_funds_apply` VALUES ('4becb8ab247a4ea58ff19eb1c4e3af03', '1447df502e6b4a5fa2b148be4bf03ec4', 0, 0, '同意，同意，同意，同意，同意，同意，同意', 'e7a185e5074741b385d3615d41a92038', '采购，采购，采购，采购，采购，采购，采购', 3000, '2020-05-03 15:13:44', '2020-05-03 15:17:31', 0);
INSERT INTO `buy_funds_apply` VALUES ('4cdb6210132d4d8e8a76166bb0dda652', '1447df502e6b4a5fa2b148be4bf03ec4', 0, 1, '不同意，不同意，不同意，不同意，不同意，不同意，', 'e7a185e5074741b385d3615d41a92038', '采购椅子，采购椅子，采购椅子，采购椅子，采购椅子', 1000, '2020-05-03 15:13:03', '2020-05-03 15:17:50', 0);
INSERT INTO `buy_funds_apply` VALUES ('7469d7426e404116af47c0af9545637b', NULL, 1, 1, NULL, 'e7a185e5074741b385d3615d41a92038', 'sbdvbsdnjbsdnsbadhnas', 500, '2020-05-10 16:46:40', '2020-05-10 16:46:40', 0);
INSERT INTO `buy_funds_apply` VALUES ('9a0cdec3fcc04fc5920220a9732b3d27', '883a51f8cae347048e45a785b8f87a0e', 0, 0, '第十一次测试，同意', 'e7a185e5074741b385d3615d41a92038', '测试', 5000, '2020-03-20 15:47:51', '2020-03-23 19:08:24', 0);
INSERT INTO `buy_funds_apply` VALUES ('a034bbee72644a2eb80cf59cc26cd2f4', '1447df502e6b4a5fa2b148be4bf03ec4', 0, 1, '不同意，不同意，不同意，不同意，不同意，不同意', 'e7a185e5074741b385d3615d41a92038', '采购路由器，采购路由器，采购路由器，采购路由器，采购路由器', 2000, '2020-05-03 15:13:22', '2020-05-03 15:17:43', 0);
INSERT INTO `buy_funds_apply` VALUES ('a062c071e74e4a2aa298e47ba37aa6c7', '883a51f8cae347048e45a785b8f87a0e', 0, 1, '不通过', 'e7a185e5074741b385d3615d41a92038', '测试2', 5000, '2020-04-08 21:36:58', '2020-04-09 13:19:52', 0);
INSERT INTO `buy_funds_apply` VALUES ('a070d54e73ba416fa87ee640e0da3166', '883a51f8cae347048e45a785b8f87a0e', 0, 0, '同意', 'e7a185e5074741b385d3615d41a92038', '购买椅子10张，单价50元', 500, '2020-03-20 15:45:54', '2020-04-08 21:56:15', 0);
INSERT INTO `buy_funds_apply` VALUES ('acd7bade8cea40b4a74a6cdc0612828c', '1447df502e6b4a5fa2b148be4bf03ec4', 0, 0, '同意，同意，同意，同意，同意，同意，同意', 'e7a185e5074741b385d3615d41a92038', '采购，采购，采购，采购，采购，采购，采购，', 1800, '2020-05-03 15:14:03', '2020-05-03 15:17:06', 0);
INSERT INTO `buy_funds_apply` VALUES ('b4a6b611d69e47c4bb7002d6a123017c', NULL, 1, 1, NULL, 'e7a185e5074741b385d3615d41a92038', '采购，采购，采购，采购，采购，采购，采购，采购，', 500, '2020-05-08 16:03:28', '2020-05-08 16:03:28', 0);
INSERT INTO `buy_funds_apply` VALUES ('d6f7696dfdff4a6ca683a5e52a82e30e', '883a51f8cae347048e45a785b8f87a0e', 0, 0, '第10次测试，同意', 'e7a185e5074741b385d3615d41a92038', '第二次测试', 3000, '2020-03-20 15:50:33', '2020-03-23 19:08:03', 0);
INSERT INTO `buy_funds_apply` VALUES ('dcc235312df54d30998c91c191054472', '883a51f8cae347048e45a785b8f87a0e', 0, 0, '同意', 'e7a185e5074741b385d3615d41a92038', '测试', 3000, '2020-04-08 21:04:39', '2020-04-08 21:55:22', 0);
INSERT INTO `buy_funds_apply` VALUES ('ef3b061bbebb43118d60eb4b39f539c5', '1447df502e6b4a5fa2b148be4bf03ec4', 0, 0, '泳衣泳衣泳衣泳衣泳衣泳衣泳衣泳衣泳衣泳衣', 'e7a185e5074741b385d3615d41a92038', '测试坻崿是测试坻崿是测试坻崿是测试坻崿是测试坻崿是测试坻崿是', 3000, '2020-04-23 16:30:03', '2020-04-23 16:31:12', 0);

-- ----------------------------
-- Table structure for clazz
-- ----------------------------
DROP TABLE IF EXISTS `clazz`;
CREATE TABLE `clazz`  (
  `clazz_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `clazz_name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级名称',
  `disc_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属系ID',
  PRIMARY KEY (`clazz_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '班级' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of clazz
-- ----------------------------
INSERT INTO `clazz` VALUES ('086e7c026605428186638f1002532c89', '商务英语1班', '35e93a34feb2486ea0e0ad3555c0c6c1');
INSERT INTO `clazz` VALUES ('17b9e914ffd542b3bfbd8415c96ab464', '体育教育2班', '3b80e0e235f74ff3bac47b8bf35db79c');
INSERT INTO `clazz` VALUES ('1f8545aee65b4480a128719d722ab92b', '休闲体育2班', '83d7872829a546d9b93b667d679df7c7');
INSERT INTO `clazz` VALUES ('22540f06e7c84165a18efdb4f6ffb390', '计算机科学与技术1班', 'f6fc3aea99cb45ef87b245696cfb9a70');
INSERT INTO `clazz` VALUES ('2ff8258554b04a26a48030dddd4963f4', '软件工程2班', 'f17283b04faa4a59a744d97a252162c1');
INSERT INTO `clazz` VALUES ('347f9c6404f64b94bee3f9edaa250ad0', '财务管理1班', 'a2a920c7c3f045a99fd9d33b1769c643');
INSERT INTO `clazz` VALUES ('405188c02beb404da6e1c4c26a10b167', '汉语国际教育2班', '148d35962079460eaaacad289f68b582');
INSERT INTO `clazz` VALUES ('43313947f5634cb9ab30448c898d8477', '汉语国际教育1班', '148d35962079460eaaacad289f68b582');
INSERT INTO `clazz` VALUES ('45770dc7fc2a4f09a6b79ea2b7f5146b', '计算机科学与技术2班', 'f6fc3aea99cb45ef87b245696cfb9a70');
INSERT INTO `clazz` VALUES ('488fdc60b43642da8de86f2d7cda0df4', '泰语1班', 'c5c4f22f1559449db7eb5cc7a1e639ff');
INSERT INTO `clazz` VALUES ('7af982ef3d3749bf8b78460d0c1c81f4', '工商管理2班', 'a124ae391f09477997cddf4b6560e509');
INSERT INTO `clazz` VALUES ('8ccc6b34d81046a1b4ae0361eaeeca98', '商务英语2班', '35e93a34feb2486ea0e0ad3555c0c6c1');
INSERT INTO `clazz` VALUES ('b0bd562a5e3e4e81bfe8b5bd12b3109a', '财务管理2班', 'a2a920c7c3f045a99fd9d33b1769c643');
INSERT INTO `clazz` VALUES ('bbdd65984b004d58b68544b229d486ec', '工商管理1班', 'a124ae391f09477997cddf4b6560e509');
INSERT INTO `clazz` VALUES ('bcca7fc622664a9cbd9ed2f66a96d89a', '国际贸易2班', 'a4e1a528c29b467e9074afee5793f206');
INSERT INTO `clazz` VALUES ('c48a1edeae8e4ac0bc29182f1550e7b1', '国际贸易1班', 'a4e1a528c29b467e9074afee5793f206');
INSERT INTO `clazz` VALUES ('c87263ef3085463b83680a2f115d7947', '休闲体育1班', '83d7872829a546d9b93b667d679df7c7');
INSERT INTO `clazz` VALUES ('d1cc057abee34cb2bd763716b4ab11cf', '软件工程1班', 'f17283b04faa4a59a744d97a252162c1');
INSERT INTO `clazz` VALUES ('e4677bc5aef54926ac0ee16c601f4afe', '体育教育1班', '3b80e0e235f74ff3bac47b8bf35db79c');
INSERT INTO `clazz` VALUES ('f9fe4632d17a40e596c3dc06e2bd3655', '泰语2班', 'c5c4f22f1559449db7eb5cc7a1e639ff');

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company`  (
  `com_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `com_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业名',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人手机号',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `com_people` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人',
  `ban` int(1) NULL DEFAULT 1 COMMENT '0 启用 1 禁用 默认1',
  `image` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '照片地址',
  `word_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '入驻时文档名称',
  `location` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文档地址',
  `agree` int(1) NULL DEFAULT 1 COMMENT '0 审批通过 1 审批不通过 默认1',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `logic_delete_flag` int(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除字段',
  PRIMARY KEY (`com_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '企业' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES ('52288dd286994aaaadaad9311278193b', '大唐集团', 'datang', '13688290904', 'f7d1242c66dec0edd80973031e26485c', '李世民', 1, NULL, '信工学院2016、2017级各专业学位课程.doc', '/uiaipms/company/1588746548469.doc', 1, NULL, '2020-05-06 14:29:14', 0);
INSERT INTO `company` VALUES ('8da64c96335d4047b174d6395c85820f', '大汉帝国', 'dahan', '13688290904', '90d30734f549cc293aa7dfe6b5cc9c49', '刘邦', 0, '/uiaipms/head-img/1588749873434.jpg', '《国家学生体质健康标准》登记表，男生大三、四（表格三）(1).doc', '/uiaipms/company/1588411087739.doc', 0, '2020-05-06 15:24:36', '2020-05-02 17:18:11', 0);
INSERT INTO `company` VALUES ('a90d4f8a7c3448a69dfcbb18b89f293e', '大秦帝国', 'daqin', '15908298537', 'acce54e08f2c835455aea4af5073a67c', '嬴政', 0, '/uiaipms/head-img/icon.png', '重修免听.doc', '/uiaipms/company/1588736820922.doc', 0, '2020-05-06 14:27:58', '2020-05-06 11:47:07', 0);

-- ----------------------------
-- Table structure for discipline
-- ----------------------------
DROP TABLE IF EXISTS `discipline`;
CREATE TABLE `discipline`  (
  `disc_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `disc_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '系的名称',
  `fac_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学院ID',
  PRIMARY KEY (`disc_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of discipline
-- ----------------------------
INSERT INTO `discipline` VALUES ('148d35962079460eaaacad289f68b582', '汉语国际教育', '534b320d10bd426cb4fbc4ddf823b92f');
INSERT INTO `discipline` VALUES ('35e93a34feb2486ea0e0ad3555c0c6c1', '商务英语', '91849a1a55314c788a07715a22d7e86b');
INSERT INTO `discipline` VALUES ('3b80e0e235f74ff3bac47b8bf35db79c', '体育教育', '8ca239f1aa2844289c21a5c6c225e526');
INSERT INTO `discipline` VALUES ('83d7872829a546d9b93b667d679df7c7', '休闲体育', '8ca239f1aa2844289c21a5c6c225e526');
INSERT INTO `discipline` VALUES ('a124ae391f09477997cddf4b6560e509', '工商管理', '954e8e86d67f4ad198ae0907429c8f92');
INSERT INTO `discipline` VALUES ('a2a920c7c3f045a99fd9d33b1769c643', '财务管理', '954e8e86d67f4ad198ae0907429c8f92');
INSERT INTO `discipline` VALUES ('a4e1a528c29b467e9074afee5793f206', '国际贸易', '954e8e86d67f4ad198ae0907429c8f92');
INSERT INTO `discipline` VALUES ('c5c4f22f1559449db7eb5cc7a1e639ff', '泰语', '91849a1a55314c788a07715a22d7e86b');
INSERT INTO `discipline` VALUES ('f17283b04faa4a59a744d97a252162c1', '软件工程', 'af6d4fea76c742fea432e482c391911b');
INSERT INTO `discipline` VALUES ('f6fc3aea99cb45ef87b245696cfb9a70', '计算机科学与技术', 'af6d4fea76c742fea432e482c391911b');

-- ----------------------------
-- Table structure for faculty
-- ----------------------------
DROP TABLE IF EXISTS `faculty`;
CREATE TABLE `faculty`  (
  `fac_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `fac_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学院名称',
  `fac_short_name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简称',
  PRIMARY KEY (`fac_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学院' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of faculty
-- ----------------------------
INSERT INTO `faculty` VALUES ('534b320d10bd426cb4fbc4ddf823b92f', '文学与新闻传播学院', '文新学院');
INSERT INTO `faculty` VALUES ('8ca239f1aa2844289c21a5c6c225e526', '体育学院', '体院');
INSERT INTO `faculty` VALUES ('91849a1a55314c788a07715a22d7e86b', '外国语学院', '外国语');
INSERT INTO `faculty` VALUES ('954e8e86d67f4ad198ae0907429c8f92', '商学院', '商学院');
INSERT INTO `faculty` VALUES ('af6d4fea76c742fea432e482c391911b', '信息科学与工程学院', '信工');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `goods_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `goods_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `goods_num` int(5) NULL DEFAULT NULL COMMENT '数量',
  `unit_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位',
  `goods_model` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '型号',
  `goods_brand` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌',
  `ban` int(1) NULL DEFAULT 0 COMMENT '0 可申请 1 已下架，默认0',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `logic_delete_flag` int(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除字段',
  PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '物品' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('15c088c7812a4fc28d37a358b4d9b7fa', '空调', 14, '2b00a4e19bb242cc9670f45bdfda6c60', '模拟数据-型号6', '模拟数据-品牌6', 0, '2020-05-10 10:48:30', '2020-05-03 14:49:25', 0);
INSERT INTO `goods` VALUES ('20e3c48e2ac840a48eb55112c63f8ab2', '椅子', 75, 'b4a86e649de549cc89d29c5250cb3bcd', '模拟数据-型号1', '模拟数据-品牌1', 0, '2020-05-10 10:44:31', '2020-05-03 14:42:46', 0);
INSERT INTO `goods` VALUES ('3a37adc26cc44d239b6fb4378cd2006c', '咖啡凳', 355, 'b4a86e649de549cc89d29c5250cb3bcd', '模拟数据-型号8', '模拟数据-品牌8', 0, '2020-05-10 10:44:34', '2020-05-03 14:50:54', 0);
INSERT INTO `goods` VALUES ('5797b9c72aaf42769d8a754167fe45ae', '路由器', 94, '2b00a4e19bb242cc9670f45bdfda6c60', '模拟数据-型号2', '模拟数据-品牌2', 0, '2020-05-06 15:12:06', '2020-05-03 14:43:50', 0);
INSERT INTO `goods` VALUES ('65aed7b07efd4141bfb0d6b402f83e8d', '办公桌', 90, 'b4a86e649de549cc89d29c5250cb3bcd', '模拟数据-型号3', '模拟数据-品牌3', 0, '2020-05-03 15:06:33', '2020-05-03 14:44:42', 0);
INSERT INTO `goods` VALUES ('6937cee5b3fc4865bb5965e4318f3bdb', '咖啡桌', 70, 'b4a86e649de549cc89d29c5250cb3bcd', '模拟数据-型号7', '模拟数据-品牌7', 0, '2020-05-03 15:11:04', '2020-05-03 14:50:08', 0);
INSERT INTO `goods` VALUES ('781c1a7a30c94be7a408d456a1ddda0e', '咖啡凳', 80, 'b4a86e649de549cc89d29c5250cb3bcd', '模拟数据-型号10', '模拟数据-品牌10', 0, '2020-05-10 10:44:21', '2020-05-03 15:10:19', 0);
INSERT INTO `goods` VALUES ('b895d888af4e4e4e9128120447ae1294', '铁皮箱', 83, 'bef6ce6b6bfb414bb773e9823baf8ac3', '模拟数据-型号5', '模拟数据-品牌5', 0, '2020-05-10 10:44:37', '2020-05-03 14:48:09', 0);
INSERT INTO `goods` VALUES ('c569782d7dfa4e12800fb7f5c06ae783', '网线', 175, '16c327eea32e488f9793daf7c66218d7', '模拟数据-型号4', '模拟数据-品牌4', 0, '2020-05-10 10:49:57', '2020-05-03 14:47:30', 0);

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`  (
  `pro_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `pro_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `stu_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请学生ID',
  `word_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '本地文件名',
  `pro_location` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目材料路径',
  `pro_desc` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目描述',
  `success` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否成功结题 0 成功 1失败',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `logic_delete_flag` int(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除字段',
  PRIMARY KEY (`pro_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '项目' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('155f83fd878941c683027018e530f281', '范睢的第1个项目', 'e71fdd8e9f274b349456b45c2862b389', '重修免听.doc', '/uiaipms/word/1589075769583.doc', '范睢的第1个项目，范睢的第1个项目，范睢的第1个项目', '0', '2020-05-10 10:34:21', '2020-05-10 09:56:12', 0);
INSERT INTO `project` VALUES ('1581a5fe17054b9d81fe58ffd98c05df', '白起项目7', 'e691218ee9d84fbf93939c1a2fa66417', '文显松-成大信工-实习实训项目解决复杂工程问题总结报告.doc', '/uiaipms/word/1588919635972.doc', '白起项目7，白起项目7，白起项目7，白起项目7', '0', '2020-05-08 14:34:01', '2020-05-08 14:34:01', 0);
INSERT INTO `project` VALUES ('1864ddd91714420fa2431aac478978bb', '李牧项目4，', '332bdd84d33d48bc80acd7cf86afa5a6', 'My SQL.docx', '/uiaipms/word/1588919982292.docx', '李牧项目4，李牧项目4，李牧项目4，李牧项目4', '0', '2020-05-08 14:39:47', '2020-05-08 14:39:47', 0);
INSERT INTO `project` VALUES ('1865a418fa1d459ca3a55fa787075163', 'ftp文档上传项目', 'e691218ee9d84fbf93939c1a2fa66417', 'd成都大学学生入学“绿色通道”审批表（填表规范）.doc', '/uiaipms/word/1588412250062.doc', 'ftp文档上传项目，ftp文档上传项目，ftp文档上传项目，ftp文档上传项目，ftp文档上传项目', NULL, '2020-05-02 17:37:35', '2020-05-02 17:37:35', 0);
INSERT INTO `project` VALUES ('272661cbf1904b0b8eb096ba8104f8f1', '李牧项目8，', '332bdd84d33d48bc80acd7cf86afa5a6', '文显松的简历.doc', '/uiaipms/word/1588920046599.doc', '李牧项目8，李牧项目8，李牧项目8，李牧项目8，', NULL, '2020-05-08 14:40:51', '2020-05-08 14:40:51', 0);
INSERT INTO `project` VALUES ('280d33966b38424ca820ee2af9a33574', '李牧项目2', '332bdd84d33d48bc80acd7cf86afa5a6', '《国家学生体质健康标准》登记表，男生大三、四（表格三）(1).doc', '/uiaipms/word/1588919929273.doc', '李牧项目1，李牧项目1，李牧项目1，李牧项目1，李牧项目1', NULL, '2020-05-08 14:38:53', '2020-05-08 14:38:53', 0);
INSERT INTO `project` VALUES ('282fa8c1bd23477bab7f7121e11b0477', '李牧的第一个项目', '332bdd84d33d48bc80acd7cf86afa5a6', '新建 Microsoft Word 文档13.docx', '/uiaipms/word/1588747396850.docx', '李牧的第一个项目，李牧的第一个项目，李牧的第一个项目，李牧的第一个项目', '0', '2020-05-06 14:43:22', '2020-05-06 14:43:22', 0);
INSERT INTO `project` VALUES ('28d26c1d9128454aa1d394d0ee885c50', '白起项目5', 'e691218ee9d84fbf93939c1a2fa66417', '实习报告册_文显松.docx', '/uiaipms/word/1588919386402.docx', '白起项目5，白起项目5，白起项目5，白起项目5', NULL, '2020-05-08 14:29:50', '2020-05-08 14:29:50', 0);
INSERT INTO `project` VALUES ('39831d8b1e58426ba9cc442a1cbdaca0', '范睢的第2个项目', 'e71fdd8e9f274b349456b45c2862b389', '信工学院2016、2017级各专业学位课程.doc', '/uiaipms/word/1589075785439.doc', '范睢的第2个项目，范睢的第2个项目，范睢的第2个项目', NULL, '2020-05-10 09:56:28', '2020-05-10 09:56:28', 0);
INSERT INTO `project` VALUES ('40732a9bc59b40aa9542131e3bdc6232', '李牧的第二个项目', '332bdd84d33d48bc80acd7cf86afa5a6', '16级毕业实习提交通知.docx', '/uiaipms/word/1588919137121.docx', '重新申报，李牧的第二个项目，李牧的第二个项目，李牧的第二个项目', NULL, '2020-05-08 14:25:42', '2020-05-08 14:25:42', 0);
INSERT INTO `project` VALUES ('69e732c2a48841d19a613d920342a9b0', '李牧项目1', '332bdd84d33d48bc80acd7cf86afa5a6', '信工学院志愿服务类素质学分认证通知 .docx', '/uiaipms/word/1588919892098.docx', '李牧项目1，李牧项目1，李牧项目1，李牧项目1', NULL, '2020-05-08 14:38:17', '2020-05-08 14:38:17', 0);
INSERT INTO `project` VALUES ('6bbae7a23a9d443f8fe739e222f35808', '白起项目6', 'e691218ee9d84fbf93939c1a2fa66417', '陈亮_实习报告册.docx', '/uiaipms/word/1588919412209.docx', '白起项目6，白起项目6，白起项目6，白起项目6', NULL, '2020-05-08 14:30:16', '2020-05-08 14:30:16', 0);
INSERT INTO `project` VALUES ('6c41b9af9bda4c76a61fc97e2c79c77e', '白起项目10', 'e691218ee9d84fbf93939c1a2fa66417', '附件一（成都大学志愿者服务活动记录卡）.docx', '/uiaipms/word/1588919693498.docx', '白起项目10，白起项目10，白起项目10，白起项目10', NULL, '2020-05-08 14:34:58', '2020-05-08 14:34:58', 0);
INSERT INTO `project` VALUES ('719560ec8e30439a81d24a751ee7b1fc', '范睢的第4个项目', 'e71fdd8e9f274b349456b45c2862b389', '新建 Microsoft Word 文档.docx', '/uiaipms/word/1589075819821.docx', '范睢的第4个项目，范睢的第4个项目，范睢的第4个项目', NULL, '2020-05-10 09:57:02', '2020-05-10 09:57:02', 0);
INSERT INTO `project` VALUES ('7292fcc0ac3948f7b25ca11f967a0ad7', '白起项目9', 'e691218ee9d84fbf93939c1a2fa66417', '附件三（成都大学志愿服务学分认定总结报告）.docx', '/uiaipms/word/1588919675923.docx', '白起项目9，白起项目9，白起项目9，白起项目9', NULL, '2020-05-08 14:34:40', '2020-05-08 14:34:40', 0);
INSERT INTO `project` VALUES ('72d0e516f272420e99a72b673b706fb2', '李牧项目6，', '332bdd84d33d48bc80acd7cf86afa5a6', '国家助学金申请表-文.doc', '/uiaipms/word/1588920014628.doc', '李牧项目6，李牧项目6，李牧项目6，李牧项目6', NULL, '2020-05-08 14:40:19', '2020-05-08 14:40:19', 0);
INSERT INTO `project` VALUES ('77e9447db6734f02ac4b2cd853de3b3d', '李牧项目5，', '332bdd84d33d48bc80acd7cf86afa5a6', '文显松的简历.doc', '/uiaipms/word/1588919998624.doc', '李牧项目5，李牧项目5，李牧项目5，李牧项目5', NULL, '2020-05-08 14:40:02', '2020-05-08 14:40:02', 0);
INSERT INTO `project` VALUES ('7aa39ca0097b43d1b4b8d83ca18d85c5', '白起项目1', 'e691218ee9d84fbf93939c1a2fa66417', '125214.doc', '/uiaipms/word/1588919320781.doc', '白起项目1，白起项目1，白起项目1，白起项目1', NULL, '2020-05-08 14:28:45', '2020-05-08 14:28:45', 0);
INSERT INTO `project` VALUES ('7cdc571770f14f13b763e345e5a6df65', '范睢的第3个项目', 'e71fdd8e9f274b349456b45c2862b389', '新建 Microsoft Word 文档13.docx', '/uiaipms/word/1589075802072.docx', '范睢的第3个项目，范睢的第3个项目，范睢的第3个项目', '0', '2020-05-10 10:34:32', '2020-05-10 09:56:44', 0);
INSERT INTO `project` VALUES ('80f5e28c94d846b0a7f2ecb75002cb6b', '范睢的第6个项目', 'e71fdd8e9f274b349456b45c2862b389', '文显松-成大信工-实习实训项目解决复杂工程问题总结报告.doc', '/uiaipms/word/1589075852600.doc', '范睢的第6个项目，范睢的第6个项目，范睢的第6个项目', NULL, '2020-05-10 09:57:35', '2020-05-10 09:57:35', 0);
INSERT INTO `project` VALUES ('9409d06a91804102ad0b68ceb6fba428', '李牧项目9，', '332bdd84d33d48bc80acd7cf86afa5a6', '重修免听.doc', '/uiaipms/word/1588920067228.doc', '李牧项目9，李牧项目9，李牧项目9，李牧项目9', NULL, '2020-05-08 14:41:11', '2020-05-08 14:41:11', 0);
INSERT INTO `project` VALUES ('a0bb27667cb24101b15790050ed81b33', '范睢的第5个项目', 'e71fdd8e9f274b349456b45c2862b389', '文显松的简历.doc', '/uiaipms/word/1589075836048.doc', '范睢的第5个项目，范睢的第5个项目，范睢的第5个项目', NULL, '2020-05-10 09:57:19', '2020-05-10 09:57:19', 0);
INSERT INTO `project` VALUES ('ae135688df73424b91fabb8427a9394b', '白起项目3', 'e691218ee9d84fbf93939c1a2fa66417', '附件1;承诺书.docx', '/uiaipms/word/1588919353646.docx', '白起项目3，白起项目3，白起项目3，白起项目3', NULL, '2020-05-08 14:29:18', '2020-05-08 14:29:18', 0);
INSERT INTO `project` VALUES ('ae69e41f354045258b0e2178c20a0c5c', '李牧的第三个项目', '332bdd84d33d48bc80acd7cf86afa5a6', '文显松的简历.doc', '/uiaipms/word/1588747501670.doc', '李牧的第三个项目，李牧的第三个项目，李牧的第三个项目', '0', '2020-05-06 14:45:07', '2020-05-06 14:45:07', 0);
INSERT INTO `project` VALUES ('b67dbdeb51804fb19d72b748aa6e53ef', '白起项目8', 'e691218ee9d84fbf93939c1a2fa66417', '附件二（成都大学志愿者服务活动证明材料）.docx', '/uiaipms/word/1588919658282.docx', '白起项目8，白起项目8，白起项目8，白起项目8', NULL, '2020-05-08 14:34:23', '2020-05-08 14:34:23', 0);
INSERT INTO `project` VALUES ('b8393de09ddb4982a1b3147c92e66108', '白起项目4', 'e691218ee9d84fbf93939c1a2fa66417', '附件2;集中实习承诺书.docx', '/uiaipms/word/1588919370881.docx', '白起项目4，白起项目4，白起项目4，白起项目4', NULL, '2020-05-08 14:29:35', '2020-05-08 14:29:35', 0);
INSERT INTO `project` VALUES ('bf0e485d9cdd42b6a64e285a95556369', '白起项目2', 'e691218ee9d84fbf93939c1a2fa66417', '125214张.doc', '/uiaipms/word/1588919337794.doc', '白起项目2，白起项目2，白起项目2，白起项目2', '1', '2020-05-08 14:29:01', '2020-05-08 14:29:01', 0);
INSERT INTO `project` VALUES ('bfa28870b6f14052892d6b2849dec733', '李牧项目7，', '332bdd84d33d48bc80acd7cf86afa5a6', '网签操作流程.docx', '/uiaipms/word/1588920030271.docx', '李牧项目7，李牧项目7，李牧项目7，李牧项目7，', NULL, '2020-05-08 14:40:34', '2020-05-08 14:40:34', 0);
INSERT INTO `project` VALUES ('c15dbe7b6dd94ff299f7cd33342266c2', '测试项目申报', 'e691218ee9d84fbf93939c1a2fa66417', 'My SQL.docx', '/uiaipms/word/1588412328279.docx', '测试项目申报，测试项目申报，测试项目申报，测试项目申报', NULL, '2020-05-02 17:38:51', '2020-05-02 17:38:51', 0);
INSERT INTO `project` VALUES ('c1ff44775f9244ceb6dfde17553b8bb3', '范睢的第10个项目', 'e71fdd8e9f274b349456b45c2862b389', 'My SQL.docx', '/uiaipms/word/1589075940823.docx', '范睢的第10个项目，范睢的第10个项目，范睢的第10个项目', NULL, '2020-05-10 09:59:03', '2020-05-10 09:59:03', 0);
INSERT INTO `project` VALUES ('c3267e7c780743c9b0c5bb7352f1475e', '李牧项目10，', '332bdd84d33d48bc80acd7cf86afa5a6', '信工学院2016、2017级各专业学位课程.doc', '/uiaipms/word/1588920082481.doc', '李牧项目10，李牧项目10，李牧项目10，李牧项目10，李牧项目10，', NULL, '2020-05-08 14:41:27', '2020-05-08 14:41:27', 0);
INSERT INTO `project` VALUES ('c451df7a750943f3b3882d5833b827a7', '李牧的第二个项目', '332bdd84d33d48bc80acd7cf86afa5a6', '新建 Microsoft Word 文档.docx', '/uiaipms/word/1588747419623.docx', '李牧的第二个项目，李牧的第二个项目，李牧的第二个项目，李牧的第二个项目', NULL, '2020-05-07 09:59:27', '2020-05-06 14:43:44', 1);
INSERT INTO `project` VALUES ('c717019bf3a54c1cbb6b97ab3bc2c0b2', '测试项目上传', 'e691218ee9d84fbf93939c1a2fa66417', 'd四川省学生资助管理系统银行卡号及开户行核对修改流程.docx', '/uiaipms/word/1588412284723.docx', '测试项目上传，测试项目上传，测试项目上传，测试项目上传', '0', '2020-05-02 17:38:07', '2020-05-02 17:38:07', 0);
INSERT INTO `project` VALUES ('c756d731f19a40caa93a71f6f535cd95', '李牧项目2，', '332bdd84d33d48bc80acd7cf86afa5a6', 'd成都大学学生入学“绿色通道”审批表（填表规范）.doc', '/uiaipms/word/1588919949468.doc', '李牧项目2，李牧项目2，李牧项目2，李牧项目2', NULL, '2020-05-08 14:39:13', '2020-05-08 14:39:13', 0);
INSERT INTO `project` VALUES ('cd9cff9694d949b297a134beab4a94e0', '李牧的第四个项目', '332bdd84d33d48bc80acd7cf86afa5a6', '网签操作流程.docx', '/uiaipms/word/1588747571532.docx', '李牧的第四个项目，李牧的第四个项目，李牧的第四个项目', NULL, '2020-05-06 14:46:17', '2020-05-06 14:46:17', 0);
INSERT INTO `project` VALUES ('d1e45bbbcf44416e8c9a05d8fe076037', '范睢的第7个项目', 'e71fdd8e9f274b349456b45c2862b389', '网签操作流程.docx', '/uiaipms/word/1589075888717.docx', '范睢的第7个项目，范睢的第7个项目，范睢的第7个项目', '0', '2020-05-10 10:34:16', '2020-05-10 09:58:11', 0);
INSERT INTO `project` VALUES ('d45e9d2f272a4e60be1f7667f42c102c', '李牧项目3，', '332bdd84d33d48bc80acd7cf86afa5a6', 'd四川省学生资助管理系统银行卡号及开户行核对修改流程.docx', '/uiaipms/word/1588919965276.docx', '李牧项目3，李牧项目3，李牧项目3，李牧项目3', NULL, '2020-05-08 14:39:30', '2020-05-08 14:39:30', 0);
INSERT INTO `project` VALUES ('ec8bf8dc772243828c77c09b1ded2394', '范睢的第9个项目', 'e71fdd8e9f274b349456b45c2862b389', '国家助学金申请表.doc', '/uiaipms/word/1589075922147.doc', '范睢的第9个项目，范睢的第9个项目，范睢的第9个项目', '0', '2020-05-10 10:34:27', '2020-05-10 09:58:45', 0);
INSERT INTO `project` VALUES ('f415476aa7ea41d6b4d223e86684478c', '范睢的第8个项目', 'e71fdd8e9f274b349456b45c2862b389', '国家助学金申请表-文.doc', '/uiaipms/word/1589075906401.doc', '范睢的第8个项目，范睢的第8个项目，范睢的第8个项目', NULL, '2020-05-10 09:58:29', '2020-05-10 09:58:29', 0);

-- ----------------------------
-- Table structure for project_approval
-- ----------------------------
DROP TABLE IF EXISTS `project_approval`;
CREATE TABLE `project_approval`  (
  `pa_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `pro_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目ID',
  `tutor_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审批导师ID',
  `pass_flag` int(1) NULL DEFAULT 1 COMMENT '是否通过标记 0 通过 1未通过， 默认 1',
  `reason` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '原因',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `logic_delete_flag` int(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除字段',
  PRIMARY KEY (`pa_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '项目审批记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project_approval
-- ----------------------------
INSERT INTO `project_approval` VALUES ('0887fb73fdf64a3c9086aa58db9e3d96', '719560ec8e30439a81d24a751ee7b1fc', 'e80f275768a24d9e855bf5595a6e1f33', 0, '同意，同意，同意，同意，同意，同意，', '2020-05-10 10:00:04', '2020-05-10 09:57:02', 0);
INSERT INTO `project_approval` VALUES ('1950e5dae6ac4bff9a213b60446f5cec', 'ae69e41f354045258b0e2178c20a0c5c', 'e80f275768a24d9e855bf5595a6e1f33', 0, '李牧的第三个项目------同意', '2020-05-06 14:47:37', '2020-05-06 14:45:07', 0);
INSERT INTO `project_approval` VALUES ('1d1a8dfb98ac4f7aa1cb87391aa54d26', '1864ddd91714420fa2431aac478978bb', 'e80f275768a24d9e855bf5595a6e1f33', 0, '通过，通过，通过，通过，通过，', '2020-05-08 14:42:41', '2020-05-08 14:39:47', 0);
INSERT INTO `project_approval` VALUES ('21f996435ba84dea9b43a07d60eda80a', '39831d8b1e58426ba9cc442a1cbdaca0', 'e80f275768a24d9e855bf5595a6e1f33', 0, '同意，同意，同意，同意，同意，同意，', '2020-05-10 10:00:11', '2020-05-10 09:56:28', 0);
INSERT INTO `project_approval` VALUES ('274a8e57a4be4855afe52d6550b0b380', '1581a5fe17054b9d81fe58ffd98c05df', 'e80f275768a24d9e855bf5595a6e1f33', 0, '通过，通过，通过，通过，通过，', '2020-05-08 14:42:50', '2020-05-08 14:34:01', 0);
INSERT INTO `project_approval` VALUES ('2c8cf37c3f66418fadb7ef19d615b4b1', '6bbae7a23a9d443f8fe739e222f35808', 'e80f275768a24d9e855bf5595a6e1f33', 0, '通过，通过，通过，通过，通过，', '2020-05-08 14:42:57', '2020-05-08 14:30:16', 0);
INSERT INTO `project_approval` VALUES ('2de75b6f27f648688f471472f41a030d', 'd1e45bbbcf44416e8c9a05d8fe076037', 'e80f275768a24d9e855bf5595a6e1f33', 0, '同意，同意，同意，同意，同意，同意，同意，', '2020-05-10 10:00:17', '2020-05-10 09:58:11', 0);
INSERT INTO `project_approval` VALUES ('30bc758adb524310bf0a02da9daf594e', 'bf0e485d9cdd42b6a64e285a95556369', 'e80f275768a24d9e855bf5595a6e1f33', 0, '通过，通过，通过，通过，通过，通过，', '2020-05-08 14:43:05', '2020-05-08 14:29:01', 0);
INSERT INTO `project_approval` VALUES ('31d8a91e68ba4775a056da59163bb41f', '7aa39ca0097b43d1b4b8d83ca18d85c5', 'e80f275768a24d9e855bf5595a6e1f33', 0, '通过，通过，通过，通过，通过，通过，', '2020-05-08 14:43:11', '2020-05-08 14:28:45', 0);
INSERT INTO `project_approval` VALUES ('3439c452c14f4f699e3e22ed1f8fdd4f', '282fa8c1bd23477bab7f7121e11b0477', 'e80f275768a24d9e855bf5595a6e1f33', 0, '李牧的第一个项目------同意', '2020-05-06 14:47:12', '2020-05-06 14:43:22', 0);
INSERT INTO `project_approval` VALUES ('3db8dab54b4b4117829ab63c183e8e3f', '69e732c2a48841d19a613d920342a9b0', 'e80f275768a24d9e855bf5595a6e1f33', 0, '通过，通过，通过，通过，通过，通过，通过，', '2020-05-08 14:43:16', '2020-05-08 14:38:17', 0);
INSERT INTO `project_approval` VALUES ('3e80e6e31b8543f7875429ade6b7474a', '1865a418fa1d459ca3a55fa787075163', 'e80f275768a24d9e855bf5595a6e1f33', 0, 'ftp文档上传项目同意，ftp文档上传项目同意，ftp文档上传项目同意', '2020-05-02 17:41:08', '2020-05-02 17:37:35', 0);
INSERT INTO `project_approval` VALUES ('4329ee64de4641f8b34c90ffe76c342e', '6c41b9af9bda4c76a61fc97e2c79c77e', 'e80f275768a24d9e855bf5595a6e1f33', 1, '不通过，不通过，不通过，不通过，不通过，', '2020-05-08 14:43:26', '2020-05-08 14:34:58', 0);
INSERT INTO `project_approval` VALUES ('488454b6278e46358ca6b8bcb7e2fe61', '7cdc571770f14f13b763e345e5a6df65', 'e80f275768a24d9e855bf5595a6e1f33', 0, '同意，同意，同意，同意，同意，同意，', '2020-05-10 10:00:40', '2020-05-10 09:56:44', 0);
INSERT INTO `project_approval` VALUES ('4f588dc715ac41df9a20ad6e1ecc4531', '9409d06a91804102ad0b68ceb6fba428', 'e80f275768a24d9e855bf5595a6e1f33', 0, '通过，通过，通过，通过，通过，通过，', '2020-05-08 14:43:32', '2020-05-08 14:41:11', 0);
INSERT INTO `project_approval` VALUES ('651a5180c1db487e8b3adc3b254e3fd8', 'd45e9d2f272a4e60be1f7667f42c102c', 'e80f275768a24d9e855bf5595a6e1f33', 0, '通过，通过，通过，通过，通过，通过，', '2020-05-08 14:43:37', '2020-05-08 14:39:30', 0);
INSERT INTO `project_approval` VALUES ('6e95b1c0663a4c81b4266c61abc61725', '7292fcc0ac3948f7b25ca11f967a0ad7', 'e80f275768a24d9e855bf5595a6e1f33', 0, '通过，通过，通过，通过，通过，通过，', '2020-05-08 14:44:10', '2020-05-08 14:34:40', 0);
INSERT INTO `project_approval` VALUES ('7eb8f4d10f7b4414863cc7827ded778c', '28d26c1d9128454aa1d394d0ee885c50', 'e80f275768a24d9e855bf5595a6e1f33', 0, '通过，通过，通过，通过，通过，通过，', '2020-05-08 14:43:42', '2020-05-08 14:29:50', 0);
INSERT INTO `project_approval` VALUES ('7f47083190c94471b49a3a061b3682be', 'c717019bf3a54c1cbb6b97ab3bc2c0b2', 'e80f275768a24d9e855bf5595a6e1f33', 0, '测试项目上传同意，测试项目上传同意，测试项目上传同意', '2020-05-02 17:41:38', '2020-05-02 17:38:07', 0);
INSERT INTO `project_approval` VALUES ('84b59c0a0b714fdd8ba1d1649e086194', '272661cbf1904b0b8eb096ba8104f8f1', 'e80f275768a24d9e855bf5595a6e1f33', 1, '不通过，不通过，不通过，不通过，不通过，', '2020-05-08 14:44:02', '2020-05-08 14:40:51', 0);
INSERT INTO `project_approval` VALUES ('871e78ad0a0a46afba72e33011dd00e3', 'c3267e7c780743c9b0c5bb7352f1475e', NULL, 1, NULL, NULL, '2020-05-08 14:41:27', 0);
INSERT INTO `project_approval` VALUES ('930b1e0a73564270a6c3993e3ef98e2a', 'c15dbe7b6dd94ff299f7cd33342266c2', 'e80f275768a24d9e855bf5595a6e1f33', 1, '不通过，不通过，不通过，不通过，不通过，', '2020-05-08 14:43:47', '2020-05-02 17:38:51', 0);
INSERT INTO `project_approval` VALUES ('96ae465cfd5d4e34a2398a204d7445fb', '77e9447db6734f02ac4b2cd853de3b3d', 'e80f275768a24d9e855bf5595a6e1f33', 0, '同意，同意，同意，同意，同意，', '2020-05-08 16:10:20', '2020-05-08 14:40:02', 0);
INSERT INTO `project_approval` VALUES ('99e29970581d478c844111b3d545f738', 'cd9cff9694d949b297a134beab4a94e0', 'e80f275768a24d9e855bf5595a6e1f33', 0, '同意，同意，同意，同意，同意，', '2020-05-08 16:10:11', '2020-05-06 14:46:17', 0);
INSERT INTO `project_approval` VALUES ('9f2fac71a09c46888745ef7cbee5931a', 'c756d731f19a40caa93a71f6f535cd95', NULL, 1, NULL, NULL, '2020-05-08 14:39:13', 0);
INSERT INTO `project_approval` VALUES ('a31dbd97ce6043759a302c645ae27abc', 'b8393de09ddb4982a1b3147c92e66108', 'e80f275768a24d9e855bf5595a6e1f33', 0, '同意，同意，同意，同意，同意，', '2020-05-08 16:10:16', '2020-05-08 14:29:35', 0);
INSERT INTO `project_approval` VALUES ('a9189aadeafa4ad4a4d33d86c3c83248', 'c1ff44775f9244ceb6dfde17553b8bb3', NULL, 1, NULL, NULL, '2020-05-10 09:59:03', 0);
INSERT INTO `project_approval` VALUES ('aaa5abc252834892afca95c2acbca3e5', '155f83fd878941c683027018e530f281', 'e80f275768a24d9e855bf5595a6e1f33', 0, '同意，同意，同意，同意，同意，同意，', '2020-05-10 10:00:26', '2020-05-10 09:56:12', 0);
INSERT INTO `project_approval` VALUES ('b47101f59ed94ab5aa66d93b20d71ad9', '72d0e516f272420e99a72b673b706fb2', 'e80f275768a24d9e855bf5595a6e1f33', 0, '同意，同意，同意，同意，同意，同意，', '2020-05-08 16:10:05', '2020-05-08 14:40:19', 0);
INSERT INTO `project_approval` VALUES ('c25d73a232764c8cb65f159176afe3e8', 'ae135688df73424b91fabb8427a9394b', NULL, 1, NULL, NULL, '2020-05-08 14:29:18', 0);
INSERT INTO `project_approval` VALUES ('c39d333798e94a148d5193c322e13ced', 'f415476aa7ea41d6b4d223e86684478c', NULL, 1, NULL, NULL, '2020-05-10 09:58:29', 0);
INSERT INTO `project_approval` VALUES ('c5625289bb3d43eba89a6c01e331ec01', 'bfa28870b6f14052892d6b2849dec733', NULL, 1, NULL, NULL, '2020-05-08 14:40:34', 0);
INSERT INTO `project_approval` VALUES ('c5ec762ff55946caba600a05933962f9', 'a0bb27667cb24101b15790050ed81b33', NULL, 1, NULL, NULL, '2020-05-10 09:57:19', 0);
INSERT INTO `project_approval` VALUES ('c6056c40cdec43a2a9009ff3b2c97ae9', '776ff313f99245ca9426dc88482b3901', NULL, 1, NULL, NULL, '2020-05-07 09:59:27', 0);
INSERT INTO `project_approval` VALUES ('ca6ea6f45d01427ebd3a139b4451204b', 'ec8bf8dc772243828c77c09b1ded2394', 'e80f275768a24d9e855bf5595a6e1f33', 0, '同意，同意，同意，同意，同意，同意，', '2020-05-10 10:00:34', '2020-05-10 09:58:45', 0);
INSERT INTO `project_approval` VALUES ('d480473fee264025ba96d3d6e4422ab8', '40732a9bc59b40aa9542131e3bdc6232', NULL, 1, NULL, NULL, '2020-05-08 14:25:42', 0);
INSERT INTO `project_approval` VALUES ('da97c1d4dbdb4ebb800aebb18c0cfc7a', '280d33966b38424ca820ee2af9a33574', NULL, 1, NULL, NULL, '2020-05-08 14:38:53', 0);
INSERT INTO `project_approval` VALUES ('eccdea19bc3249e6a93aa8ab0f6b9d5f', 'c451df7a750943f3b3882d5833b827a7', 'e80f275768a24d9e855bf5595a6e1f33', 0, '李牧的第二个项目------同意', '2020-05-06 14:47:24', '2020-05-06 14:43:44', 0);
INSERT INTO `project_approval` VALUES ('f31b167ad44a4037b117fd29f6cb14db', 'b67dbdeb51804fb19d72b748aa6e53ef', 'e80f275768a24d9e855bf5595a6e1f33', 0, '同意，同意，同意，同意，同意，', '2020-05-08 16:10:28', '2020-05-08 14:34:23', 0);
INSERT INTO `project_approval` VALUES ('fbcebc9ce4f34a8bb1dd484f6f5aafe2', '80f5e28c94d846b0a7f2ecb75002cb6b', NULL, 1, NULL, NULL, '2020-05-10 09:57:35', 0);

-- ----------------------------
-- Table structure for project_finance
-- ----------------------------
DROP TABLE IF EXISTS `project_finance`;
CREATE TABLE `project_finance`  (
  `pf_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `admin_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员',
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请人',
  `pf_amount` decimal(10, 0) NULL DEFAULT NULL COMMENT '金额',
  `apply_reason` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请原因',
  `pro_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目',
  `deal` int(1) NULL DEFAULT 1 COMMENT '是否处理 0 已处理 1未处理 默认 1',
  `agree` int(1) NULL DEFAULT 1 COMMENT '是否同意 0 同意 1 不同意 默认 1',
  `review_reason` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '同意与否的原因',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `logic_delete_flag` int(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除字段',
  PRIMARY KEY (`pf_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '项目拨款财务记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project_finance
-- ----------------------------
INSERT INTO `project_finance` VALUES ('04e1d2b87a524c569c8b1f2d20c2050b', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 120, '资金申请，资金申请，资金申请，资金申请，资金申请，', 'd1e45bbbcf44416e8c9a05d8fe076037', 0, 0, '同意申请，同意申请，同意申请，同意申请，', '2020-05-10 10:31:59', '2020-05-10 10:03:18', 0);
INSERT INTO `project_finance` VALUES ('0f2abde7e1b844b4974a05d3626cec1e', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 150, '资金申请，资金申请，资金申请，资金申请，资金申请，', 'd1e45bbbcf44416e8c9a05d8fe076037', 0, 0, '同意申请，同意申请，同意申请，同意申请，', '2020-05-10 10:31:49', '2020-05-10 10:03:42', 0);
INSERT INTO `project_finance` VALUES ('10d2644ba49a48a89df2942ee4b3d46f', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 360, '资金申请，资金申请，资金申请，资金申请，资金申请，', '69e732c2a48841d19a613d920342a9b0', 0, 0, 'jsndjsadhnsjlkdnsajkdnsajkdna', '2020-05-10 16:42:06', '2020-05-10 10:07:28', 0);
INSERT INTO `project_finance` VALUES ('14d320682e6a4da98ea8886cdff6f8e7', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 210, '资金申请，资金申请，资金申请，资金申请，', 'ec8bf8dc772243828c77c09b1ded2394', 0, 0, '同意申请，同意申请，同意申请，同意申请，', '2020-05-10 10:24:51', '2020-05-10 10:04:45', 0);
INSERT INTO `project_finance` VALUES ('162a14adf6e946948d9ec5cec844a941', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 300, '测试，测试，测试，测试，测试，测试，', 'bf0e485d9cdd42b6a64e285a95556369', 0, 0, '同意，同意，同意，同意，同意，同意，', '2020-05-08 14:52:01', '2020-05-08 14:50:31', 0);
INSERT INTO `project_finance` VALUES ('19ed167429654a54acb411db5f298669', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 130, '资金申请，资金申请，资金申请，资金申请，资金申请，', 'd1e45bbbcf44416e8c9a05d8fe076037', 0, 0, '同意申请，同意申请，同意申请，同意申请，', '2020-05-10 10:31:54', '2020-05-10 10:03:26', 0);
INSERT INTO `project_finance` VALUES ('2cb166e49ceb4a5dbe7ff8b60262de67', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 350, '资金申请，资金申请，资金申请，资金申请，资金申请，', '6bbae7a23a9d443f8fe739e222f35808', 0, 0, '同意申请，同意申请，同意申请，同意申请，', '2020-05-10 10:23:59', '2020-05-10 10:07:09', 0);
INSERT INTO `project_finance` VALUES ('2ff783849dff431a94738c451f533b6c', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 500, '测试，测试，测试，测试，测试，测试，测试，测试', 'c717019bf3a54c1cbb6b97ab3bc2c0b2', 0, 0, '测试-同意，测试-同意，测试-同意，测试-同意，测试-同意', '2020-05-02 17:51:02', '2020-05-01 17:50:22', 0);
INSERT INTO `project_finance` VALUES ('345ad69962dc405d83fa430c9c1777d6', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 160, '资金申请，资金申请，资金申请，资金申请，资金申请，', '155f83fd878941c683027018e530f281', 0, 0, '同意申请，同意申请，同意申请，同意申请，', '2020-05-10 10:25:15', '2020-05-10 10:03:52', 0);
INSERT INTO `project_finance` VALUES ('373aff90e4f948ee87deefcc223e9242', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 270, '资金申请，资金申请，资金申请，资金申请，资金申请，', '7cdc571770f14f13b763e345e5a6df65', 0, 0, '同意申请，同意申请，同意申请，', '2020-05-10 10:24:29', '2020-05-10 10:05:29', 0);
INSERT INTO `project_finance` VALUES ('381682aeebb047afb16313569bac2f83', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 250, '资金申请，资金申请，资金申请，资金申请，资金申请，', 'ec8bf8dc772243828c77c09b1ded2394', 0, 0, '同意申请，同意申请，同意申请，同意申请，', '2020-05-10 10:24:37', '2020-05-10 10:05:15', 0);
INSERT INTO `project_finance` VALUES ('3959f95725b04b0e9689944318ebb53e', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 300, '测试，测试，测试，测试，测试，', '1865a418fa1d459ca3a55fa787075163', 0, 0, '同意，同意，同意，同意，同意，同意，', '2020-05-08 14:52:13', '2020-05-08 14:49:53', 0);
INSERT INTO `project_finance` VALUES ('50adae1483664b10870002887d805b4d', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 260, '资金申请，资金申请，资金申请，资金申请，资金申请，', '7cdc571770f14f13b763e345e5a6df65', 0, 0, '同意申请，同意申请，同意申请，同意申请，', '2020-05-10 10:31:26', '2020-05-10 10:05:21', 0);
INSERT INTO `project_finance` VALUES ('52310c09917741b2917aee0d8a55e570', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 240, '资金申请，资金申请，资金申请，资金申请，资金申请，\n', 'ec8bf8dc772243828c77c09b1ded2394', 0, 0, '同意申请，同意申请，同意申请，同意申请，', '2020-05-10 10:24:45', '2020-05-10 10:05:08', 0);
INSERT INTO `project_finance` VALUES ('526f515e1d7c48c78d79066692baa6d7', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 300, '测试，测试，测试，测试，测试，测试，测试', 'c717019bf3a54c1cbb6b97ab3bc2c0b2', 0, 1, '同意，同意，同意，同意，同意，同意，同意', '2020-05-02 18:07:43', '2020-05-01 18:06:53', 0);
INSERT INTO `project_finance` VALUES ('5767a502f696405f96502b5897ac9d13', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 200, '资金申请，资金申请，资金申请，资金申请，资金申请，资金申请，', '155f83fd878941c683027018e530f281', 0, 0, '同意申请，同意申请，同意申请，同意申请，', '2020-05-10 10:24:57', '2020-05-10 10:04:29', 0);
INSERT INTO `project_finance` VALUES ('5c45811478d94cee8a00ae78f3579153', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 100, '资金申请，资金申请，资金申请，资金申请，资金申请，', 'd1e45bbbcf44416e8c9a05d8fe076037', 0, 0, '同意申请，同意申请，同意申请，同意申请，同意申请，', '2020-05-10 10:32:27', '2020-05-10 10:03:04', 0);
INSERT INTO `project_finance` VALUES ('5ff08abf04944679a2f82f8036f2bf8d', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 300, '测试，测试，测试，测试，测试，测试，测试，测试', 'c717019bf3a54c1cbb6b97ab3bc2c0b2', 0, 0, '同意，同意，同意，同意，同意，同意，同意', '2020-05-02 18:00:37', '2020-05-01 17:58:55', 0);
INSERT INTO `project_finance` VALUES ('6d8eeeef38a04b9994781c8e6465d2a5', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 340, '资金申请，资金申请，资金申请，资金申请，资金申请，', '6bbae7a23a9d443f8fe739e222f35808', 0, 0, '同意申请，同意申请，同意申请，同意申请，', '2020-05-10 10:24:05', '2020-05-10 10:07:02', 0);
INSERT INTO `project_finance` VALUES ('70de87ee9cdd4d77882d610f6da959c4', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 300, '测试，测试，测试，测试，测试，测试，', '1865a418fa1d459ca3a55fa787075163', 0, 0, '同意，同意，同意，同意，同意，同意，', '2020-05-08 14:51:49', '2020-05-08 14:51:08', 0);
INSERT INTO `project_finance` VALUES ('71d2bcadb2774a6c9c1a96882862b4fb', NULL, '66c38cfebcac46649d071058f2eb7fd1', 310, '资金申请，资金申请，资金申请，资金申请，资金申请，', '6bbae7a23a9d443f8fe739e222f35808', 1, 1, NULL, NULL, '2020-05-10 10:06:42', 0);
INSERT INTO `project_finance` VALUES ('74fe2820961e4bd9ae9f46cfd399c5b4', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 220, '资金申请，资金申请，资金申请，资金申请，资金申请，', 'ec8bf8dc772243828c77c09b1ded2394', 0, 0, '同意申请，同意申请，同意申请，同意申请，同意申请，', '2020-05-10 10:31:38', '2020-05-10 10:04:52', 0);
INSERT INTO `project_finance` VALUES ('7a17de4a52884f0a98d819c2c2514cb0', NULL, '66c38cfebcac46649d071058f2eb7fd1', 300, '测试，测试，测试，测试，测试，测试，', '1864ddd91714420fa2431aac478978bb', 1, 1, NULL, NULL, '2020-05-08 14:50:42', 0);
INSERT INTO `project_finance` VALUES ('8229768232c2461ca2b7b4cde16e0677', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 100, '项目材料购买，项目材料购买，项目材料购买', 'ae69e41f354045258b0e2178c20a0c5c', 0, 0, '李牧的第三个项目-------同意', '2020-05-06 14:58:06', '2020-05-06 14:57:15', 0);
INSERT INTO `project_finance` VALUES ('8a8b14879223474bbd17ddba09a587a0', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 280, '资金申请，资金申请，资金申请，资金申请，资金申请，', '7cdc571770f14f13b763e345e5a6df65', 0, 0, '同意申请，同意申请，同意申请，同意申请，', '2020-05-10 10:24:23', '2020-05-10 10:05:36', 0);
INSERT INTO `project_finance` VALUES ('8ad751dd8ad34f65a4a7f2a777993f61', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 370, '资金申请，资金申请，资金申请，资金申请，', '69e732c2a48841d19a613d920342a9b0', 0, 0, '同意申请，同意申请，同意申请，同意申请，同意申请，', '2020-05-10 10:23:53', '2020-05-10 10:07:34', 0);
INSERT INTO `project_finance` VALUES ('95da1b026b8b40d4876b6b262d6fd1b2', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 230, '资金申请，资金申请，资金申请，资金申请，', 'ec8bf8dc772243828c77c09b1ded2394', 0, 0, '同意申请，同意申请，同意申请，同意申请，', '2020-05-10 10:31:32', '2020-05-10 10:04:59', 0);
INSERT INTO `project_finance` VALUES ('98aa423e1fd44774b0d0c25ceb5ac092', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 400, '资金申请，资金申请，资金申请，资金申请，资金申请，', '69e732c2a48841d19a613d920342a9b0', 0, 0, '同意申请，同意申请，同意申请，同意申请，同意申请，', '2020-05-10 10:23:17', '2020-05-10 10:07:55', 0);
INSERT INTO `project_finance` VALUES ('a2bd92c2cff149ca942c7863b9310878', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 110, '资金申请，资金申请，资金申请，资金申请，资金申请，', 'd1e45bbbcf44416e8c9a05d8fe076037', 0, 0, '同意申请，同意申请，同意申请，同意申请，', '2020-05-10 10:32:05', '2020-05-10 10:03:11', 0);
INSERT INTO `project_finance` VALUES ('a5a88182f66640469557b17dd163cd9d', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 140, '资金申请，资金申请，资金申请，资金申请，资金申请，资金申请，', 'd1e45bbbcf44416e8c9a05d8fe076037', 0, 0, '同意申请，同意申请，同意申请，同意申请，', '2020-05-10 10:25:22', '2020-05-10 10:03:35', 0);
INSERT INTO `project_finance` VALUES ('a7ff8f23730a4c24a63eb0375f6a5b1e', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 500, '测试，测试，测试，测试，测试，测试，测试', 'c717019bf3a54c1cbb6b97ab3bc2c0b2', 0, 0, '同意，同意，同意，同意，同意，同意，同意', '2020-05-03 18:04:57', '2020-05-02 18:03:56', 0);
INSERT INTO `project_finance` VALUES ('b025449e81d84dc5bf9f25ba54ba2377', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 170, '资金申请，资金申请，资金申请，资金申请，', '155f83fd878941c683027018e530f281', 0, 0, '同意申请，同意申请，同意申请，同意申请，', '2020-05-10 10:25:09', '2020-05-10 10:03:59', 0);
INSERT INTO `project_finance` VALUES ('b25dc45ec754415588595f20f898bbc7', NULL, '66c38cfebcac46649d071058f2eb7fd1', 320, '资金申请，资金申请，资金申请，资金申请，资金申请，', '6bbae7a23a9d443f8fe739e222f35808', 1, 1, NULL, NULL, '2020-05-10 10:06:48', 0);
INSERT INTO `project_finance` VALUES ('baf92cbe70354d5f900ae7ecd26abff7', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 300, '测试，测试，测试，测试，测试，测试，', '1865a418fa1d459ca3a55fa787075163', 0, 0, '同意申请，同意申请，同意申请，同意申请，', '2020-05-10 10:25:39', '2020-05-08 14:50:37', 0);
INSERT INTO `project_finance` VALUES ('bbffa9b2a79948bd8eca36d3253a5ecf', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 300, '资金申请，资金申请，资金申请，资金申请，', '7cdc571770f14f13b763e345e5a6df65', 0, 0, '同意申请，同意申请，同意申请，同意申请，', '2020-05-10 10:31:20', '2020-05-10 10:05:52', 0);
INSERT INTO `project_finance` VALUES ('bcfc4bb9a9424578aa0a27b3c890b3aa', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 390, '资金申请，资金申请，资金申请，资金申请，资金申请，', '69e732c2a48841d19a613d920342a9b0', 0, 0, '同意申请，同意申请，同意申请，同意申请，同意申请，', '2020-05-10 10:23:33', '2020-05-10 10:07:47', 0);
INSERT INTO `project_finance` VALUES ('c1ad70abdaa8419489a7c123df810ef4', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 330, '资金申请，资金申请，资金申请，资金申请，', '6bbae7a23a9d443f8fe739e222f35808', 0, 0, '同意申请，同意申请，同意申请，同意申请，', '2020-05-10 10:24:11', '2020-05-10 10:06:56', 0);
INSERT INTO `project_finance` VALUES ('c7de5933a9b648bea96bf8ef0605ba0f', NULL, '66c38cfebcac46649d071058f2eb7fd1', 300, '测试，测试，测试，测试，测试，', '1581a5fe17054b9d81fe58ffd98c05df', 1, 1, NULL, NULL, '2020-05-08 14:50:25', 0);
INSERT INTO `project_finance` VALUES ('d13b0722d491454fb660c4a612d69315', NULL, '66c38cfebcac46649d071058f2eb7fd1', 300, '测试，测试，测试，测试，测试，', '1864ddd91714420fa2431aac478978bb', 1, 1, NULL, '2020-05-09 11:53:17', '2020-05-08 14:51:01', 1);
INSERT INTO `project_finance` VALUES ('d31a103b3bee45928a96a5ce66d51088', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 300, '项目资金申请测试，项目资金申请测试，项目资金申请测试', 'c717019bf3a54c1cbb6b97ab3bc2c0b2', 0, 0, '测试--同意，测试--同意，测试--同意，测试--同意', '2020-05-03 17:51:25', '2020-05-02 17:50:01', 0);
INSERT INTO `project_finance` VALUES ('d335a5aca94d4152930a6ea425c6d87f', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 300, '测试，测试，测试，测试，测试，测试，', '1581a5fe17054b9d81fe58ffd98c05df', 0, 0, '同意，同意，同意，同意，同意，同意，', '2020-05-08 14:52:07', '2020-05-08 14:50:19', 0);
INSERT INTO `project_finance` VALUES ('d49a8b07edee4121a8276f0a9731f66f', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 500, '测试，测试，测试，测试，测试，测试，测试', 'c717019bf3a54c1cbb6b97ab3bc2c0b2', 0, 0, '同意，同意，同意，同意，同意，同意，同意，同意', '2020-05-03 17:59:24', '2020-05-02 17:56:22', 0);
INSERT INTO `project_finance` VALUES ('de694b42ec374642ad99462cf1c8cb97', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 300, '测试，测试，测试，测试，测试，测试，', '1581a5fe17054b9d81fe58ffd98c05df', 0, 0, '同意，同意，同意，同意，同意，同意，', '2020-05-08 14:51:56', '2020-05-08 14:50:55', 0);
INSERT INTO `project_finance` VALUES ('deb626f834bb4fa7a97e6707628b2431', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 300, '李牧项目的启动资金，希望同意。', 'ae69e41f354045258b0e2178c20a0c5c', 0, 0, '李牧的第三个项目项目资金申请同意', '2020-05-06 14:57:52', '2020-05-06 14:56:31', 0);
INSERT INTO `project_finance` VALUES ('ea11acb04ceb4d4e91621b3074000a7c', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 300, '测试，测试，测试，测试，测试，', 'bf0e485d9cdd42b6a64e285a95556369', 0, 0, '同意，同意，同意，同意，同意，同意，', '2020-05-08 14:52:20', '2020-05-08 14:49:46', 0);
INSERT INTO `project_finance` VALUES ('f44f9024dad544de8e925f2828f7a6b7', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 180, '资金申请，资金申请，资金申请，资金申请，资金申请，', '155f83fd878941c683027018e530f281', 0, 0, '同意申请，同意申请，同意申请，同意申请，', '2020-05-10 10:25:03', '2020-05-10 10:04:06', 0);
INSERT INTO `project_finance` VALUES ('f62e083b934243d6b7cb22b89e31e26e', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 380, '资金申请，资金申请，资金申请，资金申请，资金申请，', '69e732c2a48841d19a613d920342a9b0', 0, 0, '同意申请，同意申请，同意申请，同意申请，', '2020-05-10 10:23:47', '2020-05-10 10:07:41', 0);
INSERT INTO `project_finance` VALUES ('f91030e6c148462db850a612634e903c', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 190, '资金申请，资金申请，资金申请，资金申请，资金申请，', '155f83fd878941c683027018e530f281', 0, 0, '同意申请，同意申请，同意申请，同意申请，', '2020-05-10 10:31:43', '2020-05-10 10:04:13', 0);
INSERT INTO `project_finance` VALUES ('faea69b86d57464faff21a605bb7f9d3', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 290, '资金申请，资金申请，资金申请，资金申请，资金申请，资金申请，', '7cdc571770f14f13b763e345e5a6df65', 0, 0, '同意申请，同意申请，同意申请，同意申请，', '2020-05-10 10:24:17', '2020-05-10 10:05:45', 0);

-- ----------------------------
-- Table structure for project_result
-- ----------------------------
DROP TABLE IF EXISTS `project_result`;
CREATE TABLE `project_result`  (
  `pr_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `pro_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目id',
  `tutor_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '结题人id',
  `success` int(1) NULL DEFAULT NULL COMMENT '是否成功结题，0 成功 1 失败',
  `reason` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '结题说明',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `logic_delete_flag` int(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除字段',
  PRIMARY KEY (`pr_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project_result
-- ----------------------------
INSERT INTO `project_result` VALUES ('07429fba90d5407db94761a11ed23ffb', 'bf0e485d9cdd42b6a64e285a95556369', '66c38cfebcac46649d071058f2eb7fd1', 1, '失败结题失败结题失败结题失败结题失败结题', NULL, '2020-05-09 10:32:35', 0);
INSERT INTO `project_result` VALUES ('1e20da5e62d7474a90a52619750b2d42', '7cdc571770f14f13b763e345e5a6df65', '66c38cfebcac46649d071058f2eb7fd1', 0, '孵化成功，孵化成功，孵化成功，孵化成功，', NULL, '2020-05-10 10:34:32', 0);
INSERT INTO `project_result` VALUES ('325fbe7d578d44389290bcf369e6442b', '1581a5fe17054b9d81fe58ffd98c05df', '66c38cfebcac46649d071058f2eb7fd1', 0, '成功结题，成功结题，成功结题，成功结题，成功结题，', NULL, '2020-05-09 10:31:42', 0);
INSERT INTO `project_result` VALUES ('6f9749054a0e4c56bb1669291f817d8a', 'c717019bf3a54c1cbb6b97ab3bc2c0b2', '66c38cfebcac46649d071058f2eb7fd1', 0, '结题结题结题结题结题结题结题结题', NULL, '2020-05-06 10:34:13', 0);
INSERT INTO `project_result` VALUES ('94a2c237fb994c18a653daa64f5d990e', 'ec8bf8dc772243828c77c09b1ded2394', '66c38cfebcac46649d071058f2eb7fd1', 0, '孵化成功，孵化成功，孵化成功，孵化成功，', NULL, '2020-05-10 10:34:27', 0);
INSERT INTO `project_result` VALUES ('9cd1ec3afb924b2598cf9fe7fa1a602f', '282fa8c1bd23477bab7f7121e11b0477', '66c38cfebcac46649d071058f2eb7fd1', 0, '李牧的第一个项目，李牧的第一个项目，李牧的第一个项目', NULL, '2020-05-08 10:35:34', 0);
INSERT INTO `project_result` VALUES ('e810b79b657049d68314bed7b646dae3', '1864ddd91714420fa2431aac478978bb', '66c38cfebcac46649d071058f2eb7fd1', 0, '成功结题，成功结题，成功结题，成功结题，成功结题', NULL, '2020-05-09 10:50:17', 0);
INSERT INTO `project_result` VALUES ('fdee2d4ce54a4928b59f3b499aeedb97', '155f83fd878941c683027018e530f281', '66c38cfebcac46649d071058f2eb7fd1', 0, '孵化成功，孵化成功，孵化成功，孵化成功，', NULL, '2020-05-10 10:34:21', 0);
INSERT INTO `project_result` VALUES ('ff56828b2de44581bc7dcb28ca2522b1', 'ae69e41f354045258b0e2178c20a0c5c', '66c38cfebcac46649d071058f2eb7fd1', 0, '失败测试，失败测试，失败测试，失败测试', NULL, '2020-05-09 10:00:40', 0);
INSERT INTO `project_result` VALUES ('fff0edf5199243658843cdb8fb75dea4', 'd1e45bbbcf44416e8c9a05d8fe076037', '66c38cfebcac46649d071058f2eb7fd1', 0, '孵化成功，孵化成功，孵化成功，孵化成功，', NULL, '2020-05-10 10:34:16', 0);

-- ----------------------------
-- Table structure for project_review
-- ----------------------------
DROP TABLE IF EXISTS `project_review`;
CREATE TABLE `project_review`  (
  `pr_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `tutor_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核人id',
  `pro_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目id',
  `pass_flag` int(1) NULL DEFAULT 1 COMMENT '是否通过审核 0 通过 1 未通过， 默认 1',
  `reason` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核意见',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `logic_delete_flag` int(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除 0 可用 1 逻辑删除',
  PRIMARY KEY (`pr_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '项目审核表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project_review
-- ----------------------------
INSERT INTO `project_review` VALUES ('07dd79691aca416fbcd6bbaa7c301f2e', '66c38cfebcac46649d071058f2eb7fd1', '1864ddd91714420fa2431aac478978bb', 0, '同意，同意，同意，同意，同意，', '2020-05-08 14:45:02', '2020-05-08 14:39:47', 0);
INSERT INTO `project_review` VALUES ('0b82aee0d37549228ea82a4560be5cb3', NULL, 'b8393de09ddb4982a1b3147c92e66108', 1, NULL, NULL, '2020-05-08 14:29:35', 0);
INSERT INTO `project_review` VALUES ('10e33192f5354219813249033940575f', NULL, 'd45e9d2f272a4e60be1f7667f42c102c', 1, NULL, NULL, '2020-05-08 14:39:30', 0);
INSERT INTO `project_review` VALUES ('20baf0ca011b40b284f0ef012668f8f5', '66c38cfebcac46649d071058f2eb7fd1', '155f83fd878941c683027018e530f281', 0, '同意，同意，同意，同意，同意，同意，', '2020-05-10 10:01:47', '2020-05-10 09:56:12', 0);
INSERT INTO `project_review` VALUES ('21efa8638d4d4672994b9a5d3bfa536e', '66c38cfebcac46649d071058f2eb7fd1', '6bbae7a23a9d443f8fe739e222f35808', 0, '同意，同意，同意，同意，同意，', '2020-05-08 14:46:13', '2020-05-08 14:30:16', 0);
INSERT INTO `project_review` VALUES ('2bacd3be1b914ff492589d90a34e9877', NULL, 'c1ff44775f9244ceb6dfde17553b8bb3', 1, NULL, NULL, '2020-05-10 09:59:03', 0);
INSERT INTO `project_review` VALUES ('2c05339426f14daea6977e28b0a1c838', '66c38cfebcac46649d071058f2eb7fd1', '7aa39ca0097b43d1b4b8d83ca18d85c5', 1, '同意，同意，同意，同意，同意，', '2020-05-08 14:45:14', '2020-05-08 14:28:45', 0);
INSERT INTO `project_review` VALUES ('390a951cc65a4d9b85408e22fd341528', '66c38cfebcac46649d071058f2eb7fd1', '1865a418fa1d459ca3a55fa787075163', 0, '同意，同意，同意，同意，同意，同意，', '2020-05-08 14:44:55', '2020-05-02 17:37:35', 0);
INSERT INTO `project_review` VALUES ('393263efdcfc4e44ac543286a5bc3453', NULL, 'c3267e7c780743c9b0c5bb7352f1475e', 1, NULL, NULL, '2020-05-08 14:41:27', 0);
INSERT INTO `project_review` VALUES ('3989e81f73f842348b0fa5c8b7c9de5a', NULL, 'ae135688df73424b91fabb8427a9394b', 1, NULL, NULL, '2020-05-08 14:29:18', 0);
INSERT INTO `project_review` VALUES ('3d16df830aa540a0a68e921ed8384cc9', NULL, '80f5e28c94d846b0a7f2ecb75002cb6b', 1, NULL, NULL, '2020-05-10 09:57:35', 0);
INSERT INTO `project_review` VALUES ('4aa04e579efb4e5f9d1aed006a68667d', NULL, '39831d8b1e58426ba9cc442a1cbdaca0', 1, NULL, NULL, '2020-05-10 09:56:28', 0);
INSERT INTO `project_review` VALUES ('4fb649c6e4a0438d97914a69f61f83e4', '66c38cfebcac46649d071058f2eb7fd1', '282fa8c1bd23477bab7f7121e11b0477', 0, '李牧的第一个项目------同意', '2020-05-06 14:49:54', '2020-05-06 14:43:22', 0);
INSERT INTO `project_review` VALUES ('5336cd644c0a4f1c8b409268ac9f199d', '66c38cfebcac46649d071058f2eb7fd1', 'c717019bf3a54c1cbb6b97ab3bc2c0b2', 0, '测试项目上传同意，测试项目上传同意，测试项目上传同意，测试项目上传同意', '2020-05-02 17:47:54', '2020-05-02 17:38:07', 0);
INSERT INTO `project_review` VALUES ('55ecebf1e39f419db0adcf59fdc22e91', NULL, 'b67dbdeb51804fb19d72b748aa6e53ef', 1, NULL, NULL, '2020-05-08 14:34:23', 0);
INSERT INTO `project_review` VALUES ('60f6731ff2a6455aa03cbefaa73ffa8d', NULL, '280d33966b38424ca820ee2af9a33574', 1, NULL, NULL, '2020-05-08 14:38:53', 0);
INSERT INTO `project_review` VALUES ('6191695c2c0b48e1906baa5e9fef2dfd', NULL, '9409d06a91804102ad0b68ceb6fba428', 1, NULL, NULL, '2020-05-08 14:41:11', 0);
INSERT INTO `project_review` VALUES ('639f426b065542bfb30af3836fccd7c0', NULL, '28d26c1d9128454aa1d394d0ee885c50', 1, NULL, NULL, '2020-05-08 14:29:50', 0);
INSERT INTO `project_review` VALUES ('7a5f8524c96949d48fdc52b5a47c7594', '66c38cfebcac46649d071058f2eb7fd1', '69e732c2a48841d19a613d920342a9b0', 0, '同意，同意，同意，同意，同意，同意，', '2020-05-08 14:45:10', '2020-05-08 14:38:17', 0);
INSERT INTO `project_review` VALUES ('7e8ba1d2cb954e6f8d68b708c683eb5f', '66c38cfebcac46649d071058f2eb7fd1', '7cdc571770f14f13b763e345e5a6df65', 0, '同意，同意，同意，同意，同意，同意，', '2020-05-10 10:01:35', '2020-05-10 09:56:44', 0);
INSERT INTO `project_review` VALUES ('86019c18ab544b40bf404273c4f75d6c', NULL, '7292fcc0ac3948f7b25ca11f967a0ad7', 1, NULL, NULL, '2020-05-08 14:34:40', 0);
INSERT INTO `project_review` VALUES ('86096721fe224a888dd6d8e7deb58de8', NULL, 'c15dbe7b6dd94ff299f7cd33342266c2', 1, NULL, NULL, '2020-05-02 17:38:51', 0);
INSERT INTO `project_review` VALUES ('906d6c7852f848fbb30f10d1f06dc2f0', NULL, 'c451df7a750943f3b3882d5833b827a7', 1, NULL, NULL, '2020-05-06 14:43:44', 0);
INSERT INTO `project_review` VALUES ('936eb2f8dd9f402a9c67b4aba600b1b3', NULL, 'bfa28870b6f14052892d6b2849dec733', 1, NULL, NULL, '2020-05-08 14:40:34', 0);
INSERT INTO `project_review` VALUES ('93ce89ac26d144e49224ed4227dd7fd4', NULL, '776ff313f99245ca9426dc88482b3901', 1, NULL, NULL, '2020-05-07 09:59:27', 0);
INSERT INTO `project_review` VALUES ('98f037163a524f04b9f21edbd474c80d', NULL, '272661cbf1904b0b8eb096ba8104f8f1', 1, NULL, NULL, '2020-05-08 14:40:51', 0);
INSERT INTO `project_review` VALUES ('9ebc1a1b34164ceba8963c1382c49e5a', NULL, '6c41b9af9bda4c76a61fc97e2c79c77e', 1, NULL, NULL, '2020-05-08 14:34:58', 0);
INSERT INTO `project_review` VALUES ('a40d6a644c0d4c3d86ad848a73712cba', '66c38cfebcac46649d071058f2eb7fd1', 'd1e45bbbcf44416e8c9a05d8fe076037', 0, '同意，同意，同意，同意，同意，同意，同意，', '2020-05-10 10:01:55', '2020-05-10 09:58:11', 0);
INSERT INTO `project_review` VALUES ('b1748b3a713e4317be711cb24b2b28ba', '66c38cfebcac46649d071058f2eb7fd1', 'bf0e485d9cdd42b6a64e285a95556369', 0, '同意，同意，同意，同意，同意，', '2020-05-08 14:46:08', '2020-05-08 14:29:01', 0);
INSERT INTO `project_review` VALUES ('b278eb80dfbd4ca9932573b92843d65c', NULL, '77e9447db6734f02ac4b2cd853de3b3d', 1, NULL, NULL, '2020-05-08 14:40:02', 0);
INSERT INTO `project_review` VALUES ('c8b7cbd0844946c7bcaa1a93496d1b50', NULL, '40732a9bc59b40aa9542131e3bdc6232', 1, NULL, NULL, '2020-05-08 14:25:42', 0);
INSERT INTO `project_review` VALUES ('d2057cb22215400ba425ce58cd895126', '66c38cfebcac46649d071058f2eb7fd1', 'ae69e41f354045258b0e2178c20a0c5c', 0, '李牧的第三个项目-------同意', '2020-05-06 14:49:43', '2020-05-06 14:45:07', 0);
INSERT INTO `project_review` VALUES ('d49177557a734705b722d5ec397e8314', NULL, 'f415476aa7ea41d6b4d223e86684478c', 1, NULL, NULL, '2020-05-10 09:58:29', 0);
INSERT INTO `project_review` VALUES ('dfe5ab283cb94c549a15cdb4523c8525', NULL, 'cd9cff9694d949b297a134beab4a94e0', 1, NULL, NULL, '2020-05-06 14:46:17', 0);
INSERT INTO `project_review` VALUES ('e33d31b666d943c4abc632ab8ead1764', '66c38cfebcac46649d071058f2eb7fd1', '1581a5fe17054b9d81fe58ffd98c05df', 0, '同意，同意，同意，同意，同意，同意，同意，', '2020-05-08 14:46:51', '2020-05-08 14:34:01', 0);
INSERT INTO `project_review` VALUES ('ecab85b069e34808b2e2cede974408c6', NULL, '719560ec8e30439a81d24a751ee7b1fc', 1, NULL, NULL, '2020-05-10 09:57:02', 0);
INSERT INTO `project_review` VALUES ('f509ec65f1d34916afc90002ee0cbf71', '66c38cfebcac46649d071058f2eb7fd1', 'ec8bf8dc772243828c77c09b1ded2394', 0, '同意，同意，同意，同意，同意，同意，', '2020-05-10 10:01:41', '2020-05-10 09:58:45', 0);
INSERT INTO `project_review` VALUES ('f5cd20a16b374392940101fda4e46680', NULL, 'c756d731f19a40caa93a71f6f535cd95', 1, NULL, NULL, '2020-05-08 14:39:13', 0);
INSERT INTO `project_review` VALUES ('f9174723c04547e6b8c907ad3cbf8037', NULL, 'a0bb27667cb24101b15790050ed81b33', 1, NULL, NULL, '2020-05-10 09:57:19', 0);
INSERT INTO `project_review` VALUES ('f9464e8db3504e469e3da9b95924dcd4', NULL, '72d0e516f272420e99a72b673b706fb2', 1, NULL, NULL, '2020-05-08 14:40:19', 0);

-- ----------------------------
-- Table structure for project_starting
-- ----------------------------
DROP TABLE IF EXISTS `project_starting`;
CREATE TABLE `project_starting`  (
  `ps_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `tutor_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '立项人id',
  `pro_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目id',
  `lx_flag` int(1) NULL DEFAULT 1 COMMENT '是否立项 0 是 1否 默认 1',
  `end` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '是否结题 0 是 1 否，默认1',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `logic_delete_flag` int(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除 0 可用 1 逻辑删除',
  PRIMARY KEY (`ps_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '项目立项表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project_starting
-- ----------------------------
INSERT INTO `project_starting` VALUES ('05493e5d083847e38179e277c7c24dca', '66c38cfebcac46649d071058f2eb7fd1', '1581a5fe17054b9d81fe58ffd98c05df', 0, '0', '2020-05-08 14:34:01', '2020-05-09 10:31:42', 0);
INSERT INTO `project_starting` VALUES ('079bbab123be494b985ce3632a72c895', NULL, 'b67dbdeb51804fb19d72b748aa6e53ef', 1, '1', '2020-05-08 14:34:23', NULL, 0);
INSERT INTO `project_starting` VALUES ('0e5406264bc7460fb96425368956c458', NULL, 'c451df7a750943f3b3882d5833b827a7', 1, '1', '2020-05-06 14:43:44', NULL, 0);
INSERT INTO `project_starting` VALUES ('0fb6dc3f53f74af9b564858ee43b7ea1', '66c38cfebcac46649d071058f2eb7fd1', 'd1e45bbbcf44416e8c9a05d8fe076037', 0, '0', '2020-05-10 09:58:11', '2020-05-10 10:34:16', 0);
INSERT INTO `project_starting` VALUES ('103dbcfc28e6452687577066364bb042', NULL, '280d33966b38424ca820ee2af9a33574', 1, '1', '2020-05-08 14:38:53', NULL, 0);
INSERT INTO `project_starting` VALUES ('1056f461cfff4efdb8a74e8b56d240b6', NULL, 'cd9cff9694d949b297a134beab4a94e0', 1, '1', '2020-05-06 14:46:17', NULL, 0);
INSERT INTO `project_starting` VALUES ('1d12cab209d04eefb035a4f77b57cb68', '66c38cfebcac46649d071058f2eb7fd1', '6bbae7a23a9d443f8fe739e222f35808', 0, '1', '2020-05-08 14:30:16', '2020-05-10 10:02:17', 0);
INSERT INTO `project_starting` VALUES ('22629439d11c4c24a6dfbc63d07524d1', NULL, 'c756d731f19a40caa93a71f6f535cd95', 1, '1', '2020-05-08 14:39:13', NULL, 0);
INSERT INTO `project_starting` VALUES ('246c7e12f9fe4f2ca43b06a2130ca2fe', NULL, '7aa39ca0097b43d1b4b8d83ca18d85c5', 1, '1', '2020-05-08 14:28:45', NULL, 0);
INSERT INTO `project_starting` VALUES ('2c1eec80969343b096fef428bc44cfe4', '66c38cfebcac46649d071058f2eb7fd1', '69e732c2a48841d19a613d920342a9b0', 0, '1', '2020-05-08 14:38:17', '2020-05-10 10:02:20', 0);
INSERT INTO `project_starting` VALUES ('2f6d437de6cf443792b738ba0f4a25d6', '66c38cfebcac46649d071058f2eb7fd1', '155f83fd878941c683027018e530f281', 0, '0', '2020-05-10 09:56:12', '2020-05-10 10:34:21', 0);
INSERT INTO `project_starting` VALUES ('2fb0a0f330b94d3b9a2021ccfbf55120', NULL, '39831d8b1e58426ba9cc442a1cbdaca0', 1, '1', '2020-05-10 09:56:28', NULL, 0);
INSERT INTO `project_starting` VALUES ('2ff7844c0c0e48b998de4ced09f15e8d', NULL, '77e9447db6734f02ac4b2cd853de3b3d', 1, '1', '2020-05-08 14:40:02', NULL, 0);
INSERT INTO `project_starting` VALUES ('35d76e67d9ac4d129362cbd284ee8772', NULL, '776ff313f99245ca9426dc88482b3901', 1, '1', '2020-05-07 09:59:27', NULL, 0);
INSERT INTO `project_starting` VALUES ('51aade4622624577a3fd66d22b6cee18', '66c38cfebcac46649d071058f2eb7fd1', '1864ddd91714420fa2431aac478978bb', 0, '0', '2020-05-08 14:39:47', '2020-05-09 10:50:17', 0);
INSERT INTO `project_starting` VALUES ('56f2fb2e16c44d9aa9f103d775c8a329', '66c38cfebcac46649d071058f2eb7fd1', '282fa8c1bd23477bab7f7121e11b0477', 0, '0', '2020-05-06 14:43:22', '2020-05-08 10:35:34', 0);
INSERT INTO `project_starting` VALUES ('5c1770b52db04faf911df96b9a9b5102', '66c38cfebcac46649d071058f2eb7fd1', 'c717019bf3a54c1cbb6b97ab3bc2c0b2', 0, '0', '2020-05-02 17:38:07', '2020-05-08 10:34:13', 0);
INSERT INTO `project_starting` VALUES ('6530dc4dd65a476c99bc74a54a928692', NULL, '7292fcc0ac3948f7b25ca11f967a0ad7', 1, '1', '2020-05-08 14:34:40', NULL, 0);
INSERT INTO `project_starting` VALUES ('7ef8fafe489f4667a0af0d44406742c2', NULL, '40732a9bc59b40aa9542131e3bdc6232', 1, '1', '2020-05-08 14:25:42', NULL, 0);
INSERT INTO `project_starting` VALUES ('93592f682abb47168067a5ef6ec6b566', NULL, '80f5e28c94d846b0a7f2ecb75002cb6b', 1, '1', '2020-05-10 09:57:35', NULL, 0);
INSERT INTO `project_starting` VALUES ('9424d26637224653835ad3fc865ab083', NULL, 'bfa28870b6f14052892d6b2849dec733', 1, '1', '2020-05-08 14:40:34', NULL, 0);
INSERT INTO `project_starting` VALUES ('a131c87bd7154a43b8613546a65f1761', '66c38cfebcac46649d071058f2eb7fd1', 'bf0e485d9cdd42b6a64e285a95556369', 0, '0', '2020-05-08 14:29:01', '2020-05-09 10:32:35', 0);
INSERT INTO `project_starting` VALUES ('a28424b36f1442c89c883923fcae5b7e', NULL, '9409d06a91804102ad0b68ceb6fba428', 1, '1', '2020-05-08 14:41:11', NULL, 0);
INSERT INTO `project_starting` VALUES ('a3c9513087b44f5e8669c611c48ade50', NULL, '28d26c1d9128454aa1d394d0ee885c50', 1, '1', '2020-05-08 14:29:50', NULL, 0);
INSERT INTO `project_starting` VALUES ('a89090bd76cd42b8a510708f6244b421', NULL, 'c1ff44775f9244ceb6dfde17553b8bb3', 1, '1', '2020-05-10 09:59:03', NULL, 0);
INSERT INTO `project_starting` VALUES ('ae698d25f615486c83985a6d0017f24c', NULL, 'b8393de09ddb4982a1b3147c92e66108', 1, '1', '2020-05-08 14:29:35', NULL, 0);
INSERT INTO `project_starting` VALUES ('b0fd0fddebdb4c7caaa7c72619b73a51', NULL, '272661cbf1904b0b8eb096ba8104f8f1', 1, '1', '2020-05-08 14:40:51', NULL, 0);
INSERT INTO `project_starting` VALUES ('b1a1ddb803d2455aabe023e595acb738', NULL, '72d0e516f272420e99a72b673b706fb2', 1, '1', '2020-05-08 14:40:19', NULL, 0);
INSERT INTO `project_starting` VALUES ('b2414865f075454098ead3c8c70c6376', NULL, 'c15dbe7b6dd94ff299f7cd33342266c2', 1, '1', '2020-05-02 17:38:51', NULL, 0);
INSERT INTO `project_starting` VALUES ('b367ff67a88e46dbaa0548173fd90bd9', NULL, 'a0bb27667cb24101b15790050ed81b33', 1, '1', '2020-05-10 09:57:19', NULL, 0);
INSERT INTO `project_starting` VALUES ('b3c9b7bb28f8460ba17117b7618eaba0', NULL, '719560ec8e30439a81d24a751ee7b1fc', 1, '1', '2020-05-10 09:57:02', NULL, 0);
INSERT INTO `project_starting` VALUES ('b657e1eaa6d24e48ae5723f74517a229', NULL, 'c3267e7c780743c9b0c5bb7352f1475e', 1, '1', '2020-05-08 14:41:27', NULL, 0);
INSERT INTO `project_starting` VALUES ('ced6a9cfd1664762875e7e083f0cc721', '66c38cfebcac46649d071058f2eb7fd1', 'ec8bf8dc772243828c77c09b1ded2394', 0, '0', '2020-05-10 09:58:45', '2020-05-10 10:34:27', 0);
INSERT INTO `project_starting` VALUES ('d0a85a6a71444d9bbcc8a315532b5480', NULL, '6c41b9af9bda4c76a61fc97e2c79c77e', 1, '1', '2020-05-08 14:34:58', NULL, 0);
INSERT INTO `project_starting` VALUES ('d3683f6e88e84c719475f882fb76f15e', NULL, 'ae135688df73424b91fabb8427a9394b', 1, '1', '2020-05-08 14:29:18', NULL, 0);
INSERT INTO `project_starting` VALUES ('de7a776733b4415f81c62eb78ca9a5ff', '66c38cfebcac46649d071058f2eb7fd1', '7cdc571770f14f13b763e345e5a6df65', 0, '0', '2020-05-10 09:56:44', '2020-05-10 10:34:32', 0);
INSERT INTO `project_starting` VALUES ('e77ef6980cbe4edd859fbc4b31118ff2', '66c38cfebcac46649d071058f2eb7fd1', 'ae69e41f354045258b0e2178c20a0c5c', 0, '0', '2020-05-06 14:45:07', '2020-05-08 10:31:43', 0);
INSERT INTO `project_starting` VALUES ('ee33f061709e43eaa3eea7d32ec31bf3', NULL, 'f415476aa7ea41d6b4d223e86684478c', 1, '1', '2020-05-10 09:58:29', NULL, 0);
INSERT INTO `project_starting` VALUES ('f31e0bc8609d4157817bdc4be9210541', '66c38cfebcac46649d071058f2eb7fd1', '1865a418fa1d459ca3a55fa787075163', 0, '1', '2020-05-02 17:37:35', '2020-05-08 14:49:28', 0);
INSERT INTO `project_starting` VALUES ('f9b317867dde4ba9b636662bd74d51f4', NULL, 'd45e9d2f272a4e60be1f7667f42c102c', 1, '1', '2020-05-08 14:39:30', NULL, 0);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `role_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `role_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `role_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编码',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `logic_delete_flag` int(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除字段',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('10a258b4defc4f5db4847b09ce883f73', '学生', 'student_role', '2020-01-09 15:28:00', '2020-01-09 15:28:02', 0);
INSERT INTO `role` VALUES ('3bfb84a2ad49489aab8be641fc87472a', '企业', 'company_role', '2020-01-09 15:27:27', '2020-01-09 15:27:29', 0);
INSERT INTO `role` VALUES ('3c0ac27e560643fa9495de3f69dc615a', '库存管理员', 'stock_role', '2020-01-09 15:26:19', '2020-01-09 15:26:22', 0);
INSERT INTO `role` VALUES ('50e04dd5a7c140e98f107ae4b0d1a8b0', '导师', 'tutor_role', '2020-01-09 15:27:12', '2020-01-09 15:27:15', 0);
INSERT INTO `role` VALUES ('553df5a84743447faa2e8a7e19534b88', '财务管理员', 'fin_role', '2020-01-09 15:25:24', '2020-01-09 15:25:28', 0);
INSERT INTO `role` VALUES ('8d9c223f83494839b8332dd11c4833d8', '系统管理员', 'sys_role', '2020-01-09 15:24:48', '2020-01-09 15:24:51', 0);
INSERT INTO `role` VALUES ('b5fb3c3f9f8b4dd1bb0011ee2e5b70af', '项目组长', 'tutor_leader_role', '2020-01-09 15:26:53', '2020-01-09 15:26:55', 0);

-- ----------------------------
-- Table structure for stock_into_log
-- ----------------------------
DROP TABLE IF EXISTS `stock_into_log`;
CREATE TABLE `stock_into_log`  (
  `sto_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `admin_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员',
  `goods_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '货物',
  `goods_num` int(5) NULL DEFAULT NULL COMMENT '数量',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '入库价格',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `logic_delete_flag` int(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除字段',
  PRIMARY KEY (`sto_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '库存入库记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stock_into_log
-- ----------------------------
INSERT INTO `stock_into_log` VALUES ('128caa1402c4441e8ece921b10cbd371', 'e7a185e5074741b385d3615d41a92038', '20e3c48e2ac840a48eb55112c63f8ab2', 100, 10.00, '2020-05-02 14:42:46', '2020-05-02 14:42:46', 0);
INSERT INTO `stock_into_log` VALUES ('131c7e3319ac40b7958d73370ddfdad3', 'e7a185e5074741b385d3615d41a92038', '781c1a7a30c94be7a408d456a1ddda0e', 100, 30.00, '2020-05-02 15:10:19', '2020-05-02 15:10:19', 0);
INSERT INTO `stock_into_log` VALUES ('1dcfd9619776483e9d9fd33b6f6ff9d6', 'e7a185e5074741b385d3615d41a92038', '15c088c7812a4fc28d37a358b4d9b7fa', 20, 1200.00, '2020-05-02 14:49:25', '2020-05-02 14:49:25', 0);
INSERT INTO `stock_into_log` VALUES ('6e4a17e812b74e4ea29ee71c0ea7a3ca', 'e7a185e5074741b385d3615d41a92038', 'b895d888af4e4e4e9128120447ae1294', 100, 200.00, '2020-05-02 14:48:09', '2020-05-03 14:48:09', 0);
INSERT INTO `stock_into_log` VALUES ('847debfa6bde449f9cde863735b602a0', 'e7a185e5074741b385d3615d41a92038', '5797b9c72aaf42769d8a754167fe45ae', 100, 300.00, '2020-05-03 14:43:50', '2020-05-03 14:43:50', 0);
INSERT INTO `stock_into_log` VALUES ('c2033ed0e0a54f6d9fe365ffa1e837a6', 'e7a185e5074741b385d3615d41a92038', '3a37adc26cc44d239b6fb4378cd2006c', 100, 60.00, '2020-05-03 14:50:54', '2020-05-03 14:50:54', 0);
INSERT INTO `stock_into_log` VALUES ('c32021ba84b44eab882cfacc959be2e2', 'e7a185e5074741b385d3615d41a92038', '3a37adc26cc44d239b6fb4378cd2006c', 300, 60.00, '2020-05-03 14:52:20', '2020-05-04 14:52:20', 0);
INSERT INTO `stock_into_log` VALUES ('c552c7a4b93548b08b0670755dc9cf8d', 'e7a185e5074741b385d3615d41a92038', '65aed7b07efd4141bfb0d6b402f83e8d', 100, 300.00, '2020-05-03 14:44:42', '2020-05-04 14:44:42', 0);
INSERT INTO `stock_into_log` VALUES ('c9bb32b5e8bf4457af0db12a83f12f44', 'e7a185e5074741b385d3615d41a92038', 'c569782d7dfa4e12800fb7f5c06ae783', 200, 30.00, '2020-05-04 14:47:30', '2020-05-04 14:47:30', 0);
INSERT INTO `stock_into_log` VALUES ('ff1b4729a890404196154346e38bc99c', 'e7a185e5074741b385d3615d41a92038', '6937cee5b3fc4865bb5965e4318f3bdb', 100, 120.00, '2020-05-03 14:50:08', '2020-05-03 14:50:08', 0);

-- ----------------------------
-- Table structure for stock_out_log
-- ----------------------------
DROP TABLE IF EXISTS `stock_out_log`;
CREATE TABLE `stock_out_log`  (
  `sto_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `admin_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员',
  `goods_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '货物',
  `apply_num` int(5) NULL DEFAULT NULL COMMENT '申请数量',
  `stud_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作室',
  `agree` int(1) NULL DEFAULT 1 COMMENT '0 同意 1 不同意，默认1',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `logic_delete_flag` int(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除字段',
  PRIMARY KEY (`sto_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '库存出入库记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stock_out_log
-- ----------------------------
INSERT INTO `stock_out_log` VALUES ('15605c177c724078a5fbe4b66883a1a0', 'e7a185e5074741b385d3615d41a92038', '15c088c7812a4fc28d37a358b4d9b7fa', 2, '52c5e19b049a424193d571e6fa4b629f', 0, '2020-05-02 15:11:01', '2020-05-03 15:07:37', 0);
INSERT INTO `stock_out_log` VALUES ('1880ffe83cab490494d973d9e306951e', 'e7a185e5074741b385d3615d41a92038', '781c1a7a30c94be7a408d456a1ddda0e', 10, '196e0f44e01f453281ca7336abe4703b', 0, '2020-05-10 10:44:09', '2020-05-10 10:39:55', 0);
INSERT INTO `stock_out_log` VALUES ('2bc6f57dc57a4d7eb950471dde07a08c', 'e7a185e5074741b385d3615d41a92038', 'b895d888af4e4e4e9128120447ae1294', 3, '5b961d228660441fa367de7255bbfa1a', 0, '2020-05-10 10:44:12', '2020-05-10 10:43:03', 0);
INSERT INTO `stock_out_log` VALUES ('3727afa8a6904c95bea56de161eeb4c8', 'e7a185e5074741b385d3615d41a92038', 'b895d888af4e4e4e9128120447ae1294', 2, '196e0f44e01f453281ca7336abe4703b', 0, '2020-05-10 10:44:15', '2020-05-10 10:40:11', 0);
INSERT INTO `stock_out_log` VALUES ('39bba1a868b44a7cafb2505c88a96dea', 'e7a185e5074741b385d3615d41a92038', '6937cee5b3fc4865bb5965e4318f3bdb', 30, '52c5e19b049a424193d571e6fa4b629f', 0, '2020-05-02 15:11:04', '2020-05-03 15:08:14', 0);
INSERT INTO `stock_out_log` VALUES ('490a0b7d127b447880c24295ac557e1a', 'e7a185e5074741b385d3615d41a92038', '3a37adc26cc44d239b6fb4378cd2006c', 10, '196e0f44e01f453281ca7336abe4703b', 0, '2020-05-10 10:44:18', '2020-05-10 10:40:56', 0);
INSERT INTO `stock_out_log` VALUES ('50758ebcbd254e52a896c17c808c8f0c', 'e7a185e5074741b385d3615d41a92038', 'b895d888af4e4e4e9128120447ae1294', 5, '52c5e19b049a424193d571e6fa4b629f', 0, '2020-05-02 15:11:07', '2020-05-03 15:07:43', 0);
INSERT INTO `stock_out_log` VALUES ('50a57a06ecf44592b972dcac53c76f37', 'e7a185e5074741b385d3615d41a92038', '781c1a7a30c94be7a408d456a1ddda0e', 10, '431efd931a6744989928f332a27dbb57', 0, '2020-05-10 10:44:21', '2020-05-10 10:40:42', 0);
INSERT INTO `stock_out_log` VALUES ('5b3d53673b2447d0b2c12f0950bde6c7', 'e7a185e5074741b385d3615d41a92038', '15c088c7812a4fc28d37a358b4d9b7fa', 1, '196e0f44e01f453281ca7336abe4703b', 0, '2020-05-10 10:44:25', '2020-05-10 10:40:04', 0);
INSERT INTO `stock_out_log` VALUES ('663959ccb38d454ba984d9fcf093a1fc', 'e7a185e5074741b385d3615d41a92038', 'c569782d7dfa4e12800fb7f5c06ae783', 15, '5b961d228660441fa367de7255bbfa1a', 0, '2020-05-10 10:49:58', '2020-05-10 10:43:17', 0);
INSERT INTO `stock_out_log` VALUES ('6ec651bb3c144269a34f62f6f7ccd80c', 'e7a185e5074741b385d3615d41a92038', 'b895d888af4e4e4e9128120447ae1294', 5, '431efd931a6744989928f332a27dbb57', 0, '2020-05-03 15:06:21', '2020-05-03 15:02:25', 0);
INSERT INTO `stock_out_log` VALUES ('761f0022325f46749361d0991b9b1f24', 'e7a185e5074741b385d3615d41a92038', '15c088c7812a4fc28d37a358b4d9b7fa', 1, '4998baa9dfad4d76a19caf6fbc36ca99', 0, '2020-05-10 10:44:40', '2020-05-10 10:41:23', 0);
INSERT INTO `stock_out_log` VALUES ('769e5fd810994b8f974a32b87f4310b9', 'e7a185e5074741b385d3615d41a92038', '5797b9c72aaf42769d8a754167fe45ae', 3, '431efd931a6744989928f332a27dbb57', 0, '2020-05-03 15:06:24', '2020-05-03 15:02:37', 0);
INSERT INTO `stock_out_log` VALUES ('81d289cc8bd940f3915a706d81e235f7', 'e7a185e5074741b385d3615d41a92038', '3a37adc26cc44d239b6fb4378cd2006c', 10, '52c5e19b049a424193d571e6fa4b629f', 0, '2020-05-03 15:11:11', '2020-05-03 15:07:55', 0);
INSERT INTO `stock_out_log` VALUES ('8806032eccfc418ca522229d487413ca', 'e7a185e5074741b385d3615d41a92038', '15c088c7812a4fc28d37a358b4d9b7fa', 2, '431efd931a6744989928f332a27dbb57', 0, '2020-05-04 15:06:28', '2020-05-03 14:53:35', 0);
INSERT INTO `stock_out_log` VALUES ('8c400fcca19f44369e473541e4be51ec', 'e7a185e5074741b385d3615d41a92038', '20e3c48e2ac840a48eb55112c63f8ab2', 10, '52c5e19b049a424193d571e6fa4b629f', 0, '2020-05-04 15:11:14', '2020-05-03 15:07:31', 0);
INSERT INTO `stock_out_log` VALUES ('8f97023a696e4c079c5b92fdcdc80708', NULL, '65aed7b07efd4141bfb0d6b402f83e8d', 20, '5b961d228660441fa367de7255bbfa1a', 1, '2020-05-10 10:43:10', '2020-05-10 10:43:10', 0);
INSERT INTO `stock_out_log` VALUES ('919fb76b14b941c68d6b294a7238d213', NULL, '5797b9c72aaf42769d8a754167fe45ae', 3, '196e0f44e01f453281ca7336abe4703b', 1, '2020-05-10 10:40:19', '2020-05-10 10:40:19', 0);
INSERT INTO `stock_out_log` VALUES ('92c2aa33f59c4b3a8a291d0775087e85', 'e7a185e5074741b385d3615d41a92038', '20e3c48e2ac840a48eb55112c63f8ab2', 5, '196e0f44e01f453281ca7336abe4703b', 0, '2020-05-10 10:44:31', '2020-05-10 10:39:49', 0);
INSERT INTO `stock_out_log` VALUES ('93621c867a914af285d3aa1a7460eb14', 'e7a185e5074741b385d3615d41a92038', 'c569782d7dfa4e12800fb7f5c06ae783', 10, '431efd931a6744989928f332a27dbb57', 0, '2020-05-04 15:06:30', '2020-05-03 15:02:57', 0);
INSERT INTO `stock_out_log` VALUES ('9829295083e74c488af6d46d8e7c880e', 'e7a185e5074741b385d3615d41a92038', '65aed7b07efd4141bfb0d6b402f83e8d', 10, '431efd931a6744989928f332a27dbb57', 0, '2020-05-03 15:06:34', '2020-05-03 15:02:48', 0);
INSERT INTO `stock_out_log` VALUES ('aca648c132d54ad39acb715d180d49f2', 'e7a185e5074741b385d3615d41a92038', '3a37adc26cc44d239b6fb4378cd2006c', 15, '5b961d228660441fa367de7255bbfa1a', 0, '2020-05-10 10:44:28', '2020-05-10 10:43:26', 0);
INSERT INTO `stock_out_log` VALUES ('b2d0c4606a3143bb94c7bbef4c5c3afe', 'e7a185e5074741b385d3615d41a92038', '20e3c48e2ac840a48eb55112c63f8ab2', 10, '431efd931a6744989928f332a27dbb57', 0, '2020-05-05 15:06:37', '2020-05-03 14:53:20', 0);
INSERT INTO `stock_out_log` VALUES ('b59903145e4a46769d400bbf0aff7993', NULL, '5797b9c72aaf42769d8a754167fe45ae', 10, '431efd931a6744989928f332a27dbb57', 1, '2020-05-10 10:41:03', '2020-05-10 10:41:03', 0);
INSERT INTO `stock_out_log` VALUES ('c60f1ae106614cd98cb8057c2adc9e2d', NULL, '20e3c48e2ac840a48eb55112c63f8ab2', 5, '4998baa9dfad4d76a19caf6fbc36ca99', 1, '2020-05-10 10:41:15', '2020-05-10 10:41:15', 0);
INSERT INTO `stock_out_log` VALUES ('cc9ab941133947aab0a317207c9f6f9b', NULL, '20e3c48e2ac840a48eb55112c63f8ab2', 5, '431efd931a6744989928f332a27dbb57', 1, '2020-05-10 10:40:32', '2020-05-10 10:40:32', 0);
INSERT INTO `stock_out_log` VALUES ('d7759e340b55419e908c555eed3f031d', 'e7a185e5074741b385d3615d41a92038', '3a37adc26cc44d239b6fb4378cd2006c', 10, '5b961d228660441fa367de7255bbfa1a', 0, '2020-05-10 10:44:34', '2020-05-10 10:42:57', 0);
INSERT INTO `stock_out_log` VALUES ('eabe59681dde4045bedc0a257d406116', NULL, '65aed7b07efd4141bfb0d6b402f83e8d', 4, '196e0f44e01f453281ca7336abe4703b', 1, '2020-05-10 10:40:26', '2020-05-10 10:40:26', 0);
INSERT INTO `stock_out_log` VALUES ('eb157dc4c0cf47df821b087cfd0ea6b7', 'e7a185e5074741b385d3615d41a92038', 'b895d888af4e4e4e9128120447ae1294', 2, '4998baa9dfad4d76a19caf6fbc36ca99', 0, '2020-05-10 10:44:37', '2020-05-10 10:41:29', 0);
INSERT INTO `stock_out_log` VALUES ('ee45284e14c14ba39860fb88bcb7f09e', 'e7a185e5074741b385d3615d41a92038', '5797b9c72aaf42769d8a754167fe45ae', 3, '52c5e19b049a424193d571e6fa4b629f', 0, '2020-05-05 15:11:17', '2020-05-03 15:07:48', 0);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `stu_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `stu_name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `stu_no` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学号',
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系地址',
  `nickname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录名',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `clazz_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级',
  `ban` int(1) NULL DEFAULT 0 COMMENT '0 启用 1 禁用',
  `image` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '照片路径',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `logic_delete_flag` int(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除字段',
  PRIMARY KEY (`stu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学生' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('332bdd84d33d48bc80acd7cf86afa5a6', '李牧', '201610414325', '成都市龙泉驿区', '昵称-李牧', 'limu', 'cd76d7900c08e9fe001bbdecb832a502', '13688290904', '22540f06e7c84165a18efdb4f6ffb390', 0, '/uiaipms/head-img/1588816989011.jpg', '2020-05-07 10:03:11', '2020-05-06 11:43:03', 0);
INSERT INTO `student` VALUES ('e691218ee9d84fbf93939c1a2fa66417', '白起', '201610414324', '北京市朝阳区', '昵称-白起', 'baiqi', '1693e151963a6bcffd490090a2affde7', '13688290904', '45770dc7fc2a4f09a6b79ea2b7f5146b', 0, '/uiaipms/head-img/1588412399347.jpg', '2020-05-06 11:48:24', '2020-05-02 17:34:44', 0);
INSERT INTO `student` VALUES ('e71fdd8e9f274b349456b45c2862b389', '范睢', '201610414326', '', '昵称-范睢', 'fansui', '72c3c990b2f44f7bb40913c1b8c61e15', '13688290904', '2ff8258554b04a26a48030dddd4963f4', 0, '/uiaipms/head-img/icon.png', '2020-05-10 09:55:04', '2020-05-10 09:55:04', 0);

-- ----------------------------
-- Table structure for studio
-- ----------------------------
DROP TABLE IF EXISTS `studio`;
CREATE TABLE `studio`  (
  `stud_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `stud_address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `stud_room_no` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房间号',
  `stud_area` float(5, 0) NULL DEFAULT NULL COMMENT '占地面积',
  `stud_num` int(5) NULL DEFAULT 0 COMMENT '人数',
  `com_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '属于哪个企业',
  `ban` int(1) NULL DEFAULT 0 COMMENT '0 启用 1 禁用，默认0',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `logic_delete_flag` int(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除字段，1 逻辑删除',
  PRIMARY KEY (`stud_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '工作室' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of studio
-- ----------------------------
INSERT INTO `studio` VALUES ('196e0f44e01f453281ca7336abe4703b', '8号楼3层', '02305', 80, 15, '8da64c96335d4047b174d6395c85820f', 0, '2020-05-10 10:39:12', '2020-05-03 14:38:36', 0);
INSERT INTO `studio` VALUES ('27a45afecd9a4c74b9ba8cda043332ee', '1号楼4层', '01405', 90, 0, NULL, 0, '2020-05-03 14:36:36', '2020-05-03 14:36:28', 0);
INSERT INTO `studio` VALUES ('431efd931a6744989928f332a27dbb57', '2号楼2层', '02201', 120, 15, '8da64c96335d4047b174d6395c85820f', 0, '2020-05-03 14:41:12', '2020-05-03 14:35:23', 0);
INSERT INTO `studio` VALUES ('4998baa9dfad4d76a19caf6fbc36ca99', '6号楼5层', '06503', 100, 15, '8da64c96335d4047b174d6395c85820f', 0, '2020-05-10 10:39:15', '2020-05-03 14:37:53', 0);
INSERT INTO `studio` VALUES ('52c5e19b049a424193d571e6fa4b629f', '7号楼6层', '07605', 90, 30, '8da64c96335d4047b174d6395c85820f', 0, '2020-05-06 14:41:55', '2020-05-03 14:38:20', 0);
INSERT INTO `studio` VALUES ('5b961d228660441fa367de7255bbfa1a', '3号楼5层', '03501', 60, 15, '8da64c96335d4047b174d6395c85820f', 0, '2020-05-10 10:39:20', '2020-05-03 14:36:04', 0);
INSERT INTO `studio` VALUES ('64b11ce699e6425cb399796533005ab2', '4号楼3层', '04301', 120, 0, NULL, 0, '2020-05-03 14:37:17', '2020-05-03 14:35:39', 0);
INSERT INTO `studio` VALUES ('95a3b85b09534796a12a1d9c96b92aaa', '5号楼4层', '05403', 120, 0, NULL, 0, '2020-05-03 14:37:32', '2020-05-03 14:37:32', 0);
INSERT INTO `studio` VALUES ('986b2fd7e60e4a44b419eddaa0063869', '9号楼4层', '09405', 100, 0, NULL, 0, '2020-05-03 14:35:47', '2020-05-03 14:35:47', 0);
INSERT INTO `studio` VALUES ('a8b9294d2b0a41efa767aaf638bcde59', '10号楼3层', '10301', 120, 0, NULL, 1, '2020-05-08 15:59:01', '2020-05-03 14:38:57', 0);

-- ----------------------------
-- Table structure for studio_apply
-- ----------------------------
DROP TABLE IF EXISTS `studio_apply`;
CREATE TABLE `studio_apply`  (
  `sa_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `stud_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作室id',
  `apply_com_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请企业d',
  `deal_user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '处理人id',
  `apply_reason` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请理由',
  `sa_reason` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '处理结果说明',
  `agree` int(1) NULL DEFAULT 1 COMMENT '处理结果 0 同意 1不同意 默认1',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `logic_delete_flag` int(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除字段',
  PRIMARY KEY (`sa_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of studio_apply
-- ----------------------------
INSERT INTO `studio_apply` VALUES ('14730448d5c3420ab7da5a9f74d45e7a', '431efd931a6744989928f332a27dbb57', '8da64c96335d4047b174d6395c85820f', '69fcc37f356b4767b1d556ecace9d479', '测试，测试，测试，测试，测试，测试，测试，测试', '测试，测试，测试，测试，测试，测试，测试', 0, '2020-05-03 14:40:47', '2020-05-03 14:40:06', 0);
INSERT INTO `studio_apply` VALUES ('169b2a6a210d4b0c94eddfd9a4df6966', '52c5e19b049a424193d571e6fa4b629f', '8da64c96335d4047b174d6395c85820f', '69fcc37f356b4767b1d556ecace9d479', '测试，测试，测试，测试，测试，测试，测试', '测试，测试，测试，测试，测试，测试，测试', 0, '2020-05-03 14:40:54', '2020-05-03 14:40:15', 0);
INSERT INTO `studio_apply` VALUES ('4d3d191a767e48a3894c17e3be4495d0', '5b961d228660441fa367de7255bbfa1a', '8da64c96335d4047b174d6395c85820f', '69fcc37f356b4767b1d556ecace9d479', '工作室申请，工作室申请，工作室申请，工作室申请，', '同意申请，同意申请，同意申请，同意申请，同意申请，', 0, '2020-05-10 10:38:48', '2020-05-10 10:37:47', 0);
INSERT INTO `studio_apply` VALUES ('53a8c2f222cf42c296efbe80752ce28d', '196e0f44e01f453281ca7336abe4703b', '8da64c96335d4047b174d6395c85820f', '69fcc37f356b4767b1d556ecace9d479', '测试，测试，测试，测试，测试，测试，测试', '测试，测试，测试，测试，测试，测试', 1, '2020-05-03 14:41:00', '2020-05-03 14:39:57', 0);
INSERT INTO `studio_apply` VALUES ('5a76c1072a854db98e39b812d901f96e', '196e0f44e01f453281ca7336abe4703b', '8da64c96335d4047b174d6395c85820f', '69fcc37f356b4767b1d556ecace9d479', '工作室申请，工作室申请，工作室申请，工作室申请，', '同意申请，同意申请，同意申请，', 0, '2020-05-10 10:38:53', '2020-05-10 10:37:39', 0);
INSERT INTO `studio_apply` VALUES ('af347e2142cc4458a898938a0f884714', '4998baa9dfad4d76a19caf6fbc36ca99', '8da64c96335d4047b174d6395c85820f', '69fcc37f356b4767b1d556ecace9d479', '工作室申请，工作室申请，工作室申请，工作室申请，', '同意申请，同意申请，同意申请，同意申请，', 0, '2020-05-10 10:38:57', '2020-05-10 10:37:55', 0);

-- ----------------------------
-- Table structure for sys_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_info`;
CREATE TABLE `sys_info`  (
  `sys_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `sys_param` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `sys_count` decimal(10, 0) NULL DEFAULT NULL COMMENT '数量',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `logic_delete_flag` int(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除字段',
  PRIMARY KEY (`sys_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_info
-- ----------------------------
INSERT INTO `sys_info` VALUES ('e0dacc4daba5459689e6de8aef2b05a5', '园区资金', 942079, '2020-05-10 16:42:57', '2020-03-19 15:51:29', 0);

-- ----------------------------
-- Table structure for tutor
-- ----------------------------
DROP TABLE IF EXISTS `tutor`;
CREATE TABLE `tutor`  (
  `tutor_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `tutor_name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '导师姓名',
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `nickname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `faculty_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学院id',
  `ban` int(1) NULL DEFAULT 0 COMMENT '0 启用 1 禁用',
  `image` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '照片地址',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `logic_delete_flag` int(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除字段',
  PRIMARY KEY (`tutor_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '导师' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tutor
-- ----------------------------
INSERT INTO `tutor` VALUES ('66c38cfebcac46649d071058f2eb7fd1', '张飞', '15908298537', '85a0c9b22b57e9fd351b9c4bc4936566', '昵称-张飞', 'leader_zhangfei', 'af6d4fea76c742fea432e482c391911b', 0, '/uiaipms/head-img/1588817341705.jpg', '2020-05-07 10:09:04', '2020-01-13 10:39:42', 0);
INSERT INTO `tutor` VALUES ('e80f275768a24d9e855bf5595a6e1f33', '刘备', '15908298537', 'a6a376ba1037c351d523b74f30e427a6', '昵称-刘备', 'tutor_liubei', 'af6d4fea76c742fea432e482c391911b', 0, '/uiaipms/head-img/1588817408047.jpg', '2020-05-07 10:10:10', '2020-01-14 16:24:07', 0);

-- ----------------------------
-- Table structure for unit
-- ----------------------------
DROP TABLE IF EXISTS `unit`;
CREATE TABLE `unit`  (
  `unit_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `unit_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`unit_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '计量单位' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of unit
-- ----------------------------
INSERT INTO `unit` VALUES ('16c327eea32e488f9793daf7c66218d7', '根');
INSERT INTO `unit` VALUES ('22f91b73d387491a8b52dd9dfe9730c7', '扇');
INSERT INTO `unit` VALUES ('2b00a4e19bb242cc9670f45bdfda6c60', '个');
INSERT INTO `unit` VALUES ('2fdff5120bac4445854040a83d976c2b', '箱');
INSERT INTO `unit` VALUES ('6434f550d25c455e9923b595f19e2196', '把');
INSERT INTO `unit` VALUES ('b4a86e649de549cc89d29c5250cb3bcd', '张');
INSERT INTO `unit` VALUES ('bef6ce6b6bfb414bb773e9823baf8ac3', '组');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `ur_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `role_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色',
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户',
  `ur_who` int(1) NULL DEFAULT NULL COMMENT '用户类型 1 管理员 2 导师 3 学生 4 企业',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `logic_delete_flag` int(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除字段',
  PRIMARY KEY (`ur_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户的角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1fe7fcb06f38478cb5c36c4aa7b75165', '3c0ac27e560643fa9495de3f69dc615a', 'e7a185e5074741b385d3615d41a92038', 1, '2020-05-02 16:58:41', '2020-05-02 16:58:39', 0);
INSERT INTO `user_role` VALUES ('24aba6240ce241abbd475f360f5e9775', '3bfb84a2ad49489aab8be641fc87472a', '8da64c96335d4047b174d6395c85820f', 4, '2020-05-02 17:19:09', '2020-05-02 17:19:09', 0);
INSERT INTO `user_role` VALUES ('2f0ee2e5f9684a1f9663e0ff77b47140', '553df5a84743447faa2e8a7e19534b88', '66c38cfebcac46649d071058f2eb7fd1', 2, '2020-05-10 16:38:36', '2020-05-10 16:38:36', 1);
INSERT INTO `user_role` VALUES ('51b3b7d3256d43929ccbeadc67260e0e', 'b5fb3c3f9f8b4dd1bb0011ee2e5b70af', '66c38cfebcac46649d071058f2eb7fd1', 2, '2020-05-02 16:56:12', '2020-05-02 16:56:10', 0);
INSERT INTO `user_role` VALUES ('7016b158efb649778415c34ed85709fe', '10a258b4defc4f5db4847b09ce883f73', 'e691218ee9d84fbf93939c1a2fa66417', 3, '2020-05-02 17:34:44', '2020-05-02 17:34:44', 0);
INSERT INTO `user_role` VALUES ('773d244ab95a4d9d90aee47278ba11ac', '10a258b4defc4f5db4847b09ce883f73', '332bdd84d33d48bc80acd7cf86afa5a6', 3, '2020-05-06 11:43:03', '2020-05-06 11:43:03', 0);
INSERT INTO `user_role` VALUES ('8733cc561f354365bfa8afdfdac3963e', '10a258b4defc4f5db4847b09ce883f73', 'e71fdd8e9f274b349456b45c2862b389', 3, '2020-05-10 09:55:04', '2020-05-10 09:55:04', 0);
INSERT INTO `user_role` VALUES ('8d8ba2d6bafb4537bbd046d950253b9f', '3bfb84a2ad49489aab8be641fc87472a', 'a90d4f8a7c3448a69dfcbb18b89f293e', 4, '2020-05-06 14:27:58', '2020-05-06 14:27:58', 0);
INSERT INTO `user_role` VALUES ('a392837744254965a6a4a4ad966e4fac', '553df5a84743447faa2e8a7e19534b88', '1447df502e6b4a5fa2b148be4bf03ec4', 1, '2020-05-02 16:58:36', '2020-05-02 16:58:34', 0);
INSERT INTO `user_role` VALUES ('b1aab6068b5a4382b82ada696842b635', '50e04dd5a7c140e98f107ae4b0d1a8b0', 'e80f275768a24d9e855bf5595a6e1f33', 2, '2020-05-02 16:57:13', '2020-05-02 16:57:11', 0);
INSERT INTO `user_role` VALUES ('da368f44d8ff494388c0ab9c032d7362', '50e04dd5a7c140e98f107ae4b0d1a8b0', '66c38cfebcac46649d071058f2eb7fd1', 2, '2020-05-10 16:48:29', '2020-05-10 16:48:29', 0);
INSERT INTO `user_role` VALUES ('e4c87b99f2694eb2b93b83c3eaafcb2a', '8d9c223f83494839b8332dd11c4833d8', '69fcc37f356b4767b1d556ecace9d479', 1, '2020-05-02 16:58:21', '2020-05-02 16:58:24', 0);
INSERT INTO `user_role` VALUES ('fe05c29893804d94ad84764bc6fdcbc3', '50e04dd5a7c140e98f107ae4b0d1a8b0', '66c38cfebcac46649d071058f2eb7fd1', 2, '2020-05-03 14:39:15', '2020-05-03 14:39:15', 1);

SET FOREIGN_KEY_CHECKS = 1;
