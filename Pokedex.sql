create database pokedex;

use pokedex;

create table Users (
username varchar(30) primary key,
pass varchar(30) not null
);

create table Pokemons (
idPoke int primary key,
Nombre varchar(30) not null,
Peso double,
Altura double,
Tipo varchar(30),
Tipo2 varchar(30)
);

insert into Pokemons
values
(1, 'Bulbasur',6.9,0.7,'Planta','Venenoso');

insert into Pokemons
values
(2, 'Ivysaur',13.0,1.0,'Planta','Venenoso'),
(3, 'Venusaur',100.0,2.0,'Planta','Venenoso'),
(4,'Charmander',8.5,0.6,'Fuego',null),
(5,'Charmeleon',19.0,1.1,'Fuego',null),
(6, 'Charizard',90.5,1.7,'Fuego','Volador'),
(7, 'Squirtle',9.0,0.5,'Agua',null),
(8, 'Wartortle',22.5,1.0,'Agua',null),
(9, 'Blastoise',85.5,1.6,'Agua',null);

select * from Users;

select * from Pokemons;
