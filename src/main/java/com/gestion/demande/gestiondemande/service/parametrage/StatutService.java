package com.gestion.demande.gestiondemande.service.parametrage;

import com.gestion.demande.gestiondemande.web.dto.communs.ParametrageRequestDto;

import java.util.Map;

public interface StatutService {

    ParametrageRequestDto save(ParametrageRequestDto request);

    ParametrageRequestDto update(Long id,ParametrageRequestDto request);

    public Map<String, Object> getAllStatuts(int page, int pageSize);

    ParametrageRequestDto getOne(Long id);

    void delete(Long id);

}
