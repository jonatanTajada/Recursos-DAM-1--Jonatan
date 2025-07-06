create database if not exists Producto;
use Producto;

create table if not exists Fabricante(
    CODIGO int primary key,
    NOMBRE varchar(100) not null
);

create table if not exists Producto(
    CODIGO int primary key,
    NOMBRE varchar(100) not null,
    PRECIO float,
    CODIGO_FABRICANTE int,
    constraint fk_CODIGO_FABRICANTE foreign key(CODIGO_FABRICANTE) references Fabricante(CODIGO) on update cascade
);

		#inserccion de datos
 #tabla fabricante
INSERT INTO fabricante VALUES(1, 'Asus');
INSERT INTO fabricante VALUES(2, 'Lenovo');
INSERT INTO fabricante VALUES(3, 'Hewlett-Packard');
INSERT INTO fabricante VALUES(4, 'Samsung');
INSERT INTO fabricante VALUES(5, 'Seagate');
INSERT INTO fabricante VALUES(6, 'Crucial');
INSERT INTO fabricante VALUES(7, 'Gigabyte');
INSERT INTO fabricante VALUES(8, 'Huawei');
INSERT INTO fabricante VALUES(9, 'Xiaomi');

#tabla producto
INSERT INTO producto VALUES(1, 'Disco duro SATA3 1TB', 86.99, 5);
INSERT INTO producto VALUES(2, 'Memoria RAM DDR4 8GB', 120, 6);
INSERT INTO producto VALUES(3, 'Disco SSD 1 TB', 150.99, 4);
INSERT INTO producto VALUES(4, 'GeForce GTX 1050Ti', 185, 7);
INSERT INTO producto VALUES(5, 'GeForce GTX 1080 Xtreme', 755, 6);
INSERT INTO producto VALUES(6, 'Monitor 24 LED Full HD', 202, 1);
INSERT INTO producto VALUES(7, 'Monitor 27 LED Full HD', 245.99, 1);
INSERT INTO producto VALUES(8, 'Portátil Yoga 520', 559, 2);
INSERT INTO producto VALUES(9, 'Portátil Ideapd 320', 444, 2);
INSERT INTO producto VALUES(10, 'Impresora HP Deskjet 3720', 59.99, 3);
INSERT INTO producto VALUES(11, 'Impresora HP Laserjet Pro M26nw', 180, 3);
INSERT INTO producto VALUES(12, 'DSDImpresora HP Laserjet Pro M26nwSS', 160, NULL); # PERMITE DAR DE ALTA SIN NECESIDAD DE METER EL CODIGO_FABRICANTE, POR NO TENER NOT NULL
INSERT INTO producto VALUES(13, '12333DSDImpresora HP Laserjet Pro M26nwSS', 160, NULL);
			#CONSULTAS
            
#1.	Lista el nombre de todos los productos que hay en la tabla producto.
SELECT NOMBRE FROM Producto;

#2.	Lista los nombres y los precios de todos los productos de la tabla producto.
SELECT NOMBRE, PRECIO FROM Producto;

#3.	Lista el nombre de los productos, el precio en euros y el precio en dólares estadounidenses (USD).
SELECT NOMBRE, PRECIO, PRECIO * tasa_cambio_euro_a_usd AS precio_usd
FROM Producto;

#4.	Lista el nombre de los productos, el precio en euros y el precio en dólares estadounidenses (USD). Utiliza los siguientes alias para las columnas: nombre de producto, euros, dólares.
SELECT NOMBRE AS 'nombre de producto', PRECIO AS euros, PRECIO * tasa_cambio_euro_a_usd AS dólares
FROM Producto;

#5.	Lista los nombres y los precios de todos los productos de la tabla producto, convirtiendo los nombres a mayúscula.
SELECT UPPER(NOMBRE) AS NOMBRE, PRECIO FROM Producto;

#6.	Lista los nombres y los precios de todos los productos de la tabla producto, convirtiendo los nombres a minúscula.
SELECT LOWER(NOMBRE) AS NOMBRE, PRECIO FROM Producto;

#7.	Lista el nombre de todos los fabricantes en una columna, y en otra columna obtenga en mayúsculas los dos primeros caracteres del nombre del fabricante.
SELECT NOMBRE, UPPER(SUBSTRING(NOMBRE, 1, 2)) AS dos_primeros_caracteres
FROM Fabricante;

#8.	Lista los nombres y los precios de todos los productos de la tabla producto, redondeando el valor del precio.
SELECT NOMBRE, ROUND(PRECIO) AS PRECIO FROM Producto;

#9.	Lista los nombres y los precios de todos los productos de la tabla producto, truncando el valor del precio para mostrarlo sin ninguna cifra decimal.
SELECT NOMBRE, TRUNCATE(PRECIO, 0) AS PRECIO FROM Producto;

#10.	Lista el código de los fabricantes que tienen productos en la tabla producto.
SELECT DISTINCT p.CODIGO_FABRICANTE
FROM Producto p
WHERE p.CODIGO_FABRICANTE IS NOT NULL;

#11.	Lista el código de los fabricantes que tienen productos en la tabla producto, eliminando los códigos que aparecen repetidos.
SELECT DISTINCT p.CODIGO_FABRICANTE
FROM Producto p
WHERE p.CODIGO_FABRICANTE IS NOT NULL;

#12.	Lista los nombres de los fabricantes ordenados de forma ascendente.
SELECT NOMBRE FROM Fabricante
ORDER BY NOMBRE ASC;

#13.	Lista los nombres de los fabricantes ordenados de forma descendente.
SELECT NOMBRE FROM Fabricante
ORDER BY NOMBRE DESC;

#14.	Lista los nombres de los productos ordenados en primer lugar por el nombre de forma ascendente y en segundo lugar por el precio de forma descendente.
SELECT NOMBRE, PRECIO FROM Producto
ORDER BY NOMBRE ASC, PRECIO DESC;

#15.	Devuelve una lista con las 5 primeras filas de la tabla fabricante.
SELECT * FROM Fabricante
LIMIT 5;

#16.	Devuelve una lista con 2 filas a partir de la cuarta fila de la tabla fabricante. La cuarta fila también se debe incluir en la respuesta.
SELECT * FROM Fabricante
LIMIT 2 OFFSET 3;

#17.	Lista el nombre y el precio del producto más barato. (Utilice solamente las cláusulas ORDER BY y ROWNUM).
SELECT NOMBRE, PRECIO
FROM Producto
ORDER BY PRECIO ASC
LIMIT 1;

#18.	Lista el nombre y el precio del producto más caro. (Utilice solamente las cláusulas ORDER BY y ROWNUM).
SELECT NOMBRE, PRECIO
FROM Producto
ORDER BY PRECIO DESC
LIMIT 1;

#19.	Lista el nombre de todos los productos del fabricante cuyo código de fabricante es igual a 2.
SELECT NOMBRE
FROM Producto
WHERE CODIGO_FABRICANTE = 2;


#20.	Lista el nombre de los productos que tienen un precio menor o igual a 120€.
SELECT NOMBRE
FROM Producto
WHERE PRECIO <= 120;

#21.	Lista el nombre de los productos que tienen un precio mayor o igual a 400€
SELECT NOMBRE
FROM Producto
WHERE PRECIO >= 400;


#22.	Lista el nombre de los productos que no tienen un precio mayor o igual a 400€.
SELECT NOMBRE
FROM Producto
WHERE NOT (PRECIO >= 400);


#23.	Lista todos los productos que tengan un precio entre 80€ y 300€. Sin utilizar el operador BETWEEN.
SELECT NOMBRE
FROM Producto
WHERE PRECIO >= 80 AND PRECIO <= 300;


#24.	Lista todos los productos que tengan un precio entre 60€ y 200€. Utilizando el operador BETWEEN.
SELECT NOMBRE
FROM Producto
WHERE PRECIO BETWEEN 60 AND 200;


#25.	 Lista todos los productos que tengan un precio mayor que 200€ y que el código de fabricante sea igual a 6.
SELECT NOMBRE
FROM Producto
WHERE PRECIO > 200 AND CODIGO_FABRICANTE = 6;


#26.	Lista todos los productos donde el código de fabricante sea 1, 3 o 5. Sin utilizar el operador IN.
SELECT NOMBRE
FROM Producto
WHERE CODIGO_FABRICANTE = 1 OR CODIGO_FABRICANTE = 3 OR CODIGO_FABRICANTE = 5;


#27.	 Lista todos los productos donde el código de fabricante sea 1, 3 o 5. Utilizando el operador IN.
SELECT NOMBRE
FROM Producto
WHERE CODIGO_FABRICANTE IN (1, 3, 5);


#28.	Lista el nombre y el precio de los productos en céntimos (Habrá que multiplicar por 100 el valor del precio). Cree un alias para la columna que contiene el precio que se llame céntimos.
SELECT NOMBRE, PRECIO * 100 AS centimos
FROM Producto;

#29.	Lista los nombres de los fabricantes cuyo nombre empiece por la letra S.
SELECT NOMBRE
FROM Fabricante
WHERE NOMBRE LIKE 'S%';

#30.	Lista los nombres de los fabricantes cuyo nombre termine por la vocal e.
SELECT NOMBRE
FROM Fabricante
WHERE NOMBRE LIKE '%e';

#31.	Lista los nombres de los fabricantes cuyo nombre contenga el carácter w.
SELECT NOMBRE
FROM Fabricante
WHERE NOMBRE LIKE '%w%';

#32.	Lista los nombres de los fabricantes cuyo nombre sea de 4 caracteres.
SELECT NOMBRE
FROM Fabricante
WHERE LENGTH(NOMBRE) = 4;

#33.	Devuelve una lista con el nombre de todos los productos que contienen la cadena Portátil en el nombre.
SELECT NOMBRE
FROM Producto
WHERE NOMBRE LIKE '%Portátil%';

#34.	Devuelve una lista con el nombre de todos los productos que contienen la cadena Monitor en el nombre y tienen un precio inferior a 215 €.
SELECT NOMBRE
FROM Producto
WHERE NOMBRE LIKE '%Monitor%' AND PRECIO < 215;

#35.	Lista el nombre y el precio de todos los productos que tengan un precio mayor o igual a 180€.
#	    Ordene el resultado en primer lugar por el precio (en orden descendente) y en segundo lugar por el nombre (en orden ascendente).
SELECT NOMBRE, PRECIO
FROM Producto
WHERE PRECIO >= 180
ORDER BY PRECIO DESC, NOMBRE ASC;

#36.	Devuelve una lista con el nombre del producto, precio y nombre de fabricante de todos los productos de la base de datos.
SELECT P.NOMBRE, P.PRECIO, F.NOMBRE AS 'Nombre de Fabricante'
FROM Producto P
JOIN Fabricante F ON P.CODIGO_FABRICANTE = F.CODIGO;

#37.	Devuelve una lista con el nombre del producto, precio y nombre de fabricante de todos los productos de la base de datos. Ordene el resultado por el nombre del fabricante, por orden alfabético.
SELECT P.NOMBRE, P.PRECIO, F.NOMBRE AS 'Nombre de Fabricante'
FROM Producto P
JOIN Fabricante F ON P.CODIGO_FABRICANTE = F.CODIGO
ORDER BY F.NOMBRE ASC;

#38.	 Devuelve una lista con el código del producto, nombre del producto, código del fabricante y nombre del fabricante, de todos los productos de la base de datos.
SELECT P.CODIGO, P.NOMBRE AS 'Nombre de Producto', P.CODIGO_FABRICANTE, F.NOMBRE AS 'Nombre de Fabricante'
FROM Producto P
JOIN Fabricante F ON P.CODIGO_FABRICANTE = F.CODIGO;

#39.	Devuelve el nombre del producto, su precio y el nombre de su fabricante, del producto más barato.
SELECT P.NOMBRE, P.PRECIO, F.NOMBRE AS 'Nombre de Fabricante'
FROM Producto P
JOIN Fabricante F ON P.CODIGO_FABRICANTE = F.CODIGO
ORDER BY P.PRECIO ASC
LIMIT 1;

#40.	 Devuelve el nombre del producto, su precio y el nombre de su fabricante, del producto más caro.
SELECT P.NOMBRE, P.PRECIO, F.NOMBRE AS 'Nombre de Fabricante'
FROM Producto P
JOIN Fabricante F ON P.CODIGO_FABRICANTE = F.CODIGO
ORDER BY P.PRECIO DESC
LIMIT 1;

#41.	Devuelve una lista de todos los productos del fabricante Lenovo.
SELECT NOMBRE
FROM Producto
WHERE CODIGO_FABRICANTE = (SELECT CODIGO FROM Fabricante WHERE NOMBRE = 'Lenovo');

#42.	Devuelve una lista de todos los productos del fabricante Crucial que tengan un precio mayor que 200€.
SELECT NOMBRE
FROM Producto
WHERE CODIGO_FABRICANTE = (SELECT CODIGO FROM Fabricante WHERE NOMBRE = 'Crucial') AND PRECIO > 200;

#43.	Devuelve un listado con todos los productos de los fabricantes Asus, Hewlett-Packardy Seagate. Sin utilizar el operador IN.
SELECT P.NOMBRE
FROM Producto P
JOIN Fabricante F ON P.CODIGO_FABRICANTE = F.CODIGO
WHERE F.NOMBRE = 'Asus' OR F.NOMBRE = 'Hewlett-Packard' OR F.NOMBRE = 'Seagate';

#44.	Devuelve un listado con todos los productos de los fabricantes Asus, Hewlett-Packardy Seagate. Utilizando el operador IN.
SELECT P.NOMBRE
FROM Producto P
JOIN Fabricante F ON P.CODIGO_FABRICANTE = F.CODIGO
WHERE F.NOMBRE IN ('Asus', 'Hewlett-Packard', 'Seagate');

#45.	Devuelve un listado con el nombre y el precio de todos los productos de los fabricantes cuyo nombre termine por la vocal e.
SELECT P.NOMBRE, P.PRECIO
FROM Producto P
JOIN Fabricante F ON P.CODIGO_FABRICANTE = F.CODIGO
WHERE F.NOMBRE LIKE '%e';

#46.	Devuelve un listado con el nombre y el precio de todos los productos cuyo nombre de fabricante contenga el carácter w en su nombre.
SELECT P.NOMBRE, P.PRECIO
FROM Producto P
JOIN Fabricante F ON P.CODIGO_FABRICANTE = F.CODIGO
WHERE F.NOMBRE LIKE '%w%';

#47.	Devuelve un listado con el nombre de producto, precio y nombre de fabricante, de todos los productos que tengan un precio mayor o igual a 180€. Ordene el resultado en primer lugar por el precio (en
#orden descendente) y en segundo lugar por el nombre (en orden ascendente)
SELECT P.NOMBRE, P.PRECIO, F.NOMBRE AS 'Nombre de Fabricante'
FROM Producto P
JOIN Fabricante F ON P.CODIGO_FABRICANTE = F.CODIGO
WHERE P.PRECIO >= 180
ORDER BY P.PRECIO DESC, P.NOMBRE ASC;

#48.	Devuelve un listado con el código y el nombre de fabricante, solamente de aquellos fabricantes que tienen productos asociados en la base de datos.
SELECT F.CODIGO, F.NOMBRE
FROM Fabricante F
JOIN Producto P ON F.CODIGO = P.CODIGO_FABRICANTE
GROUP BY F.CODIGO, F.NOMBRE;

#49.	Devuelve un listado de todos los fabricantes que existen en la base de datos, junto con los productos que tiene cada uno de ellos.
# 		El listado deberá mostrar también aquellos fabricantes que no tienen productos asociados.
 SELECT F.CODIGO, F.NOMBRE AS 'Nombre de Fabricante', GROUP_CONCAT(P.NOMBRE ORDER BY P.NOMBRE ASC SEPARATOR ', ') AS 'Productos'
FROM Fabricante F
LEFT JOIN Producto P ON F.CODIGO = P.CODIGO_FABRICANTE
GROUP BY F.CODIGO, F.NOMBRE;

#50.	Devuelve un listado donde sólo aparezcan aquellos fabricantes que no tienen ningún producto asociado.
SELECT F.CODIGO, F.NOMBRE AS 'Nombre de Fabricante'
FROM Fabricante F
LEFT JOIN Producto P ON F.CODIGO = P.CODIGO_FABRICANTE
WHERE P.CODIGO_FABRICANTE IS NULL;

/*---------------------------------------------------------------------------------------------------------------------------------*/
		#CONSULTAS-MULTITABLA--ESTE CODIGO LO COPIO Y PEGO DE UN WORD EJERCICIOS-SQL-TIENDA-VENTAS
      
#1.	Devuelve una lista de todos los productos del fabricante Lenovo.
SELECT *
FROM producto
WHERE CODIGO_FABRICANTE =
					(SELECT CODIGO FROM fabricante WHERE nombre = 'Įenovo');

#2.	Devuelve una lista de todos los productos del fabricante Crucial que tengan un precio mayor que 200.
SELECT *
FROM producto
WHERE CODIGO_FABRICANTE = (SELECT CODIGO FROM fabricante WHERE nombre = 'Crucial') AND precio > 200;

#3.	Devuelve un listado con todos los productos de los fabricantes Asus, Hewlett- Packardy Seagate. Sin utilizar el operador IN.
SELECT *
FROM producto
WHERE CODIGO_FABRICANTE = (SELECT CODIGO FROM fabricante WHERE nombre = 'Asus')
OR CODIGO_FABRICANTE = (SELECT CODIGO FROM fabricante WHERE nombre = 'Hewlett-Packard')
OR CODIGO_FABRICANTE = (SELECT CODIGO FROM fabricante WHERE nombre = 'Seagate');

#4.	Devuelve un listado con todos los productos de los fabricantes Asus, Hewlett- Packard y Seagate. Utilizando el operador IN.
SELECT *
FROM producto
WHERE CODIGO_FABRICANTE IN (SELECT CODIGO FROM fabricante WHERE nombre IN ('Asus', 'Hewlett-Packard', 'Seagate'));

#5.	Devuelve un listado con el nombre y el precio de todos los productos de los fabricantes cuyo nombre termine por la vocal e.
SELECT p.nombre, p.precio
FROM producto p, fabricante f
WHERE p.CODIGO_FABRICANTE = f.CODIGO AND f.nombre LIKE '%e';

#6.	Devuelve un listado con el nombre y el precio de todos los productos cuyo nombre de fabricante contenga el carácter w en su nombre.
SELECT p.nombre, p.precio 
FROM producto p, fabricante f
WHERE p.CODIGO_FABRICANTE = f.CODIGO AND f.nombre LIKE '%w%';

#7.	Devuelve un listado con el nombre de producto, precio y nombre de fabricante, de todos los productos que tengan un precio mayor o igual a 180.
#   Ordene el resultado en primer lugar por el precio (en orden descendente) y en segundo lugar por el nombre (en orden ascendente)
SELECT p.nombre, p.precio, f.nombre
FROM producto p, fabricante f
WHERE p.CODIGO_FABRICANTE = f.CODIGO AND p.precio >= 180
ORDER BY p.precio DESC, p.nombre ASC;

#8.	Devuelve un listado con el identificador y el nombre de fabricante, solamente de aquellos fabricantes que tienen productos asociados en la base de datos.
SELECT f.CODIGO, f.nombre
FROM fabricante f
WHERE	EXISTS	(SELECT	1	FROM	producto	p	WHERE p.CODIGO_FABRICANTE = f.CODIGO);
        
/*---------------------------------------------------------------------------------------------------------------------------------*/

			#Resuelva las siguientes consultas utilizando las cláusulas LEFT JOIN y RIGHT JOIN.

#1.	Devuelve un listado de todos los fabricantes que existen en la base de datos, junto con los productos que tiene cada uno de ellos. El listado deberá mostrar también aquellos fabricantes que no tienen productos asociados.
SELECT F.CODIGO, F.NOMBRE AS 'Nombre de Fabricante', GROUP_CONCAT(P.NOMBRE ORDER BY P.NOMBRE ASC SEPARATOR ', ') AS 'Productos'
FROM Fabricante F
LEFT JOIN Producto P ON F.CODIGO = P.CODIGO_FABRICANTE
GROUP BY F.CODIGO, F.NOMBRE;

#2.	Devuelve un listado donde sólo aparezcan aquellos fabricantes que no tienen ningún producto asociado.
SELECT F.CODIGO, F.NOMBRE AS 'Nombre de Fabricante'
FROM Fabricante F
LEFT JOIN Producto P ON F.CODIGO = P.CODIGO_FABRICANTE
WHERE P.CODIGO_FABRICANTE IS NULL;

#3.	¿Pueden existir productos que no estén relacionados con un fabricante? Justifique su respuesta.

#TE PERMITE DAR DE ALTA EL PRODUCTO POR QUE NO TIENE NOT NULL EN EL CAMPO CODIGO_FABRICANTE .
#CODIGO QUE ME HA PERMITIDO DAR DE ALTA: INSERT INTO producto VALUES(12, 'DSDImpresora HP Laserjet Pro M26nwSS', 160, NULL);

/*---------------------------------------------------------------------------------------------------------------------------------*/

						#CONSULTAS RESUMEN
                        
				#Consultas resumen
#1.	Calcula el número total de productos que hay en la tabla productos.
SELECT COUNT(*) AS 'Total de Productos'
FROM producto;

#2.	Calcula el número total de fabricantes que hay en la tabla fabricante.
SELECT COUNT(*) AS 'Total de Fabricantes'
FROM fabricante;

#3.	Calcula el número de valores distintos de identificador de fabricante aparecen en la tabla productos.
SELECT COUNT(DISTINCT CODIGO_FABRICANTE) AS 'Fabricantes Distintos en Productos'
FROM producto;

#4.	Calcula la media del precio de todos los productos.
SELECT AVG(PRECIO) AS 'Media de Precio'
FROM producto;

#5.	Calcula el precio más barato de todos los productos.
SELECT MIN(PRECIO) AS 'Precio Mas Barato'
FROM producto;

#6.	Calcula el precio más caro de todos los productos.
SELECT MAX(PRECIO) AS 'Precio Mas Caro'
FROM producto;

#7.	Lista el nombre y el precio del producto más barato.
SELECT NOMBRE, PRECIO
FROM producto
WHERE PRECIO = (SELECT MIN(PRECIO) FROM producto);

#8.	Lista el nombre y el precio del producto más caro.
SELECT NOMBRE, PRECIO
FROM producto
WHERE PRECIO = (SELECT MAX(PRECIO) FROM producto);

#9.	Calcula la suma de los precios de todos los productos.
SELECT SUM(PRECIO) AS 'Suma de Precios'
FROM producto;

#10.	Calcula el número de productos que tiene el fabricante Asus.
SELECT COUNT(*) AS 'Numero de Productos de Asus'
FROM producto
WHERE CODIGO_FABRICANTE = (SELECT CODIGO FROM fabricante WHERE NOMBRE = 'Asus');

#11.	Calcula la media del precio de todos los productos del fabricante Asus.
SELECT AVG(PRECIO) AS 'Media de Precio de Productos Asus'
FROM producto
WHERE CODIGO_FABRICANTE = (SELECT CODIGO FROM fabricante WHERE NOMBRE = 'Asus');

#12.	Calcula el precio más barato de todos los productos del fabricante Asus.
#13.	Calcula el precio más caro de todos los productos del fabricante Asus.
#14.	Calcula la suma de todos los productos del fabricante Asus.
#15.	Muestra el precio máximo, precio mínimo, precio medio y el número total de productos que tiene el fabricante Crucial.
#16.	Muestra el número total de productos que tiene cada uno de los fabricantes. El listado también debe incluir los fabricantes que no tienen ningún producto. El resultado mostrará dos columnas, una con el nombre del fabricante y otra con el número de productos que tiene. Ordene el resultado descendentemente por el número de productos.
#17.	Muestra el precio máximo, precio mínimo y precio medio de los productos de cada uno de los fabricantes. El resultado mostrará el nombre del fabricante junto con los datos que se solicitan.

#18.	Muestra el precio máximo, precio mínimo, precio medio y el número total de productos de los fabricantes que tienen un precio medio superior a 200. No es necesario mostrar el nombre del fabricante, con el identificador del fabricante es suficiente.

#19.	Muestra el nombre de cada fabricante, junto con el precio máximo, precio mínimo, precio medio y el número total de productos de los fabricantes que tienen un precio medio superior a 200. Es necesario mostrar el nombre del fabricante.
#20.	Calcula el número de productos que tienen un precio mayor o igual a 180.
#21.	Calcula el número de productos que tiene cada fabricante con un precio mayor o igual a 180.
#22.	Lista el precio medio los productos de cada fabricante, mostrando solamente el identificador del fabricante.
#23.	Lista el precio medio los productos de cada fabricante, mostrando solamente el nombre del fabricante.
#24.	Lista los nombres de los fabricantes cuyos productos tienen un precio medio mayor o igual a 150.
 
#25.	Devuelve un listado con los nombres de los fabricantes que tienen 2 o más productos.
                        

/*
		meterlo en las consultas del 12 en adelnte,,, es de la profe lo he cogido del classtom
        
        
SELECT MIN(precio) AS precio_mas_barato
FROM producto
WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = 'Asus');

SELECT MAX(precio) AS precio_mas_caro
FROM producto
WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = 'Asus');

SELECT SUM(precio) AS suma_precios
FROM producto
WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = 'Asus');

SELECT MAX(precio) AS precio_maximo, MIN(precio) AS precio_minimo, AVG(precio) AS
precio_medio, COUNT(*) AS cantidad_productos
FROM producto
WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = 'Crucial');

SELECT f.nombre AS fabricante, COUNT(p.codigo) AS numero_productos
FROM fabricante f
LEFT JOIN producto p ON f.codigo = p.codigo_fabricante
GROUP BY f.nombre
ORDER BY numero_productos DESC;

SELECT f.nombre AS fabricante, MAX(p.precio) AS precio_maximo,
MIN(p.precio) AS precio_minimo, AVG(p.precio) AS precio_medio
FROM fabricante f
LEFT JOIN producto p ON f.codigo = p.codigo_fabricante
GROUP BY f.nombre;

SELECT codigo_fabricante, MAX(precio) AS precio_maximo,
MIN(precio) AS precio_minimo, AVG(precio) AS precio_medio,
COUNT(codigo) AS numero_productos
FROM producto
GROUP BY codigo_fabricante
HAVING precio_medio > 200;

select * from producto;

SELECT f.nombre AS fabricante, MAX(p.precio) AS precio_maximo,
MIN(p.precio) AS precio_minimo, AVG(p.precio) AS precio_medio,
COUNT(p.codigo) AS numero_productos
FROM fabricante f
LEFT JOIN producto p ON f.codigo = p.codigo_fabricante
GROUP BY f.nombre
HAVING precio_medio > 200;

SELECT COUNT(*) AS numero_productos
FROM producto
WHERE precio >= 180;

SELECT f.nombre AS fabricante, COUNT(p.codigo) AS numero_productos
FROM fabricante f
LEFT JOIN producto p ON f.codigo = p.codigo_fabricante
WHERE p.precio >= 180
GROUP BY f.nombre;

SELECT codigo_fabricante, AVG(precio) AS precio_medio
FROM producto
GROUP BY codigo_fabricante;

SELECT f.nombre AS fabricante, AVG(p.precio) AS precio_medio
FROM fabricante f
LEFT JOIN producto p ON f.codigo = p.codigo_fabricante
GROUP BY f.nombre;

SELECT f.nombre AS fabricante
FROM fabricante f
LEFT JOIN producto p ON f.codigo = p.codigo_fabricante
GROUP BY f.nombre
HAVING AVG(p.precio) >= 150;

SELECT f.nombre AS fabricante
FROM fabricante f
LEFT JOIN producto p ON f.codigo = p.codigo_fabricante
GROUP BY f.nombre
HAVING COUNT(p.codigo) >= 2;

*/