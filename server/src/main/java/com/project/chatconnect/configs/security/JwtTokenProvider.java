package com.project.chatconnect.configs.security;

import com.project.chatconnect.domains.enities.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

/**
 * The type Jwt token provider.
 * Author: Huy Dang
 */
@Component
@RequiredArgsConstructor
public class JwtTokenProvider {
    @Value("${jwt.expiration}")
    private int expiration;

    @Value("${jwt.secret-key}")
    private String secretKey;
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

    /**
     * Generate token string.
     *
     * @param user the user
     * @return the string
     */
    public String generateToken(User user) {
        Map<String, Object> claims = Map.of(
                "id", user.getId(),
                "role", user.getRole().getRoleCode().toString()
        );
        return Jwts.builder()
                .claims(claims)
                .subject(user.getUserName())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expiration * 1000L))
                .signWith(SignatureAlgorithm.HS256, getSecretKey())
                .compact();

    }

    /**
     * Get secret key key.
     *
     * @return the secret key
     */
    private Key getSecretKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    /**
     * Extract all claims claims.
     *
     * @param token the token
     * @return the claims
     */
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * Gets expiration date.
     *
     * @param token the token
     * @return the expiration date
     */
    public Timestamp getExpirationDate(String token) {
        return new Timestamp(extractClaim(token, Claims::getExpiration).getTime());
    }

    /**
     * Extract claim t.
     *
     * @param <T>            the type parameter
     * @param token          the token
     * @param claimsResolver the claims resolver
     * @return the t
     */
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    /**
     * Is token expired boolean.
     *
     * @param token the token
     * @return the boolean
     */
    public boolean isTokenExpired(String token) {
        return getExpirationDate(token).before(new Date());
    }

    /**
     * Extract username string.
     *
     * @param token the token
     * @return the string
     */
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * Validate token boolean.
     *
     * @param token       the token
     * @param userDetails the user details
     * @return the boolean
     */
    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        try {
            if (username.equals(userDetails.getUsername()) && !isTokenExpired(token)) {
                return true;
            }
            Jwts.parser().setSigningKey(getSecretKey()).build().parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            logger.error("WT claims string is empty.");
        } catch (SignatureException ex) {
            logger.error("Invalid JWT signature.");
        }
        return false;
    }
}
