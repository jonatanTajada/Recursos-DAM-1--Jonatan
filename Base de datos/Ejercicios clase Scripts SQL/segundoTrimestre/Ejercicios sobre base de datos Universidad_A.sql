# ejercicios osbre la base de datos universidad_A
# use universidad;
-- ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
#	--	1.1.2	Consultas sobre una tabla	--
-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

#	1.	Devuelve un listado con el primer apellido, segundo apellido y el nombre de todos los alumnos. El listado deberá estar ordenado alfabéticamente de
#		menor a mayor por el primer apellido, segundo apellido y nombre;
select apellido1, apellido2, nombre
from persona
where tipo = 'alumno'
order by apellido1, apellido2, nombre;

#	2.	Averigua el nombre y los dos apellidos de los alumnos que no han dado de alta su número de teléfono en la base de datos.
select nombre, apellido1, apellido2
from persona
where tipo = 'alumno' and telefono is null;

#	3.	Devuelve el listado de los alumnos que nacieron en 1999.
select *
from persona
where tipo = 'alumno' and  year(fecha_nacimiento) = 1999;

#	4.	Devuelve el listado de profesores que no han dado de alta su número de teléfono en la base de datos y además su nif termina en K.
select * 
from persona
where tipo = 'profesor' and telefono is null and nif like '%k';

#	5.	Devuelve el listado de las asignaturas que se imparten en el primer cuatrimestre, en el tercer curso del grado que tiene el identificador 7.
select a.nombre
from asignatura a
join grado g on a.id_grado = g.id
where a.cuatrimestre = 1 and a.curso = 3 and g.id = 7;

-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
#	--	1.1.3		Consultas multitabla (Composición interna)	--
-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

#	1.	Devuelve un listado con los datos de todas las alumnas que se han matriculado alguna vez en el Grado en Ingeniería Informática (Plan 2015).
select distinct p.* 
from persona p
join alumno_se_matricula_asignatura am ON p.id = am.id_alumno
join asignatura a on am.id_asignatura = a.id
join grado g on a.id_grado = g.id
where p.tipo = 'alumno' and p.sexo = 'M' and g.nombre = 'Grado en Ingenieria Informatica (Plan 2015)'; 

#	2.	Devuelve un listado con todas las asignaturas ofertadas en el Grado en Ingeniería Informática (Plan 2015).
select a.nombre as 'nombre asignatura'
from asignatura a
join grado g on a.id_grado = g.id
where g.nombre = 'Grado en Ingenieria Informatica (Plan 2015)';

#	3.	Devuelve un listado de los profesores junto con el nombre del departamento al que están vinculados. El listado debe devolver cuatro columnas, 
#		primer apellido, segundo apellido, nombre y nombre del depar  tamento. El resultado estará ordenado alfabéticamente de menor a mayor por los apellidos y el nombre.
select p.apellido1, p.apellido2, p.nombre, d.nombre AS nombre_departamento
from persona p
join profesor pr on p.id = pr.id_profesor
join departamento d on pr.id_departamento = d.id
where p.tipo = 'profesor'
order by p.apellido1, p.apellido2, p.nombre;

#	4.	Devuelve un listado con el nombre de las asignaturas, año de inicio y año de fin del curso escolar del alumno con nif 26902806M.
select a.nombre as nombre_asignatura, ce.anyo_inicio, ce.anyo_fin
from alumno_se_matricula_asignatura am
join persona p on am.id_alumno = p.id
join asignatura a on am.id_asignatura = a.id
join curso_escolar ce on am.id_curso_escolar = ce.id
where p.nif = '26902806M';

#	5.	Devuelve un listado con el nombre de todos los departamentos que tienen profesores que imparten alguna asignatura en el Grado en Ingeniería Informática (Plan 2015).
select  d.nombre,a.nombre as 'asignatura', g.nombre as 'grado', p.nombre as 'Nombre profesor'
from persona p
join profesor pr on p.id = pr.id_profesor
join departamento d on pr.id_departamento = d.id
join asignatura a on pr.id_profesor = a.id_profesor
join grado g on a.id_grado = g.id
where p.tipo='profesor' and g.nombre='Grado en Ingeniería Informática (Plan 2015)';

#	6.	Devuelve un listado con todos los alumnos que se han matriculado en alguna asignatura durante el curso escolar 2018/2019.
select distinct p.*
from persona p
join alumno_se_matricula_asignatura am on p.id = am.id_alumno
join curso_escolar ce on am.id_curso_escolar = ce.id
where tipo = 'alumno' and  anyo_inicio = 2018 and anyo_fin = '2019';

-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
#	--	1.1.4	Consultas multitabla (Composición externa)	--	Resuelva todas las consultas utilizando las cláusulas LEFT JOIN y RIGHT JOIN.
-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

#	1.	Devuelve un listado con los nombres de todos los profesores y los departamentos que tienen vinculados. El listado también debe mostrar aquellos 
#		profesores que no tienen ningún departamento asociado. El listado debe devolver cuatro columnas, nombre del departamento, primer apellido, segundo apellido
#		y nombre del profesor. El resultado estará ordenado alfabéticamente de menor a mayor por el nombre del departamento, apellidos y el nombre.

select p.nombre, p.apellido1, p.apellido2, d.nombre as 'departamento'
from persona p
join profesor pr on p.id=pr.id_profesor
left join departamento d on pr.id_departamento=d.id
order by d.nombre, p.apellido1, p.apellido2, p.nombre;

#	2.	Devuelve un listado con los profesores que no están asociados a un departamento.
select p.nombre, p.tipo
from persona p
join profesor pr on p.id = pr.id_profesor
where pr.id_departamento is null and tipo = 'profesor';

#	3.	Devuelve un listado con los departamentos que no tienen profesores asociados.
select d.id ,d.nombre as 'nombre departamento'
from departamento d
left join profesor pr on d.id = pr.id_departamento
where pr.id_departamento is null;

#	4.	Devuelve un listado con los profesores que no imparten ninguna asignatura.
select p.nombre, p.apellido1, p.tipo, a.nombre as 'asignatura'
from persona p
join profesor pr on p.id = pr.id_profesor
left join asignatura a on pr.id_profesor=a.id_profesor
where p.tipo = 'profesor' and a.id_profesor is null;

#	5.	Devuelve un listado con las asignaturas que no tienen un profesor asignado.
#corregir
select a.nombre as 'Asignatura', p.nombre as 'nombre profesor'
from persona p
join profesor pr on p.id=pr.id_profesor
right join asignatura a on pr.id_profesor=a.id_profesor
where p.tipo = 'profesor' and p.nombre is null ;


#	6.	Devuelve un listado con todos los departamentos que tienen alguna asignatura que no se haya impartido en ningún curso escolar. 
#		El resultado debe mostrar el nombre del departamento y el nombre de la asignatura que no se haya impartido nunca.
select d.nombre as 'departamento', a.nombre as 'asignatura', ce.anyo_inicio
from departamento d 
left join profesor pr on d.id=pr.id_departamento
left join asignatura a on pr.id_profesor=a.id_profesor
left join alumno_se_matricula_asignatura am on a.id=am.id_asignatura
left join curso_escolar ce on am.id_curso_escolar=ce.id
where ce.id is null and a.nombre is not null;

-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
#	--	1.1.51.1.5	Consultas resumen	--
-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
#	1.	Devuelve el número total de alumnas que hay.
select count(*) as 'Total alumnas'
from persona 
where tipo = 'alumno' and sexo='M';

#	2.	Calcula cuántos alumnos nacieron en 1999.
select count(*) as 'Total alumnos nacidos en el año 1999'
from persona 
where tipo = 'alumno' and year(fecha_nacimiento) = 1999;

#	3.	Calcula cuántos profesores hay en cada departamento. El resultado sólo debe mostrar dos columnas, una con el nombre del departamento
#		y otra con el número de profesores que hay en ese departamento. El resultado sólo debe incluir los departamentos que tienen profesores asociados
#		y deberá estar ordenado de mayor a menor por el número de profesores.
select d.nombre as 'Departamento', count(pr.id_profesor) as Numero_de_profesores
from departamento d 
join profesor pr on d.id=pr.id_departamento
GROUP BY d.nombre
ORDER BY Numero_de_profesores DESC;

#	4.	Devuelve un listado con todos los departamentos y el número de profesores que hay en cada uno de ellos. Tenga en cuenta que pueden existir departamentos
#		que no tienen profesores asociados. Estos departamentos también tienen que aparecer en el listado.
select d.nombre as Departamento, count(pr.id_profesor) as 'Numero de profesores'
from departamento d 
left join profesor pr on d.id=pr.id_departamento
GROUP BY d.nombre
ORDER BY Departamento;

#	5.	Devuelve un listado con el nombre de todos los grados existentes en la base de datos y el número de asignaturas que tiene cada uno. 
#		Tenga en cuenta que pueden existir grados que no tienen asignaturas asociadas. Estos grados también tienen que aparecer en el listado. 
#		El resultado deberá estar ordenado de mayor a menor por el número de asignaturas.
select g.nombre as 'Grado', count(a.id) as 'Numero asignaturas'
from grado g
left join asignatura a on g.id=a.id_grado
group by g.nombre
ORDER BY 2 DESC;

#	6.	Devuelve un listado con el nombre de todos los grados existentes en la base de datos y el número de asignaturas que tiene cada uno, de los grados que 
#		tengan más de 40 asignaturas asociadas.
select g.nombre as 'Grado', count(a.id) as Numero_Asignaturas
from grado g
left join asignatura a on g.id=a.id_grado
group by g.nombre
having Numero_Asignaturas > 40;

#	7.	Devuelve un listado que muestre el nombre de los grados y la suma del número total de créditos que hay para cada tipo de asignatura. 
#		El resultado debe tener tres columnas: nombre del grado, tipo de asignatura y la suma de los créditos de todas las asignaturas que hay de ese tipo. 
#		Ordene el resultado de mayor a menor por el número total de crédidos.
select g.nombre as 'Grado', a.tipo as 'Basica/Obligatoria/Optativa',sum(a.creditos) as Total_creditos_por_asignatura
from grado g 
left join asignatura a on g.id=a.id_grado
group by g.nombre, a.tipo
order by Total_creditos_por_asignatura desc;

#	8.	Devuelve un listado que muestre cuántos alumnos se han matriculado de alguna asignatura en cada uno de los cursos escolares. 
#	El resultado deberá mostrar dos columnas, una columna con el año de inicio del curso escolar y otra con el número de alumnos matriculados.
select ce.anyo_inicio as Año_inicio, count(distinct am.id_alumno) as Numero_alumnos_matriculados
from curso_escolar ce
left join alumno_se_matricula_asignatura am on ce.id = am.id_curso_escolar
group by Año_inicio;

#	9.	Devuelve un listado con el número de asignaturas que imparte cada profesor. El listado debe tener en cuenta aquellos profesores que no imparten ninguna asignatura. El resultado 
#		mostrará cinco columnas: id, nombre, primer apellido, segundo apellido y número de asignaturas. El resultado estará ordenado de mayor a menor por el número de asignaturas.
select p.id, p.nombre, p.apellido1, p.apellido2, count(a.id) as Numero_asignaturas_imparte_cada_profesor
from persona p
left join profesor pr on p.id=pr.id_profesor
left join asignatura a on pr.id_profesor = a.id_profesor
group by p.id, p.nombre, p.apellido1, p.apellido2
order by Numero_asignaturas_imparte_cada_profesor desc;

-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- 		-- 	1.1.6	Subconsultas  --
-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------
#	1.	Devuelve todos los datos del alumno más joven.
select *
from persona
where tipo = 'alumno'
order by fecha_nacimiento desc
limit 1;
-- subconsulta
select *
from persona
where fecha_nacimiento = (select max(fecha_nacimiento) from persona where tipo = 'alumno');

#	2.	Devuelve un listado con los profesores que no están asociados a un departamento.
select p.nombre, p.apellido1, pr.id_departamento
from persona p
left join profesor pr on p.id = pr.id_profesor
where p.tipo = 'profesor' and pr.id_departamento is null;
-- subconsulta
SELECT *
FROM persona
WHERE tipo = 'profesor' AND id NOT IN (SELECT id_profesor FROM profesor);

#	3.	Devuelve un listado con los departamentos que no tienen profesores asociados.
select d.*
from departamento d
left join profesor pr ON d.id = pr.id_departamento
where pr.id_profesor is null;
-- subconsulta
select *
from departamento
where id not in(select id_departamento from profesor);

#	4.	Devuelve un listado con los profesores que tienen un departamento asociado y que no imparten ninguna asignatura.
select p.nombre, p.apellido1, d.nombre as 'Departamento', a.nombre as 'Asignatura'
from persona p
join profesor pr on p.id = pr.id_profesor
join departamento d on pr.id_departamento=d.id
left join asignatura a on pr.id_profesor=a.id_profesor
where a.nombre is null
;
-- subconsulta
select *
from persona
where tipo = 'profesor' and id in (select id_profesor from profesor) 
and id not in (select id_profesor from asignatura where id_profesor is not null);


#	5.	Devuelve un listado con las asignaturas que no tienen un profesor asignado.
select *
from asignatura
where id_profesor is null;
-- subconsulta
select * 
from asignatura
	where id not in (select id from asignatura where id_profesor in (select id_profesor from profesor));

#	6.	Devuelve un listado con todos los departamentos que no han impartido asignaturas en ningún curso escolar.
-- ¡DUDAS CUAL DE LAS DOS ES LA CORRECTA!
select distinct d.id as 'id departamento',  d.nombre as 'departamento' , a.nombre as 'asignatura', pr.id_profesor as 'id profesor',ce.anyo_inicio, ce.anyo_inicio
from departamento d
left join profesor pr on d.id = pr.id_departamento
left join asignatura a on pr.id_profesor = a.id_profesor
left join alumno_se_matricula_asignatura am on a.id = am.id_asignatura
left join curso_escolar ce on am.id_curso_escolar=ce.id
where ce.anyo_inicio is null;


