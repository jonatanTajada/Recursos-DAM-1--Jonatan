#DROP database if exists PUBS;

create database if not exists pubs collate utf8mb4_spanish2_ci;
use pubs;

create table if not exists localidad(

	COD_LOCALIDAD varchar(3) primary key,
    NOMBRE varchar(50) not null
);

create table if not exists pub(

	COD_PUB char(3) primary key,
    NOMBRE varchar(50) not null,
    LICENCIA_FISCAL varchar(50) not null,
    DOMICILIO varchar(50),
    FECHA_APERTURA  int not null,
    HORARIO enum ('HOR1','HOR2', 'HOR3'),
    COD_LOCALIDAD char(3) not null,
    
		constraint fk_COD_LOCALIDAD foreign key(COD_LOCALIDAD) references localidad(COD_LOCALIDAD) on update cascade on delete cascade
);

create table if not exists titular(

	DNI_TITULAR char(3) primary key,
	NOMBRE varchar(50) not null,
	DOMICILIO varchar(50),
	COD_PUB char(3) not null,
    
		constraint fk_pub foreign key(COD_PUB) references PUB (COD_PUB) on update cascade on delete cascade
);

create table if not exists empleado(

	DNI_EMPLEADO varchar(3) primary key,
	NOMBRE varchar(50) not null,
	DOMICILIO varchar(50)
);


create table if not exists existencias(

	COD_ARTICULO int(3) primary key,
    NOMBRE varchar(50) not null,
    CANTIDAD int not null,
		constraint ch_CANTIDAD check (CANTIDAD > 0),
    PRECIO int not null,
    COD_PUB varchar(3) not null,
		constraint fk_COD_PUB foreign key(COD_PUB) references PUB(COD_PUB) on update cascade on delete cascade
);



create table if not exists pub_empleado(

	COD_PUB VARCHAR(3),
    DNI_EMPLEADO VARCHAR(3),
    FUNCION ENUM ('CAMARERO','SEGURIDAD','LIMPIEZA'),
    
		primary key(COD_PUB, DNI_EMPLEADO, FUNCION ),
		constraint fk_COD_PUB_pub_empleado foreign key(COD_PUB) references pub(COD_PUB) on update cascade on delete cascade,
		constraint fk_DNI_EMPLEADO foreign key(DNI_EMPLEADO) references empleado(DNI_EMPLEADO) on update cascade on delete cascade
);















