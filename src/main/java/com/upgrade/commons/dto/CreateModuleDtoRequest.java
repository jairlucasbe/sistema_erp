package com.upgrade.commons.dto;

import com.upgrade.erp.server.entities.ModuleEntity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateModuleDtoRequest(
    @NotNull(message = "El número es el código secuencial del módulo y no puede ser nulo")
    Long number,

    @NotBlank(message = "El nombre del módulo es requerido")
    @NotNull(message = "El nombre del módulo no puede ser nulo")
    String name,

    String description,

    @NotNull(message = "El estado activo del módulo no puede ser nulo")
    Boolean active
) {
    public CreateModuleDtoRequest {
        active = (active == null) ? true : active;
    }

    public ModuleEntity toEntity() {
        ModuleEntity moduleEntity = new ModuleEntity();
        moduleEntity.setNumber(this.number);
        moduleEntity.setName(this.name);
        moduleEntity.setDescription(this.description);
        moduleEntity.setActive(this.active);
        return moduleEntity;
    }
}
