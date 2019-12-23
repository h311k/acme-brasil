package br.com.acmebrasil.mail;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.acmebrasil.generic.GenericService;
import br.com.acmebrasil.mail.conteudo.Conteudo;
import br.com.acmebrasil.mail.conteudo.ConteudoService;
import br.com.acmebrasil.usuario.Usuario;
import br.com.acmebrasil.util.exception.NegocioException;
import br.com.acmebrasil.util.security.Security;

@Service
public class MailService extends GenericService<MailRepository> {
	
	@Autowired 
	ConteudoService conteudoService;
	
	protected Mail salva(Mail mail) {
		Security security = new Security();
		mail.setSenha(security.encode(mail.getSenha()));
		return repository.save(mail);
	}
	
	protected void exclui(Mail mail) {
		repository.delete(mail);
	}
	
	protected List<Mail> lista() {
		return repository.findAll();
	}
	
	protected Mail buscaPorFinalidadeEmail(FinalidadeEmail finalidadeEmail) {
		return repository.findByFinalidade(finalidadeEmail);
	}
	
	public void enviaEmail(Usuario usuario, FinalidadeEmail finalidade) throws NegocioException {
		Mail mail = repository.findByFinalidade(finalidade);
		Optional<Conteudo> conteudo = conteudoService.findById(mail);
		if(!conteudo.isPresent()) {
			throw new NegocioException("Não existe conteúdo associado à estes e-mail");
		}
		//Continua o envio de email...
	}

}
