package com.springhw1.springhomework1.dto;

import lombok.Getter;

@Getter
public class PostRequestDto {
    private String title;
    private String author;
    private Long password;
    private String content;
}
