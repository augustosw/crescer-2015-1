package filmator.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import filmator.model.Filme;

public class FilmeDao {
	private List<Filme> filmes = new ArrayList<>();
	
	public List<Filme> buscaTodosFilmes(){
		return filmes;
	}
	
	public void adicionaFilme(Filme filme){
		if(validaFilme(filme))
			filmes.add(filme);
	}
	public boolean validaFilme(Filme filme){
		if(filme != null && filme.getNome().trim() != "" && filme.getAno() > 0) 
			return true;
		return false;
	}
}
 