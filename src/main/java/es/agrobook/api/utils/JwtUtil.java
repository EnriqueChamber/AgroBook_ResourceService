package es.agrobook.api.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private static final Key secret_key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    private static final long EXPIRATION_TIME = 20*60*1000; // 20 mins

    private final JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(secret_key).build();

    public String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(secret_key)
                .compact();
    }

    public Jws<Claims> validateTokenRaw(String token) {
        return jwtParser.parseClaimsJws(token);
        /*try {
            jwtParser.parseClaimsJws(token);
            return "valid";
        } catch (ExpiredJwtException ex) {
            // Token is expired
            return "expired token";
        } catch (JwtException | IllegalArgumentException e) {
            // Token is invalid (failed parsing or verification)
            return "invalid token";
        }*/
    }

    
    public boolean validateToken(String token) {
        try {
            jwtParser.parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    
    public Claims parseToken(String token) {
        return jwtParser.parseClaimsJws(token).getBody();
    }
}
