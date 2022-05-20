package com.ahmed.books.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ahmed.books.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}