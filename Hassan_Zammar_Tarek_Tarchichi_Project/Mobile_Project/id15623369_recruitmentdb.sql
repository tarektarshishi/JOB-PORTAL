-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jan 01, 2021 at 02:56 PM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id15623369_recruitmentdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `Company`
--

CREATE TABLE `Company` (
  `CID` int(11) NOT NULL,
  `Cname` varchar(80) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Email` varchar(80) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Cphone` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Job`
--

CREATE TABLE `Job` (
  `JID` int(11) NOT NULL,
  `Jtitle` varchar(80) COLLATE utf8_unicode_ci NOT NULL,
  `Jdescription` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `Jaddress` varchar(80) COLLATE utf8_unicode_ci NOT NULL,
  `Posted_On` date DEFAULT NULL,
  `C_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Company`
--
ALTER TABLE `Company`
  ADD PRIMARY KEY (`CID`);

--
-- Indexes for table `Job`
--
ALTER TABLE `Job`
  ADD PRIMARY KEY (`JID`),
  ADD KEY `C_ID` (`C_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Job`
--
ALTER TABLE `Job`
  MODIFY `JID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Job`
--
ALTER TABLE `Job`
  ADD CONSTRAINT `Job_ibfk_1` FOREIGN KEY (`C_ID`) REFERENCES `Company` (`CID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
