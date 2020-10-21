package com.gherlan.petclinic.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PetTypeTest {

    @Test
    void testEquals() {
        PetType petType1 = new PetType();
        petType1.setId(1L);

        PetType petType2 = new PetType();
        petType2.setId(1L);

        assertThat(petType1).isEqualTo(petType2);
    }

    @Test
    void testNotEquals() {
        PetType petType1 = new PetType();
        petType1.setId(1L);

        PetType petType2 = new PetType();
        petType2.setId(2L);

        assertThat(petType1).isNotEqualTo(petType2);
    }
}