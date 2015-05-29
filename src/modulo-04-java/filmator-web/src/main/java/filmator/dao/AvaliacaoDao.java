package filmator.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import filmator.model.Filme;
import filmator.model.Genero;

@Component
public class AvaliacaoDao {
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public void avaliarFilme(int idFilme, int idUsuario, int nota){
		jdbcTemplate.update("INSERT INTO Avaliacao(idFilme, idUsuario, nota) values (?, ?, ?)", idFilme, idUsuario, nota);	
	}
	
	public List<Integer> getNotaFilmeUsuario(int idFilme, int idUsuario){
		 return jdbcTemplate.query("SELECT nota FROM Avaliacao WHERE idFilme = ? AND idUsuario = ?", (ResultSet rs, int rowNum) -> {	
			return rs.getInt("nota");
		}, idFilme, idUsuario);
	}
	
	public int getMediaFilme(int idFilme){
		jdbcTemplate.query("SELECT AVG(nota) as media FROM Avaliacao WHERE idFilme = ?", (ResultSet rs, int rowNum) -> {
			return rs.getString(1);
	}, idFilme);
		return 0;
	}
}
