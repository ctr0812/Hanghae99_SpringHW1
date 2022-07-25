package com.springhw1.springhomework1.repository;

import com.springhw1.springhomework1.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findAllByOrderByModifiedAtDesc();
}
