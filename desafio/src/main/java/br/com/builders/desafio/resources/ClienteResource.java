package br.com.builders.desafio.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.builders.desafio.entities.Cliente;
import br.com.builders.desafio.services.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Cliente Endpoints", description = "Description for cliente", tags = { "ClienteEndpoint" })
@RestController
@RequestMapping(value = "/v1/clientes")
public class ClienteResource {

	@Autowired
	ClienteService service;

	@ApiOperation(value = "Buscar todos os clientes")
	@GetMapping
	public ResponseEntity<Page<Cliente>> findAll(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy) {
		
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Page<Cliente> list = service.findAllPaged(pageRequest);
		return ResponseEntity.ok().body(list);
	}

	@ApiOperation(value = "Buscar cliente pelo id")
	@GetMapping("/{id}")
	public Cliente findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}

	@ApiOperation(value = "Salvar um cliente")
	@PostMapping
	public Cliente create(@RequestBody Cliente cliente) {
		return service.insert(cliente);
	}

	@ApiOperation(value = "Atualizar um cliente")
	@PutMapping
	public Cliente update(@RequestBody Cliente cliente) {
		return service.update(cliente);
	}

	@ApiOperation(value = "Deletar um cliente")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}

}
