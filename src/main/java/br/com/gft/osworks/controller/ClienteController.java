package br.com.gft.osworks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gft.osworks.domain.model.Cliente;
import br.com.gft.osworks.domain.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public ResponseEntity<List<Cliente>> listar() {
		return ResponseEntity.ok(clienteService.listar());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
		Cliente cliente = clienteService.buscarPorId(id);
		if (cliente != null) {
			return ResponseEntity.ok(clienteService.buscarPorId(id));
		} else {
			return ResponseEntity.notFound().build();

		}
	}

//	@GetMapping("/{nome}")
//	public ResponseEntity<List<Cliente>> buscarPorNome(@PathVariable String nome) {
//		return ResponseEntity.ok(clienteService.buscarPorNome(nome));
//	}

}
