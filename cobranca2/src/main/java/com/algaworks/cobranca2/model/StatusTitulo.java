package com.algaworks.cobranca2.model;

public enum StatusTitulo {

	PENDENTE("pendente"),
	RECEBIDO("recebido");
	
	public String descricao;

	private StatusTitulo(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
}
