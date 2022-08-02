package com.springhw1.springhomework1.controller;

import com.springhw1.springhomework1.dto.CommentRequestDto;
import com.springhw1.springhomework1.dto.ResponseDto;
import com.springhw1.springhomework1.model.User;
import com.springhw1.springhomework1.security.UserDetailsImpl;
import com.springhw1.springhomework1.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CommentController {

    public final CommentService commentService;

    // 댓글 목록 조회 api
    @GetMapping("/api/comment/{id}")
    public ResponseDto<?> getAllComment(@PathVariable Long id){
        return commentService.getAllComment(id);
    }

    // 댓글 작성 api
    @PostMapping("/api/auth/comment")
    public ResponseDto<?> createComment(@RequestBody CommentRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails ) {
        User user =  userDetails.getUser();
        return commentService.createComment(requestDto,user);
    }


    // 댓글 수정 api
    @PutMapping("/api/auth/comment/{id}")
    public ResponseDto<?> updatePost(@PathVariable Long id , @RequestBody CommentRequestDto requestDto , @AuthenticationPrincipal UserDetailsImpl userDetails ) {
        return commentService.updateComment(id, requestDto);
    }

    // 댓글 삭제 api
    @DeleteMapping("/api/auth/comment/{id}")
    public ResponseDto<?> deleteComment(@PathVariable Long id) {
        return commentService.deleteComment(id);
    }

}
