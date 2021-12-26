package com.mts.security.filters;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mts.security.administration.User;
import com.mts.security.administration.UserRepo;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

@RequiredArgsConstructor
@Slf4j
public class JwtAuthorizationFilter extends OncePerRequestFilter{

	private final UserRepo userRepository;

	@Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        
		if(request.getServletPath().equals("/login")) {
			chain.doFilter(request, response);
			return;
		}
		
		// Read the Authorization header, where the JWT token should be
		String header = request.getHeader(JwtProperties.HEADER_STRING);
		
		// If header does not contain BEARER or is null delegate to Spring impl and exit
		if (header == null || !header.startsWith(JwtProperties.TOKEN_PREFIX)) {
			chain.doFilter(request, response);
			return;
		}
		
		// If header is present, try grab user principal perform authorization
		try {
			Authentication authentication = getUsernamePasswordAuthentication(request);
			SecurityContextHolder.getContext().setAuthentication(authentication);						
			chain.doFilter(request, response);
		} catch(Exception ex) {
			log.error("Error logging in: {}", ex.getMessage());
			response.setHeader("error", ex.getMessage());
			response.setStatus(HttpStatus.FORBIDDEN.value());
			Map<String, String> error = new HashMap<>();
			error.put("error_message", ex.getMessage());
			response.setContentType("application/json");
			new ObjectMapper().writeValue(response.getOutputStream(), error);
		}
		
    }

    private Authentication getUsernamePasswordAuthentication(HttpServletRequest request) {
        String token = request.getHeader(JwtProperties.HEADER_STRING).replace(JwtProperties.TOKEN_PREFIX, "");

        if (token != null) {
            // parse the token and validate it	
        	JWTVerifier verifier = JWT.require(HMAC512(JwtProperties.SECRET.getBytes())).build();        	
        	DecodedJWT decodedJWT = verifier.verify(token);       	
            String userName = decodedJWT.getSubject();

            // Search in the DB if we find the user by token subject (username)
            // If so, then grab user details and create spring auth token using username, pass, authorities/roles
            User user = userRepository.findByUsername(userName);
            if (user.getUSER_NAME() != null) {       
                // get user roles and permissions 
        		// then load them in the object user               
        		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        		List<String> roles = decodedJWT.getClaim("roles").asList(String.class);
        		roles.forEach(role -> {
        			authorities.add(new SimpleGrantedAuthority(role));
        		});
        		
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userName, null, authorities);
                return auth;
            }
            return null;
        }
        return null;
    }
	
}