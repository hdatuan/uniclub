package com.hdatuan.uniclub.service.imp;

import com.hdatuan.uniclub.repository.UserRepository;
import com.hdatuan.uniclub.service.AuthenticationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServicesImp implements AuthenticationServices {
    @Autowired
    private UserRepository userRepository;

    @Override
    public String checkLogin(String email, String password){

        return "";
    }


}
