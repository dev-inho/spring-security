package com.inho.security.config.handler;

import com.inho.security.config.exception.DuplicateUserIdException;
import com.inho.security.config.exception.LoginFailedException;
import com.inho.security.domain.dto.response.ErrorResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler({BindException.class})
    public ResponseEntity<ErrorResponseDTO> handleBindException(BindException e) {
        String errorMessage = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponseDTO.builder()
                        .msg(errorMessage)
                        .build());
    }

    @ExceptionHandler({DuplicateUserIdException.class, LoginFailedException.class})
    public ResponseEntity<ErrorResponseDTO> handleCustomException(RuntimeException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponseDTO.builder()
                        .msg(e.getMessage())
                        .build());
    }
}
