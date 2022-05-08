-- MySQL dump 10.13  Distrib 8.0.29, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: SpeMajordb
-- ------------------------------------------------------
-- Server version	8.0.29-0ubuntu0.20.04.3

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
-- Table structure for table `Photo`
--

DROP TABLE IF EXISTS `Photo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Photo` (
  `photo_id` int NOT NULL AUTO_INCREMENT,
  `id` varchar(255) DEFAULT NULL,
  `storagepoint_storagepoint_id` int DEFAULT NULL,
  PRIMARY KEY (`photo_id`),
  KEY `FKk9ymu99xoftc11l6bo7j57war` (`storagepoint_storagepoint_id`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Photo`
--

LOCK TABLES `Photo` WRITE;
/*!40000 ALTER TABLE `Photo` DISABLE KEYS */;
INSERT INTO `Photo` VALUES (1,'https://www.dropbox.com/s/d4jpvet7f6mcrwg/G1.jpg?raw=1',1),(2,'https://www.dropbox.com/s/8zx84ngamzx0ru2/G2.jpg?raw=1',1),(3,'https://www.dropbox.com/s/s6imntx7u6ury0h/G3.jpg?raw=1',1),(4,'https://www.dropbox.com/s/olpqxxdwapnd0oz/H1.jpg?raw=1',2),(5,'https://www.dropbox.com/s/o8vsn055dsh4p8m/H2.jpg?raw=1',2),(6,'https://www.dropbox.com/s/rvs40ctos8r4h7g/H3.jpg?raw=1',2),(7,'https://www.dropbox.com/s/wz7bvxbmd097sf8/I1.webp?raw=1',3),(8,'https://www.dropbox.com/s/lj56smhmsk05w6m/I2.webp?raw=1',3),(9,'https://www.dropbox.com/s/8tqvon662neujdi/I3.webp?raw=1',3),(10,'https://www.dropbox.com/s/qrdv837q5zcqimp/J1.webp?raw=1',4),(11,'https://www.dropbox.com/s/xmhiz3xxe4maq8j/J2.webp?raw=1',4),(12,'https://www.dropbox.com/s/cncmtjltldc477a/J3.jpg?raw=1',4),(13,'https://www.dropbox.com/s/nqaf9mbann4owum/K1.webp?raw=1',5),(14,'https://www.dropbox.com/s/i8re9ruzhw0qvhu/K2.webp?raw=1',5),(15,'https://www.dropbox.com/s/m0ahad3mdonbuff/K3.jpg?raw=1',5);
/*!40000 ALTER TABLE `Photo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Region`
--

DROP TABLE IF EXISTS `Region`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Region` (
  `id` int NOT NULL AUTO_INCREMENT,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Region`
--

LOCK TABLES `Region` WRITE;
/*!40000 ALTER TABLE `Region` DISABLE KEYS */;
/*!40000 ALTER TABLE `Region` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Review`
--

DROP TABLE IF EXISTS `Review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Review` (
  `review_id` int NOT NULL AUTO_INCREMENT,
  `id` varchar(255) DEFAULT NULL,
  `rating` int NOT NULL,
  `text` varchar(255) DEFAULT NULL,
  `time_created` varchar(255) DEFAULT NULL,
  `storagepoint_storagepoint_id` int DEFAULT NULL,
  `user_serviceconsumer_id` int DEFAULT NULL,
  PRIMARY KEY (`review_id`),
  KEY `FKcga7lyw1ip022xs0ljdkv566s` (`storagepoint_storagepoint_id`),
  KEY `FKe8h4cu5rhu77e9ci4ysp6rf31` (`user_serviceconsumer_id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Review`
--

LOCK TABLES `Review` WRITE;
/*!40000 ALTER TABLE `Review` DISABLE KEYS */;
INSERT INTO `Review` VALUES (1,'Reviewid11',4,'Site manager was really friendly and helpful.  Can\'t thank him enough for his help and support','2022-03-12 18:54:25',1,1),(2,'Reviewid12',5,'Very helpful receivng my moving boxes from the States. Clean facility. Would use them again.','2022-04-12 17:54:25',1,2),(3,'Reviewid21',4,'The staff at The Store Room were super helpful and accommodating. The rental is fairly expensive but my furniture was safe and kept in perfect condition.','2022-04-12 17:54:25',2,3),(4,'Reviewid22',4,'Brilliant customer service would definitely recommend','2022-06-12 17:14:25',2,4),(5,'Reviewid31',4,'The units were very secure and well maintained. Would definitely use this service again should the need arise. ','2022-06-12 17:14:25',3,5),(6,'Reviewid32',5,'Fantastic reliable and clean','2022-06-12 17:14:25',3,6),(7,'Reviewid41',4,'Not a lot to say, to be honest. Just a great service which worked really well. What more could anyone want?  Thanks.','2022-02-11 12:49:25',4,7),(8,'Reviewid42',5,'Always had excellent customer service from the staff and a very secure environment for my goods','2022-08-19 19:49:25',4,8),(9,'Reviewid51',4,'Second time I have used the store room in 12 months. The whole set up is fantastic especially the staff. I would highly recommend this company.','2022-10-11 11:49:25',5,8),(10,'Reviewid52',5,'Excellent, would definitely use again','2022-12-01 19:19:25',5,9);
/*!40000 ALTER TABLE `Review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ServiceConsumer`
--

DROP TABLE IF EXISTS `ServiceConsumer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ServiceConsumer` (
  `serviceconsumer_id` int NOT NULL AUTO_INCREMENT,
  `id` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`serviceconsumer_id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ServiceConsumer`
--

LOCK TABLES `ServiceConsumer` WRITE;
/*!40000 ALTER TABLE `ServiceConsumer` DISABLE KEYS */;
INSERT INTO `ServiceConsumer` VALUES (1,'U1','https://www.dropbox.com/s/4p5y7lp9qnjoowg/user_placeholder.jpg?raw=1','Rakesh Sharma'),(2,'U2','https://www.dropbox.com/s/4p5y7lp9qnjoowg/user_placeholder.jpg?raw=1','Vikas Garg'),(3,'U3','https://www.dropbox.com/s/4p5y7lp9qnjoowg/user_placeholder.jpg?raw=1','Bhawna Beniwal'),(4,'U4','https://www.dropbox.com/s/4p5y7lp9qnjoowg/user_placeholder.jpg?raw=1','Rohit Ranjan'),(5,'U5','https://www.dropbox.com/s/4p5y7lp9qnjoowg/user_placeholder.jpg?raw=1','Anamika Kumari'),(6,'U6','https://www.dropbox.com/s/4p5y7lp9qnjoowg/user_placeholder.jpg?raw=1','Keshav Kumar'),(7,'U7','https://www.dropbox.com/s/4p5y7lp9qnjoowg/user_placeholder.jpg?raw=1','Vandana Gupta'),(8,'U8','https://www.dropbox.com/s/4p5y7lp9qnjoowg/user_placeholder.jpg?raw=1','Mohit Jain'),(9,'U9','https://www.dropbox.com/s/4p5y7lp9qnjoowg/user_placeholder.jpg?raw=1','Kashish Taneja'),(10,'U10','https://www.dropbox.com/s/4p5y7lp9qnjoowg/user_placeholder.jpg?raw=1','Shobhit Mittal');
/*!40000 ALTER TABLE `ServiceConsumer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `StoragePoint`
--

DROP TABLE IF EXISTS `StoragePoint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `StoragePoint` (
  `storagepoint_id` int NOT NULL AUTO_INCREMENT,
  `alias` varchar(255) DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `display_phone` varchar(255) DEFAULT NULL,
  `distance` double NOT NULL,
  `id` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `is_closed` bit(1) NOT NULL,
  `address1` varchar(255) DEFAULT NULL,
  `address2` varchar(255) DEFAULT NULL,
  `address3` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `display_address` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `zip_code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `rating` float NOT NULL,
  `vendor_id` int DEFAULT NULL,
  PRIMARY KEY (`storagepoint_id`),
  KEY `FK1qpkvly5j5fqjcxh8g6xtdiah` (`vendor_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `StoragePoint`
--

LOCK TABLES `StoragePoint` WRITE;
/*!40000 ALTER TABLE `StoragePoint` DISABLE KEYS */;
INSERT INTO `StoragePoint` VALUES (1,'Orange Self-Storage Solutions',12.842976,77.665322,'+91-8433136298',0,'XzUW9MvEGOFs9_aNj11j2Q','https://www.dropbox.com/s/d4jpvet7f6mcrwg/G1.jpg?raw=1',_binary '\0','2nd Cross Road, Neeladri Nagar','Electronics City Phase 1, Electronic City','','Bengaluru','India','2nd Cross Road, Neeladri Nagar,Bengaluru, Karnataka 560100','Karnataka','560100','Orange Self-Storage Solutions','8433136298','200',4,1),(2,'Mishra\'s Residence',12.842976,77.665322,'+91-8433136231',0,'XzUW9MvEGOFs9_aNj11j2R','https://www.dropbox.com/s/olpqxxdwapnd0oz/H1.jpg?raw=1',_binary '\0','RMV8+44P','Electronics City Phase 1, Electronic City','','Bengaluru','India','RMV8+44P,Bengaluru, Karnataka 560100','Karnataka','560100','Mishra\'s Residence','8433136231','250',4,2),(3,'Kapoor and Sons',12.842411,77.66352,'+91-9434136231',0,'XzUW9MvEGOFs9_aNj11j2S','https://www.dropbox.com/s/wz7bvxbmd097sf8/I1.webp?raw=1',_binary '\0','4th Cross Rd','Electronics City Phase 1, Electronic City','','Bengaluru','India','4th Cross Rd,Bengaluru, Karnataka 560100','Karnataka','560100','Kapoor and Sons','9434136231','250',5,1),(4,'Yellow Self-Storage Solutions',12.843467,77.660452,'+91-9434136232',0,'XzUW9MvEGOFs9_aNj11j2T','https://www.dropbox.com/s/qrdv837q5zcqimp/J1.webp?raw=1',_binary '\0','4th Cross Rd','Electronics City Phase 1, Electronic City','','Bengaluru','India','4th Cross Rd,Bengaluru, Karnataka 560100','Karnataka','560100','Yellow Self-Storage Solutions','9434136232','300',4,2),(5,'Hitesh Medicals and General Stores',12.845538,77.661546,'+91-9534136232',0,'XzUW9MvEGOFs9_aNj11j2U','https://www.dropbox.com/s/nqaf9mbann4owum/K1.webp?raw=1',_binary '\0','Near Siemens','Electronics City Phase 1, Electronic City','','Bengaluru','India','Near Siemens,Bengaluru, Karnataka 560100','Karnataka','560100','zHitesh Medicals and General Stores','9534136232','300',3,3),(6,NULL,NULL,NULL,NULL,0,'XzUW9MvEGOFs9_aNj11j2U',NULL,_binary '\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'zHitesh Medicals and General Stores','9534136232','300',0,NULL);
/*!40000 ALTER TABLE `StoragePoint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Vendor`
--

DROP TABLE IF EXISTS `Vendor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Vendor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `mobile` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Vendor`
--

LOCK TABLES `Vendor` WRITE;
/*!40000 ALTER TABLE `Vendor` DISABLE KEYS */;
INSERT INTO `Vendor` VALUES (1,'test1@gmail.com','9876543210','password','ADMIN'),(2,'test2@gmail.com','9876543210','password','ADMIN'),(3,'test3@gmail.com','9876543210','password','ADMIN'),(4,'test4@gmail.com','9876543210','password','ADMIN');
/*!40000 ALTER TABLE `Vendor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-08 14:50:29
