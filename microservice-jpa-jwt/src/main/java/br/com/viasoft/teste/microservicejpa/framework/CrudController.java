package br.com.viasoft.teste.microservicejpa.framework;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class CrudController<T, ID> {

    protected abstract CrudService<T, ID> getService();

    @GetMapping
    public List<T> find() {
        return getService().find();
    }

    @GetMapping("/{id}")
    public T get(@PathVariable ID id) {
        return getService().get(id);
    }

    @PostMapping
    public T save(@RequestBody T area) {
        return getService().save(area);
    }

    @PutMapping("/{id}")
    public T update(@RequestBody T area) {
        return getService().save(area);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ID id) {
        getService().delete(id);
    }

    @GetMapping("/count")
    public Long count() {
        return getService().count();
    }

}
