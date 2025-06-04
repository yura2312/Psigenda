package com.psigenda.psigenda.repository;

import com.psigenda.psigenda.domain.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login, Long> {
    Optional <UserDetails> findLoginByUsername(String username);
}
