package br.com.viasoft.teste.microservicejpa.enumeration;

import lombok.Getter;

@Getter
public enum StatusImportacaoEnum {
	
	B("Baixado"), P("Em processamento"), E("Erro"), C("Concluido e não deletada");
	
	private String label;

	private StatusImportacaoEnum(final String label) {
		this.label = label;
	}

}
