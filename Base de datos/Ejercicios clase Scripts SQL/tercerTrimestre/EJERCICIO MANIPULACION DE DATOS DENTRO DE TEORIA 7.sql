				# 7 EJERCICIOS PRACTICOS. DENTRO DE LA TEORIA DEL TEMA 7 - MANIPULACION DE DATOS

#	7.1	Tienda de informática

-- 1. Insertar un nuevo fabricante indicando su código y su nombre.
INSERT INTO fabricante (codigo, nombre) VALUES (10, 'Nuevo fabricante 1');

-- 2. Insertar un nuevo fabricante indicando solamente su nombre.
INSERT INTO fabricante (codigo, nombre) VALUES (12, 'Nuevo fabricante 2');

-- 3. Insertar un nuevo producto asociado a uno de los nuevos fabricantes.
INSERT INTO producto (codigo, nombre, precio, codigo_fabricante) VALUES (13, 'Nuevo producto 1', 99.99, 10);

-- 4. Insertar un nuevo producto asociado a uno de los nuevos fabricantes.
INSERT INTO producto (codigo, nombre, precio, codigo_fabricante) VALUES (20, 'Nuevo producto 2', 149.99, 11);

-- 5. Crear una nueva tabla con el nombre fabricante_productos.
CREATE TABLE fabricante_productos AS
SELECT f.nombre AS nombre_fabricante, p.nombre AS nombre_producto, p.precio
FROM fabricante f
JOIN producto p ON f.codigo = p.codigo_fabricante;

-- 6. Crear una vista con el nombre vista_fabricante_productos.
CREATE VIEW vista_fabricante_productos AS
SELECT f.nombre AS nombre_fabricante, p.nombre AS nombre_producto, p.precio
FROM fabricante f
JOIN producto p ON f.codigo = p.codigo_fabricante;

-- 7. Eliminar el fabricante Asus.
-- No es posible eliminarlo porque hay productos asociados a él.
-- Para poder borrarlo, primero debemos eliminar los productos asociados a Asus.
	-- Desactivamos las restricciones de clave externa
SET FOREIGN_KEY_CHECKS = 0;
DELETE FROM fabricante WHERE nombre = 'Asus';

	-- Activamos nuevamente las restricciones de clave externa
SET FOREIGN_KEY_CHECKS = 1;

-- 8. Eliminar el fabricante Xiaomi.
-- No es posible eliminarlo porque hay productos asociados a él.
-- Para poder borrarlo, primero debemos eliminar los productos asociados a Xiaomi.

	-- Desactivamos las restricciones de clave externa
SET FOREIGN_KEY_CHECKS = 0;
DELETE FROM fabricante WHERE nombre = 'Xiaomi';

	-- Activamos nuevamente las restricciones de clave externa
SET FOREIGN_KEY_CHECKS = 1;

-- 9. Actualizar el código del fabricante Lenovo y asignarle el valor 20.
-- Es posible actualizarlo siempre que no exista ya un fabricante con código 20.
SET FOREIGN_KEY_CHECKS = 0;
UPDATE fabricante SET codigo = 20 WHERE nombre = 'Lenovo';
SET FOREIGN_KEY_CHECKS = 1;

-- 10. Actualizar el código del fabricante Huawei y asignarle el valor 30.
-- Es posible actualizarlo siempre que no exista ya un fabricante con código 30.
UPDATE fabricante SET codigo = 30 WHERE nombre = 'Huawei';

-- 11. Actualizar el precio de todos los productos sumándole 5 € al precio actual.
UPDATE producto SET precio = precio + 5;

-- 12. Eliminar todas las impresoras que tienen un precio menor de 200 €.
DELETE FROM producto WHERE nombre LIKE '%Impresora%' AND precio < 200;


-- -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
#	7.2	Empleados

			#	Realice las siguientes operaciones sobre la base de datos empleados.

#	1.	Inserta un nuevo departamento indicando su código, nombre y presupuesto.
INSERT INTO departamento (id, nombre, presupuesto, gastos) VALUES (8, 'Ventas', 200000, 0);

#	2.	Inserta un nuevo departamento indicando su nombre y presupuesto.
INSERT INTO departamento (nombre, presupuesto, gastos) VALUES ('Marketing', 150000, 0);

#	3.	Inserta un nuevo departamento indicando su código, nombre, presupuesto y gastos.
INSERT INTO departamento (id, nombre, presupuesto, gastos) VALUES (9, 'Logística', 180000, 25000);

#	4.	Inserta un nuevo empleado asociado a uno de los nuevos departamentos. La sentencia de inserción debe incluir: código, nif, nombre, apellido1, apellido2 y codigo_departamento.
INSERT INTO empleado (id, nif, nombre, apellido1, apellido2, id_departamento) VALUES (14, '87654321X', 'Laura', 'García', 'Pérez', 8);

#	5.	Inserta un nuevo empleado asociado a uno de los nuevos departamentos. La sentencia de inserción debe incluir: nif, nombre, apellido1, apellido2 y codigo_departamento.
INSERT INTO empleado (nif, nombre, apellido1, apellido2, id_departamento) VALUES ('12345678A', 'David', 'Martínez', 'López', 9);

#	6.	Crea una nueva tabla con el nombre departamento_backup que tenga las mismas columnas que la tabla departamento. Una vez creada copia todas las filas de tabla 
#		departamento en departamento_backup.
CREATE TABLE departamento_backup LIKE departamento;
INSERT INTO departamento_backup SELECT * FROM departamento;

#	7.	Elimina el departamento Proyectos. ¿Es posible eliminarlo? Si no fuese posible, ¿qué cambios debería realizar para que fuese posible borrarlo?
DELETE FROM departamento WHERE nombre = 'Proyectos';
		#		No es posible eliminar el departamento "Proyectos" si hay registros de la tabla empleado asociados a él. Para que sea posible eliminarlo, primero debes eliminar todos los empleados asociados a ese departamento o actualizar su campo id_departamento a NULL.

#	8.	Elimina el departamento Desarrollo. ¿Es posible eliminarlo? Si no fuese posible, ¿qué cambios debe‑ ría realizar para que fuese posible borrarlo?
DELETE FROM empleado WHERE id_departamento = (SELECT id FROM departamento WHERE nombre = 'Desarrollo');
DELETE FROM departamento WHERE nombre = 'Desarrollo';

	-- No es posible eliminar el departamento "Desarrollo" si hay registros de la tabla empleado asociados a él. 
    -- Para que sea posible eliminarlo, primero debes eliminar todos los empleados asociados a ese departamento o actualizar su campo id_departamento a NULL.
    
#	9.	Actualiza el código del departamento Recursos Humanos y asígnale el valor 30. ¿Es posible actualizarlo? Si no fuese posible,
	-- ¿qué cambios debería realizar para que fuese actualizarlo?
DELETE FROM empleado WHERE id_departamento = (SELECT id FROM departamento WHERE nombre = 'Recursos Humanos');
UPDATE departamento SET id = 30 WHERE nombre = 'Recursos Humanos';

	-- Si es posible actualizarlo, siempre y cuabndo no exista otro departamento con mismo codigo, porque si existiera
    -- otro departamento con el codigo 30, habria un conflicto de llaves primaria y no se podria actualizarlo.
    
-- -----------------------	SIGUE SIENDO LA EJERCICIO 9, OTRA OPCION     --------------------------------------------    
    
#	Para hacer posible esta actualización, se pueden tomar las siguientes acciones:

#	Eliminar los registros asociados en la tabla empleado antes de actualizar el código del departamento:
#	Esto implica eliminar los empleados que están asociados al departamento "Recursos Humanos" antes de realizar la actualización.
#	Por ejemplo:

DELETE FROM empleado WHERE id_departamento = (SELECT id FROM departamento WHERE nombre = 'Recursos Humanos');
UPDATE departamento SET id = 30 WHERE nombre = 'Recursos Humanos';

#	Cambiar la configuración de la restricción de clave externa para permitir la actualización en cascada:
#	Esto implica cambiar la configuración de la restricción de clave externa para que, al actualizar el código del departamento, también se actualicen automáticamente los registros asociados en la tabla empleado.
#	Por ejemplo:

ALTER TABLE empleado DROP FOREIGN KEY empleado_ibfk_1; -- Elimina la restricción de clave externa existente
ALTER TABLE empleado ADD CONSTRAINT empleado_ibfk_1 FOREIGN KEY (id_departamento) REFERENCES departamento (id) ON UPDATE CASCADE; -- Agrega una nueva restricción de clave externa con la opción ON UPDATE CASCADE

UPDATE departamento SET id = 30 WHERE nombre = 'Recursos Humanos'; -- Actualiza el código del departamento "Recursos Humanos"
		#	El segundo enfoque es más directo y permite que los registros asociados en la tabla empleado se actualicen automáticamente cuando cambie el código del departamento.


#	10.	Actualiza el código del departamento Publicidad y asígnale el valor 40. ¿Es posible actualizarlo? Si no fuese posible, ¿qué cambios debería realizar para que fuese actualizarlo?
	-- 	Es posible actualizar el código del departamento siempre y cuando no exista otro departamento con el mismo código.
UPDATE departamento SET id = 40 WHERE nombre = 'Publicidad';

#	11.	Actualiza el presupuesto de los departamentos sumándole 50000 € al valor del presupuesto actual, 
#		solamente a aquellos departamentos que tienen un presupuesto menor que 20000 €.
UPDATE departamento SET presupuesto = presupuesto + 50000 WHERE presupuesto < 20000;

#	12.	Realiza una transacción que elimine todos los empleados que no tienen un departamento asociado.
START TRANSACTION;
DELETE FROM empleado WHERE id_departamento IS NULL;
COMMIT;


-- -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
#	7.3	Jardinería

-- Operaciones sobre la base de datos jardineria:

-- 1. Inserta una nueva oficina en Almería.
insert into oficina values ('ALM001', 'Almería', 'España', null, '04001', '+34 950123456', 'Calle Principal 123', null);

-- 2. Inserta un empleado para la oficina de Almería que sea representante de ventas.
insert into empleado values (1001, 'Juan', 'Gómez', null, '123', 'juan@example.com', 'ALM001', null, 'Representante de Ventas');

-- 3. Inserta un cliente que tenga como representante de ventas el empleado que hemos creado en el paso anterior.
insert into cliente values (1, 'Cliente Ejemplo', null, null, '+34 123456789', '+34 123456789', 'Calle Cliente 1', null, 'Almería', null, 'España', '04002', 1001, 1000.00);

-- 4. Inserte un pedido para el cliente que acabamos de crear, que contenga al menos dos productos diferentes.
insert into pedido (codigo_pedido, fecha_pedido, fecha_esperada, estado, codigo_cliente) 
																values (1, '2024-04-21', '2024-04-28', 'En proceso', 1);
insert into detalle_pedido values (1, 'PROD001', 5, 10.00, 1);
insert into detalle_pedido values (1, 'PROD002', 3, 15.00, 2);

-- 5. Actualiza el código del cliente que hemos creado en el paso anterior y averigua si hubo cambios en las tablas relacionadas.
update cliente set codigo_cliente = 100 where codigo_cliente = 1;
select * from cliente;
select * from pedido;

-- 6. Borra el cliente y averigua si hubo cambios en las tablas relacionadas.
delete from cliente where codigo_cliente = 100;
select * from cliente;
select * from pedido;

-- 7. Elimina los clientes que no hayan realizado ningún pedido.
delete from cliente where codigo_cliente not in (select distinct codigo_cliente from pedido);

-- 8. Incrementa en un 20% el precio de los productos que no tengan pedidos.
update producto set precio_venta = precio_venta * 1.2
where codigo_producto not in (select distinct codigo_producto from detalle_pedido);

-- 9. Borra los pagos del cliente con menor límite de crédito.
delete from pago 
where codigo_cliente = (select codigo_cliente from cliente order by limite_credito asc limit 1);

-- 10. Establece a 0 el límite de crédito del cliente que menos unidades pedidas tenga del producto 11679.
update cliente set limite_credito = 0 
where codigo_cliente = (select codigo_cliente 
from (select p.codigo_cliente, sum(d.cantidad) as total_unidades 
from detalle_pedido d join pedido p on d.codigo_pedido = p.codigo_pedido 
join producto pr on d.codigo_producto = pr.codigo_producto 
where pr.codigo_producto = '11679' group by p.codigo_cliente order by total_unidades asc limit 1) as temp);

-- 11. Modifica la tabla detalle_pedido para insertar un campo numérico llamado iva.
--     Mediante una transacción, establece el valor de ese campo a 18 para aquellos registros cuyo pedido tenga 
--     fecha a partir de Enero de 2009. A continuación actualiza el resto de pedidos estableciendo el iva al 21.
-- esta si entra en examen!! transacciones
alter table detalle_pedido add column iva numeric(5,2);
start transaction;
update detalle_pedido d 
join pedido p on d.codigo_pedido = p.codigo_pedido set d.iva = 18 
where p.fecha_pedido >= '2009-01-01';
update detalle_pedido set iva = 21 where iva is null;
commit;

-- 12. Modifica la tabla detalle_pedido para incorporar un campo numérico llamado total_linea y 
--     actualiza todos sus registros para calcular su valor con la fórmula:
alter table detalle_pedido add column total_linea numeric(15,2);
update detalle_pedido set total_linea = cantidad * precio_unidad;

-- 13. Borra el cliente que menor límite de crédito tenga. ¿Es posible borrarlo solo con una consulta? ¿Por qué?
-- No es posible borrarlo solo con una consulta debido a que la cláusula ORDER BY no es válida en subconsultas con DELETE.
delete from cliente where codigo_cliente = (select codigo_cliente from (select codigo_cliente, limite_credito from cliente order by limite_credito asc limit 1) as temp);

-- 14. Inserta una oficina con sede en Granada y tres empleados que sean representantes de ventas.
insert into oficina values ('GRN001', 'Granada', 'España', null, '18001', '+34 958123456', 'Avenida Principal 456', null);
insert into empleado values (1002, 'María', 'López', null, '124', 'maria@example.com', 'GRN001', null, 'Representante de Ventas');
insert into empleado values (1003, 'Carlos', 'Martínez', null, '125', 'carlos@example.com', 'GRN001', null, 'Representante de Ventas');
insert into empleado values (1004, 'Ana', 'Sánchez', null, '126', 'ana@example.com', 'GRN001', null, 'Representante de Ventas');

-- 15. Inserta tres clientes que tengan como representantes de ventas los empleados que hemos creado en el paso anterior.
insert into cliente values (2, 'Cliente Granada 1', null, null, '+34 987654321', '+34 987654321', 'Calle Granada 1', null, 'Granada', null, 'España', '18002', 1002, 1500.00);
insert into cliente values (3, 'Cliente Granada 2', null, null, '+34 987654322', '+34 987654322', 'Calle Granada 2', null, 'Granada', null, 'España', '18003', 1003, 2000.00);
insert into cliente values (4, 'Cliente Granada 3', null, null, '+34 987654323', '+34 987654323', 'Calle Granada 3', null, 'Granada', null, 'España', '18004', 1004, 2500.00);

-- 16. Realiza una transacción que inserte un pedido para cada uno de los clientes. Cada pedido debe incluir dos productos.
start transaction;
insert into pedido (codigo_pedido, fecha_pedido, fecha_esperada, estado, codigo_cliente) values (2, '2024-04-21', '2024-04-28', 'En proceso', 2);
insert into detalle_pedido values (2, 'PROD003', 10, 20.00, 1);
insert into detalle_pedido values (2, 'PROD004', 5, 25.00, 2);

insert into pedido (codigo_pedido, fecha_pedido, fecha_esperada, estado, codigo_cliente) values (3, '2024-04-21', '2024-04-28', 'En proceso', 3);
insert into detalle_pedido values (3, 'PROD005', 8, 30.00, 1);
insert into detalle_pedido values (3, 'PROD006', 6, 35.00, 2);

insert into pedido (codigo_pedido, fecha_pedido, fecha_esperada, estado, codigo_cliente) values (4, '2024-04-21', '2024-04-28', 'En proceso', 4);
insert into detalle_pedido values (4, 'PROD007', 12, 40.00, 1);
insert into detalle_pedido values (4, 'PROD008', 4, 45.00, 2);
commit;

-- 17. Borra uno de los clientes y comprueba si hubo cambios en las tablas relacionadas. Si no hubo cambios, modifica las tablas necesarias estableciendo la clave foránea con la cláusula ON DELETE CASCADE.
delete from cliente where codigo_cliente = 4;
select * from cliente;
select * from pedido;

-- 18. Realiza una transacción que realice los pagos de los pedidos que han realizado los clientes del ejercicio anterior.
start transaction;
insert into pago values (2, 'Tarjeta de Crédito', 'TRANS001', '2024-04-21', 450.00);
insert into pago values (3, 'Transferencia Bancaria', 'TRANS002', '2024-04-21', 590.00);
commit;

-- -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------





 