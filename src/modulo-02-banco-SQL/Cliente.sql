Create table Cliente
(
	IDCliente int IDENTITY NOT NULL,
	Nome varchar(30) NOT NULL,
	Endereco varchar(35),
	Bairro varchar(35),
	IDCidade int	
);

INSERT INTO Cliente(Nome, Endereco, Bairro) 
VALUES('Maria', 'Rua Bento GOnçalves, 123', 'Centro');

