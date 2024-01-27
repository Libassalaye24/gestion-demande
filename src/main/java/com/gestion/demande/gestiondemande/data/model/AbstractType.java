package com.gestion.demande.gestiondemande.data.model;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@MappedSuperclass
public abstract class AbstractType  extends AbstractEntity{
    private String name;
    private String code;

    public AbstractType(Long id) {
        super(id);
    }
    public AbstractType() {
    }
}
