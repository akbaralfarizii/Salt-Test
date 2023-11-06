-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 06, 2023 at 04:08 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `salt`
--

-- --------------------------------------------------------

--
-- Table structure for table `konsumen`
--

CREATE TABLE `konsumen` (
  `id` int(11) NOT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `kota` char(100) NOT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `provinsi` char(100) NOT NULL,
  `status` char(1) NOT NULL,
  `tgl_registrasi` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `konsumen`
--

INSERT INTO `konsumen` (`id`, `alamat`, `kota`, `nama`, `provinsi`, `status`, `tgl_registrasi`) VALUES
(6, 'Jl. Mekarwangi 30', 'bandung', 'Boby Nasi Padang', 'jawa barat', '0', '2023-11-06 22:02:04'),
(7, 'jl. Nata Endah 21', 'Bandung', 'Dede Hifz', 'Jawa Barat', '1', '2023-11-06 22:02:58'),
(8, 'Jl. Bukit Bunga 112', 'Bandung', 'Ridho Emir', 'jawa barat', '1', '2023-11-06 22:03:25'),
(9, 'Jl. gading barat 21', 'Bandung', 'Rafli Surya', 'Jawa Barat', '0', '2023-11-06 22:03:54'),
(10, 'Jl. Pangipasan 40', 'Bandung', 'Dilla Sri', 'Jawa Barat', '1', '2023-11-06 22:04:29'),
(11, 'Jl. Warung Lobak 231', 'Bandung', 'Anisa Nanda', 'Jawa Barat', '1', '2023-11-06 22:04:49'),
(12, 'Jl. Cincin Permai 321', 'Bandung', 'Fikri Amir', 'Jawa Barat', '0', '2023-11-06 22:05:14'),
(13, 'Jl. Cijagra 32', 'Bandung', 'Rahma Khoir', 'Jawa Barat', '1', '2023-11-06 22:05:42'),
(14, 'Jl. Cincin Permai 323', 'Bandung', 'Raihan Maulana', 'Jawa Barat', '1', '2023-11-06 22:05:59'),
(15, 'Jl. Kopo 423', 'Bandung', 'Farhan Nuansa', 'Jawa Barat', '1', '2023-11-06 22:06:26'),
(16, 'Jl. Cimenyan 32', 'Garut', 'Melvin Bahrul', 'jawa barat', '0', '2023-11-06 22:07:02');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `konsumen`
--
ALTER TABLE `konsumen`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `konsumen`
--
ALTER TABLE `konsumen`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
