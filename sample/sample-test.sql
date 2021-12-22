DROP DATABASE IF EXISTS sample;
CREATE DATABASE sample;
USE sample;

CREATE TABLE student(
id varchar(20) primary key,
`name` varchar(20) NOT NULL,
dateOfBirth date NOT NULL,
gender bit NOT NULL,
grade int
);

insert into student(id,`name`,dateOfBirth,gender,grade) values
(1,'haiTT','1998/1/1',1,7.0),
(2,'trungDP','1998/1/2',1,7.0),
(3,'TrungDC','1998/1/3',1,7.0);