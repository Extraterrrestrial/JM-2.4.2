package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        System.out.println("UserServiceImpl - setUserDAO");
        this.userDAO = userDAO;
    }
    @Transactional
    public List<User> allUsers() {
        System.out.println("UserServiceImpl - allUsers");
        return userDAO.allUsers();
    }

    @Transactional
    public void add(User user) {
        System.out.println("UserServiceImpl - add");
        userDAO.add(user);
    }

    @Transactional
    public void delete(User user) {
        System.out.println("UserServiceImpl - delete");
        userDAO.delete(user);
    }

    @Transactional
    public void edit(User user) {
        System.out.println("UserServiceImpl - edit");
        userDAO.edit(user);
    }

    @Transactional
    public User getById(int id) {
        System.out.println("UserServiceImpl - getById");
        return userDAO.getById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("UserServiceImpl - loadUserByUsername");
        return userDAO.findByName(s);
    }

    @Override
    public String toString() {
        return "UserServiceImpl{" +
                "userDAO=" + userDAO +
                '}';
    }
}
