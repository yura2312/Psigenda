package com.psigenda.psigenda.domain.dto.response;

import com.psigenda.psigenda.domain.enums.UserRole;
import lombok.Builder;

@Builder
public record RegisterResponse(
        String username,
        UserRole role
) {
}
