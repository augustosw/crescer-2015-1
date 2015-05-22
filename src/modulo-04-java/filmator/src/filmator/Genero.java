package filmator;

public enum Genero {
	COMEDIA("Com�dia"), 
	ACAO("A��o"), 
	TERROR("Terror"), 
	AVENTURA("Aventura"), 
	FICCAO("Fic��o"), 
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
