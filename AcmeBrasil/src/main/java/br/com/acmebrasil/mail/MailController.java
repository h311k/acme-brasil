package br.com.acmebrasil.mail;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.acmebrasil.generic.GenericController;

@RestController
@RequestMapping("/mail")
public class MailController extends GenericController<MailService> {

	@PostMapping("/salva")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response salva(@RequestBody Mail mail) {
		return Response.status(Status.OK).entity(service.salva(mail)).build();
	}
	
	@PostMapping("/exclui")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response exclui(@RequestBody Mail mail) {
		service.exclui(mail);
		return Response.status(Status.OK).build();
	}

	@GetMapping("/lista")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAll() throws JsonProcessingException {
		return Response.status(Status.OK).entity(mapper.writeValueAsString(service.lista())).build();
	}
	
	@GetMapping("/lista/{finalidade}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response listByFinalidade(@RequestParam("finalidade") FinalidadeEmail finalidadeEmail) throws JsonProcessingException {
		return Response.status(Status.OK).entity(mapper.writeValueAsString(service.buscaPorFinalidadeEmail(finalidadeEmail))).build();
	}

}
