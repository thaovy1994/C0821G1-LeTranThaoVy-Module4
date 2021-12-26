DROP DATABASE IF EXISTS customer_management;
CREATE DATABASE customer_management;
USE customer_management;

CREATE TABLE customer(
id varchar(20) primary key,
`name` varchar(20) NOT NULL,
email varchar(45),
address varchar(50)
);