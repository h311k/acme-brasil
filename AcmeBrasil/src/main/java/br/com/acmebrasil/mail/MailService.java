package br.com.acmebrasil.mail;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.acmebrasil.generic.GenericService;
import br.com.acmebrasil.util.security.Security;

@Service
public class MailService extends GenericService<MailRepository> {
	
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

}
