package br.com.gft.osworks.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gft.osworks.domain.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
