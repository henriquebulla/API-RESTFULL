package com.produtos.apirest.resources;

import java.util.List;

import com.produtos.apirest.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.produtos.apirest.models.Pessoa;
import com.produtos.apirest.services.PessoaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


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

	@PostMapping(value = "pessoa")
	public ResponseEntity<Pessoa> insert(@RequestBody Pessoa obj){
		obj = service.Insert(obj);
		return ResponseEntity.ok().body(obj);
	}
	
}
