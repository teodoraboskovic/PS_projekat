/*
SQLyog Community v13.2.0 (64 bit)
MySQL - 10.4.32-MariaDB : Database - nursery_school
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
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  `birthday` date NOT NULL,
  `parent_id` bigint(20) unsigned NOT NULL,
  `jmbg` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `jmbg` (`jmbg`),
  KEY `child_ibfk_1` (`parent_id`),
  CONSTRAINT `child_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `parent` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `child` */

insert  into `child`(`id`,`firstname`,`lastname`,`birthday`,`parent_id`,`jmbg`) values 
(1,'Marko','Petrasinovic','2020-12-13',1,6666666666666),
(2,'Elena','Vojvodic','2018-07-09',2,7777777777777),
(3,'Lana','Petrovic','2019-05-22',3,8888888888888),
(4,'Teodora','Petrovic','2020-07-16',3,9999999999999),
(5,'Luka','Vucetic','2020-06-10',4,1010101010101),
(6,'Jovan','Vucetic','2019-09-09',4,1212121212121),
(7,'Nikola','Jovanovic','2018-01-14',5,1313131313131);

/*Table structure for table `employer` */

DROP TABLE IF EXISTS `employer`;

CREATE TABLE `employer` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  `adress` varchar(40) NOT NULL,
  `phone_number` bigint(20) NOT NULL,
  `sss` varchar(11) NOT NULL,
  `optional_program_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `employee_ibfk_1` (`optional_program_id`),
  CONSTRAINT `employer_ibfk_1` FOREIGN KEY (`optional_program_id`) REFERENCES `optional_program` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `employer` */

insert  into `employer`(`id`,`firstname`,`lastname`,`adress`,`phone_number`,`sss`,`optional_program_id`) values 
(1,'Marina','Boskovic','Miliceva 5',381641205813,'V',1),
(3,'Marko','Petrovic','Vojvode Stepe 16',381611335908,'V',2),
(9,'Ana','Vukasinovic','Ustanicka 23',381622002044,'V',3),
(10,'Jelena','Popovic','Marka Prodanovica 12',381642335034,'VI',4),
(11,'Emilija','Ivkovic','Beogradska 13',381654106089,'VI',5),
(12,'Djordje','Vasic','Kraljice Marije 33',381695581177,'VI',6);

/*Table structure for table `optional_program` */

DROP TABLE IF EXISTS `optional_program`;

CREATE TABLE `optional_program` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `age` varchar(4) NOT NULL,
  `difficulty_level` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `optional_program` */

insert  into `optional_program`(`id`,`name`,`age`,`difficulty_level`) values 
(1,'ples','4-5',3),
(2,'engleski1','2-3',1),
(3,'engleski2','3-4',2),
(4,'engleski3','4-5',3),
(5,'skolica sporta1','3-4',2),
(6,'skolica sporta2','4-5',3);

/*Table structure for table `parent` */

DROP TABLE IF EXISTS `parent`;

CREATE TABLE `parent` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  `adress` varchar(40) NOT NULL,
  `phone_number` bigint(20) NOT NULL,
  `jmbg` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `jmbg` (`jmbg`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `parent` */

insert  into `parent`(`id`,`firstname`,`lastname`,`adress`,`phone_number`,`jmbg`) values 
(1,'Marina','Petrasinovic','Miliceva 5',381656451770,1111111111111),
(2,'Aleksa','Vojvodic','Ustanicka 124',381636322270,2222222222222),
(3,'Marta','Petrovic','Vojislava Ilica 14',381636689761,3333333333333),
(4,'Jovan','Vucetic','Vitezova Karadjordjeve zvezde 65',381636644466,4444444444444),
(5,'Marija','Jovanovic','Matice srpske 65',381696881009,5555555555555);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `employer_id` bigint(20) unsigned NOT NULL,
  `user_status` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `employer_id` (`employer_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`employer_id`) REFERENCES `employer` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`employer_id`,`user_status`) values 
(1,'ana','ana123',9,'ACTIVE'),
(2,'marina','marina123',1,'NOT_ACTIVE');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
