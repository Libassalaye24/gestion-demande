package com.gestion.demande.gestiondemande.data.repository;

import com.gestion.demande.gestiondemande.data.model.Statut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StatutRepository extends JpaRepository<Statut,Long> {

    Page<Statut> findAllByActiveTrue(Pageable pageable);

}
