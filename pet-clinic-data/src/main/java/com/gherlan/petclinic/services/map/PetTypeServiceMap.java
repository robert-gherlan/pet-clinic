package com.gherlan.petclinic.services.map;


import com.gherlan.petclinic.model.PetType;
import com.gherlan.petclinic.services.CrudService;
import com.gherlan.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {

}
