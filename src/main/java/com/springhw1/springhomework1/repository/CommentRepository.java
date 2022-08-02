package com.springhw1.springhomework1.repository;

import com.springhw1.springhomework1.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {

}
