package mestreCuca;

import java.util.List;
import java.util.ArrayList;

public class ReceitasCaseiras implements LivroReceitas {
	static List<Receita> receitas = new ArrayList<>();
	
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
}
