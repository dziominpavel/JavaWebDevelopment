-- -----------------------------------------------------
-- Data for table `trade`.`user`
-- -----------------------------------------------------
INSERT INTO user (`name`, `login`, `password`, `role`) VALUES ('Petrov Petr', 'petrov', '22222222', 'USER');
INSERT INTO `user` (`name`, `login`, `password`, `role`) VALUES ('Sidorov Sidr', 'sidorov', '33333333', 'USER');
INSERT INTO `user` (`name`, `login`, `password`, `role`) VALUES ('Dziomin Pavel', 'dziomin', '44444444', 'MANAGER');

-- -----------------------------------------------------
-- Data for table `trade`.`products`
-- -----------------------------------------------------
INSERT INTO `products` (`id`, `name`, `barcode`, `price`, `count`, `measure_id`) VALUES (1, 'chocolate Alenka', 12345, 12.50, 100, 3);
INSERT INTO `products` (`id`, `name`, `barcode`, `price`, `count`, `measure_id`) VALUES (2, 'vodka Finlandia', 12346, 35.99, 200, 1);
INSERT INTO `products` (`id`, `name`, `barcode`, `price`, `count`, `measure_id`) VALUES (3, 'snickers', 12347, 10.0, 300, 3);
INSERT INTO `products` (`id`, `name`, `barcode`, `price`, `count`, `measure_id`) VALUES (4, 'rafaello', 12348, 20.55, 400, 2);


-- -----------------------------------------------------
-- Data for table `trade`.`receipt`
-- -----------------------------------------------------
INSERT INTO `receipt` (`id`, `user_id`, `date`, `sum`) VALUES (1, 2, '2000-01-01 02:30:00', 250);

-- -----------------------------------------------------
-- Data for table `trade`.`salesItem`
-- -----------------------------------------------------
INSERT INTO salesItem (`receipt_id`, `product_id`, `count`, `sum`) VALUES (1, 1, 3, 45);
INSERT INTO `salesItem` (`receipt_id`, `product_id`, `count`, `sum`) VALUES (1, 2, 10, 45);
INSERT INTO `salesItem` (`receipt_id`, `product_id`, `count`, `sum`) VALUES (1, 3, 12, 24);