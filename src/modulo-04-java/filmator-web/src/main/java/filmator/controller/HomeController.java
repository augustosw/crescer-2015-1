package filmator.controller;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.mockito.InjectMocks;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import filmator.dao.FilmeDao;
import filmator.model.Filme;
import filmator.model.Genero;

@Controller
public class HomeController {
	@Inject
	private FilmeDao dao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public String cadastro(Model model){
		model.addAttribute("generos", Genero.values());
		model.addAttribute("filmes", dao.buscaTodosFilmes());
		model.addAttribute("mensagem", "Preencha o formulário para cadastrar um filme");
		return "cadastro";
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(Filme filme, Model model){
		System.out.println("Nome: "+filme.getNome());
		System.out.println("Genero: " +filme.getGenero());
		if(dao.validaFilme(filme)){
			dao.inserir(filme);
			model.addAttribute("mensagem", "Filme '" +filme.getNome() +"' foi salvo");
		}
		else{
			model.addAttribute("mensagem", "Cadastro com erros");
		}
		model.addAttribute("filmes", dao.buscaTodosFilmes());
		model.addAttribute("generos", Genero.values());
		return "cadastro";
	}
	
	@ResponseBody
	@RequestMapping(value = "/inserir", method = RequestMethod.GET)
	public List<Filme> inserir(Model model, @RequestParam String nome) {
		dao.inserir(new Filme(nome));
		return dao.buscaTodosFilmes();
	}
	
}

