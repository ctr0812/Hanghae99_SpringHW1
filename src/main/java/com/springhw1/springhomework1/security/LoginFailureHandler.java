package com.springhw1.springhomework1.security;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.springhw1.springhomework1.dto.ResponseDto;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        // 실패시 response
        response.setContentType("application/json; charset=UTF-8");
            String code = null;

        if(exception.toString().contains("BadCredentialsException")) {
             code = "INVALID_MEMBER";
        } else if(exception.toString().contains("UsernameNotFoundException")) {
            code = "MEMBER_NOT_FOUND";
        }

        ObjectMapper objectMapper = new ObjectMapper();
        response.getWriter().write(objectMapper.writeValueAsString(ResponseDto.fail(code,exception.getMessage())));

    }
}
