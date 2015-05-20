package mestreCuca;

import java.util.ArrayList;
import java.util.List;

public class Receita {
	
	String nome;
	List<Ingrediente> ingredientes = new ArrayList<>();
	List<Instrucao> instrucoes = new ArrayList<>();

	public Receita(String nome, List<Ingrediente> ingredientes, List<Instrucao> instrucoes) {
		this.nome = nome != null ? nome : "Sem Nome";
		this.ingredientes = ingredientes != null ? ingredientes : new ArrayList<>();
		this.instrucoes = instrucoes != null ? instrucoes : new ArrayList<>();
	}
	public Receita(String nome) {
		this.nome = nome;
	}
	
	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	public List<Instrucao> getInstrucoes() {
		return instrucoes;
	}
	public String getNome() {
		return nome;
	}

	public double calculaValorReceita(){
		double valor = 0.0;
		
		for (Ingrediente ingrediente : ingredientes) {
			valor+=ingrediente.getPreco();
		}
		valor = (valor*100)/100;
		System.out.println("\nValor total da receita '" +this.getNome() +"': R$ "+valor);
		return valor;
	}

	public void adicionaIngrediente(Ingrediente ingrediente){
		if(validaIngrediente(ingrediente)){
			ingredientes.add(ingrediente);
		}
	}
	private boolean validaIngrediente(Ingrediente ingrediente) {
		if(ingrediente != null &&
		   ingrediente.getNome() != "" &&
		   ingrediente.getPreco() > 0)	return true;
		
		return false;
	}

	
}
