package com.psigenda.psigenda.mapper;


import com.psigenda.psigenda.domain.dto.request.RegisterRequest;
import com.psigenda.psigenda.domain.dto.response.RegisterResponse;
import com.psigenda.psigenda.domain.entity.User;

public class UserMapper {

    public static User toUser(RegisterRequest request) {
        return User
                .builder()
                .username(request.username())
                .password(request.password())
                .role(request.role()) //TODO: set USER as default, implement business logic to determine that only admin can add other admin
                .build();
    }

    public static RegisterResponse toRegisterResponse(User user) {
        return RegisterResponse
                .builder()
                .username(user.getUsername())
                .role((user.getRole()))
                .build();
    }
}
