package br.com.acmebrasil.mail;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emails_administrativos")
public class Mail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mailId;

	@Column(length = 64)
	private String remetente;

	@Column(length = 64)
	private String email;

	@Column(length = 64)
	private String senha;

	@Column(length = 64)
	private String host;

	@Column(length = 4)
	private String porta;

	@Enumerated(EnumType.STRING)
	private FinalidadeEmail finalidade;

	public Long getMailId() {
		return mailId;
	}

	public void setMailId(Long mailId) {
		this.mailId = mailId;
	}

	public String getRemetente() {
		return remetente;
	}

	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPorta() {
		return porta;
	}

	public void setPorta(String porta) {
		this.porta = porta;
	}

	public FinalidadeEmail getFinalidade() {
		return finalidade;
	}

	public void setFinalidade(FinalidadeEmail finalidade) {
		this.finalidade = finalidade;
	}

}
