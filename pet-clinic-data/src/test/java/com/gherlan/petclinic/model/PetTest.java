package com.gherlan.petclinic.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PetTest {

    @Test
    void testEquals() {
        Pet pet1 = new Pet();
        pet1.setId(1L);

        Pet pet2 = new Pet();
        pet2.setId(1L);

        assertThat(pet1).isEqualTo(pet2);
    }

    @Test
    void testNotEquals() {
        Pet pet1 = new Pet();
        pet1.setId(1L);

        Pet pet2 = new Pet();
        pet2.setId(2L);

        assertThat(pet1).isNotEqualTo(pet2);
    }
}