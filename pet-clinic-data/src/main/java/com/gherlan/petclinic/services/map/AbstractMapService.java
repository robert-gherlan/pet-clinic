package com.gherlan.petclinic.services.map;

import com.gherlan.petclinic.model.BaseEntity;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    private final Map<Long, T> storage;

    public AbstractMapService() {
        this.storage = new ConcurrentHashMap<>();
    }

    public Set<T> findAll() {
        return new HashSet<>(storage.values());
    }

    public T findById(ID id) {
        if (Objects.isNull(id)) {
            return null;
        }

        return storage.get(id);
    }

    public T save(T t) {
        if (t != null) {
            if (t.getId() == null) {
                t.setId(getNextId());
            }
            storage.put(t.getId(), t);
        } else {
            throw new IllegalArgumentException("The object can't be null.");
        }
        return t;
    }

    public void deleteById(ID id) {
        Optional.ofNullable(id).ifPresent(storage::remove);
    }

    public void delete(T t) {
        storage.entrySet().removeIf(entry -> entry.getValue().equals(t));
    }

    public long count() {
        return storage.size();
    }

    private Long getNextId() {
        long nextId = 1;
        try {
            nextId = Collections.max(storage.keySet()) + 1;
        } catch (NoSuchElementException e) {
            // Stay silent.
        }

        return nextId;
    }

}
