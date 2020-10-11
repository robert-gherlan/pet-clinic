package com.gherlan.petclinic.services;

import com.gherlan.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
