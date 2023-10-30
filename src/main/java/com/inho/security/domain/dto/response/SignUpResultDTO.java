package com.inho.security.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SignUpResultDTO {
    private boolean isSuccess;
    private int code;
    private String msg;
}
