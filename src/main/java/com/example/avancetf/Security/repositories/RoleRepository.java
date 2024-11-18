package com.example.avancetf.Security.repositories;

import com.example.avancetf.Security.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
