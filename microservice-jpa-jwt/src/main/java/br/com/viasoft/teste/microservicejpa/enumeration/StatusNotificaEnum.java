package br.com.viasoft.teste.microservicejpa.enumeration;

import lombok.Getter;

@Getter
public enum StatusNotificaEnum {

	S("Enviado"), N("Não enviado"), E("Error");
	
	private String label;

	private StatusNotificaEnum(final String label) {
		this.label = label;
	}
	
}
