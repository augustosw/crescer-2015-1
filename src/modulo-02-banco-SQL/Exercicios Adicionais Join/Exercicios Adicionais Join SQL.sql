--1) Identifique e liste quantos valores diferentes est�o definidos para a coluna 
--   Situacao da tabela Produto (somente os distintos valores).
select Situacao, count (1) as Quantidade
from Produto
group by Situacao
--2) Liste todos os clientes que tenham o LTDA no nome ou razao social.
select Nome, RazaoSocial 
from Cliente 
Where Nome LIKE '%Ltda%' OR RazaoSocial LIKE '%Ltda%'


--3) Crie (insira) um novo registro na tabela de Produto, com as seguintes informa��es:
--   Nome: Galocha Maragato
--   Pre�o de custo: 35.67
--   Pre�o de venda: 77.95
--   Situa��o: A
Begin transaction
insert into Produto(Nome, DataCadastro, PrecoCusto, PrecoVenda, Situacao) 
values('Galocha Maragato', GETDATE(), 35.67, 77.95, 'A')
commit

select * from Produto
where Nome like 'Galocha Maragato'

-- 4) Identifique e liste os produtos que n�o tiveram nenhum pedido, 
--    considere os relacionamentos no modelo de dados, pois n�o h� relacionamento 
--    direto entre Produto e Pedido (ser� preciso relacionar PedidoItem).
--    Obs.: o produto criado anteriormente dever� ser listado.
Select IDProduto, Nome, Situacao
From Produto
Where IDProduto not in(select P.IDProduto  
					   from Produto P, PedidoItem Pitem
					   where P.IDProduto = Pitem.IDProduto)


--5) Identifique qual o estado (coluna UF da tabela Cidade) possu� o maior 
--   n�mero de clientes (tabela Cliente), liste tamb�m qual o Estado possu� o menor n�mero de clientes.
--   Dica: pode (n�o � obrigat�rio) ser utilizado subquery, e tamb�m UNION.
select * from MaiorCidade
Union all
select * from MenorCidade

Create view MaiorCidade as
select top 1 C.UF, Count(1) as Quantidade
from Cliente Cli, Cidade C
where Cli.IDCidade = C.IDCidade
group by C.UF
Order by Quantidade desc

Create view MenorCidade as
select top 1 C.UF, Count(1) as Quantidade
from Cliente Cli, Cidade C
where Cli.IDCidade = C.IDCidade
group by C.UF
Order by Quantidade



--6) Liste o total de cidades (distintas) que possuem clientes que realizaram algum pedido.
--   Dica: ser� preciso relacionar Cidade com Cliente, e Cliente com Pedido.
Select distinct Ci.Nome 
from Cliente C INNER JOIN Pedido P ON C.IDCliente = P.IDCliente
		      INNER JOIN Cidade Ci ON C.IDCidade = Ci.IDCidade