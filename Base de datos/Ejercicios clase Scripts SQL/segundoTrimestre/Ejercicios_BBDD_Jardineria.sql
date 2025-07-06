#Base de datos: Jardinería. Ejercicios que se encuentra en el interior del Word de Teoria de Vistas.

-- ---------------------------VISTAS--------------------------------------------------------------------------------------
#1.	Escriba una vista que se llame listado_pagos_clientes que muestre un listado donde aparezcan todos los clientes
#   y los pagos que ha realizado cada uno de ellos. La vista deberá tener las siguientes co‑ lumnas: nombre y apellidos 
#   del cliente concatenados, teléfono, ciudad, pais, fecha_pago, total del pago, id de la transacción

create view listado_pagos_clientes as
select 
	   concat(c.nombre_cliente, ' ', c.apellido_contacto) as nombre_apellidos,
       c.telefono as telefono,
       c.ciudad as ciudad,
       c.pais as pais,
       p.fecha_pago as fecha_pago,
       p.total as total_pago,
       p.id_transaccion
from cliente c 
join pago p on c.codigo_cliente = p.codigo_cliente;

select * from listado_pagos_clientes;


#2.	Escriba una vista que se llame listado_pedidos_clientes que muestre un listado donde aparezcan todos los clientes 
#   y los pedidos que ha realizado cada uno de ellos. La vista deberá tener las siguientes columnas: nombre y apellidos del 
#	cliente concatendados, teléfono, ciudad, pais, código del pedido, fe‑ cha del pedido, fecha esperada, fecha de entrega y 
#	la cantidad total del pedido, que será la suma del producto de todas las cantidades por el precio de cada unidad, que aparecen en cada línea de pedido.   

create view listado_pedidos_clientes as
select
		c.codigo_cliente,
		concat(c.nombre_cliente, ' ', c.apellido_contacto) as nombre_apellidos,
		c.telefono as telefono,
        c.ciudad as ciudad,
        c.pais as pais,
        pe.codigo_pedido as codigo_pedido,
        pe.fecha_pedido as fecha_pedido,
        pe.fecha_esperada as fecha_esperada,
        pe.fecha_entrega as fecha_entrega,
        CONCAT(FORMAT(SUM(dp.cantidad * dp.precio_unidad), 2), ' €') AS cantidad_total_pedido
from cliente c
join pedido pe on c.codigo_cliente = pe.codigo_cliente
join detalle_pedido dp on pe.codigo_pedido = dp.codigo_pedido
group by c.codigo_cliente, pe.codigo_pedido;

select * from listado_pedidos_clientes;        



#3.	Utilice las vistas que ha creado en los pasos anteriores para devolver un listado de los clientes de la ciudad de Madrid que han realizado pagos.
-- Utilizar la vista listado_pagos_clientes
select *
from listado_pagos_clientes
where ciudad = 'Madrid';

#4.	Utilice las vistas que ha creado en los pasos anteriores para devolver un listado de los clientes que todavía no han recibido su pedido.
select *
from listado_pedidos_clientes
where fecha_entrega is null;

#5.	Utilice las vistas que ha creado en los pasos anteriores para calcular el número de pedidos que se ha realizado cada uno de los clientes.
-- Utilizar la vista listado_pedidos_clientes
select
    codigo_cliente,
    nombre_apellidos as nombre_completo,
    COUNT(distinct codigo_pedido) as numero_pedidos
from
    listado_pedidos_clientes
group by
    codigo_cliente, nombre_apellidos;

				#describe listado_pedidos_clientes;

#6.	Utilice las vistas que ha creado en los pasos anteriores para calcular el valor del pedido máximo y mínimo que ha realizado cada cliente.
select 
		codigo_cliente,
        nombre_apellidos as nombre_completo,
        max(cantidad_total_pedido) as valor_maximo_pedido,
        min(cantidad_total_pedido) as valor_minimo_pedido
from
		listado_pedidos_clientes
group by
		codigo_cliente, nombre_completo;	
        

#7.	Modifique el nombre de las vista listado_pagos_clientes y asígnele el nombre listado_de_pagos.
#   Una vez que haya modificado el nombre de la vista ejecute una consulta utilizando el nuevo 
#   nombre de la vista para comprobar que sigue funcionando correctamente.
		-- Renombrar la vista utilizando CREATE OR REPLACE VIEW
CREATE OR REPLACE VIEW listado_de_pagos AS
SELECT
    nombre_apellidos,
    telefono,
    ciudad,
    pais,
    fecha_pago,				#no modifica crea uno nuevo con los mismos campos 
    total_pago,
    id_transaccion
FROM
    listado_pagos_clientes;


select * from listado_de_pagos;

#8.	Elimine las vistas que ha creado en los pasos anteriores.
drop view if exists listado_pedidos_clientes, listado_pagos_clientes;


-- ----------------------------------------------------------------------------------------------------------------------------------------
				#Base de datos: Jardinería. EjerciciosConsultasJardineria. word externo
-- -----------------------------------------------------------------------------------------------------------------------------------------
#Consultas Simples, sobre una tabla.
-- ----------------------------------------------------------------------------------------------------------------------------------------

#1.	Devuelve un listado con el código de oficina y la ciudad donde hay oficinas.
select codigo_oficina, ciudad 
from oficina;

#2.	Devuelve un listado con la ciudad y el teléfono de las oficinas de España.
select ciudad, telefono
from oficina
where pais = 'España';
#3.	Devuelve un listado con el nombre, apellidos y email de los empleados cuyo jefe tiene un código de jefe igual a 7.
select nombre, apellido1, apellido2, email
from empleado
where codigo_jefe = 7;
#4.	Devuelve el nombre del puesto, nombre, apellidos y email del jefe de la empresa.
select e.puesto, e.nombre, e.apellido1, e.apellido2, e.email
from empleado e
join empleado j on e.codigo_jefe = j.codigo_empleado
where e.codigo_jefe is null;

#5.	Devuelve un listado con el nombre, apellidos y puesto de aquellos empleados que no sean representantes de ventas.
select nombre, apellido1, apellido2, puesto
from empleado								#dudas si es asi
where puesto != 'Representante de Ventas';
#6.	Devuelve un listado con el nombre de los todos los clientes españoles.
select nombre_cliente
from cliente
where pais = 'Spain';
#7.	Devuelve un listado con los distintos estados por los que puede pasar un pedido.
select distinct estado
FROM pedido;

#8.	Devuelve un listado con el código de cliente de aquellos clientes que realizaron algún pago en 2008.
#   Tenga en cuenta que deberá eliminar aquellos códigos de cliente que aparezcan repetidos. Resuelva la consulta:
	#•	Utilizando la función YEAR de MySQL.
	#•	Utilizando la función DATE_FORMAT de MySQL.
	#•	Sin utilizar ninguna de las funciones anteriores.
    
			-- Utilizando la función YEAR. --
select distinct codigo_cliente
from pago
where year(fecha_pago) = 2008;

			-- Utilizando la función DATE_FORMAT. --
select distinct codigo_cliente
from pago
where DATE_FORMAT(fecha_pago, '%Y') = '2008';

			-- Sin utilizar ninguna de las funciones anteriores. --
select distinct p.codigo_cliente
from pago p
join pedido pe on p.codigo_cliente = pe.codigo_cliente
where pe.fecha_pedido between '2008-01-01' and '2008-12-31';

#9.	Devuelve un listado con el código de pedido, código de cliente, fecha esperada 
#   y fecha de entrega de los pedidos que no han sido entregados a tiempo.
select codigo_pedido, codigo_cliente, fecha_esperada, fecha_entrega
from pedido
where fecha_entrega > fecha_esperada;
#10. Devuelve un listado con el código de pedido, código de cliente, fecha esperada 
#	 y fecha de entrega de los pedidos cuya fecha de entrega ha sido al menos dos días antes de la fecha esperada.

		#•	Utilizando la función ADDDATE.
			select codigo_pedido, codigo_cliente, fecha_esperada, fecha_entrega
			from pedido
			where fecha_entrega < ADDDATE(fecha_esperada, -2);
        
		#•	Utilizando la función DATEDIFF.
			SELECT codigo_pedido, codigo_cliente, fecha_esperada, fecha_entrega
			FROM pedido
			WHERE DATEDIFF(fecha_entrega, fecha_esperada) <= -2;

		#•	¿Sería posible resolver esta consulta utilizando el operador de suma + o resta -?
			-- No es posible resolver esta consulta directamente con los operadores de suma o resta. Para ello tenemos funciones --


#11.	Devuelve un listado de todos los pedidos que fueron rechazados en 2009.
select *
from pedido
where estado = 'Rechazado' and year(fecha_pedido) = 2009;
#12.	Devuelve un listado de todos los pedidos que han sido entregados en el mes de enero de cualquier año.
select *
from pedido
where month(fecha_entrega) = 1;
#13.	Devuelve un listado con todos los pagos que se realizaron en el año 2008 mediante Paypal. Ordene el resultado de mayor a menor.
select *
from pago
where forma_pago = 'PayPal' and year(fecha_pago) = 2008
order by total desc;
#14.	Devuelve un listado con todas las formas de pago que aparecen en la tabla pago. 
#       Tenga en cuenta que no deben aparecer formas de pago repetidas.
select distinct forma_pago
from pago;
#15.	Devuelve un listado con todos los productos que pertenecen a la gama Ornamentales 
#		y que tienen más de 100 unidades en stock. El listado deberá estar ordenado por su precio de venta, 
#		mostrando en primer lugar los de mayor precio.
select *
from producto
where gama = 'Ornamentales' and cantidad_en_stock > 100
order by precio_venta desc;

#16.	Devuelve un listado con todos los clientes que sean de la ciudad de Madrid
#		y cuyo representante de ventas tenga el código de empleado 11 o 30.
select *
from cliente
where ciudad = 'Madrid' and codigo_empleado_rep_ventas in (11, 30);


-- -----------------------------------------------------------------------------------------------------------------------------------------
# Consultas MultiTablas - (Composicion Interna --   resolver con INNER JOIN y NATURAL JOIN.) - 
-- ----------------------------------------------------------------------------------------------------------------------------------------

#1.	Obtén un listado con el nombre de cada cliente y el nombre y apellido de su representante de ventas.
		-- Utilizando INNER JOIN
select c.nombre_cliente, e.nombre as nombre_representante, e.apellido1 as apellido1_representante
from cliente c
join empleado e on c.codigo_empleado_rep_ventas = e.codigo_empleado;

		-- Utilizando NATURAL JOIN  - ¡No puede ser no comparte el mismo campo!

#2.	Muestra el nombre de los clientes que hayan realizado pagos junto con el nombre de sus representantes de ventas.
-- Utilizando INNER JOIN
select c.nombre_cliente, e.nombre as nombre_representante, e.apellido1 as apellido_representante
from cliente c
join pago p on c.codigo_cliente = p.codigo_cliente
join empleado e on c.codigo_empleado_rep_ventas = e.codigo_empleado;

		-- Utilizando NATURAL JOIN  - ¡No puede ser no comparte el mismo campo!

#3.	Muestra el nombre de los clientes que no hayan realizado pagos junto con el nombre de sus representantes de ventas.
-- Utilizando INNER JOIN
select c.nombre_cliente, e.nombre as nombre_representante, e.apellido1 as apellido_representante
from cliente c
left join pago p on c.codigo_cliente = p.codigo_cliente
join empleado e on c.codigo_empleado_rep_ventas = e.codigo_empleado
where p.codigo_cliente is null;

		-- Utilizando NATURAL JOIN  - ¡No puede ser no comparte el mismo campo!

#4.	Devuelve el nombre de los clientes que han hecho pagos y el nombre de sus representantes junto con la ciudad de la oficina 
#   a la que pertenece el representante.
-- Utilizando INNER JOIN
select c.nombre_cliente, e.nombre as nombre_representante, e.apellido1 as apellido_representante, o.ciudad
from cliente c
join pago p on c.codigo_cliente = p.codigo_cliente
join empleado e on c.codigo_empleado_rep_ventas = e.codigo_empleado
join oficina o on e.codigo_oficina = o.codigo_oficina;

		-- Utilizando NATURAL JOIN  - ¡No puede ser no comparte el mismo campo!

#5.	Devuelve el nombre de los clientes que no hayan hecho pagos y el nombre de sus representantes junto con la ciudad de la oficina 
#  a la que pertenece el representante.
-- Utilizando INNER JOIN
select c.nombre_cliente, e.nombre as nombre_representante, e.apellido1 as apellido_representante, o.ciudad
from cliente c
left join pago p on c.codigo_cliente = p.codigo_cliente
join empleado e on c.codigo_empleado_rep_ventas = e.codigo_empleado
join oficina o on e.codigo_oficina = o.codigo_oficina
where p.codigo_cliente is null;

		-- Utilizando NATURAL JOIN  - ¡No puede ser no comparte el mismo campo!

#6.	Lista la dirección de las oficinas que tengan clientes en Fuenlabrada.
-- Utilizando INNER JOIN
select distinct o.linea_direccion1
from oficina o
join empleado e on o.codigo_oficina = e.codigo_oficina
join cliente c on e.codigo_empleado = c.codigo_empleado_rep_ventas
where c.ciudad = 'Fuenlabrada';

		-- Utilizando NATURAL JOIN  - ¡No puede ser no comparte el mismo campo!

#7.	Devuelve el nombre de los clientes y el nombre de sus representantes junto con la ciudad 
#   de la oficina a la que pertenece el representante.
-- Utilizando INNER JOIN
select c.nombre_cliente, e.nombre as nombre_representante, e.apellido1 as apellido_representante, o.ciudad
from cliente c
join empleado e on c.codigo_empleado_rep_ventas = e.codigo_empleado
join oficina o on e.codigo_oficina = o.codigo_oficina;

		-- Utilizando NATURAL JOIN  - ¡No puede ser no comparte el mismo campo!

#8.	Devuelve un listado con el nombre de los empleados junto con el nombre de sus jefes.
-- Utilizando INNER JOIN
select e1.nombre as empleado, e2.nombre as jefe
from empleado e1
join empleado e2 on e1.codigo_jefe = e2.codigo_empleado;

		-- Utilizando NATURAL JOIN  - ¡No puede ser no comparte el mismo campo!

#9.	Devuelve un listado que muestre el nombre de cada empleados, el nombre de su jefe y el nombre del jefe de sus jefe.
-- Utilizando INNER JOIN
select e1.nombre as empleado, e2.nombre as jefe, e3.nombre as jefe_del_jefe
from empleado e1
join empleado e2 on e1.codigo_jefe = e2.codigo_empleado
join empleado e3 on e2.codigo_jefe = e3.codigo_empleado;

		-- Utilizando NATURAL JOIN  - ¡No puede ser no comparte el mismo campo!

#10.	Devuelve el nombre de los clientes a los que no se les ha entregado a tiempo un pedido.
-- Utilizando INNER JOIN
select c.nombre_cliente
from cliente c
join pedido p on c.codigo_cliente = p.codigo_cliente
where p.fecha_entrega > p.fecha_esperada;

-- Utilizando NATURAL JOIN
select c.nombre_cliente
from cliente c
natural join pedido p 
where p.fecha_entrega > p.fecha_esperada;


#11.	Devuelve un listado de las diferentes gamas de producto que ha comprado cada cliente.
-- Utilizando INNER JOIN
select c.nombre_cliente, GROUP_CONCAT(distinct p.gama order by p.gama) as gamas_compradas
from cliente c
join pedido pe on c.codigo_cliente = pe.codigo_cliente
join detalle_pedido dp on pe.codigo_pedido = dp.codigo_pedido
join producto p on dp.codigo_producto = p.codigo_producto
group by c.nombre_cliente;

-- Utilizando NATURAL JOIN
select nombre_cliente, GROUP_CONCAT(distinct gama order by gama) as gamas_compradas
from cliente
natural join pedido
natural join detalle_pedido
natural join producto
group by nombre_cliente;


-- ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
# Consultas MultiTablas - (Composicion Externa -- Resuelva todas las consultas utilizando las cláusulas LEFT JOIN, RIGHT JOIN, NATURAL LEFT JOIN y NATURAL RIGHT JOIN.) - 
-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

#1.	Devuelve un listado que muestre solamente los clientes que no han realizado ningún pago.
select c.*, p.*
from cliente c
left join pago p on c.codigo_cliente = p.codigo_cliente
where p.codigo_cliente is null;

#2.	Devuelve un listado que muestre solamente los clientes que no han realizado ningún pedido.
select c.*, pe.*
from cliente c
left join pedido pe on c.codigo_cliente = pe.codigo_cliente
where pe.codigo_pedido is null;

#3.	Devuelve un listado que muestre los clientes que no han realizado ningún pago y los que no han realizado ningún pedido.
select c.*, p.*, pe.*
from cliente c
left join pago p on c.codigo_cliente = p.codigo_cliente
left join pedido pe on c.codigo_cliente = pe.codigo_cliente
where p.codigo_cliente is null and pe.codigo_pedido is null;

#4.	Devuelve un listado que muestre solamente los empleados que no tienen una oficina asociada.
select e.*, o.*
from empleado e
right join oficina o on e.codigo_oficina = o.codigo_oficina
where e.codigo_oficina is null;

#5.	Devuelve un listado que muestre solamente los empleados que no tienen un cliente asociado.
select e.*, c.*
from empleado e
left join cliente c on e.codigo_empleado = c.codigo_empleado_rep_ventas
where c.codigo_empleado_rep_ventas is null;


#6.	Devuelve un listado que muestre solamente los empleados que no tienen un cliente asociado junto con los datos de la oficina donde trabajan.
select e.*, c.*, o.*
from empleado e
left join cliente c on e.codigo_empleado = c.codigo_empleado_rep_ventas
left join oficina o on e.codigo_oficina = o.codigo_oficina
where c.codigo_empleado_rep_ventas is null;

#7.	Devuelve un listado que muestre los empleados que no tienen una oficina asociada y los que no tienen un cliente asociado.
select e.*, o.*, c.*
from empleado e
right join oficina o on e.codigo_oficina = o.codigo_oficina
left join cliente c on e.codigo_empleado = c.codigo_empleado_rep_ventas
where e.codigo_oficina is null and c.codigo_empleado_rep_ventas is null;

#8.	Devuelve un listado de los productos que nunca han aparecido en un pedido.
select p.*
from producto p
left join detalle_pedido dp on p.codigo_producto = dp.codigo_producto
where dp.codigo_pedido is null;

#9.	Devuelve un listado de los productos que nunca han aparecido en un pedido. El resultado debe mostrar el nombre, la descripción y la imagen del producto.
select nombre_cliente from cliente left join pago
on cliente.codigo_cliente = pago.codigo_cliente
where cliente.codigo_cliente is null;
SELECT distinct p.nombre, p.descripcion, ga.imagen
FROM producto AS p
LEFT JOIN detalle_pedido AS pe ON pe.codigo_producto = p.codigo_producto
LEFT JOIN gama_producto AS ga ON ga.gama = p.gama
WHERE pe.codigo_producto IS NULL;


-- correir esta mal la 10!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
#10.	Devuelve las oficinas donde no trabajan ninguno de los empleados que hayan sido los representantes de 
#       ventas de algún cliente que haya realizado la compra de algún producto de la gama Frutales.
select o.*
from oficina o
left join empleado e on o.codigo_oficina = e.codigo_oficina
left join cliente c on e.codigo_empleado = c.codigo_empleado_rep_ventas
left join pedido pe on c.codigo_cliente = pe.codigo_cliente
left join detalle_pedido dp on pe.codigo_pedido = dp.codigo_pedido
left join producto p on dp.codigo_producto = p.codigo_producto and p.gama = 'Frutales'
where p.codigo_producto is null;

#11.	Devuelve un listado con los clientes que han realizado algún pedido pero no han realizado ningún pago.
select distinct c.codigo_cliente,c.nombre_cliente
from cliente c
left join pedido pe on c.codigo_cliente = pe.codigo_cliente
left join pago p on c.codigo_cliente = p.codigo_cliente
where pe.codigo_pedido is not null and p.codigo_cliente is null;

#- corregir esta mal la 12!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
#12.	Devuelve un listado con los datos de los empleados que no tienen clientes asociados y el nombre de su jefe asociado.
SELECT e.nombre, e.apellido1, e.apellido2, e.codigo_jefe, ejefe.nombre AS nombre_jefe, ejefe.apellido1 AS apellido_jefe
FROM empleado e
LEFT JOIN empleado ejefe ON e.codigo_jefe = ejefe.codigo_empleado
WHERE e.codigo_empleado NOT IN (SELECT DISTINCT codigo_empleado_rep_ventas FROM cliente WHERE codigo_empleado_rep_ventas IS NOT NULL);


-- ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
# Consultas Resumen.
-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

#1.	¿Cuántos empleados hay en la compañía?
select count(*) as total_empleados
from empleado;

#2.	¿Cuántos clientes tiene cada país?
select pais, count(*) as total_clientes_por_pais
from cliente
group by pais;

#3.	¿Cuál fue el pago medio en 2009?
select avg(total) as pago_medio_2009
from pago
where year(fecha_pago) = 2009;

#4.	¿Cuántos pedidos hay en cada estado? Ordena el resultado de forma descendente por el número de pedidos.
select estado, count(*) as total_pedidos
from pedido
group by estado
order by total_pedidos desc;

#5.	Calcula el precio de venta del producto más caro y más barato en una misma consulta.
select max(precio_venta) as precio_mas_caro, min(precio_venta) as precio_mas_barato
from producto;

#6.	Calcula el número de clientes que tiene la empresa.
select count(*) as total_clientes
from cliente;

#7.	¿Cuántos clientes existen con domicilio en la ciudad de Madrid?
select count(*) as clientes_madrid
from cliente
where ciudad = 'Madrid';

#8.	¿Calcula cuántos clientes tiene cada una de las ciudades que empiezan por M?
select ciudad, count(*) as total_clientes
from cliente
where ciudad like 'M%'
group by ciudad;

#9.	Devuelve el nombre de los representantes de ventas y el número de clientes al que atiende cada uno.
select concat(nombre, ' ', apellido1) as nombre_representante, count(*) as total_clientes
from empleado
join cliente on empleado.codigo_empleado = cliente.codigo_empleado_rep_ventas
group by nombre_representante;

#10.	Calcula el número de clientes que no tiene asignado representante de ventas.
select count(*) as clientes_sin_representante
from cliente
where codigo_empleado_rep_ventas is null;

#11.	Calcula la fecha del primer y último pago realizado por cada uno de los clientes. El listado deberá mostrar el nombre y los apellidos de cada cliente.
select
  ifnull(concat(nombre_cliente), concat(nombre_contacto, ' ', ifnull(apellido_contacto, '')))  'Nombre cliente y/o Nombre-apellidos Contacto',
  min(fecha_pago) as primer_pago,
  max(fecha_pago) as ultimo_pago
from cliente
left join pago on cliente.codigo_cliente = pago.codigo_cliente
group by cliente.codigo_cliente, nombre_cliente,  nombre_contacto, apellido_contacto
limit 0, 50000;


#12.	Calcula el número de productos diferentes que hay en cada uno de los pedidos.
select codigo_pedido, count(distinct codigo_producto) as productos_diferentes
from detalle_pedido
group by codigo_pedido;

#13.	Calcula la suma de la cantidad total de todos los productos que aparecen en cada uno de los pedidos.
select codigo_pedido, sum(cantidad) as suma_cantidad_total
from detalle_pedido
group by codigo_pedido;

#14.	Devuelve un listado de los 20 productos más vendidos y el número total de unidades que se han vendido 
#       de cada uno. El listado deberá estar ordenado por el número total de unidades vendidas.
select p.nombre, sum(dp.cantidad) as total_unidades_vendidas
from producto p
join detalle_pedido dp on p.codigo_producto = dp.codigo_producto
group by p.codigo_producto
order by total_unidades_vendidas desc
limit 20;

#revisar!!! sin join...
#15.	La facturación que ha tenido la empresa en toda la historia, indicando la base imponible, 
#      el IVA y el total facturado. La base imponible se calcula sumando el coste del producto 
#	   por el número de unidades ven‑ didas de la tabla detalle_pedido. El IVA es el 21 % de la base imponible, y el total la suma de los dos campos anteriores.
select
  concat(format(sum(dp.cantidad * p.precio_venta), 2), ' €') as base_imponible,
  concat(format(sum(dp.cantidad * p.precio_venta * 0.21), 2), ' €') as iva,
  concat(format(sum(dp.cantidad * p.precio_venta * 1.21), 2), ' €') as total_facturado
from detalle_pedido dp
join producto p on dp.codigo_producto = p.codigo_producto;


#16.	La misma información que en la pregunta anterior, pero agrupada por código de producto.
select
  p.codigo_producto,
  concat(format(sum(dp.cantidad * p.precio_venta), 2), ' €') as base_imponible,
  concat(format(sum(dp.cantidad * p.precio_venta * 0.21), 2), ' €') as iva,
  concat(format(sum(dp.cantidad * p.precio_venta * 1.21), 2), ' €') as total_facturado
from detalle_pedido dp
join producto p on dp.codigo_producto = p.codigo_producto
group by p.codigo_producto;


#17.	La misma información que en la pregunta anterior, pero agrupada por código de producto filtrada por los códigos que empiecen por OR.
select
  p.codigo_producto,
  concat(format(sum(dp.cantidad * p.precio_venta), 2), ' €') as base_imponible,
  concat(format(sum(dp.cantidad * p.precio_venta * 0.21), 2), ' €') as iva,
  concat(format(sum(dp.cantidad * p.precio_venta * 1.21), 2), ' €') as total_facturado
from detalle_pedido dp
join producto p on dp.codigo_producto = p.codigo_producto
where p.codigo_producto like 'OR%'
group by p.codigo_producto;

 
#18.	Lista las ventas totales de los productos que hayan facturado más de 3000 euros. Se mostrará el nombre, unidades vendidas, total facturado y total facturado con impuestos (21% IVA).
select
  p.nombre,
  sum(dp.cantidad) as unidades_vendidas,
  sum(dp.cantidad * p.precio_venta) as total_facturado,
  sum(dp.cantidad * p.precio_venta * 0.21) as total_iva,
  sum(dp.cantidad * p.precio_venta * 1.21) as total_con_iva
from producto p
join detalle_pedido dp on p.codigo_producto = dp.codigo_producto
group by p.codigo_producto
having total_facturado > 3000;

#19.	Muestre la suma total de todos los pagos que se realizaron para cada uno de los años que aparecen en la tabla pagos.
select
  year(fecha_pago) as anio,
  concat('€', format(sum(total), 2)) as suma_total_pagos
from pago
group by anio;


-- ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
#  		SUBCONSULTAS
-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
#   			||1.4.8.1 Con operadores básicos de comparación||
-- ------------------------------------------------------------------------------------------------------------------------------------------------------
#1.	Devuelve el nombre del cliente con mayor límite de crédito.
select nombre_cliente
from cliente
order by limite_credito desc
limit 1;

#2.	Devuelve el nombre del producto que tenga el precio de venta más caro.
select nombre_producto
from producto
order by precio_venta desc
limit 1;

#3.	Devuelve el nombre del producto del que se han vendido más unidades. 
#   (Tenga en cuenta que tendrá que calcular cuál es el número total de unidades que se han vendido de cada producto a partir de los datos de la tabla detalle_pedido)
select nombre
from producto
order by (select sum(cantidad) from detalle_pedido where detalle_pedido.codigo_producto = producto.codigo_producto) desc
limit 1;

#4.	Los clientes cuyo límite de crédito sea mayor que los pagos que haya realizado. (Sin utilizar INNER JOIN).
select nombre_cliente
from cliente
where limite_credito > (select sum(total) from pago where pago.codigo_cliente = cliente.codigo_cliente);

#5.	Devuelve el producto que más unidades tiene en stock.
select nombre
from producto
order by unidades_en_stock desc
limit 1;

#6.	Devuelve el producto que menos unidades tiene en stock.
select nombre
from producto
order by cantidad_en_stock asc
limit 1;

#7.	Devuelve el nombre, los apellidos y el email de los empleados que están a cargo de Alberto Soria.
select nombre, apellido1, apellido2, email
from empleado
where codigo_jefe = (select codigo_empleado from empleado where nombre = 'Alberto' and apellido1 = 'Soria');

-- ----------------------------------------------------------------------------------------------------------
#  					||1.4.8.2	 Subconsultas con ALL y ANY|| 
-- -------------------------------------------------------------------------------------------------------------
#8.	Devuelve el nombre del cliente con mayor límite de crédito.
select nombre_cliente
from cliente
where limite_credito >= all (select limite_credito from cliente);

#9.	Devuelve el nombre del producto que tenga el precio de venta más caro.
select nombre_producto
from producto
where precio_venta >= all (select precio_venta from producto);

#10.	Devuelve el producto que menos unidades tiene en stock.
select nombre_producto
from producto
where unidades_en_stock <= any (select unidades_en_stock from producto);

-- ---------------------------------------------------------------------------------------------------------------------------------------------------
#  					||1.4.8.3	Subconsultas con IN y NOT IN||
-- ---------------------------------------------------------------------------------------------------------------------------------------------------
#11.	Devuelve el nombre, apellido1 y cargo de los empleados que no representen a ningún cliente.
select nombre, apellido1, puesto as 'Cargo'
from empleado
where codigo_empleado not in (select distinct codigo_empleado_rep_ventas from cliente where codigo_empleado_rep_ventas is not null);

#12.	Devuelve un listado que muestre solamente los clientes que no han realizado ningún pago.
select *
from cliente
where codigo_cliente not in (select distinct codigo_cliente from pago where codigo_cliente is not null);

#13.	Devuelve un listado que muestre solamente los clientes que sí han realizado algún pago.
select *
from cliente
where codigo_cliente in (select distinct codigo_cliente from pago where codigo_cliente is not null);

#14.	Devuelve un listado de los productos que nunca han aparecido en un pedido.
select nombre
from producto
where codigo_producto not in (select distinct codigo_producto from detalle_pedido where codigo_producto is not null);

#15.	Devuelve el nombre, apellidos, puesto y teléfono de la oficina de aquellos empleados que no sean repre‑ sentante de ventas de ningún cliente.
select e.nombre, e.apellido1, e.apellido2, e.puesto, o.telefono
from empleado e
left join cliente c on e.codigo_empleado = c.codigo_empleado_rep_ventas
left join oficina o on e.codigo_oficina = o.codigo_oficina
where c.codigo_empleado_rep_ventas is null;

#16.	Devuelve las oficinas donde no trabajan ninguno de los empleados que hayan sido los representantes
#		de ventas de algún cliente que haya realizado la compra de algún producto de la gama Frutales.
select o.*
from oficina o
left join empleado e on o.codigo_oficina = e.codigo_oficina
left join cliente c on e.codigo_empleado = c.codigo_empleado_rep_ventas
left join pedido p on c.codigo_cliente = p.codigo_cliente
left join detalle_pedido dp on p.codigo_pedido = dp.codigo_pedido
left join producto pr on dp.codigo_producto = pr.codigo_producto
where pr.gama = 'Frutales' and c.codigo_empleado_rep_ventas is not null
LIMIT 0, 50000;


#17.	Devuelve un listado con los clientes que han realizado algún pedido pero no han realizado ningún pago.
 select *
from cliente
where codigo_cliente in (select distinct codigo_cliente from pedido) and codigo_cliente not in (select distinct codigo_cliente from pago);

-- --------------------------------------------------------------------------------------------------------------------------------
#  						||1.4.8.4 Subconsultas con EXISTS y NOT EXISTS||
-- --------------------------------------------------------------------------------------------------------------------------------
#18.	Devuelve un listado que muestre solamente los clientes que no han realizado ningún pago.
select *
from cliente c
where not exists (select 1 from pago p where c.codigo_cliente = p.codigo_cliente);

#19.	Devuelve un listado que muestre solamente los clientes que sí han realizado algún pago.
select *
from cliente c
where exists (select 1 from pago p where c.codigo_cliente = p.codigo_cliente);

#20.	Devuelve un listado de los productos que nunca han aparecido en un pedido.
select *
from producto p
where not exists (select 1 from detalle_pedido dp where p.codigo_producto = dp.codigo_producto);

#21.	Devuelve un listado de los productos que han aparecido en un pedido alguna vez.
select *
from producto p
where exists (select 1 from detalle_pedido dp where p.codigo_producto = dp.codigo_producto);


-- --------------------------------------------------------------------------------------------------------------------------------
#  						||1.1.7	Consultas variadas||
-- --------------------------------------------------------------------------------------------------------------------------------
#1. Devuelve el listado de clientes indicando el nombre del cliente y cuántos pedidos ha realizado.
select c.nombre_cliente, count(p.codigo_pedido) as pedidos_realizados
from cliente c
left join pedido p on c.codigo_cliente = p.codigo_cliente
group by c.nombre_cliente;

#2. Devuelve un listado con los nombres de los clientes y el total pagado por cada uno de ellos.
select c.nombre_cliente, sum(pa.total) as total_pagado
from cliente c
left join pago pa on c.codigo_cliente = pa.codigo_cliente
group by c.nombre_cliente;

#3. Devuelve el nombre de los clientes que hayan hecho pedidos en 2008 ordenados alfabéticamente de menor a mayor.
select distinct c.nombre_cliente
from cliente c
join pedido p on c.codigo_cliente = p.codigo_cliente
where year(p.fecha_pedido) = 2008
order by c.nombre_cliente;

#4. Devuelve el nombre del cliente, el nombre y primer apellido de su representante de ventas y el número de teléfono de la oficina del representante de ventas, de aquellos clientes que no hayan realizado ningún pago.
select c.nombre_cliente, e.nombre, e.apellido1, o.telefono
from cliente c
left join empleado e on c.codigo_empleado_rep_ventas = e.codigo_empleado
left join oficina o on e.codigo_oficina = o.codigo_oficina
where not exists (select 1 from pago pa where c.codigo_cliente = pa.codigo_cliente);

#5. Devuelve el listado de clientes donde aparezca el nombre del cliente, el nombre y primer apellido de su representante de ventas y la ciudad donde está su oficina.
select c.nombre_cliente, e.nombre, e.apellido1, o.ciudad
from cliente c
left join empleado e on c.codigo_empleado_rep_ventas = e.codigo_empleado
left join oficina o on e.codigo_oficina = o.codigo_oficina;

#6. Devuelve el nombre, apellidos, puesto y teléfono de la oficina de aquellos empleados que no sean representante de ventas de ningún cliente.
select e.nombre, e.apellido1, e.apellido2, e.puesto, o.telefono
from empleado e
left join oficina o on e.codigo_oficina = o.codigo_oficina
where e.codigo_empleado not in (select distinct codigo_empleado_rep_ventas from cliente where codigo_empleado_rep_ventas is not null);

#7. Devuelve un listado indicando todas las ciudades donde hay oficinas y el número de empleados que tiene.
select o.ciudad, count(e.codigo_empleado) as numero_empleados
from oficina o
left join empleado e on o.codigo_oficina = e.codigo_oficina
group by o.ciudad;




