/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.17-log : Database - laundry
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`laundry` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `laundry`;

/*Table structure for table `company` */

DROP TABLE IF EXISTS `company`;

CREATE TABLE `company` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'primary key id',
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `active` char(1) DEFAULT '1' COMMENT '0:inactive 1:active',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='user';

/*Data for the table `company` */

/*Table structure for table `garment` */

DROP TABLE IF EXISTS `garment`;

CREATE TABLE `garment` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'primary key id',
  `shortname` varchar(255) DEFAULT NULL,
  `companyid` int(11) unsigned NOT NULL COMMENT 'to which customer this garment belongs',
  `fullname` varchar(255) DEFAULT NULL,
  `active` char(1) DEFAULT '1' COMMENT '0:inactive 1:active',
  PRIMARY KEY (`id`),
  KEY `garment_ibfk_2` (`companyid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='garment';

/*Data for the table `garment` */

/*Table structure for table `laundryorder` */

DROP TABLE IF EXISTS `laundryorder`;

CREATE TABLE `laundryorder` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'primary key id',
  `createddate` date DEFAULT NULL COMMENT 'created time',
  `address` varchar(255) DEFAULT NULL,
  `companyid` int(11) unsigned DEFAULT NULL,
  `presetpickupdate` date DEFAULT NULL COMMENT 'prset pick up date',
  `realpickupdate` date DEFAULT NULL COMMENT 'real pick up date',
  `packingdate` date DEFAULT NULL COMMENT 'packing date by packing person',
  `presetdeliverydate` date DEFAULT NULL,
  `deliverydate` date DEFAULT NULL COMMENT 'delivery date to custmer',
  `status` int(11) DEFAULT NULL COMMENT '0:order created 1:picked up 2:partily packed 3:packed 4:delivered',
  `driverid` int(11) unsigned DEFAULT NULL COMMENT 'pickup driver',
  `packingpersonid` int(11) unsigned DEFAULT NULL COMMENT 'packingperson be responsible for',
  `notes` varchar(255) DEFAULT NULL,
  `statushistory` varchar(128) DEFAULT NULL,
  `deliverydriverid` int(11) unsigned DEFAULT NULL COMMENT 'delivery driver',
  `recurringFlag` int(10) unsigned DEFAULT '0' COMMENT '0: none 1:recurring',
  `active` char(1) DEFAULT '1' COMMENT '0:inactive 1:active',
  PRIMARY KEY (`id`),
  KEY `driverid` (`driverid`),
  KEY `packingpersonid` (`packingpersonid`),
  KEY `companyid` (`companyid`),
  KEY `deliverydriverid` (`deliverydriverid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='order';

/*Data for the table `laundryorder` */

/*Table structure for table `orderitems` */

DROP TABLE IF EXISTS `orderitems`;

CREATE TABLE `orderitems` (
  `orderid` int(11) unsigned NOT NULL,
  `garmentid` int(11) unsigned NOT NULL,
  `pickupnumber` int(10) unsigned DEFAULT NULL,
  `packnumber` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`garmentid`,`orderid`),
  KEY `orderitems_ibfk_1` (`orderid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='garment';

/*Data for the table `orderitems` */

/*Table structure for table `recurringorder` */

DROP TABLE IF EXISTS `recurringorder`;

CREATE TABLE `recurringorder` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'primary key id',
  `companyid` int(11) unsigned NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `pickupdate` date DEFAULT NULL,
  `deliverdate` date DEFAULT NULL,
  `intervaldays` int(11) DEFAULT NULL,
  `enddate` date DEFAULT NULL,
  `active` char(1) DEFAULT '1' COMMENT '0:inactive 1:active',
  PRIMARY KEY (`id`),
  KEY `companyid` (`companyid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='garment';

/*Data for the table `recurringorder` */

/*Table structure for table `resources` */

DROP TABLE IF EXISTS `resources`;

CREATE TABLE `resources` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `resUrl` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL COMMENT '1:menu 2：button',
  `parentId` int(11) DEFAULT NULL COMMENT 'parent resource',
  `sort` int(11) DEFAULT NULL COMMENT 'order',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `resources` */

insert  into `resources`(`id`,`name`,`resUrl`,`type`,`parentId`,`sort`) values (1,'System Setting','/system',0,0,1),(2,'User Control','/usersPage',1,1,2),(3,'Role Control','/rolesPage',1,1,3),(4,'Resource Control','/resourcesPage',1,1,4),(5,'Add User','/users/add',2,2,5),(6,'Delete user','/users/delete',2,2,6),(7,'Add Role','/roles/add',2,3,7),(8,'Delete Role','/roles/delete',2,3,8),(9,'Add Resource','/resources/add',2,4,9),(10,'Delete Resource','/resources/delete',2,4,10),(11,'Allocate Role','/users/saveUserRoles',2,2,11),(13,'Allocate Resource','/roles/saveRoleResources',2,3,12);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `roleDesc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`id`,`roleDesc`) values (1,'admin'),(4,'driver'),(5,'office'),(6,'packing');

/*Table structure for table `role_resources` */

DROP TABLE IF EXISTS `role_resources`;

CREATE TABLE `role_resources` (
  `roleId` int(11) unsigned NOT NULL,
  `resourcesId` int(11) unsigned NOT NULL,
  PRIMARY KEY (`roleId`,`resourcesId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role_resources` */

insert  into `role_resources`(`roleId`,`resourcesId`) values (1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,13),(9,9);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(33) DEFAULT NULL,
  `password` varchar(33) DEFAULT NULL,
  `enable` int(10) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`enable`) values (1,'admin','3ef7164d1f6167cb9f2658c07d3c2f0a',1),(2,'driver_Kaven','12ba2459a77b2c0091d2b0c968ca10c0',1),(3,'office_Ryan','a1bcbe4931ceeba333ea38a2fd6645c2',1),(4,'packing_John','b28d9e6218adebfc8ab3f4bc2f617559',1),(5,'driver_Mike','8504283627b35131763858de51b7210e',1);

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `userId` int(11) unsigned NOT NULL,
  `roleId` int(11) unsigned NOT NULL,
  PRIMARY KEY (`userId`,`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

insert  into `user_role`(`userId`,`roleId`) values (1,1),(2,4),(3,5),(4,6),(5,4),(7,5),(8,5);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
