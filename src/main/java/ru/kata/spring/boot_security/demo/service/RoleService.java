package ru.kata.spring.boot_security.demo.service;


import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;

public interface RoleService {

    boolean add(Role role);

    List<Role> getList();

    Role getRole(Integer id);

    void deleteRole(Integer id);

    void editRole(Role role);

    List<Role> listByRole(List<String> name);
}
