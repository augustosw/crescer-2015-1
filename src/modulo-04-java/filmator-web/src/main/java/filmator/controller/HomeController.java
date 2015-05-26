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
	private String msg = "";
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		msg = "";
		return "home";
	}
	
	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public String cadastro(Model model){
		model.addAttribute("generos", Genero.values());
		model.addAttribute("filmes", dao.buscaTodosFilmes());
		model.addAttribute("mensagem", msg);
		return "cadastro";
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(Filme filme, Model model){
		if(dao.validaFilme(filme)){
			dao.inserir(filme);
			msg = "Filme '" +filme.getNome() +"' foi salvo";
			model.addAttribute("mensagem", msg);
			System.out.println("Nome: "+filme.getNome());
			System.out.println("Genero: " +filme.getGenero());
		}
		else{
			
			msg = "Cadastro com erros \n"+dao.getErros();
			model.addAttribute("mensagem", msg);
		}
		model.addAttribute("filmes", dao.buscaTodosFilmes());
		model.addAttribute("generos", Genero.values());
		return "redirect:/cadastro";
	}
	
	@ResponseBody
	@RequestMapping(value = "/inserir", method = RequestMethod.GET)
	public List<Filme> inserir(Model model, @RequestParam String nome) {
		dao.inserir(new Filme(nome));
		return dao.buscaTodosFilmes();
	}
	
}

