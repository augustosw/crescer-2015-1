select NomeEmpregado as Nome
from Empregado
order by DataAdmissao;


select NomeEmpregado as Nome,
	   (Salario*12) as [Salario Anual]
from Empregado
where Cargo = 'Atendente'
  AND (Salario*12) = 18500;


select IDCidade
from Cidade
where Nome = 'Uberlândia';


select IDCidade, Nome
from Cidade
where UF = 'RS';