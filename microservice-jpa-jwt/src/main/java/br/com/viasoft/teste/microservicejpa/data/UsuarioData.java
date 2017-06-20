package br.com.viasoft.teste.microservicejpa.data;

import br.com.viasoft.teste.microservicejpa.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioData extends JpaRepository<Usuario, Long> {

    Usuario findByUsuario(String usuario);

}
