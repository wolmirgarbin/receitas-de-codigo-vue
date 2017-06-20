package br.com.viasoft.teste.microservicejpa.service.impl;

import br.com.viasoft.teste.microservicejpa.data.DfeData;
import br.com.viasoft.teste.microservicejpa.framework.DefaultCrudService;
import br.com.viasoft.teste.microservicejpa.model.Dfe;
import br.com.viasoft.teste.microservicejpa.service.DfeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DfeServiceImpl extends DefaultCrudService<Dfe, Long> implements DfeService {

    private final DfeData dfeData;

    @Autowired
    public DfeServiceImpl(DfeData dfeData) {
        this.dfeData = dfeData;
    }

    @Override
    public JpaRepository<Dfe, Long> getJpaRepository() {
        return dfeData;
    }

}
