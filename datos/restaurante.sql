drop database if exists restaurante;
create database restaurante;

use restaurante;

create table plato(
    id int AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30),
    calorias FLOAT,
    precio FLOAT
);

create table trabajador(
    id int AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30),
    apellidos VARCHAR(50),
    dni VARCHAR(9),
    telefono VARCHAR(9),
    usuario VARCHAR(30),
    password VARCHAR(30)
);

create table establecimiento(
    id int AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30),
    localidad VARCHAR(50),
    trabajadores int
);

insert into trabajador(usuario, password) values ('admin','12345');
