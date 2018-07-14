package com.bitMiners.pdf.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitMiners.pdf.domain.User;
import com.bitMiners.pdf.repository.UserRepository;
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
	
	public boolean isCorrectUsernameAndPassword(String username, String password) {
		final User user = userRepository.getUserByUsername(username);
		if (user == null) {
			return false;
		} else {
			//set authorization
			List<GrantedAuthority> authority= new ArrayList<GrantedAuthority>();
			GrantedAuthority grantedAuthority= new GrantedAuthority() {

				public String getAuthority() {
					return user.getRole();
				}
			};
			authority.add(grantedAuthority);
			
			Authentication authentication = new UsernamePasswordAuthenticationToken(user, user.getPassword(), authority);

			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			return user.getPassword().equals(password);
		}
	}

	public User getUserByUsername(String username) {
		return userRepository.getUserByUsername(username);
	}

	public User getUserById(int id) {
		return userRepository.findOne(id);
	}
	public List<User> getAllAdmins(){
		return userRepository.getAllAdmins();
	}

}
