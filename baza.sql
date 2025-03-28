/*
SQLyog Community v13.2.0 (64 bit)
MySQL - 10.4.25-MariaDB : Database - nursery_school
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`nursery_school` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `nursery_school`;

/*Table structure for table `attendance` */

DROP TABLE IF EXISTS `attendance`;

CREATE TABLE `attendance` (
  `optional_program_id` bigint(20) unsigned NOT NULL,
  `child_id` bigint(20) unsigned NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date DEFAULT NULL,
  PRIMARY KEY (`optional_program_id`,`child_id`),
  KEY `childId` (`child_id`),
  CONSTRAINT `attendance_ibfk_1` FOREIGN KEY (`optional_program_id`) REFERENCES `optional_program` (`id`),
  CONSTRAINT `attendance_ibfk_2` FOREIGN KEY (`child_id`) REFERENCES `child` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `attendance` */

insert  into `attendance`(`optional_program_id`,`child_id`,`start_date`,`end_date`) values 
(1,2,'2023-09-01',NULL),
(2,1,'2023-09-01',NULL),
(2,4,'2023-09-01',NULL),
(2,5,'2023-09-01',NULL),
(4,2,'2023-09-01',NULL),
(6,2,'2024-04-25',NULL);

/*Table structure for table `child` */

DROP TABLE IF EXISTS `child`;

CREATE TABLE `child` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `firstname` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `lastname` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `birthday` date NOT NULL,
  `parent_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `child_ibfk_1` (`parent_id`),
  CONSTRAINT `child_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `parent` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `child` */

insert  into `child`(`id`,`firstname`,`lastname`,`birthday`,`parent_id`) values 
(1,'Marko','Petrasinovic','2020-12-13',1),
(2,'Elena','Vojvodic','2018-07-09',2),
(3,'Lana','Petrovic','2019-05-22',3),
(4,'Teodora','Petrovic','2020-07-16',3),
(5,'Luka','Vucetic','2020-06-10',4),
(6,'Jovan','Vucetic','2019-09-09',4),
(7,'Nikola','Jovanovic','1918-01-14',5);

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `firstname` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `lastname` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `adress` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `phone_number` bigint(20) NOT NULL,
  `sss` int(11) NOT NULL,
  `optional_program_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `employee_ibfk_1` (`optional_program_id`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`optional_program_id`) REFERENCES `optional_program` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `employee` */

insert  into `employee`(`id`,`firstname`,`lastname`,`adress`,`phone_number`,`sss`,`optional_program_id`) values 
(1,'Marina','Boskovic','Miliceva 5',381641205813,5,1),
(3,'Marko','Petrovic','Vojvode Stepe 16',381611335908,5,2),
(9,'Ana','Vukasinovic','Ustanicka 23',381622002044,5,3),
(10,'Jelena','Popovic','Marka Prodanovica 12',381642335034,6,4),
(11,'Emilija','Ivkovic','Beogradska 13',381654106089,6,5),
(12,'Djordje','Vasic','Kraljice Marije 33',381695581177,0,6);

/*Table structure for table `optional_program` */

DROP TABLE IF EXISTS `optional_program`;

CREATE TABLE `optional_program` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `age` int(11) NOT NULL,
  `difficulty_level` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `optional_program` */

insert  into `optional_program`(`id`,`name`,`age`,`difficulty_level`) values 
(1,'ples',5,3),
(2,'engleski1',3,1),
(3,'engleski2',4,2),
(4,'engleski3',5,3),
(5,'skolica sporta1',4,2),
(6,'skolica sporta2',5,3);

/*Table structure for table `parent` */

DROP TABLE IF EXISTS `parent`;

CREATE TABLE `parent` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `firstname` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `lastname` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `adress` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `phone_number` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `parent` */

insert  into `parent`(`id`,`firstname`,`lastname`,`adress`,`phone_number`) values 
(1,'Marina','Petrasinovic','Miliceva 5',381656451770),
(2,'Aleksa','Vojvodic','Ustanicka 124',381636322270),
(3,'Marta','Petrovic','Vojislava Ilica 14',381636689761),
(4,'Jovan','Vucetic','Vitezova Karadjordjeve zvezde 65',381636644466),
(5,'Marija','Jovanovic','Matice srpske 65',381696881009);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `firstname` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `lastname` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`firstname`,`lastname`) values 
(1,'ana','ana123','Ana','Lazarevic');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
