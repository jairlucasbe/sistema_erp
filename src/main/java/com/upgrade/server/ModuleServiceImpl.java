package com.upgrade.server;

import org.springframework.stereotype.Service;

import com.upgrade.server.entities.ModuleEntity;
import com.upgrade.server.repositories.ModuleRepository;
import com.upgrade.shared.exceptions.ValidationException;

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
        if (moduleRepository.existsByNumber(moduleEntity.getNumber())) {
            throw new ValidationException("El número del módulo ya existe: " + moduleEntity.getNumber());
        }
        if (moduleRepository.existsByName(moduleEntity.getName())) {
            throw new ValidationException("El nombre del módulo ya existe: " + moduleEntity.getName());
        }
        return moduleRepository.save(moduleEntity);
    }

    public Optional<ModuleEntity> getModuleById(UUID id) {
        return moduleRepository.findById(id);
    }

    public List<ModuleEntity> getAllModules() {
        return moduleRepository.findAll();
    }

    public ModuleEntity updateModule(ModuleEntity moduleEntity) {
        return moduleRepository.save(moduleEntity);
    }
}
