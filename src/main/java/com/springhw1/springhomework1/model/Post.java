package com.springhw1.springhomework1.model;

import com.springhw1.springhomework1.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Post extends Timestamped {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private Long password;

    @Column(nullable = false)
    private String content;

    @OneToMany
    @JoinColumn(name = "POST_ID" , nullable = true)
    private List<Comment> commentList;


    public Post(PostRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.author = requestDto.getAuthor();
        this.password = requestDto.getPassword();
        this.content = requestDto.getContent();
    }

    public void update(PostRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.author = requestDto.getAuthor();
        this.password = requestDto.getPassword();
        this.content = requestDto.getContent();
    }
}
