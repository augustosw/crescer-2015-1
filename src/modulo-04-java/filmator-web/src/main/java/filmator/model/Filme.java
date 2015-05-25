package filmator.model;

import java.io.File;

public class Filme {

	private int idFilme;
	private String nome;
	private Genero genero;
	private int ano_lancamento;
	private String sinopse;
	private String imagem;
	
	public Filme() {
		
	}
	
	public Filme(int idFilme, String nome, Genero genero, int ano_lancamento){
		this.idFilme = idFilme;
		this.nome = nome;
		this.genero = genero;
		this.ano_lancamento = ano_lancamento;
	}
	
	
	public Filme(String nome){
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	public int getAno() {
		return ano_lancamento;
	}
	public Genero getGenero() {
		return genero;
	}
	public String getImagem() {
		return imagem;
	}
	public String getSinopse() {
		return sinopse;
	}
	public String getDescricao(){
		return genero.getDescricao();
	}
	
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setAno(int ano_lancamento) {
		this.ano_lancamento = ano_lancamento;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
}
