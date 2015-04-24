begin transaction

--3.1) Garantir que a situação tenha somente os valores A ou I.
ALTER TABLE Cliente 
ADD  CONSTRAINT CK_Situacao
CHECK (Situacao in ('A', 'I'));
commit

--3.2)(Pedido) Nenhum pedido poderá ter a data de entrega menor que a data do pedido.
Begin transaction
ALTER TABLE Pedido
ADD CONSTRAINT CK_DataPedido_Maior_Que_DataEntrega
CHECK (DataPedido < DataEntrega);
commit

--3.3)(Pedido) Garantir que a situação tenha somente os seguintes valores: A, C, Q e I.
begin transaction
ALTER TABLE Pedido
ADD  CONSTRAINT CK_Situacao_Pedido
CHECK (Situacao in ('A', 'C', 'Q', 'I'));
commit

--3.4)(PeditoItem) A quantidade não pode ser igual ou menor que zero.
begin transaction
ALTER TABLE PedidoItem
ADD CONSTRAINT CK_Quantidade_Maior_Que_Zero
CHECK (Quantidade > 0)



--3.5)(PeditoItem) Garantir que a situação tenha somente os seguintes valores: A, C, Q e I.