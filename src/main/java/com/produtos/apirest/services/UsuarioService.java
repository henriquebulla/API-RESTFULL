package com.produtos.apirest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.produtos.apirest.models.Usuario;
import com.produtos.apirest.repository.UsuarioRepository;
import com.produtos.apirest.services.exceptions.ResourceNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public List<Usuario> findAll(){ // retorna todos as usuarios 
		return repository.findAll();
	}
	
	public Usuario findById(Long id) { //retorna usuario por ID
		Optional<Usuario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Usuario Insert(Usuario obj) {
		return repository.save(obj);
	}
}
