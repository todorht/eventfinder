package com.eventsfinder.user.domain.repository;

import com.eventsfinder.user.domain.model.ApplicationRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<ApplicationRole, Long> {
    ApplicationRole findByName(String name);
}
