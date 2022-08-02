package com.springhw1.springhomework1.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum ErrorCode {
    // 400 Bad Request
    BAD_REQUEST("size must be between 4 and 12"),
    DUPLICATED_USERNAME("중복된 사용자 ID 가 존재합니다."),
    PASSWORDS_NOT_MATCHED("비밀번호와 비밀번호 확인이 일치하지 않습니다.");

    private final String errorMessage;

    ErrorCode( String errorMessage) {
        this.errorMessage = errorMessage;
    }
}