package br.com.gft.osworks.resource;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.gft.osworks.api.model.OrdemServicoModel;
import br.com.gft.osworks.domain.model.OrdemServico;
import br.com.gft.osworks.domain.service.OrdemServicoService;

@RestController
@RequestMapping(value = "/api/ordens-servico")
public class OrdemServicoResource {

	@Autowired
	private OrdemServicoService osService;

	@Autowired
	private ModelMapper mapper;

	@PostMapping
	public ResponseEntity<OrdemServicoModel> criarOS(@RequestBody @Valid OrdemServico ordemServico) {
		osService.criar(ordemServico);
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(ordemServico.getId()).toUri()).body(toModel(ordemServico));
	}

	@GetMapping
	public ResponseEntity<List<OrdemServicoModel>> buscarOrdens() {
		return ResponseEntity.ok(toModelList(osService.listar()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<OrdemServicoModel> buscarOrdensPorId(@PathVariable Long id) {
		OrdemServico os = osService.listarPorId(id);
		if (os != null) {
			return ResponseEntity.ok(toModel(os));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	public OrdemServicoModel toModel(OrdemServico os) {
		return mapper.map(os, OrdemServicoModel.class);
	}

	public List<OrdemServicoModel> toModelList(List<OrdemServico> os) {
		return os.stream().map(ordemServico -> toModel(ordemServico)).collect(Collectors.toList());
	}

}
 