package com.alura.infra.security;

import com.alura.domain.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.Secret}")
    private String apiSecret;
    public String generarToken(Usuario usuario){
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("Alura")
                    .withSubject(usuario.getNombre())
                    .withClaim("id",usuario.getId())
                    .withExpiresAt(generarFechaExpiracion())
                    .sign(algorithm);

        } catch (JWTVerificationException exception){
            throw  new RuntimeException();
        }
    }

    public String  getSubject(String token){
        DecodedJWT verifier = null;
        if(token == null){
            throw new RuntimeException();
        } else {
            try {
                Algorithm algorithm = Algorithm.HMAC256(apiSecret); // validando firma
                verifier = JWT.require(algorithm)
                        .withIssuer("Alura")
                        .build()
                        .verify(token);
                verifier.getSubject();
            }catch (JWTVerificationException exception){
                exception.printStackTrace();
            }
        }
        if(verifier == null || verifier.getSubject() == null){
            throw new RuntimeException("verifier invalido");
        }else {
            return verifier.getSubject();
        }
    }

    private Instant generarFechaExpiracion(){
        return LocalDateTime.now().plusHours(3).toInstant(ZoneOffset.of("-05:00"));
    }

}
