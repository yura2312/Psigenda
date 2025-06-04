package com.psigenda.psigenda.security;

import com.psigenda.psigenda.domain.dto.request.LoginRequest;
import com.psigenda.psigenda.domain.dto.request.RegisterRequest;
import com.psigenda.psigenda.domain.dto.response.RegisterResponse;
import com.psigenda.psigenda.domain.entity.User;
import com.psigenda.psigenda.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final LoginService loginService;

    @PostMapping("/register")

    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest register){
        User saveUser = loginService.save(UserMapper.toUser(register));
        RegisterResponse registerResponse = UserMapper.toRegisterResponse(saveUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(registerResponse);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest login) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(login.username(), login.password());
        var authenticate = authenticationManager.authenticate(usernamePassword);
        return ResponseEntity.ok(authenticate);
    }
}
