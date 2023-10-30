package com.inho.security.domain.dto.response;

import lombok.*;

@Getter
@Setter
public class SignInResultDTO extends SignUpResultDTO {
    private String token;

    @Builder
    public SignInResultDTO(boolean isSuccess, int code, String msg, String token) {
        super(isSuccess, code, msg);
        this.token = token;
    }
}
