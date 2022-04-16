-- MySQL dump 10.13  Distrib 8.0.22, for macos10.15 (x86_64)
--
-- Host: localhost    Database: test_badge
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `activerecord`
--

DROP TABLE IF EXISTS `activerecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activerecord` (
  `badgeid` varchar(25) DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `timestamp` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=114525 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activerecord`
--

LOCK TABLES `activerecord` WRITE;
/*!40000 ALTER TABLE `activerecord` DISABLE KEYS */;
/*!40000 ALTER TABLE `activerecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(25) DEFAULT NULL,
  `password` varchar(25) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11778 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'qzz','123','123@qq.com'),(11776,NULL,'1234','123456@qq.com'),(11777,'qzz2','1234','123456@qq.com');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `badge`
--

DROP TABLE IF EXISTS `badge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `badge` (
  `id` varchar(25) NOT NULL,
  `macaddr` varchar(25) DEFAULT NULL,
  `username` varchar(25) DEFAULT NULL,
  `password` varchar(25) DEFAULT NULL,
  `userid` varchar(25) DEFAULT NULL,
  `datasetid` varchar(25) DEFAULT NULL,
  `timestamp` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `badge`
--

LOCK TABLES `badge` WRITE;
/*!40000 ALTER TABLE `badge` DISABLE KEYS */;
INSERT INTO `badge` VALUES ('device-0513-1','888','hh','hh','hh','123',1619378943200),('device-0513-2','04:F1:28:07:DD:22','fu','fu','fu','Nokia3',1619378943311),('device-0513-3','A8:3E:0E:BB:60:51','he','he','he','Nokia3',1619378943400);
/*!40000 ALTER TABLE `badge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dataset`
--

DROP TABLE IF EXISTS `dataset`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dataset` (
  `id` int NOT NULL AUTO_INCREMENT,
  `datasetid` varchar(25) DEFAULT NULL,
  `datasetname` varchar(100) DEFAULT NULL,
  `description` mediumtext,
  `numberofbadges` int DEFAULT NULL,
  `timestamp` mediumtext,
  `admin` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dataset`
--

LOCK TABLES `dataset` WRITE;
/*!40000 ALTER TABLE `dataset` DISABLE KEYS */;
INSERT INTO `dataset` VALUES (1,'\'11\'','\'11\'','\'11\'',12,'12345678','\'11\''),(2,'123','qzzsb','qzzsb2',3,'1223232','hj'),(3,'124','qzzss','qzzsvbb',3,'1223232323232','sdsd'),(4,'Nokia3','Nokia3','Nokia3',2,'1212121212121','212121');
/*!40000 ALTER TABLE `dataset` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datasetstat`
--

DROP TABLE IF EXISTS `datasetstat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `datasetstat` (
  `id` int DEFAULT NULL,
  `datasetid` varchar(25) DEFAULT NULL,
  `num` int DEFAULT NULL,
  `timestamp` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datasetstat`
--

LOCK TABLES `datasetstat` WRITE;
/*!40000 ALTER TABLE `datasetstat` DISABLE KEYS */;
INSERT INTO `datasetstat` VALUES (125142,'Nokia3',1,1619399438679),(125143,'Nokia3',1,1619399439627),(125144,'Nokia3',1,1619399440627),(125145,'Nokia3',1,1619399441624),(125146,'Nokia3',1,1619399442624),(125147,'Nokia3',1,1619399443624),(125148,'Nokia3',1,1619399444624),(125149,'Nokia3',1,1619399445627),(125243,'Nokia3',1,1619399446622),(125248,'Nokia3',1,1619399447621),(125249,'Nokia3',1,1619399448625),(125250,'Nokia3',1,1619399449622),(125251,'Nokia3',1,1619399450628),(125252,'Nokia3',1,1619399451622),(125345,'Nokia3',1,1619399452626),(125354,'Nokia3',1,1619399453625),(125355,'Nokia3',1,1619399454625),(125356,'Nokia3',1,1619399455625),(125357,'Nokia3',1,1619399456624),(125358,'Nokia3',1,1619399457626),(125459,'Nokia3',1,1619399458624),(125460,'Nokia3',1,1619399459626),(125461,'Nokia3',1,1619399460625),(125462,'Nokia3',1,1619399461625),(125463,'Nokia3',1,1619399462626),(125464,'Nokia3',1,1619399463625),(125565,'Nokia3',1,1619399464626),(125566,'Nokia3',1,1619399465624),(125567,'Nokia3',1,1619399466624),(125568,'Nokia3',1,1619399467622),(125569,'Nokia3',1,1619399468626),(125570,'Nokia3',1,1619399469626),(125571,'Nokia3',1,1619399470625),(125672,'Nokia3',1,1619399471625),(125673,'Nokia3',1,1619399472624),(125674,'Nokia3',1,1619399473626),(125675,'Nokia3',1,1619399474633),(125676,'Nokia3',1,1619399475624),(125777,'Nokia3',1,1619399476626),(125778,'Nokia3',1,1619399477627),(125779,'Nokia3',1,1619399478627),(125780,'Nokia3',1,1619399479624),(125781,'Nokia3',1,1619399480625),(125782,'Nokia3',1,1619399481625),(125883,'Nokia3',1,1619399482624),(125884,'Nokia3',1,1619399483624),(125885,'Nokia3',1,1619399484624),(125886,'Nokia3',1,1619399485624),(125887,'Nokia3',1,1619399486624),(125888,'Nokia3',1,1619399487621),(125889,'Nokia3',1,1619399488626),(125990,'Nokia3',1,1619399489624),(125991,'Nokia3',1,1619399490626),(125992,'Nokia3',1,1619399491626),(125993,'Nokia3',1,1619399492626),(125994,'Nokia3',1,1619399493626),(125995,'Nokia3',1,1619399494624),(126094,'Nokia3',1,1619399495623),(126095,'Nokia3',1,1619399496624),(126096,'Nokia3',1,1619399497626),(126097,'Nokia3',1,1619399498623),(126098,'Nokia3',1,1619399499625),(126199,'Nokia3',1,1619399500622),(126200,'Nokia3',1,1619399501626),(126201,'Nokia3',1,1619399502626),(126202,'Nokia3',1,1619399503624),(126203,'Nokia3',1,1619399504623),(126204,'Nokia3',1,1619399505623),(126305,'Nokia3',1,1619399506623),(126306,'Nokia3',1,1619399507623),(126307,'Nokia3',1,1619399508626),(126308,'Nokia3',1,1619399509624),(126309,'Nokia3',1,1619399510622),(126310,'Nokia3',1,1619399511623),(126311,'Nokia3',1,1619399512625),(126312,'Nokia3',1,1619399513624),(126411,'Nokia3',1,1619399514624),(126412,'Nokia3',1,1619399515624),(126413,'Nokia3',1,1619399516624),(126414,'Nokia3',1,1619399517624),(126415,'Nokia3',1,1619399518624),(126516,'Nokia3',1,1619399519625),(126517,'Nokia3',1,1619399520624),(126518,'Nokia3',1,1619399521624),(126519,'Nokia3',1,1619399522623),(126520,'Nokia3',1,1619399523622),(126621,'Nokia3',1,1619399524625),(126622,'Nokia3',1,1619399525624),(126623,'Nokia3',1,1619399526622),(126624,'Nokia3',1,1619399527621),(126625,'Nokia3',1,1619399528624),(126626,'Nokia3',1,1619399529624),(126627,'Nokia3',1,1619399530621),(126628,'Nokia3',1,1619399531621),(126629,'Nokia3',1,1619399532621),(126630,'Nokia3',1,1619399533624),(126631,'Nokia3',1,1619399534623),(126730,'Nokia3',1,1619399535621),(126731,'Nokia3',1,1619399536623),(126732,'Nokia3',1,1619399537623),(126733,'Nokia3',1,1619399538625),(126734,'Nokia3',1,1619399539621),(126835,'Nokia3',1,1619399540620),(126836,'Nokia3',1,1619399541621),(126837,'Nokia3',1,1619399542620),(126930,'Nokia3',1,1619399543624),(126939,'Nokia3',1,1619399544620),(126940,'Nokia3',1,1619399545621),(126941,'Nokia3',1,1619399546622),(126942,'Nokia3',1,1619399547623),(126943,'Nokia3',1,1619399548624),(126944,'Nokia3',1,1619399549620),(126945,'Nokia3',1,1619399550622),(126946,'Nokia3',1,1619399551623),(126947,'Nokia3',1,1619399552624),(126948,'Nokia3',1,1619399553624),(126949,'Nokia3',1,1619399554621),(126950,'Nokia3',1,1619399555622),(126951,'Nokia3',1,1619399556624),(126952,'Nokia3',1,1619399557623),(126953,'Nokia3',1,1619399558624),(126954,'Nokia3',1,1619399559623),(126955,'Nokia3',1,1619399560624),(126956,'Nokia3',1,1619399561624),(126957,'Nokia3',1,1619399562623),(126958,'Nokia3',1,1619399563623),(126959,'Nokia3',1,1619399564622),(126960,'Nokia3',1,1619399565624),(126961,'Nokia3',1,1619399566623),(126962,'Nokia3',1,1619399567624),(126963,'Nokia3',1,1619399568623),(126964,'Nokia3',1,1619399569621),(126965,'Nokia3',1,1619399570624),(126966,'Nokia3',1,1619399571623),(127050,'Nokia3',1,1619399572624),(127068,'Nokia3',1,1619399573624),(127069,'Nokia3',1,1619399574621),(127070,'Nokia3',1,1619399575624),(127071,'Nokia3',1,1619399576620),(127072,'Nokia3',1,1619399618110),(127073,'Nokia3',1,1619399619061),(127074,'Nokia3',1,1619399620065),(127075,'Nokia3',1,1619399621063),(127076,'Nokia3',1,1619399622062),(127077,'Nokia3',1,1619399623063),(127078,'Nokia3',1,1619399624065),(127079,'Nokia3',1,1619399625062),(127177,'Nokia3',1,1619399626061),(127178,'Nokia3',1,1619399627057),(127179,'Nokia3',1,1619399628057),(127180,'Nokia3',1,1619399629062),(127181,'Nokia3',1,1619399630063),(127182,'Nokia3',1,1619399631062),(127283,'Nokia3',1,1619399632062),(127284,'Nokia3',1,1619399633062),(127285,'Nokia3',1,1619399634062),(127286,'Nokia3',1,1619399635059),(127287,'Nokia3',1,1619399636060),(127388,'Nokia3',1,1619399637060),(127389,'Nokia3',1,1619399638062),(127390,'Nokia3',1,1619399639060),(127391,'Nokia3',1,1619399640058),(127392,'Nokia3',1,1619399641059),(127393,'Nokia3',1,1619399642059),(127394,'Nokia3',1,1619399643057),(127403,'Nokia3',1,1619399644059),(127496,'Nokia3',1,1619399645059),(127497,'Nokia3',1,1619399646061),(127498,'Nokia3',1,1619399647059),(127499,'Nokia3',1,1619399648061),(127500,'Nokia3',1,1619399649059),(127501,'Nokia3',1,1619399650059),(127502,'Nokia3',1,1619399651059),(127511,'Nokia3',1,1619399652058),(127512,'Nokia3',1,1619399653058),(127605,'Nokia3',1,1619399654062),(127606,'Nokia3',1,1619399655058),(127707,'Nokia3',1,1619399656062),(127708,'Nokia3',1,1619399657058),(127709,'Nokia3',1,1619399658062),(127710,'Nokia3',1,1619399659058),(127711,'Nokia3',1,1619399660059),(127712,'Nokia3',1,1619399661059),(127713,'Nokia3',1,1619399662061),(127714,'Nokia3',1,1619399663057),(127715,'Nokia3',1,1619399664060),(127816,'Nokia3',1,1619399665064),(127817,'Nokia3',1,1619399666057),(127818,'Nokia3',1,1619399667057),(127827,'Nokia3',1,1619399668058),(127828,'Nokia3',1,1619399669060),(127829,'Nokia3',1,1619399670057),(127830,'Nokia3',1,1619399671057),(127831,'Nokia3',1,1619399688330),(127832,'Nokia3',1,1619399689276),(127833,'Nokia3',1,1619399690277),(127834,'Nokia3',1,1619399691272),(127835,'Nokia3',1,1619399692273),(127836,'Nokia3',1,1619399693274),(127837,'Nokia3',1,1619399694272),(127838,'Nokia3',1,1619399695273),(127839,'Nokia3',1,1619399696272),(127937,'Nokia3',1,1619399697272),(127938,'Nokia3',1,1619399698268),(127939,'Nokia3',1,1619399699269),(127940,'Nokia3',1,1619399700268),(127941,'Nokia3',1,1619399701268),(127942,'Nokia3',1,1619399702268),(127943,'Nokia3',1,1619399703269),(128036,'Nokia3',1,1619399704268),(128037,'Nokia3',1,1619399705270),(128038,'Nokia3',1,1619399706269),(128039,'Nokia3',1,1619399707270),(128140,'Nokia3',1,1619399708270),(128149,'Nokia3',1,1619399709269),(128150,'Nokia3',1,1619399710267),(128151,'Nokia3',1,1619399711268),(128152,'Nokia3',1,1619399712266),(128153,'Nokia3',1,1619399713268),(128154,'Nokia3',1,1619399714267),(128155,'Nokia3',1,1619399715270),(128156,'Nokia3',1,1619399716265),(128157,'Nokia3',1,1619399717265),(128250,'Nokia3',1,1619399718268),(128251,'Nokia3',1,1619399719266),(128252,'Nokia3',1,1619399720269),(128253,'Nokia3',1,1619399721265),(128354,'Nokia3',1,1619399722268),(128363,'Nokia3',1,1619399723265),(128364,'Nokia3',1,1619399724269),(128365,'Nokia3',1,1619399725265),(128366,'Nokia3',1,1619399726265),(128467,'Nokia3',1,1619399727265),(128468,'Nokia3',1,1619399728270),(128469,'Nokia3',1,1619399729276),(128470,'Nokia3',1,1619399730267),(128471,'Nokia3',1,1619399731264),(128472,'Nokia3',1,1619399732266),(128575,'Nokia3',1,1619399733265),(128576,'Nokia3',1,1619399734266),(128577,'Nokia3',1,1619399735267),(128578,'Nokia3',1,1619399736263),(128579,'Nokia3',1,1619399737265),(128580,'Nokia3',1,1619399738266),(128681,'Nokia3',1,1619399739269),(128682,'Nokia3',1,1619468805346);
/*!40000 ALTER TABLE `datasetstat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (128683);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movement`
--

DROP TABLE IF EXISTS `movement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movement` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `badgeid` varchar(25) DEFAULT NULL,
  `x` float DEFAULT NULL,
  `y` float DEFAULT NULL,
  `z` float DEFAULT NULL,
  `timestamp` bigint DEFAULT NULL,
  `datasetid` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=128635 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movement`
--

LOCK TABLES `movement` WRITE;
/*!40000 ALTER TABLE `movement` DISABLE KEYS */;
/*!40000 ALTER TABLE `movement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movementstate`
--

DROP TABLE IF EXISTS `movementstate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movementstate` (
  `id` int NOT NULL AUTO_INCREMENT,
  `timestamp` bigint DEFAULT NULL,
  `badgeid` varchar(25) DEFAULT NULL,
  `sitstate` int DEFAULT NULL,
  `movestate` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=128681 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movementstate`
--

LOCK TABLES `movementstate` WRITE;
/*!40000 ALTER TABLE `movementstate` DISABLE KEYS */;
/*!40000 ALTER TABLE `movementstate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nearmacs`
--

DROP TABLE IF EXISTS `nearmacs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nearmacs` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `timestamp` bigint DEFAULT NULL,
  `badgeid` varchar(25) DEFAULT NULL,
  `badgemacid` varchar(25) DEFAULT NULL,
  `nearmacaddr` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=110546 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nearmacs`
--

LOCK TABLES `nearmacs` WRITE;
/*!40000 ALTER TABLE `nearmacs` DISABLE KEYS */;
INSERT INTO `nearmacs` VALUES (1,12332323,'device-0513-1','888','12:12:12:12:12:12'),(2,12332323,'device-0513-1','888','12:12:12:12:12:13'),(3,123232,'device-0513-1','888','12:12:12:12:12:15'),(4,2323232,'device-0513-1','888','12:12:12:12:12:14'),(20068,1619197439287,'device-0513-1','888','A8:3E:0E:BB:60:51'),(22241,1619198582304,'device-0513-1','888','A8:3E:0E:B7:7A:EC'),(24137,1619198674540,'device-0513-1','888','A8:3E:0E:B7:7A:EC'),(24927,1619198737276,'device-0513-1','888','A8:3E:0E:BB:60:51'),(26266,1619199355869,'device-0513-1','888','A8:3E:0E:B7:7C:34'),(26267,1619199355869,'device-0513-1','888','AC:57:75:01:61:AB'),(27168,1619199442095,'device-0513-1','888','AC:57:75:01:61:AB'),(27172,1619199442095,'device-0513-1','888','A8:3E:0E:B7:7C:34'),(27654,1619199488135,'device-0513-1','888','A8:3E:0E:B7:7C:34'),(27655,1619199488135,'device-0513-1','888','AC:57:75:01:61:AB'),(28114,1619199531385,'device-0513-1','888','A8:3E:0E:B7:7C:34'),(28115,1619199531385,'device-0513-1','888','AC:57:75:01:61:AB'),(28116,1619199531385,'device-0513-1','888','A8:3E:0E:B7:7A:EC'),(28903,1619199589571,'device-0513-1','888','A8:3E:0E:B7:7C:34'),(28905,1619199589571,'device-0513-1','888','AC:57:75:01:61:AB'),(28907,1619199589571,'device-0513-1','888','A8:3E:0E:B7:7A:EC'),(28909,1619199589571,'device-0513-1','888','A8:3E:0E:BB:60:51'),(29329,1619199608977,'device-0513-1','888','A8:3E:0E:B7:7C:34'),(29331,1619199608977,'device-0513-1','888','AC:57:75:01:61:AB'),(30132,1619199648646,'device-0513-1','888','A8:3E:0E:B7:7C:34'),(30134,1619199648646,'device-0513-1','888','AC:57:75:01:61:AB'),(30136,1619199648647,'device-0513-1','888','A8:3E:0E:B7:7A:EC'),(31075,1619199691332,'device-0513-1','888','A8:3E:0E:B7:7C:34'),(31076,1619199691332,'device-0513-1','888','AC:57:75:01:61:AB'),(31469,1619199711147,'device-0513-1','888','A8:3E:0E:B7:7C:34'),(31470,1619199711147,'device-0513-1','888','AC:57:75:01:61:AB'),(31471,1619199711147,'device-0513-1','888','A8:3E:0E:B7:7A:EC'),(31922,1619199731087,'device-0513-1','888','A8:3E:0E:B7:7C:34'),(31924,1619199731087,'device-0513-1','888','A8:3E:0E:B7:7A:EC'),(32352,1619199751296,'device-0513-1','888','AC:57:75:01:61:AB'),(32353,1619199751296,'device-0513-1','888','A8:3E:0E:B7:7C:34'),(32354,1619199751296,'device-0513-1','888','A8:3E:0E:B7:7A:EC'),(33193,1619199792590,'device-0513-1','888','A8:3E:0E:B7:7C:34'),(33195,1619199792590,'device-0513-1','888','AC:57:75:01:61:AB'),(33496,1619199812018,'device-0513-1','888','AC:57:75:01:61:AB'),(33498,1619199812018,'device-0513-1','888','A8:3E:0E:B7:7C:34'),(33887,1619199832791,'device-0513-1','888','AC:57:75:01:61:AB'),(33889,1619199832791,'device-0513-1','888','A8:3E:0E:B7:7C:34'),(33891,1619199832791,'device-0513-1','888','A8:3E:0E:B7:7A:EC'),(34544,1619199990835,'device-0513-1','888','A8:3E:0E:B7:7C:34'),(34546,1619199990835,'device-0513-1','888','AC:57:75:01:61:AB'),(34973,1619200011874,'device-0513-1','888','AC:57:75:01:61:AB'),(34974,1619200011874,'device-0513-1','888','A8:3E:0E:B7:7C:34'),(34975,1619200011874,'device-0513-1','888','A8:3E:0E:BB:60:51'),(35332,1619200032277,'device-0513-1','888','A8:3E:0E:B7:7C:34'),(35333,1619200032277,'device-0513-1','888','AC:57:75:01:61:AB'),(35334,1619200032277,'device-0513-1','888','A8:3E:0E:B7:7A:EC'),(35637,1619200052609,'device-0513-1','888','AC:57:75:01:61:AB'),(35638,1619200052609,'device-0513-1','888','A8:3E:0E:B7:7C:34'),(35639,1619200052609,'device-0513-1','888','A8:3E:0E:B7:7A:EC'),(39275,1619201466650,'device-0513-1','888','A8:3E:0E:B7:78:EA'),(39276,1619201466650,'device-0513-1','888','A8:3E:0E:BB:60:51'),(82870,1619204354357,'device-0513-1','888','AC:57:75:01:61:AB'),(84380,1619204488165,'device-0513-1','888','AC:57:75:01:61:AB'),(110545,1619379448973,'device-0513-3','888','04:F1:28:07:DD:22');
/*!40000 ALTER TABLE `nearmacs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrcode`
--

DROP TABLE IF EXISTS `qrcode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qrcode` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `qrcode` varchar(25) DEFAULT NULL,
  `timestamp` bigint DEFAULT NULL,
  `badgeid` varchar(25) DEFAULT NULL,
  `datasetid` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25298 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrcode`
--

LOCK TABLES `qrcode` WRITE;
/*!40000 ALTER TABLE `qrcode` DISABLE KEYS */;
INSERT INTO `qrcode` VALUES (8534,'button pressed',1266533932022,'device-0513-1','hh'),(8780,'button pressed',1618275128042,'device-0513-1','hh'),(11165,'qizhenzhousb',1618276786675,'device-0513-1','hh'),(11374,'qizhenzhousb',1618276841497,'device-0513-1','hh'),(11617,'qizhenzhousb',1618276916387,'device-0513-1','hh'),(25297,'button pressed',1619198753060,'device-0513-1','123');
/*!40000 ALTER TABLE `qrcode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voice`
--

DROP TABLE IF EXISTS `voice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `voice` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `frequency` double DEFAULT NULL,
  `decibel` double DEFAULT NULL,
  `badgeid` varchar(25) DEFAULT NULL,
  `datasetid` varchar(25) DEFAULT NULL,
  `timestamp` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=128597 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voice`
--

LOCK TABLES `voice` WRITE;
/*!40000 ALTER TABLE `voice` DISABLE KEYS */;
/*!40000 ALTER TABLE `voice` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-26 16:35:06