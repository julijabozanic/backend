// package com.example.backend.security;

// import com.example.backend.repository.UserRepository;
// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpHeaders;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.stereotype.Component;
// import org.springframework.web.filter.OncePerRequestFilter;

// import java.io.IOException;
// import java.util.Collection;
// import java.util.List;
// import java.util.stream.Collectors;

// @Component
// public class JwtAuthFilter extends OncePerRequestFilter {

//     @Autowired
//     private JwtUtil jwtUtil;

//     @Autowired
//     private UserRepository userRepository;

//     @Override
//     protected void doFilterInternal(HttpServletRequest request,
//                                     HttpServletResponse response,
//                                     FilterChain filterChain)
//             throws ServletException, IOException {
//         String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
//         if (authHeader != null && authHeader.startsWith("Bearer ")) {
//             String token = authHeader.substring(7);
//             if (jwtUtil.validateToken(token)) {
//                 String username = jwtUtil.extractUsername(token);
//                 userRepository.findByUsername(username).ifPresent(user -> {
//                     Claims claims = Jwts.parser()
//                             .setSigningKey(jwtUtil.getSecret())
//                             .parseClaimsJws(token)
//                             .getBody();
//                     @SuppressWarnings("unchecked")
//                     List<String> roles = (List<String>) claims.get("roles");
//                     Collection<GrantedAuthority> authorities = roles.stream()
//                             .map(SimpleGrantedAuthority::new)
//                             .collect(Collectors.toList());
//                     Authentication auth = new UsernamePasswordAuthenticationToken(
//                             username, null, authorities);
//                     SecurityContextHolder.getContext().setAuthentication(auth);
//                 });
//             }
//         }
//         filterChain.doFilter(request, response);
//     }
// }