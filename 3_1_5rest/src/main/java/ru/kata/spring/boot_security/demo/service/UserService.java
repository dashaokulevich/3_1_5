package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.entites.User;

import java.util.List;

public interface UserService {

    void save(User user);


    List<User> listAll();


    User getById(Long id);


    void deleteById(Long id);

    void update(User user);


    User getUserByUsername(String username);


    User getUserByEmail(String email);
}
