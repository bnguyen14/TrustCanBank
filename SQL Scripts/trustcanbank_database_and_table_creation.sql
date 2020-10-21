CREATE DATABASE  IF NOT EXISTS `trustcanbank`;
USE `trustcanbank`;


DROP TABLE IF EXISTS `bank_user`;
CREATE TABLE `bank_user` (
  `userid` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL, 
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;