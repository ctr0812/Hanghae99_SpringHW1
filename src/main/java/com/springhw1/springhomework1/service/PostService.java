package com.springhw1.springhomework1.service;

import com.springhw1.springhomework1.dto.ResponseDto;
import com.springhw1.springhomework1.model.Post;
import com.springhw1.springhomework1.repository.PostRepository;
import com.springhw1.springhomework1.dto.PostRequestDto;
import com.springhw1.springhomework1.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public ResponseDto<?> getAllPost() {
        return ResponseDto.success(postRepository.findAllByOrderByModifiedAtDesc());
    }

    @Transactional
    public ResponseDto<?> createPost(PostRequestDto requestDto) {

        Post post = new Post(requestDto);

        postRepository.save(post);

        return ResponseDto.success(post);
    }

    @Transactional
    public ResponseDto<?> getPost(Long id, UserDetailsImpl userDetails) {
        Optional<Post> optionalPost = postRepository.findById(id);


        if (optionalPost.isEmpty()) {
            return ResponseDto.fail("NULL_POST_ID", "post id isn't exist");
        }

        return ResponseDto.success(optionalPost.get());
    }


    @Transactional
    public ResponseDto<?> updatePost(Long id, PostRequestDto postRequestDto) {
        Optional<Post> optionalPost = postRepository.findById(id);

        if (optionalPost.isEmpty()) {
            return ResponseDto.fail("NOT_FOUND", "post id is not exist");
        }

        Post post = optionalPost.get();
        post.update(postRequestDto);
        postRepository.save(post);

        return ResponseDto.success(post);
    }

    @Transactional
    public ResponseDto<?> deletePost(Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);

        if (optionalPost.isEmpty()) {
            return ResponseDto.fail("NOT_FOUND", "post id is not exist");
        }

        Post post = optionalPost.get();
        postRepository.delete(post);

        return ResponseDto.success(true);

    }

    @Transactional
    public ResponseDto<?> validateAuthorByPassword(Long id, String password) {
        Optional<Post> optionalPost = postRepository.findById(id);

        if (optionalPost.isEmpty()) {
            return ResponseDto.fail("NOT_FOUND", "post id is not exist");
        }

        Post post = optionalPost.get();

        if (post.getPassword().equals(password)) {
            return ResponseDto.fail("PASSWORD_NOT_CORRECT", "password is not correct");
        }

        return ResponseDto.success(true);
    }

}
