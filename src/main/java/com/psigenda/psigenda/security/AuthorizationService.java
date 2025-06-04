package com.psigenda.psigenda.security;

import com.psigenda.psigenda.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorizationService implements UserDetailsService {

    private final LoginRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findLoginByUsername(username).orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }
}
