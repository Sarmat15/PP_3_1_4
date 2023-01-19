package ru.kata.spring.boot_security.demo.service;


import org.springframework.security.core.userdetails.UserDetailsService;

import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;


public interface UserService extends UserDetailsService {


    User getUserAndRole(Integer id);

    List<User> getList();

    void deleteUser(Integer id);

    void editUser(User user);

    boolean add(User user);

    User findByEmail(String email);


}
