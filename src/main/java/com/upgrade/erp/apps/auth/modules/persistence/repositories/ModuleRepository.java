package com.upgrade.erp.apps.auth.modules.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upgrade.erp.apps.auth.modules.persistence.entities.ModuleEntity;

import java.util.UUID;

public interface ModuleRepository extends JpaRepository<ModuleEntity, UUID> {

}
