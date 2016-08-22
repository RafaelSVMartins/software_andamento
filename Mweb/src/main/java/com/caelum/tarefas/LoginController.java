package com.caelum.tarefas;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	private UsuarioDao dao;
	public LoginController() {
		this.dao = new UsuarioDao();
	}

	@RequestMapping("LoginForm")
	public String form() {
		return "formulario-login";
	}

	@RequestMapping("EfetuaLogin") 
	public String efetualogin(Usuario user, HttpSession sessao) {
		if(this.dao.buscausuario(user) != null ) {
			sessao.setAttribute("usuarioLogado", user);
			return "menu";
		} else  {
			return "forward:LoginForm";
		}
	}

	@RequestMapping("Logout")
	public String Logout(HttpSession sessao) {
		sessao.invalidate();
		return "forward:LoginForm";
	}

}
