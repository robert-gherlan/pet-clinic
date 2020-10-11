package com.gherlan.petclinic.services.sql;

import com.gherlan.petclinic.model.PetType;
import com.gherlan.petclinic.repositories.PetTypeRepository;
import com.gherlan.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("sql")
public class PetTypeServiceSQL extends CrudServiceSQL<PetType, Long> implements PetTypeService {

    public PetTypeServiceSQL(PetTypeRepository petTypeRepository) {
        super(petTypeRepository);
    }
}
