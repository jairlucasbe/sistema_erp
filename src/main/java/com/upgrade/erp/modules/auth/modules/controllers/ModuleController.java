package com.upgrade.erp.modules.auth.modules.controllers;

import com.upgrade.erp.modules.auth.modules.controllers.dto.CreateModuleDtoRequest;
import com.upgrade.erp.modules.auth.modules.persistence.entities.ModuleEntity;
import com.upgrade.erp.modules.auth.modules.services.ModuleServiceImpl;

import org.springframework.stereotype.Controller;

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
        return moduleService.createModule(moduleEntity);
    }
}
