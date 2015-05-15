package filmator;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class FilmatorTest {
	
	@Test
	public void testaListaComUmNomeDiferente() throws Exception {
		Filme avatar = new Filme("Avatar");
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
		Filme avatar = new Filme("Avatar");
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
		Filme avatar = new Filme("Avatar");
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
	
	@Test
	public void testaVisualizacoesDeUmaEmpresaParaUmGenero() throws Exception {
		Filme avatar = new Filme("Avatar");
		EmpresaDeVideos netflox = new Netflox("NetFlox");

		netflox.adicionaFilme(avatar);
	    netflox.reproduzirFilme(avatar);
	    netflox.reproduzirFilme(avatar);
	    netflox.reproduzirFilme(avatar);

	    int esperado = 3;
	    int encontrado = netflox.getVisualizacoesPorGenero(avatar.getGenero());
	    
	    assertEquals(esperado, encontrado);
		
	}

	@Test
	public void testaVisualizacoesDeUmaEmpresaComMaisDeUmGenero() throws Exception {
		EmpresaDeVideos iltube = new Iltube("Iltube");
		Filme avatar = new Filme("Avatar");
		Filme panico = new Filme("Panico", Genero.TERROR);
		
		iltube.adicionaFilme(avatar);
		iltube.adicionaFilme(panico);
		iltube.reproduzirFilme(avatar);
		iltube.reproduzirFilme(avatar);
		iltube.reproduzirFilme(panico);
		iltube.reproduzirFilme(panico);
		iltube.reproduzirFilme(panico);
		iltube.reproduzirFilme(panico);		
		int esperadoAcao = 2;
		int esperadoTerror = 4;
		int encontradoAcao = iltube.getVisualizacoesPorGenero(avatar.getGenero());
		int encontradoTerror = iltube.getVisualizacoesPorGenero(panico.getGenero());
		
		assertEquals(esperadoAcao, encontradoAcao);
		assertEquals(esperadoTerror, encontradoTerror);
	}

	@Test
	public void testaVisualizacaoComFilmeNaoEncontrado() throws Exception {
		EmpresaDeVideos iltube = new Iltube("Iltube");
		Filme avatar = new Filme("Avatar");
		
		iltube.reproduzirFilme(avatar);
		iltube.reproduzirFilme(avatar);
		int esperado = 0;
		int encontrado = iltube.getVisualizacoesPorGenero(avatar.getGenero());
		
		assertEquals(esperado, encontrado);
	}

	@Test
	public void testaVisualizacoesComMaisDeUmaEmpresa() throws Exception {
		Filme avatar = new Filme("Avatar");
		Filme panico = new Filme("Panico", Genero.TERROR);
		EmpresaDeVideos netflox = new Netflox("NetFlox");
		EmpresaDeVideos iltube = new Iltube("Iltube");

		netflox.adicionaFilme(avatar);
		netflox.adicionaFilme(panico);
	    netflox.reproduzirFilme(avatar);
	    netflox.reproduzirFilme(panico);
	    netflox.reproduzirFilme(avatar);
	    netflox.reproduzirFilme(avatar);
		iltube.adicionaFilme(avatar);
		iltube.adicionaFilme(panico);
		iltube.reproduzirFilme(avatar);
		iltube.reproduzirFilme(avatar);
		iltube.reproduzirFilme(panico);
		iltube.reproduzirFilme(panico);
		iltube.reproduzirFilme(panico);
		iltube.reproduzirFilme(panico);
		int esperadoNetAcao = 3;
		int esperadoNetTerror = 1;
		int esperadoIlAcao = 2;
		int esperadoIlTerror = 4;
		Genero gen1 = avatar.getGenero();
		Genero gen2 = panico.getGenero();
		int encontradoNetAcao = netflox.getVisualizacoesPorGenero(gen1);
		int encontradoNetTerror = netflox.getVisualizacoesPorGenero(gen2);
		int encontradoIlAcao = iltube.getVisualizacoesPorGenero(gen1);
		int encontradoIlTerror = iltube.getVisualizacoesPorGenero(gen2);
		
		assertEquals(esperadoNetAcao, encontradoNetAcao);
		assertEquals(esperadoNetTerror, encontradoNetTerror);
		assertEquals(esperadoIlAcao, encontradoIlAcao);
		assertEquals(esperadoIlTerror, encontradoIlTerror);
		
	}
	
}
