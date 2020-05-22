package br.com.gft.osworks.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gft.osworks.domain.model.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

	
}
