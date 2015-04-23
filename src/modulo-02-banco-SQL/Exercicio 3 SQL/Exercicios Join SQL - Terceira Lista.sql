--9)Faça uma consulta para exibir o nome de cada associado e sua cidade e 
--juntamente com os empregados (nome) e a cidade (localidade) de seu departamento, 
--isto deve ser exibido em uma consulta.
Select A.Nome as Nome,
	   C.Nome as Nome_Cidade
From Associado A, Cidade C
Where A.IDCidade = C.IDCidade
UNION ALL
Select E.NomeEmpregado, 
	   D.Localizacao
From Empregado E, Departamento D
Where E.IDDepartamento = D.IDDepartamento


--10)Lista as cidades que tenham associado relacionado.
Select C.IDCidade, C.Nome
From Cidade C, Associado A
Where A.IDCidade = C.IDCidade