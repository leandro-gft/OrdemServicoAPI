package br.com.gft.osworks.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gft.osworks.domain.exception.NegocioException;
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
		Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());
		if (clienteExistente != null && !clienteExistente.equals(cliente)) {
			throw new NegocioException("Já existe um cliente cadastrado com esse e-mail");
		} 
			return clienteRepository.save(cliente);		 
	}

	public void deletar(Long id) {
		clienteRepository.deleteById(id);
	}

	public void atualizar(Cliente cliente, Long id) {
		cliente.setId(id);
		cadastrarCliente(cliente);
	}
}
