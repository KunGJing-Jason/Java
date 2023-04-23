-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: empdb
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `emps`
--

DROP TABLE IF EXISTS `emps`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emps` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `birth` datetime DEFAULT NULL,
  `dept_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `dept_id_idx` (`dept_id`),
  CONSTRAINT `fk_dept_id` FOREIGN KEY (`dept_id`) REFERENCES `depts` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emps`
--

LOCK TABLES `emps` WRITE;
/*!40000 ALTER TABLE `emps` DISABLE KEYS */;
INSERT INTO `emps` (`id`, `name`, `img_url`, `sex`, `birth`, `dept_id`) VALUES (1,'张珊','photo/avatar12.png','女','2000-01-03 00:00:00',3),(2,'丽丝','photo/avatar39.png','女','2000-02-03 00:00:00',1),(3,'王武','photo/avatar20.png','男','2000-03-05 00:00:00',2),(4,'赵柳','photo/avatar12.png','男','2000-04-06 00:00:00',3),(5,'阿呆','photo/avatar39.png','女','2000-05-07 00:00:00',1),(6,'鲍勃','photo/avatar12.png','男','2000-06-08 00:00:00',2),(7,'张珊珊','photo/avatar39.png','女','2000-01-03 00:00:00',2),(8,'张珊珊','photo/avatar39.png','女','2000-01-03 00:00:00',2),(9,'张珊珊','photo/avatar39.png','女','2000-01-03 00:00:00',2),(10,'李丝丝','photo/avatar39.png','男','2000-01-03 00:00:00',2),(11,'王五五','photo/avatar12.png','女','2000-01-03 00:00:00',2),(12,'赵六六','photo/avatar12.png','男','2000-01-03 00:00:00',2),(13,'阿黛','photo/avatar39.png','男','2000-01-03 00:00:00',2),(14,'辛迪','photo/avatar39.png','女','2000-01-03 00:00:00',2),(15,'李杉','photo/avatar12.png','女','2000-01-03 00:00:00',NULL),(16,'芬妮','photo/72dbee17-829c-45eb-87a5-a62c4cdc3309.webp','女','2023-03-28 16:00:00',NULL),(17,'格兰特','photo/065198ad-d9bc-4f01-9527-3f1b5588ee25.webp','男','2023-04-05 16:00:00',NULL),(18,'亨特','photo/e9da7fb0-692b-45f2-a496-097935fb8ebf.webp','男','2023-03-31 16:00:00',NULL),(19,'艾薇','photo/30778e27-396e-4c53-b0b6-8d77cb2777d4.webp','女','2023-04-05 16:00:00',5);
/*!40000 ALTER TABLE `emps` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-10 15:36:14
