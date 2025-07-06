
/* 					EJERCICIO 1
Para las tablas Emple y Depart cree las siguientes consultas:  BASE DE DATOS: tema7empresa

Emple (emp_no, apellido, oficio, dir, fecha_alt, salario, comision, dept_no)

Depart (dept_no, dnombre, loc)
*/


# a)	Muestre todos los datos de los empleados del departamento nº 10 ordenados por apellido de la A a la Z.
/*
select * from emple
where dept_no = 10
order by apellido;
*/
# b)	Visualice el apellido, fecha de alta y salario de los empleados del departamento nº 20 cuyo oficio sea analista.
/*
select apellido, fecha_alt, salario
from emple
*/

# c)	Muestre el número y nombre de todos los departamentos.
/*
select dept_no, dnombre 
from depart;
*/

# d)	Seleccione el número, apellido y oficio de todos los empleados cuyo apellido comience por la letra J.
/*
select emp_no, apellido, oficio
from emple
where apellido like 'J%';
*/

# e)	Seleccione todos los datos de los empleados cuyo apellido contenga la letra E en la segunda posición. 
/*
select *
from emple
where apellido like'_e%';
*/

# f)	Muestre los apellidos y oficios de los empleados cuyo oficio sea VENDEDOR, ANALISTA o EMPLEADO, ordenando el resultado por apellido.
/*
select apellido, oficio
from emple
where oficio in('vendedor', 'analista', 'empleado')
order by apellido;
*/

# g)	Visualice todos los datos de los empleados que cobran más de 2000 € de salario o más de 300 € de comisión. 
/*
select *
from emple
where salario > 2000 or comision > 300;
*/

# h)	Visualice todos los datos de los empleados que cobran más de 2000 € de salario y más de 300 € de comisión. 
/*
select *
from emple
where salario > 2000 and comision > 300;
*/

# i)	Indique para todos los empleados que cobren más de 2000 € su apellido, salario, oficio y comisión, así como el nombre y la localidad del departamento en el que trabaja.
/*
Indico las 4 opciones que existen en JOIN para unir, la mejor opcion para usar Siempre es: la opcion - from depart d join emple e on d.dept_no = e.dept_no

select dnombre, loc, apellido, salario, oficio, comision
from emple emple natural join depart d 
where salario > 2000;
# from depart d join emple e using(dept_no)
# from depart d join emple e on d.dept_no = e.dept_no
# from depart d,  emple e where d.dept_no = e.dept_no and salario > 2000
*/

# j)	Indique para todos los empleados que cobran comisión su apellido, el nombre del departamento en el que trabajan,
		#la comisión que cobran, su salario y el porcentaje que supone la comisión con respecto al salario (PorcenComisión).
		#Redondee este último dato a 2 decimales, para lo que puede hacer uso de la función round,
		#que recibe como primer parámetro el número que se desea redondear y como segundo el número de decimales que se desean en el resultado.
 /*       
select apellido, dnombre, comision, salario, round((comision/salario)*100, 2) 'Porcentaje Comision '
from emple e join depart d on e.dept_no = d.dept_no
where comision > 0;
*/

# k)	Indique para el empleado que no tiene jefe o director su apellido, oficio, nombre del departamento y localidad en la que trabaja.
/*
select apellido, oficio, dnombre, loc
from depart d join emple e on d.dept_no = e.dept_no
where dir is null;
*/

# l)	Añada un nuevo departamento a la tabla Depart, con código 60, nombre ALMACEN y ubicado en MADRID.
#Muestre a continuación para los departamentos con número superior o igual a 30, su nombre y localidad y,
#en caso de que trabaje en él algún empleado, su apellido, salario y comisión.
/*
SELECT * FROM DEPART;
insert into depart
values (60, 'ALMACEN', 'MADRID');

select dnombre, loc, apellido, salario, comision
from depart d left outer join emple e on d.dept_no = e.dept_no
where dept_no >= 30;
*/

/* --------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

# En este ejercicio lo primero que hay que hacer es la creacion de la base de datos y despues realiar la consultas. La creacion de la bbdd la hare después.
# Para este ejercicio se esta usando la bbdd : tema7empresa2

#---------EJERCICIOS DE CONSULTAS---------------

# a)	Muestre por cada empleado su código, nombre, salario y el nombre del departamento en el que trabaja.
/*
select codemp, nomemp, salemp, nomdep
from empleado e join departamento d on e.CodDep = d.CodDep; 
*/

# b)	Muestre por cada departamento su código, nombre y el nombre del empleado que lo dirige. "NO LO ENTIENDO!!!"
/*
select d.coddep, nomdep, nomemp
from departamento d join empleado e on d.CodEmpDir = e.CodEmp; 
*/

# c)	Muestre por cada empleado su nombre y por cada una de las habilidades que posee, el código de la habilidad, la descripción de la habilidad y el nivel correspondiente.
/*
select nomemp, he.codhab, deshab, nivhab
from empleado e 
join  habemp he on e.codemp = he.CodEmp join habilidad h on he.CodHab = h.CodHab; 
*/

# d)  Muestre el nombre y salario de todos los empleados con salario superior a 30000 €, 
#	  así como el porcentaje que supone su salario sobre el presupuesto de su departamento.
#     Redondee el resultado de esta última operación a 2 decimales. 
/*
select nomemp, salemp, round((salemp/preanu)*100, 2) ' Porcentaje salario s/ presupuesto dpto'
from empleado e join departamento d on e.coddep = d.CodDep
where SalEmp > 30000;
*/

# e)	Muestre por cada empleado nacido después de 1969 su nombre, extensión telefónica, 
	   #fecha de nacimiento, nombre del departamento en el que trabaja y nombre del centro 
       #en el que este está ubicado. Ordene el resultado por edad de los empleados del más joven al de mayor edad.
/*       
    select nomemp, extelemp,fecnaemp, nomdep, nomcen
    from empleado e join departamento d on e.CodDep = d. CodDep join centro c on d.CodCen = c.CodCen
    where year(fecnaemp) > 1969
    order by fecnaemp;
*/    
						
#f)	Muestre los nombres y salarios de los empleados que tienen hijos nacidos después del año 1990.        
/*
select distinct nomemp, salemp
from empleado e join hijo h on e.codemp = h.CodEmp
where year(fecnahi) > 1990;
*/
    
# g)  Muestre para todos los centros de trabajo, su nombre y dirección, 
#     así como el nombre del empleado que lo dirige, su extensión telefónica y
#     su salario. Ordene el resultado por nombre de centro.
 /* 
 select nomcen 'nombre centro', dircen, nomemp 'nombre Director', extelemp, round(salemp, 2) 'Salario'
 from empleado e join centro c on e.CodEmp = c.CodEmpDir
 order by NomCen;
*/
  
# h) Muestre para el departamento que no depende de ningún otro departamento, 
#    su nombre, presupuesto, el nombre del centro en el que está ubicado,
#    así como su dirección y el nombre del empleado que dirige dicho departamento.
/*
select nomdep, preanu, nomcen, dircen, nomemp
from departamento d join centro c on d.CodCen = c.CodCen join empleado e on d.CodEmpDir = e.CodEmp
where CodDepDep is null;
*/
