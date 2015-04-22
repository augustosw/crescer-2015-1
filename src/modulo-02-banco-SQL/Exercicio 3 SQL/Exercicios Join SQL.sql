--1)Selecione o nome do empregado e nome do departamento que cada um está associado.
	select e.NomeEmpregado, d.NomeDepartamento
	from Empregado e, departamento d
	where e.IDDepartamento = d.IDDepartamento

-- 2)Exibir o nome do associado e sua cidade, exibir também associados sem Cidade relacionada.
	select a.Nome as Nome_Associado, c.Nome as Nome_Cidade
	from Associado a left join Cidade c on a.IDCidade = c.IDCidade

-- 3)Lista os estados (UF) e total de cidades que não possuem associados relacionados 
--   (dica: pode ser utilizado count + group by + exists).
	select distinct c.UF, count(c.nome) as Quantidade
	from Cidade c
	where not exists (Select 1 from Associado a where c.IDCidade = a.IDCidade)
	group by c.UF

-- 4)Faça uma consulta que liste o nome do associado, o nome da cidade, 
--   e uma coluna que indique se a cidade é da região SUL (RS, SC, PR), 
--   se for imprimir *** (3 asteriscos), senão imprimir nulo.
	select A.Nome, C.Nome, Case when 
							C.UF = 'RS' OR
							C.UF = 'SC' OR
							C.UF = 'PR' then '***'
							else null
							end as Coluna_Regiao
	from Associado A left join Cidade C on a.IDCidade = C.IDCidade



