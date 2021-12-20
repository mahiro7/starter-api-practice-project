package com.gft.api.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.gft.api.controllers.dto.TokenDTO;
import com.gft.api.controllers.forms.AuthForm;
import com.gft.api.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.Date;

@Service
public class AuthService {
    @Autowired
    private AuthenticationManager authManager;

    @Value("${api.jwt.secret}")
    private String secret;

    @Value("${api.jwt.expiration}")
    private String expiration;

    @Value("${api.jwt.issuer}")
    private String issuer;

    public TokenDTO authenticate(AuthForm authForm) throws AuthenticationException{
        Authentication authenticate = authManager.authenticate(new UsernamePasswordAuthenticationToken(authForm.getEmail(), authForm.getPassword()));
        String token = generateToken(authenticate);

        return new TokenDTO(token);
    }

    private Algorithm createAlgorithm() {
        return Algorithm.HMAC256(secret);
    }

    private String generateToken(Authentication authenticate) {
        User principal = (User)authenticate.getPrincipal();

        Date today = new Date();
        Date expirationDt = new Date(today.getTime() + Long.parseLong(expiration));



        return JWT.create()
                .withIssuer(issuer)
                .withExpiresAt(expirationDt)
                .withSubject(principal.getId().toString())
                .sign(this.createAlgorithm());
    }

    public boolean verifyToken(String token) {
        try {
            if (token == null)
                return false;

            JWT.require(this.createAlgorithm()).withIssuer(issuer).build().verify(token);

            return true;
        } catch (JWTVerificationException exception) {
            return false;
        }
    }

    public Long getUserId(String token) {
        String subject = JWT.require(this.createAlgorithm()).withIssuer(issuer).build().verify(token).getSubject();

        return Long.parseLong(subject);
    }
}
