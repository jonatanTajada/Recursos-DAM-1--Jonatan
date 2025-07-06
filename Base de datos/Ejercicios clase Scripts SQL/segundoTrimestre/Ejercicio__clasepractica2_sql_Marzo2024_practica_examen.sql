drop database if exists clasepractica2_sql_Marzo2024_practica_examen;
create database if not exists clasepractica2_sql_Marzo2024_practica_examen collate utf8mb4_spanish2_ci;
use clasepractica2_sql_Marzo2024_practica_examen;

create table if not exists Depart(
    DEPT_NO int primary key,
    NOMBRE_DEPT varchar(40) not null,
    LOC varchar(40) not null
);

create table if not exists Emple(
    Codigo varchar(40) primary key, 
    Nombre VARCHAR(40) NOT NULL,
    Apellido varchar(40) not null,
    Edad int(3),
    Oficio enum ('EMPLEADO','VENDEDOR','DIRECTOR', 'CONTABILIDAD', 'ANALISTA','PRESIDENTE') not null,
    Dir varchar(40),
    Fecha_Alt Date not null,
    Salario float not null,
    Comision float,
    DEPT_NO int not null, 
    constraint fk_DEPT_NO_Emple foreign key(DEPT_NO) references Depart(DEPT_NO) on update cascade
);

insert into Depart (DEPT_NO, NOMBRE_DEPT, LOC) VALUES
(10, 'Desarrollo del software', 'Madrid'),
(20, 'Analisis sistema', 'Bilbao'),
(30, 'Contabilidad', 'Sevilla'),
(40, 'Ventas', 'Cadiz'),
(50, 'Ventas online', 'Madrid');

insert into Emple (Codigo, Nombre, Apellido, Edad, Oficio, Dir, Fecha_Alt, Salario, Comision, DEPT_NO) VALUES
('281-160483-0005F', 'Hector', 'Rodriguez', 27, 'Vendedor', 'Leon', '1986-05-12', 12000, 0, 50),
('081-130678-0004S', 'Julio', 'Benito', 27, 'Analista', 'Ponferrada', '1982-07-14', 13000, 1500, 20),
('281-040483-0056P', 'José', 'Ruiz', 31, 'Director', 'Madrid', '1992-06-05', 16700, 1200, 30),
('281-160473-0009Q', 'Carmen', 'Delgado', 37, 'Vendedor', 'Bilbao', '1996-03-02', 13400, 0, 40),
('281-160493-0005F', 'Luis', 'Montes', 17, 'Contabilidad', 'Bilbao', '2000-08-12', 16309, 1000, 30),
('281-240784-0004Y', 'Alfonso', 'Esquivel', 26, 'Presidente', 'Cadiz', '2010-02-22', 15000, 0, 30),
('281-161277-0008R', 'Asier', 'Perez', 32, 'Empleado', 'Sevilla', '2015-03-25', 16690, 0, 10);


-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--		-- RESUELVA LAS SIGUIENTES CONSULTAS EN SQL:	--
-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
#	1.	Mostrar los nombres de los empleados ordenados alfabéticamente (Z…A)
select nombre
from emple
order by nombre desc;

#	2.	Seleccionar el nombre, el oficio y la localidad de los departamentos donde trabajan los Vendedores.
select e.nombre as 'Nombre empleado', e.oficio, d.loc as 'Ubicacion-localidad del departamento'
from emple e
join depart d on e.dept_no=d.dept_no
where oficio = 'vendedor'
;

#	3.	Listar los nombres de los empleados cuyo nombre termine con la letra ‘o’.
select nombre
from emple
where nombre like '%o';

#	4.	Seleccionar el nombre, el oficio y salario de los empleados que trabajan en Leon.
select e.nombre as 'Nombre empleado', e.oficio, e.salario, d.loc as 'Localidad'
from emple e
join depart d on e.dept_no=d.dept_no
where e.dir = 'León'
;

#	5.	Seleccionar el nombre, salario y localidad donde trabajan de los empleados que tengan un salario entre 10000 y 13000.
select e.nombre, e.salario, d.loc as 'Localidad'
from emple e
join depart d on e.dept_no=d.dept_no
where salario between 10000 and 13000
;

#	6.	Visualizar los departamentos con más de 5 empleados.
select d.NOMBRE_DEPT, count(*) as 'Cantidad de Empleados'
from emple e
join depart d on e.dept_no = d.dept_no
group by d.NOMBRE_DEPT
having count(*) > 5;

#	7.	Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo oficio que ‘Alfonso Esquivel’.
select e.nombre as 'Nombre Empleado', e.salario, d.nombre_dept as 'departamento' 
from emple e
join depart d on e.dept_no=d.dept_no
where e.oficio = (select oficio from emple where nombre = 'Alfonso' and apellido = 'Esquivel' )
;

#	8.	Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo oficio que “Luis Montes” y que no tengan comisión.
select e.nombre as 'Nombre Empleado', e.salario, d.nombre_dept as 'departamento' 
from emple e
join depart d on e.dept_no= d.dept_no
where e.oficio = (select oficio from emple where nombre = 'Luis' and apellido = 'Montes') 
and comision = 0;

#	9.	Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
select *
from emple e
join depart d on e.dept_no=d.dept_no
where e.oficio = 'Contabilidad'
order by e.nombre 
;

#	10.	Nombre de los empleados que trabajan en León y cuyo oficio sea analista o empleado.
select e.nombre, d.loc as 'localidad departamento', e.oficio
from emple e
join depart d on e.dept_no = d.dept_no
where e.dir = 'Leon' and (e.oficio = 'Analista' or e.oficio = 'Empleado');

#	11.	Calcula el salario medio de todos los empleados.
select round(avg(salario),2)as 'salario medio de todos los empleados'
from emple;

#	12.	¿Cuál es el máximo salario de los empleados del departamento 10?
select d.dept_no 'Numero departamento', round(max(salario),2) as 'salario maximo'
from emple e
join depart d on e.dept_no=d.dept_no
group by d.dept_no
having d.dept_no = 10;

select max(salario) as 'Máximo Salario'
from emple
where DEPT_NO = 40;

#	13.	Calcula el salario mínimo de los empleados del departamento ‘VENTAS’.
select d.nombre_dept as 'Nombre departamento', round(min(salario),2) as 'salario minimo'
from emple e
join depart d on e.dept_no = d.dept_no
where d.nombre_dept = 'Ventas';

#	14.	Calcula el promedio del salario de los empleados del departamento de ‘CONTABILIDAD’.
select d.nombre_dept as 'Nombre departamento', round(avg(salario),2) as 'salario promedio'
from emple e
join depart d on e.dept_no = d.dept_no
where d.nombre_dept = 'Contabilidad';

select avg(salario) as 'Promedio Salario'
from emple
where DEPT_NO = (select DEPT_NO from depart where NOMBRE_DEPT = 'Contabilidad');

#	15.	¿Cuántos empleados hay en el departamento número 10?
select d.dept_no, d.nombre_dept as 'Nombre departamento', count(*) as 'Total empleados por departamento'
from emple e
join depart d on e.dept_no = d.dept_no
where d.dept_no = 10
group by d.dept_no ,d.nombre_dept;

#	16.	¿Cuántos empleados hay en el departamento de ‘VENTAS’?
select d.dept_no, d.nombre_dept as 'Nombre departamento', count(*) as 'Total empleados por departamento'
from emple e
join depart d on e.dept_no = d.dept_no
where d.nombre_dept = 'Contabilidad'
group by d.dept_no ,d.nombre_dept;

#	17.	Calcula el número de empleados que no tienen comisión.
select count(*) as 'Total empleados sin comision'
from emple
where comision = 0;

#	18.	Visualizar cuántos nombres de los empleados empiezan por la letra ‘A’.
select count(*) as 'cantidad de nombres de empleados que empiezan por A'
from emple
where nombre like 'A%';


#	19.	Visualizar el número de empleados de cada departamento.
select d.nombre_dept as 'Nombre departamento', count(*) as 'Total empleados por departamento'
from emple e
join depart d on e.dept_no=d.dept_no
group by d.nombre_dept;

#	20.	Para cada oficio obtener la suma de salarios.
select oficio, sum(salario) as 'Total gastos salarios por oficio'
from emple 
group by oficio
order by sum(salario) desc; 
 
-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- --		-- MAS EJEMPLOS	--
-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

#	21.	Mostrar los datos de los empleados cuyo salario sea mayor que la media de todos los salarios.
select *
from emple
where salario > (select avg(salario) from emple);

#	22.	Seleccionar el nombre del empleado que tiene máximo salario.
select nombre, salario
from emple
where salario = (select max(salario) from emple);

select max(salario)
from emple;

#	23.	Mostrar el nombre del empleado que tiene el salario más bajo.
select nombre, salario
from emple
where salario = (select min(salario) as 'salario mas bajo de la empresa' from emple)
group by nombre, salario;

select min(salario)
from emple;

#	24.	Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘VENTAS’.
select e.nombre, max(salario) as 'salario mas alto'
from emple e
join depart d on e.dept_no=d.dept_no
where d.DEPT_NO = 'ventas'
group by e.nombre
;

-- 24. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘VENTAS’.
select *
from emple
where salario = (select max(salario) from emple where dept_no = (select dept_no from depart where NOMBRE_DEPT = 'Ventas'));

select nombre, max(salario) as 'salario mas alto, dpto ventas'
from emple
where DEPT_NO = (select DEPT_NO from depart d where d.nombre_dept = 'ventas' )
group by nombre;

#	25.	Visualizar el departamento con más empleados.
select d.nombre_dept as 'nombre departamento', count(e.codigo) as 'total empleados por departamento'
from emple e
join depart d on e.dept_no=d.dept_no 
group by d.nombre_dept
order by count(e.codigo) desc
limit 1;

#	26.	Visualizar el número de departamento que tenga más empleados cuyo oficio sea empleado.
select e.dept_no, count(*) as 'Total de empleados Empleado'
from emple e
where e.oficio = 'Empleado'
group by e.dept_no
order by count(*) desc
limit 1;

#	27.	Mostrar el número de oficios distintos de cada departamento.
select d.nombre_dept as 'departamento', count(distinct e.oficio) as 'Total de oficios diferentes por departamento'
from emple e
join depart d on e.dept_no=d.dept_no
group by d.nombre_dept;

#	28.	Mostrar los departamentos que tengan más de dos personas trabajando en la misma profesión.
select  d.NOMBRE_DEPT as 'Departamento', e.oficio, COUNT(*) as 'Cantidad de Empleados'
from emple e
join depart d on e.dept_no = d.dept_no
group by d.NOMBRE_DEPT, e.oficio
having COUNT(*) > 2;

-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- -- EJEMPLOS DE MODIFICACIÓN DE LA BASE DE DATOS	--
-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
#	1.	Insertar en la tabla EMPLEADO un empleado con código 081- 220678-0008U, nombre ‘Pérez Luis Carlos’ de 32 años, oficio Analista,
#		 vive en Matagalpa, fecha de alta en la empresa el 22-06- 2001, su salario es 15600, no tiene comisión y pertenece al departamento 20.
INSERT INTO Emple (Codigo, Nombre, Apellido, Edad, Oficio, Dir, Fecha_Alt, Salario, Comision, DEPT_NO)
VALUES ('081-220678-0008U', 'Carlos', 'Pérez Luis ', 32, 'Analista', 'Matagalpa', '2001-06-22', 15600, NULL, 20);

#	2.	Insertar en la tabla DEPARTAMENTO un departamento cuyo número sea 50, de nombre ‘GENERAL’ y cuya localización sea ‘Vitoria’.
-- ingreso 60 porque tengo uno que ya tiene el id 50
insert into depart(dept_no, nombre_dept, loc)
values (60, 'GENERAL', 'Vitoria');

#	3.	Insertar en la tabla DEPARTAMENTO un departamento cuyo número sea 60 y de nombre ‘PRUEBAS’.
insert into depart(dept_no, nombre_dept, loc)
values (70, 'PRUEBAS', 'A Coruña');

#	4.	Insertar en la tabla PRUEBA los datos de los empleados que pertenecen al departamento número 30.
-- creo tabla Prueba
create table PRUEBA (
    Codigo varchar(40) primary key, 
    Nombre VARCHAR(40) NOT NULL,
    Apellido varchar(40) not null,
    Edad int(3),
    Oficio enum ('EMPLEADO','VENDEDOR','DIRECTOR', 'CONTABILIDAD', 'ANALISTA','PRESIDENTE') not null,
    Dir varchar(40),
    Fecha_Alt Date not null,
    Salario float not null,
    Comision float,
    DEPT_NO int not null
);

-- insertar los datos de empleados que pertenecen al departamento 30
insert into PRUEBA (Codigo, Nombre, Apellido, Edad, Oficio, Dir, Fecha_Alt, Salario, Comision, DEPT_NO)
select Codigo, Nombre, Apellido, Edad, Oficio, Dir, Fecha_Alt, Salario, Comision, DEPT_NO
from Emple
where DEPT_NO = 30;

#	5.	Insertar en la tabla PRUEBA2 el codigo_c, número de departamento y salario de los empleados que pertenecen al departamento número 20.
create table if not exists Prueba2 (
    codigo VARCHAR(40), 
    dept_no INT, 
    salario FLOAT
) 
select codigo, dept_no, salario 
from emple 
where dept_no = 20;

#	6.	Doblar el salario a todos los empleados del departamento 30.
update emple
set salario = salario * 2
where dept_no = 30;

#	7.	Cambiar todos los empleados del departamento número 30 al departamento número 20.
update emple
set dept_no = 20
where dept_no =30;

#	8.	Incrementar en un 10% el sueldo de los empleados del departamento 10.
update emple
set salario = salario + (salario * 0.10)
where dept_no = 10;

#	9.	Cambiar la localidad del departamento número 10 a ‘Zaragoza’.
update depart
set loc = 'Zaragoza'
where dept_no = 10;

#	10.	Igualar el salario de ‘José Ruiz’ al salario de ‘Alfonso Esquivel’, de la tabla PRUEBA.
UPDATE PRUEBA
SET salario = (
    SELECT subquery.salario
    FROM (SELECT salario FROM PRUEBA WHERE nombre = 'Alfonso' AND apellido = 'Esquivel') AS subquery
)
WHERE nombre = 'Jose' AND apellido = 'Ruiz';

#	11.	En la tabla DEPARTAMENTO borrar el departamento número 40.
delete from depart
where dept_no = 40;
						# no puedo borrar por el tema de las restricciones.#
                        
#	12.	En la tabla EMPLEADO borrar todos los empleados que sean del departamento 20 y sean ‘ANALISTAS’.
delete from emple
where DEPT_NO = 20 and oficio = 'Analista';

#	13.	Borrar de la tabla EMPLEADO todos los empleados que no tengan comisión.
delete from emple
where comision = 0;
