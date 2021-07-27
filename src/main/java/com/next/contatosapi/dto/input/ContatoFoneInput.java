package com.next.contatosapi.dto.input;

import com.next.contatosapi.model.Contato;

public class ContatoFoneInput {
	
	private Contato contato;

	private String fone;

	private String obs;

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

}
