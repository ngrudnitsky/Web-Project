package by.epam.nickgrudnitsky.data;

import by.epam.nickgrudnitsky.entity.User;

import java.util.List;

public interface UserRepository {
    User findByUsername(String name);

    User save(User user);

    List<User> findAll();

    User findById(Long id);
}
