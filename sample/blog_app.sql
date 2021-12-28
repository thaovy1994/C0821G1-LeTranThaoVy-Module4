DROP DATABASE IF EXISTS blog_app;
CREATE DATABASE blog_app;
USE blog_app;

insert into category(`name`) values
("category-1"),
("category-2"),
("category-3");

insert into blog(`name`,content,note,category_id) values
('Gongcha Milktea',"Gongcha Đà Nẵng","vị tráí cây, trà kem sữa",1),
('Highland Coffee',"Highland Đà Nẵng","trà vải, freeze trà xanh",1),
('Jollibee',"Jollibee Hải Châu","gà giòn, gà sốt cay, mỳ ý",1),
('Lotteria',"Lotte mart","gà sốt trứng muối, burger, drink",2),
('Phuc Long',"Phuc Long NVL","hồng trà sữa, oolong sữa, trà vải",2),
('KFC',"KFC Lê Duẩn","gà Hot Wings, toasted tart, burger",2),
('Bon Bon Milktea',"Bon Bon Đống Đa","ts phô mai viên, ts nướng, ts đặc biệt",3),
('Be U',"Bánh trang be U","bánh tráng bơ, bánh tráng trộn, xoài ruốc",3),
('Ezi Coffee',"Ezi Đà Nẵng", "phô mai viên, thạch tá lả",3);