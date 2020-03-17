package by.epam.nickgrudnitsky.service.impl;

import by.epam.nickgrudnitsky.data.RoleRepository;
import by.epam.nickgrudnitsky.data.UserRepository;
import by.epam.nickgrudnitsky.data.impl.StubRoleRepositoryImpl;
import by.epam.nickgrudnitsky.data.impl.StubUserRepositoryImpl;
import by.epam.nickgrudnitsky.entity.Status;
import by.epam.nickgrudnitsky.entity.User;
import by.epam.nickgrudnitsky.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    UserService service;
    UserRepository userRepository;
    RoleRepository roleRepository;

    @BeforeEach
    void setUp() {
        service = new UserServiceImpl(new StubUserRepositoryImpl(), new StubRoleRepositoryImpl());
        userRepository = new StubUserRepositoryImpl();
        roleRepository = new StubRoleRepositoryImpl();
    }

    @Test
    void registerUser() {
        User user = new User();

        user.setEmail("test@email.com");
        user.setFirstName("Nick");
        user.setLastName("Grudnitsky");
        user.setUserName("NickGSTest");
        user.setPassword("1234");

        User registeredUser = service.register(user);
        assertEquals(registeredUser, userRepository.findByUsername("NickGSTest"));
    }

    @Test
    void registerNullUser() {
        User user = null;

        User registeredUser = service.register(user);
        assertEquals(registeredUser, userRepository.findByUsername("NickGSTest"));
    }

    @Test
    void getAll() {
        UserRepository repository = new StubUserRepositoryImpl();
        List<User> allUsers = repository.findAll();
        assertEquals(allUsers, service.getAll());
    }

    @Test
    void findByUsername() {
        User user = service.findByUsername("NickGS");
        assertEquals(user, userRepository.findByUsername("NickGS"));

        user = service.findByUsername("NULL");
        assertEquals(user, userRepository.findByUsername("NULL"));

        user = service.findByUsername(null);
        assertNull(user);
    }

    @Test
    void findById() {
        User user = service.findById(1L);
        assertEquals(user, userRepository.findById(1L));

        user = service.findById(-1L);
        assertEquals(user, userRepository.findById(-1L));

        assertNull(service.findById(null));
    }

    @Test
    void delete() {
        service.delete(1L);
        assertEquals(userRepository.findById(1L).getStatus(), Status.DELETED);

        service.delete(-1L);
        assertThrows(NullPointerException.class, () -> userRepository.findById(-1L).getStatus());
    }



}