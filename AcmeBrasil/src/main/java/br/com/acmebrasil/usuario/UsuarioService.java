package br.com.acmebrasil.usuario;

import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import br.com.acmebrasil.generic.GenericService;
import br.com.acmebrasil.util.exception.NegocioException;
import br.com.acmebrasil.util.security.Security;

@Service
public class UsuarioService extends GenericService<UsuarioRepository> {

	Security security = new Security();

	protected Usuario autentica(Usuario usuario) throws NegocioException {
		Optional<Usuario> usuarioEncontrado = repository.findByEmailAndSenha(usuario.getEmail(), security.geraMD5(usuario.getSenha()));
		if(usuarioEncontrado.isPresent()) {
			if(!usuarioEncontrado.get().isAtivo()) {
				throw new NegocioException("Conta de usuário inativa");
			} else {
				usuario = usuarioEncontrado.get();
				HttpSession session = request.getSession();
				session.setAttribute("usuario", usuario);
				session.setMaxInactiveInterval(20 * 60);
				return usuario;
			}
		}
		throw new NegocioException("Usuário ou senha inválidos");
	}

	protected Usuario adiciona(Usuario usuario) throws NegocioException {
		if (repository.findByEmailAndSenha(usuario.getEmail(), security.geraMD5(usuario.getSenha())).isPresent()) {
			throw new NegocioException("Este email já está em uso.");
		}
		usuario.setSenha(security.geraMD5(usuario.getSenha()));
		usuario.setDataCriacao(new Date());
		usuario.setAtivo(true);
		repository.save(usuario);
		// Adicionar aqui o envio do email de ativacao do usuario.
		return usuario;
	}
	
	protected Usuario getUsuario() {
		return super.getUsuario();
	}

}
