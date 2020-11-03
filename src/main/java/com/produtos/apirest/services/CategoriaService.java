package com.produtos.apirest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produtos.apirest.models.Categoria;
import com.produtos.apirest.repository.CategoriaRepository;
import com.produtos.apirest.services.exceptions.ResourceNotFoundException;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repository;
	
	public List<Categoria> findAll(){ // retorna todos as categorias
		return repository.findAll();
	}
	
	public Categoria findById(Long id) { //retorna categoria por ID
		Optional<Categoria> obj =  repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}
