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


--#############

CREATE TABLE `users` (
	`username` VARCHAR(50) NOT NULL,
	`password` VARCHAR(50) NOT NULL,
	`enabled` BIT NOT NULL DEFAULT b'1',
	PRIMARY KEY (`username`)
)
COLLATE='utf8_spanish2_ci'
ENGINE=InnoDB;

CREATE TABLE `user_roles` (
	`user_role_id` INT NOT NULL AUTO_INCREMENT,
	`username` VARCHAR(50) NOT NULL DEFAULT '0',
	`role` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`user_role_id`),
	UNIQUE INDEX `user_role_id_username` (`user_role_id`, `username`),
	CONSTRAINT `fk_username_idx` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
)
COLLATE='utf8_spanish2_ci'
ENGINE=InnoDB;

INSERT INTO `webapptemplate`.`users` (`username`,`password`) VALUES ('jahv','admin');
INSERT INTO `webapptemplate`.`user_roles` (`username`, `role`) VALUES ('jahv', 'ROLE_ADMIN');
INSERT INTO `webapptemplate`.`user_roles` (`username`, `role`) VALUES ('jahv', 'ROLE_USER');

INSERT INTO `webapptemplate`.`users` (`username`,`password`) VALUES ('lucy','admin');
INSERT INTO `webapptemplate`.`user_roles` (`username`, `role`) VALUES ('lucy', 'ROLE_USER');