package com.toolRentalAPI.repository;

import org.springframework.data.repository.CrudRepository;

import com.toolRentalAPI.entity.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long>{

}
