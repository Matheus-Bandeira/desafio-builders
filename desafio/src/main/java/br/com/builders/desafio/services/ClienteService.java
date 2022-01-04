package br.com.builders.desafio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.builders.desafio.entities.Cliente;
import br.com.builders.desafio.exception.ResourceNotFoundException;
import br.com.builders.desafio.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository repository;
	
	
	public List<Cliente> findAll() {
		return repository.findAll();
	}
	
	public Page<Cliente> findAllPaged(PageRequest pageRequest) {
		Page<Cliente> list = repository.findAll(pageRequest);
		return list.map(x -> new Cliente(x.getId(), x.getNome(), x.getTelefone(), x.getEndereco(), x.getIdade()));
	}
	
	public Cliente findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ID não encontrado"));
	}
	
	public Cliente insert(Cliente cliente) {
		return repository.save(cliente); 
	}
	
	public Cliente update(Cliente cliente) {
		Cliente entity = repository.findById(cliente.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		entity.setNome(cliente.getNome());
		entity.setEndereco(cliente.getEndereco());
		entity.setTelefone(cliente.getTelefone());
		entity.setIdade(cliente.getIdade());
		
		return repository.save(entity);
	}
	
	public void delete(Long id) {
		Cliente entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}
}
