package com.gherlan.petclinic.repositories;

import com.gherlan.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface VisitRepository extends CrudRepository<Visit, Long> {
    Set<Visit> findByPetId(Long petId);
}
