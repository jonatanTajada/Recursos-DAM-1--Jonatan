#	Ejercicio que se encuentra dentro del tema de la undiad 8  ---    1.8.5 Manejo de errores en MySQL

CREATE DATABASE IF NOT EXISTS test;
USE test;

CREATE TABLE IF NOT EXISTS alumno (
    id INT UNSIGNED PRIMARY KEY,
    nombre VARCHAR(50),
    apellido1 VARCHAR(50),
    apellido2 VARCHAR(50)
);


DELIMITER //
DROP PROCEDURE IF EXISTS insertar_alumno;
CREATE PROCEDURE insertar_alumno(
    IN p_id INT UNSIGNED,
    IN p_nombre VARCHAR(50),
    IN p_apellido1 VARCHAR(50),
    IN p_apellido2 VARCHAR(50),
    OUT p_error INT
)
BEGIN
    DECLARE duplicate_key CONDITION FOR SQLSTATE '23000';

    DECLARE CONTINUE HANDLER FOR duplicate_key
    BEGIN
        SET p_error = 1;
    END;

    SET p_error = 0;

    INSERT INTO alumno (id, nombre, apellido1, apellido2) VALUES (p_id, p_nombre, p_apellido1, p_apellido2);

END//
DELIMITER ;

CALL insertar_alumno(1, 'Juan', 'Perez', 'Gomez', @error);
SELECT @error;

CALL insertar_alumno(1, "Juan", "Perez", "Gomez", @error);
SELECT @error;

-- -------------------------------------------------------------------------------------------------------------------------------------------------------------------------
