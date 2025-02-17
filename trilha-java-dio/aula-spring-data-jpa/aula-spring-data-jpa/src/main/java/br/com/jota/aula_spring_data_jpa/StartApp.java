package br.com.jota.aula_spring_data_jpa;

import br.com.jota.aula_spring_data_jpa.model.User;
import br.com.jota.aula_spring_data_jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StartApp implements CommandLineRunner {
    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();

        user.setNome("João");
        user.setUsername("Jota");
        user.setPassword("123456");

        repository.save(user);

        List<User> users = repository.findAll();

        users.forEach(System.out::println);
    }
}
