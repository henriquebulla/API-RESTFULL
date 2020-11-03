package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Categoria;
import com.produtos.apirest.services.CategoriaService;



import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
public class CategoriaResource {
	@Autowired
	private CategoriaService service;
	
	
	@GetMapping("/categorias")
	@ApiOperation(value="Retorna uma lista de pessoas")
	public ResponseEntity<List<Categoria>> findAll(){
		List<Categoria> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	

	@GetMapping(value = "categoria/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id){
		Categoria obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
