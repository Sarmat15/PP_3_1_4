package ru.kata.spring.boot_security.demo.DAO;


import org.springframework.security.core.userdetails.UserDetails;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserDAO {


    User getUser(Integer id);
    List<User> getList();
    boolean add(User user);
    void deleteUser(Integer id);
    void editUser(User user);
    User findByEmail(String email);
}
