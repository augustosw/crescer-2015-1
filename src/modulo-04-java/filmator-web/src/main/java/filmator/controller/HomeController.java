package filmator.controller;

import java.util.Arrays;

import org.mockito.InjectMocks;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.FilmeDao;
import filmator.model.Filme;
import filmator.model.Genero;

@Controller
public class HomeController {

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		FilmeDao dao = new FilmeDao();
		model.addAttribute("mensagem", "Cadastro de Filmes");
		model.addAttribute("generos", Genero.values());
		return "nomeDoArquivo";
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(Filme filme, Model model){
		FilmeDao dao = new FilmeDao();
		System.out.println("Nome: "+filme.getNome());
		System.out.println("Genero: " +filme.getGenero());
		model.addAttribute("mensagem", "Salvou");
		model.addAttribute("filmes", dao.buscaTodosFilmes());
		model.addAttribute("generos", Genero.values());
		return "nomeDoArquivo";
	}
	
}

