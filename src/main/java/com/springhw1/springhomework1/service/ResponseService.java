package com.springhw1.springhomework1.service;

import com.springhw1.springhomework1.response.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ResponseService {

    private final PostResponse postResponse;
    private final PostOneResponse postOneResponse;
    private final DeleteResponse deleteResponse;
    private final PasswordResponse passwordResponse;

    public<T> PostResponse<T> getPostResponse(List<T> data){
        PostResponse postResponse = new PostResponse();
        postResponse.setData(data);
        setSuccessResponse(postResponse);
        return postResponse;
    }
    public<T> PostOneResponse getPostOneResponse(T data){
        postOneResponse.setData(data);
        setSuccessResponse(postOneResponse);
        return postOneResponse;
    }

    public DeleteResponse getTrueResponse(Boolean bool){
        deleteResponse.setData(bool);
        setSuccessResponse(deleteResponse);
        return deleteResponse;
    }

    public PasswordResponse getPasswordResponse(Boolean bool){
        passwordResponse.setData(bool);
        setSuccessResponse(passwordResponse);
        return passwordResponse;
    }


    public void setSuccessResponse(CommonResponse response){
        response.setSuccess(true);
        response.setError(null);
    }


}

