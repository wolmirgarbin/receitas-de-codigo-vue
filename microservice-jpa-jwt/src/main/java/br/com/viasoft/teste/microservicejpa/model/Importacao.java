package br.com.viasoft.teste.microservicejpa.model;

import br.com.viasoft.teste.microservicejpa.enumeration.OrdemDeProcessamentoEnum;
import br.com.viasoft.teste.microservicejpa.enumeration.StatusImportacaoEnum;
import br.com.viasoft.teste.microservicejpa.framework.EntityPattern;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="IMPORTACAO")
@Getter @Setter
public class Importacao implements EntityPattern {

	private static final long serialVersionUID = -1515740354141095465L;

	@Id
	@Column(name="IDIMPORTACAO")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name="NOME", length=300)
	private String nome;

	@Column(name="CAMINHO", length=600)
	private String caminho;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATAHORA")
	private Date dataHora;
	
	@Enumerated(EnumType.STRING)
	@Column(name="STATUSIMPORTACAO", length=1)
	private StatusImportacaoEnum statusImportacao;

	@Column(name="ERRO", length=60)
	private String erro;
	
	@Column(name="TIPO", length=3)
	private String tipo;
	
	@Column(name="EMPRESAS", length=200)
	private String empresas;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ORDEMPROCESSAMENTO", length=1)
	private OrdemDeProcessamentoEnum ordemProcessamento;
	
}