package com.next.contatosapi.dto.input;

import java.util.List;

public class ContatoInput {

	private String nome;
	
	private List<ContatoFoneInput> telefones;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ContatoFoneInput> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<ContatoFoneInput> telefones) {
		this.telefones = telefones;
	}

}
