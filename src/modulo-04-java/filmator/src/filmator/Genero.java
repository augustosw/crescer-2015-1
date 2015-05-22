package filmator;

public enum Genero {
	COMEDIA("Comédia"), 
	ACAO("Ação"), 
	TERROR("Terror"), 
	AVENTURA("Aventura"), 
	FICCAO("Ficção"), 
	SUSPENSE("Suspense");
	
 private String nome;
	
	private Genero() {
		
	}
 
 	private Genero(String nome){
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
