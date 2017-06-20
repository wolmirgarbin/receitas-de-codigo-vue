package br.com.viasoft.teste.microservicejpa.framework;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public abstract class DefaultCrudService<T, ID> implements CrudService<T, ID> {

    @Override
    public abstract JpaRepository<T, ID> getJpaRepository();

    @Override
    public List<T> find() {
        return getJpaRepository().findAll();
    }

    @Override
    public T get(@PathVariable ID id) {
        return getJpaRepository().findById(id).orElseGet(null);
    }

    @Override
    public T save(@RequestBody T entity) {
        return getJpaRepository().save(entity);
    }

    @Override
    public T update(@RequestBody T entity) {
        return getJpaRepository().save(entity);
    }

    @Override
    public void delete(@PathVariable ID id) {
        getJpaRepository().deleteById(id);
    }

    @Override
    public Long count() {
        return getJpaRepository().count();
    }
}
