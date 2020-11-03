package com.produtos.apirest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produtos.apirest.models.Pessoa;
import com.produtos.apirest.repository.PessoaRepository;
import com.produtos.apirest.services.exceptions.ResourceNotFoundException;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repository;
	
	public List<Pessoa> findAll(){ // retorna todos as pessoas 
		return repository.findAll();
	}
	
	public Pessoa findById(Long id) { //retorna pessoa por ID
		Optional<Pessoa> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}
