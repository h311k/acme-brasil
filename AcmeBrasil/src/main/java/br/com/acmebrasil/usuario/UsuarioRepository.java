package br.com.acmebrasil.usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface UsuarioRepository extends JpaRepository<Usuario,Long> {
	
	Optional<Usuario> findByEmailAndSenha(String email, String senha);

}
