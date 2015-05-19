package mestreCuca;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		ReceitasCaseiras caseiras = new ReceitasCaseiras();
		
		try{
			caseiras.buscaReceitaPeloNome("Nao acha nada");
		}
		catch (ReceitaNaoEncontradaException e){
			System.out.println(e);
		}
		System.out.println("Passou");
		
		
		Ingrediente acucar = new Ingrediente("Açúcar", 100, Medida.G, 2.5);
		Ingrediente granulado = new Ingrediente("Granulado", 200, Medida.G, 3.0);
		Ingrediente baunilha = new Ingrediente("Baunilha", 50, Medida.G, 1.3);
		Ingrediente frango = new Ingrediente("Frango", 2, Medida.KG, 10.50);
		Ingrediente batata = new Ingrediente("Batata", 1, Medida.KG, 3.50);
		Ingrediente cebola = new Ingrediente("Cebola", 0.5, Medida.KG, 7.50);
		Ingrediente cebola2 = new Ingrediente("Cebola", 1.5, Medida.KG, 7.50);
		Ingrediente presunto = new Ingrediente("Presunto", 200, Medida.G, 9.50);
		
		Receita bolo = new Receita("Bolo");
		Receita frangoAssado = new Receita("Frango Assado");
		Receita outroFrango = new Receita("Outro Frango");
		Receita sanduiche = new Receita("SanduicheIche");
		
		bolo.adicionaIngrediente(baunilha);
		bolo.adicionaIngrediente(granulado);
		bolo.adicionaIngrediente(acucar);
		bolo.calculaValorReceita();
		frangoAssado.adicionaIngrediente(cebola);
		frangoAssado.adicionaIngrediente(batata);
		frangoAssado.adicionaIngrediente(frango);
		outroFrango.adicionaIngrediente(cebola2);
		sanduiche.adicionaIngrediente(presunto);
		
		caseiras.inserir(sanduiche);
		caseiras.inserir(outroFrango);
		caseiras.inserir(frangoAssado);
		caseiras.inserir(bolo);
		
		Compras sabado = new Compras();
		sabado.adicionaReceita(frangoAssado);
		sabado.adicionaReceita(bolo);
		sabado.adicionaReceita(outroFrango);
		sabado.listaDeCompras();
		
		Compras domingo = new Compras();
		domingo.adicionaReceita(outroFrango);
		domingo.adicionaReceita(outroFrango);
		domingo.listaDeCompras();
		
		Compras sexta = new Compras();
		sexta.listaDeCompras();
		
		List<Ingrediente> alergicos = new ArrayList<>();
		alergicos.add(cebola);
		alergicos.add(baunilha);
		
		List<Receita> livres = caseiras.metodoDoAlergico(alergicos);
		System.out.println("\nReceitas livres dos ingredientes alérgicos:");
		for (Receita receita : livres) {
			System.out.println(receita.getNome());
		}
		
	}
}
