Create table Empregado
(
	IDEMpregado int NOT NULL,
	Nome varchar(50) NOT NULL,
	Sexo char(1) NOT NULL,
	IDCidade int NOT NULL,
	constraint PK_Empregado Primary Key (IDEmpregado),
	constraint CC_Empregado_Sexo Check(Sexo in('F', 'M')),
	constraint FK_Empregado_Cidade Foreign Key (IDCidade) References Cidade(IDCidade)
);