package com.next.contatosapi.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import com.next.contatosapi.dto.input.ContatoFoneInput;
import com.next.contatosapi.dto.input.ContatoInput;
import com.next.contatosapi.dto.output.ContatoFoneOutput;
import com.next.contatosapi.dto.output.ContatoOutput;
import com.next.contatosapi.model.Contato;
import com.next.contatosapi.model.ContatoFone;

public class ContatoMapper {

	public static Contato toEntity(ContatoInput contatoInput) {
		Contato contato = new Contato();
		contato.setNome(contatoInput.getNome());
		if (contatoInput.getTelefones() != null) {
			List<ContatoFone> telefones = new ArrayList<>();

			for (ContatoFoneInput contatoFoneInput : contatoInput.getTelefones()) {
				ContatoFone contatoFone = new ContatoFone();
				contatoFone.setFone(contatoFoneInput.getFone());
				contatoFone.setObs(contatoFoneInput.getObs());
				contatoFone.setContato(contato);
				telefones.add(contatoFone);
			}
			contato.setTelefones(telefones);
		}
		return contato;
	}

	public static ContatoOutput toDto(Contato contato) {
		ContatoOutput output = new ContatoOutput();
		output.setNome(contato.getNome());
		if (contato.getTelefones() != null) {
			List<ContatoFoneOutput> telefones = new ArrayList<>();

			for (ContatoFone contatoFone : contato.getTelefones()) {
				ContatoFoneOutput contatoFoneOutput = new ContatoFoneOutput();
				contatoFoneOutput.setFone(contatoFone.getFone());
				contatoFoneOutput.setObs(contatoFone.getObs());
				telefones.add(contatoFoneOutput);
			}
			output.setTelefones(telefones);
		}
		return output;
	}

}
