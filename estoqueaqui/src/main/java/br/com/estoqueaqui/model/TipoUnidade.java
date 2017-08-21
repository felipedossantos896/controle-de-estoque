package br.com.estoqueaqui.model;

public enum TipoUnidade {
	
	CAIXA("Caixa"),
	PACOTE("Pacote");
	
	private String descricao;
	
	TipoUnidade(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
