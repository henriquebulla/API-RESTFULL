package com.produtos.apirest.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.produtos.apirest.models.Usuario;
import com.produtos.apirest.services.UsuarioService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping("/usuarios")
	@ApiOperation(value="Retorna uma lista de usuarios")
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> list = service.findAll();
		return ResponseEntity.ok().body(list); 
	}
	

	@GetMapping(value = "usuario/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id){
		Usuario obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping(value = "usuarios")
	public ResponseEntity<Usuario> insert(@RequestBody Usuario obj){
		obj = service.Insert(obj);
		return ResponseEntity.ok().body(obj);
	}

}
