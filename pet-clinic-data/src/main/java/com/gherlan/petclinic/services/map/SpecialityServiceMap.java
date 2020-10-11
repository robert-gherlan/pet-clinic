package com.gherlan.petclinic.services.map;

import com.gherlan.petclinic.model.Speciality;
import com.gherlan.petclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class SpecialityServiceMap extends AbstractMapService<Speciality, Long> implements SpecialityService {

}
