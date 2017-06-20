
package br.com.viasoft.teste.microservicejpa.model;

import br.com.viasoft.teste.microservicejpa.framework.EntityPattern;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name="OUTROSENVOLVIDOS")
@Getter @Setter
public class OutrosEnvolvidos implements EntityPattern {

	private static final long serialVersionUID = -3837608453032874511L;

	@Id
	@Column(name="IDOUTROSENVOLVIDOS")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name="TIPO", length=20)
	private String tipo;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IDPESSOA")
	private Pessoa pessoa;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IDNOTA")
	private Dfe dfe;

}