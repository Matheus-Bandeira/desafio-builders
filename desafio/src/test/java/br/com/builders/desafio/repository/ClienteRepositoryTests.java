package br.com.builders.desafio.repository;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.builders.desafio.entities.Cliente;
import br.com.builders.desafio.repositories.ClienteRepository;
import br.com.builders.desafio.services.ClienteService;

@DataJpaTest
public class ClienteRepositoryTests {

	
//	@Autowired
//	ClienteRepository clienteRepository;
//
//	@Autowired
//	ClienteService clienteService;
//
//	private long exintingId;
//	private long nonExistingId;
//	private long countTotalClientes;
//	
//	
//	@BeforeEach // antes de cada teste
//	void setUp() throws Exception {
//		exintingId = 1L;
//		nonExistingId = 1000L;
//		countTotalClientes = 25L;
//	}
//
//	@Test
//	public void findByIdShouldReturnOptionalNotEmptyWhenIdExists() {
//		Optional<Cliente> result = clienteRepository.findById(1L);
//
//		Assertions.assertTrue(result.isPresent());
//
//	}

}
