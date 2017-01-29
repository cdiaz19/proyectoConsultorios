-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 29-01-2017 a las 04:07:59
-- Versión del servidor: 5.6.26-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `proyectoconsultorio`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `appointment`
--

CREATE TABLE IF NOT EXISTS `appointment` (
  `id_appointment` int(11) NOT NULL AUTO_INCREMENT,
  `id_office` int(11) NOT NULL,
  `id_patient` int(11) NOT NULL,
  `date` text NOT NULL,
  `hour` text NOT NULL,
  PRIMARY KEY (`id_appointment`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `appointment`
--

INSERT INTO `appointment` (`id_appointment`, `id_office`, `id_patient`, `date`, `hour`) VALUES
(1, 3, 1, '30-01-2017', '4:30 pm'),
(2, 4, 2, '30-01-2017', '4:30 pm'),
(3, 5, 3, '30-01-2017', '4:30 pm'),
(4, 10, 7, '30-01-2017', '4:30 pm'),
(5, 11, 8, '30-01-2017', '4:30 pm'),
(6, 12, 9, '30-01-2017', '4:30 pm');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `office`
--

CREATE TABLE IF NOT EXISTS `office` (
  `id_office` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `phone` text NOT NULL,
  `days` text NOT NULL,
  `hourStart` text NOT NULL,
  `hourEnd` text NOT NULL,
  PRIMARY KEY (`id_office`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Volcado de datos para la tabla `office`
--

INSERT INTO `office` (`id_office`, `name`, `phone`, `days`, `hourStart`, `hourEnd`) VALUES
(1, 'Nueva Clinica Tres Rios', '22795122', 'Miercoles', '8:00', '5:00'),
(2, 'Hospital CIMA', '22795122', 'Lunes y Martes', '8:00', '5:00'),
(3, 'Hospital CIMA', '22795122', 'Lunes y Martes', '8:00', '5:00'),
(4, 'Hospital CIMA', '22795122', 'Lunes y Martes', '8:00', '5:00'),
(5, 'Hospital CIMA', '22795122', 'Lunes y Martes', '8:00', '5:00'),
(6, 'Nueva Clinica Tres Rios', '22795122', 'Miercoles', '8:00', '5:00'),
(7, 'Hospital CIMA', '22795122', 'Lunes y Martes', '8:00', '5:00'),
(8, 'Nueva Clinica Tres Rios', '22795122', 'Miercoles', '8:00', '5:00'),
(9, 'Hospital CIMA', '22795122', 'Lunes y Martes', '8:00', '5:00'),
(10, 'Hospital CIMA', '22795122', 'Lunes y Martes', '8:00', '5:00'),
(11, 'Hospital CIMA', '22795122', 'Lunes y Martes', '8:00', '5:00'),
(12, 'Hospital CIMA', '22795122', 'Lunes y Martes', '8:00', '5:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `patient`
--

CREATE TABLE IF NOT EXISTS `patient` (
  `id_patient` int(11) NOT NULL AUTO_INCREMENT,
  `user` text NOT NULL,
  `password` text NOT NULL,
  `name` text NOT NULL,
  `phone` text NOT NULL,
  `address` text NOT NULL,
  `birthday` text NOT NULL,
  `associatedDiseases` text NOT NULL,
  `observation` text NOT NULL,
  PRIMARY KEY (`id_patient`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Volcado de datos para la tabla `patient`
--

INSERT INTO `patient` (`id_patient`, `user`, `password`, `name`, `phone`, `address`, `birthday`, `associatedDiseases`, `observation`) VALUES
(1, 'Carlos', '1234', 'Carlos Gonzalez', '22795352', 'Alajuela', '23-12-1985', 'Neumonia', 'Fuerte dolor en el pecho, cuesta respirar'),
(2, 'Carlos', '1234', 'Carlos Gonzalez', '22795352', 'Alajuela', '23-12-1985', 'Neumonia', 'Fuerte dolor en el pecho, cuesta respirar'),
(3, 'Santiago', '1234', 'Santiago Gonzalez', '22795352', 'Alajuela', '23-12-1985', 'Neumonia', 'Fuerte dolor en el pecho, cuesta respirar'),
(4, 'Santiago', '1234', 'Santiago Gonzalez Solorzano', '22795352', 'Alajuela', '23-12-1985', 'Neumonia', 'Fuerte dolor en el pecho, cuesta respirar'),
(6, 'Santiago', '1234', 'Santiago Gonzalez', '22795352', 'Alajuela', '23-12-1985', 'Neumonia', 'Fuerte dolor en el pecho, cuesta respirar'),
(7, 'Carlos', '1234', 'Carlos Gonzalez', '22795352', 'Alajuela', '23-12-1985', 'Neumonia', 'Fuerte dolor en el pecho, cuesta respirar'),
(8, 'Carlos', '1234', 'Carlos Gonzalez', '22795352', 'Alajuela', '23-12-1985', 'Neumonia', 'Fuerte dolor en el pecho, cuesta respirar'),
(9, 'Santiago', '1234', 'Santiago Gonzalez', '22795352', 'Alajuela', '23-12-1985', 'Neumonia', 'Fuerte dolor en el pecho, cuesta respirar'),
(10, 'Santiago', '1234', 'Santiago Gonzalez Solorzano', '22795352', 'Alajuela', '23-12-1985', 'Neumonia', 'Fuerte dolor en el pecho, cuesta respirar'),
(12, 'Santiago', '1234', 'Santiago Gonzalez', '22795352', 'Alajuela', '23-12-1985', 'Neumonia', 'Fuerte dolor en el pecho, cuesta respirar');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
