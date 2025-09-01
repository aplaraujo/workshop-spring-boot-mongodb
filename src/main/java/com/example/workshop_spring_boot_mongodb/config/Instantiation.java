package com.example.workshop_spring_boot_mongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.workshop_spring_boot_mongodb.domain.User;
import com.example.workshop_spring_boot_mongodb.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        User augusto = new User(null, "Augusto Daniel Alves", "augustodanielalves@anbima.com.br");
        User elza = new User(null, "Elza Stefany Mirella Corte Real", "elza.stefany.cortereal@petrobrais.com.br");
        User joaquim = new User(null, "Joaquim Ryan Cauã Melo", "joaquim_melo@urbam.com.br");

        userRepository.saveAll(Arrays.asList(augusto, elza, joaquim));
    }

}
