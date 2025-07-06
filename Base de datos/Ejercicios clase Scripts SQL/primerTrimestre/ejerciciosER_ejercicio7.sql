#drop database ejercicio7;
create database ejercicio7;

use ejercicio7;

create table if not exists cliente(

	dni char(9) primary key check(dni regexp '^[0-9]{8}[A-Z a-z]$'),
    apellidos varchar(50) not null,
    fecha_nac date,
    telefono char(9) check(telefono regexp '^[0-9]{9}$')
);


create table if not exists proveedor(

	nif char(9) primary key check (nif regexp '^[0-9]{8}[A-Z a-z]$'),
	nombre char(50) not null,
    direccion varchar(50) not null

);


create table if not exists producto(

	codigo int auto_increment primary key,
	nombre varchar(25) not null,
    precio int
		constraint ch_precio_producto check(precio > 0),
   nifProveedor char(9),
		constraint fk_nifProveedor_proveedor foreign key(nifProveedor) references proveedor(nif) on delete cascade on update cascade
        #CHECK (nifProveedor REGEXP '^[0-9]{8}[A-Za-z]$') no me deja, porque no puedo usar un restriccion check en una foreign key
);

create table if not exists compras(
	dniCliente char(9) ,
    codigoProducto int,
		primary key(dniCliente, codigoProducto),
        constraint fk_dniCliente_cliente foreign key(dniCliente) references cliente(dni) on delete cascade on update cascade,
        constraint fk_codigoProducto_producto foreign key(codigoProducto) references producto(codigo) on delete cascade on update cascade
        #check(dniCliente regexp '^[0-9]{8}[A-Z a-z]$')
);



