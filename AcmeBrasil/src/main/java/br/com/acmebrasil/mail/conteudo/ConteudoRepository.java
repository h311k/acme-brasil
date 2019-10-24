package br.com.acmebrasil.mail.conteudo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ConteudoRepository extends JpaRepository<Conteudo, ConteudoUsuario> {

}
