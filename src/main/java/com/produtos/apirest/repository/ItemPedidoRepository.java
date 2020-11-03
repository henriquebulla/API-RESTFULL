package com.produtos.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.apirest.models.*;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long>{
	
}
