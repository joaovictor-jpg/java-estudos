package br.com.jota.aula_spring_data_jpa.service;

import br.com.jota.aula_spring_data_jpa.model.User;
import br.com.jota.aula_spring_data_jpa.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void createdUser(User user) {
        repository.save(user);
    }

    public List<User> listUsers() {
        return repository.findAll();
    }

    public User userById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    public void updateUser(Integer id, User user) throws Exception {

        var userOptional = repository.findById(id);

        if (!userOptional.isPresent()) {
            throw new Exception("The user does not exist");
        }

        User userDb = userOptional.get();

        if (user.getNome() != null) userDb.setNome(user.getNome());

        if (user.getUsername() != null) userDb.setUsername(user.getUsername());

        if (user.getPassword() != null) userDb.setPassword(user.getPassword());

        repository.save(userDb);

    }
}
