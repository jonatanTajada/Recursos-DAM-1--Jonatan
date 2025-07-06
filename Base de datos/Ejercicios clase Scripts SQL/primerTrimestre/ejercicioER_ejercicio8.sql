#drop database ejercicio8;
create database if not exists ejercicio8 collate utf8mb4_spanish2_ci;
use ejercicio8;

#drop table camionero;
create table if not exists camionero(

	dni char(9) primary key check(dni regexp '^[0-9]{8}[A-Z a-z]$'),
    poblacio varchar(50),
    nombre varchar(50) not null,
    telefono char(9) check(telefono regexp '^[0-9]{9}$'),
    direccion varchar(50) not null,
    salario int not null
		check(salario between 1500 and 3500)
);


create table if not exists  camion(

	matricula char(7) primary key check(matricula regexp '^[0-9]{4}[A-Z a-z]{3}$'),
    modelo varchar(50) not null,
    potencia int not null,
    tipo varchar(50)
);

create table if not exists provincia(

	codigo int auto_increment primary key,
    nombre varchar(50) not null
);


create table if not exists paquete(

	codigo int auto_increment primary key,
    descripcion varchar(50) not null,
    destinatario varchar(50) not null,
    direccion varchar(50) not null,
    dniCamionero char(9),
		constraint fk_dniCamionero_camionero foreign key(dniCamionero) references camionero(dni) on delete cascade on update cascade
);

create table if not exists conduce(

	dniCamionero char(9),
    matriculaCamion char(7),
    
    primary key(dniCamionero, matriculaCamion),
    
		constraint fk_dniCamionero_camionero_conduce foreign key(dniCamionero) references camionero(dni) on delete cascade on update cascade,
        constraint fk_matriculaCamion_camion foreign key(matriculaCamion) references camion(matricula) on delete cascade on update cascade
);


