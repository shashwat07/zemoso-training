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
-- Table `mydb`.`Driver`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Driver` (
  `driver_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NULL,
  `rating` FLOAT NULL,
  `Cabs_cab_id` INT NOT NULL,
  PRIMARY KEY (`driver_id`),
  INDEX `fk_Driver_Cabs1_idx` (`Cabs_cab_id` ASC),
  UNIQUE INDEX `Cabs_cab_id_UNIQUE` (`Cabs_cab_id` ASC),
  CONSTRAINT `fk_Driver_Cabs1`
    FOREIGN KEY (`Cabs_cab_id`)
    REFERENCES `mydb`.`Cabs` (`cab_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Strong Entity\nPrimary Key - driver_id';


-- -----------------------------------------------------
-- Table `mydb`.`Cabs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Cabs` (
  `cab_id` INT NOT NULL AUTO_INCREMENT,
  `model_name` VARCHAR(45) NOT NULL,
  `Driver_driver_id` INT NOT NULL,
  PRIMARY KEY (`cab_id`),
  UNIQUE INDEX `cab_id_UNIQUE` (`cab_id` ASC),
  INDEX `fk_Cabs_Driver1_idx` (`Driver_driver_id` ASC),
  UNIQUE INDEX `Driver_driver_id_UNIQUE` (`Driver_driver_id` ASC),
  CONSTRAINT `fk_Cabs_Driver1`
    FOREIGN KEY (`Driver_driver_id`)
    REFERENCES `mydb`.`Driver` (`driver_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Strong Entity\nprimary key - cab_id';


-- -----------------------------------------------------
-- Table `mydb`.`Customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Customer` (
  `customer_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NULL,
  `cust_rating` FLOAT NOT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE INDEX `customer_id_UNIQUE` (`customer_id` ASC))
ENGINE = InnoDB
COMMENT = 'Strong Entity\nprimay key - customer_id';


-- -----------------------------------------------------
-- Table `mydb`.`Ride`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Ride` (
  `idRide` INT NOT NULL,
  `rideStart` DATETIME NOT NULL,
  `rideEnd` DATETIME NOT NULL,
  `pickup` VARCHAR(45) NOT NULL,
  `destination` VARCHAR(45) NOT NULL,
  `Driver_driver_id` INT NOT NULL,
  `Cabs_cab_id` INT NOT NULL,
  `Customer_customer_id` INT NOT NULL,
  `fare` INT NOT NULL,
  PRIMARY KEY (`idRide`),
  UNIQUE INDEX `idRide_UNIQUE` (`idRide` ASC),
  INDEX `fk_Ride_Driver1_idx` (`Driver_driver_id` ASC),
  INDEX `fk_Ride_Cabs1_idx` (`Cabs_cab_id` ASC),
  INDEX `fk_Ride_Customer1_idx` (`Customer_customer_id` ASC),
  CONSTRAINT `fk_Ride_Driver1`
    FOREIGN KEY (`Driver_driver_id`)
    REFERENCES `mydb`.`Driver` (`driver_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ride_Cabs1`
    FOREIGN KEY (`Cabs_cab_id`)
    REFERENCES `mydb`.`Cabs` (`cab_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ride_Customer1`
    FOREIGN KEY (`Customer_customer_id`)
    REFERENCES `mydb`.`Customer` (`customer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Weak Entity\nprimary key - idRide';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
USE `mydb`;

DELIMITER $$
USE `mydb`$$
CREATE DEFINER = CURRENT_USER TRIGGER `mydb`.`Ride_BEFORE_INSERT` BEFORE INSERT ON `Ride` FOR EACH ROW
BEGIN
	IF(NEW.rideStart < (SELECT Ride.rideEnd FROM Ride WHERE Ride.Customer_customer_id = NEW.customer_id))
		THEN SIGNAL SQLSTATE '45000';
		SET MESSAGE_TEXT = 'One customer cannot be in two rides at same time.';
	END IF;
END$$


DELIMITER ;
