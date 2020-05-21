package br.com.gft.osworks.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gft.osworks.domain.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	List<Cliente> findByNomeContaining(String nome);
	Cliente findByEmail(String email);
	
	
}
