-- phpMyAdmin SQL Dump
-- version 3.3.8
-- http://www.phpmyadmin.net
--
-- Serveur: 127.0.0.1
-- Généré le : Mer 19 Novembre 2014 à 12:58
-- Version du serveur: 5.1.52
-- Version de PHP: 5.3.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `bdstation`
--

-- --------------------------------------------------------

--
-- Structure de la table `borne`
--

CREATE TABLE IF NOT EXISTS `borne` (
  `idBorne` int(11) NOT NULL AUTO_INCREMENT,
  `dateMiseEnService` varchar(10) NOT NULL,
  `idStation` int(11) NOT NULL,
  `codeTypeCharge` int(11) NOT NULL,
  `etat` varchar(2) NOT NULL,
  PRIMARY KEY (`idBorne`),
  KEY `codeTypeCharge` (`codeTypeCharge`),
  KEY `idStation` (`idStation`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `borne`
--

INSERT INTO `borne` (`idBorne`, `dateMiseEnService`, `idStation`, `codeTypeCharge`, `etat`) VALUES
(1, '12/12/2010', 1, 1, 'ES'),
(2, '12/12/2011', 1, 2, 'ES'),
(3, '25/02/2012', 2, 1, 'ES'),
(4, '15/02/2012', 2, 2, 'ES'),
(5, '15/08/2014', 2, 3, 'HS');

-- --------------------------------------------------------

--
-- Structure de la table `station`
--

CREATE TABLE IF NOT EXISTS `station` (
  `idStation` int(11) NOT NULL AUTO_INCREMENT,
  `libelleEmplacement` varchar(80) NOT NULL,
  PRIMARY KEY (`idStation`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `station`
--

INSERT INTO `station` (`idStation`, `libelleEmplacement`) VALUES
(1, 'Gare MontParnasse'),
(2, 'Gare du Nord'),
(3, 'Gare de l''Est');

-- --------------------------------------------------------

--
-- Structure de la table `typecharge`
--

CREATE TABLE IF NOT EXISTS `typecharge` (
  `codeTypeCharge` int(11) NOT NULL AUTO_INCREMENT,
  `libelleTypeCharge` varchar(30) NOT NULL,
  `puissanceTypeCharge` int(11) NOT NULL,
  PRIMARY KEY (`codeTypeCharge`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `typecharge`
--

INSERT INTO `typecharge` (`codeTypeCharge`, `libelleTypeCharge`, `puissanceTypeCharge`) VALUES
(1, 'recharge normale', 3),
(2, 'semi-rapide', 24),
(3, 'recharge rapide', 50);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `borne`
--
ALTER TABLE `borne`
  ADD CONSTRAINT `borne_ibfk_1` FOREIGN KEY (`idStation`) REFERENCES `station` (`idStation`),
  ADD CONSTRAINT `borne_ibfk_2` FOREIGN KEY (`codeTypeCharge`) REFERENCES `typecharge` (`codeTypeCharge`);
