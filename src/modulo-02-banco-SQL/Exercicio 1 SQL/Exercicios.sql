Begin transaction
insert into Associado (IDAssociado, Nome, DataNascimento, Sexo, CPF)
values (5, 'Julio de Castilhos', convert(datetime, '14/12/1947', 103), 'M', '21234567895');

insert into Associado (IDAssociado, Nome, DataNascimento, Sexo, CPF)
values (6, 'Antonio Augusto Borges de Medeiros', convert(datetime, '19/03/1942', 103), 'M', '81234567891');

insert into Associado (IDAssociado, Nome, DataNascimento, Sexo, CPF)
values (7, 'Osvaldo Aranha', convert(datetime, '08/02/1958', 103), 'M', '01234567893');


select * into CidadeAux from Cidade

truncate table CidadeAux;
truncate table Associado;

insert into CidadeAux(IDCidade, Nome, UF) 
select IDCidade, Nome, UF from Cidade;

commit