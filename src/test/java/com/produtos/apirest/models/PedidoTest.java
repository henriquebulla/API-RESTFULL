package com.produtos.apirest.models;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;

import com.produtos.apirest.models.enums.StatusPedido;
import com.produtos.apirest.models.pk.ItemPedidoPK;

class PedidoTest {
	


	@Test
	void testQuantidadePedidoSemItem() {
		double quantidade;
		
		Pessoa joao = new Pessoa();
		joao.setId(66);
		joao.setNome("joao");
		joao.setCpf("10206266901");
		joao.setCep(87200161);
		
		Pedido pedido = new Pedido();
		pedido.setId((long) 55);
		pedido.setCliente(joao);
		pedido.setStatusPedido(StatusPedido.EM_ANDAMENTO);
	
		
		quantidade = pedido.getQuantidadeItem();
		
		assertEquals(0, quantidade);
		
	}
	
	@Test
	void testQuantidadePedidoComItem() {
		double quantidade;
		
		Pessoa joao = new Pessoa();
		
		joao.setId(66);
		joao.setNome("joao");
		joao.setCpf("10206266901");
		joao.setCep(87200161);
		
		
		Pedido pedido = new Pedido();
		pedido.setId((long) 55);
		pedido.setCliente(joao);
		pedido.setStatusPedido(StatusPedido.EM_ANDAMENTO);
		
		Produto telha = new Produto();
		telha.setId(1);
		telha.setNome("telha");
		telha.setEstoque(new BigDecimal(100));
		telha.setValor(new BigDecimal(1.40));
		
		ItemPedido itemUm = new ItemPedido();
		itemUm.setPedido(pedido);
		itemUm.setProduto(telha);
		itemUm.setQuantidade(500);
		itemUm.setPreco(1.40);
		
		ItemPedidoPK itempk = new ItemPedidoPK();
		itempk.setPedido(pedido);
		itempk.setProduto(telha);
		
		quantidade = pedido.getQuantidadeItem();
		
		assertEquals(500, quantidade);
		
	}

}
