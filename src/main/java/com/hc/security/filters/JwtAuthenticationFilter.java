package com.hc.security.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.core.AuthenticationException;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hc.security.administration.LoginRequestModel;
import com.hc.security.administration.User;
import com.hc.security.administration.UserRepo;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.Authentication;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

	private final AuthenticationManager authenticationManager;
	private final UserRepo userRepo;
	private final Environment env;
	
	// Trigger when we issue POST request to /login, this method will be called to start authentication
    // We also need to pass in {"username":"", "password":""} in the request body
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        LoginRequestModel credentials = null;
        try {
            credentials = new ObjectMapper().readValue(request.getInputStream(), LoginRequestModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create login token
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                credentials.getUsername(),
                credentials.getPassword(),
                new ArrayList<>());
        
        // Authenticate user
        Authentication auth = authenticationManager.authenticate(authenticationToken);

        return auth;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        // Grab principal
        User user = (User) authResult.getPrincipal();

        // Grab user scopes
        /*List<String> scopes = userRepo.getScopes(user.getUsername(), env.getProperty("app.scopeCode"));		
        
        String scopesConcat = "";
        for(int i = 0; i < scopes.size(); i++) {
        	if(i == scopes.size() - 1)
        		scopesConcat += scopes.get(i);
        	else
        		scopesConcat += scopes.get(i) + ';';		
        }

        
        Map<String, String> scopesPayload = new HashMap<>();
        scopesPayload.put("scopes", scopesConcat);
        */
        // Create JWT Token
        
        System.out.println(user.getUsername());
        String token = JWT.create()
        		.withSubject(user.getUsername())
        	//	.withPayload(scopesPayload)
                .withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME))
                .withIssuer(request.getRequestURL().toString())
                .withClaim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(HMAC512(JwtProperties.SECRET.getBytes()));
       
        Map<String, String> tokenObj = new HashMap<>();
        tokenObj.put(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX + token);
        tokenObj.put("USER_ID",String.valueOf(user.getUSER_ID()));
        tokenObj.put("EXPERT_AGE",String.valueOf(user.getAGE()));
        tokenObj.put("USER_TYPE",String.valueOf(user.getUSER_TYPE()));
        response.setContentType("application/json");
    	new ObjectMapper().writeValue(response.getOutputStream(), tokenObj);
    }
	
}