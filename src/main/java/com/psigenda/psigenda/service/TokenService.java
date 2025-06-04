package com.psigenda.psigenda.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.psigenda.psigenda.domain.entity.User;
import org.springframework.beans.factory.annotation.Value;

import java.time.Instant;
import java.util.Optional;

public class TokenService {

    @Value("${SECRET}")
    private String secret;

    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT
                    .create()
                    .withSubject(user.getUsername())
                    .withClaim("Id", user.getId())
                    .withIssuer("API Psigenda")
                    .withExpiresAt(genereteExpire())
                    .sign(algorithm);
        } catch (JWTCreationException ex) {
            throw new JWTCreationException("Erro ao gerar token", ex);
        }
    }

    public String validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.require(algorithm)
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException ex) {
            throw new JWTVerificationException("Erro ao validar token", ex);
        }
    }


    Instant genereteExpire() {
        return Instant.now().plusSeconds(7200);
    }
}
