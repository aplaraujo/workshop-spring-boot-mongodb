package com.example.workshop_spring_boot_mongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.workshop_spring_boot_mongodb.domain.Post;
import com.example.workshop_spring_boot_mongodb.domain.User;
import com.example.workshop_spring_boot_mongodb.dto.AuthorDTO;
import com.example.workshop_spring_boot_mongodb.repositories.PostRepository;
import com.example.workshop_spring_boot_mongodb.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User augusto = new User(null, "Augusto Daniel Alves", "augustodanielalves@anbima.com.br");
        User elza = new User(null, "Elza Stefany Mirella Corte Real", "elza.stefany.cortereal@petrobrais.com.br");
        User joaquim = new User(null, "Joaquim Ryan Cauã Melo", "joaquim_melo@urbam.com.br");

        userRepository.saveAll(Arrays.asList(augusto, elza, joaquim));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(augusto));
        Post post2 = new Post(null, sdf.parse("23/08/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(elza));

        postRepository.saveAll(Arrays.asList(post1, post2));

        augusto.getPosts().addAll(Arrays.asList(post1));
        elza.getPosts().addAll(Arrays.asList(post2));
        userRepository.save(augusto);
        userRepository.save(elza);
    }

}
