package com.bitMiners.pdf.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitMiners.pdf.domain.User;
import com.bitMiners.pdf.repository.repositoryImpl.UserRepository;
import com.bitMiners.pdf.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	public Integer addUser(User user) {
		return userRepository.add(user);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

}
