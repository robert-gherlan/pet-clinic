package com.gherlan.petclinic.repositories;

import com.gherlan.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Collection<Owner> findByLastName(String lastName);
}
