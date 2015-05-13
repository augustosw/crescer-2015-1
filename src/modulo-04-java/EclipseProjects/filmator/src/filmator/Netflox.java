package filmator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Netflox {
	private ArrayList<Filme> filmes = new ArrayList<Filme>();
	private HashMap<Genero, Integer> visualizazoes = new HashMap<>();
	
	public Netflox() {
	}
	public Netflox(ArrayList<Filme> filmes) {
		this.filmes = filmes;
	}
	
	public ArrayList<Filme> getFilmes() {
		return filmes;
	}
	public HashMap<Genero, Integer> getVisualizazoes() {
		return visualizazoes;
	}
	
	public void reproduzirFilme(Filme filme){
		if(filmes.contains(filme)){
			Genero genero = filme.getGenero();
			int old = visualizazoes.get(genero);
			visualizazoes.replace(genero, old, old+1);
			System.out.println("Reproduzindo agora: " +filme.getNome());
		}
		else System.out.println("Filme n�o encontrado!!");
	}
	
	public void gerarRelatorio(){
	       if(!visualizazoes.isEmpty()){
	    	   for(Map.Entry<Genero, Integer> entry : visualizazoes.entrySet())
	    	   {
	    		   String nome = entry.getKey().getNome();
	    		   int views = entry.getValue();
	    		   String exibido = "G�nero: "+nome +" | Visualiza��es: "+views;
	    	   	   System.out.println(exibido);
	    	   }
	       }
	       else System.out.println("Nenhum filme existente para gerar relat�rio");
	}
	
	public void adicionaFilme(Filme filme){
		Genero genero = filme.getGenero();
		filmes.add(filme);
		if(!visualizazoes.containsKey(genero)){
			visualizazoes.put(genero, 0);
			}
	}
	
}
