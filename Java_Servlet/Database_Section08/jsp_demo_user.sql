-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: jsp_demo
-- ------------------------------------------------------
-- Server version	8.0.13

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `ID` int(11) NOT NULL,
  `Name` varchar(45) DEFAULT NULL,
  `UserName` varchar(45) DEFAULT NULL,
  `PassWord` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `Phone` varchar(11) DEFAULT NULL,
  `Favourites` varchar(45) DEFAULT NULL,
  `about` varchar(1000) DEFAULT NULL,
  `Role` varchar(15) DEFAULT NULL,
  `Avatar` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'NGUYEN ANH TUAN','anhtuann','123456789','w190659@ccg.ac.jp','09021540153','Music,','ADMIN','Role_Admin','/Section_07_MVC/images/images.jpg'),(7,'NGUYEN ANH TUAN','admin','admin',NULL,NULL,NULL,NULL,'Role_Admin','../images/images.jpg'),(190658,'VU NGOC TUYEN','simonstorm','123456','tuyen@gmail.com','0900007008','Movies,','Tuyen thiet ke web','Role_User','../images/images.jpg'),(190659,'NGUYEN ANH TUAN','anhtuann2108','123456','learn.nguyenanhtuan@gmail.com','09021540153','Movies,Music,',' Xin chào các b&#7841;n\r\nMình là Nguy&#7877;n Anh Tu&#7845;n , n&#259;m nay 27 tu&#7893;i ,mình &#273;ã &#273;&#7871;n Nh&#7853;t &#273;&#432;&#7907;c 3 n&#259;m Hi&#7879;n t&#7841;i mình là h&#7885;c sinh n&#259;m hai c&#7911;a tr&#432;&#7901;ng cao &#273;&#259;ng Waseda t&#7841;i Tokyo.&#431;&#7899;c m&#417; c&#7911;a mình là tr&#7903; thành k&#7929; s&#432; l&#7853;p trình Web nên mình &#273;ang h&#7885;c l&#7853;p trình Java Web (Servlet và JSP )  ','Role_User','1599415022127.jpeg'),(190677,'NGUYEN THANH NAM','namspring','123456','namspring@gmail.com','09021543111','Movies,Music,','Nothing!!!','Role_User','/Section_08_MVC/images/images.jpg'),(190725,'NGUYEN THANH NHAN','nhankute','123456','thanhnhan@gmail.com','08013551109','Movies,Music,','NGUYEN THANH NHAN 27 tuoi ,song tai Tokyo .Hien tai hoc IT tai truong senmon Wasedabunri tai Takadanobaba.\r\nSo thich boi loi , da banh , chich gai.\r\nYoroshiku oneigaishimasu.','Role_User','1599185315136.png'),(190761,'NGUYEN XUAN THANH','thanhkute','123456','xuanthanh@gmail.com','07038871012','Movies,Music,','NGUYEN XUAN THANH 20 tuoi\r\nHoc lap trinh Java\r\nSong tai Tokyo\r\nNGUYEN XUAN THANH 20 tuoi\r\nHoc lap trinh Java\r\nSong tai Tokyo\r\n','Role_User','../images/images.jpg');
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

-- Dump completed on 2020-10-08 11:31:36
