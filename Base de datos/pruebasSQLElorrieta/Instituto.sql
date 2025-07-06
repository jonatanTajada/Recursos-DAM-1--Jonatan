#DROP database if exists instituto;

create database if not exists Instituto collate utf8mb4_spanish2_ci;
use Instituto;


create table if not exists Estudios(
	COD_CICLO char(3) primary key,
    NOM_CICLO varchar(40) not null unique,
    NIVEL enum('M','S') not null,
    DURACION int not null
);

create table if not exists Alumnos(
	NIF char(9),
    NOMBRE varchar(40) not null,
    APELLIDOS varchar(40) not null,
    CICLO char(3) not null, /*fk poner restriccion*/
    CURSO enum ('1', '2') not null,
    IDIOMA enum ('Ingles','Frances'),
    DIRECCION varchar(40) not null
    
   /*constraint fk_CICLO foreign key(CICLO) references Estudios (COD_CICLO) on update cascade */
);

# - AÑADIR UN NUEVO ATRIBUTO A LA TABLA -
ALTER  TABLE Alumnos 
ADD NUM_MATRICULA int zerofill not null;

# - AÑADIR PRIMARY KEY A LA TABLA -
ALTER TABLE Alumnos
ADD primary key (NIF);

# - AÑADIR FOREIGN KEY A LA TABLA -
ALTER TABLE Alumnos
ADD foreign key(CICLO) references Estudios(COD_CICLO) on update cascade;

# - AÑADIR UNIQUE A LA TABLA -
ALTER TABLE Alumnos
ADD unique(NUM_MATRICULA);


#-----------------------------------------------------------------------------

# - ASGINAR UN VALOR POR DEFECTO EN LA TABLA -
ALTER TABLE Estudios
ALTER DURACION set default 2000; 

#-----------------------------------------------------------------------------

# - Cambiar el nombre de un atributo y su definición -
/*ALTER TABLE nombre_tabla 
CHANGE [COLUMN] nombre_anterior_columna 
nuevo_nombre_columna definición_columna [restricciones_columna]; */

#-----------------------------------------------------------------------------


# - Cambiar la definición de un atributo sin cambiar su nombre -
ALTER TABLE Alumnos
MODIFY IDIOMA enum('Ingles','Frances','Aleman','Italiano');

#-----------------------------------------------------------------------------

# - Eliminar un atributo -
ALTER TABLE Estudios
DROP DURACION;

# - Eliminar la restricción de clave primaria -
/*
ALTER TABLE nombre_tabla 
DROP PRIMARY KEY;
*/

# - Eliminar una clave ajena, para lo que se debe escribir -
/*
ALTER TABLE nombre_tabla 
DROP FOREIGN KEY nombre_restricción;
*/


/*

La elección entre CHANGE y MODIFY al realizar modificaciones en una columna en MySQL depende de la naturaleza del cambio que estás realizando.

MODIFY:
Se utiliza para modificar el tipo de datos y otras propiedades de la columna, como NULL o NOT NULL, pero no para cambiar el nombre de la columna.
Es útil cuando estás haciendo cambios en el tipo de datos o restricciones sin cambiar el nombre de la columna.


CHANGE:
Se utiliza cuando deseas cambiar el nombre de la columna además de sus propiedades, como tipo de datos, NULL o NOT NULL.
Permite especificar un nuevo nombre para la columna.


Entonces, si estás cambiando el nombre de la columna junto con otras modificaciones, utiliza CHANGE.
Si solo estás haciendo modificaciones sin cambiar el nombre de la columna, utiliza MODIFY.


*/




