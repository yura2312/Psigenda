package com.psigenda.psigenda.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public enum UserRole {
    ADMIN("admin"),
    USER("user");

    private final String role;

}
