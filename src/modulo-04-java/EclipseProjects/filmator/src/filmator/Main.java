package filmator;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
//		String nome = args[0];
//		Filme filme = new Filme(nome);
//		for (int i = 1; i < args.length; i++) {
//			Ator ator = new Ator(args[i]);
//			filme.insereAtor(ator);
//		}
//		
//		String elenco = filme.toString();
//		System.out.println(elenco);
		
		Filme avatar = new Filme("Avatar");
		Netflox netflox = new Netflox();

		netflox.reproduzirFilme(avatar);
		netflox.adicionaFilme(avatar);
	    netflox.reproduzirFilme(avatar);
	    netflox.reproduzirFilme(avatar);
	    netflox.reproduzirFilme(avatar);
	    netflox.gerarRelatorio();
		
	}
}
