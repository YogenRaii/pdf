package com.bitMiners.pdf.services.impl;

import com.bitMiners.pdf.domain.User;
import com.bitMiners.pdf.repositories.UserRepository;
import com.bitMiners.pdf.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public boolean isCorrectUsernameAndPassword(String username, String password) {
        final User user = userRepository.getUserByUsername(username);
        if (user == null) {
            return false;
        } else {
            //set authorization
            List<GrantedAuthority> authority = new ArrayList<>();
            GrantedAuthority grantedAuthority = (GrantedAuthority) user::getRole;
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

    public List<User> getAllAdmins() {
        return userRepository.getAllAdmins();
    }

}
