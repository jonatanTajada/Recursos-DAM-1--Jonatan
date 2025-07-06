											# Ejercicio que se encuentra dentro de la ud8.
-- ------------------------------------------------------------------------------------------------------------------------------------------------------------------
					#	1.8.2 Procedimientos con sentencias SQL 
-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------
CREATE DATABASE IF NOT EXISTS gestion_compras;
USE gestion_compras;

CREATE TABLE IF NOT EXISTS cliente (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    pais VARCHAR(50)
);

INSERT INTO cliente (nombre, pais) VALUES
('Juan', 'Argentina'),
('María', 'España'),
('Carlos', 'Argentina'),
('Ana', 'México'),
('Pedro', 'España'),
('Luisa', 'México');

CREATE TABLE IF NOT EXISTS pago (
    id_pago INT AUTO_INCREMENT PRIMARY KEY,
    forma_pago VARCHAR(50),
    valor DECIMAL(10, 2)
);

INSERT INTO pago (forma_pago, valor) VALUES
('PayPal', 100.00),
('Transferencia', 150.50),
('PayPal', 200.75),
('Tarjeta de crédito', 75.20),
('Transferencia', 180.00),
('PayPal', 300.25),
('Tarjeta de crédito', 120.00);

CREATE TABLE IF NOT EXISTS cuadrados (
    numero INT UNSIGNED,
    cuadrado INT UNSIGNED
);

-- -----------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- -----------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- Procedimiento 1: Clientes por país
DELIMITER //
CREATE PROCEDURE ClientesPorPais(IN nombre_pais VARCHAR(50))
BEGIN
    SELECT * FROM cliente WHERE pais = nombre_pais;
END //
DELIMITER ;

-- Procedimiento 2: Pago máximo por forma de pago
DELIMITER //
CREATE PROCEDURE PagoMaximoPorFormaPago(IN forma_pago VARCHAR(50))
BEGIN
    SELECT MAX(valor) AS Pago_Maximo
    FROM pago
    WHERE forma_pago = forma_pago;
END //
DELIMITER ;

-- Procedimiento 3: Estadísticas de pagos por forma de pago
DELIMITER //
CREATE PROCEDURE EstadisticasPagos(IN forma_pago VARCHAR(50))
BEGIN
    DECLARE maximo DECIMAL(10, 2);
    DECLARE minimo DECIMAL(10, 2);
    DECLARE promedio DECIMAL(10, 2);
    DECLARE suma DECIMAL(10, 2);
    DECLARE total_pagos INT;
    
    -- Pago de maximo valor
    SELECT MAX(valor) INTO maximo
    FROM pago
    WHERE forma_pago = forma_pago;
    
    -- Pago de minimo valor
    SELECT MIN(valor) INTO minimo
    FROM pago
    WHERE forma_pago = forma_pago;
    
    -- Valor medio de los pagos
    SELECT AVG(valor) INTO promedio
    FROM pago
    WHERE forma_pago = forma_pago;
    
    -- Suma de todos los pagos
    SELECT SUM(valor) INTO suma
    FROM pago
    WHERE forma_pago = forma_pago;
    
    -- Numero de pagos realizados
    SELECT COUNT(*) INTO total_pagos
    FROM pago
    WHERE forma_pago = forma_pago;
    
    -- Devolver los resultados
    SELECT maximo AS Pago_Maximo, minimo AS Pago_Minimo, promedio AS Valor_Promedio, suma AS Suma_Total, total_pagos AS Numero_de_Pagos;
END //
DELIMITER ;

-- Procedimiento 4: Calcular cuadrados con WHILE
DELIMITER //
CREATE PROCEDURE CalcularCuadradosConWhile(IN tope INT UNSIGNED)
BEGIN
    DECLARE contador INT UNSIGNED DEFAULT 1;
    DECLARE cuadrado INT UNSIGNED;
    
    -- Eliminar contenido actual de la tabla cuadrados
    TRUNCATE TABLE cuadrados;
    
    WHILE contador <= tope DO
        SET cuadrado = contador * contador;
        INSERT INTO cuadrados (numero, cuadrado) VALUES (contador, cuadrado);
        SET contador = contador + 1;
    END WHILE;
END //
DELIMITER ;

-- Procedimiento 5: Calcular cuadrados con REPEAT
DELIMITER //
CREATE PROCEDURE CalcularCuadradosConRepeat(IN tope INT UNSIGNED)
BEGIN
    DECLARE contador INT UNSIGNED DEFAULT 1;
    DECLARE cuadrado INT UNSIGNED;
    
    -- Eliminar contenido actual de la tabla cuadrados
    TRUNCATE TABLE cuadrados;
    
    REPEAT
        SET cuadrado = contador * contador;
        INSERT INTO cuadrados (numero, cuadrado) VALUES (contador, cuadrado);
        SET contador = contador + 1;
    UNTIL contador > tope END REPEAT;
END //
DELIMITER ;

-- Procedimiento 6: Calcular cuadrados con LOOP
DELIMITER //
CREATE PROCEDURE CalcularCuadradosConLoop(IN tope INT UNSIGNED)
BEGIN
    DECLARE contador INT UNSIGNED DEFAULT 1;
    DECLARE cuadrado INT UNSIGNED;
    
    -- Eliminar contenido actual de la tabla cuadrados
    TRUNCATE TABLE cuadrados;
    
    calculando: LOOP
        SET cuadrado = contador * contador;
        INSERT INTO cuadrados (numero, cuadrado) VALUES (contador, cuadrado);
        SET contador = contador + 1;
        IF contador > tope THEN
            LEAVE calculando;
        END IF;
    END LOOP calculando;
END //
DELIMITER ;

-- ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
											# PARA REALIZAR LOS EJERCICIOS ENTRE EL 7 Y 12 CREO OTRA PEQUEÑA BASE DE DATOS
-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------------
CREATE DATABASE IF NOT EXISTS procedimientos;
USE procedimientos;

CREATE TABLE IF NOT EXISTS ejercicio (
    numero INT UNSIGNED
);

CREATE TABLE IF NOT EXISTS pares (
    numero INT UNSIGNED
);

CREATE TABLE IF NOT EXISTS impares (
    numero INT UNSIGNED
);

-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- Procedimiento 7: Calcular números con WHILE
DELIMITER //
CREATE PROCEDURE calcular_numeros_con_while(IN valor_inicial INT UNSIGNED)
BEGIN
    DECLARE contador INT UNSIGNED DEFAULT valor_inicial;
    
    -- Eliminar contenido actual de la tabla "ejercicio"
    TRUNCATE TABLE ejercicio;
    
    WHILE contador >= 1 DO
        INSERT INTO ejercicio (numero) VALUES (contador);
        SET contador = contador - 1;
    END WHILE;
END //
DELIMITER ;


-- Procedimiento 8: Calcular números con REPEAT
DELIMITER //
CREATE PROCEDURE calcular_numeros_con_repeat(IN valor_inicial INT UNSIGNED)
BEGIN
    DECLARE contador INT UNSIGNED DEFAULT valor_inicial;
    
    -- Eliminar contenido actual de la tabla "ejercicio"
    TRUNCATE TABLE ejercicio;
    
    REPEAT
        INSERT INTO ejercicio (numero) VALUES (contador);
        SET contador = contador - 1;
    UNTIL contador < 1 END REPEAT;
END //
DELIMITER ;

-- Procedimiento 9: Calcular números con LOOP
DELIMITER //
CREATE PROCEDURE calcular_numeros_con_loop(IN valor_inicial INT UNSIGNED)
BEGIN
    DECLARE contador INT UNSIGNED DEFAULT valor_inicial;
    
    -- Eliminar contenido actual de la tabla "ejercicio"
    TRUNCATE TABLE ejercicio;
    
    calculando: LOOP
        INSERT INTO ejercicio (numero) VALUES (contador);
        SET contador = contador - 1;
        IF contador < 1 THEN
            LEAVE calculando;
        END IF;
    END LOOP calculando;
END //
DELIMITER ;

-- Procedimiento 10: Calcular pares e impares con WHILE
DELIMITER //
CREATE PROCEDURE calcular_pares_impares_con_while(IN tope INT UNSIGNED)
BEGIN
    DECLARE contador INT UNSIGNED DEFAULT 1;
    DECLARE num_pares INT UNSIGNED;
    DECLARE num_impares INT UNSIGNED;
    
    -- Eliminar contenido actual de las tablas "pares" e "impares"
    TRUNCATE TABLE pares;
    TRUNCATE TABLE impares;
    
    WHILE contador <= tope DO
        IF contador % 2 = 0 THEN
            INSERT INTO pares (numero) VALUES (contador);
        ELSE
            INSERT INTO impares (numero) VALUES (contador);
        END IF;
        SET contador = contador + 1;
    END WHILE;
END //
DELIMITER ;

-- Procedimiento 11: Calcular pares e impares con REPEAT
DELIMITER //
CREATE PROCEDURE calcular_pares_impares_con_repeat(IN tope INT UNSIGNED)
BEGIN
    DECLARE contador INT UNSIGNED DEFAULT 1;
    DECLARE num_pares INT UNSIGNED;
    DECLARE num_impares INT UNSIGNED;
    
    -- Eliminar contenido actual de las tablas "pares" e "impares"
    TRUNCATE TABLE pares;
    TRUNCATE TABLE impares;
    
    REPEAT
        IF contador % 2 = 0 THEN
            INSERT INTO pares (numero) VALUES (contador);
        ELSE
            INSERT INTO impares (numero) VALUES (contador);
        END IF;
        SET contador = contador + 1;
    UNTIL contador > tope END REPEAT;
END //
DELIMITER ;

-- Procedimiento 12: Calcular pares e impares con LOOP
DELIMITER //
CREATE PROCEDURE calcular_pares_impares_con_loop(IN tope INT UNSIGNED)
BEGIN
    DECLARE contador INT UNSIGNED DEFAULT 1;
    DECLARE num_pares INT UNSIGNED;
    DECLARE num_impares INT UNSIGNED;
    
    -- Eliminar contenido actual de las tablas "pares" e "impares"
    TRUNCATE TABLE pares;
    TRUNCATE TABLE impares;
    
    calculando: LOOP
        IF contador % 2 = 0 THEN
            INSERT INTO pares (numero) VALUES (contador);
        ELSE
            INSERT INTO impares (numero) VALUES (contador);
        END IF;
        SET contador = contador + 1;
        IF contador > tope THEN
            LEAVE calculando;
        END IF;
    END LOOP calculando;
END //
DELIMITER //

											# PROBANDO PROCEDIMENTO
											CALL calcular_pares_impares_con_loop(10);
											SELECT * FROM pares;
											SELECT * FROM impares;




