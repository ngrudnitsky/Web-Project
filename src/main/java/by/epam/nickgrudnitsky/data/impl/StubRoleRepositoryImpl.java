package by.epam.nickgrudnitsky.data.impl;

import by.epam.nickgrudnitsky.data.RoleRepository;
import by.epam.nickgrudnitsky.entity.Role;
import by.epam.nickgrudnitsky.entity.Status;

import java.util.Date;

public class StubRoleRepositoryImpl implements RoleRepository {
    private static final Role role;

    static {
        role = new Role();
        role.setName("ROLE_USER");
        role.setCreated(new Date());
        role.setUpdated(new Date());
        role.setStatus(Status.ACTIVE);
    }

    @Override
    public Role findByName(String name) {
        return role;
    }
}
