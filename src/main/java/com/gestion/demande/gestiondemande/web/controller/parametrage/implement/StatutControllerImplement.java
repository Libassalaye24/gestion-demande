package com.gestion.demande.gestiondemande.web.controller.parametrage.implement;

import com.gestion.demande.gestiondemande.service.parametrage.StatutService;
import com.gestion.demande.gestiondemande.web.controller.parametrage.StatutController;
import com.gestion.demande.gestiondemande.web.dto.communs.ParametrageRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/statuts")
public class StatutControllerImplement implements StatutController {

    private final StatutService statutService;
    @Override
    public ResponseEntity<ParametrageRequestDto> save(ParametrageRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(statutService.save(request));
    }

    @Override
    public ResponseEntity<ParametrageRequestDto> update(Long id, ParametrageRequestDto request) {
        return ResponseEntity.ok(statutService.update(id, request));
    }

    @Override
    public ResponseEntity<Map<String, Object>> getAllStatuts(int page, int pageSize) {
        return ResponseEntity.ok(statutService.getAllStatuts(page, pageSize));
    }

    @Override
    public ResponseEntity<ParametrageRequestDto> getOne(Long id) {
        return ResponseEntity.ok(statutService.getOne(id));
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        statutService.delete(id);
        return ResponseEntity.ok("DELETED");
    }
}
