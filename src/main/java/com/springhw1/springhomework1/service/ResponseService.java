package com.springhw1.springhomework1.service;

import com.springhw1.springhomework1.domain.PostRequestDto;
import com.springhw1.springhomework1.response.*;
import org.springframework.stereotype.Service;

import javax.xml.ws.Response;
import java.util.List;

@Service
public class ResponseService {

    public<T> PostResponse<T> getPostResponse(List<T> data){
        PostResponse postResponse = new PostResponse();
        postResponse.setData(data);
        setSuccessResponse(postResponse);
        return postResponse;
    }

    public<T> PostOneResponse getPostOneResponse(T data){
        PostOneResponse postOneResponse = new PostOneResponse();
        postOneResponse.setData(data);
        setSuccessResponse(postOneResponse);
        return postOneResponse;
    }

    public DeleteResponse getTrueResponse(Boolean bool){
        DeleteResponse deleteResponse = new DeleteResponse();
        deleteResponse.setData(bool);
        setSuccessResponse(deleteResponse);
        return deleteResponse;
    }

    public PasswordResponse getPasswordResponse(Boolean bool){
        PasswordResponse passwordResponse = new PasswordResponse();
        passwordResponse.setData(bool);
        setSuccessResponse(passwordResponse);
        return passwordResponse;
    }



    public void setSuccessResponse(CommonResponse response){
        response.setSuccess(true);
        response.setError(null);
    }


}

