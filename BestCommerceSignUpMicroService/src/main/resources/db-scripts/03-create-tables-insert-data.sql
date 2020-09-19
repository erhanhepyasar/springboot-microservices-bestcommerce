-- Create Tables
CREATE TABLE IF NOT EXISTS `bestcommerce`.`merchant_type` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `merchant_type_name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE=InnoDB
AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS `bestcommerce`.`merchants` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,  
  `merchant_type_id` BIGINT NOT NULL,
  `merchant_name` VARCHAR(255) DEFAULT NULL,
  `owner_name` VARCHAR(255) DEFAULT NULL,
  `address` VARCHAR(255) DEFAULT NULL,
  `phone_number` VARCHAR(255) DEFAULT NULL,
  `email` VARCHAR(255) DEFAULT NULL,
  `password` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_merchant_type` (`merchant_type_id`),
  CONSTRAINT `fk_merchant_type` FOREIGN KEY (`merchant_type_id`) REFERENCES `merchant_type` (`id`)) 
ENGINE=InnoDB
AUTO_INCREMENT = 1;

-- Add sample data
INSERT INTO MERCHANT_TYPE(MERCHANT_TYPE_NAME) VALUES ('Wholesale');
INSERT INTO MERCHANT_TYPE(MERCHANT_TYPE_NAME) VALUES ('Retail merchant');


INSERT INTO MERCHANTS(MERCHANT_TYPE_ID, MERCHANT_NAME, OWNER_NAME, ADDRESS, PHONE_NUMBER, EMAIL, PASSWORD) VALUES (2, 'Merchant Name-1', 'Owner Name-1', 'Address-1', 'Phone Number-1', 'email-1', 'password-1');
INSERT INTO MERCHANTS(MERCHANT_TYPE_ID, MERCHANT_NAME, OWNER_NAME, ADDRESS, PHONE_NUMBER, EMAIL, PASSWORD) VALUES (1, 'Merchant Name-2', 'Owner Name-2', 'Address-2', 'Phone Number-2', 'email-2', 'password-2');
INSERT INTO MERCHANTS(MERCHANT_TYPE_ID, MERCHANT_NAME, OWNER_NAME, ADDRESS, PHONE_NUMBER, EMAIL, PASSWORD) VALUES (2, 'Merchant Name-3', 'Owner Name-3', 'Address-3', 'Phone Number-3', 'email-3', 'password-3');
INSERT INTO MERCHANTS(MERCHANT_TYPE_ID, MERCHANT_NAME, OWNER_NAME, ADDRESS, PHONE_NUMBER, EMAIL, PASSWORD) VALUES (2, 'Merchant Name-4', 'Owner Name-4', 'Address-4', 'Phone Number-4', 'email-4', 'password-4');
INSERT INTO MERCHANTS(MERCHANT_TYPE_ID, MERCHANT_NAME, OWNER_NAME, ADDRESS, PHONE_NUMBER, EMAIL, PASSWORD) VALUES (1, 'Merchant Name-5', 'Owner Name-5', 'Address-5', 'Phone Number-5', 'email-5', 'password-5');