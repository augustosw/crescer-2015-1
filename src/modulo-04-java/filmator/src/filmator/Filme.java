package filmator;

import java.util.ArrayList;

public class Filme {
	private String nome;
	private ArrayList<Ator> atores = new ArrayList<Ator>();
	private Genero genero;
	
	{
		this.genero = Genero.ACAO;
	}
	
	public Filme(String nome) {
		this.nome = nome;
	}
	public Filme(String nome, Genero genero){
		this.nome = nome;
		this.genero = genero;
	}
	
	public ArrayList<Ator> getAtores() {
		return atores;
	}
	public String getNome() {
		return nome;
	}
	public Genero getGenero() {
		return genero;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String toString(){
		String elenco = "Filme: " +this.getNome()+"\nElenco:\n";
		for (Ator ator : atores) {
			 elenco += ator.getNome() +"\n";
		}
		return elenco;
	}
	
	public void insereAtor(Ator ator){
		atores.add(ator);
	}
	
	public ArrayList<Ator> listaPorNome(String nome){
		ArrayList<Ator> lista = new ArrayList<Ator>();
		for (Ator ator : atores) {
			if(ator.getNome().toLowerCase().contains(nome.toLowerCase())){
				lista.add(ator);
			}
		}
		return lista;
	}
}
