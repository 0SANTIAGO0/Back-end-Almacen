package pe.cibertec.proy_sistema_almacen.service;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import pe.cibertec.proy_sistema_almacen.entity.Usuarios;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    // Debe ser de al menos 32 caracteres para HS256
    private static final String SECRET = "supersecreto12345678901234567890123456789012";

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    public String generateToken(Usuarios usuario) {
        return Jwts.builder()
                .setSubject(usuario.getCorreo())
                .claim("rol", usuario.getRol())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000)) // 1 día
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractCorreo(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean isTokenValid(String token, Usuarios usuario) {
        final String correo = extractCorreo(token);
        return (correo.equals(usuario.getCorreo()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        Date expiration = Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
        return expiration.before(new Date());
    }
}