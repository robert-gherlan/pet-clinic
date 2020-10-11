package com.gherlan.petclinic.services.sql;

import com.gherlan.petclinic.model.Speciality;
import com.gherlan.petclinic.repositories.SpecialityRepository;
import com.gherlan.petclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("sql")
public class SpecialityServiceSQL extends CrudServiceSQL<Speciality, Long> implements SpecialityService {

    public SpecialityServiceSQL(SpecialityRepository specialityRepository) {
        super(specialityRepository);
    }
}