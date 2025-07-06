#EJERCICIO 6 - CONSULTAS.


			/******************DML******************************/

#1. Rellenar tabla Cliente:

INSERT INTO Cliente (idCliente, dni,  nombre, apellidos, direccion, poblacion, telefono, email)
VALUES
  ('1', '12345678A', 'Juan', 'Pérez Gracia',  'Calle Aldapa, 3', 'Portugalete' ,'666101185' , 'juan.perez@email.com'),
  ('2', '12345678Q', 'María', 'García García', 'Calle San Juan de Dios, 5', 'Santurce', '666111032', 'maria@email.com'),
  ('3', '13245677Z', 'Carlos', 'López Sanchez', 'Calle Burgos, 12', 'Barakaldo', '678123456', 'carlos@email.com'),
  ('4', '14785236T', 'Juan', 'Pérez Tajada', 'Calle Aragón, 56', 'Bilbao', '623451789', 'juan@email.com'),
  ('5', '11223344E', 'María', 'García Rico', 'Avenida Blas de Otero, 123', 'Portugalete', '647028172', 'maria@email.com'),
  ('6', '87654321V', 'Carlos', 'López Fernández', 'Calle Aldeas Verdes, 156', 'Barakaldo', '647012014', 'carlos@email.com');
  
select * from cliente;

#2. Rellenar la tabla Pizza:

INSERT INTO Pizza (idPizza, nombrePizza, tiempoPreparacion, precio)
VALUES
  ('1', 'Margherita', '00:20:15', 10.99),
  ('2', 'Pepperoni', '00:21:00', 12.99),
  ('3', 'Vegetariana', '00:17:54', 11.99),
  ('4', 'Cuatro quesos', '00:14:41', 10.99),
  ('5', 'Barbacoa', '00:21:58', 12.99),
  ('6', 'Clásica', '00:12:50',  11.99);

select * from pizza;


#3. Rellenar la tabla Factura:

INSERT INTO Factura (idFactura, fechaFactura)
VALUES
  ('1', '2023-01-15'),
  ('2', '2023-02-03'),
  ('3', '2023-03-20');

select * from Factura;


#4. Rellenar la tabla Pedido:

INSERT INTO Pedido (idPedido, fechaHora, idFactura)
VALUES
  ('101', '2023-01-15', '1'),
  ('102', '2023-02-03', '2'),
  ('103', '2023-03-20', '3');

select * from Pedido;


#5. Rellenar la tabla ClienteRealizaPedido:

INSERT INTO ClienteRealizaPedido (idCliente, idPedido)
VALUES
  ('1', '101'),
  ('2', '102'),
  ('3', '103');
  
  select * from clienteRealizaPedido;

#6. Rellenar la tabla PedidoPizza

INSERT INTO PedidoPizza (idPedido, idPizza, unidades)
VALUES
  (101, 1, 2), 
  (102, 2, 3),  
  (103, 3, 1);
  
  select * from pedidopizza;
  

select precio from pizza where precio > 11.00;
select * from pedidopizza where idPedido = '101'; 

update pizza set precio = 9.99 where precio = 10.99; 
select * from pizza;
update cliente set email = 'juan.perez.programador@email.com' where email = 'juan.perez@email.com';
select * from cliente;

insert into Pizza (idPizza, nombrePizza, tiempoPreparacion, precio)
values
		('7', 'Barbacoa con Jamon Ibérico', '00:24:18', 21.99);
delete from pizza where nombrePizza = 'Clásica';
select * from pizza;



/******************DDL******************************/

# Consulta para obtener informacion detallada del Pedido:
SELECT Pedido.idPedido, fechaHora, Cliente.nombre AS nombreCliente, Pizza.nombrePizza, unidades
FROM Pedido
JOIN ClienteRealizaPedido ON Pedido.idPedido = ClienteRealizaPedido.idPedido
JOIN Cliente ON ClienteRealizaPedido.idCliente = Cliente.idCliente
JOIN PedidoPizza ON Pedido.idPedido = PedidoPizza.idPedido
JOIN Pizza ON PedidoPizza.idPizza = Pizza.idPizza;

# Consulta para obtener el total gastado por cada cliente:
SELECT Cliente.idCliente, nombre, SUM(precio * unidades) AS totalGastado
FROM Cliente
JOIN ClienteRealizaPedido ON Cliente.idCliente = ClienteRealizaPedido.idCliente
JOIN Pedido ON ClienteRealizaPedido.idPedido = Pedido.idPedido
JOIN PedidoPizza ON Pedido.idPedido = PedidoPizza.idPedido
JOIN Pizza ON PedidoPizza.idPizza = Pizza.idPizza
GROUP BY Cliente.idCliente, nombre;

# Subconsulta para obtener la cantidad de pedidos de cada cliente:
SELECT idCliente, nombre, (
    SELECT COUNT(idPedido)
    FROM ClienteRealizaPedido
    WHERE Cliente.idCliente = ClienteRealizaPedido.idCliente
) AS cantidadPedidos
FROM Cliente;

# Subconsulta para obtener el cliente que realizó el pedido más reciente:
SELECT idCliente, nombre
FROM Cliente
WHERE idCliente = (
    SELECT idCliente
    FROM ClienteRealizaPedido
    JOIN Pedido ON ClienteRealizaPedido.idPedido = Pedido.idPedido
    ORDER BY fechaHora DESC
    LIMIT 1
);

# Modificar la dirección de un cliente:
UPDATE Cliente
SET direccion = 'Lehendakari Aguirre 234'
WHERE idCliente = 1;

SELECT * FROM CLIENTE;

# Añadir una nueva pizza:
INSERT INTO Pizza (idPizza, nombrePizza, tiempoPreparacion, precio)
VALUES 
		(8, 'Hawaiana', '00:18:30', 13.99);

SELECT * FROM PIZZA;

# Eliminar un pedido y sus relaciones:
DELETE FROM PedidoPizza WHERE idPedido = 101;
DELETE FROM ClienteRealizaPedido WHERE idPedido = 101;
DELETE FROM Pedido WHERE idPedido = 101;

SELECT * FROM pedidopizza;
SELECT * FROM clienterealizapedido;


