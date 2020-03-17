package by.epam.nickgrudnitsky.data.impl;

import by.epam.nickgrudnitsky.data.UserRepository;
import by.epam.nickgrudnitsky.entity.Role;
import by.epam.nickgrudnitsky.entity.Status;
import by.epam.nickgrudnitsky.entity.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StubUserRepositoryImpl implements UserRepository {
    private static final List<User> users = new ArrayList<>();

    static {
        User user = new User();
        List<Role> roles = new ArrayList<>();
        Role role = new Role();
        role.setName("ROLE_USER");
        role.setCreated(new Date());
        role.setUpdated(new Date());
        role.setStatus(Status.ACTIVE);
        roles.add(role);

        user.setEmail("test@email.com");
        user.setFirstName("Nick");
        user.setLastName("Grudnitsky");
        user.setUserName("NickGS");
        user.setPassword("1234");
        user.setRoles(roles);
        user.setCreated(new Date());
        user.setUpdated(user.getCreated());
        user.setStatus(Status.ACTIVE);

        users.add(user);
    }

    @Override
    public User findByUsername(String userName) {
        for (User user : users) {
            if (user.getUserName().equals(userName)){
                return user;
            }
        }
        return null;
    }

    @Override
    public User save(User user) {
        if (user==null){
            return null;
        }
        users.add(user);
        return user;
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findById(Long id) {
        for (User user : users) {
            if (user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }
}
