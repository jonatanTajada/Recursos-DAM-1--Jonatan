create database if not exists clienteProductos collate utf8mb4_spanish2_ci;

use  clienteProductos;


create table cliente(

idCliente char(3) auto_increment primary key,
nombre varchar(50) not null
);


create table producto(
idProducto char(3) auto_increment primary key,
nombre varchar(9) not null,
dir varchar(12) not null


);

create table productoCliente(
idCliente char(3),
idProducto char(3),
cantidad int not null
	constraint ch_cantidad check (cantidad between 1 and 100),
    
    primary key (idCliente, idProducto),
	constraint fk_idCliente_cliente foreign key (idCliente) references cliente(idCliente) on delete cascade on update cascade,
    constraint fk_idProducto_producto foreign key(idProducto) references producto(idProducto) on delete cascade on update,

);

alter table cliente
modify column idCliente int auto_increment;

alter table producto
modify column idProducto int auto_increment ;









