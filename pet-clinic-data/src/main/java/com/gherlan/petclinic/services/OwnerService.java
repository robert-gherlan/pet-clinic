package com.gherlan.petclinic.services;

import com.gherlan.petclinic.model.Owner;

import java.util.Collection;

public interface OwnerService extends CrudService<Owner, Long> {
    Collection<Owner> findByLastNameContaining(String lastName);
}
