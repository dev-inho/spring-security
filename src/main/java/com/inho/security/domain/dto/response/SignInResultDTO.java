package com.inho.security.domain.dto.response;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignInResultDTO {
    private String token;
    private boolean isSuccess;
    private String msg;
    private int code;
}
