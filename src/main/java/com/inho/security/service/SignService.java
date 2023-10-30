package com.inho.security.service;

import com.inho.security.domain.dto.response.SignInResultDTO;
import com.inho.security.domain.dto.response.SignUpResultDTO;

public interface SignService {
    SignUpResultDTO signUp(String id, String password, String name, String role);

    SignInResultDTO signIn(String id, String password) throws RuntimeException;
}
