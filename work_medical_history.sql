-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 29, 2023 at 12:25 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `work_medical_history`
--

-- --------------------------------------------------------

--
-- Table structure for table `ability_file`
--

CREATE TABLE `ability_file` (
  `ID` int(11) NOT NULL,
  `Employee_CNP` varchar(13) NOT NULL,
  `Medical_History_Description` varchar(100) NOT NULL,
  `Recent_Medical_Events_Description` varchar(100) NOT NULL,
  `Blood_Pressure` varchar(50) NOT NULL,
  `Ophthalmological_Consultation` varchar(50) NOT NULL,
  `Pulse` varchar(50) NOT NULL,
  `Oxygen_Saturation` varchar(50) NOT NULL,
  `Date` date NOT NULL,
  `Building` varchar(50) NOT NULL,
  `Street` varchar(50) NOT NULL,
  `City` varchar(50) NOT NULL,
  `County` varchar(50) NOT NULL,
  `Doctor` varchar(50) NOT NULL,
  `Doctor_Phone_Number` varchar(10) NOT NULL,
  `Result` varchar(50) DEFAULT NULL,
  `Doctor_Email` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `administrator`
--

CREATE TABLE `administrator` (
  `CNP` varchar(13) NOT NULL,
  `Surname` varchar(50) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `County` varchar(50) NOT NULL,
  `City` varchar(50) NOT NULL,
  `Phone_Number` varchar(10) NOT NULL,
  `Gender` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `CNP` varchar(13) NOT NULL,
  `Surname` varchar(50) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `County` varchar(50) NOT NULL,
  `City` varchar(50) NOT NULL,
  `Phone_Number` varchar(10) NOT NULL,
  `Gender` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `CNP` varchar(13) NOT NULL,
  `Surname` varchar(50) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `County` varchar(50) NOT NULL,
  `City` varchar(50) NOT NULL,
  `Role` varchar(50) NOT NULL,
  `Phone_Number` varchar(10) NOT NULL,
  `Gender` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `health_certificate`
--

CREATE TABLE `health_certificate` (
  `ID` int(11) NOT NULL,
  `Employee_CNP` varchar(13) NOT NULL,
  `Sickness` varchar(50) NOT NULL,
  `Recommendations` varchar(50) NOT NULL,
  `Date` date NOT NULL,
  `Building` varchar(50) NOT NULL,
  `Street` varchar(50) NOT NULL,
  `City` varchar(50) NOT NULL,
  `County` varchar(50) NOT NULL,
  `Doctor` varchar(50) NOT NULL,
  `Doctor_Phone_Number` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `hiring_lab_analysis`
--

CREATE TABLE `hiring_lab_analysis` (
  `ID` int(11) NOT NULL,
  `Medical_File_ID` int(11) NOT NULL,
  `Employee_CNP` varchar(13) NOT NULL,
  `Type` varchar(50) NOT NULL,
  `Results` varchar(50) NOT NULL,
  `Date` date NOT NULL,
  `Building` varchar(50) NOT NULL,
  `Street` varchar(50) NOT NULL,
  `City` varchar(50) NOT NULL,
  `County` varchar(50) NOT NULL,
  `Doctor` varchar(50) NOT NULL,
  `Doctor_Phone_Number` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `hiring_vaccines`
--

CREATE TABLE `hiring_vaccines` (
  `ID` int(11) NOT NULL,
  `Medical_File_ID` int(11) NOT NULL,
  `Employee_CNP` varchar(13) NOT NULL,
  `Type` varchar(50) NOT NULL,
  `Date` date NOT NULL,
  `Building` varchar(50) NOT NULL,
  `Street` varchar(50) NOT NULL,
  `City` varchar(50) NOT NULL,
  `County` varchar(50) NOT NULL,
  `Doctor` varchar(50) NOT NULL,
  `Doctor_Phone_Number` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `medical_file`
--

CREATE TABLE `medical_file` (
  `ID` int(11) NOT NULL,
  `Employee_CNP` varchar(13) NOT NULL,
  `Date` date NOT NULL,
  `Building` varchar(50) NOT NULL,
  `Street` varchar(50) NOT NULL,
  `City` varchar(50) NOT NULL,
  `County` varchar(50) NOT NULL,
  `Doctor` varchar(50) NOT NULL,
  `Doctor_Phone_Number` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `medical_history`
--

CREATE TABLE `medical_history` (
  `ID` int(11) NOT NULL,
  `Medical_File_ID` int(11) NOT NULL,
  `Employee_CNP` varchar(13) NOT NULL,
  `Sickness` varchar(50) NOT NULL,
  `Severity` varchar(50) NOT NULL,
  `Date` date NOT NULL,
  `Longevity` varchar(50) NOT NULL,
  `Building` varchar(50) NOT NULL,
  `Street` varchar(50) NOT NULL,
  `City` varchar(50) NOT NULL,
  `County` varchar(50) NOT NULL,
  `Doctor` varchar(50) NOT NULL,
  `Doctor_Phone_Number` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `medical_vacation`
--

CREATE TABLE `medical_vacation` (
  `ID` int(11) NOT NULL,
  `Employee_CNP` varchar(13) NOT NULL,
  `Boss_Email` varchar(50) NOT NULL,
  `Start_Date` date NOT NULL,
  `End_Date` date NOT NULL,
  `Period` varchar(50) NOT NULL,
  `Reason` varchar(50) NOT NULL,
  `Building` varchar(50) NOT NULL,
  `Street` varchar(50) NOT NULL,
  `City` varchar(50) NOT NULL,
  `County` varchar(50) NOT NULL,
  `Doctor` varchar(50) NOT NULL,
  `Doctor_Phone_Number` varchar(10) NOT NULL,
  `Approval` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `risks_file`
--

CREATE TABLE `risks_file` (
  `ID` int(11) NOT NULL,
  `Employee_CNP` varchar(13) NOT NULL,
  `File_ID` int(11) NOT NULL,
  `Description` varchar(100) NOT NULL,
  `Chance` varchar(50) NOT NULL,
  `Recommendations` varchar(50) NOT NULL,
  `Date` date NOT NULL,
  `Building` varchar(50) NOT NULL,
  `Street` varchar(50) NOT NULL,
  `City` varchar(50) NOT NULL,
  `County` varchar(50) NOT NULL,
  `Doctor` varchar(50) NOT NULL,
  `Doctor_Phone_Number` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `yearly_health_evaluation`
--

CREATE TABLE `yearly_health_evaluation` (
  `ID` int(11) NOT NULL,
  `Employee_CNP` varchar(13) NOT NULL,
  `Medical_History_Description` varchar(100) NOT NULL,
  `Recent_Medical_Events_Description` varchar(100) NOT NULL,
  `Blood_Pressure` varchar(50) NOT NULL,
  `Ophthalmological_Consultation` varchar(50) NOT NULL,
  `Pulse` varchar(50) NOT NULL,
  `Oxygen_Saturation` varchar(50) NOT NULL,
  `Date` date NOT NULL,
  `Building` varchar(50) NOT NULL,
  `Street` varchar(50) NOT NULL,
  `City` varchar(50) NOT NULL,
  `County` varchar(50) NOT NULL,
  `Doctor` varchar(50) NOT NULL,
  `Doctor_Phone_Number` varchar(10) NOT NULL,
  `Doctor_Email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `yearly_psychological_test`
--

CREATE TABLE `yearly_psychological_test` (
  `ID` int(11) NOT NULL,
  `Employee_CNP` varchar(13) NOT NULL,
  `Role` varchar(50) NOT NULL,
  `Type` varchar(50) NOT NULL,
  `Results` varchar(50) NOT NULL,
  `Date` date NOT NULL,
  `Building` varchar(50) NOT NULL,
  `Street` varchar(50) NOT NULL,
  `City` varchar(50) NOT NULL,
  `County` varchar(50) NOT NULL,
  `Doctor` varchar(50) NOT NULL,
  `Doctor_Phone_Number` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ability_file`
--
ALTER TABLE `ability_file`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Employee_CNP` (`Employee_CNP`),
  ADD KEY `Doctor_E-mail` (`Doctor_Email`),
  ADD KEY `Doctor_Phone_Number` (`Doctor_Phone_Number`);

--
-- Indexes for table `administrator`
--
ALTER TABLE `administrator`
  ADD PRIMARY KEY (`CNP`),
  ADD UNIQUE KEY `Phone_number` (`Phone_Number`),
  ADD UNIQUE KEY `E-mail` (`Email`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`CNP`),
  ADD UNIQUE KEY `E-mail` (`Email`),
  ADD UNIQUE KEY `Phone_number` (`Phone_Number`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`CNP`),
  ADD UNIQUE KEY `E-mail` (`Email`),
  ADD UNIQUE KEY `Phone_number` (`Phone_Number`);

--
-- Indexes for table `health_certificate`
--
ALTER TABLE `health_certificate`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Employee_CNP` (`Employee_CNP`);

--
-- Indexes for table `hiring_lab_analysis`
--
ALTER TABLE `hiring_lab_analysis`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Employee_CNP` (`Employee_CNP`),
  ADD KEY `Medical_file_ID` (`Medical_File_ID`);

--
-- Indexes for table `hiring_vaccines`
--
ALTER TABLE `hiring_vaccines`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Employee_CNP` (`Employee_CNP`),
  ADD KEY `Medical_file_ID` (`Medical_File_ID`);

--
-- Indexes for table `medical_file`
--
ALTER TABLE `medical_file`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `Employee_CNP` (`Employee_CNP`);

--
-- Indexes for table `medical_history`
--
ALTER TABLE `medical_history`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Employee_CNP` (`Employee_CNP`),
  ADD KEY `Medical_file_ID` (`Medical_File_ID`);

--
-- Indexes for table `medical_vacation`
--
ALTER TABLE `medical_vacation`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Employee_CNP` (`Employee_CNP`),
  ADD KEY `Boss_E-mail` (`Boss_Email`);

--
-- Indexes for table `risks_file`
--
ALTER TABLE `risks_file`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Employee_CNP` (`Employee_CNP`);

--
-- Indexes for table `yearly_health_evaluation`
--
ALTER TABLE `yearly_health_evaluation`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Employee_CNP` (`Employee_CNP`),
  ADD KEY `Doctor_E-mail` (`Doctor_Email`),
  ADD KEY `Doctor_Phone_Number` (`Doctor_Phone_Number`);

--
-- Indexes for table `yearly_psychological_test`
--
ALTER TABLE `yearly_psychological_test`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Employee_CNP` (`Employee_CNP`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ability_file`
--
ALTER TABLE `ability_file`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `health_certificate`
--
ALTER TABLE `health_certificate`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `hiring_lab_analysis`
--
ALTER TABLE `hiring_lab_analysis`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `hiring_vaccines`
--
ALTER TABLE `hiring_vaccines`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `medical_file`
--
ALTER TABLE `medical_file`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `medical_history`
--
ALTER TABLE `medical_history`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `medical_vacation`
--
ALTER TABLE `medical_vacation`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `risks_file`
--
ALTER TABLE `risks_file`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `yearly_health_evaluation`
--
ALTER TABLE `yearly_health_evaluation`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `yearly_psychological_test`
--
ALTER TABLE `yearly_psychological_test`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ability_file`
--
ALTER TABLE `ability_file`
  ADD CONSTRAINT `ability_file_ibfk_1` FOREIGN KEY (`Doctor_Email`) REFERENCES `doctor` (`Email`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `ability_file_ibfk_2` FOREIGN KEY (`Employee_CNP`) REFERENCES `employee` (`CNP`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `health_certificate`
--
ALTER TABLE `health_certificate`
  ADD CONSTRAINT `health_certificate_ibfk_1` FOREIGN KEY (`Employee_CNP`) REFERENCES `employee` (`CNP`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `hiring_lab_analysis`
--
ALTER TABLE `hiring_lab_analysis`
  ADD CONSTRAINT `hiring_lab_analysis_ibfk_1` FOREIGN KEY (`Employee_CNP`) REFERENCES `employee` (`CNP`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `hiring_lab_analysis_ibfk_2` FOREIGN KEY (`Medical_file_ID`) REFERENCES `medical_file` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `hiring_vaccines`
--
ALTER TABLE `hiring_vaccines`
  ADD CONSTRAINT `hiring_vaccines_ibfk_1` FOREIGN KEY (`Employee_CNP`) REFERENCES `employee` (`CNP`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `hiring_vaccines_ibfk_2` FOREIGN KEY (`Medical_file_ID`) REFERENCES `medical_file` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `medical_file`
--
ALTER TABLE `medical_file`
  ADD CONSTRAINT `medical_file_ibfk_1` FOREIGN KEY (`Employee_CNP`) REFERENCES `employee` (`CNP`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `medical_history`
--
ALTER TABLE `medical_history`
  ADD CONSTRAINT `medical_history_ibfk_1` FOREIGN KEY (`Employee_CNP`) REFERENCES `employee` (`CNP`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `medical_history_ibfk_2` FOREIGN KEY (`Medical_file_ID`) REFERENCES `medical_file` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `medical_vacation`
--
ALTER TABLE `medical_vacation`
  ADD CONSTRAINT `medical_vacation_ibfk_1` FOREIGN KEY (`Boss_Email`) REFERENCES `employee` (`Email`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `medical_vacation_ibfk_2` FOREIGN KEY (`Employee_CNP`) REFERENCES `employee` (`CNP`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `risks_file`
--
ALTER TABLE `risks_file`
  ADD CONSTRAINT `risks_file_ibfk_1` FOREIGN KEY (`Employee_CNP`) REFERENCES `employee` (`CNP`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `yearly_health_evaluation`
--
ALTER TABLE `yearly_health_evaluation`
  ADD CONSTRAINT `yearly_health_evaluation_ibfk_1` FOREIGN KEY (`Doctor_Email`) REFERENCES `doctor` (`Email`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `yearly_health_evaluation_ibfk_2` FOREIGN KEY (`Employee_CNP`) REFERENCES `employee` (`CNP`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `yearly_psychological_test`
--
ALTER TABLE `yearly_psychological_test`
  ADD CONSTRAINT `yearly_psychological_test_ibfk_1` FOREIGN KEY (`Employee_CNP`) REFERENCES `employee` (`CNP`) ON DELETE NO ACTION ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
