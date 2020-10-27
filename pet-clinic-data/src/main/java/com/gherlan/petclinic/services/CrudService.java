package com.gherlan.petclinic.services;

import java.util.Set;

public interface CrudService<T, ID> {

    T findById(ID id);

    T save(T t);

    Set<T> findAll();

    void delete(T t);

    void deleteById(ID id);

    long count();
}
