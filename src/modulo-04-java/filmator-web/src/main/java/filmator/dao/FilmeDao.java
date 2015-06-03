package filmator.dao;

import java.sql.ResultSet;
import java.text.Normalizer;
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
	
	public void excluir(int idFilme){
		jdbcTemplate.update("DELETE FROM Avaliacao WHERE idFilme = ?", idFilme);
		jdbcTemplate.update("DELETE FROM Filme WHERE idFilme = ?", idFilme);		
	}

	public List<Filme> buscaTodosFilmes(){
		return jdbcTemplate.query("SELECT idFilme, nome, genero, ano_lancamento, sinopse, imagem FROM Filme", (ResultSet rs, int rowNum) -> {	
			int idFilme = rs.getInt("idFilme");
			String nome = rs.getString("nome");
			Genero genero = Genero.valueOf(rs.getString("genero"));
			int ano_lancamento = rs.getInt("ano_lancamento");
			String sinopse = rs.getString("sinopse");
			String imagem = rs.getString("imagem");
			Filme filme = new Filme(idFilme, nome, genero, ano_lancamento, sinopse, imagem);
			return filme;
		});	
	}
	
	public List<Filme> buscaFilmes(String busca){
		busca = Normalizer.normalize(busca, Normalizer.Form.NFD);
		busca = busca.replaceAll("[^\\p{ASCII}]", "");
		busca = "%"+busca+"%";
		return jdbcTemplate.query("SELECT idFilme, nome, genero, ano_lancamento, sinopse, imagem FROM Filme WHERE lower (nome) like lower(?) OR lower (genero) like lower (?) OR lower (ano_lancamento) like lower (?) OR idFilme like ?", (ResultSet rs, int rowNum) -> {	
			int idFilme = rs.getInt("idFilme");
			String nome = rs.getString("nome");
			Genero genero = Genero.valueOf(rs.getString("genero"));
			int ano_lancamento = rs.getInt("ano_lancamento");
			String sinopse = rs.getString("sinopse");
			String imagem = rs.getString("imagem");
			Filme filme = new Filme(idFilme, nome, genero, ano_lancamento, sinopse, imagem);
			return filme;
		}, busca, busca, busca, busca);	
	}
	
	
	private String erros = "";
	public boolean validaFilme(Filme filme) {
		erros = "";
		if(filme.getNome() == null) erros += "-Nome Nulo! ";
		if(filme.getNome().trim() == "") erros += "-Nome Vazio! ";
		if(filme.getAno() < 1930) erros += "-Ano Inválido (Minimo: 1930) ";
		if(filme.getSinopse().trim() == "") erros += "-Sinopse Vazia! ";
		
		if(erros == "")return true;
		return false;
	}
	public String getErros() {
		return erros;
	}	
}