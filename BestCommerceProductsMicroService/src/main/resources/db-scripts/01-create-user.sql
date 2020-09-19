-- Create User

CREATE USER 'bestcommerceapp'@'localhost' IDENTIFIED BY 'bestcommerceapp';

GRANT ALL PRIVILEGES ON * . * TO 'bestcommerceapp'@'localhost';

ALTER USER 'bestcommerceapp'@'localhost' IDENTIFIED WITH mysql_native_password BY 'bestcommerceapp';