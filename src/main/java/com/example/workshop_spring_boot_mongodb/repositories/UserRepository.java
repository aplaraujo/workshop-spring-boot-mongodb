package com.example.workshop_spring_boot_mongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.workshop_spring_boot_mongodb.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}
