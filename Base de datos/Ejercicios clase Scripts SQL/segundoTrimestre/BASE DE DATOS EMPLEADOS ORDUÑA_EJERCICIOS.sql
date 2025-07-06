#ALUMNO: JONATAN TAJADA RICO


#Ejercicio 3 ultima parte, REALIZA LAS SIGUIENTES OPERACIONES:

#EJERCICIO 1:

# Inserción en la tabla EMPLEADOS
INSERT INTO EMPLEADOS (DNI, NOMBRE, APELLIDO1, APELLIDO2, DIR1, DIR2, CIUDAD, SEXO, FECHA_NAC)
VALUES
    (72404078, 'Jonatan', 'Tajada', 'Gómez', 'Calle Autnomia', 'Piso 2', ' Barakaldo', 'H', '1989-01-15'),
    (72404874, 'Naiara', 'Carnero', 'Fernández', 'Calle Kadagua', 'Piso 3', 'Bilbao', 'M', '1988-05-20');

# Inserción en la tabla DEPARTAMENTOS
INSERT INTO DEPARTAMENTOS (DPTO_COD, NOMBRE_DPTO, DPTO_PADRE, PRESUPUESTO)
VALUES
    (10, 'Ventas', NULL, 50000),
    (20, 'RRHH', NULL, 30000);

# Inserción en la tabla ESTUDIOS
INSERT INTO ESTUDIOS (EMPLEADO_DNI, UNIVERSIDAD, AÑO, GRADO, ESPECIALIDAD)
VALUES
    (72404078, 101, '2020', 'Ing', 'Informática'),
    (72404874, 102, '2018', 'Dip', 'Finanzas');

# Inserción en la tabla TRABAJOS
INSERT INTO TRABAJOS (TRABAJO_COD, NOMBRE_TRAB, SALARIO_MIN, SALARIO_MAX)
VALUES
    (1, 'Vendedor', 20000, 35000),
    (2, 'Contable', 25000, 30000);

# Inserción en la tabla UNIVERSIDADES
INSERT INTO UNIVERSIDADES (NOMBRE_UNIV, CIUDAD, MUNICIPIO, COD_POSTAL)
VALUES
    ('101', 'Orduña', 'Ay', '12345'),
    ('102', 'Bilbao', 'GB', '67890');

# Inserción en la tabla HISTORIAL_LABORAL
INSERT INTO HISTORIAL_LABORAL (EMPLEADO_DNI, TRABAJO_COD, FECHA_INICIO, FECHA_FIN, DPTO_COD, SUPERVISOR_DNI, SALARIO)
VALUES
    (72404078, 1, '2021-01-01', NULL, 10, NULL, 35000),
    (72404874, 2, '2020-02-15', NULL, 20, 72404078, 30000);
    
    
/****************************************************************************************************************************************************/    

#Ejercicio 2: Inserte las siguientes filas.

-- Insertar filas en la tabla EMPLEADOS
INSERT INTO EMPLEADOS (NOMBRE, APELLIDO1, APELLIDO2, DNI, SEXO)
VALUES
    ('Sergio', 'Palma', 'Entrena', 111222, 'H'),
    ('Lucia', 'Ortega', 'Plus', 222333, 'H');

-- Insertar filas en la tabla Historial_Laboral
INSERT INTO Historial_Laboral (EMPLEADO_DNI, TRABAJO_COD, FECHA_INICIO, FECHA_FIN, DPTO_COD, SUPERVISOR_DNI, SALARIO) 
VALUES (111222, NULL, '1996-06-16', NULL, 222333, NULL, 35000 );


/*
3.	¿Qué ocurre si se modifica esta última fila de historial_laboral asignándole al empleado 111222 un supervisor que no existe en la tabla de empleados?

	EN PRIMER LUGAR NO EXISTE ESTE EMPLEADO, 111222, TENDRIA QUE INSERTALO EN LA TABLA EMPLEADO.
    NO PUEDO ASIGNAR UN SUPERVISOR CON UN DNI QUE NO EXSITEN EN LA TABLA EMPLEADOS, LA OPERACION DE MODIFICACION SERA RECHAZADA PARA MANTENER LA INTEGRIDAD DE LA BASE DE DATOS.


4.	Borre una universidad de la tabla de UNIVERSIDADES ¿Qué le sucede a la restricción de clave ajena de la tabla ESTUDIOS?
	Altere la definición de la tabla para que se mantenga la restricción, aunque se borre una universidad.


Si elimino una universidad me dara un error si tengo registros en ESTUDIOS que dependa de esa universidad.
Podemos cambiar la restriccion a on delete set null en la restriccion de la clave externa en ESTUDIOS para estableces
valores nulos en vez decir que no se puede eliminar.


ALTER TABLE ESTUDIOS
DROP FOREIGN KEY FK_EMPLEADO_DNI;

ALTER TABLE ESTUDIOS
ADD CONSTRAINT FK_EMPLEADO_DNI
FOREIGN KEY (EMPLEADO_DNI) REFERENCES EMPLEADOS(DNI)
ON UPDATE CASCADE ON DELETE SET NULL;


5.	Añada un nuevo atributo VALORACIÓN en la tabla de EMPLEADOS que indique de 1 a 10 la valoración que obtuvo el empleado 
en su entrevista de trabajo al iniciar su andadura en la empresa. 
Ponga el valor por defecto 5 para ese campo

ALTER TABLE EMPLEADOS
ADD COLUMN VALORACION INT DEFAULT 5;


6.	Elimine la restricción de que el atributo NOMBRE de la tabla EMPLEADOS no puede ser nulo.

ALTER TABLE EMPLEADOS
MODIFY COLUMN NOMBRE VARCHAR(10);


7.	Modificar el tipo de datos de DIREC1 de la tabla EMPLEADOS a cadena de caracteres de 40 como máximo.


ALTER TABLE EMPLEADOS
MODIFY COLUMN DIR1 VARCHAR(40);


8.	¿Podría modificar el tipo de datos del atributo FECHA_NAC de la tabla EMPLEADOS Y convertirla a tipo cadena? 
Cambiar la clave primaria de EMPLEADOS al NOMBRE y los dos APELLIDOS.

ALTER TABLE EMPLEADOS
MODIFY COLUMN FECHA_NAC VARCHAR(10);

ALTER TABLE EMPLEADOS
DROP PRIMARY KEY;

ALTER TABLE EMPLEADOS
ADD PRIMARY KEY (NOMBRE, APELLIDO1, APELLIDO2);



9.	Crear una nueva tabla llamada INFORMACIÓN UNIVERSITARIA que tenga el NOMBRE y los dos APELLIDOS (en un solo atributo)
 de todos los EMPLEADOS junto con la UNIVERSIDAD donde estudiaron. Cárguela con los datos correspondientes.


CREATE TABLE INFORMACION_UNIVERSITARIA (

    NOMBRE_COMPLETO VARCHAR(40),
    UNIVERSIDAD INT,
    
		CONSTRAINT FK_UNIVERSIDAD FOREIGN KEY (UNIVERSIDAD) REFERENCES UNIVERSIDADES(UNIVERSIDAD) ON UPDATE CASCADE ON DELETE CASCADE
);


INSERT INTO INFORMACION_UNIVERSITARIA (NOMBRE_COMPLETO, UNIVERSIDAD)
SELECT CONCAT(NOMBRE, ' ', APELLIDO1, ' ', APELLIDO2) AS NOMBRE_COMPLETO, UNIVERSIDAD
FROM EMPLEADOS;




10.	Borrar todas las tablas. ¿Hay que tener en cuenta las claves ajenas a la hora de borrar las tablas?

- Desactivar la verificación de claves ajenas temporalmente
SET foreign_key_checks = 0;

-- Borrar todas las tablas
DROP TABLE IF EXISTS INFORMACION_UNIVERSITARIA;
DROP TABLE IF EXISTS HISTORIAL_LABORAL;
DROP TABLE IF EXISTS HISTORIAL_SALARIAL;
DROP TABLE IF EXISTS ESTUDIOS;
DROP TABLE IF EXISTS UNIVERSIDADES;
DROP TABLE IF EXISTS TRABAJOS;
DROP TABLE IF EXISTS EMPLEADOS;
DROP TABLE IF EXISTS DEPARTAMENTOS;

-- Reactivar la verificación de claves ajenas
SET foreign_key_checks = 1;



*/



