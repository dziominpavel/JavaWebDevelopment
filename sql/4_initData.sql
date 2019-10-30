-- -----------------------------------------------------
-- Data for table `trade`.`user`
-- -----------------------------------------------------
USE `trade`;
INSERT INTO user (`name`, `login`, `password`, `role`) VALUES ('Ivanov Ivan', 'Admin', 'Admin123', 'ADMIN');

-- -----------------------------------------------------
-- Data for table `trade`.`measure`
-- -----------------------------------------------------
INSERT INTO `measure` (`id`, `name`) VALUES (1, 'мешок 50кг');
INSERT INTO `measure` (`id`, `name`) VALUES (2, 'мешок 100кг');
INSERT INTO `measure` (`id`, `name`) VALUES (3, 'мешок 1000кг');
INSERT INTO `measure` (`id`, `name`) VALUES (4, 'банка 1л');
INSERT INTO `measure` (`id`, `name`) VALUES (5, 'банка 5л');
INSERT INTO `measure` (`id`, `name`) VALUES (6, 'упаковка 50шт');
INSERT INTO `measure` (`id`, `name`) VALUES (7, 'упаковка 100шт');
INSERT INTO `measure` (`id`, `name`) VALUES (8, 'шт');
