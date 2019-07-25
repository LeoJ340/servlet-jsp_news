/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 8.0.16 : Database - news
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`news` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `news`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(10) NOT NULL,
  `password` varchar(24) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`id`,`username`,`password`) values (1,'Leo','340');

/*Table structure for table `news` */

DROP TABLE IF EXISTS `news`;

CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cate_id` int(11) NOT NULL,
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time` datetime NOT NULL,
  `author` varchar(15) NOT NULL,
  `content` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `news` */

insert  into `news`(`id`,`cate_id`,`title`,`time`,`author`,`content`) values (2,1,'Java零基础个人学习路线总结','2019-07-23 00:00:00','Leo','<h2>家具厂经多次改建吧</h2><p><strong>擦伤口奥克看到v弄看 vdks</strong></p><p>擦看<i>擦看</i></p>'),(3,2,'Node.js 12.7.0 发布，服务器端的 JavaScript 运行环境','2019-07-25 00:00:00','Leo','<p>Node.js 12.7.0 已经发布，Node.js&nbsp;是一个基于 Chrome V8 引擎的 JavaScript 运行环境。更新内容如下：</p><h3><strong>deps：</strong></h3><ul><li>nghttp2&nbsp;升级到&nbsp;1.39.1</li><li>npm 升级到&nbsp;6.10.0</li></ul><h3><strong>esm：</strong></h3><ul><li>实现 pkg-exports 方案。可以将一个新的&nbsp;\"exports\"&nbsp;字段添加到模块的&nbsp;package.json&nbsp;文件中，来提供自定义子路径别名&nbsp;<a href=\"http://github.com/jkrems/proposal-pkg-exports/\">&nbsp;#proposal-pkg-exports</a></li></ul><h3><strong>http</strong>:&nbsp;</h3><ul><li>新增&nbsp;response.writableFinished</li><li>在&nbsp;http.ClientRequest\"information\"&nbsp;事件中公开&nbsp;headers,&nbsp;rawHeaders&nbsp;和其他字段</li></ul><h3><strong>inspector</strong>:&nbsp;</h3><ul><li>新增&nbsp;inspector.waitForDebugger()</li></ul><h3><strong>policy</strong>:&nbsp;</h3><ul><li>添加&nbsp;--policy-integrity=sri&nbsp;CLI&nbsp; 选项，以减少策略篡改。如果指定了策略完整性，但策略没有此完整性，则 Node.js 将在运行任何代码之前出错</li></ul><h3><strong>readline,tty</strong>:&nbsp;</h3><ul><li>公开来自编写字符的各种方法的流 API</li></ul><h3><strong>src</strong>:&nbsp;</h3><ul><li>使用 cgroup 获得内存限制。这改进了为 Node.js 进程设置内存上限的方式。在此之前，使用物理内存大小来估计所需的 V8 堆大小。此更改增加了获得 Linux cgroup 设置的内存限制的能力，<a href=\"https://docs.docker.com/config/containers/resource_constraints/\">docker 容器使用该限制来设置资源约束</a></li></ul>');

/*Table structure for table `news_cate` */

DROP TABLE IF EXISTS `news_cate`;

CREATE TABLE `news_cate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(12) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `news_cate` */

insert  into `news_cate`(`id`,`name`) values (1,'国内'),(2,'国际'),(3,'互联网'),(4,'娱乐'),(5,'科技');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(10) NOT NULL,
  `password` varchar(24) NOT NULL,
  `birthday` date NOT NULL,
  `email` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tel_number` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`birthday`,`email`,`tel_number`) values (1,'张三','123','2019-07-17','1015668003@qq.com','110'),(2,'李四','456','2019-07-19','email@qq.com','111'),(3,'王五','555','2019-07-20','555@qq.com','112');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
