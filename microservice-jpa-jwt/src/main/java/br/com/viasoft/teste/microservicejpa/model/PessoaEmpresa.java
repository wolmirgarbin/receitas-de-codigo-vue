package br.com.viasoft.teste.microservicejpa.model;

import br.com.viasoft.teste.microservicejpa.framework.EntityPattern;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="PESSOAEMPRESA")
@Getter @Setter
public class PessoaEmpresa implements EntityPattern {

	private static final long serialVersionUID = -6687246361028978365L;

	@Id
	@Column(name="IDPESSOAEMPRESA")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@JoinColumn(name="IDEMPRESA")
	@ManyToOne(fetch=FetchType.EAGER)
	private Empresa empresa;
	
	@JoinColumn(name="IDPESSOA")
	@ManyToOne(fetch=FetchType.EAGER)
	private Pessoa pessoa;
	
	/*@Column(name="EMAIL", length=200)
	private String email;*/ 
	
}