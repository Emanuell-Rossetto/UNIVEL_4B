use univel;

create table produtos(
    id int primary key auto_increment,
    nome varchar(50),
    preco float(6,2),
    marca varchar(50);
)

alter table usuarios add column email varchar(50);