package com.gherlan.petclinic.services.sql;

import com.gherlan.petclinic.model.Owner;
import com.gherlan.petclinic.repositories.OwnerRepository;
import com.gherlan.petclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Profile("sql")
public class OwnerServiceSQL extends CrudServiceSQL<Owner, Long> implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerServiceSQL(OwnerRepository ownerRepository) {
        super(ownerRepository);
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Collection<Owner> findByLastNameContaining(String lastName) {
        return ownerRepository.findByLastNameContaining(lastName);
    }
}
