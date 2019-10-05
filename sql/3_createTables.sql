USE `trade`;

-- -----------------------------------------------------
-- Table `trade`.`user`
-- -----------------------------------------------------


CREATE TABLE `user`
(
    `id`       INT(11)     NOT NULL AUTO_INCREMENT,
    `name`     VARCHAR(45) NULL,
    `login`    VARCHAR(45) NOT NULL,
    `password` NCHAR(255)  NOT NULL,
    `role`     VARCHAR(45) NOT NULL,
    CONSTRAINT PK_user PRIMARY KEY (`id`),
    UNIQUE INDEX `IDX_user_login` (`login` ASC)
);



-- -----------------------------------------------------
-- Table `trade`.`measure`
-- -----------------------------------------------------

CREATE TABLE `measure`
(
    `id`   TINYINT     NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NULL,
    CONSTRAINT PK_measure PRIMARY KEY (`id`)
);


-- -----------------------------------------------------
-- Table `trade`.`products`
-- -----------------------------------------------------
CREATE TABLE `products`
(
    `id`         INT            NOT NULL AUTO_INCREMENT,
    `name`       VARCHAR(45)    NOT NULL,
    `barcode`    INT(20)        NOT NULL,
    `price`      DECIMAL(10, 2) NOT NULL,
    `count`      INT            NOT NULL,
    `measure_id` TINYINT        NULL,
    CONSTRAINT PK_products PRIMARY KEY (`id`),
    UNIQUE INDEX `IDX_barcode_UNIQUE` (`barcode` ASC),
    CONSTRAINT `FK_product_measure`
        FOREIGN KEY (`measure_id`)
            REFERENCES `measure` (`id`)
            ON DELETE RESTRICT
            ON UPDATE CASCADE
);


-- -----------------------------------------------------
-- Table `trade`.`receipt`
-- -----------------------------------------------------
CREATE TABLE `receipt`
(
    `id`      INT            NOT NULL AUTO_INCREMENT,
    `user_id` INT(11)        NOT NULL,
    `date`    DATETIME       NOT NULL,
    `sum`     decimal(10, 2) NULL,
    CONSTRAINT PK_receipt PRIMARY KEY (`id`),
    INDEX `IDX_receipt_user` (`user_id` ASC),
    INDEX `IDX_receipt_date` (`date` ASC),
    CONSTRAINT `FK_receipt_user`
        FOREIGN KEY (`user_id`)
            REFERENCES `user` (`id`)
            ON DELETE RESTRICT
            ON UPDATE CASCADE
);


-- -----------------------------------------------------
-- Table `trade`.`salesItem`
-- -----------------------------------------------------
CREATE TABLE `salesItem`
(
    `id`         INT            NOT NULL AUTO_INCREMENT,
    `receipt_id` INT            NOT NULL,
    `product_id` INT            NOT NULL,
    `count`      INT            NOT NULL,
    `sum`        DECIMAL(10, 2) NOT NULL,
    INDEX `IDX_salesItem_receipt` (`receipt_id` ASC),
    INDEX `IDX_salesItem_products` (`product_id` ASC),
    PRIMARY KEY (`id`),
    CONSTRAINT `FK_salesItem_receipt`
        FOREIGN KEY (`receipt_id`)
            REFERENCES `receipt` (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    CONSTRAINT `FK_salesItem_products`
        FOREIGN KEY (`product_id`)
            REFERENCES `products` (`id`)
            ON DELETE RESTRICT
            ON UPDATE CASCADE,
    CONSTRAINT CH_salesItem_count CHECK (count > 0)
)