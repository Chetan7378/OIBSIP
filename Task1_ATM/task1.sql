-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 12, 2023 at 05:15 AM
-- Server version: 5.5.39
-- PHP Version: 5.4.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `task1`
--

-- --------------------------------------------------------

--
-- Table structure for table `transation`
--

CREATE TABLE IF NOT EXISTS `transation` (
  `cid` int(100) NOT NULL,
  `date` varchar(100) NOT NULL,
  `type` varchar(100) NOT NULL,
  `amt` int(100) NOT NULL,
  `balance` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transation`
--

INSERT INTO `transation` (`cid`, `date`, `type`, `amt`, `balance`) VALUES
(100, 'Sat Feb 11 21:34:39 IST 2023', 'Credit', 500, 20700),
(100, 'Sat Feb 11 22:05:51 IST 2023', 'Transfer', 4000, 16700),
(100, 'Sat Feb 11 22:18:35 IST 2023', 'Withdraw', 10000, 6700),
(100, 'Sat Feb 11 23:03:13 IST 2023', 'Credit', 500, 7200),
(100, 'Sat Feb 11 23:04:07 IST 2023', 'Transfer', 500, 6700),
(1003, 'Sat Feb 11 23:30:18 IST 2023', 'Credit', 600, 8600),
(100, 'Sun Feb 12 09:23:26 IST 2023', 'Transfer', 1200, 5500);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `cid` int(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `pwd` varchar(100) NOT NULL,
  `acc` bigint(100) NOT NULL,
  `balance` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`cid`, `name`, `pwd`, `acc`, `balance`) VALUES
(100, 'chetan shivade', 'chetan12', 2992, 5500),
(1003, 'karan', 'karan13', 1343, 9800);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
