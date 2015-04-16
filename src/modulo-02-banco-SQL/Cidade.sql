drop table Cidade;

Create table Cidade
(
	IDCidade int NOT NULL,
	Nome varchar(30) NOT NULL,
	UF varchar(2) NOT NULL
		constraint PK_Cidade Primary Key(IDCidade),
		constraint UK_Cidade_Nome Unique (Nome)
);