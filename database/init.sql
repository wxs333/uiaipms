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

 Date: 03/05/2020 16:13:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1447df502e6b4a5fa2b148be4bf03ec4', '宋江', 'fin_admin', '30a73d6e2749604dc8322498f318da8b', '昵称-宋江', 0, '13688290904', '/uiaipms/head-img/1588490362691.jpg', '2020-05-03 15:19:23', '2020-01-13 11:14:16', 0);
INSERT INTO `admin` VALUES ('69fcc37f356b4767b1d556ecace9d479', '李逵', 'sys_admin', 'e386dc78feaaf547344db6a194fafe7e', '昵称-李逵', 0, '13688290904', '/uiaipms/head-img/icon.png', '2020-04-23 13:38:50', '2020-01-11 17:33:49', 0);
INSERT INTO `admin` VALUES ('e7a185e5074741b385d3615d41a92038', '卢俊义', 'stock_admin', '47647c8cca867416b5ecda48173fcf0a', '昵称-卢俊义', 0, NULL, '/uiaipms/head-img/icon.png', '2020-04-30 14:08:49', '2020-02-17 12:07:42', 0);

-- ----------------------------
-- Records of buy_funds_apply
-- ----------------------------
INSERT INTO `buy_funds_apply` VALUES ('0087263287f845759e917a1837d7ff18', '883a51f8cae347048e45a785b8f87a0e', 0, 1, '第12次测试，不同意', 'e7a185e5074741b385d3615d41a92038', '购买路由器10个，单价500元', 5000, '2020-03-20 15:47:01', '2020-03-23 19:08:58', 0);
INSERT INTO `buy_funds_apply` VALUES ('0ab87df4c31747aa9a5c6eaefd2b1bd4', '1447df502e6b4a5fa2b148be4bf03ec4', 0, 0, '同意同意同意同意同意同意同意同意同意同意同意同意', 'e7a185e5074741b385d3615d41a92038', '嘟嘟嘟嘟嘟', 6202, '2020-04-08 21:56:50', '2020-04-23 16:01:24', 0);
INSERT INTO `buy_funds_apply` VALUES ('2a366a2c403440f99a3f9311a6ac65b3', '1447df502e6b4a5fa2b148be4bf03ec4', 0, 0, '同意，同意，同意，同意，同意，同意，同意', 'e7a185e5074741b385d3615d41a92038', '采购，采购，采购，采购，采购，采购，采购，', 1500, '2020-05-03 15:13:50', '2020-05-03 15:17:23', 0);
INSERT INTO `buy_funds_apply` VALUES ('3e67689751ef49aca4b0b00de81802c8', '1447df502e6b4a5fa2b148be4bf03ec4', 0, 0, '同意，同意，同意，同意，同意，同意，同意', 'e7a185e5074741b385d3615d41a92038', '采购，采购，采购，采购，采购，采购，采购，', 500, '2020-05-03 15:13:56', '2020-05-03 15:17:12', 0);
INSERT INTO `buy_funds_apply` VALUES ('4becb8ab247a4ea58ff19eb1c4e3af03', '1447df502e6b4a5fa2b148be4bf03ec4', 0, 0, '同意，同意，同意，同意，同意，同意，同意', 'e7a185e5074741b385d3615d41a92038', '采购，采购，采购，采购，采购，采购，采购', 3000, '2020-05-03 15:13:44', '2020-05-03 15:17:31', 0);
INSERT INTO `buy_funds_apply` VALUES ('4cdb6210132d4d8e8a76166bb0dda652', '1447df502e6b4a5fa2b148be4bf03ec4', 0, 1, '不同意，不同意，不同意，不同意，不同意，不同意，', 'e7a185e5074741b385d3615d41a92038', '采购椅子，采购椅子，采购椅子，采购椅子，采购椅子', 1000, '2020-05-03 15:13:03', '2020-05-03 15:17:50', 0);
INSERT INTO `buy_funds_apply` VALUES ('9a0cdec3fcc04fc5920220a9732b3d27', '883a51f8cae347048e45a785b8f87a0e', 0, 0, '第十一次测试，同意', 'e7a185e5074741b385d3615d41a92038', '测试', 5000, '2020-03-20 15:47:51', '2020-03-23 19:08:24', 0);
INSERT INTO `buy_funds_apply` VALUES ('a034bbee72644a2eb80cf59cc26cd2f4', '1447df502e6b4a5fa2b148be4bf03ec4', 0, 1, '不同意，不同意，不同意，不同意，不同意，不同意', 'e7a185e5074741b385d3615d41a92038', '采购路由器，采购路由器，采购路由器，采购路由器，采购路由器', 2000, '2020-05-03 15:13:22', '2020-05-03 15:17:43', 0);
INSERT INTO `buy_funds_apply` VALUES ('a062c071e74e4a2aa298e47ba37aa6c7', '883a51f8cae347048e45a785b8f87a0e', 0, 1, '不通过', 'e7a185e5074741b385d3615d41a92038', '测试2', 5000, '2020-04-08 21:36:58', '2020-04-09 13:19:52', 0);
INSERT INTO `buy_funds_apply` VALUES ('a070d54e73ba416fa87ee640e0da3166', '883a51f8cae347048e45a785b8f87a0e', 0, 0, '同意', 'e7a185e5074741b385d3615d41a92038', '购买椅子10张，单价50元', 500, '2020-03-20 15:45:54', '2020-04-08 21:56:15', 0);
INSERT INTO `buy_funds_apply` VALUES ('acd7bade8cea40b4a74a6cdc0612828c', '1447df502e6b4a5fa2b148be4bf03ec4', 0, 0, '同意，同意，同意，同意，同意，同意，同意', 'e7a185e5074741b385d3615d41a92038', '采购，采购，采购，采购，采购，采购，采购，', 1800, '2020-05-03 15:14:03', '2020-05-03 15:17:06', 0);
INSERT INTO `buy_funds_apply` VALUES ('d6f7696dfdff4a6ca683a5e52a82e30e', '883a51f8cae347048e45a785b8f87a0e', 0, 0, '第10次测试，同意', 'e7a185e5074741b385d3615d41a92038', '第二次测试', 3000, '2020-03-20 15:50:33', '2020-03-23 19:08:03', 0);
INSERT INTO `buy_funds_apply` VALUES ('dcc235312df54d30998c91c191054472', '883a51f8cae347048e45a785b8f87a0e', 0, 0, '同意', 'e7a185e5074741b385d3615d41a92038', '测试', 3000, '2020-04-08 21:04:39', '2020-04-08 21:55:22', 0);
INSERT INTO `buy_funds_apply` VALUES ('ef3b061bbebb43118d60eb4b39f539c5', '1447df502e6b4a5fa2b148be4bf03ec4', 0, 0, '泳衣泳衣泳衣泳衣泳衣泳衣泳衣泳衣泳衣泳衣', 'e7a185e5074741b385d3615d41a92038', '测试坻崿是测试坻崿是测试坻崿是测试坻崿是测试坻崿是测试坻崿是', 3000, '2020-04-23 16:30:03', '2020-04-23 16:31:12', 0);

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
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES ('8da64c96335d4047b174d6395c85820f', '大汉帝国', 'dahan', '13688290904', 'abf84e05f36b7466e7595fdac03a1a3a', '刘邦', 0, '/uiaipms/head-img/icon.png', '《国家学生体质健康标准》登记表，男生大三、四（表格三）(1).doc', '/uiaipms/company/1588411087739.doc', 0, '2020-05-02 17:19:09', '2020-05-02 17:18:11', 0);

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
-- Records of faculty
-- ----------------------------
INSERT INTO `faculty` VALUES ('534b320d10bd426cb4fbc4ddf823b92f', '文学与新闻传播学院', '文新学院');
INSERT INTO `faculty` VALUES ('8ca239f1aa2844289c21a5c6c225e526', '体育学院', '体院');
INSERT INTO `faculty` VALUES ('91849a1a55314c788a07715a22d7e86b', '外国语学院', '外国语');
INSERT INTO `faculty` VALUES ('954e8e86d67f4ad198ae0907429c8f92', '商学院', '商学院');
INSERT INTO `faculty` VALUES ('af6d4fea76c742fea432e482c391911b', '信息科学与工程学院', '信工');

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('15c088c7812a4fc28d37a358b4d9b7fa', '空调', 16, '2b00a4e19bb242cc9670f45bdfda6c60', '模拟数据-型号6', '模拟数据-品牌6', 0, '2020-05-03 15:11:00', '2020-05-03 14:49:25', 0);
INSERT INTO `goods` VALUES ('20e3c48e2ac840a48eb55112c63f8ab2', '椅子', 80, 'b4a86e649de549cc89d29c5250cb3bcd', '模拟数据-型号1', '模拟数据-品牌1', 0, '2020-05-03 15:11:13', '2020-05-03 14:42:46', 0);
INSERT INTO `goods` VALUES ('3a37adc26cc44d239b6fb4378cd2006c', '咖啡凳', 390, 'b4a86e649de549cc89d29c5250cb3bcd', '模拟数据-型号8', '模拟数据-品牌8', 0, '2020-05-03 15:11:10', '2020-05-03 14:50:54', 0);
INSERT INTO `goods` VALUES ('5797b9c72aaf42769d8a754167fe45ae', '路由器', 94, '2b00a4e19bb242cc9670f45bdfda6c60', '模拟数据-型号2', '模拟数据-品牌2', 0, '2020-05-03 15:11:17', '2020-05-03 14:43:50', 0);
INSERT INTO `goods` VALUES ('65aed7b07efd4141bfb0d6b402f83e8d', '办公桌', 90, 'b4a86e649de549cc89d29c5250cb3bcd', '模拟数据-型号3', '模拟数据-品牌3', 0, '2020-05-03 15:06:33', '2020-05-03 14:44:42', 0);
INSERT INTO `goods` VALUES ('6937cee5b3fc4865bb5965e4318f3bdb', '咖啡桌', 70, 'b4a86e649de549cc89d29c5250cb3bcd', '模拟数据-型号7', '模拟数据-品牌7', 0, '2020-05-03 15:11:04', '2020-05-03 14:50:08', 0);
INSERT INTO `goods` VALUES ('781c1a7a30c94be7a408d456a1ddda0e', '咖啡凳', 100, 'b4a86e649de549cc89d29c5250cb3bcd', '模拟数据-型号10', '模拟数据-品牌10', 0, '2020-05-03 15:10:19', '2020-05-03 15:10:19', 0);
INSERT INTO `goods` VALUES ('b895d888af4e4e4e9128120447ae1294', '铁皮箱', 90, 'bef6ce6b6bfb414bb773e9823baf8ac3', '模拟数据-型号5', '模拟数据-品牌5', 0, '2020-05-03 15:11:07', '2020-05-03 14:48:09', 0);
INSERT INTO `goods` VALUES ('c569782d7dfa4e12800fb7f5c06ae783', '网线', 190, '16c327eea32e488f9793daf7c66218d7', '模拟数据-型号4', '模拟数据-品牌4', 0, '2020-05-03 15:06:30', '2020-05-03 14:47:30', 0);

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('1865a418fa1d459ca3a55fa787075163', 'ftp文档上传项目', 'e691218ee9d84fbf93939c1a2fa66417', 'd成都大学学生入学“绿色通道”审批表（填表规范）.doc', '/uiaipms/word/1588412250062.doc', 'ftp文档上传项目，ftp文档上传项目，ftp文档上传项目，ftp文档上传项目，ftp文档上传项目', '2020-05-02 17:37:35', '2020-05-02 17:37:35', 0);
INSERT INTO `project` VALUES ('c15dbe7b6dd94ff299f7cd33342266c2', '测试项目申报', 'e691218ee9d84fbf93939c1a2fa66417', 'My SQL.docx', '/uiaipms/word/1588412328279.docx', '测试项目申报，测试项目申报，测试项目申报，测试项目申报', '2020-05-02 17:38:51', '2020-05-02 17:38:51', 0);
INSERT INTO `project` VALUES ('c717019bf3a54c1cbb6b97ab3bc2c0b2', '测试项目上传', 'e691218ee9d84fbf93939c1a2fa66417', 'd四川省学生资助管理系统银行卡号及开户行核对修改流程.docx', '/uiaipms/word/1588412284723.docx', '测试项目上传，测试项目上传，测试项目上传，测试项目上传', '2020-05-02 17:38:07', '2020-05-02 17:38:07', 0);

-- ----------------------------
-- Records of project_approval
-- ----------------------------
INSERT INTO `project_approval` VALUES ('3e80e6e31b8543f7875429ade6b7474a', '1865a418fa1d459ca3a55fa787075163', 'e80f275768a24d9e855bf5595a6e1f33', 0, 'ftp文档上传项目同意，ftp文档上传项目同意，ftp文档上传项目同意', '2020-05-02 17:41:08', '2020-05-02 17:37:35', 0);
INSERT INTO `project_approval` VALUES ('7f47083190c94471b49a3a061b3682be', 'c717019bf3a54c1cbb6b97ab3bc2c0b2', 'e80f275768a24d9e855bf5595a6e1f33', 0, '测试项目上传同意，测试项目上传同意，测试项目上传同意', '2020-05-02 17:41:38', '2020-05-02 17:38:07', 0);
INSERT INTO `project_approval` VALUES ('930b1e0a73564270a6c3993e3ef98e2a', 'c15dbe7b6dd94ff299f7cd33342266c2', NULL, 1, NULL, NULL, '2020-05-02 17:38:51', 0);

-- ----------------------------
-- Records of project_finance
-- ----------------------------
INSERT INTO `project_finance` VALUES ('2ff783849dff431a94738c451f533b6c', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 500, '测试，测试，测试，测试，测试，测试，测试，测试', 'c717019bf3a54c1cbb6b97ab3bc2c0b2', 0, 0, '测试-同意，测试-同意，测试-同意，测试-同意，测试-同意', '2020-05-02 17:51:02', '2020-05-01 17:50:22', 0);
INSERT INTO `project_finance` VALUES ('526f515e1d7c48c78d79066692baa6d7', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 30000, '测试，测试，测试，测试，测试，测试，测试', 'c717019bf3a54c1cbb6b97ab3bc2c0b2', 0, 1, '同意，同意，同意，同意，同意，同意，同意', '2020-05-02 18:07:43', '2020-05-01 18:06:53', 0);
INSERT INTO `project_finance` VALUES ('5ff08abf04944679a2f82f8036f2bf8d', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 30000, '测试，测试，测试，测试，测试，测试，测试，测试', 'c717019bf3a54c1cbb6b97ab3bc2c0b2', 0, 0, '同意，同意，同意，同意，同意，同意，同意', '2020-05-02 18:00:37', '2020-05-01 17:58:55', 0);
INSERT INTO `project_finance` VALUES ('a7ff8f23730a4c24a63eb0375f6a5b1e', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 500, '测试，测试，测试，测试，测试，测试，测试', 'c717019bf3a54c1cbb6b97ab3bc2c0b2', 0, 0, '同意，同意，同意，同意，同意，同意，同意', '2020-05-03 18:04:57', '2020-05-02 18:03:56', 0);
INSERT INTO `project_finance` VALUES ('d31a103b3bee45928a96a5ce66d51088', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 3000, '项目资金申请测试，项目资金申请测试，项目资金申请测试', 'c717019bf3a54c1cbb6b97ab3bc2c0b2', 0, 0, '测试--同意，测试--同意，测试--同意，测试--同意', '2020-05-03 17:51:25', '2020-05-02 17:50:01', 0);
INSERT INTO `project_finance` VALUES ('d49a8b07edee4121a8276f0a9731f66f', '1447df502e6b4a5fa2b148be4bf03ec4', '66c38cfebcac46649d071058f2eb7fd1', 5000, '测试，测试，测试，测试，测试，测试，测试', 'c717019bf3a54c1cbb6b97ab3bc2c0b2', 0, 0, '同意，同意，同意，同意，同意，同意，同意，同意', '2020-05-03 17:59:24', '2020-05-02 17:56:22', 0);

-- ----------------------------
-- Records of project_review
-- ----------------------------
INSERT INTO `project_review` VALUES ('390a951cc65a4d9b85408e22fd341528', NULL, '1865a418fa1d459ca3a55fa787075163', 1, NULL, NULL, '2020-05-02 17:37:35', 0);
INSERT INTO `project_review` VALUES ('5336cd644c0a4f1c8b409268ac9f199d', '66c38cfebcac46649d071058f2eb7fd1', 'c717019bf3a54c1cbb6b97ab3bc2c0b2', 0, '测试项目上传同意，测试项目上传同意，测试项目上传同意，测试项目上传同意', '2020-05-02 17:47:54', '2020-05-02 17:38:07', 0);
INSERT INTO `project_review` VALUES ('86096721fe224a888dd6d8e7deb58de8', NULL, 'c15dbe7b6dd94ff299f7cd33342266c2', 1, NULL, NULL, '2020-05-02 17:38:51', 0);

-- ----------------------------
-- Records of project_starting
-- ----------------------------
INSERT INTO `project_starting` VALUES ('5c1770b52db04faf911df96b9a9b5102', '66c38cfebcac46649d071058f2eb7fd1', 'c717019bf3a54c1cbb6b97ab3bc2c0b2', 0, '2020-05-02 17:38:07', '2020-05-02 17:49:07', 0);
INSERT INTO `project_starting` VALUES ('b2414865f075454098ead3c8c70c6376', NULL, 'c15dbe7b6dd94ff299f7cd33342266c2', 1, '2020-05-02 17:38:51', NULL, 0);
INSERT INTO `project_starting` VALUES ('f31e0bc8609d4157817bdc4be9210541', NULL, '1865a418fa1d459ca3a55fa787075163', 1, '2020-05-02 17:37:35', NULL, 0);

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
-- Records of stock_out_log
-- ----------------------------
INSERT INTO `stock_out_log` VALUES ('15605c177c724078a5fbe4b66883a1a0', 'e7a185e5074741b385d3615d41a92038', '15c088c7812a4fc28d37a358b4d9b7fa', 2, '52c5e19b049a424193d571e6fa4b629f', 0, '2020-05-02 15:11:01', '2020-05-03 15:07:37', 0);
INSERT INTO `stock_out_log` VALUES ('39bba1a868b44a7cafb2505c88a96dea', 'e7a185e5074741b385d3615d41a92038', '6937cee5b3fc4865bb5965e4318f3bdb', 30, '52c5e19b049a424193d571e6fa4b629f', 0, '2020-05-02 15:11:04', '2020-05-03 15:08:14', 0);
INSERT INTO `stock_out_log` VALUES ('50758ebcbd254e52a896c17c808c8f0c', 'e7a185e5074741b385d3615d41a92038', 'b895d888af4e4e4e9128120447ae1294', 5, '52c5e19b049a424193d571e6fa4b629f', 0, '2020-05-02 15:11:07', '2020-05-03 15:07:43', 0);
INSERT INTO `stock_out_log` VALUES ('6ec651bb3c144269a34f62f6f7ccd80c', 'e7a185e5074741b385d3615d41a92038', 'b895d888af4e4e4e9128120447ae1294', 5, '431efd931a6744989928f332a27dbb57', 0, '2020-05-03 15:06:21', '2020-05-03 15:02:25', 0);
INSERT INTO `stock_out_log` VALUES ('769e5fd810994b8f974a32b87f4310b9', 'e7a185e5074741b385d3615d41a92038', '5797b9c72aaf42769d8a754167fe45ae', 3, '431efd931a6744989928f332a27dbb57', 0, '2020-05-03 15:06:24', '2020-05-03 15:02:37', 0);
INSERT INTO `stock_out_log` VALUES ('81d289cc8bd940f3915a706d81e235f7', 'e7a185e5074741b385d3615d41a92038', '3a37adc26cc44d239b6fb4378cd2006c', 10, '52c5e19b049a424193d571e6fa4b629f', 0, '2020-05-03 15:11:11', '2020-05-03 15:07:55', 0);
INSERT INTO `stock_out_log` VALUES ('8806032eccfc418ca522229d487413ca', 'e7a185e5074741b385d3615d41a92038', '15c088c7812a4fc28d37a358b4d9b7fa', 2, '431efd931a6744989928f332a27dbb57', 0, '2020-05-04 15:06:28', '2020-05-03 14:53:35', 0);
INSERT INTO `stock_out_log` VALUES ('8c400fcca19f44369e473541e4be51ec', 'e7a185e5074741b385d3615d41a92038', '20e3c48e2ac840a48eb55112c63f8ab2', 10, '52c5e19b049a424193d571e6fa4b629f', 0, '2020-05-04 15:11:14', '2020-05-03 15:07:31', 0);
INSERT INTO `stock_out_log` VALUES ('93621c867a914af285d3aa1a7460eb14', 'e7a185e5074741b385d3615d41a92038', 'c569782d7dfa4e12800fb7f5c06ae783', 10, '431efd931a6744989928f332a27dbb57', 0, '2020-05-04 15:06:30', '2020-05-03 15:02:57', 0);
INSERT INTO `stock_out_log` VALUES ('9829295083e74c488af6d46d8e7c880e', 'e7a185e5074741b385d3615d41a92038', '65aed7b07efd4141bfb0d6b402f83e8d', 10, '431efd931a6744989928f332a27dbb57', 0, '2020-05-03 15:06:34', '2020-05-03 15:02:48', 0);
INSERT INTO `stock_out_log` VALUES ('b2d0c4606a3143bb94c7bbef4c5c3afe', 'e7a185e5074741b385d3615d41a92038', '20e3c48e2ac840a48eb55112c63f8ab2', 10, '431efd931a6744989928f332a27dbb57', 0, '2020-05-05 15:06:37', '2020-05-03 14:53:20', 0);
INSERT INTO `stock_out_log` VALUES ('ee45284e14c14ba39860fb88bcb7f09e', 'e7a185e5074741b385d3615d41a92038', '5797b9c72aaf42769d8a754167fe45ae', 3, '52c5e19b049a424193d571e6fa4b629f', 0, '2020-05-05 15:11:17', '2020-05-03 15:07:48', 0);

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('e691218ee9d84fbf93939c1a2fa66417', '白起', '201610414324', '北京市朝阳区', '昵称-白起', 'baiqi', 'c67cfb29f825945eacc4534ed64e7e02', '13688290904', '45770dc7fc2a4f09a6b79ea2b7f5146b', 0, '/uiaipms/head-img/1588412399347.jpg', '2020-05-03 16:02:08', '2020-05-02 17:34:44', 0);

-- ----------------------------
-- Records of studio
-- ----------------------------
INSERT INTO `studio` VALUES ('196e0f44e01f453281ca7336abe4703b', '8号楼3层', '02305', 80, 0, NULL, 0, '2020-05-03 14:38:36', '2020-05-03 14:38:36', 0);
INSERT INTO `studio` VALUES ('27a45afecd9a4c74b9ba8cda043332ee', '1号楼4层', '01405', 90, 0, NULL, 0, '2020-05-03 14:36:36', '2020-05-03 14:36:28', 0);
INSERT INTO `studio` VALUES ('431efd931a6744989928f332a27dbb57', '2号楼2层', '02201', 120, 15, '8da64c96335d4047b174d6395c85820f', 0, '2020-05-03 14:41:12', '2020-05-03 14:35:23', 0);
INSERT INTO `studio` VALUES ('4998baa9dfad4d76a19caf6fbc36ca99', '6号楼5层', '06503', 100, 0, NULL, 0, '2020-05-03 14:37:53', '2020-05-03 14:37:53', 0);
INSERT INTO `studio` VALUES ('52c5e19b049a424193d571e6fa4b629f', '7号楼6层', '07605', 90, 30, '8da64c96335d4047b174d6395c85820f', 0, '2020-05-03 14:41:16', '2020-05-03 14:38:20', 0);
INSERT INTO `studio` VALUES ('5b961d228660441fa367de7255bbfa1a', '3号楼5层', '03501', 60, 0, NULL, 0, '2020-05-03 14:36:04', '2020-05-03 14:36:04', 0);
INSERT INTO `studio` VALUES ('64b11ce699e6425cb399796533005ab2', '4号楼3层', '04301', 120, 0, NULL, 0, '2020-05-03 14:37:17', '2020-05-03 14:35:39', 0);
INSERT INTO `studio` VALUES ('95a3b85b09534796a12a1d9c96b92aaa', '5号楼4层', '05403', 120, 0, NULL, 0, '2020-05-03 14:37:32', '2020-05-03 14:37:32', 0);
INSERT INTO `studio` VALUES ('986b2fd7e60e4a44b419eddaa0063869', '9号楼4层', '09405', 100, 0, NULL, 0, '2020-05-03 14:35:47', '2020-05-03 14:35:47', 0);
INSERT INTO `studio` VALUES ('a8b9294d2b0a41efa767aaf638bcde59', '10号楼3层', '10301', 120, 0, NULL, 0, '2020-05-03 14:38:57', '2020-05-03 14:38:57', 0);

-- ----------------------------
-- Records of studio_apply
-- ----------------------------
INSERT INTO `studio_apply` VALUES ('14730448d5c3420ab7da5a9f74d45e7a', '431efd931a6744989928f332a27dbb57', '8da64c96335d4047b174d6395c85820f', '69fcc37f356b4767b1d556ecace9d479', '测试，测试，测试，测试，测试，测试，测试，测试', '测试，测试，测试，测试，测试，测试，测试', 0, '2020-05-03 14:40:47', '2020-05-03 14:40:06', 0);
INSERT INTO `studio_apply` VALUES ('169b2a6a210d4b0c94eddfd9a4df6966', '52c5e19b049a424193d571e6fa4b629f', '8da64c96335d4047b174d6395c85820f', '69fcc37f356b4767b1d556ecace9d479', '测试，测试，测试，测试，测试，测试，测试', '测试，测试，测试，测试，测试，测试，测试', 0, '2020-05-03 14:40:54', '2020-05-03 14:40:15', 0);
INSERT INTO `studio_apply` VALUES ('53a8c2f222cf42c296efbe80752ce28d', '196e0f44e01f453281ca7336abe4703b', '8da64c96335d4047b174d6395c85820f', '69fcc37f356b4767b1d556ecace9d479', '测试，测试，测试，测试，测试，测试，测试', '测试，测试，测试，测试，测试，测试', 1, '2020-05-03 14:41:00', '2020-05-03 14:39:57', 0);

-- ----------------------------
-- Records of sys_info
-- ----------------------------
INSERT INTO `sys_info` VALUES ('e0dacc4daba5459689e6de8aef2b05a5', '园区资金', 952699, '2020-05-03 15:17:43', '2020-03-19 15:51:29', 0);

-- ----------------------------
-- Records of tutor
-- ----------------------------
INSERT INTO `tutor` VALUES ('66c38cfebcac46649d071058f2eb7fd1', '张飞', '15908298537', '5c9fde8ac48fae29aafe30d94b07808c', '昵称-张飞', 'leader_zhangfei', 'af6d4fea76c742fea432e482c391911b', 0, '/uiaipms/head-img/icon.png', '2020-04-30 14:21:18', '2020-01-13 10:39:42', 0);
INSERT INTO `tutor` VALUES ('e80f275768a24d9e855bf5595a6e1f33', '刘备', '15908298537', '800b98ea9bc2f6cbfa9e78456eb3303c', '昵称-刘备', 'tutor_liubei', 'af6d4fea76c742fea432e482c391911b', 0, '/uiaipms/head-img/icon.png', '2020-04-23 14:30:07', '2020-01-14 16:24:07', 0);

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
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1fe7fcb06f38478cb5c36c4aa7b75165', '3c0ac27e560643fa9495de3f69dc615a', 'e7a185e5074741b385d3615d41a92038', 1, '2020-05-02 16:58:41', '2020-05-02 16:58:39', 0);
INSERT INTO `user_role` VALUES ('24aba6240ce241abbd475f360f5e9775', '3bfb84a2ad49489aab8be641fc87472a', '8da64c96335d4047b174d6395c85820f', 4, '2020-05-02 17:19:09', '2020-05-02 17:19:09', 0);
INSERT INTO `user_role` VALUES ('51b3b7d3256d43929ccbeadc67260e0e', 'b5fb3c3f9f8b4dd1bb0011ee2e5b70af', '66c38cfebcac46649d071058f2eb7fd1', 2, '2020-05-02 16:56:12', '2020-05-02 16:56:10', 0);
INSERT INTO `user_role` VALUES ('7016b158efb649778415c34ed85709fe', '10a258b4defc4f5db4847b09ce883f73', 'e691218ee9d84fbf93939c1a2fa66417', 3, '2020-05-02 17:34:44', '2020-05-02 17:34:44', 0);
INSERT INTO `user_role` VALUES ('a392837744254965a6a4a4ad966e4fac', '553df5a84743447faa2e8a7e19534b88', '1447df502e6b4a5fa2b148be4bf03ec4', 1, '2020-05-02 16:58:36', '2020-05-02 16:58:34', 0);
INSERT INTO `user_role` VALUES ('b1aab6068b5a4382b82ada696842b635', '50e04dd5a7c140e98f107ae4b0d1a8b0', 'e80f275768a24d9e855bf5595a6e1f33', 2, '2020-05-02 16:57:13', '2020-05-02 16:57:11', 0);
INSERT INTO `user_role` VALUES ('e4c87b99f2694eb2b93b83c3eaafcb2a', '8d9c223f83494839b8332dd11c4833d8', '69fcc37f356b4767b1d556ecace9d479', 1, '2020-05-02 16:58:21', '2020-05-02 16:58:24', 0);
INSERT INTO `user_role` VALUES ('fe05c29893804d94ad84764bc6fdcbc3', '50e04dd5a7c140e98f107ae4b0d1a8b0', '66c38cfebcac46649d071058f2eb7fd1', 2, '2020-05-03 14:39:15', '2020-05-03 14:39:15', 0);

SET FOREIGN_KEY_CHECKS = 1;
