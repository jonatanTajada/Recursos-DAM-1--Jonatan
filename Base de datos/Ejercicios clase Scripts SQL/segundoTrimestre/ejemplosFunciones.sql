#se trabaja sobre la bbdd de Sakila. ejercicio enviado a Blanca el 16/01/2024.


#consulta 1.
select title, rating,
	case rating
		when 'G' then 'Para todos los publicos'
		when 'PG' then 'Menores acompañados'
		when 'R' then 'Para adultos'
	else 
		'Otros'
	end tipo     #creo campo tipo y segun el case tendra un valor u otro.    
from film
order by title;




#case 3
SELECT 
    payment_id, 
    customer_id, 
    amount,
    CASE 
        WHEN amount < 4 THEN 'Bajo'
        WHEN amount < 7 THEN 'Medio'
        ELSE 'Alto'
    END AS tipo,
    CASE 
        WHEN amount < 6 THEN 'Barato'
        ELSE 'Caro'
    END AS precio,
    CASE 
        WHEN amount BETWEEN 4 AND 6 THEN 'Medio'
        ELSE 'No definido'
    END AS precio2,
    IF(amount < 4, 'Bajo', IF(amount < 7, 'Medio', 'Alto')) AS tipo2
FROM 
    payment;

#consulta 4
SELECT 
    payment_id, 
    customer_id, 
    payment_date,
    CASE DAYOFWEEK(payment_date)
        WHEN 1 THEN 'Domingo'
        WHEN 2 THEN 'Lunes'
        WHEN 3 THEN 'Martes'
        WHEN 4 THEN 'Miércoles'
        WHEN 5 THEN 'Jueves'
        WHEN 6 THEN 'Viernes'
        WHEN 7 THEN 'Sábado'
        ELSE 'No definido'
    END AS nombre_dia,
    DAYOFWEEK(payment_date) AS numero_dia
FROM 
    payment;


#consulta 5
SELECT * ,
    CASE 
        WHEN staff_id = 1 THEN 'Ana'
        WHEN staff_id = 2 THEN 'Juan'
        ELSE 'Otros'
    END AS 'Empleado'
FROM 
    payment;

#consulta-6
SELECT title, 
    CASE 
        WHEN replacement_cost > 20 THEN CONCAT('Descuento: ', replacement_cost * 0.9)
        ELSE replacement_cost
    END AS 'Coste'
FROM film;

/*-------------------------------------------------------------*/

/*
INSERT INTO payment (payment_id, customer_id, staff_id, rental_id, amount, payment_date, last_update)
VALUES
(1, 101, 1, 1, 20.50, '2024-01-20', CURRENT_TIMESTAMP),
(2, 102, 2, 2, 15.75, '2024-01-21', CURRENT_TIMESTAMP),
(3, 103, 1, 3, 30.00, '2024-01-22', CURRENT_TIMESTAMP),
(4, 104, 2, 4, 25.25, '2024-01-23', CURRENT_TIMESTAMP),
(5, 105, 1, 5, 18.99, '2024-01-24', CURRENT_TIMESTAMP);

*/

# Ejemplo: seleccionar todos los campos de la tabla payment donde la fecha de pago sea el día de la semana 3 (en inglés es el martes no el miércoles).

SELECT *
FROM payment
WHERE DAYOFWEEK(payment_date) = 3;

# Ejemplo: seleccionar todos los campos de la table payment donde el día de la fecha de pago coincida con el día actual.

SELECT *
FROM payment
WHERE DAY(payment_date) = DAY(CURDATE());

/*------------------------*/
# FUNCIONES MATEMATICAS:
	#Rounded
SELECT 
    ROUND(4.9) AS round_1,
    ROUND(-4.9) AS round_neg_1,
    ROUND(123.4567) AS round_123,
    ROUND(-789.12345) AS round_neg_789;
    
	#Ceil
SELECT 
    CEIL(4.9) AS ceil_4_9,
    CEIL(-4.9) AS ceil_neg_4_9,
    CEIL(123.4567) AS ceil_123_4567,
    CEIL(-789.12345) AS ceil_neg_789_12345;
    
	#floor
SELECT 
    FLOOR(4.9) AS floor_4_9,
    FLOOR(-4.9) AS floor_neg_4_9,
    FLOOR(123.4567) AS floor_123_4567,
    FLOOR(-789.12345) AS floor_neg_789_12345;


# Truncate
SELECT 
    TRUNCATE(4.98765, 2) AS truncate_2_decimals,
    TRUNCATE(-4.12345, 2) AS truncate_neg_2_decimals,
    TRUNCATE(123.4567, 2) AS truncate_123_2_decimals,
    TRUNCATE(-789.12345, 2) AS truncate_neg_789_2_decimals;
    
# FUNCIONES DE CADENA:

	#Length
SELECT 
    LENGTH('Hola') AS longitud_hola,
    LENGTH('¡Hola, mundo!') AS longitud_hola_mundo,
    LENGTH('12345') AS longitud_numeros;
   
   # SUBSTRING
   
SELECT 
    SUBSTRING('ABCDEFG', 2, 4) AS substring_abcdefg,
    SUBSTRING('¡Hola, mundo!', 7) AS substring_hola_mundo;

	#CONCAT
SELECT 
    CONCAT('Hola', ' ', 'mundo') AS concat_hola_mundo,
    CONCAT('La respuesta es ', 42) AS concat_respuesta_42;

    # Locate
SELECT 
    LOCATE('la', 'Hola') AS locate_la_en_hola,
    LOCATE('mundo', '¡Hola, mundo!') AS locate_mundo_en_hola_mundo;
    
# FUNCIONES DE FECHA

-- CURDATE() - Fecha actual
SELECT CURDATE() AS fecha_actual;

# CURTIME() - Hora actual
SELECT CURTIME() AS hora_actual;

# NOW() - Fecha y hora actual
SELECT NOW() AS fecha_hora_actual;

# DATE_FORMAT(date, format) - Formatea una fecha con el formato especificado
SELECT DATE_FORMAT(NOW(), '%Y-%m-%d %H:%i:%s') AS fecha_hora_formateada;

# DAYOFMONTH(date), DAYOFWEEK(date), DAYOFYEAR(date)
SELECT 
    DAYOFMONTH(NOW()) AS dia_mes_actual,
    DAYOFWEEK(NOW()) AS dia_semana_actual,
    DAYOFYEAR(NOW()) AS dia_anio_actual;

# HOUR(time), MINUTE(time), SECOND(time), MONTH(date), YEAR(date)
SELECT 
    HOUR(NOW()) AS hora_actual,
    MINUTE(NOW()) AS minuto_actual,
    SECOND(NOW()) AS segundo_actual,
    MONTH(NOW()) AS mes_actual,
    YEAR(NOW()) AS anio_actual;

    

    