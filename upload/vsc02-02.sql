-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: vschool
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `addmission`
--

DROP TABLE IF EXISTS `addmission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `addmission` (
  `addmission_id` int NOT NULL AUTO_INCREMENT,
  `class_id` int NOT NULL,
  `addmission_start_time` datetime NOT NULL,
  `addmission_end_time` datetime NOT NULL,
  PRIMARY KEY (`addmission_id`),
  KEY `fk_crid6_idx` (`class_id`),
  CONSTRAINT `fk_crid6` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addmission`
--

LOCK TABLES `addmission` WRITE;
/*!40000 ALTER TABLE `addmission` DISABLE KEYS */;
/*!40000 ALTER TABLE `addmission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blog_category`
--

DROP TABLE IF EXISTS `blog_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blog_category` (
  `blog_cat_id` int NOT NULL AUTO_INCREMENT,
  `blog_cat_name` varchar(45) NOT NULL,
  PRIMARY KEY (`blog_cat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog_category`
--

LOCK TABLES `blog_category` WRITE;
/*!40000 ALTER TABLE `blog_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `blog_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blogs`
--

DROP TABLE IF EXISTS `blogs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blogs` (
  `blog_id` int NOT NULL AUTO_INCREMENT,
  `blog_name` text NOT NULL,
  `blog_upload_date` datetime NOT NULL,
  `instructor_id` int NOT NULL,
  `blog_cat_id` int NOT NULL,
  PRIMARY KEY (`blog_id`),
  KEY `fk_iid3_idx` (`instructor_id`),
  KEY `fk_bcid_idx` (`blog_cat_id`),
  CONSTRAINT `fk_bcid` FOREIGN KEY (`blog_cat_id`) REFERENCES `blog_category` (`blog_cat_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_iid3` FOREIGN KEY (`instructor_id`) REFERENCES `instructor` (`instructor_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blogs`
--

LOCK TABLES `blogs` WRITE;
/*!40000 ALTER TABLE `blogs` DISABLE KEYS */;
/*!40000 ALTER TABLE `blogs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class` (
  `class_id` int NOT NULL AUTO_INCREMENT,
  `class_name` varchar(45) DEFAULT NULL,
  `class_time` varchar(45) DEFAULT NULL,
  `class_cat_id` int DEFAULT NULL,
  `instructor_id` int DEFAULT NULL,
  `class_fee` int DEFAULT NULL,
  `class_fee_discount` int DEFAULT NULL,
  PRIMARY KEY (`class_id`),
  KEY `fk_crcid_idx` (`class_cat_id`),
  KEY `fk_iid2_idx` (`instructor_id`),
  CONSTRAINT `fk_crcid` FOREIGN KEY (`class_cat_id`) REFERENCES `class_category` (`class_cat_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_iid2` FOREIGN KEY (`instructor_id`) REFERENCES `instructor` (`instructor_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_category`
--

DROP TABLE IF EXISTS `class_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class_category` (
  `class_cat_id` int NOT NULL AUTO_INCREMENT,
  `class_cat_name` varchar(45) NOT NULL,
  PRIMARY KEY (`class_cat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_category`
--

LOCK TABLES `class_category` WRITE;
/*!40000 ALTER TABLE `class_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `class_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact_form`
--

DROP TABLE IF EXISTS `contact_form`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contact_form` (
  `contact_id` int NOT NULL AUTO_INCREMENT,
  `contact_name` varchar(45) NOT NULL,
  `contact_email` varchar(45) NOT NULL,
  `contact_phone` varchar(45) DEFAULT NULL,
  `contact_subject` varchar(45) NOT NULL,
  `contact_message` longtext NOT NULL,
  PRIMARY KEY (`contact_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact_form`
--

LOCK TABLES `contact_form` WRITE;
/*!40000 ALTER TABLE `contact_form` DISABLE KEYS */;
/*!40000 ALTER TABLE `contact_form` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_cart`
--

DROP TABLE IF EXISTS `course_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_cart` (
  `cart_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  PRIMARY KEY (`cart_id`),
  KEY `fk_uid2_idx` (`user_id`),
  CONSTRAINT `fk_uid2` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_cart`
--

LOCK TABLES `course_cart` WRITE;
/*!40000 ALTER TABLE `course_cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `course_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_category`
--

DROP TABLE IF EXISTS `course_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_category` (
  `course_cat_id` int NOT NULL AUTO_INCREMENT,
  `course_cat_name` varchar(45) NOT NULL,
  PRIMARY KEY (`course_cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_category`
--

LOCK TABLES `course_category` WRITE;
/*!40000 ALTER TABLE `course_category` DISABLE KEYS */;
INSERT INTO `course_category` VALUES (41,'JAVA'),(42,'PYTHON'),(43,'C#'),(44,'JAVASCRIPT');
/*!40000 ALTER TABLE `course_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_file`
--

DROP TABLE IF EXISTS `course_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_file` (
  `course_file_id` int NOT NULL AUTO_INCREMENT,
  `course_pic` text,
  `course_pdf` text,
  `course_video` text,
  `course_id` int DEFAULT NULL,
  PRIMARY KEY (`course_file_id`),
  KEY `fk_cfid_idx` (`course_id`),
  CONSTRAINT `fk_cfid` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_file`
--

LOCK TABLES `course_file` WRITE;
/*!40000 ALTER TABLE `course_file` DISABLE KEYS */;
/*!40000 ALTER TABLE `course_file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `courses` (
  `course_id` int NOT NULL AUTO_INCREMENT,
  `course_name` text NOT NULL,
  `course_upload_date` varchar(45) NOT NULL,
  `course_duration` varchar(45) NOT NULL,
  `course_article` varchar(45) NOT NULL,
  `course_resource` varchar(45) NOT NULL,
  `course_access` varchar(45) NOT NULL,
  `course_description` longtext NOT NULL,
  `course_curriculum` longtext NOT NULL,
  `course_cat_id` int NOT NULL,
  `instructor_id` int NOT NULL,
  `course_price` int DEFAULT NULL,
  `course_discount` int DEFAULT NULL,
  PRIMARY KEY (`course_id`),
  KEY `fk_ccid_idx` (`course_cat_id`),
  KEY `fk_iid_idx` (`instructor_id`),
  CONSTRAINT `fk_ccid` FOREIGN KEY (`course_cat_id`) REFERENCES `course_category` (`course_cat_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_iid` FOREIGN KEY (`instructor_id`) REFERENCES `instructor` (`instructor_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (45);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructor`
--

DROP TABLE IF EXISTS `instructor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instructor` (
  `instructor_id` int NOT NULL,
  `instructor_name` varchar(45) DEFAULT NULL,
  `instructor_username` varchar(45) DEFAULT NULL,
  `instructor_password` varchar(45) DEFAULT NULL,
  `instructor_email` varchar(45) DEFAULT NULL,
  `instructor_phone` varchar(45) DEFAULT NULL,
  `instructor_nid` varchar(45) DEFAULT NULL,
  `instructor_designation` varchar(45) DEFAULT NULL,
  `instructor_workplace` text,
  PRIMARY KEY (`instructor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructor`
--

LOCK TABLES `instructor` WRITE;
/*!40000 ALTER TABLE `instructor` DISABLE KEYS */;
/*!40000 ALTER TABLE `instructor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructor_payment`
--

DROP TABLE IF EXISTS `instructor_payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instructor_payment` (
  `instructor_pay_id` int NOT NULL AUTO_INCREMENT,
  `instructor_id` int NOT NULL,
  `instructor_pay` int NOT NULL,
  `instructor_pay_charge` int NOT NULL,
  `class_id` int DEFAULT NULL,
  `course_id` int DEFAULT NULL,
  PRIMARY KEY (`instructor_pay_id`),
  KEY `fk_iid4_idx` (`instructor_id`),
  KEY `fk_crid4_idx` (`class_id`),
  KEY `fk_cid4_idx` (`course_id`),
  CONSTRAINT `fk_cid4` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_crid4` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_iid4` FOREIGN KEY (`instructor_id`) REFERENCES `instructor` (`instructor_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructor_payment`
--

LOCK TABLES `instructor_payment` WRITE;
/*!40000 ALTER TABLE `instructor_payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `instructor_payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice` (
  `invoice_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `class_price_id` int DEFAULT NULL,
  `course_price_id` int DEFAULT NULL,
  `invoice_time` datetime NOT NULL,
  `payment_type` varchar(45) NOT NULL,
  PRIMARY KEY (`invoice_id`),
  KEY `fk_uid_idx` (`user_id`),
  CONSTRAINT `fk_uid` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lessons`
--

DROP TABLE IF EXISTS `lessons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lessons` (
  `lesson_id` int NOT NULL AUTO_INCREMENT,
  `lesson_name` text NOT NULL,
  `class_id` int NOT NULL,
  PRIMARY KEY (`lesson_id`),
  KEY `fk_crid2_idx` (`class_id`),
  CONSTRAINT `fk_crid2` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lessons`
--

LOCK TABLES `lessons` WRITE;
/*!40000 ALTER TABLE `lessons` DISABLE KEYS */;
/*!40000 ALTER TABLE `lessons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `model`
--

DROP TABLE IF EXISTS `model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `model` (
  `student_id` bigint NOT NULL,
  `student_email` varchar(255) DEFAULT NULL,
  `student_marks` varchar(10) NOT NULL,
  `student_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `model`
--

LOCK TABLES `model` WRITE;
/*!40000 ALTER TABLE `model` DISABLE KEYS */;
INSERT INTO `model` VALUES (1,'mohaiminul@gmail.com','45','Mohaiminul'),(16,'dccd','dcddf','sdfd'),(17,'dccd','dcddf','sdfd'),(18,'dccd','dcddf','sdfd');
/*!40000 ALTER TABLE `model` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `total_class_sale`
--

DROP TABLE IF EXISTS `total_class_sale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `total_class_sale` (
  `total_class_sale_id` int NOT NULL AUTO_INCREMENT,
  `class_id` int NOT NULL,
  `total_class_sale_user` int NOT NULL,
  `total_class_sale` int NOT NULL,
  PRIMARY KEY (`total_class_sale_id`),
  KEY `fk_crid5_idx` (`class_id`),
  CONSTRAINT `fk_crid5` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `total_class_sale`
--

LOCK TABLES `total_class_sale` WRITE;
/*!40000 ALTER TABLE `total_class_sale` DISABLE KEYS */;
/*!40000 ALTER TABLE `total_class_sale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `total_course_sale`
--

DROP TABLE IF EXISTS `total_course_sale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `total_course_sale` (
  `total_course_sale_id` int NOT NULL AUTO_INCREMENT,
  `course_id` int NOT NULL,
  `total_course_sale_user` int NOT NULL,
  `total_course_sale` int NOT NULL,
  PRIMARY KEY (`total_course_sale_id`),
  KEY `fk_cid4_idx` (`course_id`),
  KEY `fk_cid5_idx` (`course_id`),
  CONSTRAINT `fk_cid5` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `total_course_sale`
--

LOCK TABLES `total_course_sale` WRITE;
/*!40000 ALTER TABLE `total_course_sale` DISABLE KEYS */;
/*!40000 ALTER TABLE `total_course_sale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) NOT NULL,
  `user_email` varchar(45) NOT NULL,
  `user_username` varchar(45) NOT NULL,
  `user_password` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_username_UNIQUE` (`user_username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-02  2:25:57
