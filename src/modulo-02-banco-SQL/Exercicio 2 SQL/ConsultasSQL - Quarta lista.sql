--11)Altere todas cidades duplicadas (nome e uf iguais), 
--   acrescente no ínicio do nome um asterisco (*).
Update Cidade
set Nome = '*' + Nome
where Nome IN (Select Nome 
			   from Cidade
			   Group by Nome, UF
			   having count(1) > 1)


--12)Faça uma consulta que liste o nome do Associado e a descrição da coluna Sexo, 
--   informando: Masculino ou Feminino.
Select Nome, 
       Case Sexo
	   When 'M' then 'Masculino'
	   When 'F' then 'Feminino'
	   Else 'Outro'
	   End Genero
From Associado


--13)Faça uma consulta que mostre o nome do empregado, o Salario e 
--   percentual a ser descontado do Imposto de Renda, considerando a tabela abaixo:
--   Até R$ 1.164,00 = 0%De R$ 1.164,00 a R$ 2.326,00 = 15%
--   Acima de R$ 2.326,00 = 27,5%.
Select NomeEmpregado,
	   Salario,
	   Case When Salario > 1164 AND Salario <= 2326 then (Salario*0.15)
		    When Salario > 2326 then (Salario * 0.275)
		    else 0
	   End Desconto_IR
From Empregado

--14)Elimine as cidades duplicadas (mantendo 1 registro para cada).
Begin Transaction

Delete From Cidade
Where IDCidade IN (Select MAX(IDCIdade)
				   From Cidade
				   Group by Nome, UF
				   Having count(1) > 1)

commit


--15)Adicione uma regra que impeça exista mais de uma cidade com o mesmo nome em um estado.
Alter table Cidade
	add constraint UK_Cidade_NomeUF
	unique (Nome, UF);


