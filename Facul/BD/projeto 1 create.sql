SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `mydb` ;
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Depto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Depto` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`Depto` (
  `cod` INT NOT NULL ,
  `nome` VARCHAR(45) NULL ,
  `telefon` VARCHAR(15) NULL ,
  PRIMARY KEY (`cod`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Funcionario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Funcionario` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`Funcionario` (
  `cod` INT NOT NULL ,
  `nome` VARCHAR(45) NULL ,
  `sexo` CHAR(1) NULL ,
  `est_civ` CHAR(1) NULL ,
  `data_nasc` DATETIME NULL ,
  `Depto_cod` INT NOT NULL ,
  PRIMARY KEY (`cod`) ,
  INDEX `fk_Funcionario_Depto1` (`Depto_cod` ASC) ,
  CONSTRAINT `fk_Funcionario_Depto1`
    FOREIGN KEY (`Depto_cod` )
    REFERENCES `mydb`.`Depto` (`cod` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`dep_func`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`dep_func` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`dep_func` (
  `cod_func` INT NOT NULL ,
  `seq_dep` DECIMAL(10,0)  NOT NULL ,
  `nome` VARCHAR(45) NULL ,
  `sexo` CHAR(1) NULL ,
  `est_civil` CHAR(1) NULL ,
  `data_nasc` DATETIME NULL ,
  `grau_par` CHAR(1) NULL ,
  PRIMARY KEY (`cod_func`, `seq_dep`) ,
  INDEX `fk_dep_func_Funcionario` (`cod_func` ASC) ,
  CONSTRAINT `fk_dep_func_Funcionario`
    FOREIGN KEY (`cod_func` )
    REFERENCES `mydb`.`Funcionario` (`cod` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
