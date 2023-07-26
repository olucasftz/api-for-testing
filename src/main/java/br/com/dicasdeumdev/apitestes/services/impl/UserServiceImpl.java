package br.com.dicasdeumdev.apitestes.services.impl;

import br.com.dicasdeumdev.apitestes.domain.User;
import br.com.dicasdeumdev.apitestes.domain.UserDTO;
import br.com.dicasdeumdev.apitestes.repositories.UserRepository;
import br.com.dicasdeumdev.apitestes.services.UserService;
import br.com.dicasdeumdev.apitestes.services.exceptions.DataIntegrityViolationException;
import br.com.dicasdeumdev.apitestes.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(UserDTO obj) {
        findByEmail(obj);
        return userRepository.save(mapper.map(obj, User.class));
    }

    @Override
    public User update(UserDTO obj) {
        findByEmail(obj);
        return userRepository.save(mapper.map(obj, User.class));
    }

    @Override
    public void delete(Integer id) {
        findById(id);
        userRepository.deleteById(id);
    }

    private void findByEmail(UserDTO obj) {
        Optional<User> emailOfUser = userRepository.findByEmail(obj.getEmail());
        if (emailOfUser.isPresent() && !emailOfUser.get().getId().equals(obj.getId())) {
            throw new DataIntegrityViolationException("email already registered in the system!");
        }
    }
}
