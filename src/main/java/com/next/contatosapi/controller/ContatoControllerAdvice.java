package com.next.contatosapi.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.next.contatosapi.dto.ErrorDTO;
import com.next.contatosapi.service.exception.ContatoNaoEncontradoException;


@ControllerAdvice
public class ContatoControllerAdvice {
	
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ContatoNaoEncontradoException.class)
    public ErrorDTO handleUserNotFound(ContatoNaoEncontradoException contatoNaoEncontradoException) {    	
    	ErrorDTO errorDTO = new ErrorDTO();
    	errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
    	errorDTO.setMessage("Contato não encontrado.");
    	errorDTO.setTimestamp(new Date());
        return errorDTO;
    }

}
