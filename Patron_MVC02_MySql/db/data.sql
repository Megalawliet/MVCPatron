
CREATE DATABASE IF NOT EXISTS `MVC_db`;
USE `MVC_db`;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;

CREATE TABLE `persona` (
  `id` int NOT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `edad` int DEFAULT NULL,
  `profesion` varchar(30) DEFAULT NULL,
  `telefono` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `persona`
--

INSERT INTO `persona` VALUES (100,'Jaume Lopez',38,'Gerente',654321000);
INSERT INTO `persona` VALUES (101,'Joan Marsal',38,'Project Manager',654321000);
INSERT INTO `persona` VALUES (102,'Jordi Rubio',25,'Técnico de Sistemas',6654321987);
INSERT INTO `persona` VALUES (103,'Arnau Aladid',23,'Senior Developer',987654321);
INSERT INTO `persona` VALUES (104,'Daniel Sopena',22,'Junior Developer',654321987);
INSERT INTO `persona` VALUES (105,'Luis Martinez',46,'QA Team',654321000);
INSERT INTO `persona` VALUES (106,'Laia fernandez',46,'Agente Comercial',654321000);

