package ru.kata.spring.boot_security.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;


@Component
public class Init {


    private UserService userService;
    private RoleService roleService;


    @Autowired
    public Init(UserService userService, RoleService roleService) {

        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void createTable() {
        if (roleService.getList().isEmpty()) {
            Role admin = new Role(1, "ROLE_ADMIN");
            Role user = new Role(2, "ROLE_USER");
            roleService.add(admin);
            roleService.add(user);

            Set<Role> setRole1 = new HashSet<>();
            setRole1.add(admin);
            Set<Role> setRole2 = new HashSet<>();
            setRole2.add(user);
            Set<Role> setRole3 = new HashSet<>();
            setRole3.add(admin);
            setRole3.add(user);

            User adminUser1 = new User("adminUser", "adminUser", 10, "adminUser@gmail.com",
                    "adminuser", setRole3);

            User user1 = new User("user", "user", 15, "user@gmail.com",
                    "user", setRole2);

            User admin1 = new User("admin", "admin", 20, "admin1@gmail.com",
                    "admin", setRole1);

            userService.add(admin1);
            userService.add(user1);
            userService.add(adminUser1);

            System.out.println(
                    "login: admin      password: admin \n" +
                            "login: user       password: user \n" +
                            "login: adminUser  password: adminUser");
        }
    }
}
