package com.example.workshop_spring_boot_mongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.workshop_spring_boot_mongodb.domain.User;
import com.example.workshop_spring_boot_mongodb.dto.UserDTO;
import com.example.workshop_spring_boot_mongodb.repositories.UserRepository;
import com.example.workshop_spring_boot_mongodb.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

    @Autowired(required=true)
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }

    public User insert(User obj) {
        return userRepository.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    public User fromDTO(UserDTO dto) {
        return new User(dto.getId(), dto.getName(), dto.getEmail());
    }
}
