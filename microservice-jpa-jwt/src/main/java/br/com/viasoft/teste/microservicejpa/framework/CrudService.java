package br.com.viasoft.teste.microservicejpa.framework;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CrudService<T, ID> {

    JpaRepository<T, ID> getJpaRepository();

    List<T> find();

    T get(ID id);

    T save(T entity);

    T update(T entity);

    void delete(ID id);

    Long count();

}
