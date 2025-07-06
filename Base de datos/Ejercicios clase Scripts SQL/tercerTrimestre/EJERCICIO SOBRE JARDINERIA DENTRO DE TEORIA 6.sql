# EL SCRIPT DE LA BASE DE DATOS ESTA EN LA CARPTERA SEGUNDO TRIMESTRE
-- ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- 
-- --									EJERCICIOS DE LA TEORÍA 6 EN LA UD 6. INDICES
-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

#	1.	Consulte cuáles son los índices que hay en la tabla producto utilizando las instrucciones SQL que nos permiten obtener esta información de la tabla.

show index from producto;

#	2.	Haga uso de EXPLAIN para obtener información sobre cómo se están realizando las consultas y diga cuál de las dos consultas realizará menos comparaciones
#		 para encontrar el producto que estamos buscando.  ¿Cuántas comparaciones se realizan en cada caso? ¿Por qué?.
			EXPLAIN SELECT *
			FROM producto
			WHERE codigo_producto = 'OR-114';
			

			EXPLAIN SELECT *
			FROM producto
			WHERE nombre = 'Evonimus Pulchellus';

Primera consulta: type : const - rows : 1  
Segunda consulta: type : all - rows : 276

	 - La primera consulta esta utilizando un indice para realizar la busqueda, pk.
	 - La segunda consulta escanea toda la tabla.
Dado que la primera consulta utiliza la pk para una busqueda directa y el numero de filas examinadas es 1, la 1º consulta es mas eficiente que la segunda consulta que recorre toda la tabla.

#	3.	Suponga que estamos trabajando con la base de datos jardineria y queremos saber optimizar las siguientes consultas. ¿Cuál de las dos sería más eficiente?. 
#		Se recomienda hacer uso de EXPLAIN para obtener información sobre cómo se están realizando las consultas.

		EXPLAIN SELECT AVG(total)
		FROM pago
		WHERE YEAR(fecha_pago) = 2008;


		EXPLAIN SELECT AVG(total)
		FROM pago
		WHERE fecha_pago >= '2008-01-01' AND fecha_pago <= '2008-12-31';

show index from pago;

Ambas consultas muestran un escaneo completo , all, y numero de filas eaxminadas, 26. No estamos utilizando indices para optimizar la busqueda, type: all, por lo tanto,
la segunda consulta es mas eficiente ya que el porcentaje de filtrado es menor,11.11%.

Para optimizar esta consulta lo que podemos hacer es crear un indice sobre el campo fecha_pago (campo que se encuentra en el where):
create index idx_fecha_pago on pago(fecha_pago);
drop index idx_fecha_pago on pago;


#				¡¡¡¡Nota: Lectura recomendada sobre la función YEAR y el uso de índices.!!!!

#	4.	Optimiza la siguiente consulta creando índices cuando sea necesario. Se recomienda hacer uso de EXPLAIN para obtener información sobre cómo se están realizando las consultas.

		EXPLAIN SELECT *
		FROM cliente INNER JOIN pedido
		ON cliente.codigo_cliente = pedido.codigo_cliente
		WHERE cliente.nombre_cliente LIKE 'A%';
        

create index idx_nombre_cliente on cliente(nombre_cliente);
create index idx_codigo_pedido_cliente on pedido(codigo_cliente);


#	5.	¿Por qué no es posible optimizar el tiempo de ejecución de las siguientes consultas, incluso haciendo uso de índices?
 
		SELECT *
		FROM cliente INNER JOIN pedido
		ON cliente.codigo_cliente = pedido.codigo_cliente
		WHERE cliente.nombre_cliente LIKE '%A%';


		SELECT *
		FROM cliente INNER JOIN pedido
		ON cliente.codigo_cliente = pedido.codigo_cliente
		WHERE cliente.nombre_cliente LIKE '%A';
 
Las consultas que utilizan patrones de busqueda que comienzan o terminan con un caracter comodin (%) no pueden ser optimizadas eficientemente 
con indices porque no pueden aprovechar completamente la estructura de índices. En el caso de LIKE '%A%', el índice no puede ser utilizado para 
buscar valores que contienen caracteres antes y despues de 'A'. Similarmente, para LIKE '%A', el indice no puede ser utilizado para buscar valores que terminan con 'A'. 
 
-- ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- 
-- --									Optimización de consultas	Curso 2023/2024	--
-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

#	6.	Crea un índice de tipo FULLTEXT sobre las columnas nombre y descripcion de la tabla producto.

create fulltext index idx_nombre on producto(nombre);
create fulltext index idx_descripcion on producto(descripcion);

show index from producto;
drop index idx_nombre_descripcion on producto;

#	7.	Una vez creado el índice del ejercicio anterior realiza las siguientes consultas haciendo uso de la función
#		MATCH, para buscar todos los productos que:


#	Contienen la palabra planta en el nombre o en la descripción. Realice una consulta para cada uno de los modos de búsqueda fulltext que existen en MySQL
# 	(IN NATURAL LANGUAGE MODE, IN BOOLEAN MODE y WITH QUERY EXPANSION) y compare los resultados que ha obtenido en cada caso.

-- Contienen la palabra 'planta' en el nombre o descripción (modo NATURAL LANGUAGE).
SELECT *
FROM producto
WHERE MATCH(nombre, descripcion) AGAINST ('planta' IN NATURAL LANGUAGE MODE);

-- Contienen la palabra 'planta' en el nombre o descripción (modo BOOLEAN).
SELECT *
FROM producto
WHERE MATCH(nombre, descripcion) AGAINST ('planta' IN BOOLEAN MODE);

-- Contienen la palabra 'planta' en el nombre o descripción (con expansión de consulta).
SELECT *
FROM producto
WHERE MATCH(nombre, descripcion) AGAINST ('planta' WITH QUERY EXPANSION);


#	Contienen la palabra planta seguida de cualquier carácter o conjunto de caracteres, en el nombre o en la descripción.
SELECT *
FROM producto
WHERE MATCH(nombre, descripcion) AGAINST ('planta*' IN BOOLEAN MODE);


#	Empiezan con la palabra planta en el nombre o en la descripción.
SELECT *
FROM producto
WHERE MATCH(nombre, descripcion) AGAINST ('planta*' IN BOOLEAN MODE);


#	Contienen la palabra tronco o la palabra árbol en el nombre o en la descripción.
SELECT *
FROM producto
WHERE MATCH(nombre, descripcion) AGAINST ('tronco árbol' IN BOOLEAN MODE);


#	Contienen la palabra tronco y la palabra árbol en el nombre o en la descripción.
SELECT *
FROM producto
WHERE MATCH(nombre, descripcion) AGAINST ('+tronco +árbol' IN BOOLEAN MODE);


#	Contienen la palabra tronco pero no contienen la palabra árbol en el nombre o en la descripción.
SELECT *
FROM producto
WHERE MATCH(nombre, descripcion) AGAINST ('+tronco -árbol' IN BOOLEAN MODE);



#	Contiene la frase proviene de las costas en el nombre o en la descripción.
SELECT *
FROM producto
WHERE MATCH(nombre, descripcion) AGAINST ('"proviene de las costas"' IN BOOLEAN MODE);


#	8.	Crea un índice de tipo INDEX compuesto por las columnas apellido_contacto y nombre_contacto de la tabla cliente.
create index idx_apellido_nombre_contacto on cliente(apellido_contacto, nombre_contacto);


#	9.	Una vez creado el índice del ejercicio anterior realice las siguientes consultas haciendo uso de EXPLAIN:

-- Busca el cliente Javier Villar.
EXPLAIN SELECT * FROM cliente WHERE apellido_contacto = 'Villar' AND nombre_contacto = 'Javier';

-- Busca el cliente utilizando solamente el apellido Villar.
EXPLAIN SELECT * FROM cliente WHERE apellido_contacto = 'Villar';

-- Busca el cliente utilizando solamente el nombre Javier.
EXPLAIN SELECT * FROM cliente WHERE nombre_contacto = 'Javier';


# 10. Cálculo de un buen valor para crear un índice sobre un prefijo de la columna nombre_cliente de la tabla cliente.

-- Calculamos cuántos valores distintos existen en la columna nombre_cliente.
SELECT COUNT(DISTINCT nombre_cliente) FROM cliente;

-- Calculamos el número de caracteres necesarios para diferenciar todos los valores de la columna nombre_cliente.
SELECT COUNT(DISTINCT LEFT(nombre_cliente, 1)) AS caracteres_minimos FROM cliente;

-- Una vez encontrado el valor adecuado para el prefijo, creamos el índice.
CREATE INDEX idx_prefijo_nombre_cliente ON cliente(nombre_cliente(2));

-- Ejecutamos algunas consultas de prueba sobre el índice creado.
EXPLAIN SELECT * FROM cliente WHERE nombre_cliente LIKE 'Ja%';
EXPLAIN SELECT * FROM cliente WHERE nombre_cliente LIKE 'Pe%';
