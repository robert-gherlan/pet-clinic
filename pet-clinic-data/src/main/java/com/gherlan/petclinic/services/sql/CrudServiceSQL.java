package com.gherlan.petclinic.services.sql;

import com.gherlan.petclinic.model.Pet;
import com.gherlan.petclinic.services.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
public abstract class CrudServiceSQL<T, ID> implements CrudService<T, ID> {

    private final CrudRepository<T, ID> crudRepository;

    @Override
    public T findById(ID id) {
        return crudRepository.findById(id).orElse(null);
    }

    @Override
    public T save(T t) {
        return crudRepository.save(t);
    }

    @Override
    public Set<T> findAll() {
        Set<T> values = new HashSet<>();
        crudRepository.findAll().forEach(values::add);
        return values;
    }

    @Override
    public void delete(T t) {
        crudRepository.delete(t);
    }

    @Override
    public void deleteById(ID id) {
        crudRepository.deleteById(id);
    }
}
