--5)Liste o nome do empregado, o nome do gerente, e o departamento de cada um.
Select E.NomeEmpregado as Nome_Empregado,
	   E1.NomeEmpregado as Nome_Gerente,
	   D.NomeDepartamento as Departaemnto
From Empregado E, Empregado E1, Departamento D
Where E.IDGerente = E1.IDEmpregado AND E.IDDepartamento = D.IDDepartamento


---6)Fa�a uma c�pia da tabela Empregado e altere o sal�rio de todos os empregados
--   que o departamento fique na localidade de SAO PAULO, fa�a um reajuste de 14,5%
Begin transaction
Select * into EmpregadoAux from Empregado
update EmpregadoAux
set Salario = (Salario * 1.145)
Where IDDepartamento IN (Select IDDepartamento From Departamento Where Localizacao = 'SAO PAULO')
commit

--7)Liste a diferen�a que representar� o reajuste aplicado no item 
--  anterior no somat�rio dos sal�rios de todos os empregados.
Select Sum(E.Salario) as Montante_Original, Sum(EA.Salario) as Montante_Ajustado,
	   (Sum(EA.Salario) -  Sum(E.Salario)) as Diferenca
From Empregado E, EmpregadoAux EA


--8)Liste o departamento que possui o empregado de maior sal�rio.
Select top 1 D.NomeDepartamento, Max(E.Salario) as Maior_Salario
From Departamento D, Empregado E
Where E.IDDepartamento = D.IDDepartamento
Group by D.NomeDepartamento
Order by Maior_Salario desc



Select Max(Salario)
From Empregado