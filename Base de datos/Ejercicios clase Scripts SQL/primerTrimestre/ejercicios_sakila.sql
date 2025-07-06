#arreglar la enumeracion creo me me falta hacer el 4 o el 5 po eso no me cuadra

#1
select *
from actor
where upper(first_name) = 'SCARLETT';

#2
SELECT *
FROM ACTOR
WHERE upper(last_name) = 'JOHANSSON';

#3
SELECT *
FROM ACTOR
WHERE upper(first_name) like '%O%';

#4
select *
from actor
where upper(first_name) like '%O%O%' 
and upper(last_name) like '%A%';

#5
select *
from actor
where upper(first_name) like '__B%';

SELECT *
FROM actor
WHERE
    LENGTH(first_name) >= 3 AND
    UPPER(SUBSTRING(first_name, 3, 1)) = 'B';

#6
select *
from city
where upper(city) like'A%';

#7
select *
from city
where upper(city) like'%S';

#8
select *
from city
where country_id = 61;

#9
SELECT city 
FROM city 
WHERE country_id = (
	SELECT country_id FROM country WHERE upper(country) = 'SPAIN'
    );

#10
SELECT * 
FROM city 
WHERE city LIKE '% %';

#11
select *
from film
where length between 80 and 100;

#12
select *
from film
where rental_rate between 1 and 3;

#13
select title
from film
where length(title) >=12;

#14
select rating
from film
where rating = 'PG' OR rating = 'G';

#15
select rating
from film
where rating <> 'NC-17';

#18
select *
from film
where rating = 'PG' and length >=120;

#19
select count(actor_id) as 'total actores'
from actor;

#20
select count(*) as 'total ciudades en España'
from city
where country_id = (
	select country_id from country where upper(country) = 'SPAIN'
);

#21
select count(*) as 'ciudades que empiezan por A'
from city
where upper(city) like 'A%';

#22
select avg(length) as 'media de duracion de las peliculas con PG'
from film
where rating = 'PG';

#23
select sum(rental_race) ' suma de rental_rate de todas las peliculas'
from film;

#24














