package br.com.dicasdeumdev.apitestes.config;

import br.com.dicasdeumdev.apitestes.domain.User;
import br.com.dicasdeumdev.apitestes.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public void startDB(){
        User u1 = new User(null, "Zoro", "sanji@gmail.com", "sanduriu");
        User u2 = new User(null, "Sanji", "zoro@gmail.com", "namichan");

        userRepository.saveAll(List.of(u1, u2));
    }
}
