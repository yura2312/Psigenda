package com.psigenda.psigenda.domain.dto.request;

import com.psigenda.psigenda.domain.enums.UserRole;

public record RegisterRequest(
        String username,
        String password,
        UserRole role
        ) {
}
