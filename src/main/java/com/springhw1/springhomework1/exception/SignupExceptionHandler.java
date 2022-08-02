package com.springhw1.springhomework1.exception;

import com.springhw1.springhomework1.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SignupExceptionHandler {

    @ExceptionHandler(value = { SignupException.class ,NullPointerException.class })
    public ResponseEntity<Object> handleSignupException(SignupException ex) {

        return new ResponseEntity(
                ResponseDto.fail(ex.getErrorCode().name(),ex.getErrorCode().getErrorMessage()),
                HttpStatus.BAD_REQUEST
        );
    }
}