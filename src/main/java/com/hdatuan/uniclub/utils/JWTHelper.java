package com.hdatuan.uniclub.utils;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
public class JWTHelper {

    @Value("${secret-key.jwt}")
    private String secretKey;


    public String generateToken(String subject){
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
         return Jwts.builder().subject(subject).signWith(key).compact();
    }

    public String validateToken(String token) {
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
        try {
            String data = Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().getSubject();
            return data;
        } catch ( Exception e ) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

    }

}
