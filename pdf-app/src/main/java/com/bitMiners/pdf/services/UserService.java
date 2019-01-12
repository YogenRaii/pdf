package com.bitMiners.pdf.services;

import com.bitMiners.pdf.domain.User;

import java.util.List;

public interface UserService {

    Integer addUser(User user);

    List<User> getAllUsers();

    User getUserByUsername(String username);

    User getUserById(int id);

    List<User> getAllAdmins();
}
