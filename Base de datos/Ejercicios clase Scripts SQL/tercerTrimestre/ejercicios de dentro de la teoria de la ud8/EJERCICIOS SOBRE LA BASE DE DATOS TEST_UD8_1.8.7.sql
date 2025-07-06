#	Ejercicio de dentro de la unidad 8 ------    1.8.7 Cursores

CREATE DATABASE IF NOT EXISTS test;
USE test;

CREATE TABLE IF NOT EXISTS alumnos (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido1 VARCHAR(50),
    apellido2 VARCHAR(50),
    fecha_nacimiento DATE
);

INSERT INTO alumnos (nombre, apellido1, apellido2, fecha_nacimiento) VALUES
    ('Juan', 'García', 'López', '1995-05-15'),
    ('María', 'Martínez', 'Rodríguez', '1998-08-20'),
    ('Pedro', 'Sánchez', 'Gómez', '2000-03-10'),
    ('Ana', 'López', 'Fernández', '1997-11-25');


-- Añadir columna edad en tabla alumnos
ALTER TABLE alumnos ADD COLUMN edad INT;


-- Funcion calcular_edad
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
END;//
DELIMITER ;

-- Crear un procedimiento llamado actualizar_columna_edad para calcular la edad de los alumnos y actualizar la tabla
DELIMITER //
DROP PROCEDURE IF EXISTS actualizar_columna_edad;
CREATE PROCEDURE actualizar_columna_edad()
BEGIN
    DECLARE completado INT DEFAULT FALSE;         # se utilizará para determinar si se han procesado todos los registros del cursor. Inicialmente se establece en falso.
    DECLARE id_alumno INT UNSIGNED;
    DECLARE fecha_nacimiento_alumno DATE;
    DECLARE cur CURSOR FOR SELECT id, fecha_nacimiento FROM alumnos;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET completado = TRUE;

    OPEN cur;
    bucle_leer: LOOP    #  Etiqueta el inicio de un bucle llamado bucle_leer.
        FETCH cur INTO id_alumno, fecha_nacimiento_alumno;
        IF completado THEN
            LEAVE bucle_leer;
        END IF;
        UPDATE alumnos SET edad = calcular_edad(fecha_nacimiento_alumno) WHERE id = id_alumno;
    END LOOP;
    CLOSE cur;
END //
DELIMITER ;

-- verificar 
SELECT calcular_edad('1995-05-15');
CALL actualizar_columna_edad();
SELECT * FROM alumnos;

-- ----------------------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------------------
/*
2. Modifica la tabla alumnos del ejercicio anterior para añadir una nueva columna email. Una vez que
hemos modificado la tabla necesitamos asignarle una dirección de correo electrónico de forma automática
Escriba un procedimiento llamado crear_email que dados los parámetros de entrada: nombre, apellido1,
apellido2 y dominio, cree una dirección de email y la devuelva como salida.
• Procedimiento: crear_email
• Entrada:
– nombre (cadena de caracteres)
– apellido1 (cadena de caracteres)
– apellido2 (cadena de caracteres)
– dominio (cadena de caracteres)
• Salida:
– email (cadena de caracteres)
devuelva una dirección de correo electrónico con el siguiente formato:
• El primer carácter del parámetro nombre.
• Los tres primeros caracteres del parámetro apellido1.
• Los tres primeros caracteres del parámetro apellido2.
• El carácter @.
• El dominio pasado como parámetro

Ahora escriba un procedimiento que permita crear un email para todos los alumnmos que ya existen en la tabla.
Para esto será necesario crear un procedimiento llamado actualizar_columna_email que actualice la
columna email de la tabla alumnos. Este procedimiento hará uso del procedimiento crear_email que
hemos creado en el paso anterior.
*/

-- 1. Modificar la tabla alumnos para añadir la columna email:
ALTER TABLE alumnos ADD COLUMN email VARCHAR(100);

-- 2. Procedimiento crear_email:
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

-- 3.Procedimiento actualizar_columna_email:
DELIMITER //
CREATE PROCEDURE actualizar_columna_email()
BEGIN
    DECLARE completado INT DEFAULT FALSE;
    DECLARE id_alumno INT UNSIGNED;
    DECLARE nombre_alumno, apellido1_alumno, apellido2_alumno, dominio VARCHAR(50);
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




Con estos procedimientos, puedes realizar las siguientes acciones:

Modificar la tabla alumnos para añadir la columna email.
Generar emails para todos los alumnos y asignarlos a la columna email.
Obtener una lista de todos los emails de los alumnos en un formato específico.


CALL actualizar_columna_email(); -- Para asignar emails a los alumnos existentes
CALL crear_lista_emails_alumnos(); -- Para obtener la lista de emails de los alumnos

SELECT * FROM alumnos; -- Para ver la tabla de alumnos con los emails asignados


ME ESTA DANDO ERROR LA DE PROCEDIMEINTO EMAILS... VERIFICAR QUE ESTA PASANDO....





3. Escribe un procedimiento llamado crear_lista_emails_alumnos que devuelva la lista de
emails de la tabla alumnos separados por un punto y coma. Ejemplo: juan@iescelia.org;
maria@iescelia.org;pepe@iescelia.org;lucia@iescelia.org.



-- 4.DELIMITER //
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




