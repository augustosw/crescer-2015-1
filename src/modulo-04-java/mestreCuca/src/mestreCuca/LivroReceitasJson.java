package mestreCuca;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.sun.xml.internal.ws.developer.SerializationFeature;

public class LivroReceitasJson implements LivroReceitas{
	private String caminho;
	private String nome;
	private List<Receita> receitas;
	private ObjectMapper mapper = new ObjectMapper();
	
	
	public LivroReceitasJson(String nome, String caminho) {
		this.caminho = caminho;
		this.nome = nome;
		receitas = new ArrayList<>();
		try {
			List<Receita> lido = new ArrayList<>();
			lido = mapper.readValue(new File(caminho+nome+"-receitas.json"), new TypeReference<List<Receita>>() {
			});
			receitas.addAll(lido);
			printaReceitas();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void inserir(Receita receita) {		
		if(!receitas.contains(receita)){
			if(validaReceita(receita)){
				receitas.add(receita);
				salvaReceita();
			}
			else {
				System.out.println("Receita Inválida!!");
			}			
		}
		else System.out.println("Receita já existente no Livro");	
	}

	public void salvaReceita(){
		try {
			mapper.writeValue(new File(caminho+nome+"-receitas.json"), receitas);
		} catch (Exception e) {	
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void atualizar(String nome, Receita receitaAtualizada) {
		if(validaReceita(receitaAtualizada)){
			Receita receita = buscaReceitaPeloNome(nome);
			if(receita != null){
				int indice = receitas.indexOf(receita);
				receitas.set(indice, receitaAtualizada);
				System.out.println("Receita " +nome +" atualizada!");
			}
		}
		else System.out.println("Receita nova inválida!");
		salvaReceita();
	}
	

	@Override
	public void excluir(String nome) {
		Receita receita = buscaReceitaPeloNome(nome);
		if(receita != null){
			receitas.remove(receita);
			System.out.println("Receita " +nome +" removida!");
		}
		salvaReceita();
	}

	@Override
	public List<Receita> getTodasReceitas() {
		return receitas;
	}

	@Override
	public Receita buscaReceitaPeloNome(String nome) {
		for (Receita receita : receitas) {
			if(receita.getNome() == nome){
				return receita;				
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

	private void printaReceitas(){
		if(!receitas.isEmpty()){
			for (Receita receita : receitas) {
				System.out.println(receita.getNome());
			}
		}
	}
}
