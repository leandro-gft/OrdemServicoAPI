package br.com.gft.osworks.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.gft.osworks.domain.model.Cliente;
import br.com.gft.osworks.domain.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

	public Cliente buscarPorId(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}

	public List<Cliente> buscarPorNome(String nome) {
		return clienteRepository.findByNomeContaining(nome);
	}
	
	public Cliente cadastrarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public void deletar(Long id) {
		clienteRepository.deleteById(id);
	}
}
