package filmator;

public class Ator {
	private String nome;
	
	public Ator(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	
	public String toString(){
		return "Nome do Ator: " +this.getNome();
	}
}