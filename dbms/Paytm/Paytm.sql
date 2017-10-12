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
-- Table `mydb`.`Branches`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Branches` (
  `idBranches` INT NOT NULL AUTO_INCREMENT,
  `branchName` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `branchManager` VARCHAR(45) NOT NULL,
  `contact` MEDIUMTEXT NOT NULL,
  PRIMARY KEY (`idBranches`))
ENGINE = InnoDB
COMMENT = 'Strong Entity\nprimary key - idBranches';


-- -----------------------------------------------------
-- Table `mydb`.`Accounts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Accounts` (
  `idAccounts` INT NOT NULL AUTO_INCREMENT,
  `Branches_idBranches` INT NOT NULL,
  `accountBalance` MEDIUMTEXT NOT NULL,
  `accountType` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAccounts`),
  INDEX `fk_Accounts_Branches_idx` (`Branches_idBranches` ASC),
  CONSTRAINT `fk_Accounts_Branches`
    FOREIGN KEY (`Branches_idBranches`)
    REFERENCES `mydb`.`Branches` (`idBranches`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Weak Entity\nprimary key - idAccounts';


-- -----------------------------------------------------
-- Table `mydb`.`Customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Customer` (
  `idCustomer` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NULL,
  `age` TINYINT(4) NOT NULL,
  `sex` TEXT(10) NOT NULL,
  `aadharNumer` MEDIUMTEXT NOT NULL,
  `PAN` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idCustomer`))
ENGINE = InnoDB
COMMENT = 'Strong Entity\nprimary key - idCustomer';


-- -----------------------------------------------------
-- Table `mydb`.`Customer_has_Accounts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Customer_has_Accounts` (
  `Customer_idCustomer` INT NOT NULL,
  `Accounts_idAccounts` INT NOT NULL,
  PRIMARY KEY (`Customer_idCustomer`, `Accounts_idAccounts`),
  INDEX `fk_Customer_has_Accounts_Accounts1_idx` (`Accounts_idAccounts` ASC),
  INDEX `fk_Customer_has_Accounts_Customer1_idx` (`Customer_idCustomer` ASC),
  CONSTRAINT `fk_Customer_has_Accounts_Customer1`
    FOREIGN KEY (`Customer_idCustomer`)
    REFERENCES `mydb`.`Customer` (`idCustomer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Customer_has_Accounts_Accounts1`
    FOREIGN KEY (`Accounts_idAccounts`)
    REFERENCES `mydb`.`Accounts` (`idAccounts`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Weak Entity\nprimary keys - Customer_idCustomer, Accounts_idAccounts';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
USE `mydb`;

DELIMITER $$
USE `mydb`$$
CREATE DEFINER = CURRENT_USER TRIGGER `mydb`.`Customer_has_Accounts_BEFORE_INSERT` BEFORE INSERT ON `Customer_has_Accounts` FOR EACH ROW
BEGIN
	IF(NEW.idBranches = (SELECT idBranches FROM Branches WHERE Customer.idCustomer = NEW.idCustomer))
		THEN SIGNAL SQLSTATE '45000';
		SET MESSAGE_TEXT = 'Customer cannot have multiple accounts in same branch';
	END IF;
END$$


DELIMITER ;
