-- MySQL dump 10.13  Distrib 5.7.28, for Linux (x86_64)
--
-- Host: localhost    Database: casupportlog
-- ------------------------------------------------------
-- Server version	5.7.28-0ubuntu0.18.04.4

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
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_number` double NOT NULL,
  `item_type` varchar(45) NOT NULL,
  `item_subject` text,
  `item_owner` varchar(145) DEFAULT NULL,
  `item_status` varchar(45) DEFAULT NULL,
  `item_description` text,
  `item_assigned` varchar(145) DEFAULT NULL,
  `associated_item` varchar(145) DEFAULT NULL,
  `item_created_date` datetime DEFAULT NULL,
  `item_close_date` datetime DEFAULT NULL,
  `item_created_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `application_name` varchar(45) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `aged` varchar(2) NOT NULL DEFAULT 'N',
  `bounce` int(11) NOT NULL DEFAULT '0',
  `primary_sla_breached` varchar(2) NOT NULL DEFAULT 'N',
  `secondary_sla_breached` varchar(2) NOT NULL DEFAULT 'N',
  `tertiry_sla_breached` varchar(2) NOT NULL DEFAULT 'N',
  `resoluation` text,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=130 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-23  0:42:50
