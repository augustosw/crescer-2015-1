select top 1 nome 
from Associado;

select nome, DATEDIFF(YEAR, DataNascimento, GETDATE()) as Idade
from Associado;

select NomeEmpregado, DATEDIFF(MONTH, DataAdmissao, convert(datetime, '2000/12/31', 111)) as Meses_Trabalhados
from Empregado
where DataAdmissao between convert(datetime, '1980/05/01', 111) AND convert(datetime, '1982/01/20', 111)


select top 1 Cargo, count(Cargo) as Maximo
from Empregado
group by Cargo
order by Maximo desc

select Nome
from Associado
order by LEN(nome) desc



