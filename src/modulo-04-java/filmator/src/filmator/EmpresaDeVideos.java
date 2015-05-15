package filmator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmpresaDeVideos {
	private String nome;
	private ArrayList<Filme> filmes = new ArrayList<Filme>();
	private HashMap<Genero, Integer> visualizazoes = new HashMap<>();
	
	public EmpresaDeVideos(ArrayList<Filme> filmes) {
		this.filmes = filmes;
	}
	public EmpresaDeVideos(String nome){
		this.nome = nome;
	}

	public ArrayList<Filme> getFilmes() {
		return filmes;
	}	
	public HashMap<Genero, Integer> getVisualizazoes() {
		return visualizazoes;
	}
	public String getNome() {
		return nome;
	}
	public int getVisualizacoesPorGenero(Genero genero){
		if(visualizazoes.containsKey(genero)){
			return visualizazoes.get(genero);
			}
		else return 0;
	}
	
	public void reproduzirFilme(Filme filme){
		if(filmes.contains(filme)){
			Genero genero = filme.getGenero();
			int views = visualizazoes.get(genero);
			visualizazoes.put(genero, ++views);
			System.out.println("Reproduzindo agora: " +filme.getNome() +" - Via " +this.getNome());
		}
		else System.out.println("O filme "+filme.getNome() +" não foi encontrado no acervo de "+this.getNome() +"!!\n");
	}
	
	public void gerarRelatorio(){
			System.out.println("\nRelatório de Visualizações de " +this.getNome());
			if(!visualizazoes.isEmpty()){
	    	   for(Map.Entry<Genero, Integer> entry : visualizazoes.entrySet())
	    	   {
	    		   String nome = entry.getKey().getNome();
	    		   int views = entry.getValue();
	    		   String exibido = "Gênero: "+nome +" | Visualizações: "+views;
	    	   	   System.out.println(exibido);
	    	   }
	    	   System.out.println("\n");
			}
	       else System.out.println("Nenhum filme existente para gerar relatório");
	}

	public void adicionaFilme(Filme filme){
		Genero genero = filme.getGenero();
		filmes.add(filme);
		if(!visualizazoes.containsKey(genero)){
			visualizazoes.put(genero, 0);
			}
	}
}
