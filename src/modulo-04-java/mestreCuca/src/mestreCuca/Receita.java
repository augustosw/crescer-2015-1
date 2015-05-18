package mestreCuca;

import java.util.ArrayList;
import java.util.List;

public class Receita {
	
	String nome;
	List<Ingrediente> ingredientes = new ArrayList<>();
	List<Instrucao> instrucoes = new ArrayList<>();

	public Receita(String nome, List<Ingrediente> ingredientes, List<Instrucao> instrucoes) {
		this.nome = nome;
		this.ingredientes = ingredientes;
		this.instrucoes = instrucoes;
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
}
