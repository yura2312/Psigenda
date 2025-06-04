package com.psigenda.psigenda.security;

import com.psigenda.psigenda.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements UserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    var user = repository.findUserByUsername(username);
    return user
            .map(UserDetailsImp::new)
            .orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }
}
