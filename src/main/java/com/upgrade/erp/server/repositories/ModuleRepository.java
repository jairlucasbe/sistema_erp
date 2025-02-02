package com.upgrade.erp.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upgrade.erp.server.entities.ModuleEntity;

import java.util.UUID;

@Repository
public interface ModuleRepository extends JpaRepository<ModuleEntity, UUID> {
    boolean existsByNumber(Long number);
    boolean existsByName(String name);
}
