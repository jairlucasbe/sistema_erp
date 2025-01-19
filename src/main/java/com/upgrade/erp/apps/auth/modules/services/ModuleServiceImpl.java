package com.upgrade.erp.apps.auth.modules.services;

import org.springframework.stereotype.Service;

import com.upgrade.erp.apps.auth.modules.persistence.entities.ModuleEntity;
import com.upgrade.erp.apps.auth.modules.persistence.repositories.ModuleRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ModuleServiceImpl {

    private final ModuleRepository moduleRepository;

    public ModuleServiceImpl(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    public ModuleEntity createModule(ModuleEntity moduleEntity) {
        return moduleRepository.save(moduleEntity);
    }

    public Optional<ModuleEntity> getModuleById(UUID id) {
        return moduleRepository.findById(id);
    }

    public List<ModuleEntity> getAllModules() {
        return moduleRepository.findAll();
    }
}
