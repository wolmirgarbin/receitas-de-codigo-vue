package br.com.viasoft.teste.microservicejpa.controller;

import br.com.viasoft.teste.microservicejpa.framework.CrudController;
import br.com.viasoft.teste.microservicejpa.framework.CrudService;
import br.com.viasoft.teste.microservicejpa.model.Usuario;
import br.com.viasoft.teste.microservicejpa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController extends CrudController<Usuario, Long> {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    protected CrudService<Usuario, Long> getService() {
        return usuarioService;
    }
}
