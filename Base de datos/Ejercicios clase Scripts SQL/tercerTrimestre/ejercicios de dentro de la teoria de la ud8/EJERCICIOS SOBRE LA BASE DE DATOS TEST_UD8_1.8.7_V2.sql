#	Ejercicio de dentro de la unidad 8 ------    1.8.7 Cursores

CORREGIR CON LA OTRA QUE TENGO
-- Crear la base de datos si no existe y usarla
CREATE DATABASE IF NOT EXISTS test;
USE test;

-- Crear la tabla de alumnos
CREATE TABLE IF NOT EXISTS alumnos (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido1 VARCHAR(50),
    apellido2 VARCHAR(50),
    fecha_nacimiento DATE,
    edad INT, -- Añadir la columna edad
    email VARCHAR(100) -- Añadir la columna email
);

-- Insertar datos de ejemplo en la tabla de alumnos
INSERT INTO alumnos (nombre, apellido1, apellido2, fecha_nacimiento)
VALUES
    ('Juan', 'García', 'López', '1995-05-15'),
    ('María', 'Martínez', 'Rodríguez', '1998-08-20'),
    ('Pedro', 'Sánchez', 'Gómez', '2000-03-10'),
    ('Ana', 'López', 'Fernández', '1997-11-25');

-- Función para calcular la edad
DELIMITER //
CREATE FUNCTION calcular_edad(fecha DATE)
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE edad INT;
    SET edad = TIMESTAMPDIFF(YEAR, fecha, CURDATE());
    RETURN TRUNCATE(edad, 0);
END //
DELIMITER ;

/*
DELIMITER //
CREATE FUNCTION calcular_edad(fecha DATE)
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE edad INT;
    SET edad = YEAR(CURDATE()) - YEAR(fecha);
    IF (MONTH(CURDATE()) < MONTH(fecha)) OR (MONTH(CURDATE()) = MONTH(fecha) AND DAY(CURDATE()) < DAY(fecha)) THEN
        SET edad = edad - 1;
    END IF;
    RETURN edad;
END //
DELIMITER ;
*/
-- Procedimiento para actualizar la columna de edad de los alumnos
DELIMITER //
CREATE PROCEDURE actualizar_columna_edad()
BEGIN
    DECLARE completado INT DEFAULT FALSE;
    DECLARE id_alumno INT UNSIGNED;
    DECLARE fecha_nacimiento_alumno DATE;
    
    DECLARE cur CURSOR FOR SELECT id, fecha_nacimiento FROM alumnos;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET completado = TRUE;

    OPEN cur;
    bucle_leer: LOOP
        FETCH cur INTO id_alumno, fecha_nacimiento_alumno;
        IF completado THEN
            LEAVE bucle_leer;
        END IF;
        
        -- Actualizar la edad
        UPDATE alumnos SET edad = calcular_edad(fecha_nacimiento_alumno) WHERE id = id_alumno;
    END LOOP;
    CLOSE cur;
END //
DELIMITER ;

-- Procedimiento para crear el email de un alumno
DELIMITER //
CREATE PROCEDURE crear_email(
    IN p_nombre VARCHAR(50),
    IN p_apellido1 VARCHAR(50),
    IN p_apellido2 VARCHAR(50),
    IN p_dominio VARCHAR(100),
    OUT p_email VARCHAR(150)
)
BEGIN
    SET p_email = CONCAT(LEFT(p_nombre, 1), LEFT(p_apellido1, 3), LEFT(p_apellido2, 3), '@', p_dominio);
END //
DELIMITER ;

-- Procedimiento para actualizar la columna de email de los alumnos
DELIMITER //
CREATE PROCEDURE actualizar_columna_email()
BEGIN
    DECLARE completado INT DEFAULT FALSE;
    DECLARE id_alumno INT UNSIGNED;
    DECLARE nombre_alumno, apellido1_alumno, apellido2_alumno, dominio VARCHAR(100);
    DECLARE email_generado VARCHAR(150);
    
    DECLARE cur CURSOR FOR SELECT id, nombre, apellido1, apellido2 FROM alumnos;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET completado = TRUE;

    OPEN cur;
    bucle_leer: LOOP
        FETCH cur INTO id_alumno, nombre_alumno, apellido1_alumno, apellido2_alumno;
        IF completado THEN
            LEAVE bucle_leer;
        END IF;
        
        -- Generar el email
        SET dominio = 'miuniversidad.edu'; -- Cambiar por tu dominio
        CALL crear_email(nombre_alumno, apellido1_alumno, apellido2_alumno, dominio, email_generado);
        
        -- Actualizar la columna email
        UPDATE alumnos SET email = email_generado WHERE id = id_alumno;
    END LOOP;
    CLOSE cur;
END //
DELIMITER ;

-- Procedimiento para crear la lista de emails de los alumnos
DELIMITER //
CREATE PROCEDURE crear_lista_emails_alumnos()
BEGIN
    DECLARE lista_emails TEXT DEFAULT '';
    DECLARE email_alumno VARCHAR(100);
    DECLARE done INT DEFAULT FALSE;
    
    DECLARE cur CURSOR FOR SELECT email FROM alumnos;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN cur;
    bucle_leer: LOOP
        FETCH cur INTO email_alumno;
        IF done THEN
            LEAVE bucle_leer;
        END IF;
        
        IF lista_emails = '' THEN
            SET lista_emails = email_alumno;
        ELSE
            SET lista_emails = CONCAT(lista_emails, ';', email_alumno);
        END IF;
    END LOOP;
    CLOSE cur;
    
    SELECT lista_emails AS lista_emails_alumnos;
END //
DELIMITER ;

-- Llamar a los procedimientos para actualizar la edad y los emails de los alumnos
CALL actualizar_columna_edad();
CALL actualizar_columna_email();

-- Verificar la lista de emails de los alumnos
CALL crear_lista_emails_alumnos();



/*
Este script de MySQL crea una base de datos llamada "test", junto con una tabla llamada "alumnos". Luego, inserta algunos datos de ejemplo en la tabla de alumnos.

Después, define una función llamada "calcular_edad" que calcula la edad de una persona basada en su fecha de nacimiento. También define un procedimiento llamado 
"actualizar_columna_edad", que actualiza la columna de edad de todos los alumnos en la tabla utilizando la función "calcular_edad".

Además, hay un procedimiento llamado "crear_email" que genera una dirección de correo electrónico para un alumno basada en su nombre y apellidos.
 El procedimiento "actualizar_columna_email" actualiza la columna de email de todos los alumnos en la tabla utilizando este procedimiento.

Finalmente, hay un procedimiento llamado "crear_lista_emails_alumnos" que crea una lista de todos los correos electrónicos de los alumnos y la muestra como resultado.

El script finaliza llamando a los procedimientos "actualizar_columna_edad" y "actualizar_columna_email" para actualizar la edad y el correo electrónico
 de todos los alumnos en la tabla, y luego llama al procedimiento "crear_lista_emails_alumnos" para mostrar la lista de correos electrónicos de los alumnos.
*/