package br.com.gft.osworks.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gft.osworks.domain.Cliente;

@RestController
@RequestMapping(value="/api/clientes")
public class ClienteController {
		
	@GetMapping
	public List<Cliente> listar() {
		Cliente cliente1 = new Cliente(1L, "Leandro", "leandro@gmail.com", "(11)948726385");		
		Cliente cliente2 = new Cliente(2L, "Muris", "muris@gmail.com", "(11)948726385");		

		return Arrays.asList(cliente1, cliente2);
	}
	

}
