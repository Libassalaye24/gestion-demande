package com.gestion.demande.gestiondemande.data.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_user", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("USER")
public class User extends AbstractType{
    private String username;
    private String fullName;
    private String email;
    private String emailPersonnel;
    private String password;
    private String adresse;
    private String avatar;

    @ManyToOne()
    private Role role;

}
