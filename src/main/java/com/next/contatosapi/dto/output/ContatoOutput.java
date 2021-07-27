package com.next.contatosapi.dto.output;

import java.util.List;

public class ContatoOutput {

	private String nome;

	private List<ContatoFoneOutput> telefones;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ContatoFoneOutput> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<ContatoFoneOutput> telefones) {
		this.telefones = telefones;
	}

}
