package com.example.ExampleAPI.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ExampleAPI.user.model.User;

public interface UserRepositoy extends JpaRepository<User, Long> {
	User findById(long id);
	User findByEmail(String email);
	User findByEmailAndPassword(String email,String password);
	Optional<User> findOptionalById(long id);

}
