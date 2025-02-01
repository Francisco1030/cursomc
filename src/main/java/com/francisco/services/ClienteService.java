package com.francisco.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francisco.domain.Cliente;
import com.francisco.repositories.ClienteRepository;
import com.francisco.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> result = clienteRepository.findById(id);
		return result.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: Cliente"));
		
	}

	public void criar(Cliente cliente) {
		clienteRepository.save(cliente);
	}
}
