package filmator.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import filmator.model.Avaliacao;
import filmator.model.Filme;
import filmator.model.Genero;

@Component
public class AvaliacaoDao {
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public void avaliarFilme(int idFilme, int idUsuario, int nota){
			List<Integer> aval = (List<Integer>)getNotaFilmeUsuario(idFilme, idUsuario);
			if(aval.isEmpty()) insereAvaliacao(idFilme, idUsuario, nota);
			else updateAvaliacao(idFilme, idUsuario, nota);
	}
	
	public List<Integer> getNotaFilmeUsuario(int idFilme, int idUsuario){
		 return jdbcTemplate.query("SELECT nota FROM Avaliacao WHERE idFilme = ? AND idUsuario = ?", (ResultSet rs, int rowNum) -> {	
			return rs.getInt("nota");
		}, idFilme, idUsuario);
	}
	
	public List<Avaliacao> getAvaliacao(int idUsuario){
		return jdbcTemplate.query("SELECT idFilme, nota FROM Avaliacao Where idUsuario = ?", (ResultSet rs, int rowNum) -> {	
			Avaliacao aval = new Avaliacao();
			aval.setIdFilme(rs.getInt("idFilme"));
			aval.setIdUsuario(idUsuario);
			aval.setNota(rs.getInt("nota"));
			return aval;
		}, idUsuario);
	}
	
	private static int nota;
	public int getMediaFilme(int idFilme){
		nota = 0;
		jdbcTemplate.query("SELECT AVG(nota) as media FROM Avaliacao WHERE idFilme = ?", (ResultSet rs, int rowNum) -> {
			nota = rs.getInt(1);
			return rs.getString(1);
	}, idFilme);
		return nota;
	}
	
	public List<Avaliacao> getMedias(){
		return jdbcTemplate.query("SELECT idFilme, AVG(nota) as media FROM Avaliacao GROUP BY idFilme", (ResultSet rs, int rowNum) -> {
			Avaliacao aval = new Avaliacao();
			aval.setIdFilme(rs.getInt("idFilme"));
			aval.setNota(rs.getInt(2));
			return aval;
		});
	}
	
	public void insereAvaliacao(int idFilme, int idUsuario, int nota){
		jdbcTemplate.update("INSERT INTO Avaliacao(idFilme, idUsuario, nota) values (?, ?, ?)", idFilme, idUsuario, nota);
	}
	
	public void updateAvaliacao(int idFilme, int idUsuario, int nota){
		jdbcTemplate.update("UPDATE Avaliacao SET nota = ? WHERE idFilme = ? AND idUsuario = ?", nota, idFilme, idUsuario);
	}
}
