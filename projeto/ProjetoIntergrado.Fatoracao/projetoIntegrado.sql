create database projetoIntegrado;
drop database projetoIntegrado;
use projetoIntegrado;



create table prato
(
codigo int AUTO_INCREMENT,
tipo varchar(40),
preco double,
primary key (codigo)
);



create table portugues
(
codigo int  AUTO_INCREMENT ,
numPrato int,
descricao varchar(40),
disponivel varchar(40),
primary key (codigo),
foreign key (numPrato) references prato(codigo)
);

create table ingles
(
codigo int  AUTO_INCREMENT ,
numPrato int,
descricao varchar(40),
disponivel varchar(40),
primary key (codigo),
foreign key (numPrato) references prato(codigo)
);

create table espanhol
(
codigo int  AUTO_INCREMENT , 
numPrato int,
descricao varchar(40),
disponivel varchar(40),
primary key (codigo),
foreign key (numPrato) references prato(codigo)
);

create table pedido
(
codigo int  AUTO_INCREMENT, 
numSeq int, 
mesa int,
garçom varchar(40),
dataEntrada varchar(40),
horaEntrada varchar(40),
horaSaida varchar(40),
pago int,
ordem int,
primary key (codigo)
);

create table item_pedido
(
codigo int  AUTO_INCREMENT ,
numPedido int, 
numPrato int, 
quantidade int,
finalizado int,
primary key (codigo),
foreign key (numPedido) references pedido(codigo),
foreign key (numPrato) references prato(codigo)
);

create table extrato
(
codigo int AUTO_INCREMENT,
precoTotal double,
permanenciaCliente varchar(40),
dataCliente varchar(40),
cpf varchar(40),
primary key (codigo)
);


insert into prato values
(1,'pratoEntrada',10.00),
(2,'pratoEntrada', 15.00 ),
(3,'pratoEntrada', 16.00),
(4,'pratoEntrada', 11.00),
(5,'pratoEntrada', 21.00),

(6,'pratoPrincipal', 36.00),
(7,'pratoPrincipal', 12.00),
(8,'pratoPrincipal', 13.00),
(9,'pratoPrincipal', 14.00),
(10,'pratoPrincipal', 11.00),

(11,'bebida', 16.00),
(12,'bebida', 27.00 ),
(13,'bebida', 18.00),
(14,'bebida', 29.00 ),
(15,'bebida', 15.00),

(16,'sobremesa', 12.00),
(17,'sobremesa', 6.00),
(18,'sobremesa', 15.00),
(19,'sobremesa', 11.00),
(20,'sobremesa', 20.00);


insert into portugues  values
(1,1,'Salada de Rosbife','Disponivel'),
(2,2,'Casquinha de Siri','Indisponivel'),
(3,3, 'Batata Hasselback', 'Disponivel'),
(4,4, 'Aspargos com Presunto de Parma','Disponivel'),
(5,5, 'Bolinho de Arroz com Parmesão','Disponivel'),

(6,6, 'Lasanha','Disponivel'),
(7,7, 'Arroz à grega', 'Indisponivel'),
(8,8, 'Risoto de frutos do mar','Disponivel'),
(9,9, 'Bacalhau a Brás','Disponivel'),
(10,10, 'Bife de Chorizogrelhado','Disponivel'),


(11,11, 'Vinho', 'Disponivel'),
(12,12, 'Suco de laranja','Disponivel'),
(13,13, 'Refrigerante','Indisponivel'),
(14,14, 'Suco de maracuja','Disponivel'),
(15,15, 'Suco de Abacaxi','Disponivel'),

(16,16, 'Mousse de maracuja','Disponivel'),
(17,17,'Bolo de chocolate','Disponivel'),
(18,18, 'Petit gateau com sorvete','Disponivel'),
(19,19, 'Pudim de Leite','Disponivel'),
(20,20, 'Tempura de negresco com sorvete de creme','Disponivel');


insert into ingles  values
(1,1,'Salad of roast beef','Available'),
(2,2,'Casquinha Siri', 'Indisponible'),
(3,3, 'Potato Hasselback','Available'),
(4,4,  'Asparagus with Parma ham', 'Available'),
(5,5, 'Rice Cake with Parmesan','Available'),


(6,6,  'Lasagna','Available'),
(7,7, 'Pilaf', 'Indisponible'),
(8,8,'Seafood risotto', 'Available'),
(9,9,'Codfish Brás', 'Available'),
(10,10, 'Steak Chorizogrelhado','Available'),

(11,11, 'Wine', 'Available'),
(12,12, 'Orange juice', 'Available'),
(13,13, 'Refrigerant', 'Indisponible'),
(14,14, 'Passion fruit juice', 'Available'),
(15,15, 'Pineapple juice','Available'),

(16,16, 'Passion fruit mousse', 'Available'),
(17,17,'Chocolate cake', 'Available'),
(18,18, 'Petit gateau with chocolate ice cream','Available'),
(19,19, 'Milk Pudding', 'Indisponible'),
(20,20, 'Negresco tempura with ice cream','Available');

insert into espanhol  values
(1,1,'Ensalada de carne asada','Disponible'),
(2,2,'Casquinha Siri','Unavailable'),
(3,3, 'Hasselback Patata','Disponible'),
(4,4,'Espárragos con jamón de Parma','Disponible'),
(5,5, 'Pastel de arroz con queso parmesano','Disponible'),

(6,6,  'Lasaña', 'Disponible'),
(7,7, 'Arroz a la Griega', 'Unavailable'),
(8,8, 'Risotto de marisco','Disponible'),
(9,9, 'bacalao a brás','Disponible'),
(10,10, 'filete Chorizogrelhado','Disponible'),

(11,11, 'Vino', 'Unavailable'),
(12,12, 'Jugo de naranja', 'Disponible'),
(13,13, 'Refrigerante',  'Disponible'),
(14,14, 'Jugo de maracuyá','Disponible'),
(15,15, 'Jugo de piña', 'Disponible'),

(16,16, 'mousse de maracuyá', 'Disponible'),
(17,17,'Pastel de chocolate', 'Disponible'),
(18,18, 'Tarta de petit con helado de chocolate', 'Unavailable'),
(19,19, 'arroz con leche','Disponible'),
(20,20, 'Tempura con helado Negresco', 'Disponible');


select * from prato where tipo = 'bebida';
select * from espanhol where numPrato = 5;
select * from prato;
select * from portugues;
select * from ingles;


Insert into prato (tipo,preco) values ('aaa',3);
SELECT MAX(codigo) FROM prato;

update prato set tipo='pratoPrincipal', preco=3000 where codigo=1;
update portugues set descricao='alalaa', disponivel='disponivell' where numPrato=1;


select * from pedido; 
select* from item_pedido ;
select * from item_pedido where numPedido =197;
select * from pedido where numSeq= 26;
select * from item_pedido where numPedido=2;
select * from portugues where numPrato=3;
select * from prato where codigo =3;
delete from item_pedido where numPedido =4;
update item_pedido set finalizado=1 where codigo=13;


select 
    por.descricao,
    item.quantidade,
    pra.preco,
       ped.mesa
from   item_pedido item
inner join portugues por on  por.numPrato = item.numPrato 
inner join prato pra on  pra.codigo  =  por.numPrato 
inner join pedido ped  on ped.codigo = item.numPedido 
where ped.mesa = 2;

select item.codigo,
       por.descricao,
       item.quantidade,
       pra.preco,
       ped.numSeq,
       ped.mesa
from item_pedido item
inner join prato pra on item.numPrato= pra.codigo 
inner join portugues por on pra.codigo= por.numPrato
inner join pedido ped on  item.numPedido = ped.codigo
where numSeq = 783;

-- consultar item_pedido
select item.codigo,
       por.descricao,
    item.quantidade,
       pra.preco,
       ped.numSeq,
       item.finalizado,
       ped.mesa
from item_pedido item
inner join prato pra on item.numPrato= pra.codigo 
inner join portugues por on pra.codigo= por.numPrato
inner join pedido ped on item.numPedido = ped.codigo
where numSeq = 198;

-- Extrato
select item.quantidade,
    por.descricao,
    pra.preco,
       ped.mesa,
       ped.horaEntrada,
       ped.horaSaida
from   item_pedido item
inner join portugues por on  por.numPrato = item.numPrato 
inner join prato pra on  pra.codigo  =  por.numPrato 
inner join pedido ped  on ped.codigo = item.numPedido 
where ped.mesa = 1 and pago=0;

select codigo, descricao from portugues where numPrato in(select codigo from prato where tipo = 'bebida'); 
Insert into item_pedido(numPedido,numPrato,quantidade,finalizado) values ((select codigo from pedido where numSeq=198),2,12,0);

-- quantidade
select descricao, sum(quantidade) as total,pra.preco
from portugues
inner join item_pedido on portugues.codigo = item_pedido.numPrato
inner join prato pra on (item_pedido.numPrato = pra.codigo)
group by descricao 
order by total desc;

-- preço
select descricao, sum(quantidade) as quantidade,(sum(quantidade)*preco) as precoTotal
from portugues
inner join item_pedido on portugues.codigo = item_pedido.numPrato
inner join prato pra on (item_pedido.numPrato = pra.codigo)
group by descricao
order by precoTotal desc;


-- tabela item pedido
select item.codigo, item.quantidade, portu.descricao,pra.preco
from item_pedido item
inner join prato pra on item_pedido.numPrato= prato.codigo 
inner join portugues portu on prato.codigo= portugues.numPrato
where numSeq=224;


-- select carregar tela alterar
 select codigo, descricao from portugues where numPrato in ( 
 select codigo from prato where tipo in (
 select tipo from prato where codigo in (
 select numPrato from item_pedido where codigo = 3)) ) ;


select * from pedido where mesa= 1 and pago=0;
delete from pedido where codigo=2 and pago=1;
select * from pedido;
select *from item_pedido;
select * from extrato;

select horaEntrada from pedido where mesa=1 limit 1;
select horaEntrada from pedido where mesa=1 and pago=0 limit 1 ;
update item_pedido set numPrato=1,quantidade=2 where codigo=1 and numPedido in(select codigo from pedido where pago=0);
select * from item_pedido where  codigo= 1 and numPedido in(select codigo from pedido where pago=0);
delete item from item_pedido item  inner join pedido ped on ped.codigo=item.numPrato
where item.codigo = 2 and ped.pago=0;
delete from item_pedido where codigo = 1 and numPedido in(select codigo from pedido where pago=0);
update pedido set horaSaida='aa' where mesa=1 and  pago=0;
SELECT SUBSTRING('Olá, tudo bem com você?', 6, 8);
-- SUBSTRING( horaEntrada, 1, 2);

SELECT SUBSTRING( horaEntrada, 1, 2) as hora, count(*) as quant
FROM pedido
WHERE dataEntrada = '2016-10-15'
group By hora
order by quant desc
limit 1
;

select SUBSTRING(horaEntrada, 1, 2) as hora, count(*) as quant
from pedido 
-- where dataEntrada = '2016-10-15'
group By hora
order by quant desc
limit 1;
SELECT * from extrato where cpf!='';
select * from pedido where mesa= 1 and pago=0;
delete from item_pedido where numPedido =( select codigo from pedido where numSeq=218 and pago=0);
delete from pedido where codigo =6;
select * from item_pedido;
update item_pedido set numPrato=1,quantidade=1 where codigo=2 and numPedido in(select codigo from pedido where pago=0);
update pedido set pago = ((select count(codigo)from pedido)+1) where codigo=2;
select * from pedido where pago=0 order by  ordem desc;
drop table pedido;
drop table item_pedido;
select  from portugues where numPrato= ?
