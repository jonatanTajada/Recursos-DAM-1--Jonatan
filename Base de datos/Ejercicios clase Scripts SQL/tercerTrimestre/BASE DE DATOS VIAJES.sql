DROP DATABASE IF EXISTS viajes;
CREATE DATABASE viajes CHARACTER SET utf8mb4;

USE viajes;

CREATE TABLE lugares (
 id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
 nombre VARCHAR(100) NOT NULL,
 descripcion TEXT NOT NULL
 );

 INSERT INTO lugares VALUES (1, 'París', 'Viaje a <strong>París</strong>,
fascinado por la <strong>Torre Eiffel</strong> iluminada de noche y el museo
del <strong>Louvre</strong> con la <strong>Mona Lisa</strong>.');

 INSERT INTO lugares VALUES (2, 'Santorini', 'Pintoresco pueblo de <strong>
Santorini</strong> con casas blancas y tejados azules, playas de arena volcá
nica. Cuenta con museos fascinantes como el del Louvre que muestran la rica
historia de la isla y su cultura.');

 INSERT INTO lugares VALUES (3, 'Gran Cañon', 'Impresionante <strong>Gran Cañón
</strong> con paredes rocosas y espectaculares puestas de sol.');

 INSERT INTO lugares VALUES (4, 'Machu Pichu', 'Ruinas antiguas de <strong>Machu
Picchu</strong>, caminar por calles empedradas y admirar templos y terrazas.');

 INSERT INTO lugares VALUES (5, 'Tokio', 'Contraste de tradición y modernidad en
<strong>Tokio</strong>, con templos históricos y brillantes letreros de neón.');

-- ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


SELECT *
FROM lugares
WHERE descripcion LIKE '%museo del Louvre%';

-- PARA ELIMINAR LAS ETIQUETAS HTML CON EL REGUEX,, LA CONSULATA ANTEIOR NO DEVUELVENAD APOR LAS ETIQUETAS HTML 

 EXPLAIN SELECT REGEXP_REPLACE(descripcion, "<[^>]+>", "")
FROM lugares
WHERE REGEXP_REPLACE(descripcion, "<[^>]+>", "") LIKE '%museo del Louvre%';

CREATE FULLTEXT INDEX idx_nombre ON lugares(descripcion);

SHOW indexes FROM LUGARES;

SELECT *, 
MATCH(descripcion) AGAINST ('museo del Louvre')
FROM lugares
WHERE MATCH(descripcion) AGAINST ('museo del Louvre');



















