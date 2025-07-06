create database if not exists empresa collate utf8mb4_spanish2_ci;
use empresa;

create table if not exists Depart(
	DEPT_NO int primary key
		constraint ch_Depart_Dept_no check( DEPT_NO between 1 and 10),
	DNOMBRE varchar(40) not null unique,
    LOC varchar(40) not null
);


create table if not exists Emple(
	Emp_No int primary key 
		constraint ch_Emple_Emp_No check(Emp_No > 0),
	Apellido varchar(40) not null,
    Oficio enum ('EMPLEADO','VENDEDOR','DIRECTOR','ANALISTA','PROGRAMADOR','PRESIDENTE') not null,
    Dir int,
		constraint fk_Emple_Dir foreign key(Dir) references Emple(Emp_No) on update cascade, /* relacion reflexiva*/
	Fecha_Alt Date not null,
    Salario float not null
		constraint ch_Salario check(Salario >= 600),
   Comision float
		constraint ch_Comision check(Comision >= 0),
   DEPT_NO int default 10 not null, 
	constraint fk_DEPT_NO_Emple foreign key(DEPT_NO) references Depart(DEPT_NO) on update cascade
 
);




