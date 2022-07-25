package com.springhw1.springhomework1.controller;

import com.springhw1.springhomework1.dto.PasswordRequestDto;
import com.springhw1.springhomework1.model.Post;
import com.springhw1.springhomework1.repository.PostRepository;
import com.springhw1.springhomework1.dto.PostRequestDto;
import com.springhw1.springhomework1.response.DeleteResponse;
import com.springhw1.springhomework1.response.PasswordResponse;
import com.springhw1.springhomework1.response.PostOneResponse;
import com.springhw1.springhomework1.response.PostResponse;
import com.springhw1.springhomework1.service.PostService;
import com.springhw1.springhomework1.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class PostController {

    public final PostRepository postRepository;
    public final PostService postService;
    public final ResponseService responseService;

    // 게시글 전체 조회 api
    @GetMapping("/api/posts")
    public PostResponse<Post> readAllPost(){
        return responseService.getPostResponse(postRepository.findAllByOrderByModifiedAtDesc());
//        return postRepository.findAllByOrderByModifiedAtDesc();
    }

    // 게시글 조회 api
    @GetMapping("/api/posts/{id}")
    public PostOneResponse<Post> readOnePost(@PathVariable Long id){
        return responseService.getPostOneResponse(postRepository.findById(id).get());
    }

    // 게시글 작성 api
    @PostMapping("/api/posts")
    public PostOneResponse createPost(@RequestBody PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        return responseService.getPostOneResponse(postRepository.save(post));
    }

    // 게시글 비밀번호 확인 api
    @PostMapping("api/posts/{id}")
    public PasswordResponse passwordCheck(@PathVariable Long id , @RequestBody PasswordRequestDto requestDto){
        if (postRepository.findById(id).get().getPassword().equals(requestDto.getPassword())){
            return responseService.getPasswordResponse(true);
        }else return responseService.getPasswordResponse(false);
    }

    // 게시글 수정 api
    @PutMapping("/api/posts/{id}")
    public PostOneResponse updatePost(@PathVariable Long id , @RequestBody PostRequestDto requestDto ) {
        return responseService.getPostOneResponse(postService.update(id,requestDto));
    }

    // 게시글 삭제 api
    @DeleteMapping("/api/posts/{id}")
    public DeleteResponse deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
        return responseService.getTrueResponse(true);
    }

}
