--2)Liste as cidades com nome e UF duplicados que tenham clientes relacionados.
BEGIN
	DECLARE ListaCidade CURSOR
	Local
	Fast_Forward

	FOR select Nome, UF
		from Cidade
		where IDCidade in (Select Distinct IDCidade 
		                   From Cliente)
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
