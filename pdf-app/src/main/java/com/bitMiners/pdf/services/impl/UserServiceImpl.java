package com.bitMiners.pdf.services.impl;

import com.bitMiners.pdf.domain.User;
import com.bitMiners.pdf.repositories.UserRepository;
import com.bitMiners.pdf.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public Integer addUser(User user) {
        return userRepository.add(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    public User getUserById(int id) {
        return userRepository.findOne(id);
    }

    public List<User> getAllAdmins() {
        return userRepository.getAllAdmins();
    }

}
