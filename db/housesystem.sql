-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: housesystem
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer` (
  `CuNo` varchar(20) NOT NULL,
  `CuCard` varchar(20) NOT NULL,
  `CuName` varchar(10) NOT NULL,
  `Cusex` varchar(10) NOT NULL,
  `CuPhone` varchar(20) NOT NULL,
  `CuPay` varchar(10) NOT NULL,
  `roomNo` varchar(10) NOT NULL,
  `PastRoomNo` varchar(10) DEFAULT NULL,
  `cureserveTime` varchar(20) DEFAULT NULL,
  `cuCheckTime` varchar(20) DEFAULT NULL,
  `ReserveTimeLong` int(11) NOT NULL,
  PRIMARY KEY (`CuCard`),
  UNIQUE KEY `CuNo` (`CuNo`),
  UNIQUE KEY `CuPhone` (`CuPhone`),
  KEY `roomNo` (`roomNo`),
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`roomNo`) REFERENCES `room` (`roomno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('001','123','李武','男','123456','未结账未付定金','101',NULL,'2018-21',NULL,2);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food`
--

DROP TABLE IF EXISTS `food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `food` (
  `foodname` varchar(20) NOT NULL,
  `foodprice` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food`
--

LOCK TABLES `food` WRITE;
/*!40000 ALTER TABLE `food` DISABLE KEYS */;
/*!40000 ALTER TABLE `food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `housebill`
--

DROP TABLE IF EXISTS `housebill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `housebill` (
  `billNo` varchar(30) NOT NULL,
  `BillKind` varchar(10) DEFAULT NULL,
  `CuNo` varchar(10) DEFAULT NULL,
  `userno` varchar(20) DEFAULT NULL,
  `year` varchar(20) DEFAULT NULL,
  `month` varchar(20) DEFAULT NULL,
  `day` varchar(20) DEFAULT NULL,
  `profit` int(11) DEFAULT NULL,
  PRIMARY KEY (`billNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `housebill`
--

LOCK TABLES `housebill` WRITE;
/*!40000 ALTER TABLE `housebill` DISABLE KEYS */;
INSERT INTO `housebill` VALUES ('2018-12-20-09:12:10','客房费用','001',NULL,'2018','12','20',200);
/*!40000 ALTER TABLE `housebill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `housenews`
--

DROP TABLE IF EXISTS `housenews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `housenews` (
  `NewsNo` varchar(20) NOT NULL,
  `NewsShowTime` varchar(20) NOT NULL,
  `newskinds` varchar(10) NOT NULL,
  `NewsContent` varchar(100) NOT NULL,
  PRIMARY KEY (`NewsNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `housenews`
--

LOCK TABLES `housenews` WRITE;
/*!40000 ALTER TABLE `housenews` DISABLE KEYS */;
INSERT INTO `housenews` VALUES ('2018-12-20-09:21-招聘','2018-12-20-09:21','招聘','招聘服务员一名，工资面议，电话：123456');
/*!40000 ALTER TABLE `housenews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `message` (
  `time` varchar(40) NOT NULL,
  `content` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES ('2018-12-20-09:23','酒店服务很好！');
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `newuser`
--

DROP TABLE IF EXISTS `newuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `newuser` (
  `houseno` varchar(20) DEFAULT NULL,
  `userno` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `newuser`
--

LOCK TABLES `newuser` WRITE;
/*!40000 ALTER TABLE `newuser` DISABLE KEYS */;
/*!40000 ALTER TABLE `newuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nowuer`
--

DROP TABLE IF EXISTS `nowuer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `nowuer` (
  `houseno` varchar(20) DEFAULT NULL,
  `userno` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nowuer`
--

LOCK TABLES `nowuer` WRITE;
/*!40000 ALTER TABLE `nowuer` DISABLE KEYS */;
/*!40000 ALTER TABLE `nowuer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nowuser`
--

DROP TABLE IF EXISTS `nowuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `nowuser` (
  `houseno` varchar(20) NOT NULL,
  `userno` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nowuser`
--

LOCK TABLES `nowuser` WRITE;
/*!40000 ALTER TABLE `nowuser` DISABLE KEYS */;
INSERT INTO `nowuser` VALUES ('1',1);
/*!40000 ALTER TABLE `nowuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `outedroomthing`
--

DROP TABLE IF EXISTS `outedroomthing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `outedroomthing` (
  `CuNo` varchar(10) NOT NULL,
  `RoomNo` varchar(10) NOT NULL,
  `thingNo` varchar(30) NOT NULL,
  `ThingPrice` int(11) NOT NULL,
  `ThingOutAmount` int(11) NOT NULL,
  `PayMoney` int(11) NOT NULL,
  `ThingName` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `outedroomthing`
--

LOCK TABLES `outedroomthing` WRITE;
/*!40000 ALTER TABLE `outedroomthing` DISABLE KEYS */;
/*!40000 ALTER TABLE `outedroomthing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pastcustomer`
--

DROP TABLE IF EXISTS `pastcustomer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pastcustomer` (
  `cuno` varchar(20) DEFAULT NULL,
  `cucard` varchar(20) DEFAULT NULL,
  `cuname` varchar(20) DEFAULT NULL,
  `cusex` varchar(10) DEFAULT NULL,
  `cuphone` varchar(20) DEFAULT NULL,
  `roomno` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pastcustomer`
--

LOCK TABLES `pastcustomer` WRITE;
/*!40000 ALTER TABLE `pastcustomer` DISABLE KEYS */;
INSERT INTO `pastcustomer` VALUES ('0001','1234','程度','男','15254150051','101'),('002','123456123','李武','男','12345678910','102'),('003','85655','好几十','男','1234525','201'),('001','123456','李武','男','12345','101'),('001','123','fd','男','123','101');
/*!40000 ALTER TABLE `pastcustomer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `room` (
  `RoomNo` varchar(10) NOT NULL,
  `TypeNo` varchar(10) NOT NULL,
  `RoomFloor` int(11) NOT NULL,
  `Description` varchar(20) NOT NULL,
  `RoomStatus` varchar(10) NOT NULL DEFAULT '空闲',
  PRIMARY KEY (`RoomNo`),
  KEY `TypeNo` (`TypeNo`),
  CONSTRAINT `room_ibfk_1` FOREIGN KEY (`TypeNo`) REFERENCES `roomtype` (`typeno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES ('101','001',1,'靠窗','预定'),('102','002',1,'朝阳','空闲'),('201','003',2,'靠窗','空闲');
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roomstatus`
--

DROP TABLE IF EXISTS `roomstatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `roomstatus` (
  `roomno` varchar(20) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roomstatus`
--

LOCK TABLES `roomstatus` WRITE;
/*!40000 ALTER TABLE `roomstatus` DISABLE KEYS */;
/*!40000 ALTER TABLE `roomstatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roomthing`
--

DROP TABLE IF EXISTS `roomthing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `roomthing` (
  `roomno` varchar(20) NOT NULL,
  `thingno` varchar(20) NOT NULL,
  `thingprice` int(11) NOT NULL,
  `thingamount` int(11) NOT NULL,
  `thingname` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roomthing`
--

LOCK TABLES `roomthing` WRITE;
/*!40000 ALTER TABLE `roomthing` DISABLE KEYS */;
INSERT INTO `roomthing` VALUES ('101','001',5,6,'泡面'),('101','002',40,1,'暖瓶');
/*!40000 ALTER TABLE `roomthing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roomtype`
--

DROP TABLE IF EXISTS `roomtype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `roomtype` (
  `TypeNo` varchar(10) NOT NULL,
  `TypeName` varchar(10) NOT NULL,
  `TypeArea` int(11) NOT NULL,
  `TypePrice` int(11) NOT NULL,
  `PeopleNu` int(11) NOT NULL,
  PRIMARY KEY (`TypeNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roomtype`
--

LOCK TABLES `roomtype` WRITE;
/*!40000 ALTER TABLE `roomtype` DISABLE KEYS */;
INSERT INTO `roomtype` VALUES ('001','单人间',50,100,1),('002','双人间',60,200,2),('003','三人间',80,300,3),('004','四人间',90,400,4);
/*!40000 ALTER TABLE `roomtype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `UserNo` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(10) NOT NULL,
  `UserPhone` varchar(20) DEFAULT NULL,
  `UserAdress` varchar(20) NOT NULL,
  `UserPassword` varchar(20) DEFAULT NULL,
  `UserSex` varchar(10) NOT NULL,
  `UserPosition` varchar(10) NOT NULL,
  PRIMARY KEY (`UserNo`),
  UNIQUE KEY `UserPhone` (`UserPhone`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'张三','15254150052','山东','123456','男','经理'),(2,'张三','15254150051','山东','123456','男','经理');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-21 16:14:19
