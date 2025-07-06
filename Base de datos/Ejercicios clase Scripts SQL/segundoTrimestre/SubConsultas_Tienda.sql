#ejercicio del word: ejercicios_subocnsultas tienda.
#-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
#													SUBCONSULTAS EN LA CLAUSULA - WHERE - 
#---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------													--------------------------------------			
#*********************************************Con operadores básicos de comparación******************************************************************************************************

#1.	Devuelve todos los productos del fabricante Lenovo. (Sin utilizar INNER JOIN).
SELECT *
FROM producto
WHERE codigo_fabricante = 
							(SELECT codigo FROM fabricante WHERE nombre = 'Lenovo');

#2.	Devuelve todos los datos de los productos que tienen el mismo precio que el producto más caro del fabricante Lenovo. (Sin utilizar INNER JOIN).
SELECT *
FROM producto
WHERE precio = 
				(SELECT MAX(precio) FROM producto WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = 'Lenovo'));

#3.	Lista el nombre del producto más caro del fabricante Lenovo.
SELECT nombre
FROM producto
WHERE codigo_fabricante = 
						(SELECT codigo FROM fabricante WHERE nombre = 'Lenovo')
ORDER BY precio DESC
LIMIT 1;

#4.	Lista el nombre del producto más barato del fabricante Hewlett-Packard.
SELECT nombre
FROM producto
WHERE codigo_fabricante = 
						(SELECT codigo FROM fabricante WHERE nombre = 'Hewlett-Packard')
ORDER BY precio
LIMIT 1;

#5.	Devuelve todos los productos de la base de datos que tienen un precio mayor o igual al producto más caro del fabricante Lenovo.
SELECT *
FROM producto
WHERE precio >= 
				(SELECT MAX(precio) FROM producto WHERE codigo_fabricante =
																			(SELECT codigo FROM fabricante WHERE nombre = 'Lenovo'));

#6.	Lista todos los productos del fabricante Asus que tienen un precio superior al precio medio de todos sus productos.
SELECT *
FROM producto
WHERE codigo_fabricante = 
						(SELECT codigo FROM fabricante WHERE nombre = 'Asus') AND precio >
																		(SELECT AVG(precio) FROM producto WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = 'Asus'));

#*********************************************Subconsultas con ALL y ANY******************************************************************************************************************

#8.	Devuelve el producto más caro que existe en la tabla producto sin hacer uso de MAX, ORDER BY ni LIMIT.
SELECT *
FROM producto
WHERE precio >= ALL
					(SELECT precio FROM producto);

#9.	Devuelve el producto más barato que existe en la tabla producto sin hacer uso de MIN, ORDER BY ni LIMIT.
SELECT *
FROM producto
WHERE precio <= ALL
					(SELECT precio FROM producto);

#10.	Devuelve los nombres de los fabricantes que tienen productos asociados. (Utilizando ALL o ANY).
SELECT nombre
FROM fabricante
WHERE codigo = ANY 
					(SELECT codigo_fabricante FROM producto);

#11.	Devuelve los nombres de los fabricantes que no tienen productos asociados. (Utilizando ALL o ANY).
SELECT nombre
FROM fabricante
WHERE codigo <> ANY
					(SELECT codigo_fabricante FROM producto);

#*********************************************Subconsultas con IN y NOT IN*****************************************************************************************************************

#12.	Devuelve los nombres de los fabricantes que tienen productos asociados. (Utilizando IN o NOT IN).
SELECT nombre
FROM fabricante
WHERE codigo IN
				(SELECT codigo_fabricante FROM producto);

#13.	Devuelve los nombres de los fabricantes que no tienen productos asociados. (Utilizando IN o NOT IN).
SELECT nombre
FROM fabricante
WHERE codigo NOT IN 
					(SELECT codigo_fabricante FROM producto);

#*********************************************Subconsultas con EXISTS y NOT EXISTS********************************************************************************************************

#14.	Devuelve los nombres de los fabricantes que tienen productos asociados. (Utilizando EXISTS o NOT EXISTS).
SELECT nombre
FROM fabricante
WHERE EXISTS 
				(SELECT 1 FROM producto WHERE codigo_fabricante = fabricante.codigo);

#15.	Devuelve los nombres de los fabricantes que no tienen productos asociados. (Utilizando EXISTS o NOT EXISTS).
SELECT nombre
FROM fabricante
WHERE NOT EXISTS
				(SELECT 1 FROM producto WHERE codigo_fabricante = fabricante.codigo);

#*********************************************Subconsultas correlacionadas*****************************************************************************************************************

#16.	Lista el nombre de cada fabricante con el nombre y el precio de su producto más caro.
SELECT f.nombre AS fabricante, p.nombre AS producto, p.precio
FROM fabricante f
JOIN producto p ON f.codigo = p.codigo_fabricante
WHERE p.precio =				
                (SELECT MAX(precio) FROM producto WHERE codigo_fabricante = f.codigo);

#17.	Devuelve un listado de todos los productos que tienen un precio mayor o igual a la media de todos los productos de su mismo fabricante.
SELECT *
FROM producto p
WHERE p.precio >=
				 (SELECT AVG(precio) FROM producto WHERE codigo_fabricante = p.codigo_fabricante);

#18.	Lista el nombre del producto más caro del fabricante Lenovo.
SELECT nombre
FROM producto
WHERE codigo_fabricante = 
						(SELECT codigo FROM fabricante WHERE nombre = 'Lenovo')
ORDER BY precio DESC
LIMIT 1;


#*********************************************Subconsultas (En la cláusula HAVING)*********************************************************************************************************

#19.	Devuelve un listado con todos los nombres de los fabricantes que tienen el mismo número de productos que el fabricante Lenovo.
SELECT nombre
FROM fabricante
WHERE 
	(SELECT COUNT(*) FROM producto WHERE codigo_fabricante = fabricante.codigo) = 
																		(SELECT COUNT(*) FROM producto WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = 'Lenovo'));
