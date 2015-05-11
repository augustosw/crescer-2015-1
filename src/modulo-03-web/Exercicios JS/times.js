var chelsea = {
  nome: 'Chelsea Football Club',
  titulos: [
    { desc: 'Nacionais', qtd: 5 },
    { desc: 'Continentais', qtd: 1 },
    { desc: 'Mundiais', qtd: 0 }
  ]
};
var manchester = {
  nome: 'Manchester United Football Club',
  titulos: [
    { desc: 'Nacionais', qtd: 20 },
    { desc: 'Continentais', qtd: 3 },
    { desc: 'Mundiais', qtd: 1 }
  ]
};
var liverpool = {
  nome: 'Liverpool Football Club',
  titulos: [
    { desc: 'Nacionais', qtd: 18 },
    { desc: 'Continentais', qtd: 5 },
    { desc: 'Mundiais', qtd: 0 }
  ]
};
var arsenal = {
  nome: 'Arsenal Football Club',
  titulos: [
    { desc: 'Nacionais', qtd: 13 },
    { desc: 'Continentais', qtd: 0 },
    { desc: 'Mundiais', qtd: 0 }
  ]
};

var times = [chelsea, manchester, liverpool, arsenal];

var ordenaPorNacionais = (times.sort(function(a, b) {
		return b.titulos[0].qtd - a.titulos[0].qtd;
	}));

var ordenaPorContinentais = (times.sort(function(a, b) {
		return b.titulos[1].qtd - a.titulos[1].qtd;
	}));

var ordenaPorMuniais = (times.sort(function(a, b) {
	return b.titulos[2].qtd - a.titulos[2].qtd;
}));



var somarPorNacionais = function(i){
	return i.map(function(a){return a.titulos[0].qtd;})
	.reduce(function(a, b){ return a + b;});	
};
var somarPorContinentais = function(i){
	return i.map(funtion(a){return a.titulos[1].qtd;})
	.reduce(function(a, b){ return a + b;});	
};
var somarPorTodos = function(i){
	return i.map(function(a){return a.titulos.map(
							function(b){return b.qtd})
							.reduce(function(d, e){return d + e});})
	.reduce(function(a, b){ return a + b;});								
};

var apenasOsMelhores = function(i){
	var maiores = i.filter(function(a){if(a.titulos[0].qtd > 18){return a;}});
	return maiores;
};

var apenasOsMelhoresParaJSON = function(a){return JSON.stringify(apenasOsMelhores(a));};
var apenasOsMelhoresRecebendoJSON = function(a){ return JSON.parse(apenasOsMelhoresParaJSON(a));};
