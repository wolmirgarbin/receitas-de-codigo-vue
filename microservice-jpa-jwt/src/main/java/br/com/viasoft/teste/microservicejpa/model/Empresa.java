package br.com.viasoft.teste.microservicejpa.model;

import br.com.viasoft.teste.microservicejpa.enumeration.SimNao;
import br.com.viasoft.teste.microservicejpa.framework.EntityPattern;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="EMPRESA")
@Getter @Setter
public class Empresa implements EntityPattern {

	private static final long serialVersionUID = -1515740354141095465L;

	@Id
	@Column(name="IDEMPRESA")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name="NOME", length=80)
	private String nome;

	@Column(name="IDENTIFICACAO", length=20)
	private String identificacao;

	@Column(name="UF", length=2)
	private String uf;

	@Column(name="CIDADE", length=100)
	private String cidade;

	@Column(name="BAIRRO", length=60)
	private String bairro;

	@Column(name="CEP", length=10)
	private String cep;

	@Column(name="RUA", length=60)
	private String rua;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IDEMPMATRIZ")
	private Empresa empresaMatriz;

	@Enumerated(EnumType.STRING)
	@Column(name="ATIVA", length=1)
	private SimNao ativa;

	@Column(name="UTC", length=6)
	private String utc;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDCONTRATANTE")
	private Contratante contratante;

}