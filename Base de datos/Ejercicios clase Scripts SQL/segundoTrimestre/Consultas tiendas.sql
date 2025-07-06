#CONSULTAS TIENDAS


select nombre from producto;
select nombre, precio from producto;
select * from producto;	
select nombre, precio as euros, precio * 1.05 as dolares from producto;	
select nombre as "nombre producto", precio as euros, precio * 1.05 as dolares from producto;
select upper(nombre) as "nombre producto" from producto;
select lower(nombre) as "nombre producto" from producto;	
select nombre, upper(substr(nombre, 0, 2)) as codigo from fabricante;
select nombre, round(precio) as redondeado from producto;	
select nombre, trunc(precio) as truncado from producto;

select codigo_fabricante from producto;	
select distinct codigo_fabricante from producto;	
select nombre from fabricante order by nombre;
select nombre from fabricante order by nombre desc;
select nombre from producto order by nombre, precio desc;	
select * from producto limit 5;
select codigo, nombre 
from (select codigo, nombre from fabricante)
limit 4,2;

select nombre from producto where precio > 200 and codigo_fabricante = 6;
select * from producto where codigo_fabricante = 1 or codigo_fabricante = 3 or codigo_fabricante = 5;
select * from producto where codigo_fabricante IN (1,3,5);
	
select nombre, precio * 100 as centimos from producto;
select nombre from fabricante where upper(nombre) LIKE 'S%';
select nombre from fabricante where lower(nombre) LIKE '%e';

select nombre from fabricante where lower(nombre) LIKE '%w%';
select nombre from fabricante where lower(nombre) LIKE '____';
	
select nombre from producto where lower(nombre) LIKE '%portátil%';
	
select nombre from producto where lower(nombre) LIKE '%monitor%' and precio < 215;
select nombre, precio from producto where precio >= 180 order by precio desc, nombre;

select p.nombre, p.precio, f.nombre
from producto p, fabricante f
where p.codigo_fabricante = f.codigo;

select p.nombre, p.precio, f.nombre
from producto p, fabricante f
where p.codigo_fabricante = f.codigo
order by f.nombre;

select p.codigo, p.nombre, p.precio, f.nombre
from producto p, fabricante f
where p.codigo_fabricante = f.codigo;

select p.nombre, p.precio, f.nombre
from producto p, fabricante f
where p.codigo_fabricante = f.codigo
and p.precio = (select min(precio) from producto);

select p.nombre, p.precio, f.nombre
from producto p, fabricante f
where p.codigo_fabricante = f.codigo
and p.precio = (select max(precio) from producto);

select p.*
from producto p, fabricante f 
where p.codigo_fabricante = f.codigo
and upper(f.nombre) = 'LENOVO';
select * from fabricante;
select * from producto;
select p.*
from producto p, fabricante f 
where p.codigo_fabricante = f.codigo
and upper(f.nombre) = 'CRUCIAL' and p.precio > 200;

select p.*
from producto p, fabricante f 
where p.codigo_fabricante = f.codigo 
and (upper(f.nombre) = 'ASUS' or upper(f.nombre) = 'HEWLETT-PACKARD' or upper(f.nombre) = 'SEAGATE');

select p.*
from producto p, fabricante f 
where p.codigo_fabricante = f.codigo 
and upper(f.nombre) IN ('ASUS','HEWLETT-PACKARD','SEAGATE');

select p.nombre, p.precio
from producto p, fabricante f 
where p.codigo_fabricante = f.codigo 
and upper(f.nombre) LIKE '%E';

select p.nombre, p.precio
from producto p, fabricante f 
where p.codigo_fabricante = f.codigo 
and upper(f.nombre) LIKE '%W%';

select p.nombre, p.precio, f.nombre
from producto p, fabricante f 
where p.codigo_fabricante = f.codigo 
and p.precio >= 180
order by p.precio desc, p.nombre;

select distinct f.codigo, f.nombre
from producto p, fabricante f 
where p.codigo_fabricante = f.codigo;

select f.nombre, p.nombre, p.precio
from fabricante f LEFT JOIN producto p on f.codigo = p.codigo_fabricante;