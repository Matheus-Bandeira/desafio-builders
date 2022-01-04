package br.com.builders.desafio;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.builders.desafio.entities.Cliente;
import br.com.builders.desafio.repositories.ClienteRepository;
import br.com.builders.desafio.services.ClienteService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class DesafioApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@Test
	public void deveCadastrarClienteComSucesso() {
		Cliente cliente = new Cliente();
		cliente.setId(999L);
		cliente.setNome("Davi Marques Bandeira");
		cliente.setIdade(20);
		cliente.setTelefone("(21)98233-81433");
		cliente.setEndereco("Rua A");

		cliente = clienteRepository.save(cliente);

		assertThat(cliente).isNotNull();
		assertThat(cliente.getId()).isNotNull();
	}
	
	@Test
	public void deveFalharAoTentarExcluirClienteInexistente() {
		EmptyResultDataAccessException erroEsperado = Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
			clienteRepository.deleteById(999L);
		}); 
		
		assertThat(erroEsperado).isNotNull();
	}
	

	
//	@Test
//	public void deveFalharAoCadastrarClienteSemNome() {
//		Cliente cliente = new Cliente();
//		cliente.setNome(null);
//		
//		ConstraintViolationException erroEsperado = Assertions.assertThrows(ConstraintViolationException.class, () -> {
//			clienteRepository.save(cliente);
//		});
//
//		assertThat(erroEsperado).isNotNull();
//	}

}
