-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-11-2018 a las 22:32:49
-- Versión del servidor: 10.1.36-MariaDB
-- Versión de PHP: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `inmobiliaria`
--
CREATE DATABASE IF NOT EXISTS `inmobiliaria` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `inmobiliaria`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alquiler`
--
-- Creación: 27-11-2018 a las 17:25:49
--

DROP TABLE IF EXISTS `alquiler`;
CREATE TABLE `alquiler` (
  `id_inmueble` int(11) NOT NULL,
  `id_persona` int(11) NOT NULL,
  `costo` double NOT NULL,
  `fechaInicio` datetime(6) NOT NULL,
  `finContrato` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELACIONES PARA LA TABLA `alquiler`:
--   `id_inmueble`
--       `inmueble` -> `id_inmueble`
--   `id_persona`
--       `personas` -> `id_persona`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inmueble`
--
-- Creación: 24-11-2018 a las 17:23:14
--

DROP TABLE IF EXISTS `inmueble`;
CREATE TABLE `inmueble` (
  `id_inmueble` int(11) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `cantAmbientes` varchar(20) NOT NULL,
  `costo` int(11) NOT NULL,
  `disponible` tinyint(1) NOT NULL,
  `propietario` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELACIONES PARA LA TABLA `inmueble`:
--   `propietario`
--       `personas` -> `id_propietario`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personas`
--
-- Creación: 24-11-2018 a las 17:52:01
--

DROP TABLE IF EXISTS `personas`;
CREATE TABLE `personas` (
  `id_persona` int(20) NOT NULL,
  `nombreCompleto` varchar(40) NOT NULL,
  `dni` varchar(40) NOT NULL,
  `celular` varchar(40) NOT NULL,
  `id_propietario` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELACIONES PARA LA TABLA `personas`:
--

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alquiler`
--
ALTER TABLE `alquiler`
  ADD PRIMARY KEY (`id_inmueble`,`id_persona`),
  ADD KEY `id_persona` (`id_persona`);

--
-- Indices de la tabla `inmueble`
--
ALTER TABLE `inmueble`
  ADD PRIMARY KEY (`id_inmueble`),
  ADD KEY `propietario` (`propietario`);

--
-- Indices de la tabla `personas`
--
ALTER TABLE `personas`
  ADD PRIMARY KEY (`id_persona`),
  ADD KEY `id_propietario` (`id_propietario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `inmueble`
--
ALTER TABLE `inmueble`
  MODIFY `id_inmueble` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `personas`
--
ALTER TABLE `personas`
  MODIFY `id_persona` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alquiler`
--
ALTER TABLE `alquiler`
  ADD CONSTRAINT `alquiler_ibfk_1` FOREIGN KEY (`id_persona`) REFERENCES `personas` (`id_persona`);

--
-- Filtros para la tabla `inmueble`
--
ALTER TABLE `inmueble`
  ADD CONSTRAINT `inmueble_ibfk_1` FOREIGN KEY (`propietario`) REFERENCES `personas` (`id_propietario`);


--
-- Metadatos
--
USE `phpmyadmin`;

--
-- Metadatos para la tabla alquiler
--

--
-- Metadatos para la tabla inmueble
--

--
-- Metadatos para la tabla personas
--

--
-- Metadatos para la base de datos inmobiliaria
--

--
-- Volcado de datos para la tabla `pma__relation`
--

INSERT INTO `pma__relation` (`master_db`, `master_table`, `master_field`, `foreign_db`, `foreign_table`, `foreign_field`) VALUES
('inmobiliaria', 'alquiler', 'id_inmueble', 'inmobiliaria', 'inmueble', 'id_inmueble');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
