CREATE DATABASE `data-server` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;

CREATE TABLE `data-server`.`device` (
                                        `id` INT NOT NULL AUTO_INCREMENT,
                                        `type` VARCHAR(20) NULL,
                                        `token` VARCHAR(45) NULL,
                                        `serial_number` VARCHAR(45) NULL,
                                        PRIMARY KEY (`id`));


