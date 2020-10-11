package com.gherlan.petclinic.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "specilities")
public class Speciality extends BaseEntity {

    @Column(name = "description")
    private String description;
}
