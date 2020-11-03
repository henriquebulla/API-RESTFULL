package com.produtos.apirest.models.enums;

public enum StatusPedido {

	EM_ANDAMENTO(1),
	PENDENTE(2),
	CANCELADO(3),
	ENCERRADO(4);
	
	private int codigo;
	
	private StatusPedido(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	//Esse metódo tem um lado que vai percorrer todos os valores possíveis do Status pedido e
	// Caso encontre ele retorna o valor do Status, caso não encontre retorna uma excessão 
	public static StatusPedido valueOf(int codigo) {
		for (StatusPedido valor : StatusPedido.values()) {
			if(valor.getCodigo() == codigo) {
				return valor;
			}
		}
		throw new IllegalArgumentException("Código do Status Pedido Inválido");
	}
}
