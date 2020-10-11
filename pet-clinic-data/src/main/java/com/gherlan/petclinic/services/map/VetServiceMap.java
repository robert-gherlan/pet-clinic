package com.gherlan.petclinic.services.map;

import com.gherlan.petclinic.model.Speciality;
import com.gherlan.petclinic.model.Vet;
import com.gherlan.petclinic.services.CrudService;
import com.gherlan.petclinic.services.SpecialityService;
import com.gherlan.petclinic.services.VetService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Profile({"default", "map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    @Override
    public Vet save(Vet vet) {
        vet.getSpecialities().forEach(speciality -> {
            if (speciality.getId() == null) {
                Speciality savedSpeciality = specialityService.save(speciality);
                speciality.setId(savedSpeciality.getId());
            }
        });

        return super.save(vet);
    }
}
