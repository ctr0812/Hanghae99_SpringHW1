package com.springhw1.springhomework1.domain;

import lombok.Getter;

import javax.persistence.Column;

@Getter
public class PostRequestDto {
    private String title;
    private String author;
    private Long password;
    private String content;
}
