package filmator.model;

public class Avaliacao {
	private int idFilme;
	private int idUsuario;
	private int nota;
	
	public int getIdFilme() {
		return idFilme;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public int getNota() {
		return nota;
	}
	
	public void setIdFilme(int idFilme) {
		this.idFilme = idFilme;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
}
