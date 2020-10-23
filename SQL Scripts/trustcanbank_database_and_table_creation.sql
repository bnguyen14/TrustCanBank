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

USE `trustcanbank`;
DROP TABLE IF EXISTS `bank_account`;
CREATE TABLE `bank_account` (
  `account_id` int NOT NULL AUTO_INCREMENT,
  `account_type` varchar(45) DEFAULT NULL, 
  `account balance` DECIMAL(13,2) DEFAULT NULL,
  `userid` int,
  PRIMARY KEY (`account_id`),
  FOREIGN KEY (`userid`) REFERENCES Bank_user (`userid`) 
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

USE `trustcanbank`;
DROP TABLE IF EXISTS `account_transaction`;
CREATE TABLE `account_transaction` (
  `transaction_id` int NOT NULL AUTO_INCREMENT,
  `transaction_date` varchar(45) DEFAULT NULL, 
  `transaction_type` varchar(45) DEFAULT NULL, 
  `transaction_amount` DECIMAL(13,2) DEFAULT NULL,
  `account_id` int,
  PRIMARY KEY (`transaction_id`),
  FOREIGN KEY (`account_id`) REFERENCES Bank_account (`account_id`) 
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;