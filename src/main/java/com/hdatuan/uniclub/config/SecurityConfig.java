package com.hdatuan.uniclub.config;

import com.hdatuan.uniclub.filter.AuthenticationFilter;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncode() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain sercurityFilterChain(HttpSecurity http, AuthenticationFilter authenticationFilter) throws Exception {


        return http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests( request -> {
                    request.requestMatchers("/auth/*").permitAll();
                    request.requestMatchers(HttpMethod.POST, "/product").hasRole("ADMIN");
                    request.anyRequest().authenticated();
                })
                .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
