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