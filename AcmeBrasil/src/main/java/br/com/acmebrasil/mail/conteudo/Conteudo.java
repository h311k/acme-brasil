package br.com.acmebrasil.mail.conteudo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "emails_administrativos_conteudo")
public class Conteudo implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ConteudoUsuario conteudoUsuario;

	@Column(length = 64)
	private String titulo;

	@Column(columnDefinition = "TEXT")
	private String mensagem;

	public ConteudoUsuario getConteudoUsuario() {
		return conteudoUsuario;
	}

	public void setConteudoUsuario(ConteudoUsuario conteudoUsuario) {
		this.conteudoUsuario = conteudoUsuario;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
