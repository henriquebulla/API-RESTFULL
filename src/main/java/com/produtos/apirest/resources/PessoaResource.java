package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.produtos.apirest.models.Pessoa;
import com.produtos.apirest.services.PessoaService;


import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
public class PessoaResource {
	@Autowired
	private PessoaService service;
	
	
	@GetMapping("/pessoas")
	@ApiOperation(value="Retorna uma lista de pessoas")
	public ResponseEntity<List<Pessoa>> findAll(){
		List<Pessoa> list = service.findAll();
		return ResponseEntity.ok().body(list); 
	}
	

	@GetMapping(value = "pessoa/{id}")
	public ResponseEntity<Pessoa> findById(@PathVariable Long id){
		Pessoa obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
