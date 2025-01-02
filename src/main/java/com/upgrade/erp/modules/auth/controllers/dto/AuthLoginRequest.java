package com.upgrade.erp.modules.auth.controllers.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthLoginRequest(@NotBlank String username,
                               @NotBlank String password) {
}
