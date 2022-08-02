package com.springhw1.springhomework1.controller;

import com.springhw1.springhomework1.dto.ResponseDto;
import com.springhw1.springhomework1.dto.PostRequestDto;
import com.springhw1.springhomework1.security.UserDetailsImpl;
import com.springhw1.springhomework1.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class PostController {

    public final PostService postService;

    // 게시글 전체 조회 api
    @GetMapping("/api/posts")
    public ResponseDto<?> getAllPosts(){
        return postService.getAllPost();
//        return postRepository.findAllByOrderByModifiedAtDesc();
    }

    // 게시글 조회 api
    @GetMapping("/api/posts/{id}")
    public ResponseDto<?> getPost(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return postService.getPost(id, userDetails);
    }

    // 게시글 작성 api
    @PostMapping("/api/posts")
    public ResponseDto<?> createPost(@RequestBody PostRequestDto requestDto) {
        return postService.createPost(requestDto);
    }

    // 게시글 비밀번호 확인 api
    @PostMapping("/api/posts/{id}")
    public ResponseDto<?> validateAuthorByPassword(@PathVariable Long id, @RequestBody String password) {
        return postService.validateAuthorByPassword(id, password);
    }

    // 게시글 수정 api
    @PutMapping("/api/posts/{id}")
    public ResponseDto<?> updatePost(@PathVariable Long id , @RequestBody PostRequestDto postRequestDto ) {
        return postService.updatePost(id, postRequestDto);
    }

    // 게시글 삭제 api
    @DeleteMapping("/api/posts/{id}")
    public ResponseDto<?> deletePost(@PathVariable Long id) {
        return postService.deletePost(id);
    }

}
