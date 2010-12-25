-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.50-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema ptdb
--

CREATE DATABASE IF NOT EXISTS ptdb;
USE ptdb;

--
-- Definition of table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
CREATE TABLE `alumno` (
  `ALUM_DNI` int(11) NOT NULL,
  `ALUM_PASS` varchar(255) DEFAULT NULL,
  `ALUM_NOM` varchar(255) NOT NULL,
  `ALUM_TLF` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ALUM_DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `alumno`
--

/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` (`ALUM_DNI`,`ALUM_PASS`,`ALUM_NOM`,`ALUM_TLF`) VALUES 
 (56712037,'3333','Pepito','944672065'),
 (56712038,'2222','Patricia','944672006'),
 (78653209,'1111','Juan','944875631');
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;


--
-- Definition of table `asignatura`
--

DROP TABLE IF EXISTS `asignatura`;
CREATE TABLE `asignatura` (
  `ASIG_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ASIG_COD` int(11) NOT NULL,
  `ASIG_NOM` varchar(255) NOT NULL,
  `ASIG_CRED` float DEFAULT NULL,
  `ASIG_PROF` int(11) DEFAULT NULL,
  PRIMARY KEY (`ASIG_ID`),
  UNIQUE KEY `ASIG_COD` (`ASIG_COD`),
  KEY `FKECBB617346B17C21` (`ASIG_PROF`),
  CONSTRAINT `FKECBB617346B17C21` FOREIGN KEY (`ASIG_PROF`) REFERENCES `profesor` (`PROF_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `asignatura`
--

/*!40000 ALTER TABLE `asignatura` DISABLE KEYS */;
INSERT INTO `asignatura` (`ASIG_ID`,`ASIG_COD`,`ASIG_NOM`,`ASIG_CRED`,`ASIG_PROF`) VALUES 
 (1,11,'Ingeniería del Software III',9,1),
 (2,22,'Iinteligencia Artificial',9,2),
 (3,33,'Evaluación y Diseño de Redes',7,3);
/*!40000 ALTER TABLE `asignatura` ENABLE KEYS */;


--
-- Definition of table `evaluacion`
--

DROP TABLE IF EXISTS `evaluacion`;
CREATE TABLE `evaluacion` (
  `EV_ID` int(11) NOT NULL AUTO_INCREMENT,
  `EV_CONCEP` varchar(255) NOT NULL,
  `EV_NOTA` float NOT NULL,
  `ALUM_DNI` int(11) NOT NULL,
  `ASIG_ID` int(11) NOT NULL,
  PRIMARY KEY (`EV_ID`),
  KEY `FK500E38ED2351A56C` (`ASIG_ID`),
  KEY `FK500E38EDC476F076` (`ALUM_DNI`),
  CONSTRAINT `FK500E38EDC476F076` FOREIGN KEY (`ALUM_DNI`) REFERENCES `alumno` (`ALUM_DNI`),
  CONSTRAINT `FK500E38ED2351A56C` FOREIGN KEY (`ASIG_ID`) REFERENCES `asignatura` (`ASIG_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `evaluacion`
--

/*!40000 ALTER TABLE `evaluacion` DISABLE KEYS */;
INSERT INTO `evaluacion` (`EV_ID`,`EV_CONCEP`,`EV_NOTA`,`ALUM_DNI`,`ASIG_ID`) VALUES 
 (1,'Ordinaria',9.9,78653209,2),
 (2,'Ordinaria',8.9,78653209,1),
 (3,'Ordinaria',4.3,56712038,2),
 (4,'Extraordinaria',6.5,56712038,2),
 (5,'Ordinaria',9,56712037,1);
/*!40000 ALTER TABLE `evaluacion` ENABLE KEYS */;


--
-- Definition of table `matriculaciones`
--

DROP TABLE IF EXISTS `matriculaciones`;
CREATE TABLE `matriculaciones` (
  `ASIG_ID` int(11) NOT NULL,
  `ALUM_DNI` int(11) NOT NULL,
  PRIMARY KEY (`ALUM_DNI`,`ASIG_ID`),
  KEY `FK75298B112351A56C` (`ASIG_ID`),
  KEY `FK75298B11C476F076` (`ALUM_DNI`),
  CONSTRAINT `FK75298B11C476F076` FOREIGN KEY (`ALUM_DNI`) REFERENCES `alumno` (`ALUM_DNI`),
  CONSTRAINT `FK75298B112351A56C` FOREIGN KEY (`ASIG_ID`) REFERENCES `asignatura` (`ASIG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `matriculaciones`
--

/*!40000 ALTER TABLE `matriculaciones` DISABLE KEYS */;
INSERT INTO `matriculaciones` (`ASIG_ID`,`ALUM_DNI`) VALUES 
 (1,56712037),
 (1,78653209),
 (2,56712037),
 (2,56712038),
 (2,78653209),
 (3,56712037);
/*!40000 ALTER TABLE `matriculaciones` ENABLE KEYS */;


--
-- Definition of table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
CREATE TABLE `profesor` (
  `PROF_ID` int(11) NOT NULL AUTO_INCREMENT,
  `PROF_DNI` int(11) DEFAULT NULL,
  `PROF_PASS` varchar(255) DEFAULT NULL,
  `PROF_NOM` varchar(255) NOT NULL,
  `PROF_TLF` varchar(255) DEFAULT NULL,
  `PROF_EMAIL` varchar(255) DEFAULT NULL,
  `PROF_DESP` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`PROF_ID`),
  UNIQUE KEY `PROF_NOM` (`PROF_NOM`),
  UNIQUE KEY `PROF_DNI` (`PROF_DNI`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `profesor`
--

/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
INSERT INTO `profesor` (`PROF_ID`,`PROF_DNI`,`PROF_PASS`,`PROF_NOM`,`PROF_TLF`,`PROF_EMAIL`,`PROF_DESP`) VALUES 
 (1,45821905,'1111','Diego López de Ipiña','944678535','dipina@deusto.es','DeustoTech'),
 (2,76519434,'2222','Roberto Carballedo','944673909','carballedo@deusto.es','567'),
 (3,36942752,'3333','Ana Belén Lago','944673909','ablago@deusto.es','decanato');
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;


--
-- Definition of table `unidad`
--

DROP TABLE IF EXISTS `unidad`;
CREATE TABLE `unidad` (
  `UNI_ID` int(11) NOT NULL AUTO_INCREMENT,
  `UNI_ACRO` varchar(255) NOT NULL,
  `UNI_TITULO` varchar(255) NOT NULL,
  `UNI_CONT` varchar(255) DEFAULT NULL,
  `ASIG_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`UNI_ID`),
  UNIQUE KEY `UNI_ACRO` (`UNI_ACRO`),
  KEY `FK95794C972351A56C` (`ASIG_ID`),
  CONSTRAINT `FK95794C972351A56C` FOREIGN KEY (`ASIG_ID`) REFERENCES `asignatura` (`ASIG_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `unidad`
--

/*!40000 ALTER TABLE `unidad` DISABLE KEYS */;
INSERT INTO `unidad` (`UNI_ID`,`UNI_ACRO`,`UNI_TITULO`,`UNI_CONT`,`ASIG_ID`) VALUES 
 (1,'ISO3-T2','Hibernate','Persistencia',1),
 (2,'ISO3-T1','Introduccion','Introduccion',1),
 (3,'IA-T2','Euristicas','Euristicas de diseño',2),
 (4,'IA-T1','Introduccion','Introduccion',2),
 (5,'EDR-T2','Redes LAN','Diseño de redes',3),
 (6,'EDR-T1','Redes WAN','Diseño de redes',3);
/*!40000 ALTER TABLE `unidad` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
