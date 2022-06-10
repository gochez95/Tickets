-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema tickets
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tickets
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tickets` DEFAULT CHARACTER SET utf8 ;
USE `tickets` ;

-- -----------------------------------------------------
-- Table `tickets`.`rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tickets`.`rol` (
  `id_rol` INT NOT NULL AUTO_INCREMENT,
  `name_rol` VARCHAR(75) NOT NULL,
  `active` TINYINT(1) NULL,
  PRIMARY KEY (`id_rol`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tickets`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tickets`.`user` (
  `id_user` INT NOT NULL AUTO_INCREMENT,
  `name_user` VARCHAR(150) NOT NULL,
  `lastname_user` VARCHAR(150) NOT NULL,
  `user_name` VARCHAR(50) NOT NULL,
  `password` VARCHAR(150) NOT NULL,
  `email_user` VARCHAR(150) NOT NULL,
  `id_role` INT NULL,
  `active` TINYINT(1) NULL,
  PRIMARY KEY (`id_user`),
  INDEX `id_rol_fk_idx` (`id_role` ASC) VISIBLE,
  CONSTRAINT `id_rol_fk`
    FOREIGN KEY (`id_role`)
    REFERENCES `tickets`.`rol` (`id_rol`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tickets`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tickets`.`category` (
  `id_category` INT NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(75) NOT NULL,
  PRIMARY KEY (`id_category`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tickets`.`priority`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tickets`.`priority` (
  `id_priority` INT NOT NULL AUTO_INCREMENT,
  `name_priority` VARCHAR(75) NULL,
  PRIMARY KEY (`id_priority`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tickets`.`ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tickets`.`ticket` (
  `id_ticket` INT NOT NULL,
  `name_ticket` VARCHAR(150) NOT NULL,
  `description_ticket` VARCHAR(350) NOT NULL,
  `create_at` DATE NULL,
  `finish_at` DATE NULL,
  `id_category` INT NULL,
  `id_priority` INT NULL,
  `id_user` INT NULL,
  `assing` INT NULL,
  PRIMARY KEY (`id_ticket`),
  INDEX `id_category_fk_idx` (`id_category` ASC) VISIBLE,
  INDEX `id_priority_fk_idx` (`id_priority` ASC) VISIBLE,
  INDEX `id_user_idx` (`id_user` ASC) VISIBLE,
  INDEX `user_assing_fk_idx` (`assing` ASC) VISIBLE,
  CONSTRAINT `id_category_fk`
    FOREIGN KEY (`id_category`)
    REFERENCES `tickets`.`category` (`id_category`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `id_priority_fk`
    FOREIGN KEY (`id_priority`)
    REFERENCES `tickets`.`priority` (`id_priority`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `id_user`
    FOREIGN KEY (`id_user`)
    REFERENCES `tickets`.`user` (`id_user`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `user_assing_fk`
    FOREIGN KEY (`assing`)
    REFERENCES `tickets`.`user` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tickets`.`status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tickets`.`status` (
  `id_status` INT NOT NULL AUTO_INCREMENT,
  `status_name` VARCHAR(75) NOT NULL,
  PRIMARY KEY (`id_status`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tickets`.`ticket_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tickets`.`ticket_status` (
  `id_ticket` INT NOT NULL,
  `id_status` INT NOT NULL,
  PRIMARY KEY (`id_ticket`, `id_status`),
  INDEX `id_status_fk_idx` (`id_status` ASC) VISIBLE,
  CONSTRAINT `id_ticket_fk`
    FOREIGN KEY (`id_ticket`)
    REFERENCES `tickets`.`ticket` (`id_ticket`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `id_status_fk`
    FOREIGN KEY (`id_status`)
    REFERENCES `tickets`.`status` (`id_status`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tickets`.`ticket_comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tickets`.`ticket_comment` (
  `id_ticket_comment` INT NOT NULL,
  `comment` VARCHAR(350) NULL,
  `id_ticket` INT NULL,
  PRIMARY KEY (`id_ticket_comment`),
  INDEX `id_ticket_comment_fk_idx` (`id_ticket` ASC) VISIBLE,
  CONSTRAINT `id_ticket_comment_fk`
    FOREIGN KEY (`id_ticket`)
    REFERENCES `tickets`.`ticket` (`id_ticket`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tickets`.`user_tickets`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tickets`.`user_tickets` (
  `id_ticket` INT NOT NULL,
  `id_user` INT NOT NULL,
  PRIMARY KEY (`id_ticket`, `id_user`),
  INDEX `id_user_fk__idx` (`id_user` ASC) VISIBLE,
  CONSTRAINT `id_ticket_fk_`
    FOREIGN KEY (`id_ticket`)
    REFERENCES `tickets`.`ticket` (`id_ticket`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `id_user_fk_`
    FOREIGN KEY (`id_user`)
    REFERENCES `tickets`.`user` (`id_user`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

ALTER TABLE `tickets`.`ticket` 
ADD COLUMN `assign` INT NULL AFTER `id_user`,
ADD INDEX `assign_user_idx` (`assign` ASC) VISIBLE;
;
ALTER TABLE `tickets`.`ticket` 
ADD COLUMN `assign` INT NULL AFTER `id_user`,
ADD INDEX `assign_user_idx` (`assign` ASC) VISIBLE;
;
ALTER TABLE `tickets`.`ticket` 
ADD CONSTRAINT `assign_user`
  FOREIGN KEY (`assign`)
  REFERENCES `tickets`.`user` (`id_user`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

CREATE USER 'user1';

INSERT INTO `tickets`.`rol` (`name_rol`, `active`) VALUES ('admin', '1');
INSERT INTO `tickets`.`rol` (`name_rol`, `active`) VALUES ('seller', '1');
INSERT INTO `tickets`.`rol` (`name_rol`, `active`) VALUES ('user', '1');
INSERT INTO `tickets`.`rol` (`name_rol`, `active`) VALUES ('supervisor', '1');

INSERT INTO `tickets`.`user` (`name_user`, `lastname_user`, `user_name`, `password`, `email_user`, `id_role`, `active`) VALUES ('Telus', 'Telus', 'admin', '$2a$10$3VqCdIiiEBa4Nh47seGIXuWCd5GeDYZ.eY/QZwsueUuN0m2hi4c2K', 'telus@gmail.com', '1', '1');
INSERT INTO `tickets`.`user` (`name_user`, `lastname_user`, `user_name`, `password`, `email_user`, `id_role`, `active`) VALUES ('Juan', 'Perez', 'perez', '$2a$10$3VqCdIiiEBa4Nh47seGIXuWCd5GeDYZ.eY/QZwsueUuN0m2hi4c2K', 'p@gmail.com', '2', '1');
INSERT INTO `tickets`.`user` (`name_user`, `lastname_user`, `user_name`, `password`, `email_user`, `id_role`, `active`) VALUES ('Luz', 'Maria', 'luz', '$2a$10$3VqCdIiiEBa4Nh47seGIXuWCd5GeDYZ.eY/QZwsueUuN0m2hi4c2K', 'luz@gmail.com', '3', '1');
INSERT INTO `tickets`.`user` (`name_user`, `lastname_user`, `user_name`, `password`, `email_user`, `id_role`, `active`) VALUES ('Jose', 'Lopez', 'lopez1', '$2a$10$3VqCdIiiEBa4Nh47seGIXuWCd5GeDYZ.eY/QZwsueUuN0m2hi4c2K', 'lopez@gmail.com', '4', '1');


INSERT INTO `tickets`.`category` (`category_name`) VALUES ('category1');
INSERT INTO `tickets`.`category` (`category_name`) VALUES ('category2');
INSERT INTO `tickets`.`category` (`category_name`) VALUES ('category3');
INSERT INTO `tickets`.`category` (`category_name`) VALUES ('category4');


INSERT INTO `tickets`.`status` (`status_name`) VALUES ('Create');
INSERT INTO `tickets`.`status` (`status_name`) VALUES ('Escalated');
INSERT INTO `tickets`.`status` (`status_name`) VALUES ('Closed');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
