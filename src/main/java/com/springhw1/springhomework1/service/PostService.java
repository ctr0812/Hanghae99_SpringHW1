package com.springhw1.springhomework1.service;

import com.springhw1.springhomework1.domain.Post;
import com.springhw1.springhomework1.domain.PostRepository;
import com.springhw1.springhomework1.domain.PostRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Post update(Long id, PostRequestDto requestDto){
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다")
        );
        post.update(requestDto);
        return post;
    }
}
