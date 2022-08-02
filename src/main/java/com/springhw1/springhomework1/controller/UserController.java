package com.springhw1.springhomework1.controller;

import com.springhw1.springhomework1.dto.LoginRequestDto;
import com.springhw1.springhomework1.dto.ResponseDto;
import com.springhw1.springhomework1.dto.SignupRequestDto;
import com.springhw1.springhomework1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    // 회원가입
    @PostMapping("/api/member/signup")
    public ResponseDto<?> registerUser(@RequestBody SignupRequestDto requestDto) {
        return userService.registerUser(requestDto);

    }

}
