package by.epam.nickgrudnitsky.data;

import by.epam.nickgrudnitsky.entity.Role;

public interface RoleRepository {
    Role findByName(String name);

}
