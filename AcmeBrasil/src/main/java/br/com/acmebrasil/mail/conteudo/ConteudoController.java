package br.com.acmebrasil.mail.conteudo;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.acmebrasil.generic.GenericController;

@RestController
@RequestMapping("/mail/conteudo")
public class ConteudoController extends GenericController<ConteudoService> {

	@PostMapping("/salva")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response salva(@RequestBody Conteudo conteudo) {
		return Response.status(Status.OK).entity(service.salva(conteudo)).build();
	}
}
