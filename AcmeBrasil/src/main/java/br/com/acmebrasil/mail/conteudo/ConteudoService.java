package br.com.acmebrasil.mail.conteudo;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.acmebrasil.generic.GenericService;

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

}
