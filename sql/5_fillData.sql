-- -----------------------------------------------------
-- Data for table `trade`.`user`
-- -----------------------------------------------------
INSERT INTO user (`name`, `login`, `password`, `role`) VALUES ('Petrov Petr', 'petrov', '22222222', 'USER');
INSERT INTO `user` (`name`, `login`, `password`, `role`) VALUES ('Sidorov Sidr', 'sidorov', '33333333', 'USER');
INSERT INTO `user` (`name`, `login`, `password`, `role`) VALUES ('Dziomin Pavel', 'dziomin', '44444444', 'MANAGER');

-- -----------------------------------------------------
-- Data for table `trade`.`products`
-- -----------------------------------------------------
INSERT INTO `products` (`id`, `name`, `barcode`, `price`, `count`, `measure_id`) VALUES (1, 'Шпатлевка Ceresit', 1111, 12.50, 100, 1);
INSERT INTO `products` (`id`, `name`, `barcode`, `price`, `count`, `measure_id`) VALUES (2, 'Шпатлевка Ceresit Pro', 1112, 35.99, 200, 2);
INSERT INTO `products` (`id`, `name`, `barcode`, `price`, `count`, `measure_id`) VALUES (3, 'Цемент Тайфун Мастер', 2222, 10.0, 300, 2);
INSERT INTO `products` (`id`, `name`, `barcode`, `price`, `count`, `measure_id`) VALUES (4, 'Цемент Тайфун Мастер', 2223, 20.55, 400, 3);
INSERT INTO `products` (`id`, `name`, `barcode`, `price`, `count`, `measure_id`) VALUES (5, 'Краска Лидская', 3333, 20.55, 400, 4);
INSERT INTO `products` (`id`, `name`, `barcode`, `price`, `count`, `measure_id`) VALUES (6, 'Краска Лидская', 3334, 22.55, 400, 5);
INSERT INTO `products` (`id`, `name`, `barcode`, `price`, `count`, `measure_id`) VALUES (7, 'Гвозди 5х50', 4444, 30.15, 100, 6);
INSERT INTO `products` (`id`, `name`, `barcode`, `price`, `count`, `measure_id`) VALUES (8, 'Гвозди 5х50', 4445, 55.80, 100, 7);
INSERT INTO `products` (`id`, `name`, `barcode`, `price`, `count`, `measure_id`) VALUES (9, 'Молоток Fiskars', 5555, 30.00, 10, 8);
INSERT INTO `products` (`id`, `name`, `barcode`, `price`, `count`, `measure_id`) VALUES (10, 'Отвертка Fiskars', 5556, 20.30, 10, 8);
INSERT INTO `products` (`id`, `name`, `barcode`, `price`, `count`, `measure_id`) VALUES (11, 'Шуруповерт Bosh', 6666, 80.00, 10, 8);
INSERT INTO `products` (`id`, `name`, `barcode`, `price`, `count`, `measure_id`) VALUES (12, 'Дрель Bosh', 6667, 81.50, 10, 8);


-- -----------------------------------------------------
-- Data for table `trade`.`receipt`
-- -----------------------------------------------------
# INSERT INTO `receipt` (`id`, `user_id`, `date`, `sum`) VALUES (1, 2, '2000-01-01 02:30:00', 250);

-- -----------------------------------------------------
-- Data for table `trade`.`salesItem`
-- -----------------------------------------------------
# INSERT INTO salesItem (`receipt_id`, `product_id`, `count`, `sum`) VALUES (1, 1, 3, 45);
# INSERT INTO `salesItem` (`receipt_id`, `product_id`, `count`, `sum`) VALUES (1, 2, 10, 45);
# INSERT INTO `salesItem` (`receipt_id`, `product_id`, `count`, `sum`) VALUES (1, 3, 12, 24);