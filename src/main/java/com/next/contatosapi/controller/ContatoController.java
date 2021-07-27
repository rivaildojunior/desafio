package com.next.contatosapi.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.next.contatosapi.dto.input.ContatoInput;
import com.next.contatosapi.dto.mapper.ContatoMapper;
import com.next.contatosapi.dto.output.ContatoOutput;
import com.next.contatosapi.model.Contato;
import com.next.contatosapi.service.ContatoService;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

	private ContatoService service;

	public ContatoController(ContatoService service) {
		this.service = service;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void adicionar(@RequestBody ContatoInput contatoInput) {
		Contato contato = ContatoMapper.toEntity(contatoInput);
		service.adicionar(contato);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ContatoOutput> listarTodos(@RequestParam Optional<String> nome) {
		List<Contato> contatos = service.listarTodos(nome);
		return contatos.stream().map(ContatoMapper::toDto).collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public ContatoOutput pesquisarPorId(@PathVariable Long id) {
		Contato contato = service.pesquisarPorId(id);
		return ContatoMapper.toDto(contato);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Long id) {
		this.service.excluir(id);
	}

	@PutMapping("/{id}")
	public void alterar(@PathVariable Long id, @RequestBody ContatoInput contatoInput) {
		Contato contato = ContatoMapper.toEntity(contatoInput);
		this.service.alterar(id, contato);
	}

}
