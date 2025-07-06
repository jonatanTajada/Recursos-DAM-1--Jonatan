

create database if not exists ejercicio9;
use ejercicio9;

create table if not exists profesor(

	dni char(9) primary key check(dni regexp '^[0-9]{8}[A-Z a-z]$'),
    nombre varchar(50) not null,
    direccion varchar(50),
    telefono char(9) not null check(telefono regexp '^[0-9]{9}$')
);

create table if not exists alumno(

	expediente int auto_increment primary key,
    nombre varchar(50) not null,
    apellidos varchar(50) not null,
    fecha_nac date,
    expedienteDelegado int 
);

create table if not exists modulo(

	codigoExpediente int auto_increment,
    nombre varchar(50) not null,
    dniProfesor char(9),
    
    primary key(codigoExpediente, dniProfesor),
    constraint fk_codigoExpediente_alumno foreign key(codigoExpediente)references alumno(expediente) on delete cascade on update cascade,
    constraint fk_dniPorfesor_profesor foreign key(dniProfesor)references profesor(dni) on delete cascade on update cascade
);




















