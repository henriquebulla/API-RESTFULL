package com.produtos.apirest.models;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.produtos.apirest.models.enums.StatusPedido;

@Entity(name="TB_PEDIDO")
public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GTM")
	private Instant momento;
	private Integer statusPedido;
	
	@ManyToOne //Muitos para um 
	@JoinColumn(name = "Pessoa_id") // Chave estrangeira da tabela pedido
	private Pessoa cliente;
	
	@OneToMany(mappedBy = "id.pedido")
	private Set<ItemPedido> itens = new HashSet<>();
	
	public Pedido() {		
	}

	public Pedido(Long id, Instant momento,StatusPedido statusPedido ,Pessoa cliente) {
		super();
		this.id = id;
		this.momento = momento;
		setStatusPedido(statusPedido);
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}

	public StatusPedido getStatusPedido() {
		return StatusPedido.valueOf(statusPedido); //Metodo que retorna o valor do Status pedido da classe Enum
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		if(statusPedido != null) {
			this.statusPedido = statusPedido.getCodigo(); //Metodo que retorna o valor do Status pedido da classe Enum
		}
	}

	public Pessoa getCliente() {
		return cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}
	
	public Set<ItemPedido> getItens(){
		return itens;
	}
	
	

	public Double getQuantidadeItem() {
		double soma = 0.0;
		for (ItemPedido x : itens) {
			soma += x.getQuantidade();
		}
		return soma;
	}
	
	
	public Double getPrecoTotal() {
		double soma = 0.0;
		for (ItemPedido x : itens) {
			soma += x.getSubTotal();
		}
		return soma;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
}
