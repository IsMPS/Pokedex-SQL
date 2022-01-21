create database pokedex;

use pokedex;

create table Users (
username varchar(30) primary key,
pass varchar(30) not null
);

create table Pokemons (
idPoke int primary key,
NombrePoke varchar(30) not null,
Peso double,
Altura double,
ID_Tipo int,
ID_Tipo2 int
);

create table Tipos (
ID_Tipo int primary key,
NombreTipo varchar(30) not null
);

alter table Pokemons 
add foreign key (ID_Tipo) references Tipos (ID_Tipo),
add foreign key (ID_Tipo2) references Tipos (ID_Tipo);

insert into Tipos
values
(0,'Ninguno'),
(1, 'Acero'),
(2, 'Agua'),
(3, 'Bicho'),
(4, 'Dragon'),
(5, 'Electrico'),
(6, 'Fantasma'),
(7, 'Fuego'),
(8, 'Hada'),
(9, 'Hielo'),
(10, 'Lucha'),
(11, 'Normal'),
(12, 'Planta'),
(13, 'Psiquico'),
(14, 'Roca'),
(15, 'Siniestro'),
(16, 'Tierra'),
(17, 'Veneno'),
(18, 'Volador');

insert into Pokemons
values
(1, 'Bulbasur',6.9,0.7,12,17);

insert into Pokemons
values
(2, 'Ivysaur',13.0,1.0,12,17),
(3, 'Venusaur',100.0,2.0,12,17),
(4,'Charmander',8.5,0.6,7,null),
(5,'Charmeleon',19.0,1.1,7,null),
(6, 'Charizard',90.5,1.7,7,18),
(7, 'Squirtle',9.0,0.5,2,null),
(8, 'Wartortle',22.5,1.0,2,null),
(9, 'Blastoise',85.5,1.6,2,null);

create view PokeComple as 
select p.idPoke 'Numero', p.NombrePoke 'Nombre', p.Peso, p.Altura, t.NombreTipo from Pokemons p
inner join Tipos t on t.ID_Tipo=p.ID_Tipo;

select * from PokeComple;

select * from Users;

select * from Pokemons;
