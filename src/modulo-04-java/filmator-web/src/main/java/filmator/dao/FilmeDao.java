package filmator.dao;

import java.io.File;
import java.sql.ResultSet;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import filmator.model.Filme;
import filmator.model.Genero;

@Component
public class FilmeDao {

	@Inject
	private JdbcTemplate jdbcTemplate;
	
	
	public void inserir(Filme filme){
	    String nome = filme.getNome();
		String genero = filme.getGenero().name();
		int ano_lancamento = filme.getAno();
		String sinopse = filme.getSinopse();
		String imagem = filme.getImagem();
		jdbcTemplate.update("INSERT INTO Filme (nome, genero, ano_lancamento, sinopse, imagem) VALUES (?, ?, ?, ?, ?)", nome, genero, ano_lancamento, sinopse, imagem);
	}

	public List<Filme> buscaTodosFilmes(){
		return jdbcTemplate.query("SELECT idFilme, nome, genero, ano_lancamento FROM Filme", (ResultSet rs, int rowNum) -> {	
			int idFilme = rs.getInt("idFilme");
			String nome = rs.getString("nome");
			Genero genero = Genero.valueOf(rs.getString("genero"));
			int ano_lancamento = rs.getInt("ano_lancamento");
			Filme filme = new Filme(idFilme, nome, genero, ano_lancamento);
			return filme;
		});	
	}

	public boolean validaFilme(Filme filme) {
		return true;
	}
	
}