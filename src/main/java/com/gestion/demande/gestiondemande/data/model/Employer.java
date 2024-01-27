package com.gestion.demande.gestiondemande.data.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@DiscriminatorValue("EMPLOYER")
public class Employer extends User{

    private Integer soldeConge = 24;
    private Integer nombreEnfants;
    private LocalDate dateNaissance;
    @Column(columnDefinition = "boolean default false")
    private boolean conge=false;

    @ManyToOne
    @JoinColumn(name = "statut", referencedColumnName = "id")
    private Statut statut;

    @ManyToOne
    @JoinColumn(name = "departement", referencedColumnName = "id")
    private Departement departement;


    @OneToOne()
    @JoinColumn(name = "chef", referencedColumnName = "id",unique = false)
    private Employer chef;

}
