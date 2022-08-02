package com.springhw1.springhomework1.model;

import com.springhw1.springhomework1.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Comment extends Timestamped {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String content;


    public Comment(CommentRequestDto requestDto , String author) {
        this.author = author;
        this.content = requestDto.getContent();
    }

    public void update(CommentRequestDto requestDto){
        this.content = requestDto.getContent();
    }
}
