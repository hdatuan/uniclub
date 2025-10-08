package com.hdatuan.uniclub.service.imp;

import com.hdatuan.uniclub.entity.Users;
import com.hdatuan.uniclub.repository.UserRepository;
import com.hdatuan.uniclub.request.SignInRequest;
import com.hdatuan.uniclub.service.AuthenticationServices;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Optional;

@Service
public class AuthenticationServicesImp implements AuthenticationServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${secret-key.jwt}")
    private String secretKey;

    @Override
    public String checkLogin(SignInRequest signInRequest){
        String token = "";
        Optional<Users> optionalUsers = userRepository.findByEmail(signInRequest.getEmail());
        if(optionalUsers.isPresent()){
            Users user = optionalUsers.get();
            if ( passwordEncoder.matches(signInRequest.getPassword(), user.getPassword())){
                // Neu dung thi tra ra token
                SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
                token = Jwts.builder().subject("Hello").signWith(key).compact();
            }
        }

        return token;
    }


}
