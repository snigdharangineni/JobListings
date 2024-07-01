package com.springboot.joblisting.respository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springboot.joblisting.model.Post;

public interface PostRepository extends MongoRepository<Post, String>{

}
