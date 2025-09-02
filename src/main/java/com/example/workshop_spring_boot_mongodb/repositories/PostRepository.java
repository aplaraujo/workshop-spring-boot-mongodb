package com.example.workshop_spring_boot_mongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.workshop_spring_boot_mongodb.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{

}
