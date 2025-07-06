drop database if exists ventas;
create database if not exists ventas character set latin1;
use ventas;

create table if not exists cliente(
	id int unsigned auto_increment primary key,
    nombre varchar(25),
    primer_apellido varchar(15) not null,
    ciudad varchar(100),
    categoria int unsigned


);

create table if not exists comercial(
	id int unsigned auto_increment primary key,
    nombre varchar(100) not null,
    apellido1 varchar(100) not null,
    apellido2 varchar(100),
    ciudad varchar(100),
    comision float
);



/*
1.	Una vez que ha ejecutado el script y ha creado la base de datos en MySQL Server,
 ¿qué sentencia SQL debería ejecutar para modificar el encoding de la base de datos y utilizar utf8mb4 en lugar de latin1?
 
 alter database ventas 
 character set utf8mb4 collate utf8mb4_unicode_ci;
*/


/*
2.	Modifique la columna nombre de la tabla cliente para que pueda almacenar cadenas de hasta 100 caracteres y para que no pueda ser NULL.

alter table cliente
modify column nombre varchar(100) not null;
*/


/*
3.	¿Qué comando puede ejecutar para comprobar que el cambio que se ha realizado en el paso anterior se ha ejecutado correctamente?
show columns from cliente like 'nombre';   ---esto muestra solo la columna que especificas
DESCRIBE cliente;   ---esto muestra todas las columnas de la tabla
*/


/*
4.	Modifique el nombre de la columna primer_apellido y asígnele apellido1. 
También tendrá que permitir que pueda almacenar hasta 100 caracteres y que no pueda ser un valor NULL.

alter table cliente
change column primer_apellido apellido1 varchar(100) not null;

show columns from cliente like 'apellido1';
*/


/*
5.	Añada una nueva columna a la tabla cliente para poder almacenar el segundo apellido. La columna se debe llamar apellido2
 debe estar entre la columna apellido1 y ciudad, puede almacenar hasta 100 caracteres y puede ser NULL.

alter table cliente
add column apellido2 varchar(100) after apellido1 ;
*/


/*
6.	Elimine la columna categoria de la tabla cliente.

alter table cliente
drop column categoria;
*/


/*
7.	Modifique la columna comision de la tabla comercial para que almacene por defecto el valor 10.

alter table comercial
modify column comision float default 10;
*/


/*
8.	Insertar dos clientes nuevos en la tabla clientes.

insert into cliente (nombre,apellido1, apellido2, ciudad)
values ('jonatan','tajada', 'rico', 'barakaldo'),
	   ('maria','sanchez', 'perez', 'bilbao');
*/






