package com.upgrade.erp.modules.auth.modules.controllers.dto;

import com.upgrade.erp.modules.auth.modules.persistence.entities.ModuleEntity;

import jakarta.validation.constraints.NotBlank;

public record CreateModuleDtoRequest(
    @NotBlank Long number,
    @NotBlank String name,
    String description,
    @NotBlank boolean isActive
) {

    public ModuleEntity toEntity() {
        ModuleEntity moduleEntity = new ModuleEntity();
        moduleEntity.setNumber(this.number);
        moduleEntity.setName(this.name);
        moduleEntity.setDescription(this.description);
        moduleEntity.setActive(this.isActive);
        return moduleEntity;
    }
}
