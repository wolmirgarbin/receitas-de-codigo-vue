package br.com.viasoft.teste.microservicejpa.model;

import br.com.viasoft.teste.microservicejpa.enumeration.SimNao;
import br.com.viasoft.teste.microservicejpa.framework.EntityPattern;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="USUARIOEMPRESA")
@Getter @Setter
public class UsuarioEmpresa implements EntityPattern {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="IDUSUEMP")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IDEMPRESA")
	private Empresa empresa;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IDUSUARIO")
	private Usuario usuario;
	
	@Enumerated(EnumType.STRING)
	@Column(name="PADRAO", length=1)
	private SimNao padrao;

}