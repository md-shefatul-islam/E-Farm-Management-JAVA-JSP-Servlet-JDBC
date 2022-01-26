CREATE DATABASE  IF NOT EXISTS `farmtech` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `farmtech`;
-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: farmtech
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `crop`
--

DROP TABLE IF EXISTS `crop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `crop` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(245) NOT NULL,
  `quantity` varchar(45) NOT NULL,
  `price` varchar(45) NOT NULL,
  `date` date NOT NULL,
  `funame` varchar(145) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crop`
--

LOCK TABLES `crop` WRITE;
/*!40000 ALTER TABLE `crop` DISABLE KEYS */;
INSERT INTO `crop` VALUES (1,'tomato','fresh products ','100','80','2020-10-10','shefat'),(2,'potato','huge number','25','20','2021-05-19','dana'),(3,'paddy','good conditional','260','50','2021-09-14','shefat');
/*!40000 ALTER TABLE `crop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `farmer`
--

DROP TABLE IF EXISTS `farmer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `farmer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uname` varchar(145) NOT NULL,
  `name` varchar(145) NOT NULL,
  `email` varchar(145) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `city` varchar(45) NOT NULL,
  `password` varchar(145) NOT NULL,
  `gender` varchar(45) NOT NULL,
  `dob` date NOT NULL,
  `balance` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `uname_UNIQUE` (`uname`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `farmer`
--

LOCK TABLES `farmer` WRITE;
/*!40000 ALTER TABLE `farmer` DISABLE KEYS */;
INSERT INTO `farmer` VALUES (2,'dana','Dana anjum','dana@abc.com','12334','jessore','123','Female','2001-04-10','10000'),(3,'rahat','Rahat khan','ab@abc.com','123456','magura','123','Female','2020-10-02','15000'),(5,'rajib','rajib khan','ab@abc.com','123456','JASHORE','123','Male','2021-11-14','100'),(6,'rafan','rafan khan','ab@abc.com','123456','JASHORE','123','Male','2021-10-31','100'),(7,'abc','abcdee','ab@abc.com','123456','JASHORE','456','Male','2021-11-15','100'),(9,'adnan','adnan khan','ab@abc.com','123456','JASHORE','123','Male','2021-11-22','100'),(10,'shefat','shefat islam','ab@abc.com','123456','JASHORE','123','Male','2021-10-31','100');
/*!40000 ALTER TABLE `farmer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uname` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `type` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `uname_UNIQUE` (`uname`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'dana','123','farmer'),(2,'rajib','123','farmer'),(3,'ghi','789','seedbanker'),(6,'rafan','123','farmer'),(7,'abc','456','farmer'),(8,'adnan','123','farmer'),(9,'shefat','123','farmer');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `quantity` varchar(45) NOT NULL,
  `price` varchar(45) NOT NULL,
  `date` varchar(200) NOT NULL,
  `suname` varchar(45) NOT NULL,
  `buname` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (2,'potato','5','100','Sun Nov 07 21:03:51 BDT 2021','shefat','dana','accepted','crop'),(3,'potato','10','200','Sun Nov 07 21:21:00 BDT 2021','dana','shefat','pending','seed'),(4,'potato','10','200','Sun Nov 07 21:50:13 BDT 2021','dana','rahat','pending','seed'),(45,'potato','50','1000','Tue Nov 09 03:23:20 BDT 2021','shefat','dana','pending','crop'),(46,'tomato','40','12000','Tue Nov 09 03:23:34 BDT 2021','raju','shefat','accepted','seed'),(65,'potato','7','120','Tue Nov 09 20:18:56 BDT 2021','dana','shefat','pending','crop'),(67,'potato','5','100','Wed Nov 10 20:48:44 BDT 2021','dana','shefat','pending','crop'),(68,'potato','6','100','Wed Nov 10 21:03:58 BDT 2021','dana','shefat','pending','crop');
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
  `id` int NOT NULL AUTO_INCREMENT,
  `question` varchar(245) NOT NULL,
  `answer` varchar(245) DEFAULT NULL,
  `quname` varchar(45) NOT NULL,
  `auname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idquestion_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'Which month is better for cultivating paddy?','Too much tired.....','shefat','shefat'),(2,'what is the best medicine for wheat?','Too much tired.....','dana','shefat');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seed`
--

DROP TABLE IF EXISTS `seed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seed` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(245) NOT NULL,
  `quantity` varchar(45) NOT NULL,
  `price` varchar(45) NOT NULL,
  `date` varchar(45) NOT NULL,
  `suname` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seed`
--

LOCK TABLES `seed` WRITE;
/*!40000 ALTER TABLE `seed` DISABLE KEYS */;
INSERT INTO `seed` VALUES (1,'paddy','a good paddy','30','150','2020-20-10','jahid'),(2,'tomato','large amount of seed','60','300','2019-05-05','raju');
/*!40000 ALTER TABLE `seed` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-27  0:51:52
