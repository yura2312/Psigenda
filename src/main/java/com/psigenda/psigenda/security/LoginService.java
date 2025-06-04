package com.psigenda.psigenda.security;

import com.psigenda.psigenda.domain.entity.Login;
import com.psigenda.psigenda.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService {
    private final LoginRepository repository;
    private final PasswordEncoder passwordEncoder;

    public Login save(Login user){
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        return repository.save(user);
    }

}
