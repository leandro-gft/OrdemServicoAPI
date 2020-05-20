package br.com.gft.osworks.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrdemServico {

	private Long id;
	private String descricao;
	private BigDecimal preco;
	private LocalDateTime dataAbertura;
	private LocalDateTime dataFinalizacao;
	
	public OrdemServico() {
		
	}

	public OrdemServico(Long id, String descricao, BigDecimal preco, LocalDateTime dataAbertura, LocalDateTime dataFinalizacao) {
		this.id = id;
		this.descricao = descricao;
		this.preco = preco;
		this.dataAbertura = dataAbertura;
		this.dataFinalizacao = dataFinalizacao;
	}	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public LocalDateTime getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public LocalDateTime getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(LocalDateTime dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}
	
		
}
