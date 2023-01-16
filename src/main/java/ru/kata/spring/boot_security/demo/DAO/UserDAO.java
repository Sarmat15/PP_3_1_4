package ru.kata.spring.boot_security.demo.DAO;


import org.springframework.security.core.userdetails.UserDetails;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserDAO {


    void add(User user);

    List<User> getList();

    User getUser(Integer id);

    void deleteUser(Integer id);

    void editUser(User user);

    UserDetails getUserAndRole(String username);
}
