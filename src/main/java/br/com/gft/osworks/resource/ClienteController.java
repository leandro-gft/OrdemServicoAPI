package br.com.gft.osworks.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Cliente>> buscarPorNome(@PathVariable String nome) {
		return ResponseEntity.ok(clienteService.buscarPorNome(nome));
	}

	@PostMapping
	public ResponseEntity<Cliente> salvarCliente(@RequestBody Cliente cliente) {
		clienteService.cadastrarCliente(cliente);
		return ResponseEntity.created(
				ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId()).toUri())
				.body(cliente);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
		if (clienteService.buscarPorId(id) != null) {
		clienteService.deletar(id);
		return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizarCliente(@RequestBody Cliente cliente, @PathVariable Long id) {
		if (clienteService.buscarPorId(id) != null) {
			clienteService.atualizar(cliente, id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
