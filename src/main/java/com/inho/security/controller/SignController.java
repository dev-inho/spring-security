package com.inho.security.controller;

import com.inho.security.domain.dto.request.SignInRequestDTO;
import com.inho.security.domain.dto.request.SignUpRequestDTO;
import com.inho.security.domain.dto.response.SignInResultDTO;
import com.inho.security.domain.dto.response.SignUpResultDTO;
import com.inho.security.service.SignService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/sign-api")
@RequiredArgsConstructor
public class SignController {
    private final Logger log = LoggerFactory.getLogger(SignController.class);

    private final SignService signService;

    /**
     * 로그인
     * @return SignInResultDTO
     */
    @PostMapping("/sign-in")
    public SignInResultDTO signIn(@Valid SignInRequestDTO signInRequestDTO) {
        return signService.signIn(signInRequestDTO.getId(), signInRequestDTO.getPassword());
    }

    /**
     * 회원가입
     * @return SignUpResultDTO
     */
    @PostMapping("/sign-up")
    public SignUpResultDTO signUp(@Valid SignUpRequestDTO signUpRequestDTO) {
        return signService.signUp(signUpRequestDTO.getId(), signUpRequestDTO.getPassword(), signUpRequestDTO.getName(), signUpRequestDTO.getRole());
    }
}
