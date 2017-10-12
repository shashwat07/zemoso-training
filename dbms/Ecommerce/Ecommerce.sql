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
-- Table `mydb`.`Supplier`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Supplier` (
  `idSupplier` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `contact` MEDIUMTEXT NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idSupplier`))
ENGINE = InnoDB
COMMENT = 'Strong Entity\nprimary key - idSupplier';


-- -----------------------------------------------------
-- Table `mydb`.`Customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Customer` (
  `idCustomer` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NULL,
  `contact` MEDIUMTEXT NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCustomer`))
ENGINE = InnoDB
COMMENT = 'Strong Entity\nprimary key - idCustomer';


-- -----------------------------------------------------
-- Table `mydb`.`Items`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Items` (
  `idItems` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price(INR)` INT NOT NULL,
  `itemType` VARCHAR(45) NOT NULL,
  `Supplier_idSupplier` INT NOT NULL,
  PRIMARY KEY (`idItems`, `Supplier_idSupplier`),
  INDEX `fk_Items_Supplier_idx` (`Supplier_idSupplier` ASC),
  CONSTRAINT `fk_Items_Supplier`
    FOREIGN KEY (`Supplier_idSupplier`)
    REFERENCES `mydb`.`Supplier` (`idSupplier`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Strong Entity\nprimary key - idItems';


-- -----------------------------------------------------
-- Table `mydb`.`Order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Order` (
  `idOrder` INT NOT NULL AUTO_INCREMENT,
  `Items_idItems` INT NOT NULL,
  `Items_Supplier_idSupplier` INT NOT NULL,
  `Customer_idCustomer` INT NOT NULL,
  `totalPrice(INR)` INT NOT NULL,
  PRIMARY KEY (`idOrder`),
  INDEX `fk_Order_Items1_idx` (`Items_idItems` ASC, `Items_Supplier_idSupplier` ASC),
  INDEX `fk_Order_Customer1_idx` (`Customer_idCustomer` ASC),
  CONSTRAINT `fk_Order_Items1`
    FOREIGN KEY (`Items_idItems` , `Items_Supplier_idSupplier`)
    REFERENCES `mydb`.`Items` (`idItems` , `Supplier_idSupplier`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Order_Customer1`
    FOREIGN KEY (`Customer_idCustomer`)
    REFERENCES `mydb`.`Customer` (`idCustomer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Weak Entity\nprimary key - idOrder';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
