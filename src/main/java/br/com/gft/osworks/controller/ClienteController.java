package br.com.gft.osworks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gft.osworks.domain.model.Cliente;
import br.com.gft.osworks.domain.repository.ClienteRepository;

@RestController
@RequestMapping(value="/api/clientes")
public class ClienteController {
		
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}
	

}
