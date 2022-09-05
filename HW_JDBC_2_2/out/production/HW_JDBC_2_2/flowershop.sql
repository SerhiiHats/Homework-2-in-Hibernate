CREATE DATABASE flowershop;
-- DROP DATABASE flowershop;

USE flowershop;

CREATE TABLE flower(
id INT AUTO_INCREMENT PRIMARY KEY,
name_fl VARCHAR(100),
color_fl VARCHAR(50),
date_add_fl DATETIME,
time_storage_fl INT,
length_fl INT,
price DOUBLE);


CREATE TABLE accessories(
id INT AUTO_INCREMENT PRIMARY KEY,
name_ac VARCHAR (100),
description_ac VARCHAR(255),
date_add_ac DATETIME,
time_storage_ac INT,
price DOUBLE);

CREATE TABLE buket(
id_buk INT AUTO_INCREMENT PRIMARY KEY,
name_buk VARCHAR (100));

CREATE TABLE buket_deteils(
id_bd INT AUTO_INCREMENT PRIMARY KEY,
id_buk INT,
tovor_group VARCHAR(100),
id INT,
FOREIGN KEY(id_buk) REFERENCES buket(id_buk)
);

INSERT INTO flower (name_fl, color_fl, date_add_fl, time_storage_fl, length_fl, price) 
VALUES
('тюльпан', 'желтый', now(), 127, 30,  50.5),
('хризантема', 'белый', now(), 100, 40, 67.5),
('хризантема', 'розовый', now(), 95, 45,  70.5),
('альстромерия', 'белый', now(), 110, 55,  75.5),
('хризантема', 'красный', now(), 105, 31,  70.5);

INSERT INTO accessories(name_ac, description_ac, date_add_ac, time_storage_ac, price) VALUES
('бумага для букетов', 'подарочная, принт газетный 100 х 100', now(), 17520, 75.5),
('коробка для букетов', 'круглая, принт франция 30 х 30', now(), 10000, 120.0),
('лента для букетов', 'розовая 15 х 40', now(), 15575, 20.0);

INSERT INTO buket (name_buk) VALUES ('летние краски');

INSERT INTO buket_deteils (id_buk, tovor_group, id) VALUES
(1, 'flower', 2),
(1, 'flower', 3),
(1, 'flower', 5),
(1, 'accessories', 1),
(1, 'accessories', 3);

SELECT * FROM buket_deteils WHERE id_buk = 1;

SELECT f.name_fl, f.color_fl, f.date_add_fl, f.price FROM flower AS f
INNER JOIN buket_deteils AS bd ON bd.id = f.id
WHERE bd.tovor_group = 'flower';


SELECT a.name_ac, a.description_ac, a.date_add_ac, a.time_storage_ac,a.price FROM accessories AS a
INNER JOIN buket_deteils AS bd ON bd.id = a.id
WHERE bd.tovor_group = 'accessories';

INSERT INTO buket_deteils (id_buk, tovor_group, id) VALUES (1, 'Accessories', 2);

