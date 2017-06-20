package br.com.viasoft.teste.microservicejpa.model;

import br.com.viasoft.teste.microservicejpa.framework.EntityPattern;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="DOCUMENTOS")
@Getter @Setter
@XmlRootElement(name = "documento")
public class Documentos implements EntityPattern {

	private static final long serialVersionUID = -8559080241478164107L;

	@Id
	@Column(name="IDDOCUMENTOS")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name="ARQUIVO")
	private byte[] arquivo;

	@Column(name="NOME", length=200)
	private String nome;

	@Column(name="EXTENCAO", length=8)
	private String extencao;
	
}
