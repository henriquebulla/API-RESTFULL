package com.produtos.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.apirest.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	
	
}


