package com.gherlan.petclinic.services.sql;

import com.gherlan.petclinic.model.Owner;
import com.gherlan.petclinic.repositories.OwnerRepository;
import org.assertj.core.api.Assertions;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.Lob;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerServiceSQLTest {

    private static final long OWNER_ID = 1L;

    @Mock
    private OwnerRepository ownerRepository;

    @InjectMocks
    private OwnerServiceSQL ownerServiceSQL;

    @Test
    public void findAll() {
        Set<Owner> owners = new HashSet<>();
        Owner owner = new Owner();
        owner.setId(1L);
        owners.add(owner);

        Owner owner1 = new Owner();
        owner1.setId(2L);
        owners.add(owner1);

        when(ownerRepository.findAll()).thenReturn(owners);
        assertThat(ownerServiceSQL.findAll()).hasSize(2).isEqualTo(owners);
        verify(ownerRepository).findAll();
    }

    @Test
    public void findById() {
        Owner owner = new Owner();
        owner.setId(OWNER_ID);
        Optional<Owner> optionalOwner = Optional.of(owner);
        when(ownerRepository.findById(OWNER_ID)).thenReturn(optionalOwner);
        assertThat(ownerServiceSQL.findById(OWNER_ID)).isEqualTo(owner);
        verify(ownerRepository).findById(OWNER_ID);
    }

    @Test
    void save() {
        long ownerId = 2L;
        Owner owner = new Owner();
        owner.setId(ownerId);
        when(ownerRepository.save(owner)).thenReturn(owner);
        Owner savedOwner = ownerServiceSQL.save(owner);
        assertThat(savedOwner.getId()).isEqualTo(ownerId);
        verify(ownerRepository).save(owner);
    }

    @Test
    void findByLastName() {
        String lastName = "Mark";
        Owner owner = new Owner();
        owner.setId(1L);
        owner.setLastName(lastName);
        when(ownerRepository.findByLastName(lastName)).thenReturn(owner);
        assertThat(ownerServiceSQL.findByLastName(lastName)).isEqualTo(owner);
        verify(ownerRepository).findByLastName(lastName);
    }

    @Test
    public void delete() {
        Owner owner = new Owner();
        owner.setId(1L);
        ownerServiceSQL.delete(owner);
        verify(ownerRepository).delete(owner);
    }

    @Test
    public void deleteById() {
        long ownerId = 1L;
        ownerServiceSQL.deleteById(ownerId);
        verify(ownerRepository).deleteById(ownerId);
    }
}