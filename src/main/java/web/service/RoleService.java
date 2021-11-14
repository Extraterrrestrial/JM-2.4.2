package web.service;

import web.model.Role;
import web.model.User;
import java.util.List;

public interface RoleService {

    List<User> getAllRoles();

    void add(Role role);

    void edit(Role role);

    Role getById(long id);

    Role getByName(String name);
}
