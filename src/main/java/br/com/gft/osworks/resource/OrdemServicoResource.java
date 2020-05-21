package br.com.gft.osworks.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.gft.osworks.domain.model.OrdemServico;
import br.com.gft.osworks.domain.service.OrdemServicoService;

@RestController
@RequestMapping(value = "/api/ordens-servico")
public class OrdemServicoResource {

	@Autowired
	private OrdemServicoService osService;

	@PostMapping
	public ResponseEntity<OrdemServico> criarOS(@RequestBody @Valid OrdemServico ordemServico) {
		osService.criar(ordemServico);
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(ordemServico.getId()).toUri()).body(ordemServico);
	}

	@GetMapping
	public ResponseEntity<List<OrdemServico>> buscarOrdens() {
		return ResponseEntity.ok(osService.listar());
	}

	@GetMapping("/{id}")
	public ResponseEntity<OrdemServico> buscarOrdensPorId(@PathVariable Long id) {
		OrdemServico os = osService.listarPorId(id);
		if (os != null) {
			return ResponseEntity.ok(os);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
