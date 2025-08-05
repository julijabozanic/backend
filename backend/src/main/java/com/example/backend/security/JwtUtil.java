// package com.example.backend.security;

// import com.example.backend.config.JwtProperties;
// import com.example.backend.model.User;
// import io.jsonwebtoken.*;
// import org.springframework.stereotype.Component;

// import java.util.Date;

// @Component
// public class JwtUtil {

//     private final JwtProperties props;

//     public JwtUtil(JwtProperties props) {
//         this.props = props;
//     }

//     public String generateToken(User user) {
//         Claims claims = Jwts.claims().setSubject(user.getUsername());
//         claims.put("roles", user.getRoles());
//         Date now = new Date();
//         Date expiry = new Date(now.getTime() + props.getExpirationMs());
//         return Jwts.builder()
//                 .setClaims(claims)
//                 .setIssuedAt(now)
//                 .setExpiration(expiry)
//                 .signWith(SignatureAlgorithm.HS512, props.getSecret())
//                 .compact();
//     }

//     public String extractUsername(String token) {
//         return Jwts.parser()
//                 .setSigningKey(props.getSecret())
//                 .parseClaimsJws(token)
//                 .getBody()
//                 .getSubject();
//     }

//     public boolean validateToken(String token) {
//         try {
//             Jwts.parser().setSigningKey(props.getSecret()).parseClaimsJws(token);
//             return true;
//         } catch (JwtException | IllegalArgumentException e) {
//             return false;
//         }
//     }

//     public String getSecret() {
//         return props.getSecret();
//     }
// }