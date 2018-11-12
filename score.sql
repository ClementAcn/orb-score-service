-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 12 nov. 2018 à 09:40
-- Version du serveur :  5.7.23
-- Version de PHP :  7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `orb-score`
--

-- --------------------------------------------------------

--
-- Structure de la table `score`
--

DROP TABLE IF EXISTS `score`;
CREATE TABLE IF NOT EXISTS `score` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `id_place` int(11) NOT NULL,
  `score` int(11) NOT NULL,
  `comment` varchar(255) NOT NULL,
  `creation_date` timestamp NOT NULL,
  `update_date` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `score`
--

INSERT INTO `score` (`id`, `id_user`, `id_place`, `score`, `comment`, `creation_date`, `update_date`) VALUES
(1, 14, 187, 5, 'Très bon', '2018-10-28 23:00:00', '2018-10-28 23:00:00'),
(3, 12, 100, 4, 'Excellent', '2018-11-04 23:00:00', '2018-11-04 23:00:00'),
(4, 9, 100, 2, 'Assez déçu', '2018-11-04 23:00:00', '2018-11-04 23:00:00'),
(5, 12, 187, 4, 'Entrée très bonne, plat bon, assez déçu du dessert. Dans l\'ensemble très bien.', '2018-11-06 17:30:15', '2018-11-06 17:30:15'),
(6, 9, 187, 3, 'Convenable dans l\'ensemble', '2018-11-06 17:37:54', '2018-11-06 17:37:54'),
(7, 88, 88, 1, 'HJGHR', '2018-11-07 17:54:57', '2018-11-07 17:54:57'),
(11, 9, 12, 4, 'Très bon restaurant, je recommande !', '2018-11-08 08:42:38', '2018-11-08 08:42:38'),
(12, 15, 12, 2, 'Assez déçu du restaurant, serveurs très peu aimables !', '2018-11-08 08:43:16', '2018-11-08 08:43:16');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
