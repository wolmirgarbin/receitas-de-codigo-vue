package br.com.viasoft.teste.microservicejpa.model;

import br.com.viasoft.teste.microservicejpa.enumeration.SimNao;
import br.com.viasoft.teste.microservicejpa.framework.EntityPattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "USUARIO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements EntityPattern {

    private static final long serialVersionUID = 5847339135265901604L;

    @Id
    @Column(name="IDUSUARIO")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @JoinColumn(name="IDPESSOA")
    @ManyToOne(fetch=FetchType.EAGER)
    private Pessoa pessoa;

    @Column(name="USUARIO", length=20, unique=true)
    @NotBlank(message="{usuario.usuario.vazio}")
    @Size(min=11, max=18, message="{usuario.usuario.tamanho}")
    private String usuario;

    @Column(name="SENHA", length=100)
    @NotBlank(message="{usuario.senha.vazio}")
    @Size(min=3, message="{usuario.senha.tamanho}")
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(name="ATIVO", length=1)
    private SimNao ativo;

    @Enumerated(EnumType.STRING)
    @Column(name="MUDOUSENHA", length=1)
    private SimNao mudouSenha;

	/*@Enumerated(EnumType.STRING)
	@Column(name="ROLE", length=30)
	private Roles role;*/

    /**
     * Campo é apenas para usuários da empresa que podem ser administradores, isso para poder ter sempre uma empresa base, esta empresa precisa estar na lista abaixo
     */
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="IDEMPRESABASE")
    private Empresa empresaBase;

    /**
     * Lista de empresas que o usuário tem acesso
     */
    @OneToMany(fetch=FetchType.EAGER, mappedBy="usuario")
    private Set<UsuarioEmpresa> lsUsuarioEmpresa;

    @Enumerated(EnumType.STRING)
    @Column(name="AJUDA", length=1)
    private SimNao ajuda;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="IDCONTRATANTE")
    private Contratante contratante;

}
