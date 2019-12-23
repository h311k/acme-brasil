package br.com.acmebrasil.mail.conteudo;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.acmebrasil.generic.GenericService;
import br.com.acmebrasil.mail.Mail;

@Service
public class ConteudoService extends GenericService<ConteudoRepository> {

	protected Conteudo salva(Conteudo conteudo) {
		conteudo.getConteudoUsuario().setUsuario(super.getUsuario());
		return repository.save(conteudo);
	}
	
	protected void exclui(Conteudo conteudo) {
		repository.delete(conteudo);
	}

	protected List<Conteudo> lista() {
		return repository.findAll();
	}
	
	public Optional<Conteudo> findById(Mail mail) {
		ConteudoUsuario conteudoUsuario = new ConteudoUsuario();
		conteudoUsuario.setMail(mail);
		conteudoUsuario.setUsuario(super.getUsuario());
		return repository.findById(conteudoUsuario);
	}

}
