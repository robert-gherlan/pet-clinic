package com.gherlan.petclinic.services.sql;

import com.gherlan.petclinic.model.Pet;
import com.gherlan.petclinic.repositories.PetRepository;
import com.gherlan.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("sql")
public class PetServiceSQL extends CrudServiceSQL<Pet, Long> implements PetService {

    public PetServiceSQL(PetRepository petRepository) {
        super(petRepository);
    }
}
