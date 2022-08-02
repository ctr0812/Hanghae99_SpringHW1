package com.springhw1.springhomework1.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SignupException  extends RuntimeException{

    private final ErrorCode errorCode;
}
