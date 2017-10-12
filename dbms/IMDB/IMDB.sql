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
-- Table `mydb`.`Actors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Actors` (
  `idActors` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NULL,
  `sex` VARCHAR(10) NOT NULL,
  `age` TINYINT(4) NOT NULL,
  PRIMARY KEY (`idActors`))
ENGINE = InnoDB
COMMENT = 'Strong Entity\nprimary key - idActors';


-- -----------------------------------------------------
-- Table `mydb`.`Movie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Movie` (
  `idMovie` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `rating` FLOAT NULL,
  `genre` VARCHAR(45) NOT NULL,
  `revenueCollection($)` INT NULL,
  `movieBudget($)` INT NULL,
  `Actors_idActors` INT NOT NULL,
  PRIMARY KEY (`idMovie`, `Actors_idActors`),
  INDEX `fk_Movie_Actors1_idx` (`Actors_idActors` ASC),
  CONSTRAINT `fk_Movie_Actors1`
    FOREIGN KEY (`Actors_idActors`)
    REFERENCES `mydb`.`Actors` (`idActors`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Strong Entity\nprimary key - idMovie';


-- -----------------------------------------------------
-- Table `mydb`.`TvSeries`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`TvSeries` (
  `idTvSeries` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `rating` FLOAT NULL,
  `genre` VARCHAR(45) NOT NULL,
  `startDate` DATE NOT NULL,
  `Actors_idActors` INT NOT NULL,
  PRIMARY KEY (`idTvSeries`, `Actors_idActors`),
  INDEX `fk_TvSeries_Actors_idx` (`Actors_idActors` ASC),
  CONSTRAINT `fk_TvSeries_Actors`
    FOREIGN KEY (`Actors_idActors`)
    REFERENCES `mydb`.`Actors` (`idActors`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Strong Entity\nprimary key - idTvSeries';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
