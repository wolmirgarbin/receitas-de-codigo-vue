package br.com.viasoft.teste.microservicejpa.enumeration;

import lombok.Getter;

@Getter
public enum OrdemDeProcessamentoEnum {

	A("Todos os xml das notas"),
	B("Todos os eventos das notas"),
	C("Todos os pdf");
	
	private String label;

	private OrdemDeProcessamentoEnum(final String label) {
		this.label = label;
	}
	
}
