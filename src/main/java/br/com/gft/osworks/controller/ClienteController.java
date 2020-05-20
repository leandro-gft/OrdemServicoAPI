package br.com.gft.osworks.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
	
	
	@GetMapping(value="/clientes")
	public String listar() {
		return "Teste";
	}

}
