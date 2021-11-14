package web.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> role;

    public User() {
    }

    public User(String name, int age, String login, String password, Set<Role> role) {
        System.out.println("User - Constructor: name=" + name + " age=" + age + " login=" + login + " password=" + password);
        this.name = name;
        this.age = age;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public Set<Role> getRole() {
        System.out.println("User - getRole=<" + role + ">");
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    public int getId() {
        System.out.println("User - getId=<" + id + ">");
        return id;
    }

    public void setId(int id) {
        System.out.println("User - setId=<" + id + ">");
        this.id = id;
    }

    public String getName() {
        System.out.println("User - getName=<" + name + ">");
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        System.out.println("User - getAge=<" + age + ">");
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLogin() {
        System.out.println("User - getLogin=<" + login + ">");
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println("User - getAuthorities=<" + getRole() + ">");
        return getRole();
    }

    public String getPassword() {
        System.out.println("User - getPassword=<" + password + ">");
        return password;
    }

    @Override
    public String getUsername() {
        System.out.println("User - getUsername=<" + getLogin() + ">");
        return getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        System.out.println("User - isAccountNonExpired -> true");
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        System.out.println("User - isAccountNonLocked -> true");
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        System.out.println("User - isCredentialsNonExpired -> true");
        return true;
    }

    @Override
    public boolean isEnabled() {
        System.out.println("User - isEnabled -> true");
        return true;
    }

    public void setPassword(String password) {
        System.out.println("User - setPassword=<" + password + ">");
        this.password = password;
    }
}