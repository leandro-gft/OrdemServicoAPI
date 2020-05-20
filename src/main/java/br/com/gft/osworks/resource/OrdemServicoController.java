package br.com.gft.osworks.resource;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.apache.tomcat.jni.Status;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import br.com.gft.osworks.domain.model.Cliente;
import br.com.gft.osworks.domain.model.OrdemServico;
import br.com.gft.osworks.domain.model.StatusOrdemServico;

@RestController
@RequestMapping(value="/api/ordensdeservico")
public class OrdemServicoController {
		
	

}
