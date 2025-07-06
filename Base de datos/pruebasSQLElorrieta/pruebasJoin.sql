
use pedidos;

/*
select  l.refped, fecped, l.codart, DesArt, CantArt, PVPArt, round(cantArt * pvpart, 2) 'importe linea' 
from Pedido P join LineaPedido L on P.RefPed = L.RefPed join Articulo A on A.CodArt = L.CodArt 
where fecped > '2018/02/20'
;
*/

		/*en la clausula WHERE*/
/*
select RefPed, L.CodArt, DesArt, CantArt, PVPArt
from LineaPedido L, Articulo A
where L.CodArt = A.CodArt
order by RefPed, L.CodArt;
*/

/*
select  l.refped, fecped, l.codart, DesArt, CantArt, PVPArt, round(cantArt * pvpart, 2) 'importe linea' 
from pedido p , lineapedido l , articulo a
where p.refped = l.RefPed and a.CodArt = l.CodArt and fecped > '2018/02/20';
*/

		/*JOIN USING*/
#Debe tenerse en cuenta que estos atributos en las dos tablas 
#deben tener el mismo nombre; en caso contrario, no es posible combinar ambas tablas usando JOIN USING.
/*
select refped, l.codart, desart, cantart, pvpart
from lineapedido l join articulo a using(codart)
order by refped, l.CodArt;
*/

/*
select  l.refped, fecped, l.codart, DesArt, CantArt, PVPArt, round(cantArt * pvpart, 2) 'importe linea'
from pedido p join lineapedido l using (refped) join articulo a using(codart)
order by refped, 'importe linea' desc;
*/

	/*NATURAL JOIN*/
    
#requiere que los atributos que vinculan las tablas (clave ajena y correspondiente clave primaria) tengan el 
#mismo nombre y, además, que no haya aparte de la clave ajena y correspondiente clave 
#primaria, ningún otro atributo con igual nombre en las tablas que se vinculan
#muy parecido al JOIN USING pero no ahorramos de especificar que atributo une la relacion entre tablas
/*
select RefPed, l.codart, DesArt, cantart, pvpart
from lineapedido l natural join articulo a 
order by refped, l.CodArt;
*/

/*
select P.RefPed, FecPed, A.CodArt, DesArt, CantArt, PVPArt,
round(CantArt * PVPArt,2) "Importe línea"
from pedido p natural join lineapedido l natural join articulo a 
where fecped > '2018/02/20';
*/

			/*LEFT O RIGHT OUTER JOIN*/
/*AÑADIMOS DOS NUEVOS PEDIDOS PARA LOS CUALES NO VAMOS A CREAR LINEAS DE PEDIDO */
/*
INSERT INTO pedido (Refped, fecped)
VALUES
	('P0005', '2019/02/28'),
	('P0007', '2019/02/03');             
            
select p.refped, fecped, codart, cantart
from pedido p left outer join lineapedido l on p.refped = l.RefPed; 
# quiero que me muestre todas las lineas de tabla pedido independiemte si tiene o no tuplas creadas en tabla lineapedido 


select p.refped, fecped, codart, cantart
from lineapedido l  right outer join pedido p on p.refped = l.RefPed;
 #mismo resuiltado ya que he puesto pedido en la segunda tabla, es decir, a la derecha, para que se vea sus filas
*/

            