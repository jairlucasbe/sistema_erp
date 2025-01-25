package com.upgrade.client.controllers;

import org.springframework.stereotype.Controller;

import com.upgrade.server.ModuleServiceImpl;
import com.upgrade.server.entities.ModuleEntity;
import com.upgrade.shared.dto.CreateModuleDtoRequest;
import com.upgrade.shared.exceptions.ValidationException;

import jakarta.validation.Valid;

@Controller
public class ModuleController {

    private final ModuleServiceImpl moduleService;

    public ModuleController(ModuleServiceImpl moduleService) {
        this.moduleService = moduleService;
    }

    public String createModule(@Valid CreateModuleDtoRequest createModuleDtoRequest) {
        System.out.println(createModuleDtoRequest);
        try {
            ModuleEntity moduleEntity = createModuleDtoRequest.toEntity();
            moduleService.createModule(moduleEntity);
            return "Módulo creado correctamente: " + moduleEntity.getName();
        } catch (ValidationException e) {
            return e.getMessage();
        }
    }
}