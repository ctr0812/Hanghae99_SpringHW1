package com.springhw1.springhomework1.service;

import com.springhw1.springhomework1.dto.LoginRequestDto;
import com.springhw1.springhomework1.dto.ResponseDto;
import com.springhw1.springhomework1.dto.SignupRequestDto;
import com.springhw1.springhomework1.dto.UserInfoDto;
import com.springhw1.springhomework1.exception.ErrorCode;
import com.springhw1.springhomework1.exception.SignupException;
import com.springhw1.springhomework1.model.User;
import com.springhw1.springhomework1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public ResponseDto<?> registerUser(SignupRequestDto requestDto) {

        // 회원 ID 중복 확인
        String username = requestDto.getUsername();
        Optional<User> found = userRepository.findByUsername(username);
        if (found.isPresent()) {
            throw new SignupException(ErrorCode.DUPLICATED_USERNAME);
        }

        if (!requestDto.getPassword().equals(requestDto.getPasswordConfirm())) {
            throw new SignupException(ErrorCode.PASSWORDS_NOT_MATCHED);
        }

        // 패스워드 암호화
        String password = passwordEncoder.encode(requestDto.getPassword());

        User user = new User(username,password);
        userRepository.save(user);
        UserInfoDto userInfoDto = new UserInfoDto(user);
        return ResponseDto.success(userInfoDto);
    }
}
