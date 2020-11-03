package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Pedido;
import com.produtos.apirest.services.PedidoService;



import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
public class PedidoResource {
	@Autowired
	private PedidoService service;
	
	
	@GetMapping("/pedidos")
	@ApiOperation(value="Retorna uma lista de pessoas")
	public ResponseEntity<List<Pedido>> findAll(){
		List<Pedido> list = service.findAll();
		return ResponseEntity.ok().body(list); 
	}
	

	@GetMapping(value = "pedido/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable Long id){
		Pedido obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
