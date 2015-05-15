package filmator;

//import java.util.ArrayList;

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
		Filme panico = new Filme("Panico", Genero.TERROR);
		EmpresaDeVideos netflox = new Netflox("NetFlox");

		netflox.reproduzirFilme(avatar);
		netflox.adicionaFilme(avatar);
		netflox.adicionaFilme(panico);
	    netflox.reproduzirFilme(avatar);
	    netflox.reproduzirFilme(panico);
	    netflox.reproduzirFilme(avatar);
	    netflox.reproduzirFilme(avatar);
	    netflox.gerarRelatorio();
		
		EmpresaDeVideos iltube = new Iltube("Iltube");

		iltube.adicionaFilme(avatar);
		iltube.adicionaFilme(panico);
		iltube.reproduzirFilme(avatar);
		iltube.reproduzirFilme(avatar);
		iltube.reproduzirFilme(panico);
		iltube.reproduzirFilme(panico);
		iltube.reproduzirFilme(panico);
		iltube.reproduzirFilme(panico);
		iltube.gerarRelatorio();
		netflox.gerarRelatorio();
	}
}
