//package web.util;
//
//import antlr.BaseAST;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//import web.model.Role;
//import web.model.User;
//import web.service.UserService;
//
//import javax.annotation.PostConstruct;
//import java.util.Collections;
//import java.util.Set;
//
//@Component
//public class DataInitializer {
//
//    private UserService userService;
//    private PasswordEncoder passwordEncoder;
//
//    public DataInitializer(UserService userService, PasswordEncoder passwordEncoder) {
//        System.out.println("DataInitializer - Constructor=<" + userService.toString() + ">");
//        this.userService = userService;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @PostConstruct
//    public void Init() {
//        System.out.println("DataInitializer - Init: ");
//        System.out.println("DataInitializer - Init: password=<" + passwordEncoder.encode("1234") + ">");
//
////        User user = new User("admin",55,"admin",passwordEncoder.encode("1234"), Collections.singleton(Role.ROLE_ADMIN));
//        User user = new User("admin", 55, "admin", passwordEncoder.encode("1234"), Collections.singleton(Role.ROLE_ADMIN));
//        userService.add(user);
//    }
//}