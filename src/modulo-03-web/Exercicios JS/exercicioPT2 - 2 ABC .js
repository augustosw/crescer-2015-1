function Emprestimo(valorTotal, taxaJuros, quantidadeParcelas) {

  this.valorTotal = valorTotal;
  this.taxaJuros = taxaJuros;
  this.quantidadeParcelas = quantidadeParcelas || 3;
  
  
  this.valorParcela = function(){
		valorPar = 0.00;
		
		valorPar = (this.valorTotal * this.taxaJuros) / (1 - (1 / (Math.pow((1 + this.taxaJuros), this.quantidadeParcelas))));
		
		
		return parseFloat(valorPar.toFixed(2));
  }
  
  this.valorTotalJuros = function(){
		valorPar = this.valorParcela();
		valorJuros = (valorPar * this.quantidadeParcelas) - this.valorTotal;
		
		return parseFloat(valorJuros.toFixed(2));
  }
} 



 var emprestimo = new Emprestimo(1000, 0.03, 4);
 console.log(emprestimo.valorTotal); // 1000

 var emprestimo2 = new Emprestimo(500, 0.05});
 console.log(emprestimo2.quantidadeParcelas); // 3
 
 
 [
    { emprestimo: new Emprestimo(1000, 0.03, 4),  esperado: 269.03 },
    { emprestimo: new Emprestimo(1800, 0.05, 8}),  esperado: 278.5 },
    { emprestimo: new Emprestimo(500, 0.05),      esperado: 183.6 },
  ].forEach(
    function(ct) {
      var res = ct.emprestimo.valorParcela();
      console.assert(res === ct.esperado, 'Errooooou! CT:', ct.emprestimo, 'Esperado:', ct.esperado, 'Obtido:', res);
    }
  );
  
  
  [
    { emprestimo: new Emprestimo(1800, 0.13, 8),  esperado: 1200.8 },
    { emprestimo: new Emprestimo(1000, 0.03, 4),  esperado: 76.12 },
    { emprestimo: new Emprestimo(500, 0.05}),      esperado: 50.8 },
  ].forEach(
    function(ct) {
      var res = ct.emprestimo.valorTotalJuros();
      console.assert(res === ct.esperado, 'Errooooou! CT:', ct.emprestimo, 'Esperado:', ct.esperado, 'Obtido:', res);
    }
  );