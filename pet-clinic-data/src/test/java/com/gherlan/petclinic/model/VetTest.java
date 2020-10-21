package com.gherlan.petclinic.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class VetTest {

    @Test
    void testEquals() {
        Vet vet1 = new Vet();
        vet1.setId(1L);

        Vet vet2 = new Vet();
        vet2.setId(1L);

        assertThat(vet1).isEqualTo(vet2);
    }

    @Test
    void testNotEquals() {
        Vet vet1 = new Vet();
        vet1.setId(1L);

        Vet vet2 = new Vet();
        vet2.setId(2L);

        assertThat(vet1).isNotEqualTo(vet2);
    }
}