package br.com.viasoft.teste.microservicejpa.service.impl;

import br.com.viasoft.teste.microservicejpa.data.UsuarioData;
import br.com.viasoft.teste.microservicejpa.framework.DefaultCrudService;
import br.com.viasoft.teste.microservicejpa.model.Usuario;
import br.com.viasoft.teste.microservicejpa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends DefaultCrudService<Usuario, Long> implements UsuarioService {

    private final UsuarioData usuarioData;

    @Autowired
    public UsuarioServiceImpl(UsuarioData usuarioData) {
        this.usuarioData = usuarioData;
    }

    @Override
    public JpaRepository<Usuario, Long> getJpaRepository() {
        return usuarioData;
    }

}
