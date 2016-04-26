CREATE DATABASE `webapptemplate`;
USE `webapptemplate`;

CREATE TABLE `employees` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`first_name` VARCHAR(50) NOT NULL,
	`last_name` VARCHAR(50) NOT NULL,
	`department` VARCHAR(50) NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
)
COLLATE='utf8_spanish2_ci'
ENGINE=InnoDB
;

INSERT INTO `webapptemplate`.`employees` (`first_name`, `last_name`, `department`) VALUES ('Jose Antonio', 'Hernandez', 'Development');
INSERT INTO `webapptemplate`.`employees` (`first_name`, `last_name`, `department`) VALUES ('Norma Lucero', 'Flores', 'RH');

ALTER TABLE `employees`	ADD COLUMN `notes` TEXT NULL AFTER `department`;