package com.gherlan.petclinic.services.map;

import com.gherlan.petclinic.model.Owner;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OwnerServiceMapTest {

    private static final long OWNER_ID = 1L;

    private static final String LAST_NAME = "Smith";

    private OwnerServiceMap ownerServiceMap;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        Owner owner = new Owner();
        owner.setId(OWNER_ID);
        owner.setLastName(LAST_NAME);
        ownerServiceMap.save(owner);
    }

    @Test
    public void findAll() {
        Assertions.assertThat(ownerServiceMap.findAll()).hasSize(1);
    }

    @Test
    public void findById() {
        Assertions.assertThat(ownerServiceMap.findById(OWNER_ID)).isNotNull();
    }

    @Test
    void saveWithProvidedId() {
        long ownerId = 2L;
        Owner owner = new Owner();
        owner.setId(ownerId);
        Owner savedOwner = ownerServiceMap.save(owner);
        Assertions.assertThat(savedOwner.getId()).isEqualTo(ownerId);
    }

    @Test
    void saveWithNoId() {
        Owner savedOwner = ownerServiceMap.save(new Owner());
        Assertions.assertThat(savedOwner).isNotNull();
        Assertions.assertThat(savedOwner.getId()).isNotNull().isNotNegative();
    }

    @Test
    void findByLastName() {
        Owner foundOwner = ownerServiceMap.findByLastName(LAST_NAME);
        Assertions.assertThat(foundOwner).isNotNull();
        Assertions.assertThat(foundOwner.getLastName()).isEqualTo(LAST_NAME);
        Assertions.assertThat(foundOwner.getId()).isEqualTo(OWNER_ID);
    }

    @Test
    public void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(OWNER_ID));
        Assertions.assertThat(ownerServiceMap.findById(OWNER_ID)).isNull();
    }

    @Test
    public void deleteById() {
        ownerServiceMap.deleteById(OWNER_ID);
        Assertions.assertThat(ownerServiceMap.findById(OWNER_ID)).isNull();
    }
}