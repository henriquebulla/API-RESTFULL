package com.produtos.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.apirest.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
	
	
	
}


