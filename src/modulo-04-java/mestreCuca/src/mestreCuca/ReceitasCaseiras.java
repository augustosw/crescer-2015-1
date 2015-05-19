package mestreCuca;

import java.util.List;
import java.util.ArrayList;

public class ReceitasCaseiras implements LivroReceitas {
	private List<Receita> receitas = new ArrayList<>();
	
	public void inserir(Receita receita){
		if(!receitas.contains(receita)){
			if(validaReceita(receita)){
				receitas.add(receita);
			}
			else {
				System.out.println("Receita Inválida!!");
			}			
		}
		else System.out.println("Receita já existente no Livro");
	}
	
	public void atualizar(String nome, Receita receitaAtualizada){
		if(validaReceita(receitaAtualizada)){
			Receita receita = buscaReceitaPeloNome(nome);
			if(receita != null){
				int indice = receitas.indexOf(receita);
				receitas.set(indice, receitaAtualizada);
				System.out.println("Receita " +nome +" atualizada!");
			}
		}
		else System.out.println("Receita nova inválida!");
	}

	public void excluir(String nome){
		Receita receita = buscaReceitaPeloNome(nome);
		if(receita != null){
			receitas.remove(receita);
			System.out.println("Receita " +nome +" removida!");
		}
	}

	public List<Receita> getTodasReceitas(){
		return receitas;
	}
	
	public Receita buscaReceitaPeloNome(String nome){
		for (int i = 0; i < receitas.size(); i++) {
			if(receitas.get(i).getNome() == nome){
				return receitas.get(i);				
			}
		}
		throw new ReceitaNaoEncontradaException();
	}

	private boolean validaReceita(Receita receita){
		if(receita.getNome() != null
		   && receita.getNome() != "") {
			return true;
		}
		return false;
	}

	public double calculaValorReceitas(){
		double valor = 0.0;
		for (Receita receita : receitas) {
			valor+= receita.calculaValorReceita();
		}
		return valor;
	}

	public List<Receita> metodoDoAlergico(List<Ingrediente> alergicos){
		List<Receita> livres = new ArrayList<>();
		if(!alergicos.isEmpty()){
			boolean valido = true;
			for (Receita receita : receitas) {
				List<Ingrediente> ingredientes = receita.getIngredientes();
				for (Ingrediente ingrediente : ingredientes) {
					for (Ingrediente alergico : alergicos) {
						if(alergico.equals(ingrediente)) valido = false;
					}
				}
				if(valido){ 
					livres.add(receita);
				}
				
				valido = true;
			}
			return livres;
		}
		else System.out.println("\nLista de ingredientes alérgicos está vazia");
		return receitas;
				
	}		
	
}
