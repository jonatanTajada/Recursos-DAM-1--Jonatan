SELECT * FROM producto.fabricante;

# 1.	Devuelve una lista de todos los productos del fabricante Lenovo.
select *
from producto
where CODIGO_FABRICANTE = (select CODIGO from fabricante where nombre = 'Lenovo' );

# 2.	Devuelve una lista de todos los productos del fabricante Crucial que tengan un precio mayor que 200.
select *
from producto
where CODIGO_FABRICANTE = (select codigo from fabricante where nombre = 'Crucial') and PRECIO > 200;

# 3.	Devuelve un listado con todos los productos de los fabricantes Asus, Hewlett- Packard y Seagate. Sin utilizar el operador IN.
select *
from producto
where CODIGO_FABRICANTE =(select codigo from fabricante where nombre = 'Asus')
OR CODIGO_FABRICANTE =(select codigo from fabricante where nombre = ' Hewlett- Packard')
or CODIGO_FABRICANTE = (select codigo from fabricante where nombre = 'Seagate'); 

# 4.	Devuelve un listado con todos los productos de los fabricantes Asus, Hewlett- Packard y Seagate. Utilizando el operador IN.
select *
from producto
where CODIGO_FABRICANTE in(select codigo from fabricante where nombre in ('Asus', 'Hewlett- Packard', 'Seagate'));

# 5.	Devuelve un listado con el nombre y el precio de todos los productos de los fabricantes cuyo nombre termine por la vocal e.

select p.nombre, precio
from producto p
join fabricante f on p.CODIGO_FABRICANTE=f.CODIGO
where f.nombre like '%e';


# 6.	Devuelve un listado con el nombre y el precio de todos los productos cuyo  nombre de fabricante contenga el carácter w en su nombre.
select p.nombre, precio
from producto p
join fabricante f on p.CODIGO_FABRICANTE=f.CODIGO
where f.nombre like '%W%';

# 7.	Devuelve un listado con el nombre de producto, precio y nombre de fabricante, de todos los productos que tengan un precio mayor o igual a 180. 
#		Ordene el resultado en primer lugar por el precio (en orden descendente) y en segundo lugar por el nombre (en orden ascendente)

select p.nombre as 'nombre producto', CONCAT(FORMAT(precio, 2), ' €') AS 'precio ', f.nombre as 'nombre fabricante'
from producto p
join fabricante f on p.CODIGO_FABRICANTE=f.CODIGO
where precio >= 180
order by precio desc, p.nombre asc;

#	8.	Devuelve un listado con el identificador y el nombre de fabricante, solamente de aquellos fabricantes que tienen productos asociados en la base de datos.

select distinct f.codigo, f.nombre
from fabricante f
left join producto p on f.CODIGO=p.CODIGO_FABRICANTE
where p.CODIGO_FABRICANTE is not null;


SELECT DISTINCT f.codigo, f.nombre
FROM fabricante f
WHERE EXISTS (
    SELECT 1
    FROM producto p
    WHERE f.CODIGO = p.CODIGO_FABRICANTE
);

#	Resuelva las siguientes consultas utilizando las cláusulas LEFT JOIN y RIGHT JOIN.
#	1.	Devuelve un listado de todos los fabricantes que existen en la base de datos, junto con los productos que tiene cada uno de ellos. 
#	    El listado deberá mostrar también aquellos fabricantes que no tienen productos asociados.

SELECT f.*, p.*
FROM fabricante f
LEFT JOIN producto p ON f.CODIGO = p.CODIGO_FABRICANTE;


#	Devuelve un listado donde sólo aparezcan aquellos fabricantes que no tienen ningún producto asociado.

select f.*
from fabricante f
left join producto p on f.CODIGO=p.CODIGO_FABRICANTE
where p.CODIGO_FABRICANTE is null;

-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------
--	--  Consultas resumen  -- 
-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------

#1.	Calcula el número total de productos que hay en la tabla productos.
select count(*) as 'total productos'
from producto;

#2.	Calcula el número total de fabricantes que hay en la tabla fabricante.
select count(codigo) as 'numero total de fabricante en la lista'
from fabricante;

#3.	Calcula el número de valores distintos de identificador de fabricante aparecen en la tabla productos.
select  count(distinct CODIGO_FABRICANTE) as 'distintos fabricantes'
from producto;

#4.	Calcula la media del precio de todos los productos.
select avg(PRECIO) as precio_promedio
from Producto;

#5.	Calcula el precio más barato de todos los productos.
select min(precio) as 'producto mas barato'
from producto;

#6.	Calcula el precio más caro de todos los productos.
select max(precio) as 'producto mas barato'
from producto;

#7.	Lista el nombre y el precio del producto más barato.
select nombre, precio as 'producto mas barato'
from producto
where precio = (select min(precio) from producto);
--  2ºforma --
SELECT nombre, precio as 'producto mas barato'
FROM Producto
ORDER BY precio
LIMIT 1;

#8.	Lista el nombre y el precio del producto más caro.
select nombre, precio as 'producto mas caro'
from producto
where precio = (select max(precio) from producto);
-- 2º forma --
select nombre, precio as'producto mas caro'
from producto
order by precio desc
limit 1;

#9.	Calcula la suma de los precios de todos los productos.
select sum(precio) as 'suma total de los productos'
from producto;

#10.	Calcula el número de productos que tiene el fabricante Asus.
select count(*) as 'numero de productos'
from producto
where CODIGO_FABRICANTE = (select codigo from fabricante where nombre = 'Asus');

#11.	Calcula la media del precio de todos los productos del fabricante Asus.
 select avg(precio) as 'media de los productos de Asus'
from producto
where CODIGO_FABRICANTE = (select codigo from fabricante f where f.nombre = 'Asus');
 
#12.	Calcula el precio más barato de todos los productos del fabricante Asus.
select min(precio) as 'producto mas barato de proveedor Asus'
from producto p
where p.CODIGO_FABRICANTE = (select codigo from fabricante f where f.nombre = 'Asus');

#13.	Calcula el precio más caro de todos los productos del fabricante Asus.
select max(precio) as 'producto mas barato de proveedor Asus'
from producto p
where p.CODIGO_FABRICANTE = (select codigo from fabricante f where f.nombre = 'Asus');

#14.	Calcula la suma de todos los productos del fabricante Asus.
select sum(precio) as 'suma de todos los productos del proveedor Asus'
from producto p
where p.CODIGO_FABRICANTE = (select codigo from fabricante f where f.nombre = 'Asus');

#15.	Muestra el precio máximo, precio mínimo, precio medio y el número total de productos que tiene el fabricante Crucial.
select min(precio) as 'producto mas barato', max(precio) as 'producto mas caro', avg(precio) as 'media de todos sus productos', count(*) as 'total productos diferentes del proveedor'
from producto p
where p.CODIGO_FABRICANTE = (select codigo from fabricante f where f.nombre = 'Crucial');

#16.	Muestra el número total de productos que tiene cada uno de los fabricantes. El listado también debe incluir los fabricantes 
#		que no tienen ningún producto. El resultado mostrará dos columnas, una con el nombre del fabricante y otra con el número de productos que tiene. 
#		Ordene el resultado descendentemente por el número de productos.
select f.nombre as 'nombre fabricante', count(p.codigo) as 'numero total de productos'
from fabricante f
left join producto p on f.CODIGO= p.CODIGO_FABRICANTE
group by f.NOMBRE
order by 'numero de productos' desc;

#17.	Muestra el precio máximo, precio mínimo y precio medio de los productos de cada uno de los fabricantes. El resultado mostrará el nombre del fabricante 
#		junto con los datos que se solicitan.
select f.nombre as 'nombre fabricante', max(precio) as 'precio mas caro', min(precio) as 'precio mas barato', avg(precio) as 'precio medio'
from producto p
left join fabricante f on p.CODIGO_FABRICANTE=f.CODIGO
group by f.nombre;

#18.	Muestra el precio máximo, precio mínimo, precio medio y el número total de productos de los fabricantes que tienen un precio medio superior a 200. 
#		No es necesario mostrar el nombre del fabricante, con el identificador del fabricante es suficiente.
select  p.CODIGO_FABRICANTE AS 'Identificador del Fabricante', max(precio) as 'precio mas caro', min(precio) as 'precio mas barato', avg(precio) as 'precio medio',
	    count(p.codigo) as'numero total de productos superior a 200€'
from producto p
join fabricante f on p.CODIGO_FABRICANTE=f.CODIGO
group by p.CODIGO_FABRICANTE
having avg(p.precio) > 200;    
        
#19.	Muestra el nombre de cada fabricante, junto con el precio máximo, precio mínimo, precio medio y el número total de productos de los fabricantes que 
#		tienen un precio medio superior a 200. Es necesario mostrar el nombre del fabricante.
select f.nombre as 'nombre fabricante', max(precio) as 'precio mas caro', min(precio) as 'precio mas barato', avg(precio) as 'precio medio',
		count(*) as 'total productos'
from fabricante f
left join producto p on f.CODIGO=p.CODIGO_FABRICANTE
group by f.nombre
having avg(precio) > 200;

#20.	Calcula el número de productos que tienen un precio mayor o igual a 180.
select count(*) as 'cantidad de productos >= 180'
from producto
where precio >= 180;

#21.	Calcula el número de productos que tiene cada fabricante con un precio mayor o igual a 180.
select p.CODIGO_FABRICANTE as'codigo fabricante', count(p.codigo) as 'cantidad de productos >= 180'
from producto p
join fabricante f on p.CODIGO_FABRICANTE = f.CODIGO
where precio >= 180
group by p.CODIGO_FABRICANTE;

#22.	Lista el precio medio los productos de cada fabricante, mostrando solamente el identificador del fabricante.
select codigo_fabricante as 'identificador fabricante', avg(precio) as 'precio medio total de sus productos'
from producto 
group by CODIGO_FABRICANTE;

#23.	Lista el precio medio los productos de cada fabricante, mostrando solamente el nombre del fabricante.
select f.nombre as 'nombre fabricante', avg(precio) as 'precio medio total de sus productos'
from producto p
join fabricante f on p.CODIGO_FABRICANTE=f.CODIGO
group by f.nombre;

#24.	Lista los nombres de los fabricantes cuyos productos tienen un precio medio mayor o igual a 150.
select f.nombre as 'nombre fabricante'
from fabricante f
join producto p on f.CODIGO = p.CODIGO_FABRICANTE
group by f.nombre
having avg(p.precio) >= 150;

#25.	Devuelve un listado con los nombres de los fabricantes que tienen 2 o más productos.
select f.nombre as 'nombre fabricante'
from fabricante f
join producto p on f.CODIGO=p.CODIGO_FABRICANTE
group by f.nombre
having count(f.nombre) >= 2;


-- -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--			-- Consultas sobre una tabla  -- 
-- -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

#1.	Devuelve un listado con todos los pedidos que se han realizado. Los pedidos deben estar ordenados por la fecha de realización, mostrando en primer lugar los pedidos más recientes.
select *
from pedido
order by fecha desc;

#2.	Devuelve todos los datos de los dos pedidos de mayor valor.
select *
from pedido
order by total desc
limit 2;

#3.	Devuelve un listado con los identificadores de los clientes que han realizado algún pedido. Tenga en cuenta que no debe mostrar identificadores que estén repetidos.
select distinct c.id
from cliente c
join pedido p on c.id= p.id;
								-- ¡¡ no se cual de las dos es mas correcta, para mi la primera, devueven resultados diferentes !!  --
SELECT DISTINCT id_cliente
FROM pedido;

#4.	Devuelve un listado de todos los pedidos que se realizaron durante el año 2017, cuya cantidad total sea superior a 500.
select *
from pedido
where year(fecha) = 2017 and total > 500;

#5.	Devuelve un listado con el nombre y los apellidos de los comerciales que tienen una comisión entre 0.05 y 0.11.
select nombre, apellido1, apellido2
from comercial 
where comision between 0.05 and 0.11;

#6.	Devuelve el valor de la comisión de mayor valor que existe en la tabla comercial.
select max(comision) as 'comision de mayor valor'
from comercial;
 
#7.	Devuelve el identificador, nombre y primer apellido de aquellos clientes cuyo segundo apellido no es NULL. El listado deberá estar ordenado alfabéticamente por apellidos y nombre.
select id, nombre, apellido1
from cliente
where apellido2 is not null
order by apellido1, nombre;

#8.	Devuelve un listado de los nombres de los clientes que empiezan por A y terminan por n y también los nombres que empiezan por P. El listado deberá estar ordenado alfabéticamente.
select *
from cliente
where (nombre like 'A%' or nombre like 'P%') and nombre like '%n'
order by nombre;

#9.	Devuelve un listado de los nombres de los clientes que no empiezan por A. El listado deberá estar ordenado alfabéticamente.
select nombre
from cliente
where nombre not like 'A%'
order by nombre;

#10.	Devuelve un listado con los nombres de los comerciales que terminan por el o o. Tenga en cuenta que se deberán eliminar los nombres repetidos.
select distinct nombre
from comercial
where nombre like '%o%o';

-- -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--			-- Consultas multitabla (Composición interna)     join  / inner join  -- 
-- -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
#1.	Devuelve un listado con el identificador, nombre y los apellidos de todos los clientes que han realizado algún pedido. 
#	El listado debe estar ordenado alfabéticamente y se deben eliminar los elementos repetidos.
select c.id as 'id cliente', c.nombre, c.apellido1, c.apellido2
from cliente c
join pedido p on c.id = p.id_cliente
group by c.id
order by c.nombre;

#2.	Devuelve un listado que muestre todos los pedidos que ha realizado cada cliente. El resultado debe mostrar todos los datos de los pedidos y del cliente.
#	El listado debe mostrar los datos de los clientes ordenados alfabéticamente.
select c.id as 'id cliente', c.nombre, c.apellido1, c.apellido2, p.*
from cliente c
join pedido p on c.id = p.id_cliente
order by c.nombre;

#3.	Devuelve un listado que muestre todos los pedidos en los que ha participado un comercial. El resultado debe mostrar todos los datos de los pedidos y de los comerciales. 
#	El listado debe mostrar los datos de los comerciales ordenados alfabéticamente.
select *
from pedido p
join comercial co on p.id_comercial = co.id
order by co.nombre;

#4.	Devuelve un listado que muestre todos los clientes, con todos los pedidos que han realizado y con los datos de los comerciales asociados a cada pedido.
select *
from comercial co
join pedido p on co.id= p.id_comercial
join cliente c on p.id_cliente=c.id
order by c.nombre;

#5.	Devuelve un listado de todos los clientes que realizaron un pedido durante el año 2017, cuya cantidad esté entre 300 € y 1000 €.
select c.*
from cliente c
join pedido p on c.id = p.id_cliente
where year(fecha) = 2017 and total between 300 and 1000
order by c.nombre;
#6.	Devuelve el nombre y los apellidos de todos los comerciales que ha participado en algún pedido realizado por María Santana Moreno.
select distinct co.nombre, co.apellido1,co.apellido2
from comercial co
join pedido p on co.id=p.id_comercial
join cliente c on c.id=p.id_cliente
where c.nombre = 'Maria' and c.apellido1 = 'Santana' and c.apellido2 = 'Moreno';

#7.	Devuelve el nombre de todos los clientes que han realizado algún pedido con el comercial Daniel Sáez Vega.
select distinct c.nombre as 'nombre cliente'
from cliente c
join pedido p on c.id=p.id_cliente
join comercial co on p.id_comercial=co.id
where co.nombre = 'Daniel' and co.apellido1 = 'Saez' and co.apellido2 = 'Vega';


-- -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--			-- Consultas multitabla (Composición externa) LEFT JOIN, RIGHT JOIN, o FULL JOIN      -- 
-- -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
#1.	Devuelve un listado con todos los clientes junto con los datos de los pedidos que han realizado. Este listado también debe incluir los clientes que no han realizado ningún pedido.
#	El listado debe estar ordenado alfabéticamente por el primer apellido, segundo apellido y nombre de los clientes.
select c.id, c.nombre, c.apellido1, c.apellido2, p.id AS id_pedido, p.total, p.fecha
from cliente c
left join pedido p on c.id= p.id_cliente
order by c.apellido1, c.apellido2, c.nombre;

#2.	Devuelve un listado con todos los comerciales junto con los datos de los pedidos que han realizado. 
#	Este listado también debe incluir los comerciales que no han realizado ningún pedido. El listado debe estar ordenado alfabéticamente por el primer apellido, segundo apellido y nombre de los comerciales.
select co.id as 'id comercial', co.nombre as 'nombre comercial', co.apellido1, co.apellido2, p.id as 'id pedido', p.total as 'total pedido', p.fecha
from comercial co
left join pedido p on co.id=p.id_comercial
ORDER BY co.apellido1, COALESCE(co.apellido2, ''), co.nombre;

#3.	Devuelve un listado que solamente muestre los clientes que no han realizado ningún pedido.
select  c.id, c.nombre, c.apellido1, c.apellido2
from cliente c
left join pedido p on c.id=p.id_cliente
where p.id  is null
order by c.apellido1, coalesce(c.apellido2, ''), c.nombre;

#4.	Devuelve un listado que solamente muestre los comerciales que no han realizado ningún pedido.
select co.*
from comercial co
left join pedido p on co.id=p.id_comercial
where p.id is null
order by co.apellido1, COALESCE(co.apellido2, ''), co.nombre;

#5.	Devuelve un listado con los clientes que no han realizado ningún pedido y de los comerciales que no han participado en ningún pedido.
#	Ordene el listado alfabéticamente por los apellidos y el nombre. En en listado deberá diferenciar de algún modo los clientes y los comerciales.
SELECT 'Cliente' AS tipo, c.id, c.nombre, c.apellido1, c.apellido2
FROM cliente c
LEFT JOIN pedido p ON c.id = p.id_cliente
WHERE p.id IS NULL
UNION
SELECT 'Comercial' AS tipo, co.id, co.nombre, co.apellido1, co.apellido2
FROM comercial co
LEFT JOIN pedido p ON co.id = p.id_comercial
WHERE p.id IS NULL
ORDER BY apellido1, COALESCE(apellido2, ''), nombre;

-- -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--			-- Consultas Resumen  -- 
-- -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

#1.	Calcula la cantidad total que suman todos los pedidos que aparecen en la tabla pedido.
select concat(truncate(sum(total ),2 ), ' €') as 'cantidad total que suman todos los pedidos de la lista'
from pedido; 

#2.	Calcula la cantidad media de todos los pedidos que aparecen en la tabla pedido.
select concat(truncate(avg(total), 2), '€') as 'promedio de todos los pedidos de la lista'
from pedido;

#3.	Calcula el número total de comerciales distintos que aparecen en la tabla pedido.
select  count(distinct id) as 'total comerciales'
from comercial;

#4.	Calcula el número total de clientes que aparecen en la tabla cliente.
select count(id) as 'total clientes en la empresa'
from cliente; 

#5.	Calcula cuál es la mayor cantidad que aparece en la tabla pedido.
select max(total) as 'pedido con mayor valor'
from pedido;

#6.	Calcula cuál es la menor cantidad que aparece en la tabla pedido.
select min(total) as 'pedido con mayor valor'
from pedido;

#7.	Calcula cuál es el valor máximo de categoría para cada una de las ciudades que aparece en la tabla cliente.
select ciudad, max(categoria) as 'valor maximo de categoria'
from cliente
group by ciudad;

#8.	Calcula cuál es el máximo valor de los pedidos realizados durante el mismo día para cada uno de los clientes. 
#	Es decir, el mismo cliente puede haber realizado varios pedidos de diferentes cantidades el mismo día. 
#	Se pide que se calcule cuál es el pedido de máximo valor para cada uno de los días en los que un cliente ha realizado un pedido. 
#	Muestra el identificador del cliente, nombre, apellidos, la fecha y el valor de la cantidad.
select  id_cliente, c.nombre, c.apellido1, c.apellido2, fecha, MAX(total) AS maximo_valor
from pedido p
join cliente c on p.id_cliente = c.id
group by id_cliente, fecha;

#9.	Calcula cuál es el máximo valor de los pedidos realizados durante el mismo día para cada uno de los clientes, 
#	teniendo en cuenta que sólo queremos mostrar aquellos pedidos que superen la cantidad de 2000 €.
select  id_cliente, c.nombre, c.apellido1, c.apellido2, fecha, MAX(total) AS maximo_valor
from pedido p
join cliente c on p.id_cliente = c.id
where total > 200
group by id_cliente, fecha;

#10.	Calcula el máximo valor de los pedidos realizados para cada uno de los comerciales durante la fecha 2016-08-17. 
#		Muestra el identificador del comercial, nombre, apellidos y total.



#11.	Devuelve un listado con el identificador de cliente, nombre y apellidos y el número total de pedidos que ha realizado cada uno de clientes. 
#		Tenga en cuenta que pueden existir clientes que no han realizado ningún pedido. Estos clientes también deben aparecer en el listado indicando que el número de pedidos realizados es 0.


#12.	Devuelve un listado con el identificador de cliente, nombre y apellidos y el número total de pedidos que ha realizado cada uno de clientes durante el año 2017.

#13.	Devuelve un listado que muestre el identificador de cliente, nombre, primer apellido y el valor de la máxima cantidad del pedido realizado por cada uno de los clientes. 
#		El resultado debe mostrar aquellos clientes que no han realizado ningún pedido indicando que la máxima cantidad de sus pedidos realizados es 0. Puede hacer uso de la función IFNULL.

#14.	Devuelve cuál ha sido el pedido de máximo valor que se ha realizado cada año.

#15.	Devuelve el número total de pedidos que se han realizado cada año.














