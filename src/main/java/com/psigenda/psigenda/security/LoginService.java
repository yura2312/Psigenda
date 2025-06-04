package com.psigenda.psigenda.security;

import com.psigenda.psigenda.domain.entity.User;
import com.psigenda.psigenda.exception.UserRegisteredException;
import com.psigenda.psigenda.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public User save(User user){

        if (repository.findUserByUsername(user.getUsername()).isPresent()){
            throw new UserRegisteredException();
        }

        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        return repository.save(user);
    }

}
