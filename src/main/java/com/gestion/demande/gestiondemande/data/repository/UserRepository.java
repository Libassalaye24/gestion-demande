package com.gestion.demande.gestiondemande.data.repository;

import com.gestion.demande.gestiondemande.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
