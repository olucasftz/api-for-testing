package br.com.dicasdeumdev.apitestes.services;

import br.com.dicasdeumdev.apitestes.domain.User;

public interface UserService {
    User findById(Integer id);
}
