package com.bitMiners.pdf.repository;

import java.util.List;

import com.bitMiners.pdf.domain.User;

public interface UserRepository extends CrudRepository<User,Integer>{
	User getUserByUsername(String username);
	public List<User> getAllAdmins();
}
