											# TEMA 6 -  -- INDICES SOBRE LA BBDD - VIAJES

-- Crea un índice en la tabla lugares para el campo nombre.

create index nombre_idx on lugares (nombre);

-- ALTER TABLE: Crea un índice único en el campo nombre de la tabla lugares. Para modificar la estructura de una tabla. este caso
-- para agraar un indice a una tabla existente.

alter table lugares
add unique index idx_nombre_unique (nombre);

-- Actualizar y reordenar índices: 1.1.3.4.1 OPTIMIZE TABLE: Optimiza la tabla lugares.

optimize table lugares;

-- 1.1.3.4.2 ANALYZE TABLE: - Analiza la tabla lugares.
analyze table lugares;

-- ------------------------------------------
create table if not exists descripcion (
	id int unsigned auto_increment primary key,
    descripcion text not null
);



create fulltext index idx_descripcion_fulltext on descripcion (descripcion);
-- -----------------------------------------------------------------------------------------------------------------

-- 1. Crear un índice full-text en la columna descripcion:

create fulltext index idx_descripcion_fulltext on lugares (descripcion);

-- 2. Realizar una búsqueda utilizando el operador MATCH y AGAINST:
-- Buscar lugares que contengan la palabra "playas" en la descripción:

select *
from lugares
where match(descripcion) against('playas');



-- 3. Realizar una búsqueda que excluya ciertas palabras:
-- Buscar lugares que contengan "templos" pero no "neón" en la descripción:
select *
from lugares 
where match(descripcion) against('templos - neón');


-- 4. Ordenar los resultados por relevancia:
-- Buscar lugares relacionados con "historia" y ordenarlos por relevancia:
select *, match(descripcion) against('historia') as relevancia
from lugares
where match(descripcion) against ('historia')
order by relevancia desc;

-- 5. Realizar una búsqueda con modo booleano:
-- Buscar lugares que contengan "templos" o "neón" en la descripción:
select *
from lugares
where match(descripcion) against('templos -neón' in boolean mode );

-- --------------------------------------------------------------------------

show index from descripcion;
describe descripcion;
-- --------------------------------------------------------------------------
drop index idx_nombre on descripcion;
DROP INDEX idx_multiple_columnas ON lugares (nombre, descripcion);
-- --------------------------------------------------------------------------

-- ---------------------------------------------------------------------------- ---------------------------------------------------------------------------- --------------------------------------------------------------------------
													# EJERCICIO 7 -- Manipulacion De Datos
                                                    
/*

DDL (Data Definition Language - Lenguaje de Definición de Datos):

CREATE: Utilizado para crear objetos de base de datos como tablas, índices, vistas, etc.
ALTER: Utilizado para modificar la estructura de objetos existentes en la base de datos.
DROP: Utilizado para eliminar objetos de la base de datos.
TRUNCATE: Utilizado para eliminar todos los datos de una tabla manteniendo su estructura.
RENAME: Utilizado para cambiar el nombre de un objeto en la base de datos.
- --------------------------------------------------------------
DML (Data Manipulation Language - Lenguaje de Manipulación de Datos):

INSERT: Utilizado para insertar nuevos registros en una tabla.
SELECT: Utilizado para recuperar datos de una o más tablas.
UPDATE: Utilizado para modificar registros existentes en una tabla.
DELETE: Utilizado para eliminar registros de una tabla.
MERGE: Utilizado para combinar datos de múltiples tablas.
-------------------------------------------------------------------------------
DCL (Data Control Language - Lenguaje de Control de Datos):

GRANT: Utilizado para otorgar permisos a usuarios sobre objetos de la base de datos.
REVOKE: Utilizado para retirar los permisos otorgados a los usuarios.
-----------------------------------------------------------------------------------
TCL (Transaction Control Language - Lenguaje de Control de Transacciones):

COMMIT: Utilizado para guardar los cambios realizados en la base de datos.
ROLLBACK: Utilizado para deshacer los cambios realizados en la base de datos desde la última instrucción COMMIT o SAVEPOINT.
SAVEPOINT: Utilizado para marcar un punto específico en una transacción para poder revertir los cambios hasta ese punto.

*/                                                    

                                    
START TRANSACTION;

-- Realiza algunas operaciones
INSERT INTO empleados (nombre, salario) VALUES ('Juan', 3000);
INSERT INTO empleados (nombre, salario) VALUES ('Ana', 2500);

-- Establece un SAVEPOINT
SAVEPOINT punto_guardado;

-- Realiza más operaciones
INSERT INTO empleados (nombre, salario) VALUES ('Carlos', 2800);

-- Si algo sale mal, puedes deshacer las operaciones hasta este punto
ROLLBACK TO SAVEPOINT punto_guardado;

-- Realiza otras operaciones
INSERT INTO empleados (nombre, salario) VALUES ('María', 3200);

-- Confirma los cambios
COMMIT;

-- ----------------------

START TRANSACTION;

-- Realiza algunas operaciones
INSERT INTO empleados (nombre, salario) VALUES ('Juan', 3000);
INSERT INTO empleados (nombre, salario) VALUES ('Ana', 2500);

-- Establece un SAVEPOINT
SAVEPOINT punto_guardado;

-- Realiza más operaciones
INSERT INTO empleados (nombre, salario) VALUES ('Carlos', 2800);

-- Si algo sale mal, puedes deshacer las operaciones hasta este punto
ROLLBACK TO SAVEPOINT punto_guardado;

-- Realiza otras operaciones
INSERT INTO empleados (nombre, salario) VALUES ('María', 3200);

-- Confirma los cambios
COMMIT;
                



























