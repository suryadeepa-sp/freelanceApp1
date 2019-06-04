package com.freelance.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.freelance.model.User;
@Repository
public interface UserDAO extends CrudRepository<User, String> {
 User findByUsername(String username);

}
