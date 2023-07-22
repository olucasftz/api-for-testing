package br.com.dicasdeumdev.apitestes.resources;

import br.com.dicasdeumdev.apitestes.domain.User;
import br.com.dicasdeumdev.apitestes.domain.UserDTO;
import br.com.dicasdeumdev.apitestes.services.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserControllerTest {

    public static final Integer ID       = 3;
    public static final String  NAME     = "Valdir";
    public static final String  EMAIL    = "valdir@gmail.com";
    public static final String  PASSWORD = "123";

    @InjectMocks
    private UserController userController;
    @Mock
    private UserServiceImpl service;
    @Mock
    private ModelMapper mapper;

    private User user;
    private UserDTO userDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    private void startUser(){
        user = new User(ID, NAME, EMAIL, PASSWORD);
        userDTO = new UserDTO(ID, NAME, EMAIL, PASSWORD);
    }
}