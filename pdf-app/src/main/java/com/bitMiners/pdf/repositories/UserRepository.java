package com.bitMiners.pdf.repositories;

import com.bitMiners.pdf.domain.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    User getUserByUsername(String username);

    List<User> getAllAdmins();
}
