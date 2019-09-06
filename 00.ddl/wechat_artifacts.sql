/*
 Navicat Premium Data Transfer

 Source Server         : 39.105.22.26
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : 39.105.22.26:3306
 Source Schema         : wechat_artifacts

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 06/09/2019 14:22:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article_info
-- ----------------------------
DROP TABLE IF EXISTS `article_info`;
CREATE TABLE `article_info` (
  `id` int(11) DEFAULT NULL,
  `article_source` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `article_date` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `article_jsonarray` varchar(2550) CHARACTER SET utf8mb4 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article_info
-- ----------------------------
BEGIN;
INSERT INTO `article_info` VALUES (NULL, '程序员小灰', NULL, NULL, '{\"trueUrl\":\"http://mp.weixin.qq.com/s?src=11&timestamp=1566992385&ver=1818&signature=noAvuDFpGXd3OcBisbUxYJhQZvOoAVHYFMPr6HHM4O3zUssq8F3HOjGMn04W9cAXNRbrQd2KkRGUl6GnvTcjc1MK8TUG7IOZ0g5BV7IgAuuAWbU6qfs6GlsWiXPbjTEL&new=1\",\"article\":\"那些月入5000的人,凭什么比你更早买车买房?\"}');
INSERT INTO `article_info` VALUES (NULL, '网络大数据', NULL, NULL, '{\"trueUrl\":\"http://mp.weixin.qq.com/s?src=11&timestamp=1566992415&ver=1818&signature=bQio9nASYAJmz9XmhtIvtcpXtQEi8moH*O8GL5DBHTXvAs7l0bzw9qEWOj6yOsQ0uEuoRiBECBIBpR6VXL2TkxzKAKJfjEOF9q5u5dp2Rxs2uCZTt7puEH0F3YyHgokv&new=1\",\"article\":\"AICC2019公布最新中国人工智能计算力排名:北京超杭州跃居第一\"}');
INSERT INTO `article_info` VALUES (NULL, '51CTO技术栈', NULL, NULL, '{\"trueUrl\":\"http://mp.weixin.qq.com/s?src=11&timestamp=1566992445&ver=1818&signature=hnmYTMXjXCe1S7kzB9PdfIjiuafnjQFlfrzJwII823II*sN5Ev2tA81-Q-JxhWWV50Yj8-rQLGhc8QL*GRWW8khlfXU0YMon8LU8Ny9HRFyLvkKQhlA9jjnESf3NC-4m&new=1\",\"article\":\"拜托!不要再问我Session与Cookie的区别了\"}');
INSERT INTO `article_info` VALUES (NULL, '码农翻身', NULL, NULL, '{\"trueUrl\":\"http://mp.weixin.qq.com/s?src=11&timestamp=1567013924&ver=1818&signature=QN5wP2QErCuC8DvTbzFLsjvdGLskqkHFf-Gim4KCNMwpOfe8h0NJQGVG-vQu*A87VPNExhvW2X4YfQpHsWlt-Y4YjmM2xyDXe-1mSLUwByoUjTOTchZRCIfz2f55g7yq&new=1\",\"article\":\"系统设计经典题:手把手教你搭建一个IM(即时通讯) 系统\"}');
INSERT INTO `article_info` VALUES (NULL, '码农有道', NULL, NULL, '{\"trueUrl\":\"http://mp.weixin.qq.com/s?src=11&timestamp=1567013954&ver=1818&signature=z1GxBx9ZhNq6hlG-j0gpbXONMXrpmT4VhMyOehYQtOsx6kXYTWzxC3SXl-DhJH1Ka-mOMwlT0VJ0Jpv3Gm81mdBWIvT9wuSdX7yEZz5Xev0zdYSwFl2Jd10XqSJO8jsP&new=1\",\"article\":\"邪恶互联网公司图鉴\"}');
COMMIT;

-- ----------------------------
-- Table structure for article_info_v2
-- ----------------------------
DROP TABLE IF EXISTS `article_info_v2`;
CREATE TABLE `article_info_v2` (
  `id` int(11) DEFAULT NULL,
  `article_source` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `abstract` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `trueurl` varchar(2550) CHARACTER SET utf8mb4 DEFAULT NULL,
  `picurl` varchar(2550) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article_info_v2
-- ----------------------------
BEGIN;
INSERT INTO `article_info_v2` VALUES (NULL, 'CSDN', '今日揭秘 | 60+业内技术专家，9大核心技术专题', NULL, 'https://aiprocon.csdn.net/m/topic/ai_procon', 'img/csdn/1.jpg');
INSERT INTO `article_info_v2` VALUES (NULL, 'CSDN', 'Android 10 重磅来袭：支持 5G 与折叠屏、隐私安全全面升级！', NULL, 'https://blog.csdn.net/Blockchain_lemon/article/details/97848341', 'img/csdn/3.jpg');
INSERT INTO `article_info_v2` VALUES (NULL, 'CSDN', '云计算风起云涌，超融合恰逢其时！', NULL, 'https://blog.csdn.net/FL63Zv9Zou86950w/article/details/100165098', 'img/csdn/5.jpg');
INSERT INTO `article_info_v2` VALUES (NULL, 'CSDN', '冠军奖3万元！CSDN×易观算法大赛——PV,UV流量预测开赛啦', NULL, 'https://www.tinymind.cn/competitions/48', 'img/csdn/7.jpg');
INSERT INTO `article_info_v2` VALUES (NULL, 'CSDN', 'Rust 能取代 Python，更好的实现神经网络？', NULL, 'https://blog.csdn.net/csdnnews/article/details/100550182', 'img/csdn/9.jpg');
INSERT INTO `article_info_v2` VALUES (NULL, 'CSDN', '4 大妙招，教你快速搞定复杂的系统编程！', NULL, 'https://blog.csdn.net/csdnnews/article/details/100550186', 'img/csdn/11.jpg');
INSERT INTO `article_info_v2` VALUES (NULL, 'CSDN', '人间真实！一文带你群析互联网人叹气图鉴', NULL, 'https://blog.csdn.net/csdnsevenn/article/details/89666825', 'img/csdn/13.jpg');
INSERT INTO `article_info_v2` VALUES (NULL, 'CSDN', '华为方舟编译器开源！前华为人重磅解读！', NULL, 'https://blog.csdn.net/csdnnews/article/details/100190296', 'img/csdn/15.jpg');
INSERT INTO `article_info_v2` VALUES (NULL, 'CSDN', '70道高频Spring面试题，Java晋升必备', NULL, 'https://blog.csdn.net/GitChat/article/details/96443995', 'img/csdn/17.jpg');
INSERT INTO `article_info_v2` VALUES (NULL, 'CSDN', '程序员副业赚钱的 8 种模式', NULL, 'https://gitbook.cn/gitchat/activity/5cdfe5686a30bd605ba31113?utm_source=jr1906243', 'img/csdn/19.jpg');
INSERT INTO `article_info_v2` VALUES (NULL, 'CSDN', '程序员学习宝典：IT好课尽情选！', NULL, 'https://edu.csdn.net/?utm_source=home', 'img/csdn/21.jpg');
INSERT INTO `article_info_v2` VALUES (NULL, 'CSDN', '2019年程序员需具备什么编程能力？', NULL, 'https://edu.csdn.net/topic/ai30?utm_source=link', 'img/csdn/23.jpg');
INSERT INTO `article_info_v2` VALUES (NULL, 'CSDN', '数据智能之多维度分析系统的选型方法', NULL, 'https://blog.csdn.net/Androilly/article/details/100126691', 'img/csdn/25.jpg');
INSERT INTO `article_info_v2` VALUES (NULL, 'CSDN', 'Qualcomm骁龙™杯3D手游开发大赛火力全开', NULL, 'https://qualcomm.csdn.net/', 'img/csdn/27.jpg');
INSERT INTO `article_info_v2` VALUES (NULL, 'CSDN', '上云，你准备好了吗？', NULL, 'https://ibmuniversity.csdn.net/', 'img/csdn/29.jpg');
INSERT INTO `article_info_v2` VALUES (NULL, 'CSDN', '英特尔开发人员专区', NULL, 'http://intel.csdn.net/', 'img/csdn/31.jpg');
INSERT INTO `article_info_v2` VALUES (NULL, '码农翻身', '为什么你的需求估算老是翻车?看看这个故事就明白了......', '差异化其实就是顾客需要但别人没能满足的需求.千万别简单地理... 每个人看看自己犯错的比率,再看看老巴犯错的比率就明白差别在...', 'http://mp.weixin.qq.com/s?src=11&timestamp=1567735952&ver=1835&signature=sNlmI8BbEZMvoSmQaVG4fZ*ZlyjnRffxh6xYJmXzHtVoBzrvodVYgqzntFn*PCVxXGac3ILOWC3LTXab5wHf9UzSK4ySjj*Shi46Y-3pHkDwsWpAxOI13aJA2phN7HmZ&new=1', 'img/wechat/1567735953212.jpg');
INSERT INTO `article_info_v2` VALUES (NULL, '码农有道', '这几个公众号让你的业余时间变得更有价值', '学术那点事是科研圈优质公众号,值得你的关注.长按二维码识别... 计算机底层等高质量技术文章,让您的碎片化时间最大价值化....', 'http://mp.weixin.qq.com/s?src=11&timestamp=1567735983&ver=1835&signature=EmymAqhjcszPtS8-7Xta5NpJ-5GIHdk81k3OI54*eUl-awdQFTIbCojdMh-8Bp7tNzmMmvR7UzCB9jwuv690VKYOeoOekpaehs2g8DsqdMbK6e-sopt*aP5ljycce712&new=1', 'img/wechat/1567735984508.jpg');
INSERT INTO `article_info_v2` VALUES (NULL, '程序员小灰', '互联网人也敢谈恋爱?', '互联网人的爱情未免也太太太脆弱了吧?01.02.03.04.05.06.07.08.09.10.所以你看,和互联网人谈恋爱一定要慎重考虑.和一个互联网...', 'http://mp.weixin.qq.com/s?src=11&timestamp=1567736017&ver=1835&signature=AlROJTM2tjHSR3vPTaFZkx03dKBM8bAq6O6iAqMfLneah7TmZizU0uImnZnF6QDBY5XApTYGh6YqrlDAZWlR0CFhPGU0HeJbA9zz8ZG0S0JIktm1ovnmdGyKDZwSs-WY&new=1', 'img/wechat/1567736018647.jpg');
INSERT INTO `article_info_v2` VALUES (NULL, '网络大数据', '企业AI化的4个趋势:我们现在何方,又将去何处?', '趋势2:企业使用AI还是会有一定门槛事实上,目前企业完成人工... 现在相互提取或处理的数据类型是没有限制的.但我们必须回答的...', 'http://mp.weixin.qq.com/s?src=11&timestamp=1567736070&ver=1835&signature=iyQhuhSKMuObfw25maRrl-1aKonZzQI9qMwvvn5nIrDQM8jUYXBmVk9wBBZ3re1ZyFZ*ezWbtFRApzybvit9rbtpDOOE7AP*qjQc3rwr3nQ*kIVVxxBw7pmJX0HSWPcA&new=1', 'img/wechat/1567736071178.jpg');
INSERT INTO `article_info_v2` VALUES (NULL, '51CTO技术栈', '打破瓶颈,只要一个选择', '传统银行分散式的 IT 建设思路带来的“竖井式”架构难题,制约着银行未来业务的发展.新时代下,传统银行 IT 架构如何成功转型?...', 'http://mp.weixin.qq.com/s?src=11&timestamp=1567736103&ver=1835&signature=ji08b3lCj8FkqKtrImsAo2K2k8-Ls7uSMs3xs6ud9Y*391dsXPl5KJ*Y-RA8Vh*jfdaGfLG*5L9LFFpM1ghii2j1BwnSfsxum*OJe5KAoX8vMQA20acxIjVSY9iE89E9&new=1', 'img/wechat/1567736103857.jpg');
COMMIT;

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `title` varchar(255) DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  `url` varchar(2550) DEFAULT NULL,
  `collecttime` varchar(255) DEFAULT NULL,
  `picurl` varchar(2550) DEFAULT NULL,
  `abstract` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collection
-- ----------------------------
BEGIN;
INSERT INTO `collection` VALUES ('“ZAO”凉凉!教你用Deepfakes换脸', '51CTO技术栈', 'http://weixin.sogou.com/api/share?timestamp=1567750376&signature=qIbwY*nI6KU9tBso4VCd8lYSesxOYgLcHX5tlbqlMR8N6flDHs4LLcFgRw7FjTAOxHcHHd-97uK8wgq814vf3RrCQK8-vMqkStsjX*8UH79B8JKAMd2VE6UpN-5p3Em0qSUWABp4zeLGevGUb63y3YWhlHrgJJrZ0vMTXEwpDsHmUe6hm622BIH22BIH0uQ9eoGPLSEZj7p*3yhVAmPxZuCO3y33LnPUjA2AWJxegqo=', '1567750376529', 'img/wechat/1567667621009.jpg', '“ 近日,一款名为＂ZAO＂的AI 换脸软件在社交媒体刷屏,火爆... Deepfakes 换脸.如何使用 Deepfakes 换脸?获取 deepfakes 工...');
INSERT INTO `collection` VALUES ('15 个超赞超牛逼的 Linux 工具,提高效率的同时增加乐趣!', '码农有道', 'http://mp.weixin.qq.com/s?src=11&timestamp=1567667525&ver=1833&signature=iTLqrRcJa0ODXqXVtLnEufdZ97SN4v3HWKEmVi4qxOJTcWZdmHlucAbQcGEG74nw6f6D8qB9SVN32K8LQQECcpBo2FwKMnSnkMTCIw6eouwugm1-dQyNEqfs*xx6Uzrc&new=1', '2', 'img/wechat/1567667525858.jpg', 'json.tool.5、shellcheck:shell脚本静态检查工具,能够识别语法错... 回放scriptreplay -t time.txt session.typescript15、multitail:多重 tail...');
INSERT INTO `collection` VALUES ('全球最大同性交友平台的“黑历史”', '码农翻身', 'http://mp.weixin.qq.com/s?src=11&timestamp=1567667494&ver=1833&signature=4EemsQby1*7HVIgyjWBe1UoMjAg0U5ob3O**AltuIpOaUittlp1QGMzgnRbvOW0j-uliDcuo940Ja5cmczWtLabnbovb5Tmrl*vuKNGkoV-uawYSJAJ9NGIgSUphpcu5&new=1', '3', 'img/wechat/1567667494424.jpg', '“全球最大同性交友网站”.而今天,GitHub将很可能会并入一家... 这样的在开源群体中的“黑历史”,不是通过纳德拉最近几年的频...');
INSERT INTO `collection` VALUES ('【只推荐一位】他自学成才,坐拥38w粉丝,技术第一大号!', '程序员小灰', 'http://mp.weixin.qq.com/s?src=11&timestamp=1567667556&ver=1833&signature=cN*V3VAb5rlO2np0vKLplHbYs9MOiOoxbyg0uQwKh4PGhTM4Z9asV-rSVkiBXNJpqLF9*lNDzrOwxzXC81F5-Mk41V0gY7p-Tzk0pUS*04yZnqp*95Sc5*VCEqmMdKnh&new=1', '4', 'img/wechat/1567667556446.jpg', '他选择了Python作为编程工具,开始了自学之旅.积累在读研期间... 说起追热点,杜蕾斯第二,没人敢第一!你的高考过去了这么久还...');
INSERT INTO `collection` VALUES ('2018-2019中国新型智慧城市建设与发展综合影响力报告', '网络大数据', 'http://weixin.sogou.com/api/share?timestamp=1567750534&signature=qIbwY*nI6KU9tBso4VCd8lYSesxOYgLcHX5tlbqlMR8N6flDHs4LLcFgRw7FjTAON02UjQobtE7aUARDBF56HEy0ncXbRTmnvZ5qlMhhYrp55VoO*rYRgPcOYtqHn5kkMqIYD0VoTY3NIWjzsHGj77TsXr4qwdZqEjqlszf24T3Y3pUhFX4r2RqwtUh3PKinDR-zF*0Eo5CiIoJk6hACXz-ohjUGeW-3RPBLt4F0ZOQ=', '1567750534976', 'img/wechat/1567667590356.jpg', '2018-2019中国数字经济和智慧产业综合影响力指数排名第八系列2018-2019年中国新型智慧城市建设与发展综合影响力评估排名及得...');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
