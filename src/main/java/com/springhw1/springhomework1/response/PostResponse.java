package com.springhw1.springhomework1.response;

import com.springhw1.springhomework1.response.CommonResponse;
import com.springhw1.springhomework1.domain.Post;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostResponse<T> extends CommonResponse {
    T data;
}
