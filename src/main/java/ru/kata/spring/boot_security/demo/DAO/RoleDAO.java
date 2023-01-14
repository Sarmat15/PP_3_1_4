package ru.kata.spring.boot_security.demo.DAO;

import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;

public interface RoleDAO {

    boolean add(Role user);


    Role convert(String id);

    Role getRole(Integer id);


    List<Role> getList();

    void deleteRole(Integer id);

    void editRole(Role role);

    List<Role> listByName(List<String> name);

    Role findByName(String name);
}
