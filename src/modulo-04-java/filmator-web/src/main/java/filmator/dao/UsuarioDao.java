package filmator.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import filmator.model.Usuario;

@Component
public class UsuarioDao {
	
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public List<Usuario> logaUsuario(String inputLogin, String inputSenha){
		return jdbcTemplate.query("SELECT idUsuario, login, admin FROM Usuario WHERE login = ? AND senha = ?", (ResultSet rs, int rowNum) -> {	
			String logs = rs.getString("login");
			String adm = rs.getString("admin");
			int id = rs.getInt("idUsuario"); 
			Usuario usuario = new Usuario(logs);
			usuario.setAdm(adm);
			usuario.setIdUsuario(id);
			return usuario;
		}, inputLogin, inputSenha);	
	}
	
	public void inserirUsuario(String inputLogin, String inputSenha){
			jdbcTemplate.update("INSERT INTO Usuario(login, senha, admin) values (?, ?, 'F')", inputLogin, inputSenha);	
	}
	
	private String msg = "";
	public boolean validaUsuario(String inputLogin, String inputSenha){
		msg = "";
		if(inputLogin.trim() == "") msg += "-Campo Usuário vazio! ";
		if(inputLogin == null) msg += "-Campo Usuário NULO! ";
		if(inputLogin.length() < 5) msg +="-Usuário com menos de 5 letras! ";

		if(inputSenha.trim() == "") msg += "-Campo Senha vazio! ";
		if(inputSenha == null) msg += "-Campo Senha NULO! ";
		if(inputSenha.length() < 5) msg += "-Senha com menos de 5 letras! ";
		
		if(msg == "")return true;
		return false;

	}
	public String getMsg() {
		return msg;
	}
}
