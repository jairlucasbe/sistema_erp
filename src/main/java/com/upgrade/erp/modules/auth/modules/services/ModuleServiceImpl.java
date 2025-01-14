package com.upgrade.erp.modules.auth.modules.services;

import org.springframework.stereotype.Service;
import com.upgrade.erp.modules.auth.modules.persistence.entities.ModuleEntity;
import com.upgrade.erp.modules.auth.modules.persistence.repositories.ModuleRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ModuleServiceImpl {

    private final ModuleRepository moduleRepository;

    public ModuleServiceImpl(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    // Crear un nuevo módulo
    public ModuleEntity createModule(ModuleEntity moduleEntity) {
        return moduleRepository.save(moduleEntity);
    }

    // Obtener un módulo por su ID
    public Optional<ModuleEntity> getModuleById(UUID id) {  // Cambiado de Long a UUID
        return moduleRepository.findById(id);
    }

    /**
     * Obtener todos los modulos
     * @return
     */
    public List<ModuleEntity> getAllModules() {
        return moduleRepository.findAll();
    }
}
