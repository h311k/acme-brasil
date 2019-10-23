package br.com.acmebrasil.generic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.acmebrasil.usuario.Usuario;

public abstract class GenericService<T> {
	
	@Autowired
	protected HttpServletRequest request;
	
	protected Usuario getUsuario() {
		HttpSession session = request.getSession();
		return (Usuario) session.getAttribute("usuario");
	}
	
	@Autowired
	protected T repository;

}
