package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.model.User;
// «Пользователь» – это просто Object. В большинстве случаев он может быть
//  приведен к классу UserDetails.
// Для создания UserDetails используется интерфейс UserDetailsService, с единственным методом:
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserService userService;

    @Autowired
    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.getUser(s);
        if (user == null) {
            throw new UsernameNotFoundException("Unknown user: " + s);
        }
        return user;
    }
}