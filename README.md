# ProjetoFinalDM110

Messages:

Nomes JNDI das filas ou tópicos JMS:


DM110Projeto - 
java:/jsm/queue/DM110Projeto


persistence: ipdatabase
java:/ipdatabaseDS

create database ipdatabase
create table infoip (
id serial primary key,
ip varchar(50) not null,
status boolean not null
);

create sequence seq_infoip;


EndPoint:

http:<host>/dm110/api/poller/start/{ip}/{mask}


http:<host>/dm110/api/poller/status/{ip}