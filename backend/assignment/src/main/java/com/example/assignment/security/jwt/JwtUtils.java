package com.example.assignment.security.jwt;

import com.example.assignment.data.entities.Account;
import com.example.assignment.utils.Utils;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    public String generateJwtToken(Account account) {
        return Jwts
                .builder()
                .setSubject(account.getUsername())
                .setExpiration(new Date((new Date()).getTime() + Utils.JWT_EXP))
                .signWith(SignatureAlgorithm.HS256, Utils.JWT_SECRET)
                .compact();
    }

    public String getUsernameFromJwtToken(String token) {
        return Jwts
                .parser()
                .setSigningKey(Utils.JWT_SECRET)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public Boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(Utils.JWT_SECRET).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            System.err.println("Invalid JWT signature: " + e.getMessage());
        } catch (MalformedJwtException e) {
            System.err.println("Invalid JWT token: " + e.getMessage());
        } catch (ExpiredJwtException e) {
            System.err.println("JWT token is expired: " + e.getMessage());
        } catch (UnsupportedJwtException e) {
            System.err.println("JWT token is unsupported: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("JWT claims string is empty: " + e.getMessage());
        }

        return false;
    }
}
