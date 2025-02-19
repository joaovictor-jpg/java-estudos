package br.com.jota.aula_spring_data_jpa.repository;

import br.com.jota.aula_spring_data_jpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsernameIgnoreCase(String username);
}
