--1)-----

Select top 1 with ties 
	   PedidoItem.IDPRoduto, 
	   Produto.Nome,
	   SUM(Quantidade) Total_Itens
From PedidoItem 
     inner join Produto on Produto.IDProduto = PedidoItem.IDProduto
Group by PedidoItem.IDProduto, Produto.Nome
Order by Total_Itens desc



--2)Liste as cidades com nome e UF duplicados que tenham clientes relacionados.
BEGIN
	DECLARE ListaCidade CURSOR
	Local
	Fast_Forward

	FOR select Nome, UF
		from Cidade
		group by Nome, UF
		having count(1) > 1;

	DECLARE @vNome varchar(50),
	@vUF varchar(2)

	OPEN ListaCidade;
		FETCH NEXT FROM ListaCidade INTO @vNome, @vUF

	WHILE (@@FETCH_STATUS=0) BEGIN
		Print @vNome + '/'+@vUF;
		FETCH NEXT FROM ListaCidade INTO @vNome, @vUF
	END

	CLOSE ListaCidade;
	DEALLOCATE ListaCidade;
END



--3)Identifique qual o material é utilizado por mais produtos e em seguida liste a 
--  quantidade de pedidos realizados, com produtos compostos por este material, 
--  liste também o valor total de vendas dos últimos 60 dias.

BEGIN
	Declare @idMaterial int;
	Select top 1 @idMaterial = IDMaterial
	From ProdutoMaterial
	Group by IDMaterial
    order by count(Distinct IDProduto) desc;

	DECLARE ProdutosComMaterial CURSOR
	Local
	Fast_Forward
	FOR Select count(Distinct IDProduto)
	     From ProdutoMaterial
		 Where IDMaterial = @idMaterial;

	Declare @produtos int
	OPEN ProdutosComMaterial;
		FETCH NEXT FROM ProdutosComMaterial INTO @produtos

	WHILE (@@FETCH_STATUS=0) BEGIN
		Print 'Produtos feitos com o material mais usado (id:' +Cast(@idMaterial as Varchar(10)) +'):' +Cast(@produtos as Varchar(10));
		FETCH NEXT FROM ProdutosComMaterial INTO @produtos
	END

	CLOSE ProdutosComMaterial;
	DEALLOCATE ProdutosComMaterial;
END


select SUM(ValorPedido) as ValorTotal
from Pedido Ped
	inner join PedidoItem Item on Item.IDPedido = Ped.IDPedido
	inner join Produto Prod on Prod.IDProduto = Item.IDProduto
	--inner join ProdutoMaterial PM on PM.IDProduto = Prod.IDProduto
where Ped.DataPedido between DATEADD(day, -60, GETDATE()) and GETDATE()
	and Prod.IDProduto in (Select IDProduto from vw_ProdutosUtilizados);

Ped.IDPedido, Item.IDPedidoItem, Prod.IDProduto, Prod.Nome, Item.Quantidade, 

create view vw_ProdutosUtilizados as
Select pro.IDProduto, pro.Nome
	     From Produto pro
		 Where exists (Select 1 
			           from ProdutoMaterial pm
					   where pm.IDProduto = pro.IDProduto
					   and pm.IDMaterial in (Select IDMaterial from vw_produtosMaisUtilizado));


create view vw_produtosMaisUtilizado as
Select top 1 with ties ma.IDMaterial, ma.Descricao, count(distinct pm.IDProduto) as Total
	From Material ma
		inner join ProdutoMaterial pm on pm.IDMaterial = ma.IDMaterial
		inner join Produto pr on pr.IDProduto = pm.IDProduto
	Group by ma.IDMaterial, ma.Descricao
    order by Total desc;