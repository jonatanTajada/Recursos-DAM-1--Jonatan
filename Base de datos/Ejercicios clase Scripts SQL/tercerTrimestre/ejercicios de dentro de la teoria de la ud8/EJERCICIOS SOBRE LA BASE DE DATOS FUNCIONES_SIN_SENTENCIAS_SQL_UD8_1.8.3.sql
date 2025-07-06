						# EJERCICIO DE LA UNIDAD 8 - 1.8.3
-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
CREATE DATABASE IF NOT EXISTS funciones_sin_sentencias_sql;
USE funciones_sin_sentencias_sql;

-- Tabla para almacenar los resultados de las funciones
CREATE TABLE IF NOT EXISTS resultados (
    id INT AUTO_INCREMENT PRIMARY KEY,
    resultado VARCHAR(50)
);
-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
										#	1.8.3 Funciones sin sentencias SQL
-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- Función 1: Determinar si un número es par
DELIMITER //
CREATE FUNCTION EsPar(numero INT) RETURNS BOOLEAN
DETERMINISTIC
NO SQL
BEGIN
    DECLARE es_par BOOLEAN;
    IF numero % 2 = 0 THEN
        SET es_par = TRUE;
    ELSE
        SET es_par = FALSE;
    END IF;
    RETURN es_par;
END //
DELIMITER ;
													-- Llamar a la funcion con diferentes valores
										SELECT EsPar(2) AS Par_2, EsPar(3) AS Par_3, EsPar(10) AS Par_10, EsPar(15) AS Par_15;
SELECT EsPar(20);
-- Función 2: Calcular la hipotenusa de un triángulo
DELIMITER //
CREATE FUNCTION Hipotenusa(a FLOAT, b FLOAT) RETURNS FLOAT
DETERMINISTIC
NO SQL
BEGIN
    DECLARE hipotenusa FLOAT;
    SET hipotenusa = SQRT(a * a + b * b);
    RETURN hipotenusa;
END //
DELIMITER ;

												-- Llamar a la función con diferentes valores de los lados del triángulo
										SELECT Hipotenusa(3, 4) AS Hipotenusa_3_4, Hipotenusa(5, 12) AS Hipotenusa_5_12, Hipotenusa(7, 24) AS Hipotenusa_7_24;

-- Función 3: Obtener el nombre del día de la semana
DELIMITER //
CREATE FUNCTION NombreDiaSemana(dia_semana INT) RETURNS VARCHAR(20)
DETERMINISTIC
NO SQL
BEGIN
    DECLARE nombre_dia VARCHAR(20);
    CASE dia_semana
        WHEN 1 THEN SET nombre_dia = 'Lunes';
        WHEN 2 THEN SET nombre_dia = 'Martes';
        WHEN 3 THEN SET nombre_dia = 'Miércoles';
        WHEN 4 THEN SET nombre_dia = 'Jueves';
        WHEN 5 THEN SET nombre_dia = 'Viernes';
        WHEN 6 THEN SET nombre_dia = 'Sábado';
        WHEN 7 THEN SET nombre_dia = 'Domingo';
        ELSE SET nombre_dia = 'Día no válido';
    END CASE;
    RETURN nombre_dia;
END //
DELIMITER ;

-- Función 4: Obtener el mayor de tres números
DELIMITER //
CREATE FUNCTION MayorDeTres(a FLOAT, b FLOAT, c FLOAT) RETURNS FLOAT
DETERMINISTIC
NO SQL
BEGIN
    DECLARE mayor FLOAT;
    IF a >= b AND a >= c THEN
        SET mayor = a;
    ELSEIF b >= a AND b >= c THEN
        SET mayor = b;
    ELSE
        SET mayor = c;
    END IF;
    RETURN mayor;
END //
DELIMITER ;

-- Función 5: Calcular el área de un círculo
DELIMITER //
CREATE FUNCTION AreaCirculo(radio FLOAT) RETURNS FLOAT
DETERMINISTIC
NO SQL
BEGIN
    DECLARE area FLOAT;
    SET area = PI() * radio * radio;
    RETURN area;
END //
DELIMITER ;
											-- Llamar a la función para calcular el área de un círculo con radio 5
										SELECT AreaCirculo(5) AS Area_Circulo;
        
-- Función 6: Calcular el número de años transcurridos entre dos fechas
DELIMITER //
CREATE FUNCTION AniosTranscurridos(fecha_inicio DATE, fecha_fin DATE) RETURNS INT
DETERMINISTIC
NO SQL
BEGIN
    DECLARE anios INT;
    SET anios = DATEDIFF(fecha_fin, fecha_inicio) / 365;
    RETURN anios;
END //
DELIMITER ;

											-- Llamar a la función para calcular el número de años transcurridos entre dos fechas
										SELECT AniosTranscurridos('2008-01-01', '2018-01-01') AS Anios_Transcurridos;

-- Función 7: Eliminar acentos de una cadena de texto --la profe tiene 2 maneras que me gusta mas

DELIMITER //
CREATE FUNCTION QuitarAcentos(cadena VARCHAR(255)) RETURNS VARCHAR(255)
DETERMINISTIC
NO SQL
BEGIN
    DECLARE cadena_sin_acentos VARCHAR(255);
    SET cadena_sin_acentos = REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(
        REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(
            cadena,
            'á', 'a'), 
            'é', 'e'), 
            'í', 'i'), 
            'ó', 'o'), 
            'ú', 'u'),
            'Á', 'A'), 
            'É', 'E'), 
            'Í', 'I'), 
            'Ó', 'O'), 
            'Ú', 'U');
    RETURN cadena_sin_acentos;
END //
DELIMITER ;


/*
DELIMITER //

CREATE FUNCTION QuitarAcentos(cadena VARCHAR(255)) RETURNS VARCHAR(255)
DETERMINISTIC
NO SQL
BEGIN
    DECLARE cadena_sin_acentos VARCHAR(255);

    SET cadena_sin_acentos = REPLACE(
        REPLACE(
            REPLACE(
                REPLACE(
                    REPLACE(
                        REPLACE(
                            REPLACE(
                                REPLACE(
                                    cadena,
                                    'á', 'a'),
                                'é', 'e'),
                            'í', 'i'),
                        'ó', 'o'),
                    'ú', 'u'),
                'Á', 'A'),
            'É', 'E'),
        'Í', 'I'),
        'Ó', 'O'),
        'Ú', 'U');

    RETURN cadena_sin_acentos;
END //

DELIMITER ;
*/

											-- Llamar a la función para quitar acentos de una cadena de texto
										SELECT QuitarAcentos('María') AS Sin_Acentos;






