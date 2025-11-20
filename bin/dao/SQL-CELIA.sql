use univel;

CREATE database univel;

create table usuario (
	id int primary key,
	nome_usuario varchar(64),
	senha_hash varchar(64),
	data_criacao datetime
);


create table produtos(
    id int primary key auto_increment,
    nome varchar(50),
    preco float(6,2),
    marca varchar(50)
);

alter table usuarios add column email varchar(50);