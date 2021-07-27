package com.next.contatosapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.next.contatosapi.model.Contato;
import com.next.contatosapi.repository.ContatoRepository;
import com.next.contatosapi.service.exception.ContatoNaoEncontradoException;

@Service
public class ContatoService {

	private ContatoRepository repository;

	public ContatoService(ContatoRepository repository) {
		this.repository = repository;
	};

	public void adicionar(Contato contato) {
		repository.save(contato);
	}

	public List<Contato> listarTodos(Optional<String> nome) {
		if (nome.isPresent()) {
			return (List<Contato>) repository.listarContatos(nome.get());
		} else {
			return (List<Contato>) repository.listarContatos();
		}
	}

	public Contato pesquisarPorId(Long id) {
		Optional<Contato> contatoOpt = repository.findById(id);
		if (!contatoOpt.isPresent()) {
			throw new ContatoNaoEncontradoException();
		}
		return contatoOpt.get();
	}

	public void excluir(Long id) {
		Contato contato = pesquisarPorId(id);
		repository.delete(contato);
	}

	public void alterar(Long id, Contato contato) {
		Contato alterar = pesquisarPorId(id);
		alterar.setNome(contato.getNome());
		repository.save(alterar);
	}

}
