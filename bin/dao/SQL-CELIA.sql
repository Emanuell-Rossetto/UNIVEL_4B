CREATE database univel;

create table usuario (
	id int primary key,
	nome_usuario varchar(64),
	senha_hash varchar(64),
	data_criacao datetime
);
