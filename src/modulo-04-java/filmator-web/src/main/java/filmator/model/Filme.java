package filmator.model;

import java.io.File;

public class Filme {

	private String nome;
	private Genero genero;
	private int ano;
	private String sinopse;
	private File imagem;
	
	public Filme() {
		
	}
	public Filme(String nome){
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	public int getAno() {
		return ano;
	}
	public Genero getGenero() {
		return genero;
	}
	public File getImagem() {
		return imagem;
	}
	public String getSinopse() {
		return sinopse;
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public void setImagem(File imagem) {
		this.imagem = imagem;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
}
