package com.gherlan.petclinic.services.map;

import com.gherlan.petclinic.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class PetServiceMapTest {
    private final Long petId = 1L;
    private PetServiceMap petMapService;

    @BeforeEach
    void setUp() {
        petMapService = new PetServiceMap();
        Pet pet = new Pet();
        pet.setId(petId);
        petMapService.save(pet);
    }

    @Test
    void findAll() {
        Set<Pet> petSet = petMapService.findAll();
        assertThat(petSet).hasSize(1);
    }

    @Test
    void findByIdExistingId() {
        Pet pet = petMapService.findById(petId);
        assertThat(pet.getId()).isEqualTo(petId);
    }

    @Test
    void findByIdNotExistingId() {
        Pet pet = petMapService.findById(5L);
        assertThat(pet).isNull();
    }

    @Test
    void findByIdNullId() {
        Pet pet = petMapService.findById(null);
        assertThat(pet).isNull();
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Pet pet2 = new Pet();
        pet2.setId(id);

        Pet savedPet = petMapService.save(pet2);
        assertThat(savedPet.getId()).isEqualTo(id);
    }

    @Test
    void saveDuplicateId() {
        Long id = 1L;
        Pet pet2 = new Pet();
        pet2.setId(id);
        Pet savedPet = petMapService.save(pet2);
        assertThat(savedPet.getId()).isEqualTo(id);
        assertThat(petMapService.findAll()).hasSize(1);
    }

    @Test
    void saveNoId() {
        Pet savedPet = petMapService.save(new Pet());
        assertThat(savedPet).isNotNull();
        assertThat(savedPet.getId()).isNotNull();
        assertThat(petMapService.findAll()).hasSize(2);
    }

    @Test
    void deletePet() {
        petMapService.delete(petMapService.findById(petId));
        assertThat(petMapService.findAll()).isEmpty();
    }

    @Test
    void deleteWithWrongId() {
        Pet pet = new Pet();
        pet.setId(5L);

        petMapService.delete(pet);
        assertThat(petMapService.findAll()).hasSize(1);
    }

    @Test
    void deleteWithNullId() {
        petMapService.delete(new Pet());
        assertThat(petMapService.findAll()).hasSize(1);
    }

    @Test
    void deleteNull() {
        petMapService.delete(null);
        assertThat(petMapService.findAll()).hasSize(1);
    }

    @Test
    void deleteByIdCorrectId() {
        petMapService.deleteById(petId);
        assertThat(petMapService.findAll()).isEmpty();
    }

    @Test
    void deleteByIdWrongId() {
        petMapService.deleteById(5L);
        assertThat(petMapService.findAll()).hasSize(1);
    }

    @Test
    void deleteByIdNullId() {
        petMapService.deleteById(null);
        assertThat(petMapService.findAll()).hasSize(1);
    }
}
