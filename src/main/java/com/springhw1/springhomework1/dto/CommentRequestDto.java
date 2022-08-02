package com.springhw1.springhomework1.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentRequestDto {
    private Long postId;
    private String content;
}
