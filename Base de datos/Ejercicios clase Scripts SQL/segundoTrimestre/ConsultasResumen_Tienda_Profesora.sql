SELECT f.nombre, COUNT(p.codigo) AS num_productos
FROM fabricante f
LEFT JOIN producto p ON f.codigo = p.codigo_fabricante
GROUP BY f.nombre;

SELECT f.nombre
FROM fabricante f
LEFT JOIN producto p ON f.codigo = p.codigo_fabricante
WHERE p.codigo IS NULL;

SELECT COUNT(*) AS total_productos
FROM producto;

SELECT COUNT(*) AS total_fabricantes
FROM fabricante;

SELECT COUNT(DISTINCT codigo_fabricante) AS total_valores_distintos
FROM producto;

SELECT AVG(precio) AS media_precio
FROM producto;

SELECT MIN(precio) AS precio_mas_barato
FROM producto;

SELECT MAX(precio) AS precio_mas_caro
FROM producto;

SELECT nombre, precio
FROM producto
WHERE precio = (SELECT MIN(precio) FROM producto);

SELECT nombre, precio
FROM producto
WHERE precio = (SELECT MAX(precio) FROM producto);

SELECT SUM(precio) AS suma_precios
FROM producto;

SELECT COUNT(*) AS cantidad_productos
FROM producto
WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = 'Asus');

SELECT AVG(precio) AS media_precios
FROM producto
WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = 'Asus');

SELECT MIN(precio) AS precio_mas_barato
FROM producto
WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = 'Asus');

SELECT MAX(precio) AS precio_mas_caro
FROM producto
WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = 'Asus');

SELECT SUM(precio) AS suma_precios
FROM producto
WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = 'Asus');

SELECT MAX(precio) AS precio_maximo, MIN(precio) AS precio_minimo, AVG(precio) AS
precio_medio, COUNT(*) AS cantidad_productos
FROM producto
WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = 'Crucial');

SELECT f.nombre AS fabricante, COUNT(p.codigo) AS numero_productos
FROM fabricante f
LEFT JOIN producto p ON f.codigo = p.codigo_fabricante
GROUP BY f.nombre
ORDER BY numero_productos DESC;

SELECT f.nombre AS fabricante, MAX(p.precio) AS precio_maximo,
MIN(p.precio) AS precio_minimo, AVG(p.precio) AS precio_medio
FROM fabricante f
LEFT JOIN producto p ON f.codigo = p.codigo_fabricante
GROUP BY f.nombre;

SELECT codigo_fabricante, MAX(precio) AS precio_maximo,
MIN(precio) AS precio_minimo, AVG(precio) AS precio_medio,
COUNT(codigo) AS numero_productos
FROM producto
GROUP BY codigo_fabricante
HAVING precio_medio > 200;

select * from producto;

SELECT f.nombre AS fabricante, MAX(p.precio) AS precio_maximo,
MIN(p.precio) AS precio_minimo, AVG(p.precio) AS precio_medio,
COUNT(p.codigo) AS numero_productos
FROM fabricante f
LEFT JOIN producto p ON f.codigo = p.codigo_fabricante
GROUP BY f.nombre
HAVING precio_medio > 200;

SELECT COUNT(*) AS numero_productos
FROM producto
WHERE precio >= 180;

SELECT f.nombre AS fabricante, COUNT(p.codigo) AS numero_productos
FROM fabricante f
LEFT JOIN producto p ON f.codigo = p.codigo_fabricante
WHERE p.precio >= 180
GROUP BY f.nombre;

SELECT codigo_fabricante, AVG(precio) AS precio_medio
FROM producto
GROUP BY codigo_fabricante;

SELECT f.nombre AS fabricante, AVG(p.precio) AS precio_medio
FROM fabricante f
LEFT JOIN producto p ON f.codigo = p.codigo_fabricante
GROUP BY f.nombre;

SELECT f.nombre AS fabricante
FROM fabricante f
LEFT JOIN producto p ON f.codigo = p.codigo_fabricante
GROUP BY f.nombre
HAVING AVG(p.precio) >= 150;

SELECT f.nombre AS fabricante
FROM fabricante f
LEFT JOIN producto p ON f.codigo = p.codigo_fabricante
GROUP BY f.nombre
HAVING COUNT(p.codigo) >= 2;