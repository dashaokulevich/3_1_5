package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.entites.User;
import ru.kata.spring.boot_security.demo.repository.UserRepository;



import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }


    public List<User> listAll() {
        return userRepository.findAll();
    }


    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }


    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public void update(User user) {
        Optional<User> optionalUser = userRepository.findById(user.getId());
        if (optionalUser.isPresent()) {
            User editUser = optionalUser.get();
            editUser.setId(user.getId());
            editUser.setUsername(user.getUsername());
            editUser.setFirstName(user.getFirstName());
            editUser.setLastName(user.getLastName());
            editUser.setEmail(user.getEmail());
            editUser.setAge(user.getAge());
            editUser.setRoles(user.getRoles());
            if (!editUser.getPassword().equals(user.getPassword())) {
                editUser.setPassword(passwordEncoder.encode(user.getPassword()));
            }
            userRepository.save(editUser);
        }
    }



    public User getUserByUsername(String username) {
        return userRepository.getByUsername(username);
    }


    public User getUserByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.getByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User with email address '%s' not found", email));
        }

        return user;
    }
}