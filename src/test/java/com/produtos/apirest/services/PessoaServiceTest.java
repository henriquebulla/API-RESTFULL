package com.produtos.apirest.services;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.google.common.base.Optional;
import com.produtos.apirest.models.Pessoa;
import com.produtos.apirest.repository.PessoaRepository;

import ch.qos.logback.core.net.server.Client;

@RunWith(MockitoJUnitRunner.class)
class PessoaServiceTest extends PessoaService {

	@Mock
	private PessoaRepository pessoaRepository;
	
	@InjectMocks
	private PessoaService pessoaService;

	
	@Test
	void testFindSucces() {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(55);
		pessoa.setNome("João");
		pessoa.setCep(87200161);
		pessoa.setCpf("10206266901");
		
		assertEquals("Joao", pessoa.getNome().toString());
	}

}
