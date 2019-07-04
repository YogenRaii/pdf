package com.bitMiners.pdf.services.impl;

import com.bitMiners.pdf.domain.Profile;
import com.bitMiners.pdf.domain.User;
import com.bitMiners.pdf.exceptions.PdfApiException;
import com.bitMiners.pdf.repositories.UserRepository;
import com.bitMiners.pdf.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
        User user = userRepository.findOne(id);
        if (Objects.isNull(user)) {
            throw new PdfApiException("User not found with id " + id, 404);
        }
        return user;
    }

    public List<User> getAllAdmins() {
        return userRepository.getAllAdmins();
    }

    @Override
    public Profile getProfileByUserId(int userId) {
        User user = getUserById(userId);
        if (Objects.isNull(user.getProfile())) {
            throw new PdfApiException("Profile not found for user with id " + userId, 404);
        }
        return user.getProfile();
    }
}
