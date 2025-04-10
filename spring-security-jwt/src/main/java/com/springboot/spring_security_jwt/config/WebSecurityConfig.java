package com.springboot.spring_security_jwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable()) // 
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/register").permitAll() 
                .anyRequest().authenticated() 
            )
            .formLogin();
            .httpBasic(Customizer.withDefaults()); 
        return http.build();
    }


    @Bean
    public UserDetailsService  userDetailsService() {
        UserDetails kaushal 
                = org.springframework.security.core.userdetails.User.withUsername("kaushal")
                .password("{noop}password")
                .roles("USER")
                .build();

        UserDetails karan
                = org.springframework.security.core.userdetails.User.withUsername("karan")
                .password("{noop}password")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(kaushal,karan);

    }
}

