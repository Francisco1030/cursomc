package com.francisco.resources;

import com.francisco.resources.dtos.CriarClienteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.francisco.domain.Cliente;
import com.francisco.services.ClienteService;

import java.net.URI;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResources {
	
	@Autowired
	private ClienteService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> find(@PathVariable Integer id) {
		Cliente obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Cliente> create(@RequestBody CriarClienteDto body) {
		service.criar(body.toCliente());
		return ResponseEntity.created(URI.create("OK")).build();
	}
}
