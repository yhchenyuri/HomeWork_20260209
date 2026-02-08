-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: localhost    Database: homework
-- ------------------------------------------------------
-- Server version	8.0.44

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
-- Table structure for table `productorder`
--

DROP TABLE IF EXISTS `productorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productorder` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_no` varchar(45) DEFAULT NULL,
  `product_no` varchar(45) DEFAULT NULL,
  `order_date` varchar(45) DEFAULT NULL,
  `product_item1` int DEFAULT NULL,
  `product_item2` int DEFAULT NULL,
  `product_item3` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productorder`
--

LOCK TABLES `productorder` WRITE;
/*!40000 ALTER TABLE `productorder` DISABLE KEYS */;
INSERT INTO `productorder` VALUES (1,'',NULL,NULL,1,1,1),(2,NULL,NULL,NULL,1,1,1),(3,NULL,NULL,NULL,2,2,2),(4,NULL,'3',NULL,2,2,2);
/*!40000 ALTER TABLE `productorder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productpage`
--

DROP TABLE IF EXISTS `productpage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productpage` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `ProductName` varchar(45) DEFAULT NULL,
  `Price` int DEFAULT NULL,
  `Amount` int DEFAULT NULL,
  `Content` varchar(45) DEFAULT NULL,
  `product_no` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productpage`
--

LOCK TABLES `productpage` WRITE;
/*!40000 ALTER TABLE `productpage` DISABLE KEYS */;
INSERT INTO `productpage` VALUES (1,'stand',300,1,'new',''),(3,'lip',100,1,'new',''),(23,'earphone',1000,1,'new',''),(24,'sticker',100,1,'new',''),(25,'pencil',10,1,'old',''),(26,'notebook',10000,1,'old',''),(27,'cup',100,1,'old',''),(28,'Adaptor',100,1,'old',''),(29,'toothpaste',20,1,'new',NULL),(30,'fan',100,1,'old',NULL),(31,'pen',5,1,'',NULL),(32,'Lotion',500,1,'很新',NULL),(33,'Lotion',500,1,'很新',NULL);
/*!40000 ALTER TABLE `productpage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `register`
--

DROP TABLE IF EXISTS `register`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `register` (
  `id` int NOT NULL AUTO_INCREMENT,
  `member` varchar(45) DEFAULT NULL,
  `tel` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `passwordcheck` varchar(45) DEFAULT NULL,
  `account` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `register`
--

LOCK TABLES `register` WRITE;
/*!40000 ALTER TABLE `register` DISABLE KEYS */;
INSERT INTO `register` VALUES (1,'defaulttest','0912345678','1234','taipei','1234','default'),(2,'member2','0912345678','1234','taipei','1234','cat'),(3,'test','0912345678','1234','taipei','1234','rabbit'),(4,'apple','09123','123','taipei','123','apple'),(5,'dao','09123','123','taipei','123','orange'),(6,'dao','09123','123','taipei','123','pineapple'),(7,'service','09123','123','taipei','123','bear'),(8,'UI','0912','1234','taipei','1234','toast'),(9,'UIfail','0912','123','NY','345','strawberry'),(10,'UIfail','0912','123','NZ','123','bird'),(11,'Chen','0912','1234','USA','1234','chen');
/*!40000 ALTER TABLE `register` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-02-08 12:28:28
