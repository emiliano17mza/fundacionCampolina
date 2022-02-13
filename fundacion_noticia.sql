-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: fundacion
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
-- Table structure for table `noticia`
--

DROP TABLE IF EXISTS `noticia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `noticia` (
  `id` varchar(255) NOT NULL,
  `fecha` date DEFAULT NULL,
  `texto` longtext NOT NULL,
  `titulo` varchar(255) NOT NULL,
  `alta` bit(1) NOT NULL,
  `texto_cortado` varchar(255) NOT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `noticia`
--

LOCK TABLES `noticia` WRITE;
/*!40000 ALTER TABLE `noticia` DISABLE KEYS */;
INSERT INTO `noticia` VALUES ('7ba42bfe-15fd-4c9a-95a3-dcccd958573b','2022-02-05','asdasdasdasdasdas','VAMOSSSSSS',_binary '','asdasdasdasdasdas','null'),('ca3bd823-6462-460b-a0f2-a5294d796762','2022-02-03','Esta asd jas djas dhas dhasy dash sdh cadscas523e\"!5e211e5ds5axas51x5as1xa5s1xa5s1xc zxCDC5zxCZXC5zx','Prueba imagen',_binary '','Esta asd jas djas dhas dhasy dash sdh cadscas523e\"!5e211e5ds5axas51x5as1xa5s1xa5s1xc zxCDC5zxCZXC5zx','null'),('cb49f22e-5fcd-4296-a9d2-0f245358b5ff','2022-02-05','asdasdasdasdas','Prueba NO SE',_binary '','asdasdasdasdas','MARCA CAMPOLINA.jpg'),('f605005a-cc63-4952-9e49-7338bb06d9d4','2022-02-04','hhhhhhhhhhn','ppppppppppppppppppppp',_binary '','hhhhhhhhhhn','logo_chico.png'),('fa8c9824-cc05-4278-bd9c-01ea0e7cc768','2022-02-04','asdasdasdas','Hola mundo!!!',_binary '','asdasdasdas','null');
/*!40000 ALTER TABLE `noticia` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-13 19:58:33
