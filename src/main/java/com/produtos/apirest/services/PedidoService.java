package com.produtos.apirest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produtos.apirest.models.Pedido;
import com.produtos.apirest.repository.PedidoRepository;
import com.produtos.apirest.services.exceptions.ResourceNotFoundException;


@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;
	
	public List<Pedido> findAll(){ // retorna todos os pedidos
		return repository.findAll();
	}
	
	public Pedido findById(Long id) { //retorna pedido por ID
		Optional<Pedido> obj =  repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}
