package com.mts.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.mts.security.administration.UserRepo;
import com.mts.security.filters.JwtAuthenticationFilter;
import com.mts.security.filters.JwtAuthorizationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class MainConfig extends WebSecurityConfigurerAdapter{
	
	private final UserDetailsServiceImpl userDetailsServiceImpl;
    private final UserRepo userRepository;
    private final Environment env;
    
	@Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(this.userDetailsServiceImpl);
        return daoAuthenticationProvider;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtAuthenticationFilter(authenticationManager(), this.userRepository, env))
                .addFilterBefore(new JwtAuthorizationFilter(this.userRepository), UsernamePasswordAuthenticationFilter.class)
                // configure access rules
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                //.antMatchers("/schedulejob/getjobs").hasRole("CC Online Support")
                //.antMatchers("/schedulejob/getjobs").hasAuthority("Draft.Pull")
                .anyRequest().authenticated();
    	
    	http.cors();
    }
	
}