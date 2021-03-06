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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.gft.osworks.api.model.ComentarioModel;
import br.com.gft.osworks.api.model.OrdemServicoInput;
import br.com.gft.osworks.api.model.OrdemServicoModel;
import br.com.gft.osworks.domain.model.Comentario;
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
	public ResponseEntity<OrdemServicoModel> criarOS(@RequestBody @Valid OrdemServicoInput ordemServicoInput) {
		OrdemServico os = osService.criar(toEntity(ordemServicoInput));
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(ordemServicoInput.getCliente().getId()).toUri()).body(toModel(os));
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
	
	@PostMapping("/{id}/comentarios")
	public ResponseEntity<ComentarioModel> postar(@PathVariable Long id, @RequestBody Comentario comentario){
		comentario = osService.postarComentario(id, comentario);
		return ResponseEntity.
				created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(comentario.getId()).toUri()).
				body(comentarioToModel(comentario));
	}
	
	
	@GetMapping("/{id}/comentarios")
	public ResponseEntity<List<ComentarioModel>> listar(@PathVariable Long id){
		return ResponseEntity.ok().body(toComentarioList(osService.listarComentarios(id)));
		
	}

	
	@PutMapping("/{id}/finalizacao")
	public ResponseEntity<Void> finalizarOs(@PathVariable Long id){
			osService.finalizar(id);
			
			return ResponseEntity.noContent().build();
			
		}
	
	
	public OrdemServicoModel toModel(OrdemServico os) {
		return mapper.map(os, OrdemServicoModel.class);
	}
	
	public ComentarioModel comentarioToModel(Comentario comentario) {
		return mapper.map(comentario, ComentarioModel.class);
	}
	
	public List<ComentarioModel> toComentarioList(List<Comentario> comentarios){
		return comentarios.stream().map(comentario -> comentarioToModel(comentario)).collect(Collectors.toList());
	}

	public List<OrdemServicoModel> toModelList(List<OrdemServico> os) {
		return os.stream().map(ordemServico -> toModel(ordemServico)).collect(Collectors.toList());
	}
	
	public OrdemServico toEntity(OrdemServicoInput osi) {
		return mapper.map(osi, OrdemServico.class);
	}

}
 