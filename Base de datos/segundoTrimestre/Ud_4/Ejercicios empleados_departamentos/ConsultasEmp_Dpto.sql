	
select * 
from empleados;

select * 
from departamentos;

select * 
from empleados 
where lower(cargoE)='secretaria';

select nomemp, salemp 
from empleados;

select * 
from empleados 
where lower(cargoE)='vendedor'
order by nomEmp asc;

select distinct nombreDPto 
from departamentos;

select nomEmp, cargoE, salemp 
from empleados 
order by salemp;

select salemp, comisione 
from empleados 
order by comisionE;

select distinct comisione 
from empleados;

select nomemp, salemp, (salemp+500000) as 'pago estimado'
from empleados 
where codDepto = '3000'
order by nomemp;

select nomemp,salemp,comisione 
from empleados
where comisionE > salEmp;

select nomemp,salemp,comisione 
from empleados
where comisionE <= (salEmp*0.3);

select nomemp as 'Nombre', cargoe as 'Cargo'
from empleados;

select nDIEmp,salemp,comisione 
from empleados
where nDIEmp > '19.709.802';

select nomemp, cargoe
from empleados
where lower(nomemp) > 'j' and lower(nomemp) < 'z'
order by nomemp;

select salemp,
            comisione,
            (salemp + comisione) as 'Salario total', 
            ndiemp
from empleados
where comisione > 1000000
order by ndiemp;

select salemp,
            comisione,
            (salemp + comisione) as 'Salario total',
            ndiemp 
from empleados 
where comisione = 0 
order by ndiemp;

select nomEmp 
from empleados 
where lower(nomEmp) not like '%ma%';

select nombreDpto 
from departamentos 
where lower(nombreDpto) not in ('ventas', 'investigación', 'mantenimiento');

select e.nomemp, d.nombreDpto 
from empleados e, departamentos d 
where e.codDepto=d.codDepto  and (lower(e.cargoE)='secretaria' or lower(e.cargoE)='vendedor')
and lower(d.nombreDpto)<>'producción' and e.salEmp > 1000000 
order by e.fecIncorporacion;

/*Ejercio 22*/
select * 
from empleados 
where char_length(nomemp) = 11 order by nomEmp;

/*Ejercio 23*/
select *, length(nomemp)
from empleados 
where char_length(nomemp) < 11;

/*Ejercio 24*/
select e.nomEmp, d.nombreDpto, e.salEmp 
from empleados e, departamentos d 
where e.codDepto=d.codDepto and lower(e.nomEmp) like 'm%' and (e.salEmp > 800000 or e.comisionE>0) 
and lower(d.nombreDpto)<>'ventas';

select nomEmp, salEmp, comisionE 
from empleados 
where salEmp between (comisionE/2) and comisionE;

/*Ejercio 26*/
select max(salEmp) as 'Salario mayor'
from empleados;

/*Ejercio 27*/
select comisionE, count(*) as 'Num empleados'
from empleados group by comisionE having comisionE > 0;

/*Ejercio 28*/
select max(nomemp) as 'Mayor alfabeticamente'
from empleados;

select max(salemp) as 'Salario mayor', min(salemp) as 'Salario menor', max(salemp) - min(salemp) as 'Diferencia' 
from empleados;

select codDepto, sexemp, count(*) 
from empleados 
group by codDepto, sexemp;

select codDepto, avg(salemp) 
from empleados 
group by codDepto;

select nDIEmp, salEmp 
from empleados 
where salemp >= (select avg(salemp) from empleados);

select d.codDepto, d.nombreDpto, count(*) as 'Num empleados'
from departamentos d, empleados e 
where d.codDepto=e.codDepto 
group by d.codDepto 
having count(*) >= 3;

select j.nDIEmp, j.nomEmp, count(*) as 'Num Empleados'
from empleados e, empleados j 
where e.jefeID=j.nDIEmp  
group by e.jefeID
having count(*)>=2
order by count(*) desc;

select d.codDepto, d.nombreDpto 
from departamentos d, empleados e 
where d.codDepto=e.codDepto 
group by d.codDepto 
having count(*) = 0;

select d.nombreDpto, sum(e.salEmp) 
from departamentos d, empleados e 
where d.codDepto=e.codDepto
group by d.nombreDpto 
order by sum(e.salEmp) desc
limit 1;





