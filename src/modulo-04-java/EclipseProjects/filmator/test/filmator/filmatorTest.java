package filmator;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class filmatorTest {
	
	@Test
	public void testaListaComUmNomeDiferente() throws Exception {
		Filme avatar = new Filme();
		Ator ator1 = new Ator("Nome1");
		Ator ator2 = new Ator("1 Nome2");
		Ator ator3 = new Ator("Noame3");
		
		avatar.insereAtor(ator1);
		avatar.insereAtor(ator2);
		avatar.insereAtor(ator3);
		ArrayList<Ator> esperado = new ArrayList<Ator>();
		esperado.add(ator1);
		esperado.add(ator2);
		ArrayList<Ator> lista = avatar.listaPorNome("Nome");
		
		assertEquals(lista, esperado);
	}

	@Test
	public void testaListaComNenhumNome() throws Exception {
		Filme avatar = new Filme();
		Ator ator1 = new Ator("Nome1");
		Ator ator2 = new Ator("Nome2");
		Ator ator3 = new Ator("Noame3");
		
		avatar.insereAtor(ator1);
		avatar.insereAtor(ator2);
		avatar.insereAtor(ator3);
		ArrayList<Ator> esperado = new ArrayList<Ator>();
		ArrayList<Ator> lista = avatar.listaPorNome("dsfd");
		
		assertEquals(lista, esperado);
	}

	@Test
	public void testaAdicaoDeAtorEmFilme() throws Exception {
		Filme avatar = new Filme();
		Ator ator1 = new Ator("Nome1");
		Ator ator2 = new Ator("Nome2");
		Ator ator3 = new Ator("Noame3");
		
		avatar.insereAtor(ator1);
		avatar.insereAtor(ator2);
		avatar.insereAtor(ator3);
		int esperado = 3;
		int encontrado = avatar.getAtores().size();
		
		assertEquals(esperado, encontrado);
	}

	@Test
	public void testaAtorComNome() throws Exception {
		Ator ator = new Ator("Nome1");
		
		String esperado = "Nome1";
		String encontrado = ator.getNome();
		
		assertEquals(esperado, encontrado);
	}
	
}
