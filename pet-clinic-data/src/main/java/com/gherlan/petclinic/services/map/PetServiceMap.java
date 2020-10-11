package com.gherlan.petclinic.services.map;


import com.gherlan.petclinic.model.Pet;
import com.gherlan.petclinic.services.CrudService;
import com.gherlan.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

}
