package com.next.contatosapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.next.contatosapi.model.Contato;

public interface ContatoRepository extends CrudRepository<Contato, Long> {
	
	@Query("select c from Contato c where c.nome like %:nome% order by c.nome")
	List<Contato> listarContatos(@Param("nome") String nome);

	@Query("select c from Contato c order by c.nome")
	List<Contato> listarContatos();

}
