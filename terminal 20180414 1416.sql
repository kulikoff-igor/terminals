-- Скрипт сгенерирован Devart dbForge Studio for MySQL, Версия 6.0.622.0
-- Домашняя страница продукта: http://www.devart.com/ru/dbforge/mysql/studio
-- Дата скрипта: 14.04.2018 14:16:45
-- Версия сервера: 5.5.28
-- Версия клиента: 4.1

-- 
-- Отключение внешних ключей
-- 
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;

-- 
-- Установка кодировки, с использованием которой клиент будет посылать запросы на сервер
--
SET NAMES 'utf8';

-- 
-- Установка базы данных по умолчанию
--
USE terminal;

--
-- Описание для таблицы merch_tab
--
DROP TABLE IF EXISTS merch_tab;
CREATE TABLE merch_tab (
  id_merch_tab INT(11) NOT NULL AUTO_INCREMENT,
  addr_1 VARCHAR(40) NOT NULL,
  addr_2 VARCHAR(15) NOT NULL,
  e_mail VARCHAR(30) NOT NULL,
  merch_name VARCHAR(25) NOT NULL,
  phone VARCHAR(13) NOT NULL,
  zipcode INT(11) NOT NULL,
  PRIMARY KEY (id_merch_tab)
)
ENGINE = INNODB
AUTO_INCREMENT = 4
AVG_ROW_LENGTH = 5461
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы t_model
--
DROP TABLE IF EXISTS t_model;
CREATE TABLE t_model (
  id_t_model INT(11) NOT NULL AUTO_INCREMENT,
  description VARCHAR(20) NOT NULL,
  PRIMARY KEY (id_t_model)
)
ENGINE = INNODB
AUTO_INCREMENT = 10
AVG_ROW_LENGTH = 1820
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы terms_desc
--
DROP TABLE IF EXISTS terms_desc;
CREATE TABLE terms_desc (
  id_term_desc INT(11) NOT NULL AUTO_INCREMENT,
  description VARCHAR(10) NOT NULL,
  PRIMARY KEY (id_term_desc)
)
ENGINE = INNODB
AUTO_INCREMENT = 6
AVG_ROW_LENGTH = 3276
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы trans_type_desc
--
DROP TABLE IF EXISTS trans_type_desc;
CREATE TABLE trans_type_desc (
  id_trans_type_desc INT(11) NOT NULL AUTO_INCREMENT,
  description VARCHAR(20) NOT NULL,
  PRIMARY KEY (id_trans_type_desc)
)
ENGINE = INNODB
AUTO_INCREMENT = 13
AVG_ROW_LENGTH = 1365
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы terminals
--
DROP TABLE IF EXISTS terminals;
CREATE TABLE terminals (
  id_terminals INT(11) NOT NULL AUTO_INCREMENT,
  addr_1 VARCHAR(40) NOT NULL,
  addr_2 VARCHAR(15) NOT NULL,
  term_name VARCHAR(22) NOT NULL,
  zipcode INT(11) NOT NULL,
  id_t_model INT(11) NOT NULL,
  id_merch_tab INT(11) NOT NULL,
  id_term_desc INT(11) NOT NULL,
  PRIMARY KEY (id_terminals),
  CONSTRAINT FK2du1yf4qkqblgr75su4r58g3 FOREIGN KEY (id_merch_tab)
    REFERENCES merch_tab(id_merch_tab) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT FK5pjpibk9ldta1r6t1cacsm49o FOREIGN KEY (id_term_desc)
    REFERENCES terms_desc(id_term_desc) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT FKlt6mhoxe67t0rw89go8rwwxcu FOREIGN KEY (id_t_model)
    REFERENCES t_model(id_t_model) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE = INNODB
AUTO_INCREMENT = 8
AVG_ROW_LENGTH = 4096
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы trans_scheme
--
DROP TABLE IF EXISTS trans_scheme;
CREATE TABLE trans_scheme (
  id_trans_scheme INT(11) NOT NULL AUTO_INCREMENT,
  description VARCHAR(255) DEFAULT NULL,
  number_trans_scheme INT(11) NOT NULL,
  id_trans_type_desc INT(11) NOT NULL,
  PRIMARY KEY (id_trans_scheme),
  CONSTRAINT FKbftxdn4dce9alx3dtsd6h593i FOREIGN KEY (id_trans_type_desc)
    REFERENCES trans_type_desc(id_trans_type_desc) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE = INNODB
AUTO_INCREMENT = 5
AVG_ROW_LENGTH = 4096
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы key_tab
--
DROP TABLE IF EXISTS key_tab;
CREATE TABLE key_tab (
  id_key_tab INT(11) NOT NULL AUTO_INCREMENT,
  key_authorization INT(11) NOT NULL,
  id_terminals INT(11) NOT NULL,
  PRIMARY KEY (id_key_tab),
  CONSTRAINT FKml8t8y3lbpref9obohxuyrklp FOREIGN KEY (id_terminals)
    REFERENCES terminals(id_terminals) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE = INNODB
AUTO_INCREMENT = 5
AVG_ROW_LENGTH = 4096
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы pid_group
--
DROP TABLE IF EXISTS pid_group;
CREATE TABLE pid_group (
  id_pid_group INT(11) NOT NULL AUTO_INCREMENT,
  number_pid_group INT(11) NOT NULL,
  id_terminals INT(11) NOT NULL,
  PRIMARY KEY (id_pid_group),
  CONSTRAINT FK77rps3duyw1spxqicmikmhlfu FOREIGN KEY (id_terminals)
    REFERENCES terminals(id_terminals) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE = INNODB
AUTO_INCREMENT = 5
AVG_ROW_LENGTH = 4096
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы term_currency
--
DROP TABLE IF EXISTS term_currency;
CREATE TABLE term_currency (
  id_term_currency INT(11) NOT NULL AUTO_INCREMENT,
  curr_1 VARCHAR(11) NOT NULL,
  curr_2 VARCHAR(11) DEFAULT NULL,
  curr_3 VARCHAR(11) DEFAULT NULL,
  curr_4 VARCHAR(11) DEFAULT NULL,
  id_terminals INT(11) NOT NULL,
  PRIMARY KEY (id_term_currency),
  CONSTRAINT FK4ui494jouiwg2a0tlbk0okun6 FOREIGN KEY (id_terminals)
    REFERENCES terminals(id_terminals) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE = INNODB
AUTO_INCREMENT = 5
AVG_ROW_LENGTH = 4096
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Описание для таблицы trans_pid_group
--
DROP TABLE IF EXISTS trans_pid_group;
CREATE TABLE trans_pid_group (
  id_trans_pid_group INT(11) NOT NULL AUTO_INCREMENT,
  id_pid_group INT(11) DEFAULT NULL,
  id_trans_scheme INT(11) DEFAULT NULL,
  number_pid_group INT(11) NOT NULL,
  number_trans_scheme INT(11) NOT NULL,
  PRIMARY KEY (id_trans_pid_group),
  CONSTRAINT FKga2l33x4ele167wd6b28roa5j FOREIGN KEY (number_trans_scheme)
    REFERENCES trans_scheme(id_trans_scheme) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT FKrcbstk2elrl1snfk5uv1uh48h FOREIGN KEY (number_pid_group)
    REFERENCES pid_group(id_pid_group) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE = INNODB
AUTO_INCREMENT = 2
CHARACTER SET utf8
COLLATE utf8_general_ci;

-- 
-- Вывод данных для таблицы merch_tab
--
INSERT INTO merch_tab VALUES
(1, 'УЛ.МИРА, 23', 'СОЛИГОРСК', 'passat@gmail.com', 'ООО ПАССАТ', '+375291234567', 222131),
(2, 'ПР-Т ЖЕЛЕЗНОДОРОЖНЫЙ, 45-2', 'МИНСК', 'finco@mail.ru', 'ОАО РАДУГА', '+375443838921', 200002),
(3, 'УЛ.КИРОВА, 4', 'МИНСК', 'balfol@mail.ru', 'ИП РУДЬКО П.Н.', '+375258765941', 232001);

-- 
-- Вывод данных для таблицы t_model
--
INSERT INTO t_model VALUES
(1, 'Ingenico'),
(2, 'VeriFone'),
(3, 'Spire'),
(4, 'NexGo'),
(5, 'МВВ-Трейд'),
(6, 'NCR'),
(7, 'VinCor'),
(8, 'Виртуальный терминал'),
(9, 'Касса');

-- 
-- Вывод данных для таблицы terms_desc
--
INSERT INTO terms_desc VALUES
(1, 'POS'),
(2, 'MPOS'),
(3, 'ATM'),
(4, 'E-COM'),
(5, 'CASH-IN');

-- 
-- Вывод данных для таблицы trans_type_desc
--
INSERT INTO trans_type_desc VALUES
(1, 'баланс'),
(2, 'снятие наличный'),
(3, 'перевод'),
(4, 'смена статуса'),
(5, 'возврат'),
(6, 'оплата\r\n'),
(7, 'пополнение'),
(8, 'списание'),
(9, 'опалата в атм'),
(10, 'бонусирование'),
(11, 'вычисление CAVV'),
(12, 'проверка счета');

-- 
-- Вывод данных для таблицы terminals
--
INSERT INTO terminals VALUES
(3, 'УЛ.ОКТЯБРЬСКАЯ, 12', 'СОЛИГОРСК', 'КОРОНА', 213001, 2, 1, 2),
(5, 'HELLO.BY', 'HELLO.BY', 'INTERNET', 222212, 8, 3, 4),
(6, 'УЛ.МАРШАЛЛА ЛОСИКА', 'ПАВИЛЬОН 10', 'МИНСК', 200310, 1, 2, 1),
(7, 'УЛ.ОКТЯБРЬСКАЯ, 13', 'СОЛИГОРСК', 'GREEN', 256301, 6, 1, 3);

-- 
-- Вывод данных для таблицы trans_scheme
--
INSERT INTO trans_scheme VALUES
(1, 'разршение операций олаты, баланса', 1, 1),
(2, 'разршение операций олаты, баланса', 1, 3),
(3, 'разршение операций олаты, баланса', 1, 6),
(4, 'разршение операций олаты, баланса', 1, 8);

-- 
-- Вывод данных для таблицы key_tab
--
INSERT INTO key_tab VALUES
(1, 456343242, 3),
(2, 45354123, 5),
(3, 374376378, 6),
(4, 43473786, 7);

-- 
-- Вывод данных для таблицы pid_group
--
INSERT INTO pid_group VALUES
(1, 1, 3),
(2, 1, 5),
(3, 2, 6),
(4, 3, 7);

-- 
-- Вывод данных для таблицы term_currency
--
INSERT INTO term_currency VALUES
(1, 'BYN', 'RUB', 'EUR', 'USD', 3),
(2, 'BYN', 'RUB', NULL, NULL, 5),
(3, 'BYN', 'EUR', NULL, NULL, 6),
(4, 'BYN', 'USD', NULL, NULL, 7);

-- 
-- Вывод данных для таблицы trans_pid_group
--

-- Таблица terminal.trans_pid_group не содержит данных

-- 
-- Включение внешних ключей
-- 
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;