create table if not exists pedido(
	RefPed char(5) primary key,
    FecPed date not null
);

show tables;
desc Articulo;

create table if not exists Articulo(
	CodArt char(5) primary key,
    DesArt varchar(30) not null,
    PVPArt float not null
		constraint ch_PVPArt check (PVPArt > 0)
);

create table if not exists LineaPedido(
	RefPed char(5),
    CodArt char(5),
	CantArt int not null default 1
		constraint ch_CantArt check (CantArt > 0),
	constraint pk_LineaPedido primary key(RefPed, CodArt),
    constraint fk_RefPed_LineaPedido foreign key(RefPed) references pedido(RefPed) on update cascade,
    constraint fk_CodArt_LineaPedido foreign key(CodArt) references Articulo(CodArt) on update cascade
);



