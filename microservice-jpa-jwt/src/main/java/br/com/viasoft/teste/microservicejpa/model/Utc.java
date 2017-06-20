package br.com.viasoft.teste.microservicejpa.model;

import br.com.viasoft.teste.microservicejpa.framework.EntityPattern;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="UTC")
@Getter @Setter
public class Utc implements EntityPattern {

	private static final long serialVersionUID = 599876220256078169L;

	@Id
	@Column(name="IDUTC")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name="VALOR", length=6)
	private String valor;

	@Column(name="DESCRICAO", length=50)
	private String descricao;

}