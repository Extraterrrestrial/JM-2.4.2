package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.RoleDAO;
import web.model.Role;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private RoleDAO roleDAO;

    @Autowired
    public void setRole(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }


    @Override
    public List<User> getAllRoles() {
        return roleDAO.getAllRoles();
    }

    @Override
    public void add(Role role) {
        roleDAO.add(role);
    }

    @Override
    public void edit(Role role) {
        roleDAO.edit(role);
    }

    @Override
    public Role getById(long id) {
        return roleDAO.getById(id);
    }

    @Override
    public Role getByName(String name) {
        return roleDAO.getByName(name);
    }
}
