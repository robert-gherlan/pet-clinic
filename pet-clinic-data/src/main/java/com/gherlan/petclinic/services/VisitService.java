package com.gherlan.petclinic.services;

import com.gherlan.petclinic.model.Visit;

import java.util.Set;

public interface VisitService extends CrudService<Visit, Long> {
    Set<Visit> findByPetId(Long petId);
}
