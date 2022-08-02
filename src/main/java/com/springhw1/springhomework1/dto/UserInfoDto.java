package com.springhw1.springhomework1.dto;

import com.springhw1.springhomework1.model.Timestamped;
import com.springhw1.springhomework1.model.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class UserInfoDto extends Timestamped {
    private Long id;
    private String username;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;


    public UserInfoDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.createdAt = user.getCreatedAt();
        this.modifiedAt = user.getModifiedAt();

    }
}
