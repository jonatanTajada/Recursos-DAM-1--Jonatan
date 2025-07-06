# Ejercicios de la Unidad 8. La base de datos me la invento para poder realizar los ejercicios.

CREATE DATABASE IF NOT EXISTS EjemploEstudiantes;
USE EjemploEstudiantes;

CREATE TABLE IF NOT EXISTS estudiantes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    calificacion FLOAT
);

INSERT INTO estudiantes (nombre, calificacion) VALUES
('Carlos', 8.7),
('Luisa', 7.2),
('Ana', 5.9),
('Pedro', 4.5),
('María', 9.8);

-- -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
														#	1.8 Ejercicios 
-- ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
#	1.8.1 Procedimientos sin sentencias SQL

#	-- Procedimiento 1: ¡Hola mundo!
DELIMITER //
CREATE PROCEDURE Saludar()
BEGIN
    SELECT '¡Hola mundo!' AS Mensaje;
END //
DELIMITER ;

#	-- Procedimiento 2: Clasificar número
DELIMITER //
CREATE PROCEDURE ClasificarNumero(IN numero FLOAT)
BEGIN
    IF numero > 0 THEN
        SELECT 'El número es positivo';
    ELSEIF numero < 0 THEN
        SELECT 'El número es negativo';
    ELSE
        SELECT 'El número es cero';
    END IF;
END //
DELIMITER ;

#	-- Procedimiento 3: Clasificar número con parámetro de salida
DELIMITER //
CREATE PROCEDURE ClasificarNumeroConSalida(IN numero FLOAT, OUT resultado TEXT)
BEGIN
    IF numero > 0 THEN
        SET resultado = 'El número es positivo';
    ELSEIF numero < 0 THEN
        SET resultado = 'El número es negativo';
    ELSE
        SET resultado = 'El número es cero';
    END IF;
END //
DELIMITER 
#CALL ClasificarNumeroConSalida(10);
#SELECT @NUMERO;


#	-- Procedimiento 4: Clasificar calificación
DELIMITER //
CREATE PROCEDURE ClasificarCalificacion(IN id_estudiante INT)
BEGIN
    DECLARE nota_estudiante FLOAT;
    
    -- ObteneR la calificaciOn del estudiante
    SELECT calificacion INTO nota_estudiante FROM estudiantes WHERE id = id_estudiante;
    
    CASE 
        WHEN nota_estudiante >= 0 AND nota_estudiante < 5 THEN
            SELECT 'Insuficiente';
        WHEN nota_estudiante >= 5 AND nota_estudiante < 6 THEN
            SELECT 'Aprobado';
        WHEN nota_estudiante >= 6 AND nota_estudiante < 7 THEN
            SELECT 'Bien';
        WHEN nota_estudiante >= 7 AND nota_estudiante < 9 THEN
            SELECT 'Notable';
        WHEN nota_estudiante >= 9 AND nota_estudiante <= 10 THEN
            SELECT 'Sobresaliente';
        ELSE
            SELECT 'Nota no válida';
    END CASE;
END //
DELIMITER ;

#	-- Procedimiento 5: Clasificar calificación con parámetro de salida
DELIMITER //
CREATE PROCEDURE ClasificarCalificacionConSalida(IN id_estudiante INT, OUT resultado VARCHAR(20))
BEGIN
    DECLARE nota_estudiante FLOAT;
    
    -- Obtener la calificacion del estudiante
    SELECT calificacion INTO nota_estudiante FROM estudiantes WHERE id = id_estudiante;
    
    CASE 
        WHEN nota_estudiante >= 0 AND nota_estudiante < 5 THEN
            SET resultado = 'Insuficiente';
        WHEN nota_estudiante >= 5 AND nota_estudiante < 6 THEN
            SET resultado = 'Aprobado';
        WHEN nota_estudiante >= 6 AND nota_estudiante < 7 THEN
            SET resultado = 'Bien';
        WHEN nota_estudiante >= 7 AND nota_estudiante < 9 THEN
            SET resultado = 'Notable';
        WHEN nota_estudiante >= 9 AND nota_estudiante <= 10 THEN
            SET resultado = 'Sobresaliente';
        ELSE
            SET resultado = 'Nota no válida';
    END CASE;
END //
DELIMITER ;

#	-- Procedimiento 6: Clasificar calificación con CASE
DELIMITER //
CREATE PROCEDURE ClasificarCalificacionConCase(IN id_estudiante INT)
BEGIN
    DECLARE nota_estudiante FLOAT;
    
    -- Obtenemos la calificación del estudiante
    SELECT calificacion INTO nota_estudiante FROM estudiantes WHERE id = id_estudiante;
    
    -- Clasificamos la calificación
    SELECT CASE 
        WHEN nota_estudiante >= 0 AND nota_estudiante < 5 THEN 'Insuficiente'
        WHEN nota_estudiante >= 5 AND nota_estudiante < 6 THEN 'Aprobado'
        WHEN nota_estudiante >= 6 AND nota_estudiante < 7 THEN 'Bien'
        WHEN nota_estudiante >= 7 AND nota_estudiante < 9 THEN 'Notable'
        WHEN nota_estudiante >= 9 AND nota_estudiante <= 10 THEN 'Sobresaliente'
        ELSE 'Nota no válida'
    END AS resultado;
END //
DELIMITER ;

#	-- Procedimiento 7: Nombre del día de la semana con IF
DELIMITER //
CREATE PROCEDURE NombreDiaSemana_IF(IN dia_semana INT)
BEGIN
    DECLARE nombre_dia VARCHAR(20);
    
    IF dia_semana = 1 THEN
        SET nombre_dia = 'lunes';
    ELSEIF dia_semana = 2 THEN
        SET nombre_dia = 'martes';
    ELSEIF dia_semana = 3 THEN
        SET nombre_dia = 'miércoles';
    ELSEIF dia_semana = 4 THEN
        SET nombre_dia = 'jueves';
    ELSEIF dia_semana = 5 THEN
        SET nombre_dia = 'viernes';
    ELSEIF dia_semana = 6 THEN
        SET nombre_dia = 'sábado';
    ELSEIF dia_semana = 7 THEN
        SET nombre_dia = 'domingo';
    ELSE
        SET nombre_dia = 'Valor no válido';
    END IF;
    
    SELECT nombre_dia AS Dia_de_la_Semana;
END //
DELIMITER ;

#	-- Procedimiento 8: Nombre del día de la semana con CASE
DELIMITER //
CREATE PROCEDURE NombreDiaSemana_CASE(IN dia_semana INT)
BEGIN
    DECLARE nombre_dia VARCHAR(20);
    
    CASE dia_semana
        WHEN 1 THEN SET nombre_dia = 'lunes';
        WHEN 2 THEN SET nombre_dia = 'martes';
        WHEN 3 THEN SET nombre_dia = 'miércoles';
        WHEN 4 THEN SET nombre_dia = 'jueves';
        WHEN 5 THEN SET nombre_dia = 'viernes';
        WHEN 6 THEN SET nombre_dia = 'sábado';
        WHEN 7 THEN SET nombre_dia = 'domingo';
        ELSE SET nombre_dia = 'Valor no válido';
    END CASE;
    
    SELECT nombre_dia AS Dia_de_la_Semana;
END //
DELIMITER ;

-- -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------






