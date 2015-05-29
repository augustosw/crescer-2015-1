var desmarcar = function(elemento, idFilme){
	$(elemento).prevAll().prop('checked', false);
	$(elemento).nextAll().prop('checked', false);
	postarAvaliacao(elemento, idFilme)
};

var postarAvaliacao = function(elemento, idFilme){
	var rate = $(elemento).val();
	var url = '/avaliar?rating='+rate+'&idFilme='+idFilme;
	$.ajax({
		url: url,
		type: 'POST'
	}).done(function(resultado){
			$('#media' + idFilme).html(resultado);
		});
};

var getAvaliacao = function(idFilme){
	var url = '/getAvaliacao?idFilme='+idFilme;
	$.ajax({
		url: url,
		type: 'GET'
	}).done(function(resultado){
			$('#nota'+resultado+'_'+idFilme).prop('checked', true);
		});
};

var getMedias = function(){
	var url = '/getMedias';
	$.ajax({
		url: url,
		type: 'GET'
	}).done(function(resultado){
			resultado.forEach(function(item){
				var filme = item.idFilme;
				$('#media' +filme).html(item.nota);
			});
		})	
}


var getAvaliacoes = function(){
	var url = '/getAvaliacoes';
	$.ajax({
		url: url,
		type: 'GET'
	}).done(function(resultado){
			resultado.forEach(function(item){
				var filme = item.idFilme;
				var nota = item.nota;
				$('#nota'+nota+'_'+filme).prop('checked', true);
			});
		});
};