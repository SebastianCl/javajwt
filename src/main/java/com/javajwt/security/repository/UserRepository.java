package com.javajwt.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javajwt.security.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
