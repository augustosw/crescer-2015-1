--6)Fa�a uma consulta que retorne o nome do associado
--  e a data de quando cada completar� (ou completou) 50 anos, liste tamb�m o dia da semana.
	select Nome, convert(date, (dateadd(YEAR, 50, DataNascimento))) as Data_50_Anos,
		   datename(dw, dateadd(YEAR, 50, DataNascimento)) as Dia_Semana
	from Associado
	
--7)Liste a quantidade de cidades agrupando por UF.
	select UF, count(1) Numero_Cidades
	from Cidade
	group by UF


--8)Liste as cidades que possuem o mesmo nome e UF.
	select Nome, UF
	from Cidade
	group by Nome, UF
	having count(1) > 1

--9)Identifique qual deve ser o pr�ximo ID para a 
--  cria��o de um novo registro na tabela Associado (maior + 1).
	select max(IDAssociado)+1
	from Associado

--10)Limpe a tabela CidadeAux, e insira somente as cidades com nomes e UF�s distintos, 
--	 considere somente o menor c�digo ID das cidades duplicadas.
	truncate table CidadeAux;
	insert into CidadeAux(Nome, IDCidade, UF) select distinct Nome, IDCidade, UF from Cidade;

	select Nome, UF, count(1)
	from CidadeAux
	group by Nome, UF
	having count(1) > 1

	insert into CidadeAux(IDCidade, Nome, UF) 
select IDCidade, Nome, UF from Cidade;