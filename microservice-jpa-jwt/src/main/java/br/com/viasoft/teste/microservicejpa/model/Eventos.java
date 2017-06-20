package br.com.viasoft.teste.microservicejpa.model;

import br.com.viasoft.teste.microservicejpa.framework.EntityPattern;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="EVENTOS")
@Getter @Setter
public class Eventos implements EntityPattern {

	private static final long serialVersionUID = -6056231662393057766L;

	@Id
	@Column(name="IDEVENTOS")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@JoinColumn(name="IDDOCUMENTOS")
	@ManyToOne(fetch=FetchType.LAZY)
	private Documentos documento;
	
	@JoinColumn(name="IDNOTA")
	@ManyToOne(fetch=FetchType.LAZY)
	private Dfe dfe;
	
	@Column(name="DESCRICAO", length=20)
	private String descricao;
	
	@Column(name="SEQUENCIAL", length=20)
	private Integer sequencial;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DTEVENTO")
	private Date dtEvento;
	
	@Column(name="TIPO", length=20)
	private String tipo;
	
	@Column(name="CHAVE", length=60)
	private String chave;
	
	@Column(name="RETSTAT")
	private Integer retStat;
	
	@Column(name="RETMOTIVO", length=100)
	private String retMotivo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="RETDTAUTORIZA")
	private Date retDtAutoriza;
	
	@Column(name="RETPROTOCOLO", length=40)
	private String retProtocolo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DTHRCARREGADO", nullable=false)
	private Date dtHrCarregado;
}
