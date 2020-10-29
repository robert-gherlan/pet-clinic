package com.gherlan.petclinic.controllers;

import com.gherlan.petclinic.model.Owner;
import com.gherlan.petclinic.model.Pet;
import com.gherlan.petclinic.model.PetType;
import com.gherlan.petclinic.services.OwnerService;
import com.gherlan.petclinic.services.PetService;
import com.gherlan.petclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class PetControllerTest {

    @Mock
    private PetService petService;

    @Mock
    private OwnerService ownerService;

    @Mock
    private PetTypeService petTypeService;

    @InjectMocks
    private PetController petController;

    private MockMvc mockMvc;

    private Owner owner;

    private Set<PetType> petTypes;

    @BeforeEach
    void setUp() {
        owner = new Owner();
        owner.setId(1L);

        petTypes = new HashSet<>();

        PetType dogPetType = new PetType();
        dogPetType.setId(1L);
        dogPetType.setName("Dog");

        PetType catPetType = new PetType();
        catPetType.setId(2L);
        catPetType.setName("Cat");

        petTypes.add(dogPetType);
        petTypes.add(catPetType);

        mockMvc = MockMvcBuilders.standaloneSetup(petController).addPlaceholderValue("ownerId", "1").build();
    }

    @Test
    void initCreationForm() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(owner);
        when(petTypeService.findAll()).thenReturn(petTypes);

        mockMvc.perform(get("/owners/1/pets/new"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("owner"))
                .andExpect(model().attributeExists("pet"))
                .andExpect(view().name("pets/createOrUpdatePet"));
    }

    @Test
    void processCreationForm() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(owner);
        when(petTypeService.findAll()).thenReturn(petTypes);

        mockMvc.perform(post("/owners/1/pets/new"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/owners/1"));

        verify(petService).save(any());
    }

    @Test
    void initUpdateForm() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(owner);
        when(petTypeService.findAll()).thenReturn(petTypes);
        Pet pet = new Pet();
        pet.setId(2L);
        when(petService.findById(anyLong())).thenReturn(pet);

        mockMvc.perform(get("/owners/1/pets/2/edit"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("owner"))
                .andExpect(model().attributeExists("pet"))
                .andExpect(view().name("pets/createOrUpdatePet"));
    }

    @Test
    void processUpdateForm() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(owner);
        when(petTypeService.findAll()).thenReturn(petTypes);
        mockMvc.perform(post("/owners/1/pets/2/edit"))
                .andExpect(status().is3xxRedirection())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(redirectedUrl("/owners/1"));

        verify(petService).save(any());
    }
}
