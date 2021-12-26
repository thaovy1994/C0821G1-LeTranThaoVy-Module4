DROP DATABASE IF EXISTS product_management;
CREATE DATABASE product_management;
USE product_management;

CREATE TABLE product(
id varchar(20) primary key,
`name` varchar(20) NOT NULL,
price double,
`description` varchar(45),
producer varchar(20) NOT NULL
);

insert into product(id,`name`,price,`description`,producer) values
("SP-01",'Fresh Milk',12000,"no sugar","Vnmilk"),
("SP-02",'Socola Milk',15000,"socola","Nuti"),
("SP-03",'Yogurt Milk',18000,"orginal","Vnmilk");