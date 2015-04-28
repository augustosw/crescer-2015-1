--1) Identifique e liste quantos valores diferentes estão definidos para a coluna 
--   Situacao da tabela Produto (somente os distintos valores).
select Situacao, count (1) as Quantidade
from Produto
group by Situacao
--2) Liste todos os clientes que tenham o LTDA no nome ou razao social.
select Nome, RazaoSocial 
from Cliente 
Where Nome LIKE '%Ltda%' OR RazaoSocial LIKE '%Ltda%'


--3) Crie (insira) um novo registro na tabela de Produto, com as seguintes informações:
--   Nome: Galocha Maragato
--   Preço de custo: 35.67
--   Preço de venda: 77.95
--   Situação: A
Begin transaction
insert into Produto(Nome, DataCadastro, PrecoCusto, PrecoVenda, Situacao) 
values('Galocha Maragato', GETDATE(), 35.67, 77.95, 'A')
commit

select * from Produto
where Nome like 'Galocha Maragato'

-- 4) Identifique e liste os produtos que não tiveram nenhum pedido, 
--    considere os relacionamentos no modelo de dados, pois não há relacionamento 
--    direto entre Produto e Pedido (será preciso relacionar PedidoItem).
--    Obs.: o produto criado anteriormente deverá ser listado.
Select IDProduto, Nome, Situacao
From Produto
Where IDProduto not in(select P.IDProduto  
					   from Produto P, PedidoItem Pitem
					   where P.IDProduto = Pitem.IDProduto)

CREATE INDEX IX_Pedido_Produto ON PedidoItem (IDProduto);

--5) Identifique qual o estado (coluna UF da tabela Cidade) possuí o maior 
--   número de clientes (tabela Cliente), liste também qual o Estado possuí o menor número de clientes.
--   Dica: pode (não é obrigatório) ser utilizado subquery, e também UNION.
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


create index IX_Cidade_Cliente ON Cliente(IDCidade);


--6) Liste o total de cidades (distintas) que possuem clientes que realizaram algum pedido.
--   Dica: será preciso relacionar Cidade com Cliente, e Cliente com Pedido.
Select count(distinct Ci.Nome) as TotalCidades
from Cliente C INNER JOIN Pedido P ON C.IDCliente = P.IDCliente
		      INNER JOIN Cidade Ci ON C.IDCidade = Ci.IDCidade


select Count(distinct Nome) as TotalCidades
From Cidade
Where EXISTS (Select 1
			  From Cliente Cli
				   inner join Pedido Ped on Ped.IDCliente = Cli.IDCliente
			  Where Cli.IDCidade = Cidade.IDCidade)

--7) Dentro da atual estrutura, cada produto é composto por 1 ou vários materiais 
--   (tabela ProdutoMaterial). Identifique se existe algum produto sem material relacionado.
--   Obs.: o produto criado anteriormente deverá ser listado.



--8) Liste os produtos, com seu preço de custo, e relacione com seus os materiais 
--   (ProdutoMaterial), e liste também o somatório do PrecoCusto de todos seus materiais. 
--   Veja um exemplo abaixo: IDProduto    Produto     Preco Custo R$     Preco Custo Materiais R$
--                            1589      Chin Palm3940        883,74                1.092,02
--                            2253    Salg Plops Presunto    370,88                  823,03
--                            3581   Garrafa Madri Rolha     872,43                1.469,31


--9) Após identificar o preço de custo dos produtos e seus materiais será preciso acertar os
-- produtos que estão com o valor de custo inferior ao custo dos materiais. 
-- Pra isso faça uma alteração (update) na tabela de Produtos, definindo o PrecoCusto, 
-- para que fique igual ao custo dos seus materiais.



-- 10) Liste os clientes que tenham o mesmo nome (Tabela Cliente, registros com o nome (apenas) duplicado).



--11) Lista qual o primeiro nome mais popular entre os clientes, considere apenas o primeiro nome.



--12) Liste qual o produto é mais vendido (considere a informação da quantidade).