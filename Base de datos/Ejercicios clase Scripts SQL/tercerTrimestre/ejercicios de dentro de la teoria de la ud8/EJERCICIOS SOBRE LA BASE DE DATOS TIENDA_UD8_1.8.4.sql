							# Ejercicio sobre la base de datos Tienda. Ejercicio de la unidad 8
-- ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
#	1.8.4 Funciones con sentencias SQL
-- ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- 1. Escribe una función para la base de datos tienda que devuelva el número total de productos que hay en la tabla productos. 
DELIMITER //
CREATE FUNCTION TotalProductos() RETURNS INT
DETERMINISTIC
NO SQL
BEGIN
    DECLARE total INT;
    SELECT COUNT(*) INTO total FROM producto;
    RETURN total;
END //
DELIMITER ;

-- 2. Escribe una función para la base de datos tienda que devuelva el valor medio del precio de los productos de un determinado fabricante
--    que se recibirá como parámetro de entrada. El parámetro de entrada será el nombre del fabricante. 
DELIMITER //
CREATE FUNCTION ValorMedioPrecioPorFabricante(nombre_fabricante VARCHAR(100)) RETURNS FLOAT
DETERMINISTIC
NO SQL
BEGIN
    DECLARE valor_medio FLOAT;
    SELECT AVG(precio) INTO valor_medio 
    FROM producto 
    WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = nombre_fabricante);
    RETURN valor_medio;
END //
DELIMITER ;
SELECT ValorMedioPrecioPorFabricante("CRUCIAL");
-- 3. Escribe una función para la base de datos tienda que devuelva el valor máximo del precio de los productos de un determinado fabricante que se recibirá 
--    como parámetro de entrada. El parámetro de entrada será el nombre del fabricante. 
DELIMITER //
CREATE FUNCTION ValorMaximoPrecioPorFabricante(nombre_fabricante VARCHAR(100)) RETURNS FLOAT
DETERMINISTIC
NO SQL
BEGIN
    DECLARE valor_maximo FLOAT;
    SELECT MAX(precio) INTO valor_maximo 
    FROM producto 
    WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = nombre_fabricante);
    RETURN valor_maximo;
END //
DELIMITER ;

-- 4. Escribe una función para la base de datos tienda que devuelva el valor mínimo del precio de los productos de un determinado fabricante que se recibirá como 
--    parámetro de entrada. El parámetro de entrada será el nombre del fabricante.
DELIMITER //
CREATE FUNCTION ValorMinimoPrecioPorFabricante(nombre_fabricante VARCHAR(100)) RETURNS FLOAT
DETERMINISTIC
NO SQL
BEGIN
    DECLARE valor_minimo FLOAT;
    SELECT MIN(precio) INTO valor_minimo 
    FROM producto 
    WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = nombre_fabricante);
    RETURN valor_minimo;
END //
DELIMITER ;

