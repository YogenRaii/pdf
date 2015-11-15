package com.bitMiners.pdf.service;

import java.util.List;

import com.bitMiners.pdf.domain.User;

public interface UserService {

	Integer addUser(User user);

	List<User> getAllUsers();
}
