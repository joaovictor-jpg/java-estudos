package br.com.jota.service;

import br.com.jota.domain.model.User;

public interface UserService {
    User findById(Long id);
    User create(User userToCreate);
}
