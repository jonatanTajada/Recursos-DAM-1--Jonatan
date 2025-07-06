#drop database Ventas;
CREATE DATABASE IF NOT exists VENTAS;
USE VENTAS;

CREATE TABLE cliente (
id INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(100),
apellido1 VARCHAR(100),
apellido2 VARCHAR(100),
ciudad VARCHAR(100), 
categoria INT
);

CREATE TABLE comercial (
id INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(100),
 apellido1 VARCHAR(100),
 apellido2 VARCHAR(100), 
 comision FLOAT
);

CREATE TABLE pedido (
id INT AUTO_INCREMENT PRIMARY KEY,
total DOUBLE NOT null,
fecha DATE,
id_cliente INT,
id_comercial INT,
	FOREIGN KEY (id_cliente) REFERENCES cliente(id),
	FOREIGN KEY (id_comercial) REFERENCES comercial(id)
);
 
INSERT INTO cliente (nombre, apellido1, apellido2, ciudad, categoria)
				VALUES('Aarón', 'Rivero', 'Gómez', 'Almería', 100);
INSERT INTO cliente  (nombre, apellido1, apellido2, ciudad, categoria)
				VALUES('Adela', 'Salas', 'Díaz', 'Granada', 200);
 INSERT INTO cliente  (nombre, apellido1, apellido2, ciudad, categoria)
				VALUES('Adolfo', 'Rubio', 'Flores', 'Sevilla', NULL);
 INSERT INTO cliente  (nombre, apellido1, apellido2, ciudad, categoria)
				VALUES('Adrián', 'Suárez', NULL, 'Jaén', 300);
 INSERT INTO cliente  (nombre, apellido1, apellido2, ciudad, categoria)
				VALUES('Marcos', 'Įoyola', 'Méndez', 'Almería', 200);
INSERT INTO cliente  (nombre, apellido1, apellido2, ciudad, categoria)
				VALUES('María', 'Santana', 'Moreno', 'Cádiz', 100); 
INSERT INTO cliente  (nombre, apellido1, apellido2, ciudad, categoria)
				VALUES('Pilar', 'Ruiz', NULL, 'Sevilla', 300);
INSERT INTO cliente  (nombre, apellido1, apellido2, ciudad, categoria)
				VALUES('Pepe', 'Ruiz', 'Santana', 'Huelva', 200); 
INSERT INTO cliente  (nombre, apellido1, apellido2, ciudad, categoria)
				VALUES('Guillermo', 'Įópez', 'Gómez', 'Granada', 225);
INSERT INTO cliente  (nombre, apellido1, apellido2, ciudad, categoria)
				VALUES('Daniel', 'Santana', 'Įoyola', 'Sevilla', 125);

INSERT INTO comercial(nombre, apellido1, apellido2, comision)
				VALUES('Daniel', 'Sáez', 'Vega', 0.15),
					  ('Juan', 'Gómez', 'Įópez', 0.13),
					  ('Diego','Flores', 'Salas', 0.11),
					  ('Marta','Herrera', 'Gil', 0.14),
					  ('Antonio','Carretero', 'Ortega', 0.12),
					  ('Manuel','Domínguez', 'Hernández', 0.13),
					  ('Antonio','Vega', 'Hernández', 0.11),
					  ('Alfredo','Ruiz', 'Flores', 0.05);

INSERT INTO pedido(total, fecha, id_cliente, id_comercial)
				VALUES(150.5, '2017-10-05', 5, 2),
					  (270.65, '2016-09-10', 1, 5),
					  (65.26, '2017-10-05', 2, 1),
					  (110.5, '2016-08-17', 8, 3),
				      (948.5, '2017-09-10', 5, 2),
					  (2400.6, '2016-07-27', 7, 1),
				      (5760, '2015-09-10', 2, 1),
					  (1983.43, '2017-10-10', 4, 6),
					  (2480.4, '2016-10-10', 8, 3),
					  (250.45, '2015-06-27', 8, 2),
					  (75.29, '2016-08-17', 3, 7),
					  (3045.6, '2017-04-25', 2, 1),
					  (545.75, '2019-01-25', 6, 1),
					  (145.82, '2017-02-02', 6, 1),
				      (370.85, '2019-03-11', 1, 5),
					  (2389.23, '2019-03-11', 1, 5);



/*------------------------------------------------------------------------------------------------------------------*/

#•	Realice las siguientes consultas:

#Consultas sobre una tabla
#1.	Devuelve un listado con todos los pedidos que se han realizado. Los pedidos deben estar ordenados por la fecha de realización, mostrando en primer lugar los pedidos más recientes.
SELECT *
FROM pedido
ORDER BY fecha DESC;

#2.	Devuelve todos los datos de los dos pedidos de mayor valor.
SELECT *
FROM pedido
ORDER BY total DESC
LIMIT 2;

#3.	Devuelve un listado con los identificadores de los clientes que han realizado algún pedido. Tenga en cuenta que no debe mostrar identificadores que estén repetidos.
SELECT DISTINCT id_cliente
FROM pedido;

#4.	Devuelve un listado de todos los pedidos que se realizaron durante el año 2017, cuya cantidad total sea superior a 500.
SELECT *
FROM pedido
WHERE YEAR(fecha) = 2017 AND total > 500;

#5.	Devuelve un listado con el nombre y los apellidos de los comerciales que tienen una comisión entre 0.05 y 0.11.
SELECT nombre, apellido1, apellido2
FROM comercial
WHERE comision BETWEEN 0.05 AND 0.11;

#6.	Devuelve el valor de la comisión de mayor valor que existe en la tabla comercial.
 SELECT MAX(comision) AS 'max_comision'
FROM comercial;

#7.	Devuelve el identificador, nombre y primer apellido de aquellos clientes cuyo segundo apellido no es NULL. El listado deberá estar ordenado alfabéticamente por apellidos y nombre.
SELECT id, nombre, apellido1
FROM cliente
WHERE apellido2 IS NOT NULL
ORDER BY apellido1, nombre;

#8.	Devuelve un listado de los nombres de los clientes que empiezan por A y terminan por n y también los nombres que empiezan por P. El listado deberá estar ordenado alfabéticamente.
SELECT nombre
FROM cliente
WHERE (nombre LIKE 'A%N' OR nombre LIKE 'P%')
ORDER BY nombre;

#9.	Devuelve un listado de los nombres de los clientes que no empiezan por A. El listado deberá estar ordenado alfabéticamente.
SELECT nombre
FROM cliente
WHERE NOT nombre LIKE 'A%'
ORDER BY nombre;

#10.	Devuelve un listado con los nombres de los comerciales que terminan por el o o. Tenga en cuenta que se deberán eliminar los nombres repetidos.
SELECT DISTINCT nombre
FROM comercial
WHERE nombre LIKE '%o' OR nombre LIKE '%O';

/*-----------------------------------------------------------------------------------------------------------------------*/

#Consultas multitabla (Composición interna)

#1.	Devuelve un listado con el identificador, nombre y los apellidos de todos los clientes que han realizado algún pedido. El listado debe estar ordenado alfabéticamente y se deben eliminar los elementos repetidos.
SELECT DISTINCT c.id, c.nombre, c.apellido1, c.apellido2
FROM cliente c
JOIN pedido p ON c.id = p.id_cliente
ORDER BY c.apellido1, c.nombre;

#2.	Devuelve un listado que muestre todos los pedidos que ha realizado cada cliente. El resultado debe mostrar todos los datos de los pedidos y del cliente. El listado debe mostrar los datos de los clientes ordenados alfabéticamente.
SELECT p.*, c.*
FROM pedido p
JOIN cliente c ON p.id_cliente = c.id
ORDER BY c.apellido1, c.nombre;

#3.	Devuelve un listado que muestre todos los pedidos en los que ha participado un comercial. El resultado debe mostrar todos los datos de los pedidos y de los comerciales. El listado debe mostrar los datos de los comerciales ordenados alfabéticamente.
SELECT p.*, co.*
FROM pedido p
JOIN comercial co ON p.id_comercial = co.id
ORDER BY co.apellido1, co.nombre;

#4.	Devuelve un listado que muestre todos los clientes, con todos los pedidos que han realizado y con los datos de los comerciales asociados a cada pedido.
 SELECT c.*, p.*, co.*
FROM cliente c
JOIN pedido p ON c.id = p.id_cliente
JOIN comercial co ON p.id_comercial = co.id
ORDER BY c.apellido1, c.nombre, p.fecha;

#5.	Devuelve un listado de todos los clientes que realizaron un pedido durante el año 2017, cuya cantidad esté entre 300 € y 1000 €.
SELECT DISTINCT c.*
FROM cliente c
JOIN pedido p ON c.id = p.id_cliente
WHERE YEAR(p.fecha) = 2017 AND p.total BETWEEN 300 AND 1000
ORDER BY c.apellido1, c.nombre;

#6.	Devuelve el nombre y los apellidos de todos los comerciales que ha participado en algún pedido realizado por María Santana Moreno.
SELECT DISTINCT co.nombre, co.apellido1, co.apellido2
FROM cliente c
JOIN pedido p ON c.id = p.id_cliente
JOIN comercial co ON p.id_comercial = co.id
WHERE c.nombre = 'María' AND c.apellido1 = 'Santana' AND c.apellido2 = 'Moreno';


#7.	Devuelve el nombre de todos los clientes que han realizado algún pedido con el comercial Daniel Sáez Vega.
SELECT DISTINCT c.nombre
FROM cliente c
JOIN pedido p ON c.id = p.id_cliente
JOIN comercial co ON p.id_comercial = co.id
WHERE co.nombre = 'Daniel' AND co.apellido1 = 'Sáez' AND co.apellido2 = 'Vega';


/*-----------------------------------------------------------------------------------------------------------------------*/

#Consultas multitabla (Composición externa)

#1.	Devuelve un listado con todos los clientes junto con los datos de los pedidos que han realizado. Este listado también debe incluir los clientes que no han realizado ningún pedido. El listado debe estar ordenado alfabéticamente por el primer apellido, segundo apellido y nombre de los clientes.
SELECT c.nombre, c.apellido1, c.apellido2, p.total, p.fecha
FROM cliente c
LEFT JOIN pedido p ON c.id = p.id_cliente
ORDER BY c.apellido1, c.apellido2, c.nombre;



#2.	Devuelve un listado con todos los comerciales junto con los datos de los pedidos que han realizado.
	#Este listado también debe incluir los comerciales que no han realizado ningún pedido. El listado debe estar ordenado alfabéticamente por el primer apellido, segundo apellido y nombre de los comerciales.
SELECT co.nombre, co.apellido1, co.apellido2, p.total, p.fecha
FROM comercial co
LEFT JOIN pedido p ON co.id = p.id_comercial
ORDER BY co.apellido1, co.apellido2, co.nombre;

#3.	Devuelve un listado que solamente muestre los clientes que no han realizado ningún pedido.
SELECT c.nombre, c.apellido1, c.apellido2
FROM cliente c
LEFT JOIN pedido p ON c.id = p.id_cliente
WHERE p.id IS NULL;


#4.	Devuelve un listado que solamente muestre los comerciales que no han realizado ningún pedido.
SELECT co.nombre, co.apellido1, co.apellido2
FROM comercial co
LEFT JOIN pedido p ON co.id = p.id_comercial
WHERE p.id IS NULL;

#5.	Devuelve un listado con los clientes que no han realizado ningún pedido y de los comerciales que no han participado en ningún pedido. Ordene el listado alfabéticamente por los apellidos y el nombre. En en listado deberá diferenciar de algún modo los clientes y los comerciales.
SELECT 'Cliente' AS tipo, c.id, c.nombre, c.apellido1, c.apellido2, NULL AS
comercial_id, NULL AS comercial_nombre, NULL AS comercial_apellido1, NULL
AS comercial_apellido2
FROM cliente c
LEFT JOIN pedido p ON c.id = p.id_cliente
WHERE p.id IS NULL
UNION
SELECT 'Comercial' AS tipo, NULL AS cliente_id, NULL AS cliente_nombre,
NULL AS cliente_apellido1, NULL AS cliente_apellido2, com.id, com.nombre,
com.apellido1, com.apellido2
FROM comercial com
LEFT JOIN pedido p ON com.id = p.id_comercial
WHERE p.id IS NULL
ORDER BY apellido1, apellido2, nombre;

/*-----------------------------------------------------------------------------------------------------------------------*/

#Consultas resumen

#1.	Calcula la cantidad total que suman todos los pedidos que aparecen en la tabla pedido.
SELECT SUM(total) AS cantidad_total
FROM pedido;

#2.	Calcula la cantidad media de todos los pedidos que aparecen en la tabla pedido.
SELECT AVG(total) AS cantidad_media
FROM pedido;

#3.	Calcula el número total de comerciales distintos que aparecen en la tabla pedido.
SELECT COUNT(DISTINCT id_comercial) AS total_comerciales
FROM pedido;

#4.	Calcula el número total de clientes que aparecen en la tabla cliente.
SELECT COUNT(*) AS total_clientes
FROM cliente;

#5.	Calcula cuál es la mayor cantidad que aparece en la tabla pedido.
SELECT MAX(total) AS mayor_cantidad
FROM pedido;


#6.	Calcula cuál es la menor cantidad que aparece en la tabla pedido.
SELECT MIN(total) AS menor_cantidad
FROM pedido;

#7.	Calcula cuál es el valor máximo de categoría para cada una de las ciudades que aparece en la tabla cliente.
SELECT ciudad, MAX(categoria) AS max_categoria
FROM cliente
GROUP BY ciudad;

#8.	Calcula cuál es el máximo valor de los pedidos realizados durante el mismo día para cada uno de los clientes. Es decir, el mismo cliente puede haber realizado varios pedidos de diferentes cantidades el mismo día. Se pide que se calcule cuál es el pedido de máximo valor para cada uno de los días en los que un cliente ha realizado un pedido. Muestra el identificador del cliente, nombre, apellidos, la fecha y el valor de la cantidad.
SELECT id_cliente, nombre, apellido1, fecha, MAX(total) AS max_pedido_valor
FROM pedido p
JOIN cliente c ON p.id_cliente = c.id
GROUP BY id_cliente, fecha;

#9.	Calcula cuál es el máximo valor de los pedidos realizados durante el mismo día para cada uno de los clientes, teniendo en cuenta que sólo queremos mostrar aquellos pedidos que superen la cantidad de 2000 €.
SELECT id_cliente, nombre, apellido1, fecha, MAX(total) AS max_pedido_valor
FROM pedido p
JOIN cliente c ON p.id_cliente = c.id
WHERE total > 2000
GROUP BY id_cliente, fecha;

#10.	Calcula el máximo valor de los pedidos realizados para cada uno de los comerciales durante la fecha 2016-08-17. Muestra el identificador del comercial, nombre, apellidos y total.
SELECT id_comercial, nombre, apellido1, apellido2, MAX(total) AS max_pedido_valor
FROM pedido p
JOIN comercial co ON p.id_comercial = co.id
WHERE fecha = '2016-08-17'
GROUP BY id_comercial;

#11.	Devuelve un listado con el identificador de cliente, nombre y apellidos y el número total de pedidos que ha realizado cada uno de clientes. Tenga en cuenta que pueden existir clientes que no han realizado ningún pedido. Estos clientes también deben aparecer en el listado indicando que el número de pedidos realizados es 0.
SELECT c.id, c.nombre, c.apellido1, c.apellido2, COUNT(p.id) AS total_pedidos
FROM cliente c
LEFT JOIN pedido p ON c.id = p.id_cliente
GROUP BY c.id, c.nombre, c.apellido1, c.apellido2;

#12.	Devuelve un listado con el identificador de cliente, nombre y apellidos y el número total de pedidos que ha realizado cada uno de clientes durante el año 2017.
SELECT c.id, c.nombre, c.apellido1, c.apellido2, COUNT(p.id) AS total_pedidos_2017
FROM cliente c
LEFT JOIN pedido p ON c.id = p.id_cliente
WHERE YEAR(p.fecha) = 2017 OR p.fecha IS NULL
GROUP BY c.id, c.nombre, c.apellido1, c.apellido2;

#13.	Devuelve un listado que muestre el identificador de cliente, nombre, primer apellido y el valor de la máxima cantidad del pedido realizado por cada uno de los clientes. El resultado debe mostrar aquellos clientes que no han realizado ningún pedido indicando que la máxima cantidad de sus pedidos realizados es 0. Puede hacer uso de la función IFNULL.
SELECT c.id, c.nombre, c.apellido1, IFNULL(MAX(p.total), 0) AS max_cantidad_pedido
FROM cliente c
LEFT JOIN pedido p ON c.id = p.id_cliente
GROUP BY c.id, c.nombre, c.apellido1;

#14.	Devuelve cuál ha sido el pedido de máximo valor que se ha realizado cada año.
SELECT YEAR(fecha) AS anio, MAX(total) AS max_valor_pedido
FROM pedido
GROUP BY anio;

#15.	Devuelve el número total de pedidos que se han realizado cada año.
SELECT YEAR(fecha) AS anio, COUNT(*) AS total_pedidos
FROM pedido
GROUP BY anio;

