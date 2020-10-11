package com.gherlan.petclinic.services.sql;

import com.gherlan.petclinic.model.Vet;
import com.gherlan.petclinic.repositories.VetRepository;
import com.gherlan.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("sql")
public class VetServiceSQL extends CrudServiceSQL<Vet, Long> implements VetService {

    public VetServiceSQL(VetRepository vetRepository) {
        super(vetRepository);
    }
}