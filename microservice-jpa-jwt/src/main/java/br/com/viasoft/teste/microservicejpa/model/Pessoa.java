package br.com.viasoft.teste.microservicejpa.model;

import br.com.viasoft.teste.microservicejpa.framework.EntityPattern;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name="PESSOA")
@Getter @Setter
public class Pessoa implements EntityPattern {

	private static final long serialVersionUID = -3837608453032874511L;

	@Id
	@Column(name="IDPESSOA")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name="NOME", length=60)
	private String nome;

	@Column(name="FANTASIA", length=80)
	private String fantasia;

	@Column(name="IDENTIFICACAO", length=20)
	private String identificacao;

	@Column(name="IE", length=30)
	private String ie;

	@JsonIgnore
	@OneToMany(fetch=FetchType.EAGER, mappedBy="pessoa")
	private Set<PessoaEmpresa> lsPesEmp;

	@Column(name="EMAILPRINC", length=120)
	private String emailPrincipal;

}