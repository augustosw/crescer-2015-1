package filmator.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.mockito.InjectMocks;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import filmator.dao.AvaliacaoDao;
import filmator.dao.FilmeDao;
import filmator.dao.UsuarioDao;
import filmator.model.Avaliacao;
import filmator.model.Filme;
import filmator.model.Genero;
import filmator.model.Usuario;

@Controller
public class HomeController {
	@Inject
	private FilmeDao dao;
	@Inject
	private UsuarioDao udao;
	@Inject
	private AvaliacaoDao adao;
	private String msg = "";
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("mensagem", msg);
		return "home";
	}
	
	@RequestMapping(value = "/inicialAdm", method = RequestMethod.GET)
	public String inicial(Model model) {
		return "inicialAdm";
	}
	
	@RequestMapping(value="/logar", method= RequestMethod.POST)
	public String logar(Model model, @RequestParam("usuario") String login, @RequestParam("senha") String senha, HttpSession session){
		List<Usuario> usuarios = udao.logaUsuario(login, senha);
		Usuario usuario = null;
		if(usuarios.size() > 0) usuario = usuarios.get(0);
		if(usuario == null) return "redirect:/erro";
		session.setAttribute("usuarioLogado", usuario);
		if(usuario.getAdm().equals("T"))return "redirect:/inicialAdm";
		return "redirect:/filmes";
	}
	@RequestMapping(value="/logarAdm", method= RequestMethod.POST)
	public String logarAdm(Model model, @RequestParam("usuario") String login, @RequestParam("senha") String senha){
		List<Usuario> usuarios = udao.logaUsuario(login, senha);
		Usuario usuario = null;
		if(usuarios.size() > 0) usuario = usuarios.get(0);
		if(usuario.getAdm().equals("T")) return "redirect:/inicialAdm";
		return "redirect:/erro";
	}
	@RequestMapping(value="/erro", method= RequestMethod.GET)
	public String erro(Model model){
		msg = "Login inválido!";
		return "redirect:/";
	}
	
	@RequestMapping(value = "/cadastroFilme", method = RequestMethod.GET)
	public String cadastroFilme(Model model){
		model.addAttribute("generos", Genero.values());
		model.addAttribute("filmes", dao.buscaTodosFilmes());
		model.addAttribute("mensagem", msg);
		msg="";
		return "cadastroFilme";
	}
	
	@RequestMapping(value = "/cadastroUsuario", method = RequestMethod.GET)
	public String cadastroUsuario(Model model){
		model.addAttribute("mensagem", msg);
		msg="";
		return "cadastroUsuario";		
	}
	
	@RequestMapping(value = "/busca", method = RequestMethod.GET)
	public String busca(Model model, @RequestParam("busca") String busca){
		model.addAttribute("filmes", dao.buscaFilmesPorNome(busca));
		model.addAttribute("busca", busca);
		return "busca";
	}
	@RequestMapping(value = "/buscaAdm", method = RequestMethod.GET)
	public String buscaAdm(Model model, @RequestParam("busca") String busca){
		model.addAttribute("filmes", dao.buscaFilmesPorNome(busca));
		model.addAttribute("busca", busca);
		return "buscaAdm";
	}
	
	@RequestMapping(value = "/filmes", method = RequestMethod.GET)
	public String busca(Model model){
		model.addAttribute("filmes", dao.buscaTodosFilmes());
		return "filmes";
	}
	@RequestMapping(value = "/filmesAdm", method = RequestMethod.GET)
	public String filmesAdm(Model model){
		model.addAttribute("filmes", dao.buscaTodosFilmes());
		return "filmesAdm";
	}
	
	
	@RequestMapping(value = "/salvarFilme", method = RequestMethod.POST)
	public String salvarFilme(Filme filme, Model model){
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
		return "redirect:/cadastroFilme";
	}
	
	@RequestMapping(value = "/salvarUsuario", method= RequestMethod.POST)
	public String salvarUsuario(@RequestParam("login")String inputLogin, @RequestParam("senha")String inputSenha, Model model){
		msg = "";
		if(udao.validaUsuario(inputLogin, inputSenha)){
			udao.inserirUsuario(inputLogin, inputSenha);
			msg = "Usuário inserido com sucesso! Faça login para continuar!";
			model.addAttribute("mensagem", msg);
			return "redirect:/";
		}
		else{ 
			msg = "Cadastro com erros: "+udao.getMsg();
			model.addAttribute("mensagem", msg);
			return "redirect:/cadastroUsuario";
		}
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model){	
		return "login";
	}
	
	@RequestMapping(value="/excluirFilme", method = RequestMethod.GET)
	public String exclui(Model model, @RequestParam("idFilme")int idFilme){
		dao.excluir(idFilme);
		model.addAttribute("filmes", dao.buscaTodosFilmes());
		return "redirect:/filmes";
	}
	
	@ResponseBody
	@RequestMapping(value = "/avaliar", method = RequestMethod.GET)
	public List<Integer> avaliarFilme(Model model, @RequestParam("rating") int rating, @RequestParam("idFilme") int idFilme, HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		int id = usuario.getIdUsuario();
		adao.avaliarFilme(idFilme, id, rating);
		return adao.getNotaFilmeUsuario(idFilme, id);
	}
	
	@ResponseBody
	@RequestMapping(value = "/melhores", method = RequestMethod.GET)
	public List<Filme> inserir(Model model) {
		List<Filme> filmes = new ArrayList<>();
		filmes.add(new Filme("ahsha"));
		filmes.add(new Filme("haa"));
		filmes.add(new Filme("um filme"));
		
		return filmes;
	}
	
}

