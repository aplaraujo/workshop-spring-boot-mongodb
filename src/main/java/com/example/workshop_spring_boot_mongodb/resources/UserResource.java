package com.example.workshop_spring_boot_mongodb.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.workshop_spring_boot_mongodb.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<User>> findAll() {
        User manuela = new User("1", "Manuela Rosa Nina Rocha", "manuela_rosa_rocha@zizafernandes.com");
        User vera = new User("2", "Vera Isabelle Nascimento", "veraisabellenascimento@willianfernandes.com.br");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(manuela, vera));
        return ResponseEntity.ok().body(list);
    }
}
