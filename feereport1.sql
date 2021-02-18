-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 18, 2021 at 10:04 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `feereport1`
--

-- --------------------------------------------------------

--
-- Table structure for table `accountant`
--

CREATE TABLE `accountant` (
  `Username` int(11) NOT NULL,
  `Password` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `accountant`
--

INSERT INTO `accountant` (`Username`, `Password`) VALUES
(1234, 1234);

-- --------------------------------------------------------

--
-- Table structure for table `addaccountant`
--

CREATE TABLE `addaccountant` (
  `Name` varchar(20) NOT NULL,
  `Username` varchar(20) NOT NULL,
  `Password` int(20) NOT NULL,
  `Email` varchar(20) NOT NULL,
  `ContactNo` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `addaccountant`
--

INSERT INTO `addaccountant` (`Name`, `Username`, `Password`, `Email`, `ContactNo`) VALUES
('Mrinal', '1582', 1582, 'm@gmail.com', 628368125),
('Jasmine', '777', 777, 'jas@gmail.com', 789567);

-- --------------------------------------------------------

--
-- Table structure for table `addstudent`
--

CREATE TABLE `addstudent` (
  `Name` varchar(20) NOT NULL,
  `RollNo` int(20) NOT NULL,
  `Course` varchar(20) NOT NULL,
  `Fee` int(20) NOT NULL,
  `Paid` int(20) NOT NULL,
  `Due` int(20) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `City` varchar(20) NOT NULL,
  `State` varchar(20) NOT NULL,
  `Country` varchar(20) NOT NULL,
  `ContactNo` bigint(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `addstudent`
--

INSERT INTO `addstudent` (`Name`, `RollNo`, `Course`, `Fee`, `Paid`, `Due`, `Address`, `City`, `State`, `Country`, `ContactNo`) VALUES
('Parshant', 1, 'Java', 1100, 1100, 0, 'Indira Colony', 'Pathankot', 'Punjab', 'India', 1234567891),
('Arshi', 2, 'C', 1200, 0, 1200, 'xyz', 'x', 'y', 'India', 78790),
('Aly', 3, 'Python', 1200, 1100, 100, 'xyz', 'z', 'x', 'India', 6568);

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `Username` int(50) NOT NULL,
  `Password` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`Username`, `Password`) VALUES
(123, 123);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `addstudent`
--
ALTER TABLE `addstudent`
  ADD PRIMARY KEY (`RollNo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
