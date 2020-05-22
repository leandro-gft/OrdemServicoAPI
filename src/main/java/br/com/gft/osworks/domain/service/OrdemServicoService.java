package br.com.gft.osworks.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gft.osworks.domain.exception.NegocioException;
import br.com.gft.osworks.domain.model.Comentario;
import br.com.gft.osworks.domain.model.OrdemServico;
import br.com.gft.osworks.domain.repository.ClienteRepository;
import br.com.gft.osworks.domain.repository.ComentarioRepository;
import br.com.gft.osworks.domain.repository.OrdemServicoRepository;

@Service
public class OrdemServicoService {

	@Autowired
	private OrdemServicoRepository osRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ComentarioRepository comentarioRepository;
	
	
	public OrdemServico criar(OrdemServico ordemServico) {
		ordemServico.setCliente(
				clienteRepository.
				findById(ordemServico.getCliente().getId()).
				orElseThrow(() -> new NegocioException("Cliente não encontrado"))
				);
		return osRepository.save(ordemServico);
	}
	
	public List<OrdemServico> listar(){
		return osRepository.findAll();
	}
	
	public OrdemServico listarPorId(Long id){
		return osRepository.findById(id).orElse(null);
	}
	
	public Comentario postarComentario(Long id, Comentario comentario) {
		OrdemServico os = osRepository.findById(id).orElseThrow(()-> new NegocioException("Ordem de serviço não encontrada")); 
		comentario.setOrdem(os);
		return comentarioRepository.save(comentario);
	}	
	
}
