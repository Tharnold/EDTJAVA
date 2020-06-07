-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 20, 2020 at 01:41 PM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `edt`
--
CREATE DATABASE IF NOT EXISTS `edt` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `edt`;

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `email` varchar(320) CHARACTER SET ascii NOT NULL,
  `password` char(34) CHARACTER SET ascii COLLATE ascii_bin NOT NULL,
 `droit` int(10) NOT NULL, 
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;


--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`ID`, `nom`, `prenom`, `email`, `password`, `droit`) VALUES
(1, 'Salhani', 'Thomas', 'salhani.thomas@edu.ece.fr', 'aaa', 1),
(2, 'Segretinat', 'Mathieu', 'mathieu.segretinat@edu.ece.fr', 'bbb', 2),
(3, 'Arnold', 'Thibault', 'thibault.arnold@edu.ece.fr', 'ccc', 3),
(4, 'Dupont', 'Jean', 'jean.dupont@edu.ece.fr', 'ddd', 4),
(5, 'Vignau', 'Pierre', 'pierre.vignau@edu.ece.fr', 'eee', 3),
(6, 'Caillault', 'Thomas', 'thomas.caillault@edu.ece.fr', 'fff', 3),
(7, 'Robin', 'Mascle', 'robin.mascle@edu.ece.fr', 'ggg', 4),
(8, 'Maxence', 'Hardoin', 'maxence.hardouin@edu.ece.fr', 'hhh', 4);


-- --------------------------------------------------------

-- --------------------------------------------------------

--
-- Table structure for table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
CREATE TABLE IF NOT EXISTS `promotion` (
  `nom` varchar(255) NOT NULL,
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `promotion`
--

INSERT INTO `promotion` (`nom`, `ID`) VALUES
('ING1', '1'),
('ING2', '2'),
('ING3', '3');

-- --------------------------------------------------------



--
-- Table structure for table `groupe`
--

DROP TABLE IF EXISTS `groupe`;
CREATE TABLE IF NOT EXISTS `groupe` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `nom` int(30) NOT NULL,
   `IDpromotion` int(10) NOT NULL ,
  PRIMARY KEY (`ID`),
  FOREIGN KEY (IDpromotion)
  REFERENCES promotion(ID))
  ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `groupe`
--

INSERT INTO `groupe` (`ID`, `nom`, `IDpromotion`) VALUES
(1,08, 1),
(2,09, 3),
(3,01, 2),
(4,02, 2),
(5,05, 3),
(6,06, 3);

-- --------------------------------------------------------

--
-- Table structure for table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `IDutilisateur` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `IDgroupe` int(11) NOT NULL,
  PRIMARY KEY (`IDutilisateur`),
  FOREIGN KEY (`IDutilisateur`)
  REFERENCES utilisateur(`ID`),
  FOREIGN KEY (`IDgroupe`)
  REFERENCES groupe(`ID`)) 
  ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `etudiant`
--

INSERT INTO `etudiant` (`IDutilisateur`, `numero`, `IDgroupe`) VALUES

(4, 228, 2),
(7, 231, 1),
(8, 232, 3);



-- --------------------------------------------------------

--
-- Table structure for table `cours`
--

DROP TABLE IF EXISTS `cours`;
CREATE TABLE IF NOT EXISTS `cours` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cours`
--

INSERT INTO `cours` (`ID`, `nom`) VALUES
(1, 'Maths'),
(2, 'Physique'),
(3, 'Informatique');

-- --------------------------------------------------------
--
-- Table structure for table `type_cours`
--

DROP TABLE IF EXISTS `type_cours`;
CREATE TABLE IF NOT EXISTS `type_cours` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `type_cours`
--

INSERT INTO `type_cours` (`ID`,  `nom`) VALUES
(1, 'soutien'),
(2, 'projet'),
(3, 'magistral'),
(4, 'TP'),
(5, 'TD'),
(6, 'en ligne');

-- --------------------------------------------------------

--
-- Table structure for table `enseignant`
--

DROP TABLE IF EXISTS `enseignant`;
CREATE TABLE IF NOT EXISTS `enseignant` (
  `IDutilisateur` int(11) NOT NULL,
  `IDcours` int(11) NOT NULL,
  PRIMARY KEY (`IDutilisateur`, `IDcours`),
  FOREIGN KEY (`IDutilisateur`)
  REFERENCES utilisateur(`ID`),
   FOREIGN KEY (`IDcours`)
  REFERENCES cours(`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `enseignant`
--

INSERT INTO `enseignant` (`IDutilisateur`,  `IDcours`) VALUES
(3, 1),
(5, 2),
(6, 3);

-- --------------------------------------------------------
--
-- Table structure for table `site`
--

DROP TABLE IF EXISTS `site`;
CREATE TABLE IF NOT EXISTS `site` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `site`
--

INSERT INTO `site` (`ID`,`nom`) VALUES
(1, 'Eiffel1'),
(2, 'Eiffel2'),
(3, 'Eiffel3');

-- --------------------------------------------------------
-- --------------------------------------------------------
--
-- Table structure for table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `capacité` int(11) NOT NULL,
   `IDsite` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
    FOREIGN KEY (`IDsite`)
  REFERENCES site(`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `salle`
--

INSERT INTO `salle` (`ID`,  `nom`, `capacité`, `IDsite` ) VALUES
(1, 'A', 300, 1 ),
(2, 'B', 300, 1 ),
(3, 'C' , 350, 2 ),
(4, 'D' , 400, 2 ),
(5, 'E' , 450, 3 ),
(6, 'F', 500, 3   );

-- --------------------------------------------------------
-- --------------------------------------------------------
--
-- Table structure for table `seance`
--

DROP TABLE IF EXISTS `seance`;
CREATE TABLE IF NOT EXISTS `seance` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `semaine` int(11) NOT NULL ,
  `date` varchar(255) NOT NULL ,
   `heure_debut` varchar(255) NOT NULL ,
   `heure_fin` varchar(255)NOT NULL ,
   `etat` int(11) NOT NULL ,
   `IDcours` int(11) NOT NULL,
   `IDtype` int(11) NOT NULL ,
  PRIMARY KEY (`ID`),
    FOREIGN KEY (`IDcours`)
  REFERENCES cours(`ID`),
    FOREIGN KEY (`IDtype`)
  REFERENCES type_cours(`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `seance`
--

INSERT INTO `seance` (`ID`,  `semaine`, `date`, `heure_debut`, `heure_fin`, `etat`, `IDcours` , `IDtype`  ) VALUES
(1, 12, "08/09/2020", "14h","16h", 3, 1,1 ),
(2, 14, "09/10/2020","10h30", "12h", 3, 2,2 ),
(3, 16, "06/01/2021", "15h","17h", 3, 1,3 ),
(4, 30, "30/03/2021", "8h30", "10h",2, 3,4 ),
(5, 22, "08/05/2021", "14h","16h", 3, 2,5 ),
(6, 31, "12/04/2021", "18h","20h", 1, 3,6 ),
(7, 24, "26/02/2021", "11h","12h", 1, 1,3 ),
(8, 16, "18/10/2020", "10h","13h", 1, 1, 4),
(9, 4, "08/09/2020", "9h30","11h", 3, 3,2 ),
(10, 8, "25/12/2020", "8h30","10h30", 3, 2,1 );

-- --------------------------------------------------------
--
-- Table structure for table `SEANCE_GROUPE`
--

DROP TABLE IF EXISTS `SEANCE_GROUPE`;
CREATE TABLE IF NOT EXISTS `SEANCE_GROUPE` (
 `IDseance` int(11) NOT NULL,
 `IDseance1` int(11) NOT NULL,
  `IDgroupe` int(11) NOT NULL,
  PRIMARY KEY (`IDseance`, `IDseance1`, `IDgroupe`),
  FOREIGN KEY (`IDseance`)
  REFERENCES seance(`ID`),
  FOREIGN KEY (`IDseance1`)
  REFERENCES seance(`ID`),
   FOREIGN KEY (`IDgroupe`)
  REFERENCES groupe(`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SEANCE_GROUPE`
--

INSERT INTO `SEANCE_GROUPE` (`IDseance`, `IDseance1`, `IDgroupe`  ) VALUES
( 1, 2 ,1 ),
( 2, 3 ,2),
(3, 4 , 3);



COMMIT;
