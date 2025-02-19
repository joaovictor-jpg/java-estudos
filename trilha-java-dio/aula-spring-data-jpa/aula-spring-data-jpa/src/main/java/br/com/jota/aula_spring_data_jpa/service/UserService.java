package br.com.jota.aula_spring_data_jpa.service;

import br.com.jota.aula_spring_data_jpa.model.User;
import br.com.jota.aula_spring_data_jpa.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createdUser(User user) {

        var encryptedPassword = passwordEncoder.encode(user.getPassword());

        user.setPassword(encryptedPassword);

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

        if (user.getName() != null) userDb.setName(user.getName());

        if (user.getUsername() != null) userDb.setUsername(user.getUsername());

        if (user.getPassword() != null) userDb.setPassword(passwordEncoder.encode(user.getPassword()));

        repository.save(userDb);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsernameIgnoreCase(username).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado!"));
    }
}
