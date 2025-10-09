package com.hdatuan.uniclub.filter;


import com.hdatuan.uniclub.utils.JWTHelper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Component
public class AuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JWTHelper jwtHelper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("doFilterInternal");
        String authHeader = request.getHeader("Authorization");
        if ( authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            System.out.println("token: " + token);

            String data = jwtHelper.validateToken(token);
            if ( data != null ) {

                List<GrantedAuthority> authorities = new ArrayList<>();
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(data);
                authorities.add(authority);

                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken("","", authorities);

                SecurityContext context = SecurityContextHolder.getContext();
                context.setAuthentication(authenticationToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}
