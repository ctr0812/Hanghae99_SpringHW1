package com.springhw1.springhomework1.response;

import com.springhw1.springhomework1.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordResponse<T> extends CommonResponse {
    Boolean data;
}