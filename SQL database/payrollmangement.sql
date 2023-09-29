-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 29, 2023 at 10:35 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `payrollmangement`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `UId` varchar(20) NOT NULL,
  `Pass` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`UId`, `Pass`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `empid` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `month` varchar(255) NOT NULL,
  `year` varchar(255) NOT NULL,
  `total_leave` varchar(255) DEFAULT NULL,
  `sick_leave` varchar(255) DEFAULT NULL,
  `casual_leave` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`empid`, `name`, `month`, `year`, `total_leave`, `sick_leave`, `casual_leave`) VALUES
(1, 'Yash', 'January', '2022', '1', '2', '1'),
(1, 'Yash', 'February', '2022', '2', '4', '2'),
(1, 'Yash', 'March', '2022', '2', '5', '3');

-- --------------------------------------------------------

--
-- Table structure for table `employeedetails`
--

CREATE TABLE `employeedetails` (
  `empid` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `dob` date DEFAULT NULL,
  `fname` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `permanent_address` varchar(255) DEFAULT NULL,
  `mobile` varchar(15) DEFAULT NULL,
  `eme_mobile` varchar(15) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `basic_salary` decimal(10,2) DEFAULT NULL,
  `date_of_joining` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `employeedetails`
--

INSERT INTO `employeedetails` (`empid`, `name`, `dob`, `fname`, `address`, `permanent_address`, `mobile`, `eme_mobile`, `department`, `role`, `basic_salary`, `date_of_joining`) VALUES
(1, 'Yash', '2001-03-27', 'Brij Kumar Sharma', 'Shiv vihar Delhi', 'BHatipura Garh Road Meerut', '8171136156', '9758545145', 'Java Full Stack', 'Software Developer', 25000.00, '2022-01-01'),
(2, 'Rama Shankar', '2000-09-16', 'Daya Shankar', 'street of Delhi', 'azamgarh', '123456789', '987654321', 'Java Full Stack', 'Software Developer', 25000.00, '2022-01-01');

-- --------------------------------------------------------

--
-- Table structure for table `salary`
--

CREATE TABLE `salary` (
  `empid` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `month` varchar(255) DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL,
  `total_leave` int(11) DEFAULT NULL,
  `sick_leave` int(11) DEFAULT NULL,
  `casual_leave` int(11) DEFAULT NULL,
  `basic_salary` int(11) DEFAULT NULL,
  `da` int(11) DEFAULT NULL,
  `esi` int(11) DEFAULT NULL,
  `pf` int(11) DEFAULT NULL,
  `package1` int(11) DEFAULT NULL,
  `tds_Tax` int(11) DEFAULT NULL,
  `total_salary` int(11) DEFAULT NULL,
  `exceed_leave` int(11) DEFAULT NULL,
  `final_salary` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `salary`
--

INSERT INTO `salary` (`empid`, `name`, `month`, `year`, `total_leave`, `sick_leave`, `casual_leave`, `basic_salary`, `da`, `esi`, `pf`, `package1`, `tds_Tax`, `total_salary`, `exceed_leave`, `final_salary`) VALUES
(1, 'Yash', 'January', '2022', 1, 2, 1, 25000, 12500, 500, 1500, 426000, 12600, 34450, -2, 34450),
(1, 'Yash', 'February', '2022', 2, 4, 2, 25000, 12500, 500, 1500, 426000, 12600, 34450, -4, 34450),
(1, 'Yash', 'March', '2022', 2, 5, 3, 25000, 12500, 500, 1500, 426000, 12600, 34450, -6, 34450);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employeedetails`
--
ALTER TABLE `employeedetails`
  ADD PRIMARY KEY (`empid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employeedetails`
--
ALTER TABLE `employeedetails`
  MODIFY `empid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
