package com.gherlan.petclinic.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SpecialityTest {

    @Test
    void testEquals() {
        Speciality speciality1 = new Speciality();
        speciality1.setId(1L);

        Speciality speciality2 = new Speciality();
        speciality2.setId(1L);

        assertThat(speciality1).isEqualTo(speciality2);
    }

    @Test
    void testNotEquals() {
        Speciality speciality1 = new Speciality();
        speciality1.setId(1L);

        Speciality speciality2 = new Speciality();
        speciality2.setId(2L);

        assertThat(speciality1).isNotEqualTo(speciality2);
    }
}