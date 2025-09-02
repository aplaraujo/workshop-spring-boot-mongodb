package com.example.workshop_spring_boot_mongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.workshop_spring_boot_mongodb.domain.Post;
import com.example.workshop_spring_boot_mongodb.repositories.PostRepository;
import com.example.workshop_spring_boot_mongodb.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado!"));
    }

    public List<Post> findByTitle(String text) {
        return postRepository.searchTitle(text);
    }
}
