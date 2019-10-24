package br.com.acmebrasil.mail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface MailRepository extends JpaRepository<Mail, Long> {

	Mail findByFinalidade(FinalidadeEmail finalidade);

}
