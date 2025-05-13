// package org.example.inchiriazausor.cofing;

// import org.example.inchiriazausor.Util.JwtUtil;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;
// import org.springframework.web.filter.OncePerRequestFilter;

// @Component
// public class JwtRequestFilter extends OncePerRequestFilter {

//     @Autowired
//     private JwtUtil jwtUtil;
    
//     @Autowired
//     private CustomUserDetailsService userDetailsService;

//     @Override
//     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//             throws ServletException, IOException {
        
//         // Extrage token-ul din headerul Authorization
//         final String authHeader = request.getHeader("Authorization");
//         String username = null;
//         String jwt = null;

//         if (authHeader != null && authHeader.startsWith("Bearer ")) {
//             jwt = authHeader.substring(7);  // Extrage token-ul (fără "Bearer ")
//             username = jwtUtil.extractUsername(jwt);  // Extrage username-ul din JWT
//         }

//         if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//             UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//             // Dacă JWT-ul este valid, setează autentificarea
//             if (jwtUtil.validateToken(jwt, userDetails)) {
//                 UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
//                         new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                 SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//             }
//         }

//         // Continuă cu procesarea cererii
//         chain.doFilter(request, response);
//     }
// }
