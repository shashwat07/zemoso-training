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
-- Table `mydb`.`Restaurant`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Restaurant` (
  `restaurant_id` INT NOT NULL AUTO_INCREMENT,
  `address` VARCHAR(45) NOT NULL,
  `contact` MEDIUMTEXT NOT NULL,
  PRIMARY KEY (`restaurant_id`),
  UNIQUE INDEX `restaurant_id_UNIQUE` (`restaurant_id` ASC))
ENGINE = InnoDB
COMMENT = 'Strong Entity\nprimary key - restaurant_id';


-- -----------------------------------------------------
-- Table `mydb`.`Customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Customer` (
  `customer_id` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NULL,
  `contact` MEDIUMTEXT NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE INDEX `customer_id_UNIQUE` (`customer_id` ASC),
  UNIQUE INDEX `contact_UNIQUE` (`contact` ASC))
ENGINE = InnoDB
COMMENT = 'Strong Entity\nprimary key - customer_id';


-- -----------------------------------------------------
-- Table `mydb`.`Order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Order` (
  `order_id` INT NOT NULL AUTO_INCREMENT,
  `Customer_customer_id` INT NOT NULL,
  `DeliveryPerson_person_id` INT NOT NULL,
  `orderTime` DATETIME NOT NULL,
  `orderDeliveryTime` DATETIME NOT NULL,
  `Restaurant_restaurant_id` INT NOT NULL,
  PRIMARY KEY (`order_id`),
  UNIQUE INDEX `order_id_UNIQUE` (`order_id` ASC),
  INDEX `fk_Order_Customer1_idx` (`Customer_customer_id` ASC),
  INDEX `fk_Order_DeliveryPerson1_idx` (`DeliveryPerson_person_id` ASC),
  INDEX `fk_Order_Restaurant1_idx` (`Restaurant_restaurant_id` ASC),
  CONSTRAINT `fk_Order_Customer1`
    FOREIGN KEY (`Customer_customer_id`)
    REFERENCES `mydb`.`Customer` (`customer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Order_DeliveryPerson1`
    FOREIGN KEY (`DeliveryPerson_person_id`)
    REFERENCES `mydb`.`DeliveryPerson` (`person_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Order_Restaurant1`
    FOREIGN KEY (`Restaurant_restaurant_id`)
    REFERENCES `mydb`.`Restaurant` (`restaurant_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Weak Entity\nprimary key - order_id';


-- -----------------------------------------------------
-- Table `mydb`.`DeliveryPerson`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`DeliveryPerson` (
  `person_id` INT NOT NULL AUTO_INCREMENT,
  `Order_order_id` INT NOT NULL,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NULL,
  `contact` MEDIUMTEXT NOT NULL,
  PRIMARY KEY (`person_id`),
  UNIQUE INDEX `person_id_UNIQUE` (`person_id` ASC),
  INDEX `fk_DeliveryPerson_Order_idx` (`Order_order_id` ASC),
  UNIQUE INDEX `contact_UNIQUE` (`contact` ASC),
  CONSTRAINT `fk_DeliveryPerson_Order`
    FOREIGN KEY (`Order_order_id`)
    REFERENCES `mydb`.`Order` (`order_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Strong Entity\nprimary key - person_id';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
