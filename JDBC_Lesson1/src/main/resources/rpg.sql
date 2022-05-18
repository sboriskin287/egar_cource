CREATE TABLE Hero
(
    id     integer generated always as identity (maxvalue 1024)
        constraint Hero_pkey primary key,
    name   varchar(64)   not null,
    health numeric(6, 2) not null,
    damage numeric(6, 2) not null
);

CREATE TABLE Archer
(
    id      integer generated always as identity (maxvalue 1024)
        constraint Archer_pkey primary key,
    hero_id integer not null
        constraint Hero_fk REFERENCES Hero (id)
);

CREATE TABLE Warrior
(
    id      integer generated always as identity (maxvalue 1024)
        constraint Warrior_pkey primary key,
    hero_id integer not null
        constraint Hero_fk REFERENCES Hero (id)
);

CREATE TABLE Mage
(
    id      integer generated always as identity (maxvalue 1024)
        constraint Mage_pkey primary key,
    mana    integer not null,
    hero_id integer not null
        constraint Hero_fk REFERENCES Hero (id)
);

CREATE TABLE Elf
(
    id      integer generated always as identity (maxvalue 1024)
        constraint Elf_pkey primary key,
    hero_id integer not null
        constraint Hero_fk REFERENCES Hero (id)
);

CREATE TABLE Dwarf
(
    id      integer generated always as identity (maxvalue 1024)
        constraint Dwarf_pkey primary key,
    hero_id integer not null
        constraint Hero_fk REFERENCES Hero (id)
);

create table Item
(
    id      integer generated always as identity (maxvalue 1024)
        constraint Item_pkey
            primary key,
    type    smallint not null,
    value   integer  not null,
    hero_id integer  not null
        constraint Hero_fk REFERENCES Hero (id)
);

CREATE TABLE Location
(
    id     integer generated always as identity (maxvalue 1024)
        constraint Location_pkey primary key,
    x_cord numeric(10, 2) not null,
    y_cord numeric(10, 2) not null,
    name   varchar(64),
    type   smallint
);

create table Task
(
    id          integer generated always as identity (maxvalue 1024)
        constraint Task_pkey primary key,
    name        varchar(128),
    location_id integer NOT NULL
        CONSTRAINT Location_fk references Location (id),
    award       integer
);

create table Hero_Task
(
    hero_id integer
        CONSTRAINT Hero_fk REFERENCES Hero (id),
    task_id integer
        CONSTRAINT Task_fk REFERENCES Task (id),
    primary key (hero_id, task_id)
);

INSERT INTO Hero (name, health, damage) VALUES ('Archer 1', 100, 100);
INSERT INTO Archer (hero_id) SELECT max(id) FROM Hero;

INSERT INTO Hero (name, health, damage) VALUES ('Archer 2', 50, 150);
INSERT INTO Archer (hero_id) SELECT max(id) FROM Hero;

INSERT INTO Hero (name, health, damage) VALUES ('Archer 3', 30, 160);
INSERT INTO Archer (hero_id) SELECT max(id) FROM Hero;

INSERT INTO Hero (name, health, damage) VALUES ('Archer 4', 130, 10);
INSERT INTO Archer (hero_id) SELECT max(id) FROM Hero;

INSERT INTO Hero (name, health, damage) VALUES ('Archer 5', 1200, 700);
INSERT INTO Archer (hero_id) SELECT max(id) FROM Hero;


INSERT INTO Hero (name, health, damage) VALUES ('Warrior 1', 100, 100);
INSERT INTO Warrior (hero_id) SELECT max(id) FROM Hero;

INSERT INTO Hero (name, health, damage) VALUES ('Warrior 2', 60, 250);
INSERT INTO Warrior (hero_id) SELECT max(id) FROM Hero;

INSERT INTO Hero (name, health, damage) VALUES ('Warrior 3', 80, 350);
INSERT INTO Warrior (hero_id) SELECT max(id) FROM Hero;

INSERT INTO Hero (name, health, damage) VALUES ('Warrior 4', 170, 170);
INSERT INTO Warrior (hero_id) SELECT max(id) FROM Hero;

INSERT INTO Hero (name, health, damage) VALUES ('Warrior 5', 500, 860);
INSERT INTO Warrior (hero_id) SELECT max(id) FROM Hero;


INSERT INTO Hero (name, health, damage) VALUES ('Mage 1', 100, 100);
INSERT INTO Mage (hero_id, mana) VALUES ((SELECT max(id) FROM Hero), 100);

INSERT INTO Hero (name, health, damage) VALUES ('Mage 2', 650, 150);
INSERT INTO Mage (hero_id, mana) VALUES ((SELECT max(id) FROM Hero),150);

INSERT INTO Hero (name, health, damage) VALUES ('Mage 3', 3, 1160);
INSERT INTO Mage (hero_id, mana) VALUES ((SELECT max(id) FROM Hero), 200);

INSERT INTO Hero (name, health, damage) VALUES ('Mage 4', 330, 410);
INSERT INTO Mage (hero_id, mana) VALUES ((SELECT max(id) FROM Hero), 250);

INSERT INTO Hero (name, health, damage) VALUES ('Mage 5', 2230, 580);
INSERT INTO Mage (hero_id, mana) VALUES ((SELECT max(id) FROM Hero), 400);


INSERT INTO Hero (name, health, damage) VALUES ('Elf 1', 100, 100);
INSERT INTO Elf (hero_id) SELECT max(id) FROM Hero;

INSERT INTO Hero (name, health, damage) VALUES ('Elf 2', 80, 250);
INSERT INTO Elf (hero_id) SELECT max(id) FROM Hero;

INSERT INTO Hero (name, health, damage) VALUES ('Elf 3', 90, 860);
INSERT INTO Elf (hero_id) SELECT max(id) FROM Hero;

INSERT INTO Hero (name, health, damage) VALUES ('Elf 4', 430, 60);
INSERT INTO Elf (hero_id) SELECT max(id) FROM Hero;

INSERT INTO Hero (name, health, damage) VALUES ('Elf 5', 1200, 8500);
INSERT INTO Elf (hero_id) SELECT max(id) FROM Hero;


INSERT INTO Hero (name, health, damage) VALUES ('Dwarf 1', 100, 100);
INSERT INTO Dwarf (hero_id) SELECT max(id) FROM Hero;

INSERT INTO Hero (name, health, damage) VALUES ('Dwarf 2', 80, 150);
INSERT INTO Dwarf (hero_id) SELECT max(id) FROM Hero;

INSERT INTO Hero (name, health, damage) VALUES ('Dwarf 3', 30, 160);
INSERT INTO Dwarf (hero_id) SELECT max(id) FROM Hero;

INSERT INTO Hero (name, health, damage) VALUES ('Dwarf 4', 130, 60);
INSERT INTO Dwarf (hero_id) SELECT max(id) FROM Hero;

INSERT INTO Hero (name, health, damage) VALUES ('Dwarf 5', 1200, 700);
INSERT INTO Dwarf (hero_id) SELECT max(id) FROM Hero;

INSERT INTO Item (type, value, hero_id) VALUES (1, 200, 1);
INSERT INTO Item (type, value, hero_id) VALUES (1, 250, 2);
INSERT INTO Item (type, value, hero_id) VALUES (2, 169, 3);
INSERT INTO Item (type, value, hero_id) VALUES (2, 958, 4);
INSERT INTO Item (type, value, hero_id) VALUES (3, 165, 5);
INSERT INTO Item (type, value, hero_id) VALUES (3, 365, 6);
INSERT INTO Item (type, value, hero_id) VALUES (2, 200, 7);
INSERT INTO Item (type, value, hero_id) VALUES (2, 347, 8);
INSERT INTO Item (type, value, hero_id) VALUES (1, 426, 9);
INSERT INTO Item (type, value, hero_id) VALUES (1, 229, 2);

INSERT INTO Location (x_cord, y_cord, name, type) VALUES (65,67,'Minos Tirit', 1);
INSERT INTO Location (x_cord, y_cord, name, type) VALUES (128,254,'Rivendel', 1);
INSERT INTO Location (x_cord, y_cord, name, type) VALUES (78,489,'Shir', 1);
INSERT INTO Location (x_cord, y_cord, name, type) VALUES (22,29,'Gorgorot', 1);
INSERT INTO Location (x_cord, y_cord, name, type) VALUES (356,459,'Minos Morgul', 1);
INSERT INTO Location (x_cord, y_cord, name, type) VALUES (784,269,'Edoras', 1);

INSERT INTO Task (name, location_id, award) VALUES ('Task1', 1, 100);
INSERT INTO Task (name, location_id, award) VALUES ('Task1', 1, 200);
INSERT INTO Task (name, location_id, award) VALUES ('Task1', 2, 50);
INSERT INTO Task (name, location_id, award) VALUES ('Task1', 3, 1200);
INSERT INTO Task (name, location_id, award) VALUES ('Task1', 4, 1000);
INSERT INTO Task (name, location_id, award) VALUES ('Task1', 5, 100);
