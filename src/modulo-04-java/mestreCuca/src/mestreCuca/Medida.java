package mestreCuca;

public enum Medida {
	XIC("Xícara de Chá", "xic"), 
	COL("Colher de Sopa","colher"),
	KG("KiloGrama","Kg"),
	G("Grama","g"),
	MG("MiliGrama", "mg"),
	L("Litro","L"),
	ML("MiliLitro","ml");
	
	private String nome;
	private String abreviacao;
	
	private Medida(String nome, String abreviacao) {
		this.nome = nome;
		this.abreviacao = abreviacao;
	}
	
	public String getAbreviacao() {
		return abreviacao;
	}
	public String getNome() {
		return nome;
	}
	
}
