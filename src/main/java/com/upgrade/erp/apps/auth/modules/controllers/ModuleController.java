package com.upgrade.erp.apps.auth.modules.controllers;

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

    public void updateModule() {
        System.out.println("Aplicacion funcionando correctamente");
    }
}
