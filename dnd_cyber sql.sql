create database dnd_cyber;
use dnd_cyber;

CREATE TABLE dm (
id_dm INT NOT NULL AUTO_INCREMENT,
name_dm VARCHAR (15) NOT NULL,
PRIMARY KEY (id_dm)
);

CREATE TABLE adventure (
id_adv INT NOT NULL AUTO_INCREMENT,
name_adv VARCHAR (20) NOT NULL,
id_dm INT NOT NULL,
PRIMARY KEY (id_adv),
FOREIGN KEY (id_dm) REFERENCES dm(id_dm),
UNIQUE uc_adv(name_adv, id_dm)
);

CREATE TABLE class (
id_class INT NOT NULL AUTO_INCREMENT,
name_class VARCHAR (15) NOT NULL,
PRIMARY KEY (id_class)
);

CREATE TABLE race (
id_race INT NOT NULL AUTO_INCREMENT,
name_race VARCHAR (15) NOT NULL,
PRIMARY KEY (id_race)
);

CREATE TABLE player (
id_player INT NOT NULL AUTO_INCREMENT,
name_player VARCHAR (15) NOT NULL,
PRIMARY KEY (id_player)
);

CREATE TABLE pc (
id_pc INT NOT NULL AUTO_INCREMENT,
name_pc VARCHAR (20) NOT NULL,
id_class INT NOT NULL,
id_race INT NOT NULL,
id_player INT NOT NULL,
PRIMARY KEY (id_pc),
FOREIGN KEY (id_class) REFERENCES class(id_class),
FOREIGN KEY (id_race) REFERENCES race(id_race),
FOREIGN KEY (id_player) REFERENCES player(id_player)
);

CREATE TABLE party (
id_adv INT NOT NULL,
id_pc INT NOT NULL,
FOREIGN KEY (id_adv) REFERENCES adventure(id_adv),
FOREIGN KEY (id_pc) REFERENCES pc(id_pc)
);