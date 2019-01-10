package com.bitMiners.pdf.repositories;

import java.util.List;

import com.bitMiners.pdf.domain.User;

public interface UserRepository extends CrudRepository<User,Integer>{
	User getUserByUsername(String username);
	List<User> getAllAdmins();
	User findUserByUsername(String username);
}
