package com.psigenda.psigenda.domain.dto.request;

public record LoginRequest(
        String username,
        String password,
        String role
) {
}
