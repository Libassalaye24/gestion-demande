package com.gestion.demande.gestiondemande.service.parametrage.implement;

import com.gestion.demande.gestiondemande.data.model.Statut;
import com.gestion.demande.gestiondemande.data.repository.StatutRepository;
import com.gestion.demande.gestiondemande.service.mapper.MapperService;
import com.gestion.demande.gestiondemande.service.mapper.PageListMapper;
import com.gestion.demande.gestiondemande.service.parametrage.StatutService;
import com.gestion.demande.gestiondemande.web.dto.communs.ParametrageRequestDto;
import com.gestion.demande.gestiondemande.web.exceptions.BadRequestException;
import com.gestion.demande.gestiondemande.web.exceptions.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class StatutServiceImplement implements StatutService {

    private final StatutRepository statutRepository;
    @Override
    public ParametrageRequestDto save(ParametrageRequestDto request) {
        Statut statut = MapperService.mapToEntity(request,Statut.class);
        return MapperService.mapToEntity(statutRepository.save(statut),ParametrageRequestDto.class);
    }

    @Override
    public ParametrageRequestDto update(Long id, ParametrageRequestDto request) {
        if (request == null) throw new BadRequestException("Request must not be null");
        Statut statut = statutRepository.findById(id).orElse(null);
        if (statut == null) throw new EntityNotFoundException("Statut not found provided id");
        Statut saved = MapperService.mapToEntity(request,Statut.class);
        saved.setId(id);
        return MapperService.mapToEntity(statutRepository.save(saved),ParametrageRequestDto.class);
    }

    @Override
    public Map<String, Object> getAllStatuts(int page, int pageSize) {
        Pageable paging = PageRequest.of(page, pageSize);
        Page<Statut> tPage = statutRepository.findAllByActiveTrue(paging);
        return PageListMapper.getPageToMapObject(
                tPage.getContent(),
                tPage.getNumber(),
                tPage.getTotalElements(),
                tPage.getTotalPages()
        );
    }

    @Override
    public ParametrageRequestDto getOne(Long id) {
        Statut statut = statutRepository.findById(id).orElse(null);
        if (statut == null) throw new EntityNotFoundException("Statut not found provided id");
        return MapperService.mapToEntity(statut,ParametrageRequestDto.class);
    }

    @Override
    public void delete(Long id) {
        Statut statut = statutRepository.findById(id).orElse(null);
        if (statut == null) throw new EntityNotFoundException("Statut not found provided id");
        statutRepository.delete(statut);
    }
}
