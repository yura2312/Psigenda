package com.psigenda.psigenda.security;

import com.psigenda.psigenda.domain.dto.request.LoginRequest;
import com.psigenda.psigenda.domain.dto.request.RegisterRequest;
import com.psigenda.psigenda.domain.entity.Login;
import com.psigenda.psigenda.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final LoginService loginService;

    @PostMapping("/register")
    //TODO: Register method
    public ResponseEntity register(@RequestBody RegisterRequest register){
        //Login saveLogin = loginService.save(register);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest login) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(login.username(), login.password());
        var authenticate = authenticationManager.authenticate(usernamePassword);
        return ResponseEntity.ok(authenticate);
    }
}
