package com.egar.security;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

@Component
public class JwtTokenUtil {
    private static final String SECRET = "ahgB654783Hfdf";

    public String generateToken(User user) {
        Date now = new Date();
        long expTime = now.getTime() + 600000;
        return Jwts
                .builder()
                .setClaims(Map.of(
                        "id", user.getId(),
                        "name", user.getName(),
                        "role", user.getRole()))
                .setExpiration(new Date(expTime))
                .setId(String.valueOf(user.getUsername()))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .toString();
    }

    public boolean validateToken(String token) {
        String t = token.substring(7);
        try {
            Jwts
                    .parser()
                    .setSigningKey(SECRET)
                    .parse(t);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public String getUsername(String token) {
        String t = token.substring(7);
        return Jwts
                .parser()
                .parseClaimsJws(token)
                .getBody()
                .getId();
    }
}
