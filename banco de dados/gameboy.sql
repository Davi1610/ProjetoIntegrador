create database gameBoy;
use gameBoy;

-- Criação de tabelas
create table clientes(
   idCli int primary key auto_increment,
   nome varchar(150) not null,
   cpf varchar(20) unique not null,
   email varchar(60),
   fone1 varchar(15) not null,
   fone2 varchar(15),
   cep varchar(10) not null,
   endereco varchar(200) not null,
   numero varchar(10) not null,
   complemento varchar(5),
   bairro varchar(150) not null,
   cidade varchar(150) not null
);

create table usuarios(
   idUsu int primary key auto_increment,
   usuario varchar(50) not null,
   login varchar(60) not null unique,
   senha varchar(250) not null
   
);
select * from usuarios;


create table tbOs(
   idOs int primary key auto_increment,
   modeloConsole varchar(250) not null,
   defeito varchar(250) not null,
   obs varchar(250) not null,
   diagnosticoTec varchar(250),
   dataos timestamp default current_timestamp,
   statusos varchar(50) not null,
   valor decimal(10,2),
   idCli int not null,
   foreign key(idCli) references clientes (idCli)
   );

-- Verificar tabelas 
show tables;
describe usuarios;
describe clientes;
describe tbOs;

-- Cadastro de usuarios
insert into usuarios (usuario, login, senha)
values ('José de Assis','jose@email.com',md5('123@senac')); 

insert into usuarios (usuario, login, senha)
values ('Edilson Silva','edilson@js.com',md5('senac@123'));

insert into usuarios (usuario, login, senha)
values ('Kelly Cristina','kelly@email.com',md5('senac@456'));

select * from usuarios;


-- Cadastro de clientes
insert into clientes (nome,cpf, email, fone1, fone2, cep, endereco, numero,complemento, bairro, cidade) 
values ('Davi Fonseca', '000.000.000.00', 'davi@email.com', '11111-1111','22222-2222','00000-000','Rua Espirito Santo','80','B','Jardim Castelo Branco','Poá');

insert into clientes (nome,cpf, email, fone1, fone2,cep, endereco, numero,complemento, bairro, cidade) 
values ('José Walace', '111.111.111.11', 'jose@email.com', '11111-2222','22222-3333','11111-111','Rua São Paulo','90','A','Jardim Anchieta','Ferraz de Vasconcelos');

insert into clientes (nome,cpf, email, fone1, fone2,cep, endereco, numero,complemento, bairro, cidade) 
values ('Maxswell Diniz', '222.222.222.22', 'max@email.com', '11111-3333','22222-4444','22222-222','Rua Rouxinol','180','','Bairro São João','Suzano');

select * from clientes;


-- Ordem de Serviço (OS)
insert into tbOS (modeloConsole,defeito,obs, diagnosticoTec, statusos, valor,idCli)
values ('PS4','Parou de ligar','aparelho com arranhões','Quando liga se sente um cheiro de queimado','aprovado',300.00,1);

insert into tbOS (modeloConsole,defeito,obs, diagnosticoTec, statusos, valor,idCli)
values ('Nintendo Switch','Esquentando muito e desligando sozinho','aparelho fazendo um som incomum e alto','Aquecendo muito','Aguardando aprovação do cliente',500.00,3);

select * from tbOS;
drop database gameBoy;