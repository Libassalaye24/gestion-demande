package com.gestion.demande.gestiondemande.web.dto.communs;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ParametrageRequestDto {

    private Long id;
    private boolean active = true;
    private String name;
    private String code;

}
