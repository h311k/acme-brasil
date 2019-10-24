package br.com.acmebrasil.mail.conteudo;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.acmebrasil.mail.Mail;
import br.com.acmebrasil.usuario.Usuario;

@Embeddable
public class ConteudoUsuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@OneToOne
	@JoinColumn(name = "mail_id")
	private Mail mail;

	@OneToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Mail getMail() {
		return mail;
	}

	public void setMail(Mail mail) {
		this.mail = mail;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
