package br.com.viasoft.teste.microservicejpa.model;

import br.com.viasoft.teste.microservicejpa.enumeration.SimNao;
import br.com.viasoft.teste.microservicejpa.framework.EntityPattern;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="GERENCIADORES")
@Getter @Setter
public class Gerenciadores implements EntityPattern {

	private static final long serialVersionUID = 5847339135265901604L;

	@Id
	@Column(name="IDGERENCIADORES")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="USUARIO", length=50, unique=true)
	private String usuario;
	
	@Column(name="SENHA", length=60)
	private String senha;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ATIVO", length=1)
	private SimNao ativo;
	
}
