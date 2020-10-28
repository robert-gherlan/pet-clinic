package com.gherlan.petclinic.controllers;

import com.gherlan.petclinic.model.Owner;
import com.gherlan.petclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    private OwnerService ownerService;

    @InjectMocks
    private OwnerController ownerController;

    private Set<Owner> owners;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        owners = new HashSet<>();
        Owner owner = new Owner();
        owner.setId(1L);
        owners.add(owner);

        Owner owner1 = new Owner();
        owner1.setId(2L);
        owners.add(owner1);

        mockMvc = MockMvcBuilders
                .standaloneSetup(ownerController)
                .build();
    }

    @Test
    void findOwners() throws Exception {
        mockMvc.perform(get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/findOwners"))
                .andExpect(model().attributeExists("owner"));
        verifyNoInteractions(ownerService);
    }

    @Test
    void getOwnerById() throws Exception {
        Owner owner = new Owner();
        owner.setId(1L);
        when(ownerService.findById(1L)).thenReturn(owner);
        mockMvc.perform(get("/owners/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/owner"))
                .andExpect(model().attribute("owner", hasProperty("id", is(1L))));
        verify(ownerService, times(1)).findById(1L);
    }

    @Test
    void getAddOwner() throws Exception {
        mockMvc.perform(get("/owners/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/createOrUpdateOwner"))
                .andExpect(model().attributeExists("owner"));
        verifyNoInteractions(ownerService);
    }

    @Test
    void addOwner() throws Exception {
        Owner owner = new Owner();
        owner.setId(1L);
        when(ownerService.save(any())).thenReturn(owner);
        mockMvc.perform(post("/owners/new"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"))
                .andExpect(model().attributeExists("owner"));
        verify(ownerService).save(any());
    }

    @Test
    void getUpdateOwnerPage() throws Exception {
        Owner owner = new Owner();
        owner.setId(1L);
        when(ownerService.findById(1L)).thenReturn(owner);
        mockMvc.perform(get("/owners/1/edit"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/createOrUpdateOwner"))
                .andExpect(model().attributeExists("owner"));
        verify(ownerService).findById(1L);
    }

    @Test
    void updateOwner() throws Exception {
        Owner owner = new Owner();
        owner.setId(1L);
        when(ownerService.save(any())).thenReturn(owner);
        mockMvc.perform(post("/owners/1/edit"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"));
        verify(ownerService).save(any());
    }
}