package com.psigenda.psigenda.domain.dto.request;

public record RegisterRequest(
        String login,
        String email,
        String password
) {
}
