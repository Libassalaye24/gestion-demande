package com.gestion.demande.gestiondemande.data.repository;

import com.gestion.demande.gestiondemande.data.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
