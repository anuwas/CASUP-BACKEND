-- MySQL dump 10.13  Distrib 5.7.29, for Linux (x86_64)
--
-- Host: localhost    Database: casupportlog
-- ------------------------------------------------------
-- Server version	5.7.29-0ubuntu0.18.04.1

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
-- Table structure for table `application_user`
--

DROP TABLE IF EXISTS `application_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `application_user` (
  `application_user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_role` varchar(45) DEFAULT NULL,
  `user_id` varchar(145) DEFAULT NULL,
  `user_full_name` varchar(145) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`application_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `applications`
--

DROP TABLE IF EXISTS `applications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `applications` (
  `applications_id` int(11) NOT NULL AUTO_INCREMENT,
  `application_name` varchar(145) DEFAULT NULL,
  `application_description` text,
  PRIMARY KEY (`applications_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `configuration_properties`
--

DROP TABLE IF EXISTS `configuration_properties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `configuration_properties` (
  `configuration_properties_id` int(11) NOT NULL AUTO_INCREMENT,
  `config_name` varchar(45) DEFAULT NULL,
  `config_value` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`configuration_properties_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `dev_daily_scrum`
--

DROP TABLE IF EXISTS `dev_daily_scrum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dev_daily_scrum` (
  `daily_scrum_id` int(11) NOT NULL AUTO_INCREMENT,
  `sprint_name` varchar(45) NOT NULL,
  `dev_item` varchar(45) DEFAULT NULL,
  `current_status` text,
  `resource_name` varchar(145) DEFAULT NULL,
  `status_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`daily_scrum_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `dev_item`
--

DROP TABLE IF EXISTS `dev_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dev_item` (
  `dev_item_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_parent_id` int(11) NOT NULL DEFAULT '0',
  `item_number` varchar(45) DEFAULT NULL,
  `parent_item` varchar(45) DEFAULT NULL,
  `item_group` varchar(45) DEFAULT NULL,
  `item_type` varchar(45) DEFAULT NULL,
  `item_sub_type` varchar(45) DEFAULT NULL,
  `item_story_point` int(11) NOT NULL DEFAULT '0',
  `item_status` varchar(45) DEFAULT NULL,
  `item_sprint_id` int(11) NOT NULL DEFAULT '0',
  `item_sprint_name` varchar(45) DEFAULT NULL,
  `item_sprint_status` varchar(45) DEFAULT NULL,
  `item_sprint_status_comment` text,
  `item_subject` varchar(145) DEFAULT NULL,
  `item_description` text,
  `item_acceptance_ctriteria` text,
  `item_epic_name` varchar(45) DEFAULT NULL,
  `item_current_board` varchar(45) DEFAULT NULL,
  `application_name` varchar(45) DEFAULT NULL,
  `item_priority` varchar(45) DEFAULT NULL,
  `is_refined` varchar(45) DEFAULT NULL,
  `refine_date` varchar(45) DEFAULT NULL,
  `refine_comment` text,
  `link_item` varchar(45) DEFAULT NULL,
  `link_comment` text,
  `developer_name` varchar(45) DEFAULT NULL,
  `tester_name` varchar(45) DEFAULT NULL,
  `onboared_sprint` varchar(45) DEFAULT NULL,
  `delivered_sprint` varchar(45) DEFAULT NULL,
  `delivery_status` varchar(45) DEFAULT NULL,
  `item_sys_release_date` date DEFAULT NULL,
  `item_qa_release_date` date DEFAULT NULL,
  `item_uat_release_date` date DEFAULT NULL,
  `item_uat_rfc` varchar(45) DEFAULT NULL,
  `item_prd_release_date` date DEFAULT NULL,
  `item_prd_rfc` varchar(45) DEFAULT NULL,
  `item_uat_bug_count` int(11) DEFAULT '0',
  `item_prd_bug_count` int(11) DEFAULT '0',
  `project_name` varchar(45) DEFAULT NULL,
  `item_created_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`dev_item_id`),
  UNIQUE KEY `item_uat_bug_number_UNIQUE` (`item_uat_bug_count`),
  UNIQUE KEY `item_prd_bug_number_UNIQUE` (`item_prd_bug_count`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `dev_sprint`
--

DROP TABLE IF EXISTS `dev_sprint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dev_sprint` (
  `sprint_id` int(11) NOT NULL AUTO_INCREMENT,
  `sprint_name` varchar(45) DEFAULT NULL,
  `sprint_open_date` date DEFAULT NULL,
  `sprint_close_date` date DEFAULT NULL,
  `committed_story_point` int(11) NOT NULL DEFAULT '0',
  `deliverd_story_point` int(11) NOT NULL DEFAULT '0',
  `scope_creep` int(10) NOT NULL DEFAULT '0',
  `scope_creep_description` text,
  `spill_over_sp` int(10) NOT NULL DEFAULT '0',
  `spill_over_item` text,
  `is_spill_over` varchar(1) NOT NULL DEFAULT 'N',
  `sprint_created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`sprint_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `releases`
--

DROP TABLE IF EXISTS `releases`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `releases` (
  `release_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_subject` varchar(145) DEFAULT NULL,
  `item_description` text,
  `application_name` varchar(145) DEFAULT NULL,
  `uat_start_date` date DEFAULT NULL,
  `uat_signoff_date` date DEFAULT NULL,
  `uat_rfc_number` double DEFAULT NULL,
  `post_uat_bug_count` int(11) NOT NULL DEFAULT '0',
  `prd_release_date` date DEFAULT NULL,
  `prd_rfc_number` double DEFAULT NULL,
  `post_prd_bug_count` int(11) NOT NULL DEFAULT '0',
  `comment` text,
  `item_created_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `technology_tower` varchar(45) NOT NULL DEFAULT 'JAVA',
  PRIMARY KEY (`release_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `smart_operation`
--

DROP TABLE IF EXISTS `smart_operation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `smart_operation` (
  `smart_operation_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` varchar(45) DEFAULT NULL,
  `operation_date` date DEFAULT NULL,
  PRIMARY KEY (`smart_operation_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `support_item`
--

DROP TABLE IF EXISTS `support_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `support_item` (
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
  `priority` int(11) NOT NULL DEFAULT '0',
  `aged` varchar(2) NOT NULL DEFAULT 'N',
  `bounce` int(11) NOT NULL DEFAULT '0',
  `primary_sla_breached` varchar(2) NOT NULL DEFAULT 'N',
  `secondary_sla_breached` varchar(2) NOT NULL DEFAULT 'N',
  `tertiry_sla_breached` varchar(2) NOT NULL DEFAULT 'N',
  `resoluation` text,
  `rfc_number` double DEFAULT NULL,
  `tower_name` varchar(45) NOT NULL DEFAULT 'Java',
  `cronical_report` varchar(45) NOT NULL DEFAULT 'N',
  `revised_tower` varchar(45) DEFAULT NULL,
  `aged_on_date` datetime DEFAULT NULL,
  `breach_justification` text,
  `aged_justification` text,
  `debt_class` varchar(45) DEFAULT NULL,
  `debt_type` varchar(45) DEFAULT NULL,
  `debt_remedial_mechanism` varchar(45) DEFAULT NULL,
  `debt_estimate` varchar(45) DEFAULT NULL,
  `debt_comment` text,
  `modified_datetime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `rca_document` varchar(255) DEFAULT NULL,
  `document_shared_date` date DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=280 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `support_item_activity`
--

DROP TABLE IF EXISTS `support_item_activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `support_item_activity` (
  `support_item_activity_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) DEFAULT NULL,
  `item_activity` text,
  `item_activity_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`support_item_activity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_task_scheduler`
--

DROP TABLE IF EXISTS `user_task_scheduler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_task_scheduler` (
  `task_scheduler_id` int(11) NOT NULL AUTO_INCREMENT,
  `task_name` varchar(255) DEFAULT NULL,
  `task_description` text,
  `follow_up_to` varchar(145) DEFAULT NULL,
  `task_status` varchar(45) DEFAULT NULL,
  `priority` varchar(45) DEFAULT NULL,
  `task_scheduled_date` date NOT NULL,
  `comment` text,
  `task_modified_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `task_created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`task_scheduler_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_task_scheduler_activity`
--

DROP TABLE IF EXISTS `user_task_scheduler_activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_task_scheduler_activity` (
  `user_task_scheduler_activity_id` int(11) NOT NULL AUTO_INCREMENT,
  `task_scheduler_id` int(11) NOT NULL,
  `task_activity` text,
  `activity_created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_task_scheduler_activity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-03 23:55:19
