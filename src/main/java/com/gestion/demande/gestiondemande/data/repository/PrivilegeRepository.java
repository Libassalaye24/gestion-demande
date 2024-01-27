package com.gestion.demande.gestiondemande.data.repository;

import com.gestion.demande.gestiondemande.data.model.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<Privilege,Long> {
}
