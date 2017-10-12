-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Train`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Train` (
  `train_id` INT NOT NULL,
  `train_name` VARCHAR(45) NOT NULL,
  `stationStart` VARCHAR(45) NOT NULL,
  `stationEnd` VARCHAR(45) NOT NULL,
  `firstStationDeparture` DATETIME NOT NULL,
  `lastStationArrival` DATETIME NOT NULL,
  PRIMARY KEY (`train_id`))
ENGINE = InnoDB
COMMENT = 'Strong Entity\nprimary key - train_id';


-- -----------------------------------------------------
-- Table `mydb`.`Customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Customer` (
  `customer_id` INT NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NULL,
  `age` INT NOT NULL,
  `contact` MEDIUMTEXT NOT NULL,
  `Ticket_ticket_id` INT NOT NULL,
  PRIMARY KEY (`customer_id`),
  INDEX `fk_Customer_Ticket1_idx` (`Ticket_ticket_id` ASC),
  CONSTRAINT `fk_Customer_Ticket1`
    FOREIGN KEY (`Ticket_ticket_id`)
    REFERENCES `mydb`.`Ticket` (`ticket_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Strong Entity\nprimary key - customer_id';


-- -----------------------------------------------------
-- Table `mydb`.`Ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Ticket` (
  `ticket_id` INT NOT NULL,
  `reserved` TINYINT(1) NOT NULL DEFAULT 0,
  `Train_train_id` INT NULL,
  `seatId` VARCHAR(45) NULL,
  `fare` INT NOT NULL,
  `Customer_customer_id` INT NOT NULL,
  PRIMARY KEY (`ticket_id`),
  INDEX `fk_Ticket_Train1_idx` (`Train_train_id` ASC),
  INDEX `fk_Ticket_Customer1_idx` (`Customer_customer_id` ASC),
  CONSTRAINT `fk_Ticket_Train1`
    FOREIGN KEY (`Train_train_id`)
    REFERENCES `mydb`.`Train` (`train_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ticket_Customer1`
    FOREIGN KEY (`Customer_customer_id`)
    REFERENCES `mydb`.`Customer` (`customer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Weak Entity\nPrimary key - ticket_id';

USE `mydb`;

DELIMITER $$
USE `mydb`$$
CREATE DEFINER = CURRENT_USER TRIGGER `mydb`.`Ticket_BEFORE_INSERT` BEFORE INSERT ON `Ticket` FOR EACH ROW
BEGIN
	IF(NEW.reserved = TRUE AND (NEW.Train_train_id = NULL OR NEW.Customer_customer_id))
		THEN SIGNAL SQLSTATE '45000';
        SET MESSAGE_TEXT = 'Each reserved ticket must have a train and customer';
	END IF;
END$$


DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
