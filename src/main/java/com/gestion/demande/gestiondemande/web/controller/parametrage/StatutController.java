package com.gestion.demande.gestiondemande.web.controller.parametrage;

import com.gestion.demande.gestiondemande.web.dto.communs.ParametrageRequestDto;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

public interface StatutController {

    @PostMapping
    ResponseEntity<ParametrageRequestDto> save(@RequestBody ParametrageRequestDto request);

    @PutMapping("/{id}")
    ResponseEntity<ParametrageRequestDto> update(@PathVariable Long id, @RequestBody ParametrageRequestDto request);


    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllStatuts(@RequestParam(value = "page") int page, @RequestParam(value = "pageSize") int pageSize);

    @GetMapping("/{id}")
    ResponseEntity<ParametrageRequestDto> getOne(@PathVariable Long id);

    @DeleteMapping("/{id}")
    ResponseEntity<String> delete(@PathVariable Long id);
}
