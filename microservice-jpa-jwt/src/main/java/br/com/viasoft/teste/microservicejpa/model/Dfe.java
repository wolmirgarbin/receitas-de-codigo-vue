package br.com.viasoft.teste.microservicejpa.model;

import br.com.viasoft.teste.microservicejpa.enumeration.SimNao;
import br.com.viasoft.teste.microservicejpa.enumeration.StatusNotificaEnum;
import br.com.viasoft.teste.microservicejpa.enumeration.TipoDocumento;
import br.com.viasoft.teste.microservicejpa.framework.EntityPattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DFE")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dfe implements EntityPattern {

    private static final long serialVersionUID = -1626621025738624132L;

    @Id
    @Column(name="IDNOTA")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @JoinColumn(name="IDNFE")
    @ManyToOne(fetch=FetchType.LAZY)
    private Documentos docNfe;

    @JoinColumn(name="IDDANF")
    @ManyToOne(fetch=FetchType.LAZY)
    private Documentos docDanf;

    @JoinColumn(name="IDPESSOAEMITENTE")
    @ManyToOne(fetch=FetchType.LAZY)
    private Pessoa emitente;

    @JoinColumn(name="IDPESSOADESTINATARIO")
    @ManyToOne(fetch=FetchType.LAZY)
    private Pessoa destinatario;

    @Column(name="CHAVE", length=60)
    private String chave;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="DTEMISSAO")
    private Date dtEmissao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="DTSAIDA")
    private Date dtSaida;

    @Column(name="NUMERO")
    private Integer numero;

    @Column(name="SERIE", length=3)
    private String serie;

    @Column(name="NATOP", length=60)
    private String natop;

    @Column(name="TIPOEMISSAO")
    private Integer tipoEmissao;

    @Column(name="TIPOAMB")
    private Integer tipoAmb;

    @Column(name="VNF")
    private Double vnf;

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

    @Enumerated(EnumType.STRING)
    @Column(name="SINCRONIZADO")
    private SimNao sincronizado;

    @Enumerated(EnumType.STRING)
    @Column(name="NFEOUCTE", length=3)
    private TipoDocumento nfeOuCte;

    @Enumerated(EnumType.STRING)
    @Column(name="NOTIFICADOEMAIL", length=1)
    private StatusNotificaEnum notificadoEmail;

}
