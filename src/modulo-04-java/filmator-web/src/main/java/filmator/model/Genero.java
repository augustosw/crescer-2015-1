package filmator.model;

public enum Genero {
		COMEDIA("Comédia"), 
		ACAO("Ação"), 
		TERROR("Terror"), 
		AVENTURA("Aventura"), 
		FICCAO("Ficção"), 
		SUSPENSE("Suspense");
		
		private String descricao;
		

		
		private Genero(String descricao){
			this.descricao = descricao;
		}
		
		public String getDescricao() {
			return descricao;
		}
		public void setNome(String descricao) {
			this.descricao = descricao;
		}
}
