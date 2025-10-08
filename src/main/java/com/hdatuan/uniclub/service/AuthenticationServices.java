package com.hdatuan.uniclub.service;

import com.hdatuan.uniclub.request.SignInRequest;

public interface AuthenticationServices {
    String checkLogin(SignInRequest signInRequest);
}
