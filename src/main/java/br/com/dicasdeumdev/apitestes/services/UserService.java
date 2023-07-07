package br.com.dicasdeumdev.apitestes.services;

import br.com.dicasdeumdev.apitestes.domain.User;

import java.util.List;

public interface UserService {
    User findById(Integer id);
    List<User> findAll();
}
