drop database ejercicioDepor;
create database if not exists ejercicioDepor;
use ejercicioDepor;

create table if not exists Pais(
CODIGO_PAIS char(3) primary key,
NOMBRE varchar(25)
);

create table if not exists Deportista(
CODIGO_DEPORTISTA varchar(3)  primary key,
NOMBRE varchar(25),
APELLIDO1 varchar(25),
CODIGO_PAIS varchar(3),

	constraint fk_CODIGO_PAIS foreign key(CODIGO_PAIS) references Pais(CODIGO_PAIS) on update cascade on delete cascade
);

create table if not exists Deporte(
CODIGO_DEPORTE varchar(3) primary key,
NOMBRE varchar(25)
);


create table if not exists DeportistaPracticaDeporte(
CODIGO_DEPORTE varchar(3),
CODIGO_DEPORTISTA varchar(3),

	primary key(CODIGO_DEPORTE, CODIGO_DEPORTISTA),
	constraint fk_CODIGO_DEPORTE foreign key(CODIGO_DEPORTE) references Deporte(CODIGO_DEPORTE) on delete cascade on update cascade,
	constraint fk_CODIGO_DEPORTISTA foreign key(CODIGO_DEPORTISTA) references Deportista(CODIGO_DEPORTISTA) on delete cascade on update cascade
);
-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- 	--   • 1.2a. Añade los países:   -- 	#inserccion de datos  --  #tabla Pais
-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
# JAM, Jamaica
# ESP, España
# USA, Estados Unidos de América
# AUS, Australia
# RUS, Rusia

insert into Pais values('JAM', 'Jamaica');
insert into Pais values('ESP', 'España');
insert into Pais values('USA','Estados Unidos de America');
insert into Pais values('AUS', 'Australia');
insert into Pais values('RUS','Rusia');

-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- 	--  • 1.2b. Añade los deportistas:  -- 	#inserccion de datos  --  #tabla Deportista
-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
# BOL, Usain, Bolt (Jamaica)
# POW, Asafa, Powell (Jamaica)
# CRA, Saúl, Craviotto (España)
# TAU, Diana, Taurasi (Estados Unidos)
# PHE, Michael, Phelps (Estados Unidos)
# MUR, Andy, Murray (UK)

insert into Deportista (CODIGO_DEPORTISTA, NOMBRE, APELLIDO1, CODIGO_PAIS) VALUES
('BOL', 'Usain', 'Bolt', 'JAM'),
('POW', 'Asafa', 'Powell', 'JAM'),
('CRA', 'Saúl', 'Craviotto', 'ESP'),
('TAU', 'Diana', 'Taurasi', 'USA'),
('PHE', 'Michael', 'Phelps', 'USA'),
('MUR', 'Andy', 'Murray', null);

-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- 	--  • 1.2c. Añade los deportes:  -- 	#inserccion de datos  --  #tabla Deporte
-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
insert into Deporte(CODIGO_DEPORTE, NOMBRE) values
('ATL', 'Atletismo'),
('REM', 'Remo'),
('BAL', 'Baloncesto'),
('NAT', 'Natación'),
('BAD', 'Badminton'),
('VEL', 'Velocidad');

-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- --  • 1.2d. Y la relación DeportistaPracticaDeporte:  -- 	#inserccion de datos  --  #tabla DeportistaPracticaDeporte
-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- Añade la relación DeportistaPracticaDeporte  

	INSERT INTO DeportistaPracticaDeporte (CODIGO_DEPORTE, CODIGO_DEPORTISTA) VALUES
	((SELECT CODIGO_DEPORTE FROM DEPORTE WHERE NOMBRE = 'Velocidad'), (SELECT CODIGO_DEPORTISTA FROM DEPORTISTA WHERE NOMBRE = 'Usain' AND APELLIDO1 = 'Bolt')),
	((SELECT CODIGO_DEPORTE FROM DEPORTE WHERE NOMBRE = 'Remo'), (SELECT CODIGO_DEPORTISTA FROM DEPORTISTA WHERE NOMBRE = 'Saúl' AND APELLIDO1 = 'Craviotto')),
	( (SELECT CODIGO_DEPORTE FROM DEPORTE WHERE NOMBRE = 'Baloncesto'), (SELECT CODIGO_DEPORTISTA FROM DEPORTISTA WHERE NOMBRE = 'Diana' AND APELLIDO1 = 'Taurasi')),
	((SELECT CODIGO_DEPORTE FROM DEPORTE WHERE NOMBRE = 'Natación'), (SELECT CODIGO_DEPORTISTA FROM DEPORTISTA WHERE NOMBRE = 'Michael' AND APELLIDO1 = 'Phelps'));


select * from deporte;
-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- 																	--  CONSULTAS --
-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


#	• 1.3. Muestra los nombres y apellidos de todos los deportistas, junto al nombre del país al que pertenecen.
select d.nombre, d.apellido1, p.nombre
from deportista d
join pais p on d.CODIGO_PAIS=p.CODIGO_PAIS
order by d.nombre, d.apellido1;

#	• 1.4. Muestra los nombres y apellidos de todos los deportistas, junto al nombre del país al que pertenecen,
#       en caso de que dicho país aparezca en la base de datos. También se deben mostrar los datos de los deportistas cuyo país no se haya introducido aún.
 select d.nombre, d.apellido1, p.nombre as 'nombre pais'
 from deportista d
 left join pais p on d.CODIGO_PAIS = p.CODIGO_PAIS
 order by d.nombre, d.apellido1;
 
SELECT D.NOMBRE, D.APELLIDO1, COALESCE(P.NOMBRE, 'País Desconocido') AS NOMBRE_PAIS
FROM Deportista D
LEFT JOIN Pais P ON D.CODIGO_PAIS = P.CODIGO_PAIS;

 
#	• 1.5. Muestra los nombres de todos los países, junto a los apellidos de los deportistas de ese país. Deben aparecer también los países de los que no conozcamos ningún deportista.
select p.nombre as 'nombre pais', d.apellido1
from pais p
left join deportista d on p.CODIGO_PAIS=d.CODIGO_PAIS;

#	• 1.6. Muestra los nombres y apellidos de todos los deportistas, junto al nombre del deporte que practican 
#      (sólo aquellos de los que tengamos constancia que realmente practican algún deporte).
select d.nombre, d.apellido1, dp.nombre
from deportista d
join deportistaPracticaDeporte dpd on d.CODIGO_DEPORTISTA = dpd.codigo_deportista
join deporte dp on dpd.codigo_deporte = dp.codigo_deporte;

#	• 1.7. Muestra los nombres y apellidos de todos los deportistas, junto al nombre del deporte que practican (incluso los que no sepamos cuál es su deporte).
select d.nombre, d.apellido1, dp.nombre
from deportista d
left join deportistapracticadeporte dpd on d.CODIGO_DEPORTISTA=dpd.CODIGO_DEPORTISTA
left join deporte dp on dpd.CODIGO_DEPORTE = dp.CODIGO_DEPORTE;

SELECT D.NOMBRE, D.APELLIDO1, COALESCE(DEP.NOMBRE, 'Deporte Desconocido') AS NOMBRE_DEPORTE
FROM Deportista D
LEFT JOIN DeportistaPracticaDeporte DP ON D.CODIGO_DEPORTISTA = DP.CODIGO_DEPORTISTA
LEFT JOIN Deporte DEP ON DP.CODIGO_DEPORTE = DEP.CODIGO_DEPORTE;

#	• 1.8. Muestra el nombre de todos los deportes, junto con los nombres y apellidos de los deportistas que lo practican 
#		   (incluso si para algún deporte aún no hemos introducido ningún deportista).
select dp.nombre, d.nombre, d.apellido1
from deporte dp
left join deportistapracticadeporte dpd on dp.CODIGO_DEPORTE=dpd.CODIGO_DEPORTE
left join deportista d on dpd.CODIGO_DEPORTISTA=d.CODIGO_DEPORTISTA;

SELECT DEP.NOMBRE AS NOMBRE_DEPORTE, COALESCE(D.NOMBRE || ' ' || D.APELLIDO1, 'Ningún Deportista') AS DEPORTISTA_ASOCIADO
FROM Deporte DEP
LEFT JOIN DeportistaPracticaDeporte DP ON DEP.CODIGO_DEPORTE = DP.CODIGO_DEPORTE
LEFT JOIN Deportista D ON DP.CODIGO_DEPORTISTA = D.CODIGO_DEPORTISTA;


#	• 1.9. Partiendo de la base de datos "ejercicioDepor", que tenía información sobre deportistas y disciplinas deportivas: 
#			muestra en una misma consulta los nombres y apellidos de todos los deportistas, además de los nombres de las disciplinas deportivas.  
select d.nombre, d.apellido1, dp.nombre
from deportista d
left join deportistapracticadeporte dpd on d.CODIGO_DEPORTISTA=dpd.CODIGO_DEPORTISTA
left join deporte dp on dpd.CODIGO_DEPORTE=dp.CODIGO_DEPORTE;

#   • 1.10. Muestra los nombres y apellidos de todos los deportistas, junto al nombre del país al que pertenecen, en caso de que dicho país aparezca 
#			en la base de datos. Deben aparecer todos los países y todos los deportistas, aunque alguno pudiera estar sin relacionar 
#			(exista algún deportista del que no conozcamos el país o algún país del que no tengamos anotados aún deportistas).
select d.nombre, d.apellido1, p.nombre
from deportista d
left join pais p on d.CODIGO_PAIS=p.CODIGO_PAIS;

#   • 1.11. Muestra los nombres y apellidos de todos los deportistas, junto al nombre de la disciplina deportiva que practican. 
#			Deben aparecer todas las disciplinas y todos los deportistas, aunque alguno pudiera estar sin relacionar.
select d.nombre, d.apellido1, dp.nombre as 'nombre deporte'
from deportista d
left join deportistapracticadeporte dpd on d.CODIGO_DEPORTISTA = dpd.CODIGO_DEPORTISTA
left join deporte dp on dpd.CODIGO_DEPORTE= dp.CODIGO_DEPORTE;

SELECT D.NOMBRE, D.APELLIDO1, COALESCE(DP.NOMBRE, 'Disciplina Desconocida') AS NOMBRE_DEPORTE
FROM Deportista d
LEFT JOIN DeportistaPracticaDeporte dpd ON d.CODIGO_DEPORTISTA = dpd.CODIGO_DEPORTISTA
LEFT JOIN Deporte dp ON dpd.CODIGO_DEPORTE = dp.CODIGO_DEPORTE;

#	• 1.12. Muestra los nombres y apellidos de todos los deportistas (en formato "Apellido, nombre"), junto al nombre de la disciplina deportiva que practican. 
#			Deben mostrarse todas las disciplinas y todos los deportistas, aunque alguno pudiera estar sin relacionar. Los datos deben aparecer ordenados según el apellido del deportista.
select concat(d.apellido1, ' - ' ,d.nombre ) as 'apellido_nombre', coalesce(dp.nombre, 'Disciplina desconocida') as 'nombre deporte'
from deportista d
left join deportistapracticadeporte dpd on d.CODIGO_DEPORTISTA = dpd.CODIGO_DEPORTISTA
left join deporte dp on dpd.CODIGO_DEPORTE= dp.CODIGO_DEPORTE
order by apellido1;

-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- 																	--  VISTAS --
-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

#	• 1.13. Partiendo de la base de datos " ejercicioDepor", que tenía información sobre deportistas y disciplinas deportivas: crea una vista "personasydeportes" que permita obtener los nombres y apellidos de todos los deportistas, junto con el nombre del deporte que practican (este último dato aparecerá con el nombre "deporte").
create view PersonasYDeportes as
select d.nombre, d.apellido1, dp.nombre as 'deporte'
from deportista d
join deportistapracticadeporte dpd on d.CODIGO_DEPORTISTA=dpd.CODIGO_DEPORTISTA
join deporte dp on dpd.CODIGO_DEPORTE=dp.CODIGO_DEPORTE;

select * from personasydeportes;

#	• 1.14. Usa la vista "personasydeportes" para obtener los nombres y apellidos de los deportistas que practican deportes cuyo nombre comienza con "B".
select nombre, apellido1
from personasydeportes
where nombre like 'B%';
#	• 1.15. Crea una vista "personasypaises" que permita muestre un campo "persona" (que estará formado por los apellidos, una coma, un espacio y el nombre de cada deportista)
#			y un campo "pais", que será el nombre del país, o NULL si no se ha indicado el país.
create view PersonasYPaises as
select concat(d.apellido1, ' , ', d.nombre) as 'persona', p.nombre as 'pais'
from deportista d
join pais p on d.CODIGO_PAIS=p.CODIGO_PAIS;

select * from personasypaises;

#	• 1.16. Usa la vista "personasypaises" para obtener los nombres y apellidos de los deportistas de "España", ordenados por apellido.
select persona
from personasypaises
where pais = 'España'
order by persona;



