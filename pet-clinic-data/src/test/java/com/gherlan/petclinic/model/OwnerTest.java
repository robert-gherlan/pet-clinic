package com.gherlan.petclinic.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OwnerTest {

    @Test
    void testEquals() {
        Owner owner1 = new Owner();
        owner1.setId(1L);

        Owner owner2 = new Owner();
        owner2.setId(1L);

        assertThat(owner1).isEqualTo(owner2);
    }

    @Test
    void testNotEquals() {
        Owner owner1 = new Owner();
        owner1.setId(1L);

        Owner owner2 = new Owner();
        owner2.setId(2L);

        assertThat(owner1).isNotEqualTo(owner2);
    }
}