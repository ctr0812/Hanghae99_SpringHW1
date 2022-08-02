package com.springhw1.springhomework1.security;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.springhw1.springhomework1.dto.ResponseDto;
import com.springhw1.springhomework1.dto.UserInfoDto;
import com.springhw1.springhomework1.model.User;
import com.springhw1.springhomework1.security.jwt.JwtTokenUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    public static final String AUTH_HEADER = "Authorization";
    public static final String TOKEN_TYPE = "BEARER";

    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response,
                                        final Authentication authentication) throws IOException {
        final UserDetailsImpl userDetails = ((UserDetailsImpl) authentication.getPrincipal());
        // Token 생성
        final String token = JwtTokenUtils.generateJwtToken(userDetails);
        response.addHeader(AUTH_HEADER, TOKEN_TYPE + " " + token);

        // 로그인 성공시 Response
        response.addHeader("content-type" , "application/json");
        User user = userDetails.getUser();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule()).disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);;
        UserInfoDto userInfoDto = new UserInfoDto(user);
        response.getWriter().write(objectMapper.writeValueAsString(ResponseDto.success(userInfoDto)));
    }
}


