package br.com.acmebrasil.generic;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class GenericController<T> {

	@Autowired
	protected T service;

	protected ObjectMapper mapper = new ObjectMapper();
	
}
