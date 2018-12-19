-- MySQL dump 10.13  Distrib 5.7.24, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: EggChecker
-- ------------------------------------------------------
-- Server version	5.7.24-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Eggs`
--

DROP TABLE IF EXISTS `Eggs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Eggs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(20) NOT NULL,
  `userId` int(11) NOT NULL,
  `collectedDate` varchar(15) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Eggs_User_id_fk` (`userId`),
  CONSTRAINT `Eggs_User_id_fk` FOREIGN KEY (`userId`) REFERENCES `User` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=171 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Eggs`
--

LOCK TABLES `Eggs` WRITE;
/*!40000 ALTER TABLE `Eggs` DISABLE KEYS */;
INSERT INTO `Eggs` VALUES (84,'chicken',44,'2018-12-14','ertyerty'),(85,'chicken',44,'2018-12-14',NULL),(86,'chicken',44,'2018-12-14',NULL),(87,'chicken',44,'2018-12-14',NULL),(88,'chicken',44,'2018-12-14',NULL),(89,'chicken',44,'2018-12-14',NULL),(90,'chicken',44,'2018-12-14',NULL),(91,'chicken',44,'2018-12-14',NULL),(92,'chicken',44,'2018-12-14',NULL),(93,'chicken',44,'2018-12-14',NULL),(94,'chicken',44,'2018-12-14',NULL),(95,'chicken',44,'2018-12-14',NULL),(96,'chicken',44,'2018-12-14',NULL),(97,'chicken',44,'2018-12-14',NULL),(98,'chicken',44,'2018-12-14',NULL),(99,'chicken',44,'2018-12-14',NULL),(100,'chicken',44,'2018-12-14',NULL),(101,'chicken',44,'2018-12-14',NULL),(102,'chicken',44,'2018-12-14',NULL),(103,'chicken',44,'2018-12-14',NULL),(104,'chicken',44,'2018-12-14',NULL),(105,'chicken',44,'2018-12-14',NULL),(106,'chicken',44,'2018-12-14',NULL),(107,'chicken',44,'2018-12-14',NULL),(108,'chicken',44,'2018-12-14',NULL),(109,'chicken',44,'2018-12-14',NULL),(110,'chicken',44,'2018-12-14',NULL),(111,'chicken',44,'2018-12-14',NULL),(112,'chicken',44,'2018-12-14',NULL),(113,'chicken',44,'2018-12-14',NULL),(114,'chicken',44,'2018-12-14',NULL),(115,'chicken',44,'2018-12-14',NULL),(116,'chicken',44,'2018-12-14',NULL),(117,'chicken',44,'2018-12-14',NULL),(118,'chicken',44,'2018-12-14',NULL),(119,'chicken',44,'2018-12-14',NULL),(120,'chicken',44,'2018-12-14',NULL),(121,'chicken',44,'2018-12-14',NULL),(122,'chicken',44,'2018-12-14',NULL),(123,'chicken',44,'2018-12-14',NULL),(124,'chicken',44,'2018-12-14',NULL),(125,'chicken',44,'2018-12-14',NULL),(126,'chicken',44,'2018-12-14',NULL),(127,'chicken',44,'2018-12-14',NULL),(128,'chicken',44,'2018-12-14',NULL),(129,'chicken',44,'2018-12-14',NULL),(130,'chicken',44,'2018-12-14',NULL),(131,'chicken',44,'2018-12-14',NULL),(132,'chicken',44,'2018-12-14',NULL),(133,'chicken',44,'2018-12-14',NULL),(134,'chicken',44,'2018-12-14',NULL),(135,'chicken',44,'2018-12-14',NULL),(136,'chicken',44,'2018-12-14',NULL),(141,'chicken',44,'2018-12-17','The weather today is aclear sky with the Temperature in Fahrenheit 22.0'),(149,'chicken',44,'2018-12-17','The weather today is aclear sky with the Temperature in Fahrenheit 22.0'),(150,'chicken',44,'2018-12-17','The weather today is aclear sky with the Temperature in Fahrenheit 22.0'),(151,'chicken',44,'2018-12-17','The weather today is aclear sky with the Temperature in Fahrenheit 22.0'),(152,'chicken',44,'2018-12-17','The weather today is aclear sky with the Temperature in Fahrenheit 22.0'),(153,'chicken',44,'2018-12-17','The weather today is aclear sky with the Temperature in Fahrenheit 22.0'),(154,'chicken',44,'2018-12-17','The weather today is aclear sky with the Temperature in Fahrenheit 24.0'),(155,'duck',44,'2018-12-17','The weather today is aclear sky with the Temperature in Fahrenheit 24.0'),(156,'chicken',44,'2018-12-18','The weather today is afew clouds with the Temperature in Fahrenheit 32.0'),(157,'chicken',44,'2018-12-18','The weather today is afew clouds with the Temperature in Fahrenheit 32.0'),(158,'chicken',44,'2018-12-18','The weather today is afew clouds with the Temperature in Fahrenheit 34.0'),(159,'chicken',44,'2018-12-18','The weather today is afew clouds with the Temperature in Fahrenheit 33.0'),(160,'duck',44,'2018-12-18','The weather today is afew clouds with the Temperature in Fahrenheit 33.0'),(161,'chicken',44,'2018-12-18','The weather today is afew clouds with the Temperature in Fahrenheit 33.0'),(162,'chicken',44,'2018-12-18','The weather today is afew clouds with the Temperature in Fahrenheit 33.0'),(163,'chicken',44,'2018-12-18','The weather today is afew clouds with the Temperature in Fahrenheit 33.0'),(164,'chicken',44,'2018-12-18','The weather today is afew clouds with the Temperature in Fahrenheit 33.0'),(168,'chicken',44,'2018-12-18','The weathfew clouds with the Temperature in Fahrenheit 33.0'),(169,'chicken',44,'2018-12-18','The weather today is few clouds with the Temperature in Fahrenheit 33.0'),(170,'chicken',44,'2018-12-18','The weather today is few clouds with the Temperature in Fahrenheit 33.0');
/*!40000 ALTER TABLE `Eggs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Role`
--

DROP TABLE IF EXISTS `Role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Role` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `userName` varchar(255) NOT NULL,
  PRIMARY KEY (`roleId`),
  UNIQUE KEY `userName_Unique` (`userName`),
  CONSTRAINT `fkroleuser` FOREIGN KEY (`userName`) REFERENCES `User` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Role`
--

LOCK TABLES `Role` WRITE;
/*!40000 ALTER TABLE `Role` DISABLE KEYS */;
INSERT INTO `Role` VALUES (1,'admin','admin'),(2,'user','john'),(12,'user','zip');
/*!40000 ALTER TABLE `Role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) NOT NULL,
  `userPass` varchar(255) NOT NULL,
  `zipId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `User_id_uindex` (`id`),
  UNIQUE KEY `User_userName_uindex` (`userName`),
  KEY `User_zipcodeWeather_id_fk` (`zipId`),
  CONSTRAINT `User_zipcodeWeather_id_fk` FOREIGN KEY (`zipId`) REFERENCES `zipCodeWeather` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (2,'admin','admin',1),(44,'john','john',1),(53,'zip','z',1);
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zipCodeWeather`
--

DROP TABLE IF EXISTS `zipCodeWeather`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zipCodeWeather` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `weather` varchar(255) NOT NULL,
  `zip` int(11) DEFAULT NULL,
  `timeStamp` varchar(255) DEFAULT NULL,
  `tempInKelvin` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `zipcodeWeather_Id_uindex` (`id`),
  UNIQUE KEY `zipcodeWeather_Zip_uindex` (`zip`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zipCodeWeather`
--

LOCK TABLES `zipCodeWeather` WRITE;
/*!40000 ALTER TABLE `zipCodeWeather` DISABLE KEYS */;
INSERT INTO `zipCodeWeather` VALUES (1,'clear sky',53575,'Sat Dec 15 23:54:17 CST 2018',267.57);
/*!40000 ALTER TABLE `zipCodeWeather` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-19 12:56:29
