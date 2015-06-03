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
	public String home(Model model, HttpSession session ) {
		session.setAttribute("usuarioLogado", null);
		model.addAttribute("mensagem", msg);
		msg="";
		return "home";
	}
	
	@RequestMapping(value = "/inicialAdm", method = RequestMethod.GET)
	public String inicialAdm(Model model, HttpSession session) {
		Object usuario = session.getAttribute("usuarioLogado");
		model.addAttribute("mensagem", "");
		if(usuario != null){
			if(((Usuario) usuario).getAdm().equals("T")){
				Usuario usu = (Usuario)usuario;
				String login = usu.getLogin();
				model.addAttribute("loginUsuario", login);
				return "inicialAdm";
			}
		}
		msg = "Dollynho Developer diz: Tentar acessar uma página sem estar logado não pode amiginhos";
		model.addAttribute("mensagem", msg);
		return "redirect:/";
		
	}
	@RequestMapping(value = "/inicial", method = RequestMethod.GET)
	public String inicial(Model model, HttpSession session) {
		Object usuario = session.getAttribute("usuarioLogado");
		model.addAttribute("mensagem", "");
		if(usuario != null){
			Usuario usu = (Usuario) session.getAttribute("usuarioLogado");
			String login = usu.getLogin();
			model.addAttribute("loginUsuario", login);
			return "inicial";
		}
		msg = "Dollynho Developer diz: Tentar acessar uma página sem estar logado não pode amiginhos";
		model.addAttribute("mensagem", msg);
		return "redirect:/";
	}
	
	@RequestMapping(value="/logar", method= RequestMethod.POST)
	public String logar(Model model, @RequestParam("usuario") String login, @RequestParam("senha") String senha, HttpSession session){
		List<Usuario> usuarios = udao.logaUsuario(login, senha);
		Usuario usuario = null;
		if(usuarios.size() > 0) usuario = usuarios.get(0);
		if(usuario == null) return "redirect:/erro";
		session.setAttribute("usuarioLogado", usuario);
		if(usuario.getAdm().equals("T"))return "redirect:/inicialAdm";
		return "redirect:/inicial";
	}
	@RequestMapping(value="/erro", method= RequestMethod.GET)
	public String erro(Model model){
		msg = "Login inválido!";
		return "redirect:/";
	}
	
	@RequestMapping(value = "/cadastroFilme", method = RequestMethod.GET)
	public String cadastroFilme(Model model, HttpSession session){
		Object usuario = session.getAttribute("usuarioLogado");
		model.addAttribute("mensagem", "");
		if(usuario != null){
			if(((Usuario) usuario).getAdm().equals("T")){
				model.addAttribute("generos", Genero.values());
				model.addAttribute("filmes", dao.buscaTodosFilmes());
				model.addAttribute("mensagem", msg);
				Usuario usu = (Usuario)usuario;
				String login = usu.getLogin();
				model.addAttribute("loginUsuario", login);
				msg="";
				return "cadastroFilme";
			}
		}
		msg = "Dollynho Developer diz: Tentar acessar uma página sem estar logado não pode amiginhos";
		model.addAttribute("mensagem", msg);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/cadastroUsuario", method = RequestMethod.GET)
	public String cadastroUsuario(Model model){		
		model.addAttribute("mensagem", msg);
		msg="";
		return "cadastroUsuario";		
	}
	
	@RequestMapping(value = "/busca", method = RequestMethod.GET)
	public String busca(Model model, @RequestParam("busca") String busca, HttpSession session){
		Object usuario = session.getAttribute("usuarioLogado");
		model.addAttribute("mensagem", "");
		if(usuario != null){
			model.addAttribute("filmes", dao.buscaFilmes(busca));
			model.addAttribute("busca", busca);
			Usuario usu = (Usuario) session.getAttribute("usuarioLogado");
			String login = usu.getLogin();
			model.addAttribute("loginUsuario", login);
			return "busca";
		}
		msg = "Dollynho Developer diz: Tentar acessar uma página sem estar logado não pode amiginhos";
		model.addAttribute("mensagem", msg);
		return "redirect:/";
		
		
	}
	@RequestMapping(value = "/buscaAdm", method = RequestMethod.GET)
	public String buscaAdm(Model model, @RequestParam("busca") String busca, HttpSession session){
		Object usuario = session.getAttribute("usuarioLogado");
		model.addAttribute("mensagem", "");
		if(usuario != null){
			if(((Usuario) usuario).getAdm().equals("T")){
				Usuario usu = (Usuario)usuario;
				String login = usu.getLogin();
				model.addAttribute("loginUsuario", login);
				model.addAttribute("filmes", dao.buscaFilmes(busca));
				model.addAttribute("busca", busca);
				return "buscaAdm";
			}
		}
		msg = "Dollynho Developer diz: Tentar acessar uma página sem estar logado não pode amiginhos";
		model.addAttribute("mensagem", msg);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/filmes", method = RequestMethod.GET)
	public String busca(Model model, HttpSession session){
		Object usuario = session.getAttribute("usuarioLogado");
		model.addAttribute("mensagem", "");
		if(usuario != null){
			Usuario usu = (Usuario)usuario;
			String login = usu.getLogin();
			model.addAttribute("loginUsuario", login);
			model.addAttribute("filmes", dao.buscaTodosFilmes());
			return "filmes";
			
		}
		msg = "Dollynho Developer diz: Tentar acessar uma página sem estar logado não pode amiginhos";
		model.addAttribute("mensagem", msg);
		return "redirect:/";
		
		
	}
	@RequestMapping(value = "/filmesAdm", method = RequestMethod.GET)
	public String filmesAdm(Model model, HttpSession session){
		Object usuario = session.getAttribute("usuarioLogado");
		model.addAttribute("mensagem", "");
		if(usuario != null){
			if(((Usuario) usuario).getAdm().equals("T")){
				Usuario usu = (Usuario)usuario;
				String login = usu.getLogin();
				model.addAttribute("loginUsuario", login);
				model.addAttribute("filmes", dao.buscaTodosFilmes());
				return "filmesAdm";
			}
		}
		msg = "Dollynho Developer diz: Tentar acessar uma página sem estar logado não pode amiginhos";
		model.addAttribute("mensagem", msg);
		return "redirect:/";
	}
	
	
	@RequestMapping(value = "/salvarFilme", method = RequestMethod.POST)
	public String salvarFilme(Filme filme, Model model, HttpSession session){
		Object usuario = session.getAttribute("usuarioLogado");
		model.addAttribute("mensagem", "");
		if(usuario != null){
			if(((Usuario) usuario).getAdm().equals("T")){
				Usuario usu = (Usuario)usuario;
				String login = usu.getLogin();
				model.addAttribute("loginUsuario", login);
				
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
		}
		msg = "Dollynho Developer diz: Tentar acessar uma página sem estar logado não pode amiginhos";
		model.addAttribute("mensagem", msg);
		return "redirect:/";
		
		
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
	
	@RequestMapping(value="/excluirFilme", method = RequestMethod.GET)
	public String exclui(Model model, @RequestParam("idFilme")int idFilme, HttpSession session){
		Object usuario = session.getAttribute("usuarioLogado");
		model.addAttribute("mensagem", "");
		if(usuario != null){
			if(((Usuario) usuario).getAdm().equals("T")){
				Usuario usu = (Usuario)usuario;
				String login = usu.getLogin();
				model.addAttribute("loginUsuario", login);
				dao.excluir(idFilme);
				model.addAttribute("filmes", dao.buscaTodosFilmes());
				return "redirect:/filmesAdm";
			}
		}
		msg = "Dollynho Developer diz: Tentar acessar uma página sem estar logado não pode amiginhos";
		model.addAttribute("mensagem", msg);
		return "redirect:/";	
	}
	
	@ResponseBody
	@RequestMapping(value = "/avaliar", method = RequestMethod.POST)
	public int avaliarFilme(Model model, @RequestParam("rating") int rating, @RequestParam("idFilme") int idFilme, HttpSession session){
		Object usuario = session.getAttribute("usuarioLogado");
		model.addAttribute("mensagem", "");
		if(usuario != null){
			Usuario usu = (Usuario)usuario;
			String login = usu.getLogin();
			model.addAttribute("loginUsuario", login);
			int id = usu.getIdUsuario();
			adao.avaliarFilme(idFilme, id, rating);
			return adao.getMediaFilme(idFilme);		
		}
		return 0;
			
	}
	
	@ResponseBody
	@RequestMapping(value = "/getAvaliacao", method = RequestMethod.GET)
	public int getAvaliacaoUsuario(Model model, @RequestParam("idFilme") int idFilme, HttpSession session){
		Object usuario = session.getAttribute("usuarioLogado");
		model.addAttribute("mensagem", "");
		if(usuario != null){
			Usuario usu = (Usuario)usuario;
			String login = usu.getLogin();
			model.addAttribute("loginUsuario", login);
			int id = usu.getIdUsuario();
			List<Integer> nota = (List<Integer>)adao.getNotaFilmeUsuario(idFilme, id);
			return nota.get(0);	
		}
		return 0;
		
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/getAvaliacoes", method = RequestMethod.GET)
	public List<Avaliacao> getAvaliacoes(Model model, HttpSession session){
		Object usuario = session.getAttribute("usuarioLogado");
		model.addAttribute("mensagem", "");
		if(usuario != null){
			Usuario usu = (Usuario)usuario;
			String login = usu.getLogin();
			model.addAttribute("loginUsuario", login);
			int id = usu.getIdUsuario();
			return adao.getAvaliacao(id);
		}
		return null;	
	}
	
	@ResponseBody
	@RequestMapping(value = "/getMedias", method = RequestMethod.GET)
	public List<Avaliacao> getMedias(Model model,  HttpSession session){
		Object usuario = session.getAttribute("usuarioLogado");
		model.addAttribute("mensagem", "");
		if(usuario != null){
			Usuario usu = (Usuario)usuario;
			String login = usu.getLogin();
			model.addAttribute("loginUsuario", login);
			List<Avaliacao> medias = (List<Avaliacao>)adao.getMedias();
			return medias;
		}
		return null;
		
	}
	
}

