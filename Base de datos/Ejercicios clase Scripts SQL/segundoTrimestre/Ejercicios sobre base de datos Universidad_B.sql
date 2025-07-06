# Ejercicios sobre la base de datos universidad b.
-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- 		-- 	1.1.2	Consultas sobre una tabla  --
-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------
#	1.	Devuelve un listado con el primer apellido, segundo apellido y el nombre de todos los alumnos. El listado deberá estar ordenado alfabéticamente de menor a mayor 
#		por el primer apellido, segundo apellido y nombre.
select apellido1, apellido2, nombre
from alumno
order by apellido1, apellido2, nombre;

#	2.	Averigua el nombre y los dos apellidos de los alumnos que no han dado de alta su número de teléfono en la base de datos.
select nombre, apellido1, apellido2
from alumno
where telefono is null;

#	3.	Devuelve el listado de los alumnos que nacieron en 1999.
select *
from alumno
where year(fecha_nacimiento) = 1999;

#	4.	Devuelve el listado de profesores que no han dado de alta su número de teléfono en la base de datos y además su nif termina en K.
select *
from profesor
where telefono is null and nif like '%k';

#	5.	Devuelve el listado de las asignaturas que se imparten en el primer cuatrimestre, en el tercer curso del grado que tiene el identificador 7.
select nombre
from asignatura
where cuatrimestre = 1 and curso = 3 and id_grado = 7;

-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- 		-- 	1.1.3	Consultas multitabla (Composición interna)  --
-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------
#	1.	Devuelve un listado con los datos de todas las alumnas que se han matriculado alguna vez en el Grado en Ingeniería Informática (Plan 2015).
select al.nombre,al.apellido1, al.apellido2, g.nombre as 'Grado'
from alumno al
join alumno_se_matricula_asignatura am on al.id=am.id_alumno
join asignatura a on am.id_asignatura=a.id
join grado g on a.id =g.id
where al.sexo = 'M' and g.nombre = 'Grado en Ingeniería Informática (Plan 2015)';

#	2.	Devuelve un listado con todas las asignaturas ofertadas en el Grado en Ingeniería Informática (Plan 2015).
select a.nombre as 'Asignatura', g.nombre as 'Grado'
from asignatura a 
join grado g on a.id_grado=g.id
where g.nombre = 'Grado en Ingeniería Informática (Plan 2015)';

#	3.	Devuelve un listado de los profesores junto con el nombre del departamento al que están vinculados. El listado debe devolver cuatro columnas, primer apellido, 
#		segundo apellido, nombre y nombre del departamento. El resultado estará ordenado alfabéticamente de menor a mayor por los apellidos y el nombre.
select pr.apellido1, pr.apellido2, pr.nombre, d.nombre as 'Departamento'
from profesor pr
join departamento d on pr.id_departamento=d.id
order by  pr.apellido1, pr.apellido2, pr.nombre;

#	4.	Devuelve un listado con el nombre de las asignaturas, año de inicio y año de fin del curso escolar del alumno con nif 26902806M.
select a.nombre as 'Asignatura', ce.anyo_inicio as 'Año incio', ce.anyo_fin as 'Año fin'
from asignatura a
join alumno_se_matricula_asignatura am on a.id=am.id_asignatura
join alumno al on am.id_alumno=al.id
join curso_escolar ce on am.id_curso_escolar= ce.id
where al.nif = '26902806M';

#	5.	Devuelve un listado con el nombre de todos los departamentos que tienen profesores que imparten alguna asignatura en el Grado en Ingeniería Informática (Plan 2015).
select distinct d.nombre as 'Departamento'
from departamento d
join profesor pr on d.id=pr.id_departamento
join asignatura a on pr.id=a.id_profesor
join grado g on a.id_grado=g.id
where g.nombre = 'Grado en Ingeniería Informática (Plan 2015)';

#	6.	Devuelve un listado con todos los alumnos que se han matriculado en alguna asignatura durante el curso escolar 2018/2019.
select al.nombre as 'Alumno', al.apellido1, al.apellido2
from alumno al
join alumno_se_matricula_asignatura am on al.id=am.id_alumno
join asignatura a on am.id_asignatura=a.id
join curso_escolar ce on am.id_curso_escolar=ce.id
where ce.anyo_inicio = 2018 and ce.anyo_fin = 2019;

-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- 		-- 	1.1.4	Consultas multitabla (Composición externa)  --  # Resuelva todas las consultas utilizando las cláusulas LEFT JOIN y RIGHT JOIN.
-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------
#	1.	Devuelve un listado con los nombres de todos los profesores y los departamentos que tienen vinculados. 
#		El listado también debe mostrar aquellos profesores que no tienen ningún departamento asociado. El listado debe devolver cuatro columnas, nombre del departamento, 
#		primer apellido, segundo apellido y nombre del profesor. El resultado estará ordenado alfabéticamente de menor a mayor por el nombre del departamento, apellidos y el nombre.
select d.nombre as 'Departamento', pr.apellido1, pr.apellido2, pr.nombre
from profesor pr
right join departamento d on pr.id_departamento=d.id
order by d.nombre, pr.apellido1, pr.apellido2, pr.nombre;

#	2.	Devuelve un listado con los profesores que no están asociados a un departamento.
select pr.apellido1, pr.apellido2, pr.nombre as 'Profesor'
from profesor pr
left join departamento d on pr.id_departamento=d.id
where pr.id_departamento is null;

#	3.	Devuelve un listado con los departamentos que no tienen profesores asociados.
select d.nombre as 'Departamento', pr.nombre as 'Profesor'
from departamento d
left join profesor pr on d.id=pr.id_departamento
where pr.nombre is null;

#	4.	Devuelve un listado con los profesores que no imparten ninguna asignatura.
select pr.nombre, pr.apellido1, pr.apellido2, a.nombre as 'Asignatura'
from profesor pr
left join asignatura a on pr.id=a.id_profesor
where a.nombre is null;

#	5.	Devuelve un listado con las asignaturas que no tienen un profesor asignado.

select a.nombre as 'Asignatura', pr.nombre as 'Profesor'
from asignatura a
left join profesor pr on a.id_profesor=pr.id
where pr.nombre is null;

#	6.	Devuelve un listado con todos los departamentos que tienen alguna asignatura que no se haya impartido en ningún curso escolar. 
#		El resultado debe mostrar el nombre del departamento y el nombre de la asignatura que no se haya impartido nunca.
select d.nombre as 'Departamento', a.nombre as 'Asignatura'
from departamento d
left join profesor pr on d.id=pr.id_departamento
left join asignatura a on pr.id=a.id_profesor
left join alumno_se_matricula_asignatura am on a.id=am.id_asignatura
left join curso_escolar ce on am.id_curso_escolar=ce.id
where ce.id is null;

-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- 		-- 	1.1.5	Consultas resumen  -- 
-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------
#	1.	Devuelve el número total de alumnas que hay.
select count(*) as 'numero total alumnas'
from alumno
where sexo = 'M'; 

#	2.	Calcula cuántos alumnos nacieron en 1999.
select count(*) as 'Numero de alumnos del año 1999'
from alumno
where year(fecha_nacimiento) = 1999;

#	3.	Calcula cuántos profesores hay en cada departamento. El resultado sólo debe mostrar dos columnas, una con el nombre del departamento y otra con el número de
#		profesores que hay en ese departamento. El resultado sólo debe incluir los departamentos que tienen profesores asociados y deberá estar ordenado de mayor a menor 
#		por el número de profesores.
select d.nombre as 'Departamento',  count(pr.id) as 'Numero profesores'
from profesor pr
join departamento d on pr.id_departamento= d.id 
group by d.nombre
order by count(pr.id) desc;

#	4.	Devuelve un listado con todos los departamentos y el número de profesores que hay en cada uno de ellos. Tenga en cuenta que pueden existir departamentos que 
#		no tienen profesores asociados. Estos departamentos también tienen que aparecer en el listado.
select d.nombre as 'Departamento',  count(pr.id) as 'Numero profesores'
from departamento d
left join profesor pr on d.id=pr.id_departamento
group by d.nombre
order by count(pr.id) desc;

#	5.	Devuelve un listado con el nombre de todos los grados existentes en la base de datos y el número de asignaturas que tiene cada uno. Tenga en cuenta que pueden 
#		existir grados que no tienen asignaturas asociadas. Estos grados también tienen que aparecer en el listado. El resultado deberá estar ordenado de mayor a menor por 
#		el número de asignaturas.
select g.nombre as 'Grado', count(a.id) as 'Numero de asignaturas'
from grado g
left join asignatura a on g.id=a.id_grado
group by g.nombre
order by count(a.id) desc;

#	6.	Devuelve un listado con el nombre de todos los grados existentes en la base de datos y el número de asignaturas que tiene cada uno, de los grados que tengan más 
#		de 40 asignaturas asociadas.
select g.nombre as 'Grado', count(a.id) as 'Numero de asignaturas'
from grado g
left join asignatura a on g.id=a.id_grado
group by g.nombre
having count(a.id) > 40;

#	7.	Devuelve un listado que muestre el nombre de los grados y la suma del número total de créditos que hay para cada tipo de asignatura. El resultado debe tener 
#		tres columnas: nombre del grado, tipo de asignatura y la suma de los créditos de todas las asignaturas que hay de ese tipo. Ordene el resultado de mayor a menor 
#		por el número total de crédidos.
select g.nombre as 'Grado', a.tipo as 'Basica/Obligatoria/Optativa', sum(a.creditos) as 'Total creditos'
from grado g
left join asignatura a on g.id=a.id_grado
group by g.nombre, a.tipo
order by sum(a.creditos) desc;

#	8.	Devuelve un listado que muestre cuántos alumnos se han matriculado de alguna asignatura en cada uno de los cursos escolares. El resultado deberá mostrar dos columnas, 
#		una columna con el año de inicio del curso escolar y otra con el número de alumnos matriculados.
select ce.anyo_inicio as 'Año incio', count(al.id) as 'Total alumnos matriculados'
from alumno al
left join alumno_se_matricula_asignatura am on al.id=am.id_alumno
left join asignatura a on am.id_asignatura=a.id
left join curso_escolar ce on am.id_curso_escolar=ce.id
group by ce.anyo_inicio, ce.anyo_fin;

#	9.	Devuelve un listado con el número de asignaturas que imparte cada profesor. El listado debe tener en cuenta aquellos profesores que no imparten ninguna asignatura. 
#		El resultado mostrará cinco columnas: id, nombre, primer apellido, segundo apellido y número de asignaturas. El resultado estará ordenado de mayor a menor por el 
#		número de asignaturas.
select pr.id, pr.nombre, pr.apellido1, pr.apellido2, count(a.id) 'Numeros asignaturas impartidas'
from asignatura a
right join profesor pr on a.id_profesor=pr.id
group by pr.id, pr.nombre, pr.apellido1, pr.apellido2
order by count(a.id) desc;

- --------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- 		-- 	1.1.6	Subconsultas  --
-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------
#	1.	Devuelve todos los datos del alumno más joven.
select nombre, apellido1, fecha_nacimiento
from alumno
order by  fecha_nacimiento desc
limit 1
;
-- subconsulta --
select *
from alumno
where fecha_nacimiento = (select min(fecha_nacimiento) from alumno);

#	2.	Devuelve un listado con los profesores que no están asociados a un departamento.
select *
from profesor
where id_departamento is null;

#	3.	Devuelve un listado con los departamentos que no tienen profesores asociados.
select *
from departamento
where id not in (select distinct id_departamento from profesor where id_departamento is not null);

#	4.	Devuelve un listado con los profesores que tienen un departamento asociado y que no imparten ninguna asignatura.
select pr.nombre, pr.apellido1, d.nombre as 'Departamento', a.nombre as 'Asignatura'
from profesor pr
left join departamento d on pr.id_departamento=d.id
left join asignatura a on pr.id=a.id_profesor
where a.nombre is null;
-- subconsulta --
select *
from profesor
where id_departamento IS NOT NULL 
and not exists (select 1 from asignatura where id_profesor = profesor.id);


#	5.	Devuelve un listado con las asignaturas que no tienen un profesor asignado.
SELECT *
FROM asignatura
WHERE id_profesor IS NULL;

#	6.	Devuelve un listado con todos los departamentos que no han impartido asignaturas en ningún curso escolar.
-- ¡DUDAS CUAL DE LAS DOS ES LA CORRECTA!
select  d.nombre as 'Departamento', a.nombre as 'Asignatura', ce.anyo_inicio, ce.anyo_fin
from departamento d
left join profesor pr on d.id=pr.id_departamento
left join asignatura a on pr.id=a.id_profesor
left join alumno_se_matricula_asignatura am on a.id=am.id_asignatura
left join curso_escolar ce on am.id_curso_escolar=ce.id
where a.nombre is not null
;
-- subconsulta
SELECT *
FROM departamento d
WHERE NOT EXISTS (
    SELECT 1
    FROM asignatura a
    WHERE a.id_grado = d.id
);


