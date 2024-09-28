package com.drm.arithmeticcalculator.auth.token;

import com.drm.arithmeticcalculator.auth.entity.UserPO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Component
@Slf4j
public class JwtService {

    @Getter
    private final Long jwtExpiration;

    private final SecretKey SECRET_KEY;

    public JwtService(@Value("${jwt.access-token-expiration}") Long jwtExpiration, @Value("${jwt.key}") String key) {
        this.jwtExpiration = jwtExpiration;
        SECRET_KEY= Keys.hmacShaKeyFor(key.getBytes());
    }

    public String generateToken(UserPO user, Map<String, Object> extraClaims) {
        Date expirationDate = new Date(System.currentTimeMillis() + this.jwtExpiration);
        return Jwts
                .builder()
                .claims(extraClaims)
                .subject(user.getUsername())
                .issuedAt(new Date())
                .expiration(expirationDate)
                .header()
                    .add("typ", "JWT" )
                    .and()
                .signWith(SECRET_KEY)
                .compact();
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
         return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parser()
                .verifyWith(SECRET_KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

//    public Boolean isTokenValid(String token, UserDetails userDetails) {
//        final String username = extractUsername(token);
//        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
//    }
//
//    private boolean isTokenExpired(String token) {
//        return extractExpiration(token).before(new Date());
//    }
//
//    private Date extractExpiration(String token) {
//        return extractClaim(token, Claims::getExpiration);
//    }
//
//    public String generateToken(UserDetails userDetails) {
//        return generateToken(new HashMap<>(), userDetails);
//    }
//
//    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
//        return buildToken(extraClaims, userDetails, jwtExpiration);
//    }
//
//    private String buildToken(Map<String, Object> extraClaims, UserDetails userDetails, Long expiration) {
//        return Jwts
//                .builder()
//                .subject(userDetails.getUsername())
//                .claims(extraClaims)
//                .issuedAt(new Date())
//                .expiration(new Date(System.currentTimeMillis() + expiration))
//                .signWith(SECRET_KEY)
//                .compact();
//    }
//

}
