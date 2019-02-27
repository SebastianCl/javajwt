package com.javajwt.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javajwt.security.model.Todo;


public interface TodoRepository extends JpaRepository<Todo, Long> {
   
}
