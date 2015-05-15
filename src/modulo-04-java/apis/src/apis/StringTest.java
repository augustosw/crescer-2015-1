package apis;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringTest {
	@Test
	public void chatAtTest() throws Exception {
		String palavra = "Palavra";
		
		char encontrado = palavra.charAt(1);
		char esperado = 'a';
		
		assertEquals(esperado, encontrado);
	}
	
	@Test
	public void startsWithTest() throws Exception {
		String palavra = "Palavra";
		
		boolean encontrado = palavra.startsWith("P");
		boolean esperado = true;
		
		assertEquals(esperado, encontrado);
	}

	@Test
	public void endsWithTest() throws Exception {
		String palavra = "Palavra";
		
		boolean encontrado = palavra.endsWith("vra");
		boolean esperado = true;
		
		assertEquals(esperado, encontrado);
	}

	@Test
	public void containsTest() throws Exception {
		String palavra = "Palavra";
		
		boolean encontrado = palavra.contains("ala");
		boolean esperado = true;
		
		assertEquals(esperado, encontrado);
	}

	@Test
	public void compareToTest() throws Exception {
		String palavra = "Palavra";
		
		int encontrado = palavra.compareTo("PalavraMaior");
		int esperado = -5;
		
		assertEquals(esperado, encontrado);
	}

	@Test
	public void indexOfTest() throws Exception {
		String palavra = "Palavra";
		
		int encontrado = palavra.indexOf("l");
		int esperado = 2;
		
		assertEquals(esperado, encontrado);
		
	}
	
	@Test
	public void toLowerCaseTest() throws Exception {
		String palavra = "PALAVRA";
		
		String encontrado = palavra.toLowerCase();
		String esperado = "palavra";
		
		assertEquals(esperado, encontrado);
	}

	@Test
	public void toUpperCaseTest() throws Exception {
		String palavra = "palavra";
		
		String encontrado = palavra.toUpperCase();
		String esperado = "PALAVRA";
		
		assertEquals(esperado, encontrado);
	}

	@Test
	public void lenghtTest() throws Exception {
		String palavra = "Palavra";
		
		int encontrado = palavra.length();
		int esperado = 7;
		
		assertEquals(esperado, encontrado);
	}

	@Test
	public void replaceTest() throws Exception {
		String palavra = "Palavra";
		
		String encontrado = palavra.replace('P', 'D');
		String esperado = "Dalavra";
		
		assertEquals(esperado, encontrado);
	}

	@Test
	public void replaceFirstTest() throws Exception {
		String palavra = "Palavra";
		
		String encontrado = palavra.replaceFirst("lav","ABC");
		String esperado = "PaABCra";
		
		assertEquals(esperado, encontrado);
	}

	@Test
	public void splitTest() throws Exception {
		String palavra = "pala:vra";
		
		String[] encontrado = palavra.split(":");
		String[] esperado = {"pala","vra"};
		for (int i = 0; i < esperado.length; i++) {
			assertEquals(encontrado[i], esperado[i]);
		}
		
	}	

//	@Test
//	public void trimTest() throws Exception {
//		String palavra = " Pala vra";
//		
//		String encontrado = palavra.trim();
//		String esperado = "Palavra";
//		
//		assertEquals(esperado, encontrado);
//	}
	
}
