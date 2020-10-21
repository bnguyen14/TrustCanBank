CREATE USER 'trustcanbank'@'localhost' IDENTIFIED BY 'trustcanbank';

GRANT ALL PRIVILEGES ON * . * TO 'trustcanbank'@'localhost';

ALTER USER 'trustcanbank'@'localhost' IDENTIFIED WITH mysql_native_password BY 'admin';