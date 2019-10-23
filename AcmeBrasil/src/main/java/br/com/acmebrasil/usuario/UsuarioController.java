package br.com.acmebrasil.usuario;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.acmebrasil.generic.GenericController;
import br.com.acmebrasil.util.exception.NegocioException;

@RestController
@RequestMapping("/usuario")
public class UsuarioController extends GenericController<UsuarioService> {

	@PostMapping("/salva")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response salva(@RequestBody Usuario usuario) {
		try {
			return Response.status(Status.OK).entity(service.adiciona(usuario)).build();
		} catch (NegocioException e) {
			return Response.status(Status.UNAUTHORIZED).entity(e.getMessage()).build();
		}
	}

	@PostMapping("/autentica")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response autentica(@RequestBody Usuario usuario) {
		try {
			return Response.status(Status.OK).entity(service.autentica(usuario)).build();
		} catch (NegocioException e) {
			return Response.status(Status.UNAUTHORIZED).entity(e.getMessage()).build();
		}
	}

	@GetMapping("/testa")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response testa() {
		return Response.status(Status.OK).entity(service.getUsuario()).build();
	}

}
