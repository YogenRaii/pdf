package com.bitMiners.pdf.services;

import java.util.List;

import com.bitMiners.pdf.domain.User;

public interface UserService {

	Integer addUser(User user);

	List<User> getAllUsers();
	
	User getUserByUsername(String username);
	
	User getUserById(int id);
	List<User> getAllAdmins();
//	boolean isCorrectUsernameAndPassword(String username, String password);
}
