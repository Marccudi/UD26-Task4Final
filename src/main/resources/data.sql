#create database UD26T4;
#use UD26T4;
drop table if exists reservas;
drop table if exists equipos;
drop table if exists investigadores;
drop table if exists facultad;

create table facultad(
	codigo int auto_increment,
    nombre varchar(100),
    primary key (codigo)
);

create table equipos(
	num_serie char(4),
    nombre varchar(100),
    facultad int,
    primary key (num_serie),
    foreign key (facultad) references facultad(codigo)
);
create table investigadores(
	dni varchar(8),
    nomapels varchar(255),
    facultad int,
    primary key (dni),
    foreign key (facultad) references facultad(codigo)
);

create table reserva(
	id int auto_increment,
	dni varchar(8),
    num_serie char(4),
    comienzo datetime,
    fin datetime,
    primary key (id, dni, num_serie),
    foreign key (dni) references investigadores(dni),
    foreign key (num_serie) references equipos(num_serie)   
);


insert into facultad(nombre) values('RoviraVirgili');
insert into facultad(nombre) values('Papadelta');

insert into equipos(num_serie, nombre, facultad) values('1', 'px-1', 1);
insert into equipos(num_serie, nombre, facultad) values('2', 'px-2', 2);

insert into investigadores(dni, nomapels, facultad) values('12345678', 'Marc', 1);
insert into investigadores(dni, nomapels, facultad) values('23456789', 'Manolo', 1);

insert into reserva(dni, num_serie, comienzo, fin) values('12345678', '1', '2021-03-13 00:00:00', '2021-03-14 00:00:00');
