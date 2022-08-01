CREATE DATABASE `data-server` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;

CREATE TABLE `data-server`.`device` (
                                        `id` INT NOT NULL AUTO_INCREMENT,
                                        `type` VARCHAR(20) NULL,
                                        `token` VARCHAR(45) NULL,
                                        `serial_number` VARCHAR(45) NULL,
                                        PRIMARY KEY (`id`));

CREATE TABLE `data-server`.`data_type` (
                                           `id` INT NOT NULL AUTO_INCREMENT,
                                           `name` VARCHAR(45) NULL,
                                           `field` INT NULL,
                                           PRIMARY KEY (`id`));

CREATE TABLE `data-server`.`data` (
                                      `id` INT NOT NULL AUTO_INCREMENT,
                                      `device_id` INT NULL,
                                      `type_id` INT NULL,
                                      `time` DATETIME NULL,
                                      `data_int` INT NULL,
                                      `data_float` FLOAT NULL,
                                      `data_string` VARCHAR(100) NULL,
                                      `description` VARCHAR(200) NULL,
                                      PRIMARY KEY (`id`),
                                      INDEX `device_id_fk_idx` (`device_id` ASC) VISIBLE,
                                      INDEX `type_id_fk_idx` (`type_id` ASC) VISIBLE,
                                      CONSTRAINT `device_id_fk`
                                          FOREIGN KEY (`device_id`)
                                              REFERENCES `data-server`.`device` (`id`)
                                              ON DELETE NO ACTION
                                              ON UPDATE NO ACTION,
                                      CONSTRAINT `type_id_fk`
                                          FOREIGN KEY (`type_id`)
                                              REFERENCES `data-server`.`data_type` (`id`)
                                              ON DELETE NO ACTION
                                              ON UPDATE NO ACTION);

