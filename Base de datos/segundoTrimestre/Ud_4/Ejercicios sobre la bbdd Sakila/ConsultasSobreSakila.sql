SELECT * 
FROM actor 
WHERE upper(first_name) = 'SCARLETT';

SELECT * 
FROM actor 
WHERE upper(last_name) = 'JOHANSSON';

SELECT * 
FROM actor 
WHERE upper(first_name) LIKE '%O%';

SELECT * 
FROM actor 
WHERE upper(first_name) LIKE '%O%'
AND upper(last_name) LIKE '%A%';

SELECT * 
FROM actor 
WHERE upper(first_name) LIKE '%O%O%'
AND upper(last_name) LIKE '%A%';

SELECT * 
FROM actor 
WHERE upper(first_name) LIKE '__B%';

SELECT * 
FROM city 
WHERE upper(city) LIKE 'A%';

SELECT * 
FROM city 
WHERE upper(city) LIKE '%S';

SELECT * 
FROM city 
WHERE country_id = 61;

SELECT * 
FROM city 
WHERE country_id = (SELECT country_id FROM country WHERE upper(country) = 'SPAIN');

SELECT * 
FROM city 
WHERE city LIKE '% %';

SELECT * 
FROM film 
WHERE length >= 80 and length <= 100;
 
-- segunda opcion
 
SELECT * 
FROM film 
WHERE length between 80 and 100;

SELECT * 
FROM film 
WHERE rental_rate >= 1 
AND rental_rate <= 3;

SELECT title, length(title) as longitud 
FROM film 
WHERE length(title) >= 12;

SELECT * 
FROM film 
WHERE rating = 'PG'
OR rating = 'G';

SELECT * 
FROM film 
WHERE rating <> 'NC-17';

SELECT * 
FROM film 
WHERe rating = 'PG'
AND length >= 120;

SELECT COUNT(*) as num_actor 
FROM actor;

SELECT COUNT(*) as num_cities 
FROM city 
WHERE country_id = (SELECT country_id from country where upper(country) = 'SPAIN');

SELECT COUNT(*) as num_countries 
FROM country 
WHERE upper(country) LIKE 'A%';

SELECT AVG(length) as media_duracion 
FROM film 
WHERE rating = 'PG';

SELECT SUM(rental_rate) as suma_rental 
FROM film;

SELECT MAX(length) as mayor_duracion 
FROM film;

SELECT MIN(length) as mayor_duracion 
FROM film;

SELECT co.country, c.city
FROM city c, country co
WHERE c.country_id = co.country_id;

SELECT f.title, a.first_name, a.last_name
FROM film f, actor a, film_actor fa
WHERE f.film_id = fa.film_id 
AND a.actor_id = fa.actor_id
ORDER BY f.title;

SELECT f.title, c.name as category
FROM film f, category c, film_category ca
WHERE f.film_id = ca.film_id 
AND c.category_id = ca.category_id
ORDER BY f.title;

SELECT co.country, c.city, a.address, a.address2, s.first_name, s.last_name
FROM country co, city c, address a, staff s
WHERE co.country_id = c.country_id 
AND a.city_id = c.city_id 
AND s.address_id = a.address_id;

SELECT co.country, c.city, a.address, a.address2, cu.first_name, cu.last_name
FROM country co, city c, address a, customer cu
WHERE co.country_id = c.country_id 
AND a.city_id = c.city_id 
AND cu.address_id = a.address_id;

SELECT rating, count(*)
FROM film
GROUP BY rating;

SELECT first_name, last_name, count(*)
FROM actor a, film f, film_actor fa
WHERE f.film_id = fa.film_id 
AND a.actor_id = fa.actor_id
AND first_name = 'ED'
AND last_name = 'CHASE'
GROUP BY first_name, last_name;

SELECT c.name, avg(f.length) as media_duracion
FROM category c, film f, film_category fc
WHERE c.category_id = fc.category_id
AND f.film_id = fc.film_id
group by c.name;







