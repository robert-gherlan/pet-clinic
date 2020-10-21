package com.gherlan.petclinic.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VisitTest {

    @Test
    void testEquals() {
        Visit visit1 = new Visit();
        visit1.setId(1L);

        Visit visit2 = new Visit();
        visit2.setId(1L);

        assertThat(visit1).isEqualTo(visit2);
    }

    @Test
    void testNotEquals() {
        Visit visit1 = new Visit();
        visit1.setId(1L);

        Visit visit2 = new Visit();
        visit2.setId(2L);

        assertThat(visit1).isNotEqualTo(visit2);
    }
}