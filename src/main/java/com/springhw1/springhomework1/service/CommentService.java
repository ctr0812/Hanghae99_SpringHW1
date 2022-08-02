package com.springhw1.springhomework1.service;

import com.springhw1.springhomework1.dto.CommentRequestDto;
import com.springhw1.springhomework1.dto.PostRequestDto;
import com.springhw1.springhomework1.dto.ResponseDto;
import com.springhw1.springhomework1.model.Comment;
import com.springhw1.springhomework1.model.Post;
import com.springhw1.springhomework1.model.User;
import com.springhw1.springhomework1.repository.CommentRepository;
import com.springhw1.springhomework1.repository.PostRepository;
import com.springhw1.springhomework1.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;


    @Transactional
    public ResponseDto<?> getAllComment(Long id) {

        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isEmpty()) {
            return ResponseDto.fail("NOT_FOUND", "post id is not exist");
        }
        List<Comment> commentList = optionalPost.get().getCommentList();

        return ResponseDto.success(commentList);
    }



    @Transactional
    public ResponseDto<?> createComment(CommentRequestDto requestDto, User user) {

        Optional<Post> optionalPost =  postRepository.findById(requestDto.getPostId());
        if (optionalPost.isEmpty()) {
            return ResponseDto.fail("NOT_FOUND", "post id is not exist");
        }

        String author = user.getUsername();
        Comment comment = new Comment(requestDto, author);
        comment = commentRepository.save(comment);


        Post post = optionalPost.get();
        post.getCommentList().add(comment);
        postRepository.save(post);

        return ResponseDto.success(comment);
    }


    @Transactional
    public ResponseDto<?> updateComment(Long id, CommentRequestDto requestDto) {
        Optional<Post> optionalPost = postRepository.findById(requestDto.getPostId());

        if (optionalPost.isEmpty()) {
            return ResponseDto.fail("NOT_FOUND", "post id is not exist");
        }

        List<Comment> commentList = optionalPost.get().getCommentList();
        Comment changedComment = null;
        
        for (Comment comment : commentList) {
            if (comment.getId().equals(id)) {

                Optional<Comment> updateComment = commentRepository.findById(id);
                changedComment = updateComment.get();
                changedComment.update(requestDto);
                commentRepository.save(changedComment);
            }
        }
        if (changedComment == null) {
            return ResponseDto.fail("NOT_FOUND", "comment id is not exist");
        } else {

            return ResponseDto.success(changedComment);
        }
    }
    

    @Transactional
    public ResponseDto<?> deleteComment(Long id) {
        Optional<Comment> optionalComment = commentRepository.findById(id);

        if (optionalComment.isEmpty()) {
            return ResponseDto.fail("NOT_FOUND", "comment id is not exist");
        }

        Comment comment = optionalComment.get();
        commentRepository.delete(comment);

        return ResponseDto.success(true);

    }

}
