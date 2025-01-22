package com.upgrade.erp.apps.auth.modules.controllers;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Controller;

import com.upgrade.erp.apps.auth.modules.controllers.dto.CreateModuleDtoRequest;
import com.upgrade.erp.apps.auth.modules.persistence.entities.ModuleEntity;
import com.upgrade.erp.apps.auth.modules.services.ModuleServiceImpl;

@Controller
public class ModuleController {

    private final ModuleServiceImpl moduleService;

    public ModuleController(ModuleServiceImpl moduleService) {
        this.moduleService = moduleService;
    }

    public ModuleEntity createModule(CreateModuleDtoRequest request) {
        ModuleEntity moduleEntity = new ModuleEntity();
        moduleEntity.setNumber(request.number());
        System.out.println();
        moduleEntity.setName(request.name());
        moduleEntity.setDescription(request.description());
        moduleEntity.setActive(request.isActive());
        System.out.println(request);
        return moduleService.createModule(moduleEntity);
    }

    public void updateModule(UUID uuid_module, CreateModuleDtoRequest request) {
        Optional<ModuleEntity> existingModuleOpt = moduleService.getModuleById(uuid_module);
        if (existingModuleOpt.isPresent()) {
            ModuleEntity moduleEntity = existingModuleOpt.get();
            moduleEntity.setNumber(request.number());
            moduleEntity.setName(request.name());
            moduleEntity.setDescription(request.description());
            moduleEntity.setActive(request.isActive());
            moduleService.updateModule(moduleEntity);
        } else {
            System.out.println("Module not found");
        }
    }

    public Optional<ModuleEntity> getModuleById(UUID id) {
        return moduleService.getModuleById(id);
    }
}
