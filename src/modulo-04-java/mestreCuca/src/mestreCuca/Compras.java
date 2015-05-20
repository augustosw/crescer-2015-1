package mestreCuca;

import java.util.List;
import java.util.ArrayList;

public class Compras {
	List<Receita> receitas = new ArrayList<>();
	
	public List<Ingrediente> listaDeCompras(){
		List<Ingrediente> compras = new ArrayList<>();
		
		if(!receitas.isEmpty()){
			for (Receita receita : receitas) {			
				if(compras.isEmpty()){
					compras.addAll(receitas.get(0).getIngredientes());
					}
				else{
					List<Ingrediente> lista = receita.getIngredientes();
					for (Ingrediente ingrediente : lista) {
						boolean existe = false;
						int index = 0;
						for (Ingrediente deCompra : compras) {
							if(ingrediente.equals(deCompra)){
								existe = true;
								index = compras.indexOf(deCompra);
							}
						}
						if(existe){
							double qtde = ingrediente.getQuantidade() + compras.get(index).getQuantidade();
							compras.get(index).setQuantidade(qtde);
						}
						else{
							compras.add(ingrediente);
						}
					}
				}
			}
			printaCompras(compras);
		}
		else System.out.println("\nLista de Receitas Vazia!!");
		return compras;
	}

	public void adicionaReceita(Receita receita){
		if(!receitas.contains(receita)){
			receitas.add(receita);
		}
	}

	private void printaCompras(List<Ingrediente> compras){
		System.out.println("\nLista de Compras:");
		for (Ingrediente ingrediente : compras) {
			double qtde = ingrediente.getQuantidade();
			String medida = ingrediente.getMedida().getNome();
			String nome = ingrediente.getNome();
			String complemento = qtde > 1 ? "s" : "";
			System.out.println(qtde +" " +medida +complemento +" de " +nome);
		}
	}
	
}
