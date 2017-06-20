package br.com.viasoft.teste.microservicejpa.controller;

import br.com.viasoft.teste.microservicejpa.framework.CrudController;
import br.com.viasoft.teste.microservicejpa.framework.CrudService;
import br.com.viasoft.teste.microservicejpa.model.Dfe;
import br.com.viasoft.teste.microservicejpa.service.DfeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dfe")
public class DfeController extends CrudController<Dfe, Long> {

    private final DfeService dfeService;

    @Autowired
    public DfeController(DfeService dfeService) {
        this.dfeService = dfeService;
    }

    @Override
    protected CrudService<Dfe, Long> getService() {
        return dfeService;
    }
}
