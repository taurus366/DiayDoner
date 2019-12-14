-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: remotemysql.com    Database: UkfOir9In3
-- ------------------------------------------------------
-- Server version	8.0.13-4

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admins`
--

DROP TABLE IF EXISTS `admins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admins` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admins`
--

REPLACE  IGNORE INTO `admins` VALUES (1,'test','81dc9bdb52d04dc20036dbd8313ed055');

--
-- Table structure for table `articles`
--

DROP TABLE IF EXISTS `articles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `articles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(75) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` decimal(3,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articles`
--

REPLACE  IGNORE INTO `articles` VALUES (6,'Дюнер-порция',4.00);
REPLACE  IGNORE INTO `articles` VALUES (7,'Джоб с кашкавал',1.00);
REPLACE  IGNORE INTO `articles` VALUES (8,'Джоб с кренвриш',1.00);
REPLACE  IGNORE INTO `articles` VALUES (9,'Джоб с кебабче',1.00);
REPLACE  IGNORE INTO `articles` VALUES (10,'Джоб с кюфте',1.00);
REPLACE  IGNORE INTO `articles` VALUES (11,'Джоб с шунка',2.00);
REPLACE  IGNORE INTO `articles` VALUES (12,'Джоб с шпеков салам',1.00);
REPLACE  IGNORE INTO `articles` VALUES (13,'Джоб с телешки салам',1.00);
REPLACE  IGNORE INTO `articles` VALUES (14,'Пилешко кюфте',1.00);
REPLACE  IGNORE INTO `articles` VALUES (15,'Пилешко кебабче',1.00);
REPLACE  IGNORE INTO `articles` VALUES (16,'Хапки 500гр',4.00);
REPLACE  IGNORE INTO `articles` VALUES (17,'/Безалкохолна напитка/ серино',0.00);
REPLACE  IGNORE INTO `articles` VALUES (18,'Кола /кен/',1.00);
REPLACE  IGNORE INTO `articles` VALUES (19,'Фанта /кен/',1.29);
REPLACE  IGNORE INTO `articles` VALUES (20,'Вода',1.00);
REPLACE  IGNORE INTO `articles` VALUES (21,'Айрян',1.00);
REPLACE  IGNORE INTO `articles` VALUES (23,'нов Айрян',4.10);

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `session_id` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `article_id` int(11) NOT NULL,
  `added_time` datetime NOT NULL,
  `ketchup` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `mayonnaise` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `chili` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `spotted_salt` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

REPLACE  IGNORE INTO `cart` VALUES (98,'-1953463500',5,'2019-12-12 15:38:17','не','не','не','не');
REPLACE  IGNORE INTO `cart` VALUES (103,'1883397174',7,'2019-12-13 16:22:20','не','да','не','не');
REPLACE  IGNORE INTO `cart` VALUES (104,'2098577546',7,'2019-12-13 16:27:15','не','да','не','не');
REPLACE  IGNORE INTO `cart` VALUES (105,'-633264782',7,'2019-12-13 16:43:30','не','не','не','не');
REPLACE  IGNORE INTO `cart` VALUES (106,'2020838633',7,'2019-12-13 16:45:36','не','да','не','не');
REPLACE  IGNORE INTO `cart` VALUES (107,'2098577546',10,'2019-12-13 16:51:12','не','да','не','не');
REPLACE  IGNORE INTO `cart` VALUES (108,'2098577546',7,'2019-12-13 16:53:59','не','да','не','не');
REPLACE  IGNORE INTO `cart` VALUES (109,'556386920',8,'2019-12-13 16:55:22','не','не','не','не');
REPLACE  IGNORE INTO `cart` VALUES (110,'556386920',0,'2019-12-13 17:04:55','не','не','не','не');
REPLACE  IGNORE INTO `cart` VALUES (111,'556386920',0,'2019-12-13 17:04:57','не','не','не','не');
REPLACE  IGNORE INTO `cart` VALUES (112,'556386920',0,'2019-12-13 17:04:58','не','не','не','не');
REPLACE  IGNORE INTO `cart` VALUES (113,'556386920',0,'2019-12-13 17:04:59','не','не','не','не');
REPLACE  IGNORE INTO `cart` VALUES (114,'556386920',0,'2019-12-13 17:05:00','не','не','не','не');
REPLACE  IGNORE INTO `cart` VALUES (115,'556386920',0,'2019-12-13 17:05:01','не','не','не','не');
REPLACE  IGNORE INTO `cart` VALUES (116,'556386920',0,'2019-12-13 17:05:02','не','не','не','не');
REPLACE  IGNORE INTO `cart` VALUES (117,'2020838633',0,'2019-12-13 17:05:57','не','не','не','не');
REPLACE  IGNORE INTO `cart` VALUES (118,'552793512',10,'2019-12-13 19:00:55','не','не','не','да');

--
-- Table structure for table `orders_address`
--

DROP TABLE IF EXISTS `orders_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `session_id` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `firstname` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `secondname` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `thirdname` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `city` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `ordered_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders_address`
--

REPLACE  IGNORE INTO `orders_address` VALUES (7,'-574074044','ALI','ALI','ФАМИЛИЯ','seventeen number nine','0894396766','Медовец','2019-12-12 14:45:38');
REPLACE  IGNORE INTO `orders_address` VALUES (8,'-2062470183','ALI','ZINAL','asd','seventeen number nine','0894396766','Медовец','2019-12-13 16:21:59');

--
-- Table structure for table `orders_article`
--

DROP TABLE IF EXISTS `orders_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `article_id` int(11) NOT NULL,
  `ketchup` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `mayonnaise` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `chili` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `spotted_salt` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders_article`
--

REPLACE  IGNORE INTO `orders_article` VALUES (9,7,5,'не','да','не','не');
REPLACE  IGNORE INTO `orders_article` VALUES (10,7,9,'не','да','не','не');
REPLACE  IGNORE INTO `orders_article` VALUES (11,8,21,'не','не','не','не');
REPLACE  IGNORE INTO `orders_article` VALUES (12,8,6,'не','да','не','не');
REPLACE  IGNORE INTO `orders_article` VALUES (13,8,16,'да','не','не','да');

--
-- Table structure for table `sessions`
--

DROP TABLE IF EXISTS `sessions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sessions` (
  `int` int(11) NOT NULL AUTO_INCREMENT,
  `session` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `created_date` datetime NOT NULL,
  `last_activity_date` datetime NOT NULL,
  PRIMARY KEY (`int`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sessions`
--

REPLACE  IGNORE INTO `sessions` VALUES (53,'-8340613','2019-12-05 10:06:56','2019-12-05 10:06:56');
REPLACE  IGNORE INTO `sessions` VALUES (54,'-1025763089','2019-12-05 11:38:59','2019-12-05 11:38:59');
REPLACE  IGNORE INTO `sessions` VALUES (60,'-1953463500','2019-12-12 15:38:16','2019-12-12 15:38:16');
REPLACE  IGNORE INTO `sessions` VALUES (61,'-612086433','2019-12-13 10:39:02','2019-12-13 10:39:02');
REPLACE  IGNORE INTO `sessions` VALUES (62,'-611665632','2019-12-13 10:41:57','2019-12-13 10:41:57');
REPLACE  IGNORE INTO `sessions` VALUES (63,'-559121085','2019-12-13 11:12:52','2019-12-13 11:12:52');
REPLACE  IGNORE INTO `sessions` VALUES (64,'-633264782','2019-12-13 11:43:19','2019-12-13 11:43:19');
REPLACE  IGNORE INTO `sessions` VALUES (66,'-1924635982','2019-12-13 11:52:04','2019-12-13 11:52:04');
REPLACE  IGNORE INTO `sessions` VALUES (67,'-1926251077','2019-12-13 13:41:09','2019-12-13 13:41:09');
REPLACE  IGNORE INTO `sessions` VALUES (68,'1917919575','2019-12-13 16:06:51','2019-12-13 16:06:51');
REPLACE  IGNORE INTO `sessions` VALUES (69,'1883397174','2019-12-13 16:22:20','2019-12-13 16:22:20');
REPLACE  IGNORE INTO `sessions` VALUES (70,'2098577546','2019-12-13 16:27:15','2019-12-13 16:27:15');
REPLACE  IGNORE INTO `sessions` VALUES (71,'2020838633','2019-12-13 16:45:36','2019-12-13 16:45:36');
REPLACE  IGNORE INTO `sessions` VALUES (72,'556386920','2019-12-13 16:55:21','2019-12-13 16:55:21');
REPLACE  IGNORE INTO `sessions` VALUES (73,'552793512','2019-12-13 19:00:55','2019-12-13 19:00:55');
REPLACE  IGNORE INTO `sessions` VALUES (74,'1882616956','2019-12-14 17:12:58','2019-12-14 17:12:58');
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-14 19:21:44
