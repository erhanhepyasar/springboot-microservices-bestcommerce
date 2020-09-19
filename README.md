
*********************************************************************************************************
              SPRING BOOT BACK END MICRO SERVICES FOR BEST COMMERCE APPLICATION
*********************************************************************************************************


*********************************************************************************************************
              URL'S FOR PRODUCTS AND SIGN UP MICRO SERVICES
*********************************************************************************************************

Eureka Discovery Micro Service: 
----------------------------------------
	
http://localhost:8761 


Products Micro Service:
----------------------------------------

All API’s: 			http://localhost:8080/api/

Get all products: 			http://localhost:8080/api/products

Get products with paging:	  	http://localhost:8080/api/products?page=2&size=3 

Get product with Id: 		http://localhost:8080/api/products/1

Get products sorted by price:           http://localhost:8080/api/products?sort=unitPrice 

Get products sorted by inventory:	http://localhost:8080/api/products?sort=inventory 

Get all product categories: 		http://localhost:8080/api/category 

Get product-category with id: 	http://localhost:8080/api/category/2 

Get products with category id: 	http://localhost:8080/api/products/search/findByCategoryId?id=2 

Get products with category id with paging: 
http://localhost:8080/api/products/search/findByCategoryId?id=2&page=1&size=2 

Get products with category id sorted by price:
http://localhost:8080/api/products/search/findByCategoryId?id=2&sort=unitPrice

Get products with category id sorted by inventory:
http://localhost:8080/api/products/search/findByCategoryId?id=2&sort=inventory




Sign Up Micro Service:
----------------------------------------

Get all users:  		      http://localhost:8081/api/users

Get users with paging: 	      http://localhost:8081/api/users?page=1&size=1

Get user with Id: 		       http://localhost:8081/api/users/1

Get all merchant types: 	       http://localhost:8081/api/merchant-type

Get merchant type with id:         http://localhost:8081/api/merchant-type/1

Get user with merchant type id: http://localhost:8081/api/users/search/findByMerchantTypeId?id=1 



*********************************************************************************************************
              MYSQL DATABASE SCRIPTS
*********************************************************************************************************


-- Create User


CREATE USER 'bestcommerceapp'@'localhost' IDENTIFIED BY 'bestcommerceapp';

GRANT ALL PRIVILEGES ON * . * TO 'bestcommerceapp'@'localhost';

ALTER USER 'bestcommerceapp'@'localhost' IDENTIFIED WITH mysql_native_password BY 'bestcommerceapp';



-- Create Schema

DROP SCHEMA IF EXISTS `bestcommerce`;

CREATE SCHEMA `bestcommerce`;

USE `bestcommerce` ;



-- Create Tables

CREATE TABLE IF NOT EXISTS `bestcommerce`.`category` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE=InnoDB
AUTO_INCREMENT = 1;



CREATE TABLE IF NOT EXISTS `bestcommerce`.`product` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,  
  `name` VARCHAR(255) DEFAULT NULL,
  `description` VARCHAR(255) DEFAULT NULL,
  `unit_price` DECIMAL(13,2) DEFAULT NULL,    
  `inventory` INT DEFAULT NULL,  
  `category_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_category` (`category_id`),
  CONSTRAINT `fk_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) 
ENGINE=InnoDB
AUTO_INCREMENT = 1;



CREATE TABLE IF NOT EXISTS `bestcommerce`.`payment` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `payment_name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE=InnoDB
AUTO_INCREMENT = 1;



CREATE TABLE IF NOT EXISTS `bestcommerce`.`delivery` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `delivery_name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE=InnoDB
AUTO_INCREMENT = 1;



CREATE TABLE IF NOT EXISTS `bestcommerce`.`product_payment` (
    PP_ID BIGINT NOT NULL AUTO_INCREMENT,
    PROD_ID BIGINT,
    PAY_ID BIGINT,
    PRIMARY KEY (PP_ID),
    FOREIGN KEY (PROD_ID) REFERENCES PRODUCT(ID),
    FOREIGN KEY (PAY_ID) REFERENCES PAYMENT(ID)
)
ENGINE=InnoDB
AUTO_INCREMENT = 1;



CREATE TABLE IF NOT EXISTS `bestcommerce`.`product_delivery` (
    PD_ID BIGINT NOT NULL AUTO_INCREMENT,
    PROD_ID BIGINT,
    DEL_ID BIGINT,
    PRIMARY KEY (PD_ID),
    FOREIGN KEY (PROD_ID) REFERENCES PRODUCT(ID),
    FOREIGN KEY (DEL_ID) REFERENCES DELIVERY(ID)
)
ENGINE=InnoDB
AUTO_INCREMENT = 1;



-- Add sample data

INSERT INTO CATEGORY(CATEGORY_NAME) VALUES ('Electronics');

INSERT INTO CATEGORY(CATEGORY_NAME) VALUES ('Fashion');

INSERT INTO CATEGORY(CATEGORY_NAME) VALUES ('Food');


INSERT INTO PAYMENT(PAYMENT_NAME) VALUES ('Direct');

INSERT INTO PAYMENT(PAYMENT_NAME) VALUES ('In installments');


INSERT INTO DELIVERY(DELIVERY_NAME) VALUES ('Delivery option-1');

INSERT INTO DELIVERY(DELIVERY_NAME) VALUES ('Delivery option-2');

INSERT INTO DELIVERY(DELIVERY_NAME) VALUES ('Delivery option-3');


INSERT INTO PRODUCT (NAME, DESCRIPTION, INVENTORY, UNIT_PRICE, CATEGORY_ID) VALUES ('Product-1', 'Product Description-1', 10, 5.25, 1);

INSERT INTO PRODUCT (NAME, DESCRIPTION, INVENTORY, UNIT_PRICE, CATEGORY_ID) VALUES ('Product-2', 'Product Description-2', 8, 3.25, 1);

INSERT INTO PRODUCT (NAME, DESCRIPTION, INVENTORY, UNIT_PRICE, CATEGORY_ID) VALUES ('Product-3', 'Product Description-3', 2, 6.00, 1);

INSERT INTO PRODUCT (NAME, DESCRIPTION, INVENTORY, UNIT_PRICE, CATEGORY_ID) VALUES ('Product-4', 'Product Description-4', 4, 10.25, 2);

INSERT INTO PRODUCT (NAME, DESCRIPTION, INVENTORY, UNIT_PRICE, CATEGORY_ID) VALUES ('Product-5', 'Product Description-5', 9, 7.50, 2);

INSERT INTO PRODUCT (NAME, DESCRIPTION, INVENTORY, UNIT_PRICE, CATEGORY_ID) VALUES ('Product-6', 'Product Description-6', 25, 8, 2);

INSERT INTO PRODUCT (NAME, DESCRIPTION, INVENTORY, UNIT_PRICE, CATEGORY_ID) VALUES ('Product-7', 'Product Description-7', 17, 15.50, 3);

INSERT INTO PRODUCT (NAME, DESCRIPTION, INVENTORY, UNIT_PRICE, CATEGORY_ID) VALUES ('Product-8', 'Product Description-8', 22, 12.25, 3);

INSERT INTO PRODUCT (NAME, DESCRIPTION, INVENTORY, UNIT_PRICE, CATEGORY_ID) VALUES ('Product-9', 'Product Description-9', 17, 16.75, 3);


INSERT INTO PRODUCT_PAYMENT(PROD_ID, PAY_ID) VALUES (1, 1);

INSERT INTO PRODUCT_PAYMENT(PROD_ID, PAY_ID) VALUES (1, 2);

INSERT INTO PRODUCT_PAYMENT(PROD_ID, PAY_ID) VALUES (2, 1);

INSERT INTO PRODUCT_PAYMENT(PROD_ID, PAY_ID) VALUES (3, 2);

INSERT INTO PRODUCT_PAYMENT(PROD_ID, PAY_ID) VALUES (4, 1);

INSERT INTO PRODUCT_PAYMENT(PROD_ID, PAY_ID) VALUES (4, 2);


INSERT INTO PRODUCT_DELIVERY(PROD_ID, DEL_ID) VALUES (1, 1);

INSERT INTO PRODUCT_DELIVERY(PROD_ID, DEL_ID) VALUES (1, 2);

INSERT INTO PRODUCT_DELIVERY(PROD_ID, DEL_ID) VALUES (1, 3);

INSERT INTO PRODUCT_DELIVERY(PROD_ID, DEL_ID) VALUES (2, 3);

INSERT INTO PRODUCT_DELIVERY(PROD_ID, DEL_ID) VALUES (3, 2);

INSERT INTO PRODUCT_DELIVERY(PROD_ID, DEL_ID) VALUES (4, 1);

INSERT INTO PRODUCT_DELIVERY(PROD_ID, DEL_ID) VALUES (4, 3);

INSERT INTO PRODUCT_DELIVERY(PROD_ID, DEL_ID) VALUES (5, 2);

INSERT INTO PRODUCT_DELIVERY(PROD_ID, DEL_ID) VALUES (6, 3);



-- Create Tables

CREATE TABLE IF NOT EXISTS `bestcommerce`.`merchant_type` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `merchant_type_name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE=InnoDB
AUTO_INCREMENT = 1;



CREATE TABLE IF NOT EXISTS `bestcommerce`.`users` (
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



INSERT INTO USERS(MERCHANT_TYPE_ID, MERCHANT_NAME, OWNER_NAME, ADDRESS, PHONE_NUMBER, EMAIL, PASSWORD) VALUES (2, 'Merchant Name-1', 'Owner Name-1', 'Address-1', 'Phone Number-1', 'email-1', 'password-1');


INSERT INTO USERS(MERCHANT_TYPE_ID, MERCHANT_NAME, OWNER_NAME, ADDRESS, PHONE_NUMBER, EMAIL, PASSWORD) VALUES (1, 'Merchant Name-2', 'Owner Name-2', 'Address-2', 'Phone Number-2', 'email-2', 'password-2');


INSERT INTO USERS(MERCHANT_TYPE_ID, MERCHANT_NAME, OWNER_NAME, ADDRESS, PHONE_NUMBER, EMAIL, PASSWORD) VALUES (2, 'Merchant Name-3', 'Owner Name-3', 'Address-3', 'Phone Number-3', 'email-3', 'password-3');


INSERT INTO USERS(MERCHANT_TYPE_ID, MERCHANT_NAME, OWNER_NAME, ADDRESS, PHONE_NUMBER, EMAIL, PASSWORD) VALUES (2, 'Merchant Name-4', 'Owner Name-4', 'Address-4', 'Phone Number-4', 'email-4', 'password-4');


INSERT INTO USERS(MERCHANT_TYPE_ID, MERCHANT_NAME, OWNER_NAME, ADDRESS, PHONE_NUMBER, EMAIL, PASSWORD) VALUES (1, 'Merchant Name-5', 'Owner Name-5', 'Address-5', 'Phone Number-5', 'email-5', 'password-5');
