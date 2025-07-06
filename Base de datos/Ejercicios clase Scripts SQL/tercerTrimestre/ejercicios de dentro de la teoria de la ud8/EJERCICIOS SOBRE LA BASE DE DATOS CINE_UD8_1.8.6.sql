#	Ejercicio de la unidad 8 ----- 1.8.6 Transacciones con procedimientos almacenados

CREATE DATABASE IF NOT EXISTS cine;
USE cine;

CREATE TABLE IF NOT EXISTS cuentas (
    id_cuenta INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    saldo DECIMAL(10, 2) UNSIGNED
);

CREATE TABLE IF NOT EXISTS entradas (
    id_butaca INT UNSIGNED PRIMARY KEY,
    nif CHAR(9)
);


DELIMITER //
CREATE PROCEDURE comprar_entrada(
    IN p_nif CHAR(9),
    IN p_id_cuenta INT UNSIGNED,
    IN p_id_butaca INT UNSIGNED,
    OUT p_error INT
)
BEGIN
    DECLARE continue_handler_for_sqlerror CONDITION FOR SQLSTATE '45000';
    DECLARE continue_handler_for_duplicate_key CONDITION FOR SQLSTATE '23000';

    DECLARE saldo_suficiente BOOLEAN DEFAULT TRUE;

    DECLARE EXIT HANDLER FOR continue_handler_for_sqlerror
    BEGIN
        SET p_error = 1;
    END;

    DECLARE EXIT HANDLER FOR continue_handler_for_duplicate_key
    BEGIN
        SET p_error = 1;
    END;

    START TRANSACTION;

    UPDATE cuentas SET saldo = saldo - 5 WHERE id_cuenta = p_id_cuenta;

    SELECT saldo INTO saldo_suficiente FROM cuentas WHERE id_cuenta = p_id_cuenta;
    IF saldo_suficiente < 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Saldo insuficiente';
    END IF;

    INSERT INTO entradas (id_butaca, nif) VALUES (p_id_butaca, p_nif);

    IF p_error = 0 THEN
        COMMIT;
    ELSE
        ROLLBACK;
    END IF;

    SET p_error = 0;

END //
DELIMITER ;

# comprobar procedimiento

-- Declarar una variable para almacenar el resultado del procedimiento
SET @error = 0;

CALL comprar_entrada('123456789', 1, 1, @error);

-- Verificar el resultado
SELECT 
    CASE 
        WHEN @error = 0 THEN 'La compra se realizo correctamente'
        ELSE 'Hubo un error en la compra'
    END AS mensaje;

/*
IF @error = 0 THEN
    SELECT 'La compra se realizó correctamente' AS mensaje;
ELSE
    SET @error_msg = (
        SELECT 
            CASE
                WHEN @error = 1 THEN 'Error: Saldo insuficiente'
                WHEN @error = 2 THEN 'Error: Entrada duplicada'
                ELSE 'Error desconocido'
            END
    );
    SELECT @error_msg AS mensaje;
END IF;
*/

-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
											# TEST

#	2. ¿Qué ocurre cuando intentamos comprar una entrada y le pasamos como parámetro un número de
#		cuenta que no existe en la tabla cuentas?

El procedimiento comprar_entrada actualizará el saldo de la cuenta con el id_cuenta proporcionado. Si ese id_cuenta no existe en la tabla cuentas,
la actualización no afectará a ninguna fila. Por lo tanto, el procedimiento se ejecutará sin errores, ya que no lanzará ninguna excepción SQL.

#		¿Ocurre algún error o podemos comprar la entrada?

Cuando intentamos comprar una entrada con un número de cuenta que no existe en la tabla cuentas,
no ocurre ningún error en el procedimiento comprar_entrada. Esto se debe a que la actualización del saldo 
simplemente no afecta a ninguna fila, ya que no existe la cuenta. Por lo tanto, la entrada no se compra efectivamente, pero no hay ningún error lanzado.


#		En caso de que exista algún error, ¿cómo podríamos resolverlo?.

modificar el procedimiento para que primero compruebe si la cuenta existe en la tabla cuentas.
Si la cuenta no existe, podemos lanzar una excepción o establecer un código de error para manejar la situación de manera adecuada.
Esta verificación permite detectar si la cuenta existe o no:

/*
#	Realizar una verificación antes de actualizar el saldo para asegurarnos de que la cuenta existe en la tabla cuentas

CREATE PROCEDURE comprar_entrada(
    IN p_nif CHAR(9),
    IN p_id_cuenta INT UNSIGNED,
    IN p_id_butaca INT UNSIGNED,
    OUT p_error INT
)
BEGIN
    DECLARE continue_handler_for_sqlerror CONDITION FOR SQLSTATE '45000';
    DECLARE continue_handler_for_duplicate_key CONDITION FOR SQLSTATE '23000';
    DECLARE cuenta_existente BOOLEAN DEFAULT FALSE;  -- Variable para verificar si la cuenta existe

    SELECT COUNT(*) INTO cuenta_existente FROM cuentas WHERE id_cuenta = p_id_cuenta;

    IF cuenta_existente = 0 THEN
        SET p_error = 1;  -- Establecer error si la cuenta no existe
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'La cuenta especificada no existe';
        LEAVE comprar_entrada_proc;  -- Salir del procedimiento
    END IF;

    DECLARE EXIT HANDLER FOR continue_handler_for_sqlerror
    BEGIN
        SET p_error = 1;
    END;

    DECLARE EXIT HANDLER FOR continue_handler_for_duplicate_key
    BEGIN
        SET p_error = 1;
    END;

    DECLARE saldo_suficiente BOOLEAN DEFAULT TRUE;

    DECLARE EXIT HANDLER FOR continue_handler_for_sqlerror
    BEGIN
        SET p_error = 1;
    END;

    DECLARE EXIT HANDLER FOR continue_handler_for_duplicate_key
    BEGIN
        SET p_error = 1;
    END;

    START TRANSACTION;

    UPDATE cuentas SET saldo = saldo - 5 WHERE id_cuenta = p_id_cuenta;

    SELECT saldo INTO saldo_suficiente FROM cuentas WHERE id_cuenta = p_id_cuenta;
    IF saldo_suficiente < 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Saldo insuficiente';
    END IF;

    INSERT INTO entradas (id_butaca, nif) VALUES (p_id_butaca, p_nif);

    IF p_error = 0 THEN
        -- Aplicar COMMIT si no hay errores
        COMMIT;
    ELSE
        ROLLBACK;
    END IF;

    SET p_error = 0;

END //
*/