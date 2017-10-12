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
-- Table `mydb`.`Hotel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Hotel` (
  `idHotel` INT NOT NULL AUTO_INCREMENT,
  `hotelName` VARCHAR(45) NOT NULL,
  `contact` MEDIUMTEXT NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idHotel`),
  UNIQUE INDEX `idHotel_UNIQUE` (`idHotel` ASC))
ENGINE = InnoDB
COMMENT = 'Strong Entity\nprimary key - idHotel';


-- -----------------------------------------------------
-- Table `mydb`.`Customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Customer` (
  `idCustomer` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NULL,
  `aadharNumber` MEDIUMTEXT NOT NULL,
  `contact` MEDIUMTEXT NOT NULL,
  `isLoyal` TINYINT(1) NOT NULL,
  PRIMARY KEY (`idCustomer`),
  UNIQUE INDEX `idCustomer_UNIQUE` (`idCustomer` ASC))
ENGINE = InnoDB
COMMENT = 'Strong Entity\nprimary key - idCustomer';


-- -----------------------------------------------------
-- Table `mydb`.`Booking`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Booking` (
  `idBooking` INT NOT NULL,
  `Hotel_idHotel` INT NOT NULL,
  `Customer_idCustomer` INT NOT NULL,
  `bookingDate` DATE NOT NULL,
  `stayDuration` INT NOT NULL,
  `Cost` INT NOT NULL,
  PRIMARY KEY (`idBooking`),
  INDEX `fk_Booking_Hotel_idx` (`Hotel_idHotel` ASC),
  INDEX `fk_Booking_Customer1_idx` (`Customer_idCustomer` ASC),
  CONSTRAINT `fk_Booking_Hotel`
    FOREIGN KEY (`Hotel_idHotel`)
    REFERENCES `mydb`.`Hotel` (`idHotel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Booking_Customer1`
    FOREIGN KEY (`Customer_idCustomer`)
    REFERENCES `mydb`.`Customer` (`idCustomer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Weak Entity\nprimary key - idBooking';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
